/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.Curso;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class ControladorVistaEstudiante {
    private Universidad uni;
    
    public ControladorVistaEstudiante(){
        uni = new Universidad();
    }
    
    public int obtenerCantidadCursosEstudiante(String user){
        return uni.obtenerCantidadCursosEstudiante(user);
    }
    
    public Curso obtenerCursoEstudianteIndex(String user, int index){
        return uni.obtenerCursoEstudianteIndex(user, index);
    }
    
    public Curso buscarCurso(int id){
        return uni.buscarCurso(id);
    }
    
}
