/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import util.LSE;
import util.Queue;

/**
 *
 * @author Pixels
 */
public class Laboratorio implements Serializable{
    private LSE<OcupanteYPrestamo> ocupantes;
    private Queue<OcupanteYPrestamo> queue;
    private int cupo;
    private boolean habilitado;
    private String razonDeshabilitado;
    
    public Laboratorio(int cupo) {
        this.ocupantes = new LSE<>();
        this.queue = new Queue<>();
        this.cupo = cupo;
        this.habilitado = true;
        this.razonDeshabilitado = "";
    }

    public LSE<OcupanteYPrestamo> getOcupantes() {
        return ocupantes;
    }

    public void setRegistroIngresoYSalida(LSE<OcupanteYPrestamo> ocupantes) {
        this.ocupantes = ocupantes;
    }

    public Queue<OcupanteYPrestamo> getQueue() {
        return queue;
    }

    public void setQueue(Queue<OcupanteYPrestamo> queue) {
        this.queue = queue;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
        if(habilitado){
            this.razonDeshabilitado = "";
        }
    }

    public String getRazonDeshabilitado() {
        return razonDeshabilitado;
    }

    public void setRazonDeshabilitado(String razonDeshabilitado) {
        this.razonDeshabilitado = razonDeshabilitado;
    }
    
    public int obtenerCantidadHerramientas(){
        int contador = 0;
        for (int i = 0; i < ocupantes.getSize(); i++) {
            for (int j = 0; j < ocupantes.get(i).getHerramientas().getSize(); j++) {
                contador++;
            }
        }
        return contador;
    }
    
    public Herramienta obtenerHerramientaIndex(int index){
        int i = -1;
        for (int j = 0; j < ocupantes.getSize(); j++) {
            for (int k = 0; k < ocupantes.get(j).getHerramientas().getSize(); k++) {
                i++;
                if(i == index){
                    return ocupantes.get(j).getHerramientas().get(k);
                }
            }
        }
        return null;
    }
    
    public void devolverHerramientas(){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            for (int j = 0; j < ocupantes.get(i).getHerramientas().getSize(); j++) {
                ocupantes.get(i).getHerramientas().get(j).setDisponible(true);
            }
            ocupantes.get(i).getHerramientas().removeAll();
        }
        Universidad.serializarLaboratorios();
        Universidad.serializarHerramientas();
    }
    
    public int obtenerCupoDisponible(){
        return cupo - ocupantes.getSize();
    }
    
    public Herramienta buscarHerramienta(int id){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).buscarHerramienta(id) != null){
                return ocupantes.get(i).buscarHerramienta(id);
            }
        }
        return null;
    }
    
    public boolean devolverHerramienta(int id){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).removerHerramienta(id)){
                return true;
            }
        }
        return false;
    }
    
    public OcupanteYPrestamo buscarPrestamo(String user){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).getEstudiante().getUser().equals(user)){
                return ocupantes.get(i);
            }
        }
        return null;
    }
    
    public Estudiante buscarOcupanteUsuario(String user){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).getEstudiante().getUser().equals(user)){
                return ocupantes.get(i).getEstudiante();
            }
        }
        return null;
    }
    
    public Estudiante buscarOcupante(String documento){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).getEstudiante().getDocumento().equals(documento)){
                return ocupantes.get(i).getEstudiante();
            }
        }
        return null;
    }
    
    public boolean registrarOcupante(Estudiante estudiante) {
        Estudiante aux = buscarOcupante(estudiante.getDocumento());
        if (aux == null) {
            OcupanteYPrestamo ocupante = new OcupanteYPrestamo(estudiante);
            if (validarCupo()) {
                ocupantes.add(ocupante);
                Universidad.serializarLaboratorios();
                return true;
            }else{
                queue.add(ocupante);
                Universidad.serializarLaboratorios();
                return false;
            }
        }
        return false;
    }
    
    public boolean removerOcupante(String user){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            if(ocupantes.get(i).getEstudiante().getUser().equals(user)){
                if(ocupantes.get(i).getHerramientas().getSize() > 0){
                    ocupantes.get(i).devolverHerramientas();
                    Universidad.serializarHerramientas();
                }
                ocupantes.remove(i);
                if(queue.getSize() > 0){
                    ocupantes.add(queue.poll());
                }
                Universidad.serializarLaboratorios();
                return true;
            }
        }
        return false;
    }
    
    public boolean validarCupo(){
        if(ocupantes.getSize() < cupo){
            return true;
        }
        return false;
    }
    
    public void vaciarLaboratorio(){
        for (int i = 0; i < ocupantes.getSize(); i++) {
            ocupantes.get(i).devolverHerramientas();
        }
        ocupantes.removeAll();
        queue.removeAll();
        Universidad.serializarLaboratorios();
        Universidad.serializarHerramientas();
    }
    
    public boolean validarHerramienta(String tipo){
        int contador = 0;
        for (int i = 0; i < ocupantes.getSize(); i++) {
            for (int j = 0; j < ocupantes.get(i).getHerramientas().getSize(); j++) {
                if(ocupantes.get(i).getHerramientas().get(j).getTipo().equals(tipo)){
                    contador++;
                }
            }
        }
        if(contador < 2){
            return true;
        }
        return false;
    }
    
}
