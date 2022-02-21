/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Program.OOP.ATM;

import java.util.Scanner;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.io.IOException;

public class OptionMenu extends Account{
    Scanner Input = new Scanner(System.in);
    //Format Uang.
    DecimalFormat formatUang = new DecimalFormat("'Rp '###,###.00");
    //Identifikasi Nilai dan Kunci untuk nilai tersebut.
    HashMap<String, Integer> data = new HashMap<String, Integer>();
    // Login
    public void getLogin()throws IOException{
        int x = 1;
        // Perulangan Untuk Login
        do {            
            try {
                //user dan pin yang menggunakan HasMap.
                data.put("user",123);
                data.put("admin",123);
                System.out.println("Selamat Datang Penggunan ATM");
                System.out.print("Masukan Nama User anda :");
                setNamaUser(Input.nextLine());
//                Input.nextLine();
                System.out.print("Masukan Pin Anda : ");
                setPinUser(Input.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Inputan Salah. Hanya Menggunakan Angka." + "\n");
                x = 2;
            }
            String nu = getNamaUser();
            int pu = getPinUser();
            if (data.containsValue(pu)&& data.containsKey(nu)) {
                getAccountType();
            } else {
                System.out.println("\n" + "Nomor User atau Pin Anda Salah" + "\n");
            }
        } while (x == 1);
    }
    // Pilihan Jenis Akun
    public void getAccountType() {
        System.out.println("Pilih Akun yang Ingin Anda Akses :");
        System.out.println("1. Rekening Giro");
        System.out.println("2. Tabungan");
        System.out.println("3. Keluar");
        System.out.print("Masukan Pilihan Anda : ");
        int pilihan = Input.nextInt();
        switch (pilihan) {
            case 1:
                getRekeningGiro();
                break;
            case 2:
                getTabungan();
                break;
            case 3:
                System.out.println("Terimakasih Telah Menggunakan ATM.");
                break;
            default:
                System.out.println("\n" + "Inputan Yang Anda Masukan Salah.");
                getAccountType();
        }
    }
    // Rekening Giro
    public void getRekeningGiro() {
        System.out.println("Rekening Giro Menu :");
        System.out.println("1. Lihat Saldo");
        System.out.println("2. Tarik Uang");
        System.out.println("3. Setor Uang");
        System.out.println("4. Keluar");
        System.out.print("Masukan Pilihan : ");
        int pilihan = Input.nextInt();
        switch (pilihan) {
            case 1:
                System.out.println("Lihat Saldo : " + formatUang.format(getSaldoGiro()));
                getRekeningGiro();
                break;
            case 2:
                getPenarikanGiro();
                getRekeningGiro();
                break;
            case 3:
                getSetorGiro();
                getRekeningGiro();
                break;
            case 4:
                System.out.println("Terimakasih Telah Menggunakan ATM.");
                getAccountType();
            default:
                System.out.println("\nInputan yang Anda Masukan Salah.");
                getRekeningGiro();
        }
    }
    // Tabungan
    public void getTabungan() {
        System.out.println("Tabungan Menu :");
        System.out.println("1. Lihat Saldo");
        System.out.println("2. Tarik Uang");
        System.out.println("3. Setor Uang");
        System.out.println("4. Keluar");
        System.out.print("Masukan Pilihan : ");
        int pilihan = Input.nextInt();
        switch (pilihan) {
            case 1:
                System.out.println("Lihat Saldo : " + formatUang.format(getSaldoTabungan()));
                getTabungan();
                break;
            case 2:
                getPenarikanTabungan();
                getTabungan();
                break;
            case 3:
                getSetorTabungan();
                getTabungan();
                break;
            case 4:
                System.out.println("Terimakasih Telah Menggunakan ATM.");
                getAccountType();
            default:
                System.out.println("\nInputan yang Anda Masukan Salah.");
                getTabungan();
        }
    }
}
