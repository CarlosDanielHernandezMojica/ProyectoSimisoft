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
public class Municipios {

    private DataAccess dataAcces = DataAccess.instance();
    private int idMunicipio;
    private String nombre;
    private int idEstado;

    public Municipios() {
    }

    public Municipios(int idMunicipio, String nombre, int idEstado) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.idEstado = idEstado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Municipios";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Municipios WHERE idMunicipio = " + idMunicipio;
        DefaultTableModel res = dataAcces.Query(query);
        idMunicipio = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        idEstado = (int) res.getValueAt(0, 2);
    }

    public boolean Add() {

        String query = "INSERT INTO Municipios (nombre, idEstado) "
                + "VALUES('" + nombre + "', " + idEstado + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Municipios WHERE idMunicipio = " + idMunicipio;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE Municipios SET "
                + "nombre = '" + nombre + "', "
                + "idEstado = " + idEstado + " "
                + "WHERE idMunicipio = " + idMunicipio;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT idMunicipio ID, m.nombre Nombre, e.nombre Estado FROM municipios m\n"
                + "INNER JOIN Estados e ON e.idEstado = m.idEstado";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "SELECT idMunicipio ID, m.nombre Nombre, e.nombre Estado FROM municipios m\n"
                + "INNER JOIN Estados e ON e.idEstado = m.idEstado Order by Nombre";
        return dataAcces.Query(query);
        
    }
    
    public DefaultTableModel Search(String columna, String busqueda) {
        String query = "SELECT * FROM Municipios WHERE " +columna + " = '" + busqueda + "' ";
        return dataAcces.Query(query);
    }
}
