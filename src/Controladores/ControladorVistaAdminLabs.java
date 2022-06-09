/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.Estudiante;
import modelo.Herramienta;
import modelo.Laboratorio;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class ControladorVistaAdminLabs {
    private Universidad uni;
    
    public ControladorVistaAdminLabs(){
        uni = new Universidad();
    }
    
    public Laboratorio obtenerLab(int i, int j){
        return uni.obtenerLab(i, j);
    }
    
    public int obtenerCantidadHerramientasDisponibles(){
        return uni.obtenerCantidadHerramientasDisponibles();
    }
    
    public Herramienta obtenerHerramientaDisponibleIndex(int i){
        return uni.obtenerHerramientaDisponibleIndex(i);
    }
    
    public Herramienta buscarHerramientaDisponible(int id){
        return uni.buscarHerramientaDisponible(id);
    }
    
    public Estudiante buscarEstudianteDoc(String documento){
        return uni.buscarEstudianteDoc(documento);
    }
    
    public boolean validarEstudianteLab(String user){
        return uni.validarEstudianteLab(user);
    }
}
