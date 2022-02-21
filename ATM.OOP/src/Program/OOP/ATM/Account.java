/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Program.OOP.ATM;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {
    private String NamaUser;
    private int PinUser;
    private double SaldoGiro;
    private double SaldoTabungan;

//    public Account(int NomorUser, int PinUser, double SaldoGiro, double SaldoTabungan) {
//        this.NomorUser = NomorUser;
//        this.PinUser = PinUser;
//        this.SaldoGiro = SaldoGiro;
//        this.SaldoTabungan = SaldoTabungan;
//    }
    
    Scanner input = new Scanner(System.in);
    //format uang.
    DecimalFormat formatUang = new DecimalFormat("'Rp '###,###.00");
// setter dan getter untuk User dan Pin

    public String getNamaUser() {
        return NamaUser;
    }

    public String setNamaUser(String NamaUser) {
        this.NamaUser = NamaUser;
        return NamaUser;
    }

    public int getPinUser() {
        return PinUser;
    }

    public int setPinUser(int PinUser) {
        this.PinUser = PinUser;
        return PinUser;
    }
// Saldi Tabunfan dan Giro
    public double getSaldoGiro() {
        return SaldoGiro;
    }

    public double getSaldoTabungan() {
        return SaldoTabungan;
    }
// Menghitung Tarik dan Setor dari masing-masing jenis akun.
    public double hitungTarikGiro(double jumlah)  {
        SaldoGiro = (SaldoGiro - jumlah);
        return SaldoGiro;
    }
    
    public double hitungTarikTabungan(double jumlah){
        SaldoTabungan = (SaldoTabungan - jumlah);
        return SaldoTabungan;
    }
    
    public double hitungSetorGiro(double jumlah){
        SaldoGiro = (SaldoGiro + jumlah);
        return SaldoGiro;
    }
    
    public double hitungSetorTabungan(double jumlah){
        SaldoTabungan = (SaldoTabungan + jumlah);
        return SaldoTabungan;
    }
// Akhir perhitungan Tarik dan Setor.
    public void getPenarikanGiro() {
        System.out.println("Saldo pada Rekening Giro : " + formatUang.format(SaldoGiro));
        System.out.print("Jumlah Penarikan : ");
        double jumlah = input.nextDouble();
        if ((SaldoGiro - jumlah) >= 0) {
            hitungTarikGiro(jumlah);
            System.out.println("Sisa Saldo Anda : " + formatUang.format(SaldoGiro));
        } else {
            System.out.println("Saldo Anda Todak Mencukupi.");
        }
    }
    public void getPenarikanTabungan() {
        System.out.println("Saldo pada Rekening Anda : " + formatUang.format(SaldoTabungan));
        System.out.print("Masukan Jumlah Penarikan : ");
        double jumlah = input.nextDouble();
        if ((SaldoTabungan - jumlah) >= 0) {
            hitungTarikTabungan(jumlah);
            System.out.println("Sisa Saldo Anda : " + formatUang.format(SaldoTabungan));
        } else {
            System.out.println("Saldo Anda Tidak Mencukupi.");
        }
    }
    public void getSetorGiro(){
        System.out.println("Saldo pada Rekening Giro : " + formatUang.format(SaldoGiro));
        System.out.print("Masukan Jumlah Setoran : ");
        double jumlah = input.nextDouble();
        if ((SaldoGiro + jumlah) >= 0) {
            hitungSetorGiro(jumlah);
            System.out.println("Saldo yang Anda : " + formatUang.format(SaldoGiro));
        } else {
            System.out.println("Nilai Tidak Boleh Negativ.");
        }
    }
    public void getSetorTabungan() {
        System.out.println("Saldo Pada Tabungan : " + formatUang.format(SaldoTabungan));
        System.out.print("Masukan Jumlah Setoran : ");
        double jumlah = input.nextDouble();
        if ((SaldoTabungan + jumlah) >= 0) {
            hitungSetorTabungan(jumlah);
            System.out.println("Saldo Anda : " + formatUang.format(SaldoTabungan));
        } else {
            System.out.println("Nilai Tidak Boleh Negativ.");
        }
    }
}
