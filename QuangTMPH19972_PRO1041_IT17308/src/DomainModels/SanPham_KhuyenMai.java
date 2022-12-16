/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author truongmanhquang
 */
public class SanPham_KhuyenMai {
    private String id;
    private String idKM;
    private String idCTSP;
    private Double donGia;
    private Double donGiaSauKhiGiam;
    private int trangThai;

    public SanPham_KhuyenMai() {
    }

    public SanPham_KhuyenMai(String idKM, String idCTSP) {
        this.idKM = idKM;
        this.idCTSP = idCTSP;
    }

    public SanPham_KhuyenMai(String idKM, String idCTSP, int trangThai) {
        this.idKM = idKM;
        this.idCTSP = idCTSP;
        this.trangThai = trangThai;
    }

    public SanPham_KhuyenMai(String id, String idKM, String idCTSP, Double donGia, Double donGiaSauKhiGiam, int trangThai) {
        this.id = id;
        this.idKM = idKM;
        this.idCTSP = idCTSP;
        this.donGia = donGia;
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDonGiaSauKhiGiam() {
        return donGiaSauKhiGiam;
    }

    public void setDonGiaSauKhiGiam(Double donGiaSauKhiGiam) {
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
