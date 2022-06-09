/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.Asignatura;
import modelo.Curso;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Herramienta;
import modelo.Salon;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class ControladorVistaAdminGeneral {
    private Universidad uni;
    
    public ControladorVistaAdminGeneral(){
        uni = new Universidad();
    }
    
    public Estudiante buscarEstudiante(String user){
        return uni.buscarEstudiante(user);
    }
    
    public Estudiante buscarEstudianteDoc(String doc){
        return uni.buscarEstudianteDoc(doc);
    }
    
    public boolean registrarEstudiante(Estudiante estudiante){
        return uni.registrarEstudiante(estudiante);
    }
    
    public boolean eliminarEstudiante(String user){
        return uni.eliminarEstudiante(user);
    }
    
    public int obtenerCantidadEstudiantes(){
        return uni.obtenerCantidadEstudiantes();
    }
    
    public Estudiante buscarEstudianteIndex(int i){
        return uni.buscarEstudianteIndex(i);
    }
    
    public Docente buscarDocente(String user){
        return uni.buscarDocente(user);
    }
    
    public Docente buscarDocenteIndex(int i){
        return uni.buscarDocenteIndex(i);
    }
    
    public boolean registrarDocente(Docente docente){
        return uni.registrarDocente(docente);
    }
    
    public boolean eliminarDocente(String user){
        return uni.eliminarDocente(user);
    }
    
    public int obtenerCantidadDocentes(){
        return uni.obtenerCantidadDocentes();
    }
    
    public int obtenerCantidadCursosDocente(String user){
        return uni.obtenerCantidadCursosDocente(user);
    }
    
    public Salon buscarSalon(int numero){
        return uni.buscarSalon(numero);
    }
    
    public boolean registrarSalon(Salon salon){
        return uni.registrarSalon(salon);
    }
    
    public boolean eliminarSalon(int numero){
        return uni.eliminarSalon(numero);
    }
    
    public Asignatura buscarAsignatura(int id){
        return uni.buscarAsignatura(id);
    }
    
    public boolean registrarAsignatura(Asignatura asignatura){
        return uni.registrarAsignatura(asignatura);
    }
    
    public boolean eliminarAsignatura(int id){
        return uni.eliminarAsignatura(id);
    }
    
    public Curso buscarCurso(int id){
        return uni.buscarCurso(id);
    }
    
    public boolean registrarCurso(Curso curso){
        return uni.registrarCurso(curso);
    }
    
    public boolean eliminarCurso(int id){
        return uni.eliminarCurso(id);
    }
    
    public int obtenerCantidadCursos(){
        return uni.obtenerCantidadCursos();
    }
    
    public Curso obtenerCursoIndex(int i){
        return uni.obtenerCursoIndex(i);
    }
    
    public int obtenerCantidadAsignaturas(){
        return uni.obtenerCantidadAsignaturas();
    }
    
    public Asignatura obtenerAsignaturaIndex(int i){
        return uni.obtenerAsignaturaIndex(i);
    }
    
    public int obtenerCantidadSalones(){
        return uni.obtenerCantidadSalones();
    }
    
    public Salon obtenerSalonIndex(int i){
        return uni.obtenerSalonIndex(i);
    }
    
    public int obtenerCantidadCursosSalon(int numero){
        return uni.obtenerCantidadCursosSalon(numero);
    }
    
    public String[] crearArregloIdAsignaturas(){
        return uni.crearArregloIdAsignaturas();
    }
    
    public String[] crearArregloSalones(){
        return uni.crearArregloSalones();
    }
    
    public String[] crearArregloHoras(String dia, int numeroSalon){
        return uni.crearArregloHoras(dia, numeroSalon);
    }
    
    public boolean registrarHerramienta(Herramienta herramienta){
        return uni.registrarHerramienta(herramienta);
    }
    
    public int obtenerCantidadHerramientas(){
        return uni.obtenerCantidadHerramientas();
    }
    
    public Herramienta obtenerHerramientaIndex(int i){
        return uni.obtenerHerramientaIndex(i);
    }
    
    public int obtenerCantidadHerramientasDisponibles(){
        return uni.obtenerCantidadHerramientasDisponibles();
    }
    
    public Herramienta obtenerHerramientaDisponibleIndex(int i){
        return uni.obtenerHerramientaDisponibleIndex(i);
    }
    
    public Herramienta buscarHerramienta(int id){
        return uni.buscarHerramienta(id);
    }
    
    public boolean eliminarHerramienta(int id){
        return uni.eliminarHerramienta(id);
    }
    
    public void validarHerramientasPrestadas(){
        uni.validarHerramientasPrestadas();
    }
}
