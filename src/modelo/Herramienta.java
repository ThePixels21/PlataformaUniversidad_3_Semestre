/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Singleton.Singleton;
import java.io.Serializable;

/**
 *
 * @author Pixels
 */
public class Herramienta implements Serializable{
    private String nombre;
    private String tipo;
    private int id;
    private boolean disponible;

    public Herramienta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.id = Singleton.determinarIdHerramienta();
        this.disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
