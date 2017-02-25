import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class Simulator {
	private ATM atm = new ATM();
	//Bank myBank = new Bank();
	
	public static void main(String[] args){
		Simulator s = new Simulator();
		if (args == null || args.length == 0){ // run with no arguments
			// do prompt version
			Scanner reader = new Scanner(System.in);
			String input = null;
			do {
				input = reader.nextLine();
			} while (s.prompt(input));
			reader.close();
		}
		else { // run with filename argument
			try {
				Path path = Paths.get(args[0]);
				Files.lines(path).forEach(l -> s.prompt(l));
			}
			catch (IOException e){
				System.out.println("Error encountered opening file: " + e);
			}
			
		}
		
	}
	
	@SuppressWarnings("null")
	public boolean prompt(String s){
		boolean b = true;
		String[] sp = s.split("\\s+");
		switch (sp[0]){
			case "CARDREAD":	// 
				atm.cardRead(Integer.parseInt(sp[1]));
				break;
			case "NUM":
				atm.num(Integer.parseInt(sp[1]));
				break;
			case "DIS":
				String text = sp[1];
				for (int i = 2; i < sp.length; i++){
					text = text.concat(" " + sp[i]);
				}
				//text.trim();
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
						atm.buttonPress(0);
						break;
				}
				break;
			case "EXIT":
				b = false;
				break;
		}
		return b;
	}
}
