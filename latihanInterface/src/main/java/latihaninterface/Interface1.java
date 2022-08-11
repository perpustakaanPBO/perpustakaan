/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihaninterface;
import java.io.*;
/**
 *
 * @author Ken Jaya
 */
public interface Interface1 {
    
    interface in1{
        final int a = 10;
        final int b = 20;
        
        void display();
    }
    
    class testClass implements in1{
        public void display(){
            System.out.println("Hitung Luas Persegi Panjang Dengan Java Interface");
        };
        
        public static void main(String[] args){
            testClass t = new testClass();
            int x = a * b;
            t.display();
            
            System.out.println("Ukuran Panjang: "+a);
            System.out.println("Ukuran lebar: "+b);
            System.out.println("Luas Persegi Panjang: "+x);
        }
    }
}
