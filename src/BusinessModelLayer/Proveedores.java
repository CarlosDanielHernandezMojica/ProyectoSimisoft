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
public class Proveedores {

    private DataAccess dataAcces = DataAccess.instance();
    private int idProveedor;
    private String nombre;
    private int idContacto;
    private boolean activo;

    public Proveedores() {
    }

    public Proveedores(int idProveedor, String nombre, int idContacto, boolean activo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Proveedores";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Proveedores WHERE idProveedor = " + idProveedor;
        DefaultTableModel res = dataAcces.Query(query);
        idProveedor = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        idContacto = (int) res.getValueAt(0, 2);
        activo = (boolean) res.getValueAt(0, 3);
    }

    public boolean Add() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "INSERT INTO Proveedores (nombre, idContacto, activo) "
                + "VALUES('" + nombre + "', " + idContacto + ", " + activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Proveedores WHERE idProveedor = " + idProveedor;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "UPDATE Proveedores SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idProveedor = " + idProveedor;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT idProveedor ID, nombre Nombre, c.calle Direccion, activo Activo from Proveedores p\n"
                + "INNER JOIN Contactos c ON c.idContacto = p.idContacto";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "SELECT idProveedor ID, nombre Nombre, c.calle Direccion, activo Activo from Proveedores p\n"
                + "INNER JOIN Contactos c ON c.idContacto = p.idContacto Order by Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String nombre) {
        String query = "SELECT idProveedor ID, nombre Nombre, c.calle Direccion, activo Activo from Proveedores p\n"
                + "INNER JOIN Contactos c ON c.idContacto = p.idContacto WHERE p.nombre = '" + nombre + "'";
        return dataAcces.Query(query);
    }
}
