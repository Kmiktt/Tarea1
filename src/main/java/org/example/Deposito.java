package org.example;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> al;
    public  Deposito(){
        al = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida b){
        al.add(b);
    }
    public Bebida getBebida(){

        if ((al.size()!=0)) return al.remove(0);
        else return null;
    }
}
