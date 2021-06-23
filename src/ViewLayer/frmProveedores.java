/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BusinessModelLayer.Categorias;
import BusinessModelLayer.Proveedores;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos D
 */
public class frmProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form Proveedores
     */
    Proveedores proveedores = new Proveedores();
    public frmProveedores() {
        initComponents();
        jtProveedores.setModel(new Proveedores().GetAllModelNew());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tProveedores = new javax.swing.JScrollPane();
        jtProveedores = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        bActualizar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bOrdenar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proveedores");
        setVisible(true);

        jtProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tProveedores.setViewportView(jtProveedores);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        bActualizar.setText("Actualizar");
        bActualizar.setFocusable(false);
        bActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bActualizar);

        bNuevo.setText("Nuevo");
        bNuevo.setFocusable(false);
        bNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(bNuevo);

        bModificar.setText("Modificar");
        bModificar.setFocusable(false);
        bModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(bModificar);

        bEliminar.setText("Eliminar");
        bEliminar.setFocusable(false);
        bEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(bEliminar);

        bOrdenar.setText("Ordenar");
        bOrdenar.setFocusable(false);
        bOrdenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bOrdenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenarActionPerformed(evt);
            }
        });
        jToolBar1.add(bOrdenar);

        bBuscar.setText("Buscar");
        bBuscar.setFocusable(false);
        bBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(bBuscar);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jToolBar1.add(txtBuscar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        frmNProveedor obj = new frmNProveedor();
        obj.setTitle("Nuevo Proveedor");
        obj.setModal(true);
        obj.setVisible(true);
        
        jtProveedores.setModel(new Proveedores().GetAllModelNew());
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        if (jtProveedores.getSelectedRow() >= 0) {
            int idProducto = (int) jtProveedores.getValueAt(jtProveedores.getSelectedRow(), 0);
            frmNProveedor obj = new frmNProveedor(idProducto);
            obj.setTitle("Modificar Proveedor");
            obj.setModal(true);
            obj.setVisible(true);
            jtProveedores.setModel(new Proveedores().GetAllModelNew());

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un proveedor");
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenarActionPerformed
                jtProveedores.setModel(proveedores.GetAllOrderBy());
    }//GEN-LAST:event_bOrdenarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
                if (jtProveedores.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar este elemento?", "Eliminar", JOptionPane.YES_NO_OPTION) < 1) {
                int idProducto = (int) jtProveedores.getValueAt(jtProveedores.getSelectedRow(), 0);
                Proveedores obj = new Proveedores();
                obj.setIdProveedor(idProducto);
                if (obj.Delete()) {
                    JOptionPane.showMessageDialog(this, "Proveedor eliminado");
                }
                jtProveedores.setModel(obj.GetAllModelNew());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un proveedor");
        }


    }//GEN-LAST:event_bEliminarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        if (txtBuscar.getText().isEmpty() == false) {
            System.out.println(proveedores.Search(txtBuscar.getText()).getRowCount());

            if(proveedores.Search(txtBuscar.getText()).getRowCount() > 0){
                jtProveedores.setModel(proveedores.Search(txtBuscar.getText()));
            }else{
                JOptionPane.showMessageDialog(this, "El registro no existe");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar una palabra");
        }

    }//GEN-LAST:event_bBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(txtBuscar.getText().isEmpty()){
            jtProveedores.setModel(proveedores.GetAllModelNew());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bOrdenar;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtProveedores;
    private javax.swing.JScrollPane tProveedores;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
