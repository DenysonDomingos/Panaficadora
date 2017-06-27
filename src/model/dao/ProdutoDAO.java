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
import model.bean.Produto;

/**
 *
 * @author deny_domin
 */
public class ProdutoDAO {
    
    public void create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        
        try {
            stnt = con.prepareStatement("INSERT INTO Produto (Nome, Preco) VALUES (?, ?)");
            stnt.setString(1, p.getNome());
            stnt.setDouble(2, p.getPreco());
            
            stnt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
    
    public List <Produto> read (){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stnt = con.prepareStatement("SELECT * FROM Produto");
            rs = stnt.executeQuery();
            
            while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("IDProduto"));
                produto.setNome(rs.getString("Nome"));
                produto.setPreco(rs.getDouble("Preco"));
                
                produtos.add(produto);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        
        return produtos;
    }
    
}
