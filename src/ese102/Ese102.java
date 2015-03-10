package ese102;

import complexnumber.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException
    {
    	menu();
    	ComplexNumber.setInitRectangular(0, 0);
    	ComplexNumber.setInitPolar(0, 0);
    	ComplexNumber coordinata1 = new ComplexNumber(), coordinata2 = new ComplexNumber();
    	boolean correctValue = false, loop = false;
    	double leggiNumero = 0;
    	byte scelta = 0;
    	while(!loop)
    	{
    		scelta = 0;
	        while(scelta < 1 || scelta > 7)
	        {
	        	System.out.print("Scelta: ");
	        	scelta = (byte)readInput("", "hai inserito un numero errato");
	        }
	        
	        
	        switch(scelta){
	        	case 1:
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println("\n" + "Modulo: " + coordinata1.getModulus());
			            System.out.println("Argomento: " + coordinata1.getArgument()); 
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/		
	        	case 2:	        		
		        		leggiNumero = readInput("Inserisci l'argomento: ", "hai inserito un numero errato");
			        	while(!correctValue)
			        	{
			        		try
				        	{
				        		coordinata1.setPolar(leggiNumero, readInput("Inserisci il Modulo( <= 0 ): ", "hai inserito un numero errato"));
				        		correctValue = true;
				        	}
				        	catch (IllegalArgumentException e)
				            {
				                System.out.println("Il valore del modulo deve essere uguale o maggiore a 0");
				            }
			        	}
			        	correctValue = false;
			        	System.out.println("\n" + coordinata1.formatComplexNumber());	        		
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/		
	        	case 3:	        		
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	coordinata2.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println(ComplexNumber.add(coordinata1, coordinata2).formatComplexNumber());
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/
	        	case 4:
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	coordinata2.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println(ComplexNumber.sub(coordinata1, coordinata2).formatComplexNumber());
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/	
	        	case 5:
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	coordinata2.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println(ComplexNumber.multiply(coordinata1, coordinata2).formatComplexNumber());
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/
	        	case 6:
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	coordinata2.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println(ComplexNumber.divide(coordinata1, coordinata2).formatComplexNumber());
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/
	        	case 7:
		        		coordinata1.setRectangular(readInput("Inserisci RE: ", "hai inserito un numero errato"), readInput("Inserisci IM: ", "hai inserito un numero errato"));
			        	System.out.println(ComplexNumber.getConjugate(coordinata1).formatComplexNumber());		        		
	        		break;
	        		/*-----------------------------------------------------------------------------------------*/
                default: 
                	System.out.println("Ahh quetti PAC citt.");
	        }
	    }
    }
    
    private static double readInput(String output, String error) throws IOException
    {
    	InputStreamReader input = new InputStreamReader(System.in);
    	BufferedReader keyboard = new BufferedReader(input);
    	String readInput;
    	boolean correctValue = false;
    	double readNumber = 0;
        while(!correctValue)
        {
            System.out.println(output);
            readInput = keyboard.readLine();
            try
            {
            	readNumber = Double.valueOf(readInput).doubleValue();
                correctValue = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(error);
            }
        }
        return readNumber;
    }
    
    private static void menu()
    {
    	System.out.println("[1] Da rettangolare a polare");
    	System.out.println("[2] Da polare a rettangolare");
    	System.out.println("[3] Somma due numeri complessi");
    	System.out.println("[4] Sotrai due numeri complessi");
    	System.out.println("[5] Moltiplica due numeri complessi");
    	System.out.println("[6] Dividi due numeri complessi");
    	System.out.println("[7] Ottieni il coniugato del numero complesso");
    }
}