/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos D
 */
public class Productos {

    private DataAccess dataAcces = DataAccess.instance();
    private int idProducto;
    private String nombre;
    private double precio;
    private Date caducidad;
    private double descuento;
    private int idCategoria;
    private boolean activo;
    DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    public Productos() {
    }

    public Productos(int idProducto, String nombre, double precio, Date caducidad, double descuento, int idCategoria, boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.descuento = descuento;
        this.idCategoria = idCategoria;
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public DateFormat getF() {
        return f;
    }

    public void setF(DateFormat f) {
        this.f = f;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Productos";
        return dataAcces.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAcces.Query(query);
        idProducto = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        precio = Double.parseDouble(res.getValueAt(0, 2).toString()) ;
        caducidad = (Date) res.getValueAt(0, 3);
        descuento = Double.parseDouble(res.getValueAt(0, 4).toString());
        idCategoria = (int) res.getValueAt(0, 5);
        activo = (boolean) res.getValueAt(0, 6);
    }

    public boolean Add() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "INSERT INTO productos(nombre, precio, caducidad, descuento, idCategoria, activo) "
                + "VALUES('" + nombre + "', " + precio + ", '" + f.format(caducidad) + "', " + descuento + ", " + idCategoria + "," + activo + ")";
        return dataAcces.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Productos WHERE idProducto = " + idProducto;
        return dataAcces.Execute(query) >= 1;

    }

    public boolean Update() {
        int activo = 1;
        if (this.activo) {
            activo = 1;
        } else {
            activo = 0;
        }
        String query = "UPDATE Productos SET "
                + "nombre = '" + nombre + "', "
                + "precio = " + precio + ", "
                + "caducidad = '" + f.format(caducidad) + "', "
                + "descuento = " + descuento + ","
                + "idCategoria = " + idCategoria + ", "
                + "activo = " + activo + " "
                + "WHERE idProducto = " + idProducto;

        return dataAcces.Execute(query) >= 1;
    }

    public DefaultTableModel GetAllModelNew() {
        String query = "select idProducto ID, p.nombre Nombre, precio Precio, caducidad Caducidad, descuento Descuento, c.nombre Categoria, p.activo Activo  from productos p\n"
                + "inner join Categorias c on c.idCategoria = p.idCategoria";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel GetAllOrderBy() {
        String query = "select idProducto ID, p.nombre Nombre, precio Precio, caducidad Caducidad, descuento Descuento, c.nombre Categoria, p.activo Activo  from productos p\n"
                + "inner join Categorias c on c.idCategoria = p.idCategoria Order by Nombre";
        return dataAcces.Query(query);
    }
    
    public DefaultTableModel Search(String nombre) {
        String query = "select idProducto ID, p.nombre Nombre, precio Precio, caducidad Caducidad, descuento Descuento, c.nombre Categoria, p.activo Activo  from productos p\n"
                + "inner join Categorias c on c.idCategoria = p.idCategoria WHERE p.nombre ='" + nombre + "'";
        return dataAcces.Query(query);
    }
    
}
