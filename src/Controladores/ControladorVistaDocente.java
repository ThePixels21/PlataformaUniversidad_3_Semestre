/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.Curso;
import modelo.Salon;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class ControladorVistaDocente {
    private Universidad uni;
    
    public ControladorVistaDocente(){
        uni = new Universidad();
    }
    
    public int obtenerCantidadCursosDocente(String user){
        return uni.obtenerCantidadCursosDocente(user);
    }
    
    public Curso obtenerCursoDocenteIndex(String user, int index){
        return uni.obtenerCursoDocenteIndex(user, index);
    }
    
    public Curso buscarCursoDocente(int id, String user){
        return uni.buscarCursoDocente(id, user);
    }
    
    public String[] crearArregloSalonesDisponibles(Curso curso){
        return uni.crearArregloSalonesDisponibles(curso);
    }
    
    public Salon buscarSalon(int numero){
        return uni.buscarSalon(numero);
    }
}
