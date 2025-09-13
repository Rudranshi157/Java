public class OOPs{
    static void detail(){
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.changeColor("blue");
        p1.setTip(5);
        //p1.detail();
        // System.out.println("color : "+p1.color+"  tip : "+p1.tip);
        // p1.tip = 8;
        // p1.color = "red";
        // System.out.println("color : "+p1.color+"  tip : "+p1.tip);
        // Student a = new Student();
        // a.name = "ram";
        // a.age = 21;
        // System.out.println("name "+a.name+" \nage "+a.age);
        //BankAccount myAcc = new BankAccount("google");
        //myAcc.username ="jhdkjbxbbu";
        //myAcc.setpassword("jhhs");
        //System.out.println(myAcc.username);
        //myAcc.detail();
        //detail();
        // Calculator calc = new Calculator();
        // calc.sum(3,4,5);
        // System.out.println(calc.sum(3,3));
        // Deer d = new Deer();
        // d.eat();
        // Horse c = new Horse();
        // System.out.println(c.color);
        // c.changeColor();
        // System.out.println(c.color);
        Mustang myhorse = new Mustang();
        System.out.println(myhorse.color);
        // Queen Q = new Queen();
        // Q.moves();
    }
}
class Animal{
    void eat(){
        System.out.println("eat different things");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("eat grass");
    }
}

abstract class Animals{
    String color ;
    void eat(){
        System.out.println("eats");
    }
    abstract void walk();
    Animals (){
        color = "brown";
        System.out.println("Animal constructor is called...");
    }
}
class Horse extends Animals{
    void walk(){
        System.out.println("walks on 4 legs.");
    }
    void changeColor(){
        color = "blue";
    }
    Horse(){
        super();
        System.out.println("Horse constructor is called...");
    }
}
class Mustang extends Horse{
    Mustang(){
        
        System.out.println("Mustang constructor is called...");
    }
}
class Chicken extends Animals{
    void think(){
        System.out.println(".()");
    }
    void walk(){
        System.out.println("wals on 2 legs.");
    }
}

interface Chessplayers{
    void moves();
}
class Queen implements Chessplayers{
    public void moves(){
        System.out.println("moves up, down , left , right and diagonal");
    }
}
class King implements Chessplayers{
    public void moves(){
        System.out.println("moves up, down , left , right and diagonal by only one step");
    }
}
class Rook implements Chessplayers{
    public void moves(){
        System.out.println("moves up, down , left and right");
    }
}
class Calculator{
    int sum(int a , int b){
        return a+b;
    }
    int sum (int a , int b , int c){
        return a+b+c;
    }
    double sum(double a , double b){
        return  a+b;
    }
}
class BankAccount{
    protected String username;
    private String password;
    void setpassword(String pwd ){
        password = pwd;
    }
    private String showpwd(){
        return password;
    }
    public void detail(){
        System.out.println("USERNAME : "+username+"\nPASSWORD : "+showpwd());
    }

    public BankAccount(String username) {
        this.username = username;
    }
    
}
class Pen{
    int tip;
    String color;

    void changeColor(String newColor){
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
    void detail(){
        System.out.println(color + tip);
    }
}
class Student{
    int age;
    String name;
}

