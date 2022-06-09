/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Singleton.Singleton;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import util.LSE;

/**
 *
 * @author Pixels
 */
public class Universidad implements Serializable{
    private static LSE<Usuario> usuarios;
    private static LSE<Salon> salones;
    private static LSE<Curso> cursos;
    private static LSE<Asignatura> asignaturas;
    private static Laboratorio[][] laboratorios;
    private static LSE<Herramienta> herramientas;

    public Universidad() {
        crearInstancias();
    }
    
    private void crearInstancias(){
        Universidad.usuarios = Singleton.getInstance().getUsuarios();
        Universidad.salones = Singleton.getInstance().getSalones();
        Universidad.cursos = Singleton.getInstance().getCursos();
        Universidad.asignaturas = Singleton.getInstance().getAsignaturas();
        Universidad.laboratorios = Singleton.getInstance().getLaboratorios();
        Universidad.herramientas = Singleton.getInstance().getHerramientas();
    }
    
    public static void serializarUsuarios(){
        try{
            FileOutputStream archivo = new FileOutputStream("usuarios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(usuarios);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void serializarSalones(){
        try{
            FileOutputStream archivo = new FileOutputStream("salones.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(salones);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void serializarCursos(){
        try{
            FileOutputStream archivo = new FileOutputStream("cursos.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(cursos);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void serializarAsignaturas(){
        try{
            FileOutputStream archivo = new FileOutputStream("asignaturas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(asignaturas);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void serializarLaboratorios(){
        try{
            FileOutputStream archivo = new FileOutputStream("laboratorios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(laboratorios);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void serializarHerramientas(){
        try{
            FileOutputStream archivo = new FileOutputStream("herramientas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(herramientas);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private Usuario buscarUsuario(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i).getUser().equals(user)){
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    private Usuario buscarUsuarioDocumento(String documento){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i).getDocumento().equals(documento)){
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    public Estudiante buscarEstudiante(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Estudiante && usuarios.get(i).getUser().equals(user)){
                return (Estudiante) usuarios.get(i);
            }
        }
        return null;
    }
    
    public Estudiante buscarEstudianteDoc(String doc) {
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Estudiante && usuarios.get(i).getDocumento().equals(doc)){
                return (Estudiante) usuarios.get(i);
            }
        }
        return null;
    }
    
    public Estudiante buscarEstudianteIndex(int i) {
        Estudiante estudiante = null;
        int index = -1;
        for (int j = 0; j < usuarios.getSize(); j++) {
            if (usuarios.get(j) instanceof Estudiante) {
                index++;
                if (index == i) {
                    estudiante = (Estudiante) usuarios.get(j);
                }
            }
        }
        return estudiante;
    }
    
    public boolean registrarEstudiante(Estudiante estudiante){
        Usuario aux = buscarUsuario(estudiante.getUser());
        Usuario aux2 = buscarUsuarioDocumento(estudiante.getDocumento());
        if(aux == null && aux2 == null){
            usuarios.add(estudiante);
            serializarUsuarios();
            return true;
        }
        return false;
    }
    
    public boolean eliminarEstudiante(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Estudiante && usuarios.get(i).getUser().equals(user)){
                usuarios.remove(i);
                serializarUsuarios();
                return true;
            }
        }
        return false;
    }
    
    public Docente buscarDocente(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Docente && usuarios.get(i).getUser().equals(user)){
                return (Docente) usuarios.get(i);
            }
        }
        return null;
    }
    
    public Docente buscarDocenteIndex(int i) {
        Docente docente = null;
        int index = -1;
        for (int j = 0; j < usuarios.getSize(); j++) {
            if (usuarios.get(j) instanceof Docente) {
                index++;
                if (index == i) {
                    docente = (Docente) usuarios.get(j);
                }
            }
        }
        return docente;
    }
    
    public boolean registrarDocente(Docente docente){
        Usuario aux = buscarUsuario(docente.getUser());
        Usuario aux2 = buscarUsuarioDocumento(docente.getDocumento());
        if(aux == null && aux2 == null){
            usuarios.add(docente);
            serializarUsuarios();
            return true;
        }
        return false;
    }
    
    public boolean eliminarDocente(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Docente && usuarios.get(i).getUser().equals(user)){
                usuarios.remove(i);
                serializarUsuarios();
                return true;
            }
        }
        return false;
    }
    
    public AdminGeneral buscarAdminGeneral(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof AdminGeneral
                    && usuarios.get(i).getUser().equals(user)){
                return (AdminGeneral) usuarios.get(i);
            }
        }
        return null;
    }
    
    public AdminLabs buscarAdminLabs(String user){
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof AdminLabs
                    && usuarios.get(i).getUser().equals(user)){
                return (AdminLabs) usuarios.get(i);
            }
        }
        return null;
    }
    
    public int obtenerCantidadEstudiantes(){
        int contador = 0;
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Estudiante){
                contador++;
            }
        }
        return contador;
    }
    
    public int obtenerCantidadDocentes(){
        int contador = 0;
        for (int i = 0; i < usuarios.getSize(); i++) {
            if(usuarios.get(i) instanceof Docente){
                contador++;
            }
        }
        return contador;
    }
    
    public int obtenerCantidadCursosDocente(String user){
        int contador = 0;
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getDocente().getUser().equals(user)){
                contador++;
            }
        }
        return contador;
    }
    
    public Curso obtenerCursoDocenteIndex(String user, int index){
        int i = -1;
        for (int j = 0; j < cursos.getSize(); j++) {
            if(cursos.get(j).getDocente().getUser().equals(user)){
                i++;
                if(i == index){
                    return cursos.get(j);
                }
            }
        }
        return null;
    }
    
    public int obtenerCantidadCursosEstudiante(String user){
        int contador = 0;
        for (int i = 0; i < cursos.getSize(); i++) {
            for (int j = 0; j < cursos.get(i).getNotas().getSize(); j++) {
                if(cursos.get(i).getNotas().get(j).getEstudiante().getUser().equals(user)){
                    contador++;
                }
            }
        }
        return contador;
    }
    
    public Curso obtenerCursoEstudianteIndex(String user, int index){
        int i = -1;
        for (int j = 0; j < cursos.getSize(); j++) {
            for (int k = 0; k < cursos.get(j).getNotas().getSize(); k++) {
                if(cursos.get(j).getNotas().get(k).getEstudiante().getUser().equals(user)){
                    i++;
                    if(i == index){
                        return cursos.get(j);
                    }
                }
            }
        }
        return null;
    }
    
    public Salon buscarSalon(int numero){
        for (int i = 0; i < salones.getSize(); i++) {
            if(salones.get(i).getNumero() == numero){
                return salones.get(i);
            }
        }
        return null;
    }
    
    public boolean registrarSalon(Salon salon){
        Salon aux = buscarSalon(salon.getNumero());
        if(aux == null){
            salones.add(salon);
            serializarSalones();
            return true;
        }
        return false;
    }
    
    public boolean eliminarSalon(int numero){
        for (int i = 0; i < salones.getSize(); i++) {
            if(salones.get(i).getNumero() == numero){
                salones.remove(i);
                serializarSalones();
                return true;
            }
        }
        return false;
    }
    
    public Asignatura buscarAsignatura(int id){
        for (int i = 0; i < asignaturas.getSize(); i++) {
            if(asignaturas.get(i).getId() == id){
                return asignaturas.get(i);
            }
        }
        return null;
    }
    
    public boolean registrarAsignatura(Asignatura asignatura){
        Asignatura aux = buscarAsignatura(asignatura.getId());
        if(aux == null){
            asignaturas.add(asignatura);
            serializarAsignaturas();
            return true;
        }
        return false;
    }
    
    public boolean eliminarAsignatura(int id){
        for (int i = 0; i < asignaturas.getSize(); i++) {
            if(asignaturas.get(i).getId() == id){
                asignaturas.remove(i);
                serializarAsignaturas();
                return true;
            }
        }
        return false;
    }
    
    public Curso buscarCurso(int id){
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getId() == id){
                return cursos.get(i);
            }
        }
        return null;
    }
    
    public Curso buscarCursoDocente(int id, String user){
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getDocente().getUser().equals(user) && cursos.get(i).getId() == id){
                return cursos.get(i);
            }
        }
        return null;
    }
    
    public boolean registrarCurso(Curso curso){
        Curso aux = buscarCurso(curso.getId());
        if(aux == null){
            cursos.add(curso);
            serializarCursos();
            return true;
        }
        return false;
    }
    
    public boolean eliminarCurso(int id){
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getId() == id){
                cursos.remove(i);
                serializarCursos();
                return true;
            }
        }
        return false;
    }
    
    public int obtenerCantidadCursos(){
        return cursos.getSize();
    }
    
    public Curso obtenerCursoIndex(int i){
        return cursos.get(i);
    }
    
    public int obtenerCantidadAsignaturas(){
        return asignaturas.getSize();
    }
    
    public Asignatura obtenerAsignaturaIndex(int i){
        return asignaturas.get(i);
    }
    
    public int obtenerCantidadSalones(){
        return salones.getSize();
    }
    
    public Salon obtenerSalonIndex(int i){
        return salones.get(i);
    }
    
    public int obtenerCantidadCursosSalon(int numero){
        int contador = 0;
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getSalon().getNumero() == numero){
                contador++;
            }
        }
        return contador;
    }
    
    public static int determinarIdCurso(){
        int id = 0;
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getId() > id){
                id = cursos.get(i).getId();
            }
        }
        return id+1;
    }
    
    public static int determinarIdAsignatura(){
        int id = 0;
        for (int i = 0; i < asignaturas.getSize(); i++) {
            if(asignaturas.get(i).getId() > id){
                id = asignaturas.get(i).getId();
            }
        }
        return id+1;
    }
    
    public String[] crearArregloIdAsignaturas(){
        String[] array = new String[asignaturas.getSize()+1];
        array[0] = "Seleccionar";
        for (int i = 0; i < asignaturas.getSize(); i++) {
            array[i+1] = Integer.toString(asignaturas.get(i).getId());
        }
        return array;
    }
    
    public String[] crearArregloSalones(){
        String[] array = new String[salones.getSize()+1];
        array[0] = "Seleccionar";
        for (int i = 0; i < salones.getSize(); i++) {
            array[i+1] = Integer.toString(salones.get(i).getNumero());
        }
        return array;
    }
    
    public String[] crearArregloSalonesDisponibles(Curso curso) {
        String[] array = new String[salones.getSize()];
        array[0] = Integer.toString(curso.getSalon().getNumero());
        int contador = 1;
        for (int i = 0; i < salones.getSize(); i++) {
            if (salones.get(i).getNumero() != curso.getSalon().getNumero()) {
                array[contador] = Integer.toString(salones.get(i).getNumero());
                contador++;
            }
        }
        for (int i = 0; i < cursos.getSize(); i++) {
            if (curso.getDia().equals(cursos.get(i).getDia())) {
                for (int j = 0; j < curso.getHoras().length; j++) {
                    for (int k = 0; k < cursos.get(i).getHoras().length; k++) {
                        if (curso != cursos.get(i) && curso.getHoras()[j] == cursos.get(i).getHoras()[k]) {
                            for (int l = 0; l < array.length; l++) {
                                if (array[i] != null && array[l].equals(Integer.toString(cursos.get(i).getSalon().getNumero()))) {
                                    array[l] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                contador++;
            }
        }
        String[] salonesDispo = new String[contador];
        contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                salonesDispo[contador] = array[i];
                contador++;
            }
        }
        return salonesDispo;
    }
    
    public String[] crearArregloHoras(String dia, int numeroSalon){
        int[] array = new int[16];
        int contador = 7;
        for (int i = 0; i < array.length; i++) {
            array[i] = contador;
            contador++;
        }
        
        int hora = 0;
        for (int i = 0; i < cursos.getSize(); i++) {
            if(cursos.get(i).getDia().equals(dia) && cursos.get(i).getSalon().getNumero() == numeroSalon){
                for (int j = 0; j < cursos.get(i).getHoras().length; j++) {
                    hora = cursos.get(i).getHoras()[j];
                    for (int k = 0; k < array.length; k++) {
                        if(hora == array[k]){
                            array[k] = 0;
                        }
                    }
                }
            }
        }
        
        contador = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0){
                contador++;
            }
        }
        
        String[] hrs = new String[contador+1];
        hrs[0] = "Seleccionar";
        contador = 1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0){
                hrs[contador] = Integer.toString(array[i]);
                contador++;
            }
        }
        return hrs;
    }
    
    public Laboratorio obtenerLab(int i, int j){
        return laboratorios[i][j];
    }
    
    public int obtenerCantidadHerramientas(){
        return herramientas.getSize();
    }
    
    public Herramienta obtenerHerramientaIndex(int i){
        return herramientas.get(i);
    }
    
    public int obtenerCantidadHerramientasDisponibles(){
        int contador = 0;
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).isDisponible()){
                contador++;
            }
        }
        return contador;
    }
    
    public Herramienta obtenerHerramientaDisponibleIndex(int i){
        int index = -1;
        for (int j = 0; j < herramientas.getSize(); j++) {
            if(herramientas.get(j).isDisponible()){
                index++;
                if(index == i){
                    return herramientas.get(j);
                }
            }
        }
        return null;
    }
    
    public Herramienta buscarHerramientaDisponible(int id){
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).isDisponible() && herramientas.get(i).getId() == id){
                return herramientas.get(i);
            }
        }
        return null;
    }
    
    public Herramienta buscarHerramienta(int id){
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).getId() == id){
                return herramientas.get(i);
            }
        }
        return null;
    }
    
    public boolean registrarHerramienta(Herramienta herramienta){
        Herramienta aux = buscarHerramienta(herramienta.getId());
        if(aux == null){
            herramientas.add(herramienta);
            serializarHerramientas();
            return true;
        }
        return false;
    }
    
    public boolean eliminarHerramienta(int id){
        for (int i = 0; i < herramientas.getSize(); i++) {
            if(herramientas.get(i).getId() == id){
                herramientas.remove(i);
                serializarHerramientas();
                return true;
            }
        }
        return false;
    }
    
    public void validarHerramientasPrestadas(){
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                for (int k = 0; k < laboratorios[i][j].getOcupantes().getSize(); k++) {
                    for (int l = 0; l < laboratorios[i][j].getOcupantes().get(k).getHerramientas().getSize(); l++) {
                        if(laboratorios[i][j].getOcupantes().get(k).getHerramientas().get(l).isDisponible()){
                            laboratorios[i][j].getOcupantes().get(k).getHerramientas().remove(l);
                        }
                    }
                }
            }
        }
    }
    
    public boolean validarEstudianteLab(String user){
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                for (int k = 0; k < laboratorios[i][j].getOcupantes().getSize(); k++) {
                    if(laboratorios[i][j].getOcupantes().get(k).getEstudiante().getUser().equals(user)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}