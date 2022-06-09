/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Pixels
 * @param <T>
 */
public class Queue<T> implements Serializable {
    private Nodo<T> primero;
    private int size;
    
    public Queue(){
        this.primero = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    /**
     * Permite agregar un dato a la lista en la ultima posición.
     * @param dato el dato que se quiere ingresar a la lista.
     */
    public void add(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if(primero == null){
            primero = nuevo;
        }else {
            Nodo<T> aux = primero;
            while(aux.getNodoSig() != null){
                aux = aux.getNodoSig();
            }
            aux.setNodoSig(nuevo);
        }
        this.size++;
    }
    
    public T peek(){
        if(primero == null){
            return null;
        }
        return this.primero.getDato();
    }
    
    public T poll(){
        if(primero == null){
            return null;
        }
        T dato = primero.getDato();
        primero = primero.getNodoSig();
        this.size--;
        return dato;
    }
    
    public void removeAll(){
        primero = null;
        this.size = 0;
    }
}
