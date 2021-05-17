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
public class Usuarios {

    private DataAccess dataAcces = DataAccess.instance();
    private int idUsuario;
    private String nombre;
    private String tipoUsuario;
    private String usuario;
    private String password;
    private int idSucursal;
    private int idContacto;
    private boolean activo;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String nombre, String tipoUsuario, String usuario, String password, int idSucursal, int idContacto, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idSucursal = idSucursal;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
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
        String query = "SELECT * FROM Usuarios";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT *FROM Usuarios WHERE idUsuario = " + idUsuario;
        DefaultTableModel res = dataAcces.Query(query);
        idUsuario = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        tipoUsuario = (String) res.getValueAt(0, 2);
        usuario = (String) res.getValueAt(0, 3);
        password = (String) res.getValueAt(0, 4);
        idSucursal = (int) res.getValueAt(0, 5);
        idContacto = (int) res.getValueAt(0, 6);
        activo = (boolean) res.getValueAt(0, 7);
    }

    public boolean Add() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "INSERT INTO Usuarios (nombre, tipoUsuario, usuario, password, idSucursal, idContacto, activo) "
                + "VALUES('" + nombre + "', '" + tipoUsuario + "', '" + usuario + "', '" + password + "', " + idSucursal + ", " + idContacto + ", " + activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Usuarios WHERE idUsuario = " + idUsuario;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "UPDATE Usuarios SET "
                + "nombre = '" + nombre + "', "
                + "tipoUsuario = '" + tipoUsuario + "', "
                + "usuario = '" + usuario + "', "
                + "password = '" + password + "', "
                + "idSucursal = " + idSucursal + ", "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idUsuario = " + idUsuario;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "select idUsuario ID, u.nombre Nombre, tipoUsuario Rol, usuario Usuario, s.nombre Sucursal, c.calle Direccion from usuarios u\n"
                + "INNER JOIN Sucursales s on s.idSucursal = u.idSucursal\n"
                + "inner join Contactos c on c.idContacto = u.idContacto";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "select idUsuario ID, u.nombre Nombre, tipoUsuario Rol, usuario Usuario, s.nombre Sucursal, c.calle Direccion from usuarios u\n"
                + "INNER JOIN Sucursales s on s.idSucursal = u.idSucursal\n"
                + "inner join Contactos c on c.idContacto = u.idContacto Order by Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String columna, String busqueda) {
        String query = "SELECT * FROM Usuarios WHERE " +columna + " = '" + busqueda + "' ";
        return dataAcces.Query(query);
    }
}
