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
public class Sucursales {

    private DataAccess dataAcces = DataAccess.instance();
    private int idSucursal;
    private String nombre;
    private int idContacto;
    private boolean activo;

    public Sucursales() {
    }

    public Sucursales(int idSucursal, String nomFarmacia, int idContacto, boolean activo) {
        this.idSucursal = idSucursal;
        this.nombre = nomFarmacia;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
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
        String query = "SELECT * FROM Sucursales";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Sucursales WHERE idSucursal = " + idSucursal;
        DefaultTableModel res = dataAcces.Query(query);
        idSucursal = (int) res.getValueAt(0, 0);
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
        String query = "INSERT INTO Sucursales(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "', " + idContacto + " , " + activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Sucursales WHERE idSucursal = " + idSucursal;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE Sucursales SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ","
                + "activo = " + activo + " "
                + "WHERE idSucursal = " + idSucursal;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel getDireccion() {

        String query = "SELECT idSucursal, idConctacto, calle FROM Sucursales s "
                + "INNER JOIN Contactos c ON c.idContacto = s.idContacto "
                + "INNER JOIN Localidades l ON l.idLocalidad = c.idLocalidad "
                + "WHERE idSucursal = " + idSucursal;

        return dataAcces.Query(query);
    }

    public DefaultTableModel getAllDireccions() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "SELECT idSucursal, idContacto, calle FROM Sucursales s "
                + "INNER JOIN Contactos c ON c.idContacto = s.idContacto "
                + "INNER JOIN Localidades l ON l.idLocalidad = c.idLocalidad ";

        return dataAcces.Query(query);
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "select idSucursal ID, nombre Nombre, c.calle Direccion, activo Activo from sucursales s\n"
                + "Inner join Contactos c on c.idContacto = s.idContacto";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "select idSucursal ID, nombre Nombre, c.calle Direccion, activo Activo from sucursales s\n"
                + "Inner join Contactos c on c.idContacto = s.idContacto ORDER BY Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String columna, String busqueda) {
        String query = "SELECT * FROM Sucursales WHERE " +columna + " = '" + busqueda + "' ";
        return dataAcces.Query(query);
    }
}
