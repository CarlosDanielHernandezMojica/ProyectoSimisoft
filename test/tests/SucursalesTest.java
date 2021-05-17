/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import BusinessModelLayer.*;
import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos D
 */
public class SucursalesTest {

    private DataAccess dataAcces = DataAccess.instance();
    private int idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private int activo;

    public SucursalesTest() {
    }

    public SucursalesTest(int idSucursal, String nomFarmacia, String direccion, String telefono, int activo) {
        this.idSucursal = idSucursal;
        this.nombre = nomFarmacia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getIdFarmacia() {
        return idSucursal;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM farmacias";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM farmacias WHERE idFarmacia = " + idSucursal;
        DefaultTableModel res = dataAcces.Query(query);
        idSucursal = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        direccion = (String) res.getValueAt(0, 2);
        telefono = (String) res.getValueAt(0, 3);
        activo = (int) res.getValueAt(0, 4);
    }

    public boolean Add() {
        String query = "INSERT INTO farmacias(nombre, direccion, telefono, activo) "
                + "VALUES('" + nombre + "','" + direccion + "','" + telefono + "'," + activo + ");";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idSucursal;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        String query = "UPDATE farmacias SET "
                + "nombre = '" + nombre + "', "
                + "direccion = '" + direccion + "', "
                + "telefono = '" + telefono + "',"
                + "activo = " + activo + " "
                + "WHERE idFarmacia = " + idSucursal + ";";

        return dataAcces.Execute(query) >= 1;
    }

}
