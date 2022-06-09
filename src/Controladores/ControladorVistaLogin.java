/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelo.AdminGeneral;
import modelo.AdminLabs;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class ControladorVistaLogin {
    private Universidad uni;
    
    public ControladorVistaLogin(){
        uni = new Universidad();
    }
    
    public AdminGeneral buscarAdminGeneral(String user){
        return uni.buscarAdminGeneral(user);
    }
    
    public AdminLabs buscarAdminLabs(String user){
        return uni.buscarAdminLabs(user);
    }
    
    public Docente buscarDocente(String user){
        return uni.buscarDocente(user);
    }
    
    public Estudiante buscarEstudiante(String user){
        return uni.buscarEstudiante(user);
    }
}
