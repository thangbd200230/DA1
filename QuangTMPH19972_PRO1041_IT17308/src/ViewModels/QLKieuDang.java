/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author truongmanhquang
 */
public class QLKieuDang {
    private String ma;
    private String ten;
    private int trangThai;

    public QLKieuDang() {
    }

    public QLKieuDang(String ma, String ten, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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
    
    public String inTrangThai(){
        if(trangThai==0){
            return "Còn hoạt động";
        }else{
            return "Ngừng hoạt động";
        }
    }
}
