/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import ViewModels.QLChatLieu;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface ChatLieuService {
    List<ChatLieu> getAll();
    
    List<QLChatLieu> getList();
    
    String add(ChatLieu chatLieu);
    
    String update(ChatLieu chatLieu,String ma);
    
    String delete(String ma);
}
