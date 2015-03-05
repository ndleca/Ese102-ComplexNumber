package ese102;

import complexnumber.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException{
    	
    	ComplexNumber cn1 = new ComplexNumber();
        ComplexNumber cn2 = new ComplexNumber();
        InputStreamReader input = new InputStreamReader(System.in);
    	BufferedReader tastiera = new BufferedReader(input);
    	String riga;
    	boolean valore=false;
    	double leggiNumero=0;
    	double leggiNumbero1=0;
    	while(!valore){
    		System.out.println("Coordinata X: ");
    		riga = tastiera.readLine();
    		try{
    			leggiNumero = Double.valueOf(riga).doubleValue();
    			valore = true;
    		}
    		catch(NumberFormatException e){
    			System.out.println("sei down");
    		}
    	}
    	valore = false;
    	while(!valore){
    		System.out.println("Coordinata Y: ");
    		riga = tastiera.readLine();
    		try{
    			leggiNumbero1 = Double.valueOf(riga).doubleValue();
    			valore = true;
    		}
    		catch(NumberFormatException e){
    			System.out.println("sei ancora + down");
    		}
    	}
    	valore = false;
    	cn1.setRectangular(leggiNumero, leggiNumbero1);	
    	while(!valore){
    		System.out.println("Modulo: ");
    		riga = tastiera.readLine();
    		try{
    			leggiNumero = Double.valueOf(riga).doubleValue();
    			valore = true;
    		}
    		catch(NumberFormatException e){
    			System.out.println("il ritardato dei ritardati che scrivi scemo?");
    		}
    	}
    	valore = false;
    	while(!valore){
    		System.out.println("Argomento: ");
    		riga = tastiera.readLine();
    		try{
    			leggiNumbero1 = Double.valueOf(riga).doubleValue();
    			valore = true;
    		}
    		catch(NumberFormatException e){
    			System.out.println("basta ci rinuncio");
    		}
    	}
    	cn2.setPolar(leggiNumero, leggiNumbero1);
    	System.out.println("Argomento: " + cn1.getArgument());
        System.out.println("Modulo: " + cn1.getModulus());
        System.out.println("Re: " + cn2.getRe());
        System.out.println("Im: " + cn2.getIm());
    }
    
}