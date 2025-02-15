package Week2.Caculate_S_and_P;

public class Rectangle extends Shape{
    private double width , length;


    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPerimeter (){
        return (getLength() + getWidth()) * 2;

    }

    public double getArea (){
        return getLength() *  getWidth()  ;
    }

    public void printResult (){
        System.out.println("Width: "+getWidth());
        System.out.println("Length: "+getLength());
    }
}
