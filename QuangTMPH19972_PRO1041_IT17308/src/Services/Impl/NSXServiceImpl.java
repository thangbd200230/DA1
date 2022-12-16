/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NSX;
import Repositories.Impl.NSXRepositoryImpl;
import Repositories.NSXRepository;
import Services.NSXService;
import ViewModels.QLNSX;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class NSXServiceImpl implements NSXService{

    private NSXRepository nSXRepository=new NSXRepositoryImpl();
    @Override
    public List<NSX> getAll() {
        return nSXRepository.getAll();
    }

    @Override
    public String add(NSX nSX) {
        boolean testAdd=nSXRepository.add(nSX);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NSX nSX, String ma) {
        boolean testUpdate=nSXRepository.update(nSX, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =nSXRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLNSX> getList() {
        return nSXRepository.getList();
    }
    
}
