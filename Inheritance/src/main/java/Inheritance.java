/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ken Jaya
 */
public class Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A VarsuperOb = new A();
        B VarsubOb = new B();
        
        System.out.println("SupperClass");
        
        VarsuperOb.x = 10;
        VarsuperOb.y = 20;
        VarsuperOb.tampilkanNilaixy();
        
        System.out.println("SubClass");
        
        VarsubOb.x = 5;
        VarsubOb.y = 4;
        VarsubOb.tampilkanNilaixy();
        
        System.out.println("Subclass Jumlah");
        
        VarsubOb.z = 30;
        VarsubOb.TampilkanJumlah();
        
        System.out.println("Subclass");
        VarsubOb.x = 15;
        VarsubOb.y = 14;
        VarsubOb.tampilkanNilaixy();
        
        System.out.println("SuperClass");
        VarsuperOb.x = 10;
        VarsuperOb.y = 20;
        
        VarsuperOb.tampilkanNilaixy();
        
        System.out.println("Subclass Jumlah");
        VarsubOb.z = 60;
        VarsubOb.TampilkanJumlah();
        
    }
    private static class A{
        int x; int y;
            
        void tampilkanNilaixy(){
            System.out.println("Nilai x: "+x+", y: "+y);
        }
    }
    
    private static class B extends A{
        int z;
        
        void TampilkanJumlah(){
            System.out.println("Jumlah: "+(x+y+z));
        }

        
    }
    
}
