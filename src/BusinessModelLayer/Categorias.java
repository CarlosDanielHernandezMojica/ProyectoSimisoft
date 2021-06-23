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
public class Categorias {

    private DataAccess dataAcces = DataAccess.instance();
    private int idCategoria;
    private String nombre;
    private boolean activo;

    public Categorias() {
    }

    public Categorias(int idCategoria, String nombre, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Categorias";
        return dataAcces.Query(query);
    } 

    public void GetById() {
        String query = "SELECT *FROM Categorias WHERE idCategoria = " + idCategoria;
        DefaultTableModel res = dataAcces.Query(query);
        idCategoria = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        activo = (boolean) res.getValueAt(0, 2);
    }

    public boolean Add() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "INSERT INTO Categorias (nombre, activo) "
                + "VALUES('" + nombre + "', "+ activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Categorias WHERE idCategoria = " + idCategoria;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        }else {
            activo = 0;
        }
        String query = "UPDATE Categorias SET "
                + "nombre = '" + nombre + "', "
                + "activo = " + activo + " "
                + "WHERE idCategoria = " + idCategoria;

        return dataAcces.Execute(query) >= 1;
    }
    
    public DefaultTableModel GetAllModelNew() {
        String query = "select idCategoria ID, nombre Nombre, activo Activo from categorias";
        return dataAcces.Query(query);
    } 
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "select idCategoria ID, nombre Nombre, activo Activo from categorias ORDER BY Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String nombre) {
        String query = "SELECT idCategoria ID, nombre Nombre, activo Activo FROM Categorias WHERE nombre = '" + nombre + "' ";
        return dataAcces.Query(query);
    }
}
