/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Pixels
 */
public class RegistroNotasEstudiante implements Serializable{
    private Estudiante estudiante;
    private double nota1;
    private double nota2;
    private double nota3;
    private double acumulado;
    
    private boolean anulable;

    public RegistroNotasEstudiante(Estudiante estudiante, double nota1, double nota2, double nota3) {
        this.estudiante = estudiante;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.anulable = true;
        setAcumulado();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
        this.anulable = false;
        setAcumulado();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
        this.anulable = false;
        setAcumulado();
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
        this.anulable = false;
        setAcumulado();
    }

    public double getAcumulado() {
        return acumulado;
    }

    private void setAcumulado() {
        this.acumulado = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
    }

    public boolean isAnulable() {
        return anulable;
    }
}
