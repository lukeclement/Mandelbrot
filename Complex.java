public class Complex{
  private double i;
  private double r;

  public Complex(double r, double i){
    this.i=i;
    this.r=r;
  }
  //Components
  public double getReal(){
    return r;
  }
  public double getImaginary(){
    return i;
  }
  public void setReal(double r){
    this.r=r;
  }
  public void setImaginary(double i){
    this.i=i;
  }
  //Multiply and add
  public Complex times(Complex z){
    double a=r;
    double b=i;
    double c=z.getReal();
    double d=z.getImaginary();
    return new Complex(a*c-b*d,a*d+c*b);
  }
  public Complex add(Complex z){
    return new Complex(z.getReal()+r,z.getImaginary()+i);
  }
  //Powers
  public Complex s(){
    Complex z=new Complex(r,i);
    return z.times(z);
  }
}
