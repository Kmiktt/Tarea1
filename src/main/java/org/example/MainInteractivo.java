package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        ArrayList<Moneda> money=new ArrayList<Moneda>();
        money.add(new Moneda500());
        money.add(new Moneda100());
        money.add(new Moneda1000());
        Expendedor exp = new Expendedor(20);

        money.sort(null);
        System.out.println("¿Que moneda deseas seleccionar?");
        for (int i = 0; i < money.size(); i++) {
            System.out.println("["+i+"] - Moneda de "+money.get(i).getValor()+" pesos");
        }
        var con = System.console();
        int a = 0;
        if (con != null) {
            Scanner preg = new Scanner(con.reader());
            a = preg.nextInt();
        }
        int b = 0;
        if (con != null) {
            Scanner preg = new Scanner(con.reader());
            System.out.println("¿Que producto deseas comprar?");
            System.out.println("[1] - cocacola\n" +
                    "[2] - sprite\n" +
                    "[3] - fanta\n" +
                    "[4] - super8\n" +
                    "[5] - snickers\n");
            b = preg.nextInt();
        }
        System.out.println();
        try {
            Comprador comp = new Comprador(money.get(a), b, exp);
            System.out.println(comp.queConsumiste());
            System.out.println(comp.cuantoVuelto());
        }
        catch(NoHayProductoException e){
            System.out.println("El producto no se encuentra o no existe");
        }
        catch(PagoIncorrectoException e){
            System.out.println("La moneda ingresada no existe");
        }
        catch(PagoInsuficienteException e){
            System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada");
        }
    }
}