/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Pixels
 */
public class Nodo<T> implements Serializable{
    private T dato;
    private Nodo<T> nodoSig;
    
    public Nodo(T dato){
        this.dato = dato;
        this.nodoSig = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getNodoSig() {
        return nodoSig;
    }

    public void setNodoSig(Nodo<T> nodoSig) {
        this.nodoSig = nodoSig;
    }
    
}
