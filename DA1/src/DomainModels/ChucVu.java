/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author thang
 */
public class ChucVu {

    private String id;
    private String MaCV;
    private String ten;
    private int trangThai;

    public ChucVu() {
    }

    public ChucVu(String id, String MaCV, String ten, int trangThai) {
        this.id = id;
        this.MaCV = MaCV;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public ChucVu(String MaCV, String ten, int trangThai) {
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
