/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ken Jaya
 */
class Count extends Thread{
    public void run(){
        try{
            System.out.println("Thread "+Thread.currentThread().getId()+" Sedang Berjalan");
        }catch(Exception e){
            System.out.println("Proses terganggu");
        }
    }
}

public class Exthread{
    public static void main(String[] args){
        for(int i = 0; i<=10; i++){
            Count satu = new Count();
            satu.start();
        }
    }
}