package complexnumber;

public class ComplexNumber{
    private double re;
    private double im;
 
    public String formatComplexNumber(){
        String r = this.re + "+(" + this.im + ")i";
        return r;
    }

    public void setRectangular(double re, double im){
    	this.re = re;
    	this.im = im;
    }
    
    public void setPolar(double modulus, double argument){
        this.im = Math.sin(argument*Math.PI/180)*modulus;
        this.re = Math.cos(argument*Math.PI/180)*modulus;
    }
    
    public double getModulus(){
        return(Math.sqrt(Math.pow(this.re,2)+Math.pow(this.im,2)));
    }
    
    public double getArgument(){
        return((Math.atan(this.im/this.re)*180)/Math.PI);
    }
      
    public double getRe(){
        return re;
    }

    public double getIm(){
        return im;
    }
}