package complexnumber;

public class ComplexNumber
{
    private double re;
    private double im;
        
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
    public ComplexNumber add(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
        result.setRectangular(this.re+operand.re, this.im+operand.im);
    	return result;
    }
    
    /**
     * Sottrae due numeri complessi
     * @param operand
     * @return
     */
    public ComplexNumber sub(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(this.re-operand.re, this.im-operand.im);
    	return result;
    }
    
    /**
     * Moltiplica due numeri complessi
     * @param operand
     * @return
     */
    public ComplexNumber multiply(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(this.getArgument()+operand.getArgument(), this.getModulus()*operand.getModulus());
    	return result;
    }
    
    /**
     * Divide due numeri complessi
     * @param operand
     * @return
     */
    public ComplexNumber divide(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(this.getArgument()-operand.getArgument(), this.getModulus()/operand.getModulus());
    	return result;
    }
        
    /**
     * Ritorna il complesso coniugato del numero complesso
     * @return
     */
    public ComplexNumber getConjugate()
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(this.re, -this.im);
    	return result;
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
     * 
     *
     * 
     */
}
