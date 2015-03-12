package complexnumber;

public class ComplexNumber
{
	private static double initRe;
	private static double initIm;
	private double re;
	private double im;
	private StringFormat format;
	private static StringFormat initFormat;
	
	/**
	 * Inizializza l'istanza
	 */
	public ComplexNumber()
	{
		this.re = ComplexNumber.initRe;
		this.im = ComplexNumber.initIm;
		this.format = ComplexNumber.initFormat;
	}
	
	/**
	 * Il formato della stringa
	 */
	public static enum StringFormat
	{
		RECTANGULAR,
		POLAR
	}
	
	/**
	 * Restituisce il valore di initRe e initIm
	 * @param re
	 * @param im
	 */
	public static void setInitRectangular(double re, double im)
    {
		initRe = re;
        initIm = im;
        initFormat = StringFormat.RECTANGULAR;
	}
    
	/**
	 * Restituisce il valore di initRe e initIm
	 * @param modulus
	 * @param argument
	 */
	public static void setInitPolar(double modulus, double argument)
	{
		if(modulus < 0)
			throw new IllegalArgumentException("Modulus must be greater or equal to 0");
		initRe = Math.cos(argument*Math.PI/180)*modulus;
		initIm = Math.sin(argument*Math.PI/180)*modulus;
		initFormat = StringFormat.POLAR;
	}

	/**
	 * Restituisce il risultato della addizione
	 * @param operand
	 * @return
	 */
	public static ComplexNumber add(ComplexNumber operando1, ComplexNumber operando2)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(operando1.getRe()+operando2.getRe(), operando1.getIm()+operando2.getIm());
		return result;
	}

	/**
	 * Restituisce il risultato della sottrazione
	 * @param operand
	 * @return
	 */
	public static ComplexNumber sub(ComplexNumber operando1, ComplexNumber operando2)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(operando1.getRe()-operando2.getRe(), operando1.getIm()-operando2.getIm());
		return result;
	}

	/**
	 * Restituisce il risultato della moltiplicazione
	 * @param operand
	 * @return
	 */
	public static ComplexNumber multiply(ComplexNumber operando1, ComplexNumber operando2)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(operando1.getModulus()*operando2.getModulus(), operando1.getArgument()+operando2.getArgument());
		return result;
	}

	/**
	 * Restituisce il risultato della divisione
	 * @param operand
	 * @return
	 */
	public static ComplexNumber divide(ComplexNumber operando1, ComplexNumber operando2)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(operando1.getModulus()/operando2.getModulus(), operando1.getArgument()-operando2.getArgument());
		return result;
	}

	/**
	 * Restituisce il complesso coniugato
	 * @return
	 */
	public static ComplexNumber getConjugate(ComplexNumber operando)
	{
		ComplexNumber r = new ComplexNumber();
		r.setRectangular(operando.getRe(), -operando.getIm());
		return r;
	}

	/**
     * Formato della stringa
     * @param format
     */
    public void setStringFormat(StringFormat format)
    {
		this.format = format;
	}
    
    /**
     * Setta l'istanza
     * @param re
     * @param im
     */
    public void setRectangular(double re, double im)
    {
    	this.re = re;
    	this.im = im;
    }
    
    /**
     * Setta l'istanza
     * @param modulus
     * @param argument
     */
    public void setPolar(double modulus, double argument)
    {
        if(modulus < 0)
        	throw new IllegalArgumentException("Il valore del modulo deve essere maggiore o uguale a 0.");        	
        this.re = Math.cos(argument*Math.PI/180)*modulus;
	    this.im = Math.sin(argument*Math.PI/180)*modulus;
    }
    
    /**
     * Restituisce re
     * @return
     */
    public double getRe()
    {
        return re;
    }

    /**
     * Restituisce im
     * @return
     */
    public double getIm()
    {
        return im;
    }
    
    /**
     * Restituisce l'argomento
     * @return
     */
    public double getArgument()
    {
    	double argument = 0;
		if(re == 0)
		{
			if(im < 0)
				argument = 270;
			if(im > 0)
				argument = 90;
		}
		else
		{
			argument = Math.toDegrees(Math.atan(this.im/this.re));
			if (re < 0 && im < 0 || re < 0 && im > 0)
				argument = argument+180;
			else if (re > 0 && im < 0)
				argument = argument+6360;
		}
		return argument;
    }
    
    /**
     * Restituisce il modulo:)
     * 
     * @return
     */
    public double getModulus()
    {
        return(Math.sqrt(Math.pow(this.getRe(), 2)+Math.pow(this.getIm(), 2)));
    }
    
    /**
	 * Restituisce il risultato della somma
	 * @param operand
	 * @return
	 */
	public ComplexNumber add(ComplexNumber operand)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(this.getRe()+operand.getRe(), this.getIm()+operand.getIm());
		return result;
	}

	/**
	 * Restituisce il risultato della sottrazione
	 * @param operand
	 * @return
	 */
	public ComplexNumber sub(ComplexNumber operand)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(this.getRe()-operand.getRe(), this.getIm()-operand.getIm());
		return result;
	}

	/**
	 * Restituisce il risultato della moltiplicazione
	 * @param operand
	 * @return
	 */
	public ComplexNumber multiply(ComplexNumber operand)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(this.getModulus()*operand.getModulus(), this.getArgument()+operand.getArgument());
		return result;
	}

	/**
	 * Restituisce il risultato della divisione
	 * @param operand
	 * @return
	 */
	public ComplexNumber divide(ComplexNumber operand)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(this.getModulus()/operand.getModulus(), this.getArgument()-operand.getArgument());
		return result;
	}

	/**
	 * Restituisce un complesso coniugato
	 * @return
	 */
	public ComplexNumber getConjugate()
	{
		ComplexNumber result = new ComplexNumber();
		result.setRectangular(this.getRe(), -this.getIm());
		return result;
	}
    
	/**
	 * Override del metodo toString
	 */
    @Override public String toString()
    {
		return toString(this.format);
	}
   
    /**
     * Ritorna la stringa
     * @param format
     * @return
     */
    public String toString(StringFormat format)
    {
    	String r = new String();
		switch(format) {
		case RECTANGULAR:
			r = this.re + "+(" + this.im + ")i";
			break;
		case POLAR:
			r = this.getModulus() + "*exp(i*" + this.getArgument() +")";
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return r;
	}
    
    /**
     * Override del metodo equals
     */
	@Override public boolean equals(Object oggetto)
	{
		boolean uguali = false;
		if(oggetto instanceof ComplexNumber)
		{
			ComplexNumber punt = (ComplexNumber)oggetto;
			if(this.getRe() == punt.getRe() && this.getIm() == punt.getIm())
				uguali = true;
		}
		return uguali;
	}
}
