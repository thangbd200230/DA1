/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface DongSPRepository {
    List<DongSP> getAll();
    
    List<QLDongSP> getList();
    
    boolean add(DongSP dongSP);
    
    boolean update(DongSP dongSP, String ma);
    
    boolean delete(String ma);
}
