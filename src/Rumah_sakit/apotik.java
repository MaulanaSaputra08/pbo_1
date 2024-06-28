/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rumah_sakit;

/**
 *
 * @author ASUS X465U
 */
public class apotik {
    String nama, alamat, telp, hari, jam;
    int namaApotik, alamatApotik, telepon, hariBuka, jamBuka;

    public apotik() {}

   public void namaApotik(String nama) {
        this.nama = nama;
    }

    public int namaApotik() {
        this.namaApotik = 0;
        if (this.nama.equals("1")) {
            this.namaApotik = 1;
        } else if (this.nama.equals("2")) {
            this.namaApotik = 2;
        } else {
            this.namaApotik = 3;
        }
        return this.namaApotik;
    }


   public void alamatApotik(String alamat) {
        this.alamat = alamat;
    }

    public int alamatApotik() {
        this.alamatApotik = 0;
        if (this.alamat.equals("1")) {
            this.alamatApotik = 1;
        } else if (this.alamat.equals("2")) {
            this.alamatApotik = 2;
        } else {
            this.alamatApotik = 3;
        }
        return this.alamatApotik;
    }
    
     public void telepon(String telp) {
        this.telp = telp;
    }

    public int telepon() {
        this.telepon = 0;
        if (this.telp.equals("1")) {
            this.telepon = 1;
        } else if (this.telp.equals("2")) {
            this.telepon = 2; 
        } else {
            this.telepon = 3;
        }
        return this.telepon;
    }

   public void hariBuka(String hari) {
        this.hari = hari;
    }

    public int hariBuka() {
        this.hariBuka = 0;
        if (this.hari.equals("1")) {
            this.hariBuka = 1;
        } else if (this.hari.equals("2")) {
            this.hariBuka = 2;
        } else {
            this.hariBuka = 3;
        }
        return this.hariBuka;
    }
    
    public void jamBuka(String jam) {
        this.jam = jam;
    }

    public int jamBuka() {
        this.jamBuka = 0;
        if (this.jam.equals("1")) {
            this.jamBuka = 1;
        } else if (this.jam.equals("2")) {
            this.jamBuka = 2;
        } else {
            this.jamBuka = 3;
        }
        return this.jamBuka;
    }
    
    public String getNamaApotikString() {
        switch (this.namaApotik) {
            case 1:
                return "K24";
            case 2:
                return "Apotik farma";
            case 3:
                return "Apotik melia";
            default:
                return "Unknown";
        }   
    }
    public String getAlamatApotikString() {
        switch (this.alamatApotik) {
            case 1:
                return "basirih";
            case 2:
                return "kelayan";
            case 3:
                return "pekauman";
            default:
                return "Unknown";
        }   
    }
    public String getTeleponString() {
        switch (this.telepon) {
            case 1:
                return "089865476454";
            case 2:
                return "085437865234";
            case 3:
                return "089765477654";
            default:
                return "Unknown";
        }   
    }
    public String getHariBukaString() {
        switch (this.hariBuka) {
            case 1:
                return "senin-rabu";
            case 2:
                return "sabtu-minggu";
            case 3:
                return "senin-jum'at";
            default:
                return "Unknown";
        }   
    }
    public String getJamBukaString() {
        switch (this.jamBuka) {
            case 1:
                return "08.00-17.00";
            case 2:
                return "09.00.22.00";
            case 3:
                return "07.00-12.00";
            default:
                return "Unknown";
        }   
    }
    
}