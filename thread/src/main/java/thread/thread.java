package thread;

//class Count extends Thread{
//    public void run(){
//        try{
//            System.out.println("Thread "+ Thread.currentThread().getId()+" Sedang Berjalan");
//        }catch(Exception e){
//            System.out.println("Proses Terganggu");
//        }
//    }    
//}
//
//public class thread {
//    public static void main(String[] args){
//        for(int i = 1; i<=10;i++){
//            Count satu = new Count();
//            satu.start();
//        }
//    }
//}

//class Count implements Runnable{
//    public void run(){
//        try{
//          System.out.println("Thread "+ Thread.currentThread().getId()+" Sedang Berjalan");  
//        }catch(Exception e){
//            System.out.println("Proses Terganggu");
//            
//        }
//    }
//}
//
//public class thread{
//    
//    public static void main(String[] args){
//        for(int i = 1; i <= 10; i++){
//            Thread jalan = new Thread(new Count());
//            jalan.start();
//        }
//    }
//}
class Hello implements Runnable{
    public void run(){
        for(int i = 1; i <=10; i++){
          System.out.println("Hello");
          try{Thread.sleep(500);} catch(Exception e){}
        }        
    }
}

class World implements Runnable{
    public void run(){
        for(int i = 1; i<=10; i++){
            System.out.println("World");
            try{Thread.sleep(500);} catch(Exception e){}
        }
    }
}

public class thread{
    public static void main(String[] args){
        Thread satu = new Thread(new Hello());
        Thread dua = new Thread(new World());
        
        satu.start();
        try{Thread.sleep(10);} catch(Exception e){}
        satu.stop();
        dua.start();
        
    }
}

