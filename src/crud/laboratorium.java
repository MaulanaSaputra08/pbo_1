package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class laboratorium {
    private String database_name = "muhammad_maulana_saputra_2210010682";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public laboratorium() {
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

    public void Simpan_laboratorium(String Nm_Lab, String Alamat, String Tlp) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO laboratorium (Nm_Lab, Alamat, Tlp) VALUES (?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Lab);
                perintah.setString(2, Alamat);
                perintah.setString(3, Tlp);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

 public void Ubah_laboratorium(String Nm_Lab, String Alamat, String Tlp) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE laboratorium SET Nm_Lab=?, alamat=? WHERE Tlp=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Lab);
                perintah.setString(2, Alamat);
                perintah.setString(3, Tlp);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_laboratorium(String Alamat) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM laboratorium WHERE nama_alamat=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Alamat);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
public void GetNm_Lab(String Nm_Lab) {
            try {
                String sql = "select * from laboratorium where Nm_Lab=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);

                perintah.setString(1, Nm_Lab);
                
                ResultSet data = perintah.executeQuery();

                while (data.next()) {
                System.out.println("Nm_Lab: "+ data.getString("Nm_Lab"));
                System.out.println("Alamat: "+ data.getString("Alamat"));
                System.out.println("Tlp: "+ data.getString("Tlp"));
            }
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
            public void GetRecord(){
                try {
                    String sql = "select * from Laboratorium order by Nm_Lab asc"; 
                    Statement perintah = koneksiDB.createStatement();
                        
                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()) {
                        System.out.println( 
                        data.getString("Nm_Lab") + " | " +
                        data.getString("Alamat") + " | " +
                        data.getString("Tlp")
                        );
                    }
//                perintah.setString(1, Nm_Lab);
//                perintah.setString(2, Alamat);
//                perintah.setString(3, Tlp);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
            public int JumlahRecord() {
                int jumlah = 0;
                try {
                    String sql = "select * from laboratorium order by Nm_Lab asc";
                    Statement perintah = koneksiDB.createStatement();

                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()){
                        jumlah = jumlah + 1;
                    }
                } catch (Exception e) {
                System.out.println(e.getMessage());
                }
                return jumlah;
            }
        }