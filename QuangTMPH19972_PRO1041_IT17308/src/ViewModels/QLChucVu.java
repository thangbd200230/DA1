/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author thang
 */
public class QLChucVu {
    private String id;
    private String MaCV;
    private String ten;
    private int trangThai;

    public QLChucVu() {
    }

    public QLChucVu(String id, String MaCV, String ten, int trangThai) {
        this.id = id;
        this.MaCV = MaCV;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public QLChucVu(String MaCV, String ten, int trangThai) {
        this.MaCV = MaCV;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
