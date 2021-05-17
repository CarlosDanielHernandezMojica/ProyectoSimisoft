/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos D
 */
public class ProductosProveedores {

    private DataAccess dataAcces = DataAccess.instance();
    private int idProductoProveedor;
    private int idProducto;
    private int idProveedor;

    public ProductosProveedores() {
    }

    public ProductosProveedores(int idProductoProveedor, int idProducto, int idProveedor) {
        this.idProductoProveedor = idProductoProveedor;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }

    public int getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT pr.idProveedor IdProveedor, pr.nombre NombreProveedor, p.idProducto IdProducto, p.nombre NombreProducto  FROM ProductosProveedores pp\n"
                + "INNER JOIN Productos p ON p.idProducto = pp.idProducto\n"
                + "INNER JOIN Proveedores pr ON pr.idProveedor = pp.idProveedor";
        return dataAcces.Query(query);
    }

    public boolean Asignar() {
        String query = "INSERT INTO ProductosProveedores (idProveedor, idProducto) VALUES (" + idProveedor + " ," + idProducto + ")";

        return dataAcces.Execute(query) >= 1;
    }

}
