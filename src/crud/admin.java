package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admin {
    private String database_name = "muhammad_maulana_saputra_2210010682";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public admin() {
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

    public void Simpan_admin(String Nm_Admin, String Password) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO admin (Nm_Admin, Password) VALUES (?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Admin);
                perintah.setString(2, Password);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

 public void Ubah_admin(String Nm_Admin, String Password) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE admin SET Nm_Admin=? WHERE Password=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Admin);
                perintah.setString(2, Password);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_admin(String Nm_Admin) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM admin WHERE Nm_Admin=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, Nm_Admin);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
    public void GetNm_Admin(String Nm_Admin) {
            try {
                String sql = "select * from admin where Nm_Admin=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);

                perintah.setString(1, Nm_Admin);
                
                ResultSet data = perintah.executeQuery();

                while (data.next()) {
                System.out.println("Nm_Admin: "+ data.getString("Nm_Admin"));
                System.out.println("Password: "+ data.getString("Password"));
            }
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
            public void GetRecord(){
                try {
                    String sql = "select * from admin order by Nm_Admin asc"; 
                    Statement perintah = koneksiDB.createStatement();
                        
                    ResultSet data = perintah.executeQuery(sql);

                    while(data.next()) {
                        System.out.println( 
                        data.getString("Nm_Admin") + " | " +
                        data.getString("Password")
                        );
                    }
//                perintah.setString(1, Nm_Admin);
//                perintah.setString(2, Password);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
        }
            public int JumlahRecord() {
                int jumlah = 0;
                try {
                    String sql = "select * from admin order by Nm_Admin asc";
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