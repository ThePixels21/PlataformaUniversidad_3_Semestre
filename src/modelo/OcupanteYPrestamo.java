/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import util.LSE;

/**
 *
 * @author Pixels
 */
public class OcupanteYPrestamo implements Serializable{
    private Estudiante estudiante;
    private LSE<Herramienta> herramientas;

    public OcupanteYPrestamo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.herramientas = new LSE<>();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LSE<Herramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(LSE<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }
    
    public Herramienta buscarHerramienta(int id){
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).getId() == id){
                return herramientas.get(i);
            }
        }
        return null;
    }
    
    public void prestarHerramienta(Herramienta herramienta) {
        herramienta.setDisponible(false);
        herramientas.add(herramienta);
        Universidad.serializarLaboratorios();
        Universidad.serializarHerramientas();
    }
    
    public boolean removerHerramienta(int id){
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).getId() == id){
                herramientas.get(i).setDisponible(true);
                herramientas.remove(i);
                Universidad.serializarHerramientas();
                Universidad.serializarLaboratorios();
                return true;
            }
        }
        return false;
    }
    
    public void devolverHerramientas() {
        for (int i = 0; i < herramientas.getSize(); i++) {
            herramientas.get(i).setDisponible(true);
        }
        herramientas.removeAll();
    }
    
}
