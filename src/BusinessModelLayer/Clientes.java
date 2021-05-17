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
public class Clientes {

    private DataAccess dataAcces = DataAccess.instance();
    private int idCliente;
    private String nombre;
    private int idContacto;
    private boolean activo;

    public Clientes() {
    }

    public Clientes(int idCliente, String nombre, int idContacto, boolean activo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        String query = "SELECT * FROM Clientes";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Clientes WHERE idCliente = " + idCliente;
        DefaultTableModel res = dataAcces.Query(query);
        idCliente = (int) res.getValueAt(0, 0);
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
        String query = "INSERT INTO Clientes (nombre, idContacto, activo) "
                + "VALUES('" + nombre + "', " + idContacto + ", " + activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Clientes WHERE idCliente = " + idCliente;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "UPDATE Clientes SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + (int) activo + " "
                + "WHERE idCliente = " + idCliente;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "Select idCliente ID, nombre Nombre, c.calle Direccion, activo Activo from clientes cl \n"
                + "INNER join contactos c on c.idContacto = cl.idContacto";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "Select idCliente ID, nombre Nombre, c.calle Direccion, activo Activo from clientes cl \n"
                + "INNER join contactos c on c.idContacto = cl.idContacto Order by Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String columna, String busqueda) {
        String query = "SELECT * FROM Clientes WHERE " +columna + " = '" + busqueda + "' ";
        return dataAcces.Query(query);
    }

}
