

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadWrite {

	public ArrayList<ATMCard> readCards() {
		ArrayList<ATMCard> cards=new ArrayList<ATMCard>();
		String[] lockedCards=readLokedCards();
		try {
			  FileReader fileReader = new FileReader("resources/cards/Cards.txt");
	            BufferedReader bufferdreader = new BufferedReader(fileReader);
		
		
		  String line;
          while ((line = bufferdreader.readLine()) != null) {
        	  ATMCard card = null;
        	  String[] values = line.split(";");
        	  
				card= new ATMCard(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
				if(lockedCards==null|| !Arrays.asList(lockedCards).contains(values[5])){
				    	cards.add(card);
				}
          }
          
		}catch (Exception e) {
			System.err.println(e);
			
		}
		
		return cards;
		
	}
	
	public void createLockedCardsFileWhenNotExist() {
		 File file = new File("resources/cards/lokedCards.txt");
		 try {
			 file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] readLokedCards() {
		createLockedCardsFileWhenNotExist();
		try {
			  FileReader fileReader = new FileReader("resources/cards/lokedCards.txt");
	            BufferedReader bufferdreader = new BufferedReader(fileReader);
		
		
		  String line;
         if ((line = bufferdreader.readLine()) != null) {
       	return  line.split(";");
       	  


         }
         
		}catch (Exception e) {
			System.err.println(e);
			
		}
		
		return null;
		
	}
public void addLockedCard(String cardnummber) {
	createLockedCardsFileWhenNotExist();
	
	 FileWriter writer;
	try {
		 FileReader fileReader = new FileReader("resources/cards/lokedCards.txt");
         BufferedReader bufferdreader = new BufferedReader(fileReader);
	String bevore=bufferdreader.readLine();
	
	  if(bevore==null) {
		  bevore="";
	  }
		writer = new FileWriter("resources/cards/lokedCards.txt");
		 writer.write(bevore+cardnummber+";");
		 writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
}
