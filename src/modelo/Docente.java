/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pixels
 */
public class Docente extends Usuario{
    
    private String nivelAcademico;
    private String estudios;
    private int expLaboral;

    public Docente(String nivelAcademico, String estudios, int expLaboral, String user, String psw, String nombre, String apellido, int edad, String documento, String telefono, String correo) {
        super(user, psw, nombre, apellido, edad, documento, telefono, correo);
        this.nivelAcademico = nivelAcademico;
        this.estudios = estudios;
        this.expLaboral = expLaboral;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public int getExpLaboral() {
        return expLaboral;
    }

    public void setExpLaboral(int expLaboral) {
        this.expLaboral = expLaboral;
    }

}
