

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class slowPrint {
	
	private static BooleanProperty readyForInput = new SimpleBooleanProperty(false);
	private static int delay = 0;
	public static Timeline printer;
	
	public static void setDelay(int newDelay) {
		delay = newDelay;
	}
	
	public static void ln(String sentence) throws InterruptedException {
		char[] characters = sentence.toCharArray();
		
		for(int count = 0; count < characters.length; count++) {
			if (characters[count] == '%' && characters[count + 1] == 'n') {
				System.out.printf("%n");
				count++;
			}else {
			System.out.print(characters[count]);
			}
			TimeUnit.MILLISECONDS.sleep(30);
			
			if(count == characters.length - 1) {
				System.out.printf("%n");
				TimeUnit.MILLISECONDS.sleep(600);
			}
		}
	}
	
	public static Timeline autoFormat(String sentence, TextArea textbox,ScrollPane scrollyBoi, int d, int maxSentenceLength) throws InterruptedException{
		textbox.setText("");
		
		ArrayList<String> words = new ArrayList<String>();
		int wordStartIndex = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				words.add(sentence.substring(wordStartIndex, i) + " ");
				wordStartIndex = i+1;
			}else if(i == sentence.length() - 1) {
				if(sentence.substring(wordStartIndex, sentence.length()) != " ") {
					words.add(sentence.substring(wordStartIndex, sentence.length()));
				}
			}
		}
		
		ArrayList<Timeline> totalTL = new ArrayList<Timeline>();
		
		int currentSentenceLength = 0;
		for(int i = 0; i < words.size(); i++) {
			if(i < words.size() - 1) {
				if(currentSentenceLength + words.get(i).length() + words.get(i + 1).length() > maxSentenceLength) {
					totalTL.add(ln(words.get(i), textbox, scrollyBoi, d));
					currentSentenceLength = words.get(i).length();
				}else {
					totalTL.add(cont(words.get(i), textbox, d));
					currentSentenceLength += words.get(i).length();
				}
			}else {
				totalTL.add(cont(words.get(i), textbox, d));
				currentSentenceLength += words.get(i).length();
			}
		}
		
		for(int i = totalTL.size()-1; i >= 0; i--) {
			applyFinish(i, totalTL);
		}
		return totalTL.get(0);
	}
	
	private static void applyFinish(int index, ArrayList<Timeline> totalTL) {
		if(index != 0) {
			totalTL.get(index-1).setOnFinished(event ->{
				totalTL.get(index).play();
			});
		}
	}
	
	private static Timeline ln(String word ,TextArea textbox, ScrollPane scrollyBoi, int delay) {
        Timeline timeline = new Timeline();
        Duration delayBetweenMessages = Duration.millis(delay);
        Duration frame = delayBetweenMessages;
        timeline.getKeyFrames().add(new KeyFrame(frame, e -> printer = timeline));
        for(char c: word.toCharArray()) {
        	timeline.getKeyFrames().add(new KeyFrame(frame, e -> {
        		scrollyBoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
      		      @Override
      		      public void handle(KeyEvent e) {
      		    	  if(e.getCode() == KeyCode.ESCAPE) {
      		    		  timeline.setOnFinished(ActionEvent -> {timeline.stop();});
      		    		  timeline.stop();
      		    	  }
      		    	  e.consume();
      		        }
      		    });
        		textbox.appendText(String.format("%c" , c));
        		}));
            frame = frame.add(delayBetweenMessages);
        }
        timeline.getKeyFrames().add(new KeyFrame(frame, e -> {
    		scrollyBoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
  		      @Override
  		      public void handle(KeyEvent e) {
  		    	  if(e.getCode() == KeyCode.ESCAPE) {
  		    		  timeline.setOnFinished(ActionEvent -> {timeline.stop();});
  		    		  timeline.stop();
  		    	  }
  		    	  e.consume();
  		        }
  		    });
    		textbox.appendText(String.format("%n"));
    		}));
        frame = frame.add(delayBetweenMessages);
        scrollyBoi.setVvalue(0);
        
        timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
            readyForInput.set(newStatus != Animation.Status.RUNNING);
            if (newStatus != Animation.Status.RUNNING) {
                textbox.requestFocus();
            }
        });
        return timeline ;
    }
	
	private static Timeline cont(String word ,TextArea textbox, int delay) {
        Timeline timeline = new Timeline();
        Duration delayBetweenMessages = Duration.millis(delay);
        Duration frame = delayBetweenMessages;
        timeline.getKeyFrames().add(new KeyFrame(frame, e -> printer = timeline));
        for(char c: word.toCharArray()) {
        	timeline.getKeyFrames().add(new KeyFrame(frame, e -> {
        		textbox.setOnKeyPressed(new EventHandler<KeyEvent>() {
      		      @Override
      		      public void handle(KeyEvent e) {
      		    	  if(e.getCode() == KeyCode.ESCAPE) {
      		    		  timeline.setOnFinished(ActionEvent -> {timeline.stop();});
      		    		  timeline.stop();
      		    	  }
      		    	  e.consume();
      		        }
      		    });
        		textbox.appendText(String.format("%c" , c));
        		}));
            frame = frame.add(delayBetweenMessages);
        }
        
        timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
            readyForInput.set(newStatus != Animation.Status.RUNNING);
            if (newStatus != Animation.Status.RUNNING) {
                textbox.requestFocus();
            }
        });
        return timeline ;
    }
	
	public static void cont(String sentence) throws InterruptedException {
		char[] characters = sentence.toCharArray();
		
		for(int count = 0; count < characters.length; count++) {
			System.out.print(characters[count]);
			TimeUnit.MILLISECONDS.sleep(30);
			
			if(count == characters.length - 1) {
				TimeUnit.MILLISECONDS.sleep(600);
			}
		}
	}

}
