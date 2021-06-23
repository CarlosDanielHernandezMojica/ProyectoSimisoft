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
public class Contactos {

    private DataAccess dataAcces = DataAccess.instance();
    private int idContacto;
    private String calle;
    private int codigoPostal;
    private String telefono;
    private int idLocalidad;
    private int idMunicipio;

    public Contactos() {
    }

    public Contactos(int idContacto, String calle, int codigoPostal, String telefono, int idLocalidad, int idMunicipio) {
        this.idContacto = idContacto;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.idLocalidad = idLocalidad;
        this.idMunicipio = idMunicipio;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Contactos";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Contactos WHERE idContacto = " + idContacto;
        DefaultTableModel res = dataAcces.Query(query);
        idContacto = (int) res.getValueAt(0, 0);
        calle = (String) res.getValueAt(0, 1);
        codigoPostal = (int) res.getValueAt(0, 2);
        telefono = (String) res.getValueAt(0, 3);
        idLocalidad = (int) res.getValueAt(0, 4);
        idMunicipio = (int) res.getValueAt(0, 5);
    }

    public boolean Add() {
        
        String query = "INSERT INTO Contactos (calle, codigoPostal, telefono, idLocalidad, idMunicipio) "
                + "VALUES('" + calle + "' , '" + codigoPostal + "', '" + telefono + "', " + idLocalidad + " , " + idMunicipio + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Contactos WHERE idContacto = " + idContacto;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE Contactos SET "
                + "calle = '" + calle + "', "
                + "codigoPostal = '" + codigoPostal + "', "
                + "telefono = '" + telefono + "', "
                + "idLocalidad = " + idLocalidad + ", "
                + "idMunicipio = " + idMunicipio + " "
                + "WHERE idContacto = " + idContacto;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "SELECT idContacto ID, calle Calle, codigoPostal CP, telefono Telefono, l.nombre Localidad, m.nombre Municipio FROM contactos c\n"
                + "INNER JOIN Localidades l ON l.idLocalidad = c.idLocalidad\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = c.idMunicipio";
        return dataAcces.Query(query);
    }

    public DefaultTableModel GetAllOrderBy() {
        String query = "SELECT idContacto ID, calle Calle, codigoPostal CP, telefono Telefono, l.nombre Localidad, m.nombre Municipio FROM contactos c\n"
                + "INNER JOIN Localidades l ON l.idLocalidad = c.idLocalidad\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = c.idMunicipio ORDER BY calle";
        
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String nombre) {
        String query = "SELECT idContacto ID, calle Calle, codigoPostal CP, telefono Telefono, l.nombre Localidad, m.nombre Municipio FROM contactos c\n"
                + "INNER JOIN Localidades l ON l.idLocalidad = c.idLocalidad\n"
                + "INNER JOIN Municipios m ON m.idMunicipio = c.idMunicipio WHERE codigoPostal = '" + nombre + "' ";
        return dataAcces.Query(query);
    }
    
}
