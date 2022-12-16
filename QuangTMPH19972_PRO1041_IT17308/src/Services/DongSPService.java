/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface DongSPService {
    List<DongSP> getAll();
    
    List<QLDongSP> getList();
    
    String add(DongSP dongSP);
    
    String update(DongSP dongSP,String ma);
    
    String delete(String ma);
}
