/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author thang
 */
public class QLNhanVien {
    private String id;
    private String Ma;
    private String ten;
    private String tenDem;
    private String Ho;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private int trangThai;
    private String chucVu;

    public QLNhanVien() {
    }

    public QLNhanVien(String id, String Ma, String ten, String tenDem, String Ho, String gioiTinh, String ngaySinh, String sdt, String diaChi, int trangThai, String chucVu) {
        this.id = id;
        this.Ma = Ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.Ho = Ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
    }

    public QLNhanVien(String Ma, String ten, String tenDem, String Ho, String gioiTinh, String ngaySinh, String sdt, String diaChi, int trangThai, String chucVu) {
        this.Ma = Ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.Ho = Ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public String trangThaiIs(){
        if(trangThai==0){
            return "Đi làm";
        }else{
             return "Đã nghỉ việc";
        }
    }
    public Object[] todata(){
        return new Object[]{Ma,Ho+tenDem+ten,gioiTinh,ngaySinh,sdt,diaChi,trangThaiIs(),chucVu};
    }

    
}
