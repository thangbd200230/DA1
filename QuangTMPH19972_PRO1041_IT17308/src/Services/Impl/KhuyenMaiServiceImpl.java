/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.KhuyenMai;
import Repositories.Impl.KhuyenMaiRepositoryImpl;
import Repositories.KhuyenMaiRepository;
import Services.KhuyenMaiService;
import ViewModels.QLKhuyenMai;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService{

     private KhuyenMaiRepository khuyenMaiRepository=new KhuyenMaiRepositoryImpl();
    @Override
    public List<QLKhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }

    @Override
    public List<QLKhuyenMai> getOne(String ma) {
        return khuyenMaiRepository.getOne(ma);
    }

    @Override
    public String add(KhuyenMai km) {
        boolean testAdd=khuyenMaiRepository.add(km);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai km, String ma) {
        boolean testAdd=khuyenMaiRepository.update(km, ma);
        if(testAdd){
            return "Cập nhật thành công";
        }else{
            return "Cập nhật thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testAdd=khuyenMaiRepository.delete(ma);
        if(testAdd){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLKhuyenMai> getSearchLoaiKMPT(int loaiKM) {
        return khuyenMaiRepository.getSearchLoaiKMPT(loaiKM);
    }

    @Override
    public List<QLKhuyenMai> getSearchTTNHD(int trangThai) {
        return khuyenMaiRepository.getSearchTTNHD(trangThai);
    }

    @Override
    public List<QLKhuyenMai> getSearchLoaiKMTien(int loaiKM) {
        return khuyenMaiRepository.getSearchLoaiKMTien(loaiKM);
    }

    @Override
    public List<QLKhuyenMai> getSearchTTCHD(int trangThai) {
        return khuyenMaiRepository.getSearchTTCHD(trangThai);
    }

    @Override
    public List<QLKhuyenMai> getList() {
        return khuyenMaiRepository.getList();
    }
    
}
