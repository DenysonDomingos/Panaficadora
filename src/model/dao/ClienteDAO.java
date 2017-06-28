/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author deny_domin
 */
public class ClienteDAO {
    
    public void create(Cliente p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("INSERT INTO Cliente (Nome, Telefone, Documento) VALUES (?, ?, ?)");
            stnt.setString(1, p.getNome());
            stnt.setString(2, p.getTelefone());
            stnt.setString(3, p.getDocumento());
                                       
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
    
    public List <Cliente> read (){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stnt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stnt.executeQuery();
            
            while (rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("IDProduto"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setDocumento(rs.getString("Documento"));                                
                
                clientes.add(cliente);                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return clientes;
    }
    
    public void update(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("UPDATE Cliente SET Nome = ?, Telefone = ?, Documento = ? WHERE IDCliente =? ");
            stnt.setString(1, c.getNome());
            stnt.setString(2, c.getTelefone());
            stnt.setString(3, c.getDocumento());
            stnt.setInt(4, c.getId());
                                               
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
        public void delete(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("DELETE FROM Cliente WHERE IDCliente =? ");            
            stnt.setInt(1, c.getId());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }    
    }
}
