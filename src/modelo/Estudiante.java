/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pixels
 */
public class Estudiante extends Usuario{
    
    private int puntajePruebasSaber;

    public Estudiante(int puntajePruebasSaber, String user, String psw, String nombre, String apellido, int edad, String documento, String telefono, String correo) {
        super(user, psw, nombre, apellido, edad, documento, telefono, correo);
        this.puntajePruebasSaber = puntajePruebasSaber;
    }

    public int getPuntajePruebasSaber() {
        return puntajePruebasSaber;
    }

    public void setPuntajePruebasSaber(int puntajePruebasSaber) {
        this.puntajePruebasSaber = puntajePruebasSaber;
    }
    
}
