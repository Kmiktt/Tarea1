package org.example;
import java.util.ArrayList;

/**
 *  un Deposito generico para guardar Objetos T
 */
public class Deposito<T> {
    /** Arraylist para guardar objetos T */
    private ArrayList<T> al;
    /** constructor que crea un nuevo objeto Arraylist*/
    public  Deposito(){
        al = new ArrayList<T>();
    }
    /**
     * @param b objeto tipo T que sera agregado al arraylist
     */
    public void add(T b){
        al.add(b);
    }
    /**
     * @return El primer objeto ingresado (FIFO)
     */
    public T get(){
        if ((al.size()!=0)) return al.remove(0);
        else return null;
    }
}
