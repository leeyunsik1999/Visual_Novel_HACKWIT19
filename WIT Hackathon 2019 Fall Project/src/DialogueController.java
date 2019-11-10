import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class DialogueController extends Menu implements Initializable{

	Timeline runningDialogue;
	ArrayList<String> dialogue = new ArrayList<>();
	int currentDialogue = 0;
	String currentChar;
	String[] responses = new String[3];
	
	@FXML
	private TextArea genericTextBox;
	
	@FXML
	private AnchorPane AnchorBois;
	
	@FXML
	private VBox diaVBox;
	
	@FXML
	private VBox choiceBox;
	
	@FXML
	private ImageView background;
	
	@FXML
	private ImageView characterImage;
	
	@FXML
	private ScrollPane scrollyBoi;
	
	@FXML
	private Label choice1Text;
	
	@FXML
	private Label choice2Text;
	
	@FXML
	private Label choice3Text;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		currentDialogue = 0;
		genericTextBox.setEditable(false);
		genericTextBox.autosize();
		genericTextBox.setStyle("-fx-background-color: transparent;");
		background.setImage(sceneOutline.getBackground());
		characterImage.setImage(sceneOutline.getCharacter());
		currentChar = GameManager.ROUTE;
		try {
			Scanner in = new Scanner(sceneOutline.getDialogue());
			while(in.hasNext()) {
				String s = in.nextLine();
				if(s.contains("Choice:")) {
					choice3Text.setText("");
					if(s.contains("2")) {
						String temp = in.nextLine();
						if(temp.equals("***")) {
							String multiLine = "";
							while(!temp.equals("***")) {
								if(multiLine.equals("")) {
									multiLine += temp;
								}else {
									multiLine += String.format("%n%s", temp);
								}
								temp = in.nextLine();
							}
						}else {
							choice1Text.setText(temp);
						}
						
						temp = in.nextLine();
						if(temp.equals("***")) {
							String multiLine = "";
							while(!temp.equals("***")) {
								if(multiLine.equals("")) {
									multiLine += temp;
								}else {
									multiLine += String.format("%n%s", temp);
								}
								temp = in.nextLine();
							}
						}else {
							choice2Text.setText(temp);
						}
					} else {
						choice1Text.setText(in.nextLine());
						choice2Text.setText(in.nextLine());
						choice3Text.setText(in.nextLine());
					}
					dialogue.add(s);
				}else if(s.contains("Response:")) {
					if(s.contains("2")) {
						responses[0] = in.nextLine();
						responses[1] = in.nextLine();
					}else {
						responses[0] = in.nextLine();
						responses[1] = in.nextLine();
						responses[2] = in.nextLine();
					}
					
				}else {
					dialogue.add(s);
				}
			}
			printDialogue(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printDialogue(Scanner in) {
		runningDialogue = new Timeline();
		Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.ONE, e -> {
        	if(!dialogue.get(currentDialogue).equals("")) {
        		if(dialogue.get(currentDialogue).contains("Choice:")) {
        			choiceBox.setDisable(false);
        			choiceBox.setOpacity(1);
        			choiceBox.toFront();
        			emptyKeyPressed(scrollyBoi);
        			if(dialogue.get(currentDialogue).contains("2")) {
        				setChoicePress2(in);
        			}else {
            			setChoicePress3(in);
        			}
        			
        			
        		}else if(dialogue.get(currentDialogue).startsWith("-") && dialogue.get(currentDialogue).endsWith("-")){
        			String dia = dialogue.get(currentDialogue);
        			if(dia.contains("leaves")) {
        				fadeChar(characterImage ,false);
        			}else if(dia.contains("joins")) {
        				int lastIndex = 1;
        				for(int i = 1; i < dia.length(); i++) {
        					if(dia.charAt(i) == ' ') {
        						lastIndex = i;
        						break;
        					}
        				}
        				sceneOutline.setCharacter(dia.substring(1, lastIndex) + ".png");
        				characterImage.setImage(sceneOutline.getCharacter());
        				fadeChar(characterImage, true);
        			}else {
        				fadeChar(characterImage, false);
        				sceneOutline.setBackground(dia.substring(1, dia.length() - 1));
        				background.setImage(sceneOutline.getBackground());
        			}
        		} else {
        			try {
            			keyPressed(scrollyBoi, in);
                        slowPrint.autoFormat(dialogue.get(currentDialogue), genericTextBox, scrollyBoi, 30, 90);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
        		}
        		
        	}
            
        }));
        timeline.setOnFinished(ActionEvent -> {
        	keyPressedNext(scrollyBoi,in);
        });
		runningDialogue = timeline;
		runningDialogue.play();
	}
	
	public void printDialogueFast(Scanner in) {
		runningDialogue = new Timeline();
		Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.ONE, e -> {
        		for(String s: dialogue) {
        			if(!s.equals("")) {
                		if(s.contains("Choice:")) {
                			choiceBox.setDisable(false);
                			choiceBox.setOpacity(1);
                			choiceBox.toFront();
                			emptyKeyPressed(scrollyBoi);
                			if(s.contains("2")) {
                				setChoicePress2(in);
                			}else {
                    			setChoicePress3(in);
                			}
                			
                			
                		}else {
                			try {
                    			keyPressedNext(scrollyBoi, in);
                                slowPrint.autoFormat(s, genericTextBox, scrollyBoi, 1, 90);
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                		}
        		}
        	
        	}
            
        }));
		runningDialogue = timeline;
		runningDialogue.play();
	}
	
	public void removeChoice() {
		choiceBox.setDisable(false);
		choiceBox.setOpacity(1);
		choiceBox.toBack();
	}
	
	public void setChoicePress3(Scanner in) {
		choice1Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(currentChar){
					case "java":
						GameManager.BIAS[1][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "python":
						GameManager.BIAS[0][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "c":
						GameManager.BIAS[2][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}
				
			}
			
		});
		
		choice2Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(currentChar){
					case "java":
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "python":
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "c":
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}
				
			}
			
		});
		
		choice3Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(currentChar) {
					case "java":
						GameManager.BIAS[1][0]--;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[2], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "python":
						GameManager.BIAS[0][0]--;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[2], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "c":
						GameManager.BIAS[2][0]--;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[2], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}	
			}
		});
	}
	
	public void setChoicePress2(Scanner in) {
		choice1Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(currentChar){
					case "java":
						GameManager.BIAS[1][0] -= 2;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "python":
						GameManager.BIAS[0][0]-= 2;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "c":
						GameManager.BIAS[2][0]-= 2;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[0], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}
				
			}
			
		});
		
		choice2Text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				switch(currentChar){
					case "java":
						GameManager.BIAS[1][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "python":
						GameManager.BIAS[0][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "c":
						GameManager.BIAS[2][0]++;
						removeChoice();
						keyPressed(scrollyBoi, in);
						try {
							slowPrint.autoFormat(responses[1], genericTextBox, scrollyBoi, 30, 90);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}
				
			}
			
		});
	}
	
	public void skip(Scanner in) {
		runningDialogue.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		slowPrint.printer.stop();
		
		if(currentDialogue < dialogue.size()-1) {
			System.out.print("Next Dialogue");
			currentDialogue += 1;
			printDialogue(in);
		}else {
			fadeToNextScene(AnchorBois);
		}
		
	}
	
	public void emptyKeyPressed(Parent p) {
		p.setOnKeyReleased(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  e.consume();
		        }
		    });
	}
	
	public void keyPressed(Parent p, Scanner in) {
		
		p.setOnKeyReleased(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  if(e.getCode() == KeyCode.ESCAPE) {
		    		runningDialogue.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		slowPrint.printer.stop();
		    		
		    		printDialogueFast(in);
		    	  }
		    	  e.consume();
		        }
		    });
	}
	
	public void keyPressedNext(Parent p, Scanner in) {
		
		p.setOnKeyReleased(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  if(e.getCode() == KeyCode.ESCAPE) {
		    		  skip(in);
		    	  }
		    	  e.consume();
		        }
		    });
	}
	
	

}
