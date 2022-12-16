/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author truongmanhquang
 */
public class TaiKhoan {
    private String id;
    private String taiKhoan;
    private String matKhau;
    private String newPass;
    private String cfnPass;
    private int trangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String matKhau, String newPass, String cfnPass) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.newPass = newPass;
        this.cfnPass = cfnPass;
    }

    public TaiKhoan(String id, String taiKhoan, String matKhau, int trangThai) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
