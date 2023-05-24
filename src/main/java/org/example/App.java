package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Kassa kassa = new Kassa();
        Produk produk1 = new Produk("metal gear solid 5",300000);
        Produk produk2 = new Produk("death stranding",900000);
        Produk produk3 = new Produk("bundle ps4",5000000);
        Produk produk4 = new Produk("cofee talk",200000);
        System.out.println("----------Skenario 1: Registrasi Kasir----------");
        Kasir kasir1 = new Kasir("Mika Osborn","mikaosborn","osbornmika");
        Kasir kasir2 = new Kasir("kevin doyle","kevindoyle","doylekevin");
        kassa.register(kasir1);
        kassa.register(kasir2);
        System.out.println("----------Skenario 2: Login Gagal----------");
        kassa.login("Mika","Mika");
        System.out.println("----------Skenario 3: Login Berhasil (Username: mikaosborn)----------");
        kassa.login("mikaosborn","osbornmika");
        System.out.println("----------Skenario 4: Print Nota #1----------");
        kassa.tambahPesanan(produk1,1);
        kassa.tambahPesanan(produk2,2);
        kassa.printNota();
        System.out.println("----------Skenario 5: Print Nota #2----------");
        kassa.tambahPesanan(produk4,1);
        kassa.printNota();
        System.out.println("----------Skenario 6: Login Berhasil (Username: kevindoyle)----------");
        kassa.login("kevindoyle","doylekevin");
        System.out.println("----------Skenario 7: Print Nota #3----------");
        kassa.tambahPesanan(produk3,2);
        kassa.tambahPesanan(produk4,1);
        kassa.printNota();
        System.out.println("----------Skenario 8: Informasi Pejualan Kasir----------");
        kassa.printPenjualanKasir();
    }
}
