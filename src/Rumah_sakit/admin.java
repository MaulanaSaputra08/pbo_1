zpackage Rumah_sakit;

public class admin extends apotik {
    String nama, email, password;
    
    public admin() {}
    
    public admin(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }
        
    public void inputNama(String nama) {
        this.nama = nama;
    }
    
    public String NamaAdmin() {
        return this.nama;
    }
    
    public void inputEmail(String email) {
        this.email = email;
    }
    
    public String EmailAdmin() {
        return this.email;
    }
    
    public void inputPassword(String password) {
        this.password = password;
    }
    
    public String PasswordAdmin() {
        return this.password;
    }
}