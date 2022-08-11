/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ken Jaya
 */
import java.util.Scanner;
public class Karyawaan {

    /**
     * @param args the command line arguments
     */
    
    String ID,nama,divisi;
    Double gaji;
    
    public Karyawaan(String kode,String Nama,String div,Double Gaji){
        ID = kode;
        nama = Nama;
        divisi = div;
        gaji = Gaji;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Data Karyawan: ");
        System.out.println("ID: ");
        String id = scan.next();
        System.out.println("Nama: ");
        String n = scan.next();
        System.out.println("Divisi: ");
        String d = scan.next();
        System.out.println("Gaji: ");
        Double g = scan.nextDouble();
        Karyawaan k = new Karyawaan(id,n,d,g);
        System.out.println("=============================");
        
        System.out.println("ID: "+k.ID);
        System.out.println("Nama: "+k.nama);
        System.out.println("Divisi: "+k.divisi);
        System.out.println("Gaji: "+k.gaji);
    }
    
}
