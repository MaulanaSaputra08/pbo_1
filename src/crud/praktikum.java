/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ASUS X465U
 */
public class praktikum {
    private String database_name = "uji_koding";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 
    
    public praktikum() {
        try {
            String lokasi = "jdbc:mysql://localhost:3306/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
 public void Simpan_praktikum(String npm, double ips_1, double ips_2, double ipk) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO praktikum (npm, ips_1, ips_2, ipk) VALUES (?, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, npm);
                perintah.setDouble(2, ips_1);
                perintah.setDouble(3, ips_2);
                perintah.setDouble(4, ipk);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
 public void Ubah_praktikum(String npm, double ips_1, double ips_2, double ipk) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE praktikum SET npm=?, ips_1=?, ips_2 WHERE ipk=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, npm);
                perintah.setDouble(2, ips_1);
                perintah.setDouble(3, ips_2);
                perintah.setDouble(4, ipk);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
 public void Hapus_praktikum(String npm) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM praktikum WHERE npm=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, npm);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
 public void GetNpm(String npm) {
            try {
                String sql = "select * from praktikum where npm=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);

                perintah.setString(1, npm);
                
                ResultSet data = perintah.executeQuery();

                while (data.next()) {
                System.out.println("npm: "+ data.getString("npm"));
                System.out.println("ips_1: "+ data.getDouble("ips_1"));
                System.out.println("ips_2: "+ data.getDouble("ips_2"));
                System.out.println("ipk: "+ data.getDouble("ipk"));
//                System.out.println("npm: "+ data.getString("npm"));
//                System.out.println("ips_1: "+ data.getString("ips_1"));
//                System.out.println("ips_2: "+ data.getString("ips_2"));
//                System.out.println("ipk: "+ data.getString("ipk"));
            }
                } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
            public void GetRecord(){
                try {
                    String sql = "select * from praktikum order by npm asc"; 
                    Statement perintah = koneksiDB.createStatement();
                        
                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()) {
                        System.out.println( 
                        data.getString("npm") + " | " +
                        data.getDouble("ips_1") + " | " +
                        data.getDouble("ips_2") + " | " +
                        data.getDouble("ipk")
                        );
                    }
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
        }
            public int JumlahRecord() {
                int jumlah = 0;
                try {
                    String sql = "select * from praktikum order by npm asc";
                    Statement perintah = koneksiDB.createStatement();

                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()){
                        jumlah = jumlah + 1;
                    }
                } catch (SQLException e) {
                System.out.println(e.getMessage());
                }
                return jumlah;
            }
        }
