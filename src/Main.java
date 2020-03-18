import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyImage image=new MyImage("D:\\kursach","pepe.jpg");
        image.pixelMatrix();
        image.noize1();
        image.createNoizeImage();
        System.out.println(4*((int)(Math.random()*32))>>5);




    }
}
