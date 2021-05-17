/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BusinessModelLayer.Productos;
import BusinessModelLayer.ProductosProveedores;
import BusinessModelLayer.Proveedores;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos D
 */
public class frmProductoPorveedor extends javax.swing.JInternalFrame {

    Productos producto = new Productos();
    Proveedores proveedor = new Proveedores();
    ProductosProveedores pp = new ProductosProveedores();
    public frmProductoPorveedor() {
        initComponents();
        
        tProductoProveedor.setModel(pp.GetAllModelNew());
        
        for (int i = 0; i < producto.GetAllModel().getRowCount(); i++) {
            cbProducto.addItem(producto.GetAllModel().getValueAt(i, 1).toString());
        }
        
        for (int i = 0; i < proveedor.GetAllModel().getRowCount(); i++) {
            cbProveedor.addItem(proveedor.GetAllModel().getValueAt(i, 1).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tProductoProveedor = new javax.swing.JTable();
        bAgregar = new javax.swing.JButton();
        cbProveedor = new javax.swing.JComboBox<>();
        cbProducto = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proveedores - Productos");
        setVisible(true);

        tProductoProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tProductoProveedor);

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAgregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        int idProveedor = 0;

        for (int i = 0; i < proveedor.GetAllModel().getRowCount(); i++) {
            if (cbProveedor.getSelectedItem().equals(proveedor.GetAllModel().getValueAt(i, 1))) {
                idProveedor = (int) proveedor.GetAllModel().getValueAt(i, 0);
                System.out.println(proveedor.GetAllModel().getValueAt(i, 0));
            }
        }
        
        int idProducto = 0;
        for (int i = 0; i < producto.GetAllModel().getRowCount(); i++) {
            if (cbProducto.getSelectedItem().equals(producto.GetAllModel().getValueAt(i, 1))) {
                idProducto = (int) producto.GetAllModel().getValueAt(i, 0);
                System.out.println(producto.GetAllModel().getValueAt(i, 0));
            }
        }

        if (new ProductosProveedores(0, idProducto, idProveedor).Asignar()) {
            
        }else{
        JOptionPane.showMessageDialog(this, "Elemento agregado correctamente");        }
        
        
        tProductoProveedor.setModel(pp.GetAllModelNew());
    }//GEN-LAST:event_bAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JComboBox<String> cbProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tProductoProveedor;
    // End of variables declaration//GEN-END:variables
}