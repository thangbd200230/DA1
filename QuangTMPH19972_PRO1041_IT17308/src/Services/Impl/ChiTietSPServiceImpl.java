/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.ChiTietSP;
import Repositories.ChiTietSPRepository;
import Repositories.Impl.ChiTietSPRepositoryImpl;
import Services.ChiTietSPService;
import ViewModels.QLChiTietSP;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class ChiTietSPServiceImpl implements ChiTietSPService{

    private ChiTietSPRepository chiTietSPRepository=new ChiTietSPRepositoryImpl();
    @Override
    public List<QLChiTietSP> getAll() {
        return chiTietSPRepository.getAll();
    }

    @Override
    public List<QLChiTietSP> getOne(String ma) {
        return chiTietSPRepository.getOne(ma);
    }

    @Override
    public String add(ChiTietSP chiTietSP) {
        boolean testAdd=chiTietSPRepository.add(chiTietSP);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChiTietSP chiTietSP, String id) {
        boolean testUpdate=chiTietSPRepository.update(chiTietSP, id);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean testDelete=chiTietSPRepository.delete(id);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLChiTietSP> getList() {
        return chiTietSPRepository.getList();
    }

    @Override
    public boolean updateSoLuongSP(QLChiTietSP qLChiTietSP, String idCTSP) {
        return chiTietSPRepository.updateSoLuongSP(qLChiTietSP, idCTSP);
    }

    @Override
    public List<QLChiTietSP> getSoLuongById(String id) {
        return chiTietSPRepository.getSoLuongById(id);
    }

    @Override
    public List<QLChiTietSP> SearchTrangThai(int trangThai) {
      return chiTietSPRepository.SearchTrangThai(trangThai);
    }

 
    
}
