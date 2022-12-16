/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.TaiKhoan;
import Repositories.Impl.TaiKhoanRepositoryImpl;
import Repositories.TaiKhoanRepository;
import Services.TaiKhoanService;

/**
 *
 * @author truongmanhquang
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{

    private TaiKhoanRepository taiKhoanRepository=new TaiKhoanRepositoryImpl();
    @Override
    public TaiKhoan getOne(String name) {
        return taiKhoanRepository.getOne(name);
    }

    @Override
    public boolean checkLogin(String userName, String pass) {
        return taiKhoanRepository.checkLogin(userName, pass);
    }

    @Override
    public boolean update(TaiKhoan tk, String tenTK) {
        return taiKhoanRepository.update(tk, tenTK);
    }
    
}
