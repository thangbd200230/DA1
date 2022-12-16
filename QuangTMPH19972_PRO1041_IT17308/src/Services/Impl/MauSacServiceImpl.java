/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.MauSac;
import Repositories.Impl.MauSacRepositoryImpl;
import Repositories.MauSacRepository;
import Services.MauSacService;
import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class MauSacServiceImpl implements MauSacService{

    private MauSacRepository mauSacRepository=new MauSacRepositoryImpl();
    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public String add(MauSac mauSac) {
        boolean testAdd=mauSacRepository.add(mauSac);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(MauSac mauSac, String ma) {
        boolean testUpdate=mauSacRepository.update(mauSac, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =mauSacRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLMauSac> getList() {
        return mauSacRepository.getList();
    }
    
}
