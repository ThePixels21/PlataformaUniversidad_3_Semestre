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
public class Curso implements Serializable{
    private Docente docente;
    private Asignatura asignatura;
    private byte bloqueHoras;
    private Salon salon;
    private String dia;
    private int[] horas;
    private int id;
    private LSE<RegistroNotasEstudiante> notas;

    public Curso(Docente docente, Asignatura asignatura, byte bloqueHoras, Salon salon, String dia, int horaInicio) {
        this.docente = docente;
        this.asignatura = asignatura;
        this.bloqueHoras = bloqueHoras;
        this.salon = salon;
        this.dia = dia;
        this.horas = new int[bloqueHoras];
        asignarHoras(horaInicio);
        this.notas = new LSE<>();
        this.id = Universidad.determinarIdCurso();
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public byte getBloqueHoras() {
        return bloqueHoras;
    }

    public void setBloqueHoras(byte bloqueHoras) {
        this.bloqueHoras = bloqueHoras;
        this.horas = new int[bloqueHoras];
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getHoras() {
        return horas;
    }

    public void setHoras(int[] horas) {
        this.horas = horas;
    }
    
    public LSE<RegistroNotasEstudiante> getNotas() {
        return notas;
    }
    
    public RegistroNotasEstudiante buscarRegistro(String user){
        for (int i = 0; i < notas.getSize(); i++) {
            if(notas.get(i).getEstudiante().getUser().equals(user)){
                return notas.get(i);
            }
        }
        return null;
    }
    
    public RegistroNotasEstudiante buscarRegistroDocumento(String documento){
        for (int i = 0; i < notas.getSize(); i++) {
            if(notas.get(i).getEstudiante().getDocumento().equals(documento)){
                return notas.get(i);
            }
        }
        return null;
    }
    
    public boolean registrarEstudiante(Estudiante estudiante){
        RegistroNotasEstudiante aux = buscarRegistro(estudiante.getUser());
        if(aux == null){
            notas.add(new RegistroNotasEstudiante(estudiante, 0, 0, 0));
            Universidad.serializarCursos();
            return true;
        }
        return false;
    }
    
    public boolean eliminarEstudiante(String user){
        for (int i = 0; i < notas.getSize(); i++) {
            if(notas.get(i).getEstudiante().getUser().equals(user)){
                notas.remove(i);
                Universidad.serializarCursos();
                return true;
            }
        }
        return false;
    }
    
    public void asignarHoras(int inicio){
        int hraInicio = inicio;
        for (int i = 0; i < horas.length; i++) {
            horas[i] = hraInicio;
            hraInicio++;
        }
    }
}
