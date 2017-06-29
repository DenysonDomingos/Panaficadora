/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author Douglas
 */
public class ConsultarProduto extends javax.swing.JFrame{

    /**
     * Creates new form ConsultarProduto
     */
    public ConsultarProduto() {
        initComponents();
        
        readJTable();
    }
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        for (Produto p: pdao.read()){
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco()
            });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lProdutos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lProdutos.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lProdutos.setText("Produtos");

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lProdutos)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lProdutos)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lProdutos;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables

 
}
