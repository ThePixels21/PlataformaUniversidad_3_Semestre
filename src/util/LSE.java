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
public class LSE<T> implements Serializable{
    private Nodo<T> primero;
    private int size;
    
    public LSE(){
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
    /**
     * Permite obtener un dato en una posición.
     * @param i index del dato el cual se quiere obtener
     * @return El dato que se quiere obtener.
     */
    public T get(int i){
        Nodo<T> aux = primero;
        if(i >= size || i < 0){
            throw new ArrayIndexOutOfBoundsException(i);
        }else {
            if(i == 0){
                return aux.getDato();
            }else {
                int contador = 0;
                while(contador < i){
                    aux = aux.getNodoSig();
                    contador++;
                }
            }
        }
        return aux.getDato();
    }
    
    /**
     * Este método remueve el nodo de la posición requerida de la lista, 
     * cambiando la referencia del nodo al cual apuenta el anterior por 
     * el nodo siguiente del mismo.
     * @param i posición del objeto a eliminar de la lista.
     */
    public void remove(int i){
        /*Verificar si el index ingresado está fuera del rango de 
        la lista para lanzar una excepción.*/
        if(i >= size || i < 0){
            throw new ArrayIndexOutOfBoundsException(i);
        }else{
            /*Si el index es 0, se cambia el nodo de la primera posición
            por el nodo siguiente al cual apunta el mismo, para así remover 
            el primer nodo de la lista.*/
            if(i == 0){ 
                primero = primero.getNodoSig();
            }else{
                Nodo<T> anterior = primero;
                int contador = 0;
                /*Se obtiene el nodo que está en la posición anterior del nodo
                a eliminar en la variable auxiliar "anterior".*/
                while(contador < i - 1){
                    anterior = anterior.getNodoSig();
                    contador++;
                }
                /*Se obtiene el nodo que está en la siguiente posición del nodo
                a eliminar en la variable auxiliar "siguiente".*/
                Nodo<T> siguiente = anterior.getNodoSig().getNodoSig();
                /*Se reemplaza la referencia guardada por nodo anterior al nodo 
                a eliminar por el nodo siguiente del mismo, para así remover el 
                nodo requerido de la lista.*/
                anterior.setNodoSig(siguiente);
            }
        }
        //Se resta uno al tamaño de la lista debido nodo removido.
        this.size--;
    }
    /**
     * Este método guarda un dato en la lista dependiendo un index
     * que será la posición en la cual se guardará el mismo.
     * @param dato a guardar en la lista
     * @param i index en el cual se va a guardar
     */
    public void add(T dato, int i) {
        //Se crea el nuevo nodo
        Nodo<T> nuevo = new Nodo<>(dato);
        //Se valida que el index recibido sea válido
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i);
        } else {
            /*Si el index es 0 se le asigna al nuevo nodo el nodo
              siguiente de la posición a la cual se quiere agregar y
              luego se asigna el primer nodo por el nuevo.*/
            if (i == 0) {
                nuevo.setNodoSig(primero);
                primero = nuevo;
            } else {
                //Se guarda el nodo de la primera posición.
                Nodo<T> aux = primero;
                int contador = 1;
                //Se obtiene el nodo anterior del index.
                while (i > contador) {
                    aux = aux.getNodoSig();
                    contador++;
                }
                /*Se le asigna al nuevo nodo el nodo siguiente del index
                  recibido y se le asigna al nodo anterior del index el
                  nodo a agregar.*/
                nuevo.setNodoSig(aux.getNodoSig());
                aux.setNodoSig(nuevo);
            }
        }
        //Se aumenta en 1 el tamaño de la lista.
        size++;
    }
    
    public void removeAll(){
        primero = null;
        this.size = 0;
    }
}
