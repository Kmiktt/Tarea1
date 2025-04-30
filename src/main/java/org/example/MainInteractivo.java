package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        ArrayList<Moneda> money=new ArrayList<Moneda>();
        money.add(new Moneda500());
        money.add(new Moneda100());
        money.add(new Moneda1000());

        money.sort(null);
        System.out.println("¿Que moneda deseas seleccionar?");
        for (int i = 0; i < money.size(); i++) {
            System.out.println("["+i+"] - Moneda de "+money.get(i).getValor()+" pesos");
        }
        var con = System.console();
        if (con != null) {
            Scanner preg = new Scanner(con.reader());
            int i =preg.nextInt();
        }
    }
}