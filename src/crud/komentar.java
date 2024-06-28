package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class komentar {
    private String database_name = "muhammad_maulana_saputra_2210010682";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public komentar() {
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

    public void Simpan_komentar(String Nama, String Email, String isi_Komentar, String tanggal) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO komentar (Nama, Email, isi_Komentar, tanggal) VALUES (?, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nama);
                perintah.setString(2, Email);
                perintah.setString(3, isi_Komentar);
                perintah.setString(4, tanggal);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

 public void Ubah_komentar(String Nama, String Email, String isi_Komentar, String tanggal) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE komentar SET Nama=?, email=?, isi_komentar=? WHERE tanggal=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nama);
                perintah.setString(2, Email);
                perintah.setString(3, isi_Komentar);
                perintah.setString(4, tanggal);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_komentar(String Nama) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM komentar WHERE Nama=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nama);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
 public void GetNama(String Nama) {
            try {
                String sql = "select * from komentar where Nama=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);

                perintah.setString(1, Nama);
                
                ResultSet data = perintah.executeQuery();

                while (data.next()) {
                System.out.println("Nama: "+ data.getString("Nama"));
                System.out.println("Email: "+ data.getString("Email"));
                System.out.println("isi_Komentar: "+ data.getString("isi_Komentar"));
                System.out.println("tanggal: "+ data.getString("tanggal"));
            }
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
            public void GetRecord(){
                try {
                    String sql = "select * from komentar order by Nama asc"; 
                    Statement perintah = koneksiDB.createStatement();
                        
                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()) {
                        System.out.println( 
                        data.getString("Nama") + " | " +
                        data.getString("Email") + " | " +
                        data.getString("isi_Komentar") + " | " +
                        data.getString("tanggal")
                        );
                    }
//                perintah.setString(1, Nama);
//                perintah.setString(2, Email);
//                perintah.setString(3, isi_Komentar);
//                perintah.setString(4, tanggal)

                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
            public int JumlahRecord() {
                int jumlah = 0;
                try {
                    String sql = "select * from komentar order by Nama asc";
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