/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BusinessModelLayer.Categorias;
import BusinessModelLayer.Sucursales;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos D
 */
public class frmCategorias extends javax.swing.JInternalFrame {

    Categorias categoria = new Categorias();

    public frmCategorias() {
        initComponents();
        jtCategorias.setModel(new Categorias().GetAllModelNew());

        for (int i = 0; i < categoria.GetAllModel().getColumnCount(); i++) {
            cbColumna.addItem(categoria.GetAllModel().getColumnName(i).toString());
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

        jToolBar1 = new javax.swing.JToolBar();
        bActualizar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bOrdenar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbColumna = new javax.swing.JComboBox<>();
        cbBusqueda = new javax.swing.JComboBox<>();
        bBuscar = new javax.swing.JButton();
        tCategorias = new javax.swing.JScrollPane();
        jtCategorias = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categorias");
        setVisible(true);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        bActualizar.setText("Actualizar");
        bActualizar.setFocusable(false);
        bActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });
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

        jLabel1.setText("Buscar por:");
        jToolBar1.add(jLabel1);

        cbColumna.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbColumnaItemStateChanged(evt);
            }
        });
        cbColumna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbColumnaMouseExited(evt);
            }
        });
        jToolBar1.add(cbColumna);

        jToolBar1.add(cbBusqueda);

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

        jtCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        tCategorias.setViewportView(jtCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        frmNCategorias obj = new frmNCategorias();
        obj.setTitle("Nueva Categoria");
        obj.setModal(true);
        obj.setVisible(true);

        jtCategorias.setModel(new Categorias().GetAllModelNew());
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        if (jtCategorias.getSelectedRow() >= 0) {
            int idProducto = (int) jtCategorias.getValueAt(jtCategorias.getSelectedRow(), 0);
            frmNCategorias obj = new frmNCategorias(idProducto);
            obj.setTitle("Modificar Categoria");
            obj.setModal(true);
            obj.setVisible(true);
            jtCategorias.setModel(new Categorias().GetAllModelNew());

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un producto");
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenarActionPerformed
        jtCategorias.setModel(categoria.GetAllOrderBy());
    }//GEN-LAST:event_bOrdenarActionPerformed

    private void cbColumnaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbColumnaItemStateChanged
        int selected = 0;

        cbBusqueda.removeAllItems();

        selected = cbColumna.getSelectedIndex();
        System.out.println(cbColumna.getSelectedIndex() + 1);
        for (int i = 0; i < categoria.GetAllModel().getRowCount(); i++) {

            cbBusqueda.addItem(categoria.GetAllModel().getValueAt(i, selected).toString());

        }
    }//GEN-LAST:event_cbColumnaItemStateChanged

    private void cbColumnaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbColumnaMouseExited

    }//GEN-LAST:event_cbColumnaMouseExited

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        jtCategorias.setModel(categoria.Search(cbColumna.getSelectedItem().toString(), cbBusqueda.getSelectedItem().toString()));
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        if (jtCategorias.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar este elemento?", "Eliminar", JOptionPane.YES_NO_OPTION) < 1) {
                int idProducto = (int) jtCategorias.getValueAt(jtCategorias.getSelectedRow(), 0);
                Categorias obj = new Categorias();
                obj.setIdCategoria(idProducto);
                if (obj.Delete()) {
                    JOptionPane.showMessageDialog(this, "Producto eliminado");
                }
                jtCategorias.setModel(obj.GetAllModel());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un producto");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        Categorias obj = new Categorias();
        jtCategorias.setModel(obj.GetAllModelNew());
    }//GEN-LAST:event_bActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bOrdenar;
    private javax.swing.JComboBox<String> cbBusqueda;
    private javax.swing.JComboBox<String> cbColumna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtCategorias;
    private javax.swing.JScrollPane tCategorias;
    // End of variables declaration//GEN-END:variables
}