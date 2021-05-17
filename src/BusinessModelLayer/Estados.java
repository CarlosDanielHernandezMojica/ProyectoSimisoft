/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos D
 */
public class Estados {
    private DataAccess dataAcces = DataAccess.instance();
    private int idEstado;
    private String nombre;

    public Estados() {
    }

    public Estados(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM estados";
        return dataAcces.Query(query);
    } 

    public void GetById() {
        String query = "SELECT * FROM Estados WHERE idEstado = " + idEstado;
        DefaultTableModel res = dataAcces.Query(query);
        idEstado = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
    }

    public boolean Add() {
        String query = "INSERT INTO Estados(nombre) "
                + "VALUES('" + nombre +"')";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Estados WHERE idEstado = " + idEstado;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE Estados SET "
                + "nombre = '" + nombre + "' "
                + "WHERE idEstado = " + idEstado;

        return dataAcces.Execute(query) >= 1;
    }
    
    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT idEstado ID, nombre Nombre FROM estados";
        return dataAcces.Query(query);
    } 
    
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "SELECT idEstado ID, nombre Nombre FROM estados ORDER BY Nombre";
        return dataAcces.Query(query);
    } 
    
    public DefaultTableModel Search(String columna, String busqueda) {
        String query = "SELECT * FROM Estados WHERE " +columna + " = '" + busqueda + "' ";
        return dataAcces.Query(query);
    }
}
