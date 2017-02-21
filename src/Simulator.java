import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Simulator {
	private ATM atm = new ATM();
	//Bank myBank = new Bank();
	
	public static void main(String[] args) throws IOException {
		if (args[0].equals(null)){ // run with no arguments
			// do prompt version
		}
		else { // run with filename argument
			Path path = Paths.get(args[0]);
			Files.lines(path).forEach(s -> quickPrompt(s));
		}
		
	}
	
	public void prompt(String s){
		String[] sp = s.split("\\s+");
		switch (sp[0]){
			case "CARDREAD":
				atm.cardRead(Integer.parseInt(sp[1]));
				break;
			case "NUM":
				atm.num(Integer.parseInt(sp[1]));
				break;
			case "DIS":
				String text = null;
				for (int i = 1; i < sp.length; i++){
					text.concat(sp[i] + " ");
				}
				text.trim();
				atm.display(text);
				break;
			case "PRINT":
				String ptext = null;
				for (int i = 1; i < sp.length; i++){
					ptext.concat(sp[i] + " ");
				}
				ptext.trim();
				atm.print(ptext);
				break;
			case "BUTTON":
				switch (sp[1]){
					case "W":
						atm.buttonPress(1);
						break;
					case "CB":
						atm.buttonPress(2);
						break;
					case "CANCEL":
						atm.buttonPress(3);
				}
				break;
		}
	}
	
	public static void quickPrompt(String s){
		
	}
}
