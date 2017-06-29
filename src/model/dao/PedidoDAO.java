/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Pedido;

/**
 *
 * @author deny_domin
 */
public class PedidoDAO {
    
    public void create(Pedido p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("INSERT INTO Pedido (IDProduto, IDVenda, Quantidade) VALUES (?, ?, ?)");
            stnt.setInt(1, p.getIdProduto());
            stnt.setInt(2, p.getIdVenda());
            stnt.setInt(3, p.getQuantidade());
                                       
            
            stnt.executeUpdate();                        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
}
