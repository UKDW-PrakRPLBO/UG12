package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class LoginTest {

    @Test
    public void testRegister(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("Mika Osborn","mikaosborn","osbornmika");
            kassa.register(kasir1);

            System.setOut(originalOut);
            printStream.close();

            String capturedOutput = outputStream.toString();


            assertEquals("Kasir Mika Osborn berhasil ditambahkan ke dalam sistem.", capturedOutput.trim());


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testBerhasilLogin(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("kevin doyle","kevindoyle","doylekevin");

            kassa.register(kasir1);
            String capturedOutput = outputStream.toString();

            kassa.login("kevindoyle","doylekevin");
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Login berhasil!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testGagalLogin(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("kevin doyle","kevindoyle","doylekevin");

            kassa.register(kasir1);
            String capturedOutput = outputStream.toString();

            kassa.login("dikitole","tolediki");
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Username/password Anda salah!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testPrintNota1(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Produk produk1 = new Produk("Cort AC 160 CF",3112000);
        Produk produk2 = new Produk("Cort AD810 OP",1115000);

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("kevin doyle","kevindoyle","doylekevin");

            kassa.register(kasir1);
            kassa.login("kevindoyle","doylekevin");
            kassa.tambahPesanan(produk1,1);
            kassa.tambahPesanan(produk2,2);

            String capturedOutput = outputStream.toString();

            kassa.printNota();
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Cort AC 160 CF";
            String expectedOutput2 = "2230000";
            String expectedOutput3 = "Total: Rp5342000";

            assertTrue(capturedOutput.contains(expectedOutput));
            assertTrue(capturedOutput.contains(expectedOutput2));
            assertTrue(capturedOutput.contains(expectedOutput3));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testPrintNota2(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Produk produk1 = new Produk("gitar akustik",200000);
        Produk produk2 = new Produk("pipa rucika",100000);

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("Bukayo saka","bukayosaka","sakabukayo");

            kassa.register(kasir1);
            kassa.login("bukayosaka","sakabukayo");
            kassa.tambahPesanan(produk1,1);
            kassa.tambahPesanan(produk2,2);

            String capturedOutput = outputStream.toString();

            kassa.printNota();
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "pipa rucika";
            String expectedOutput2 = "200000";
            String expectedOutput3 = "Bukayo saka";

            assertTrue(capturedOutput.contains(expectedOutput));
            assertTrue(capturedOutput.contains(expectedOutput2));
            assertTrue(capturedOutput.contains(expectedOutput3));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testPrintPenjualanKasir1(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Produk produk1 = new Produk("Cort AC 160 CF",3112000);
        Produk produk2 = new Produk("Cort AD810 OP",1115000);

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("kevin doyle","kevindoyle","doylekevin");
            Kasir kasir2 = new Kasir("yanto iglesias","yantoiglesias","iglesiasyanto");


            kassa.register(kasir1);
            kassa.register(kasir2);
            kassa.login("kevindoyle","doylekevin");
            kassa.tambahPesanan(produk1,1);
            kassa.tambahPesanan(produk2,2);
            kassa.printNota();
            kassa.login("yantoiglesias","iglesiasyanto");
            kassa.tambahPesanan(produk2,2);
            kassa.printNota();
            String capturedOutput = outputStream.toString();

            kassa.printPenjualanKasir();
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "kevin doyle\t\tRp5342000";
            String expectedOutput2 = "yanto iglesias\t\tRp2230000";


            assertTrue(capturedOutput.contains(expectedOutput));
            assertTrue(capturedOutput.contains(expectedOutput2));



        } finally {
            printStream.close();
        }

    }

    @Test
    public void testPrintPenjualanKasir2(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Produk produk1 = new Produk("Cort AC 160 CF",3112000);
        Produk produk2 = new Produk("Cort AD810 OP",1115000);

        try {
            System.setOut(printStream);

            Kassa kassa = new Kassa();
            Kasir kasir1 = new Kasir("David calibre","davidcalibre","calibredavid");
            Kasir kasir2 = new Kasir("Bukayo saka","bukayosaka","sakabukayo");


            kassa.register(kasir1);
            kassa.register(kasir2);
            kassa.login("davidcalibre","calibredavid");
            kassa.tambahPesanan(produk1,1);
            kassa.tambahPesanan(produk2,2);
            kassa.printNota();
            kassa.login("bukayosaka","sakabukayo");
            kassa.tambahPesanan(produk2,2);
            kassa.printNota();
            String capturedOutput = outputStream.toString();

            kassa.printPenjualanKasir();
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "David calibre\t\tRp5342000";
            String expectedOutput2 = "Bukayo saka\t\tRp2230000";


            assertTrue(capturedOutput.contains(expectedOutput));
            assertTrue(capturedOutput.contains(expectedOutput2));



        } finally {
            printStream.close();
        }

    }

}
