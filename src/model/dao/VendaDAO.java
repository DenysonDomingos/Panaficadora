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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Venda;

/**
 *
 * @author deny_domin
 */
public class VendaDAO {

    public int create(Venda v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        int idVenda = 0;

        try {
            stnt = con.prepareStatement("INSERT INTO Venda (IDCliente, ValorTotal) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            stnt.setInt(1, v.getIdCliente());
            stnt.setDouble(2, v.getValorTotal());

            stnt.executeUpdate();
            
            rs = stnt.getGeneratedKeys();

            if (rs.next() && rs != null) {
                idVenda = rs.getInt(1);
            } else {
                System.out.println("No, Nop nada");
            }           

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
        return idVenda;
    }
}
