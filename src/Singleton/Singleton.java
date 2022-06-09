/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import modelo.AdminGeneral;
import modelo.AdminLabs;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Docente;
import modelo.Herramienta;
import modelo.Laboratorio;
import modelo.Salon;
import modelo.Usuario;
import util.LSE;

/**
 *
 * @author Pixels
 */
public class Singleton implements Serializable{
    private static Singleton instance;
    private static LSE<Usuario> usuarios;
    private static LSE<Salon> salones;
    private static LSE<Curso> cursos;
    private static LSE<Asignatura> asignaturas;
    private static Laboratorio[][] laboratorios;
    private static LSE<Herramienta> herramientas;
    
    private Singleton(){
    }
    
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    
    public LSE<Usuario> getUsuarios(){
        if(usuarios == null){
            leerUsuarios();
        }
        return usuarios;
    }
    
    public LSE<Salon> getSalones(){
        if(salones == null){
            leerSalones();
        }
        return salones;
    }
    
    public LSE<Curso> getCursos(){
        if(cursos == null){
            leerCursos();
        }
        return cursos;
    }
    
    public LSE<Asignatura> getAsignaturas(){
        if(asignaturas == null){
            leerAsignaturas();
        }
        return asignaturas;
    }
    
    public Laboratorio[][] getLaboratorios(){
        if(laboratorios == null){
            leerLaboratorios();
        }
        return laboratorios;
    }
    
    public LSE<Herramienta> getHerramientas(){
        if(herramientas == null){
            leerHerramientas();
        }
        return herramientas;
    }
    
    private void leerUsuarios(){
        try{
            FileInputStream archivo = new FileInputStream("usuarios.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            usuarios = (LSE<Usuario>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            usuarios = new LSE<>();
            crearUsuarios();
        }
    }
    
    private void leerSalones(){
        try{
            FileInputStream archivo = new FileInputStream("salones.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            salones = (LSE<Salon>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            salones = new LSE<>();
        }
    }
    
    private void leerCursos(){
        try{
            FileInputStream archivo = new FileInputStream("cursos.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            cursos = (LSE<Curso>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            cursos = new LSE<>();
        }
    }
    
    private void leerAsignaturas(){
        try{
            FileInputStream archivo = new FileInputStream("asignaturas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            asignaturas = (LSE<Asignatura>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            asignaturas = new LSE<>();
        }
    }
    
    private void leerLaboratorios(){
        try{
            FileInputStream archivo = new FileInputStream("laboratorios.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            laboratorios = (Laboratorio[][]) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            laboratorios = new Laboratorio[3][];
            crearLaboratorios();
        }
    }
    
    private void crearLaboratorios() {
        for (int i = 0; i < laboratorios.length; i++) {
            if (i != 1) {
                laboratorios[i] = new Laboratorio[6];
            } else {
                laboratorios[i] = new Laboratorio[1];
            }
        }
        initLaboratorios();
    }
    
    private void initLaboratorios() {
        int contador = 6;
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                if (laboratorios[i][j] == null) {
                    laboratorios[i][j] = new Laboratorio(contador);
                    contador+=2;
                }
            }
        }
    }
    
    private void leerHerramientas(){
        try{
            FileInputStream archivo = new FileInputStream("herramientas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            herramientas = (LSE<Herramienta>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            herramientas = new LSE<>();
            crearHerramientas();
        }
    }
    
    private void crearUsuarios() {
        usuarios.add(new AdminGeneral("admin", "admin", "admin", "admin", 0, "9491", "3651991", "admin@gmail.com"));
        usuarios.add(new AdminLabs("labs", "labs", "admin", "adminLabs", 1, "818", "321649", "labs@gmail.com"));
        usuarios.add(new Docente("Universitario", "Ingeniero electrónico", 3,"2", "2", "Pedro", "Ramirez", 29, "949", "3848998", "pedro@gmail.com"));
    }
    
    private void crearHerramientas(){
        herramientas.add(new Herramienta("Microscopio electrónico", "Microscopio"));
        herramientas.add(new Herramienta("Microscopio ultravioleta", "Microscopio"));
        herramientas.add(new Herramienta("Microscopio óptico", "Microscopio"));
        herramientas.add(new Herramienta("Tubo corto", "TuboEnsayo"));
        herramientas.add(new Herramienta("Tubo mediano", "TuboEnsayo"));
        herramientas.add(new Herramienta("Tubo grande", "TuboEnsayo"));
        herramientas.add(new Herramienta("Espatula pequeña", "Espatula"));
        herramientas.add(new Herramienta("Espatula mediana", "Espatula"));
        herramientas.add(new Herramienta("Espatula grande", "Espatula"));
        herramientas.add(new Herramienta("Mechero", "Mechero"));
        herramientas.add(new Herramienta("Termometro digital", "Termometro"));
        herramientas.add(new Herramienta("Termometro infrarrojo", "Termometro"));
        herramientas.add(new Herramienta("Termometro de mercurio", "Termometro"));
        herramientas.add(new Herramienta("Bascula gr", "Bascula"));
        herramientas.add(new Herramienta("Bascula kg", "Bascula"));
        herramientas.add(new Herramienta("Bascula lbs", "Bascula"));
        herramientas.add(new Herramienta("Pipeta", "Pipeta"));
        herramientas.add(new Herramienta("Pinzas", "Pinza"));
    }
    
    public static int determinarIdHerramienta(){
        int id = 0;
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).getId() > id){
                id = herramientas.get(i).getId();
            }
        }
        return id+1;
    }
}
