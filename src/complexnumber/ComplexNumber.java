package complexnumber;

public class ComplexNumber
{
	static private double initRe;
    static private double initIm;
    private double re;
    private double im;
    
    /**
     * Static method, initialize the variables initializeRe and initializeIm to default value.
     * Works only with rectangular coordinates.
     * @param re
     * @param im
     */
    public static void setInitRectangular(double re, double im)
    {
        initRe = re;
        initIm = im;
    }
    
    /**
     * Static method, initialize the variables initializeRe and initializeIm to default value, given argument and modulus.
	 * Works only with polar coordinates.
     * @param modulus
     * @param argument
     */
    public static void setInitPolar(double modulus, double argument)
    {
        if(modulus < 0)
        	throw new IllegalArgumentException("Modulus must be greater or equal to 0");
        initRe = Math.cos(argument*Math.PI/180)*modulus;
        initIm = Math.sin(argument*Math.PI/180)*modulus;
    }
        
    /**
     * Inzializza le variabili re e im
     * @param re
     * @param im
     */
    public void setRectangular(double re, double im)
    {
    	this.re = re;
    	this.im = im;
    }
    
    /**
     * Inizializza le variabili argument e modulus
     * @param modulus
     * @param argument
     */
    public void setPolar(double argument, double modulus)
    {
    	if(modulus >= 0)
        {
        	this.re = Math.cos(argument*Math.PI/180)*modulus;
	        this.im = Math.sin(argument*Math.PI/180)*modulus;
        	if(argument == 90)
        		this.re = 0;
        	else if(argument == 180)
	        	this.im = 0;
        	else if(argument == 270)
        		this.re = 0;
        }
        else
        	throw new IllegalArgumentException("il valore del modulo deve essere uguale o maggiore di 0");
    }
    
    /**
     * Somma due numeri complessi
     * @param operand
     * @return
     */
    static public ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber risultato = new ComplexNumber();
    	risultato.setRectangular(operand1.re+operand2.re, operand1.im+operand2.im);
    	return risultato;
    }
    
    /**
     * Sottrae due numeri complessi
     * @param operand
     * @return
     */
    static public ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber risultato = new ComplexNumber();
    	risultato.setRectangular(operand1.re-operand2.re, operand1.im-operand2.im);
    	return risultato;
    }
    
    /**
     * Moltiplica due numeri complessi
     * @param operand
     * @return
     */
    static public ComplexNumber multiply(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber risultato = new ComplexNumber();
    	risultato.setPolar(operand1.getArgument()+operand2.getArgument(), operand1.getModulus()*operand2.getModulus());
    	return risultato;
    }
    
    /**
     * Divide due numeri complessi
     * @param operand
     * @return
     */
    static public ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber risultato = new ComplexNumber();
    	risultato.setPolar(operand1.getArgument()-operand2.getArgument(), operand1.getModulus()/operand2.getModulus());
    	return risultato;
    }
        
    /**
     * Ritorna il complesso coniugato del numero complesso
     * @return
     */
    static public ComplexNumber getConjugate(ComplexNumber operand)
    {
    	ComplexNumber risultato = new ComplexNumber();
    	risultato.setRectangular(operand.re, -operand.im);
    	return risultato;
    }
    
    /**
     * Stampa il numero complesso
     * @return
     */
    public String formatComplexNumber()
    {
        String result = this.getRe() + "+(" + this.getIm() + ")i";
        return result;
    }
    
    /**
     * Ritorna il modulo
     * @return
     */
    public double getModulus()
    {
        return(Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2)));
    }
        
    /**
     * Ritorna l'argomento
     * @return
     */
    public double getArgument()
    {
    	int bugFix = 0;
    	if(this.re < 0)
    		bugFix = 180;
    	return((Math.atan(this.im/this.re)*180)/Math.PI+bugFix);
    }
    
    /**
     * Ritorna re
     * @return
     */
    public double getRe()
    {
        return re;
    }

    /**
     * Ritorna im
     * @return
     */
    public double getIm()
    {
        return im;
    }
    
    /*
     * 		1) Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2))
     * 		   Math.atan(this.im/this.re)*180)/Math.PI
     * 		   Per re = 0 e im = 0 l'argomento non esiste
     *         this.re = Math.cos(argument*Math.PI/180)*modulus
	 *         this.im = Math.sin(argument*Math.PI/180)*modulus
     * 
     * 		2) non si puo fornire quatro funzioni setter (setRe, setIm, setModulus, setArgument), 
     * 		   perche bisogna lavorare in coppia con 2 parametri (setRectangular, setPolar)
     * 
     * 		3) siccome avrei bisogno di 2 costruttori, che non possono esistere contemporaneamente 
     * 		   dato che richiedono entrambia lo stesso numero di valori dello stesso tipo, non ne ho utilizzato nessuno
     * 
     * 		4) Devi usare 4 funzioni getter perche un metodo non puo ritornare 2 valori
     *
     *      5) 
     *    		x = a1+b1i 
     *      	y = a2+b2i
     *      	x+y = (a1+a2)+(b1+b2)i
     *      	x-y = (a1-a2)+(b1-b2)i
     *      
     *      6) 
     *	    	x = a1+b1i 
     *     		y = a2+b2i
     *      	Argomento = ArgomentoX+ArgomentoY
     *      	Modulo = ModuloX*ModuloY
	 *	    	Argomento = ArgomentoX-ArgomentoY
     *      	Modulo = ModuloX/ModuloY
     *	
     *	    7) 
     *      	x = a+bi 
     *      	x = a-bi
     */
}
