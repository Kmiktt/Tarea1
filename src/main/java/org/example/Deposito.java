package org.example;
import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> al;
    public  Deposito(){
        al = new ArrayList<T>();
    }
    public void add(Bebida b){
        al.add(b);
    }
    public T get(){
        if ((al.size()!=0)) return al.remove(0);
        else return null;
    }
}
