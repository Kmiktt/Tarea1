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
        var con = System.console();
        while(con != null) {
            System.out.println("¿Que moneda deseas seleccionar?");
            for (int i = 0; i < money.size(); i++) {
                System.out.println("["+i+"] - Moneda de "+money.get(i).getValor()+" pesos");
            }
            con = System.console();
            int a = 0;
            if (con != null) {
                Scanner preg = new Scanner(con.reader());
                a = preg.nextInt();
                while (a > 2 || a < 0) {
                    System.out.println("moneda incorrecta, vuelva a intentarlo");
                    preg = new Scanner(con.reader());
                    a = preg.nextInt();
                }
            }
            int b = 0;
            if (con != null) {
                Scanner preg = new Scanner(con.reader());
                System.out.println("¿Que producto deseas comprar?");
                for (Productos Var : Productos.values()) {
                    System.out.println("["+Var.getNum()+"] - "+ Var);
                }
                b = preg.nextInt();
            }
            try {
                // * desde acá hasta acá es libre edición
                Comprador comp = new Comprador(money.get(a), b, exp);
                System.out.println("el cliente consumio:" + comp.queConsumiste());
                System.out.println("y su vuelto es:" + comp.cuantoVuelto() + "\n");
                // *
            } catch (NoHayProductoException e) {
                System.out.println("El producto no se encuentra o no existe");
            } catch (PagoIncorrectoException e) {
                System.out.println("La moneda ingresada no existe");
            } catch (PagoInsuficienteException e) {
                System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada");
            }
            System.out.println("¿Desea comprar algo mas?\n" +
                    "[0] - si\n" +
                    "[1] - no\n");
            Scanner preg = new Scanner(con.reader());
            if(preg.nextInt() == 1)break;
        }

    }
}