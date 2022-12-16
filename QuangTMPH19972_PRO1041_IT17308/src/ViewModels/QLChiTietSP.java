/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author truongmanhquang
 */
public class QLChiTietSP {
    private String id;
    private String maSP;
    private String tenSP;
    private String mauSac;
    private String chatLieu;
    private String kieuDang;
    private String kichCo;
    private String dongSP;
    private String NSX;
    private double giaBan;
    private double giaNhap;
    private int soLuong;
    private String moTa;
    private int trangThai;

    public QLChiTietSP() {
    }

    public QLChiTietSP(int soLuong) {
        this.soLuong = soLuong;
    }

    public QLChiTietSP(String maSP, String tenSP, String mauSac, String chatLieu, String kieuDang, String kichCo, String dongSP, String NSX, double giaBan, double giaNhap, int soLuong, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.kichCo = kichCo;
        this.dongSP = dongSP;
        this.NSX = NSX;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public QLChiTietSP(String id, String maSP, String tenSP, String mauSac, String chatLieu, String kieuDang, String kichCo, String dongSP, String NSX, double giaBan, double giaNhap, int soLuong, String moTa, int trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.kichCo = kichCo;
        this.dongSP = dongSP;
        this.NSX = NSX;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String inTrangThai(){
        if(trangThai==0){
            return "Còn hàng";
        }else{
            return "Hết hàng";
        }
    }
}
