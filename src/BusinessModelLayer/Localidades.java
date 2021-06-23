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
public class Localidades {

    private DataAccess dataAcces = DataAccess.instance();
    private int idLocalidad;
    private String nombre;
    private int idMunicipio;

    public Localidades() {
    }

    public Localidades(int idLocalidad, String nombre, int idMunicipio) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.idMunicipio = idMunicipio;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Localidades";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Localidades WHERE idLocalidad = " + idLocalidad;
        DefaultTableModel res = dataAcces.Query(query);
        idLocalidad = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        idMunicipio = (int) res.getValueAt(0, 2);
    }

    public boolean Add() {

        String query = "INSERT INTO Localidades (nombre, idMunicipio) "
                + "VALUES('" + nombre + "', " + idMunicipio + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Localidades WHERE idLocalidad = " + idLocalidad;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE Localidades SET "
                + "nombre = '" + nombre + "', "
                + "idMunicipio = " + idMunicipio + " "
                + "WHERE idLocalidad = " + idLocalidad;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT idLocalidad ID, l.nombre Nombre, m.nombre Municipio FROM Localidades l\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = l.idMunicipio";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "SELECT idLocalidad ID, l.nombre Nombre, m.nombre Municipio FROM Localidades l\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = l.idMunicipio Order by Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String nombre) {
        String query = "SELECT idLocalidad ID, l.nombre Nombre, m.nombre Municipio FROM Localidades l\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = l.idMunicipio WHERE l.nombre = '" + nombre + "'";
        return dataAcces.Query(query);
    }
}
