/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface MauSacService {
    List<MauSac> getAll();
    
    List<QLMauSac> getList();
    
    String add(MauSac mauSac);
    
    String update(MauSac mauSac,String ma);
    
    String delete(String ma);
}
