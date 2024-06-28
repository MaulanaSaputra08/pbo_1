package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class apotik {
    private String database_name = "muhammad_maulana_saputra_2210010682";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public apotik() {
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

    public void Simpan_apotik(String Nm_Apotik, String Alamat, String Telp, String Hari_buka, String Jam_buka) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO apotik (Nm_Apotik, Alamat, Telp, Hari_buka, Jam_buka) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Apotik);
                perintah.setString(2, Alamat);
                perintah.setString(3, Telp);
                perintah.setString(4, Hari_buka);
                perintah.setString(5, Jam_buka);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

 public void Ubah_apotik(String Nm_Apotik, String Alamat, String Telp, String Hari_buka, String Jam_buka) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE apotik SET Alamat=?, Telp=?, Hari_buka=?, Jam_buka=? WHERE Nm_Apotik=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Apotik);
                perintah.setString(2, Alamat);
                perintah.setString(3, Telp);
                perintah.setString(4, Hari_buka);
                perintah.setString(5, Jam_buka);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_apotik(String Nm_Apotik) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM apotik WHERE Nm_Apotik=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Apotik);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
 public void GetNm_Apotik(String Nm_Apotik) {
            try {
                String sql = "select * from apotik where Nm_Apotik=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);

                perintah.setString(1, Nm_Apotik);
                
                ResultSet data = perintah.executeQuery();

                while (data.next()) {
                System.out.println("Nm_Apotik: "+ data.getString("Nm_Apotik"));
                System.out.println("Alamat: "+ data.getString("Alamat"));
                System.out.println("Telp: "+ data.getString("Telp"));
                System.out.println("Hari_Buka: "+ data.getString("Hari_Buka"));
                System.out.println("Jam_Buka: "+ data.getString("Jam_Buka"));
            }
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
            public void GetRecord(){
                try {
                    String sql = "select * from apotik order by Nm_Apotik asc"; 
                    Statement perintah = koneksiDB.createStatement();
                        
                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()) {
                        System.out.println( 
                        data.getString("Nm_Apotik") + " | " +
                        data.getString("Alamat") + " | " +
                        data.getString("Hari_Buka") + " | " +
                        data.getString("Jam_Buka") + " | " +
                        data.getString("Telp")
                        );
                    }
//                perintah.setString(1, Nm_Apotik);
//                perintah.setString(2, Alamat);
//                perintah.setString(3, Telp);
//                perintah.setString(4, Hari_buka);
//                perintah.setString(5, Jam_buka);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
            public int JumlahRecord() {
                int jumlah = 0;
                try {
                    String sql = "select * from apotik order by Nm_Apotik asc";
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