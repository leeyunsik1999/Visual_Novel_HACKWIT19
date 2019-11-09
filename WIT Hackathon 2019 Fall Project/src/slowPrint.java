

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.scene.text.Text;

public class slowPrint {
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
	
	public static void autoFormat(String sentence, Text textbox, int delay, int maxSentenceLength) throws InterruptedException{
		textbox.setText("");
		ArrayList<String> words = new ArrayList<String>();
		int wordStartIndex = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				words.add(sentence.substring(wordStartIndex, i));
				wordStartIndex = i+1;
			}else if(i == sentence.length() - 1) {
				if(sentence.substring(wordStartIndex, sentence.length()) != " ") {
					words.add(sentence.substring(wordStartIndex, sentence.length()));
				}
			}
		}
		
		int currentSentenceLength = 0;
		for(int i = 0; i < words.size(); i++) {
			if(i < words.size() - 1)
				if(currentSentenceLength + words.get(i).length() + words.get(i + 1).length() > maxSentenceLength) {
					ln(words.get(i), textbox, delay);
				}else {
					cont(words.get(i), textbox, delay);
				}
			else {
				cont(words.get(i), textbox, delay);
			}
		}
		
		
	}
	
	public static void cont(String sentence, Text textbox, int delay) throws InterruptedException{
		char[] characters = sentence.toCharArray();
		String temp = textbox.getText();
		
		for(int count = 0; count < characters.length; count++) {
			temp += characters[count];
			textbox.setText(String.format("%s", temp));
			TimeUnit.MILLISECONDS.sleep(delay);
		}
	}
	
	public static void ln(String sentence, Text textbox, int delay) throws InterruptedException {
		char[] characters = sentence.toCharArray();
		String temp = textbox.getText();;
		
		for(int count = 0; count < characters.length; count++) {
			if (characters[count] == '%' && characters[count + 1] == 'n') {
				temp += "%n";
				textbox.setText(String.format("%s", temp));
				count++;
			}else {
				temp += characters[count];
				textbox.setText(String.format("%s", temp));
			}
			
			if(count == characters.length - 1) {
				temp += "%n";
				textbox.setText(String.format("%s", temp));
			}else {
				TimeUnit.MILLISECONDS.sleep(delay);
			}
		}
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
