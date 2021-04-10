/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BusinessModelLayer.Producto;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Carlos D
 */
public class frmProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProductos
     */
    public frmProductos() {
        initComponents();
        jtProductos.setModel(new Producto().GetAllModel());
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
        Nuevo = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        ScrollPanel = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
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

        Nuevo.setText("Nuevo");
        Nuevo.setFocusable(false);
        Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(Nuevo);

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

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductos.getTableHeader().setReorderingAllowed(false);
        ScrollPanel.setViewportView(jtProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        frmNProducto obj = new frmNProducto();
        obj.setTitle("Nuevo Producto");
        obj.setModal(true);
        obj.setVisible(true);
        jtProductos.setModel(new Producto().GetAllModel());
    }//GEN-LAST:event_NuevoActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        if (jtProductos.getSelectedRow() >= 0) {
            int idProducto = (int) jtProductos.getValueAt(jtProductos.getSelectedRow(), 0);
            frmNProducto obj = new frmNProducto(idProducto);
            obj.setTitle("Modificar Producto");
            obj.setModal(true);
            obj.setVisible(true);
            jtProductos.setModel(new Producto().GetAllModel());

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un producto");
        }


    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed

        if (jtProductos.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this, "¿Desea eliminar este elemento?", "Eliminar", JOptionPane.YES_NO_OPTION) < 1) {
                int idProducto = (int) jtProductos.getValueAt(jtProductos.getSelectedRow(), 0);
                Producto obj = new Producto();
                obj.setIdProducto(idProducto);
                if (obj.Delete()) {
                    JOptionPane.showMessageDialog(this, "Producto eliminado");
                }
                jtProductos.setModel(obj.GetAllModel());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un producto");
        }


    }//GEN-LAST:event_bEliminarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        Producto obj = new Producto();
        obj.GetAllModel();
    }//GEN-LAST:event_bActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nuevo;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
}
