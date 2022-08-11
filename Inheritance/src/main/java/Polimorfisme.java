abstract class Bentuk{
    protected int panjang;
    protected int lebar;
    
    public String getBentuk(){
        return "Bentuk Dasar: ";
    }
    
    public int hitungLuas(){
        return panjang*lebar/2;
    }
}

class BujurSangkar extends Bentuk{
    public BujurSangkar(int panjang1, int lebar1){
        this.panjang = panjang1;
        this.lebar = lebar1;
    }
    
    public String getBentuk(){
        return "Bentuk Bujur Sangkar ";
    }
    
    public int hitungLuas(){
        return panjang*lebar;
    }
}

class SegiTiga extends Bentuk{
    public SegiTiga(int panjang2, int  lebar2){
        this.panjang = panjang2;
        this.lebar = lebar2;
    }
    
    public String getBentuk(){
        return "Bentuk Segitiga ";
    }
    
    
}

class Polimorfisme{
    public static void cetakLuasBentuk(Bentuk btk){
        System.out.println(btk.getBentuk()+"dengan luas"+ btk.hitungLuas());
    }
    
    public static void main(String[] args){
        BujurSangkar bs = new BujurSangkar(10, 20);
        BujurSangkar bsl = new BujurSangkar(10, 20);
        SegiTiga st = new SegiTiga(5, 10);
        SegiTiga stl = new SegiTiga(50, 100);
        
        cetakLuasBentuk(bs);
        cetakLuasBentuk(bsl);
        cetakLuasBentuk(st);
        cetakLuasBentuk(stl);
    }
}