package org.example;
import java.util.ArrayList;

public class DepositoM {
    private ArrayList<Moneda> alm;
    public DepositoM(){
        alm = new ArrayList<Moneda>();
    }
    public void addMoneda(Moneda m){
        alm.add(m);
    }
    public Moneda getMoneda(){
        if ((alm.size()!=0)) return alm.remove(0);
        else return null;
    }
}
