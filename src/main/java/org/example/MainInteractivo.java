package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(20);
        var con = System.console();
        while(con != null) {
            System.out.println("¿Que moneda deseas seleccionar?");
            System.out.println("[0] - Moneda de 100 pesos\n" +
                    "[1] - Moneda de 500 pesos\n" +
                    "[2] - Moneda de 1000 pesos\n");
            con = System.console();
            int a = 0;
            if (con != null) {
                Scanner preg = new Scanner(con.reader());
                a = preg.nextInt();
            }
            Moneda m = null;
            switch (a){
                case 0: {
                    m = new Moneda100();
                }
                case 1: {
                    m = new Moneda500();
                }
                case 2: {
                    m = new Moneda1000();
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
                Comprador comp = new Comprador(m, b, exp);
                System.out.println("el cliente consumio:" + comp.queConsumiste());
                System.out.println("y su vuelto es:" + comp.cuantoVuelto() + "\n");
                // *
            } catch (NoHayProductoException e) {
                System.out.println("El producto no se encuentra o no existe\n");
            } catch (PagoIncorrectoException e) {
                System.out.println("La moneda ingresada no existe\n");
            } catch (PagoInsuficienteException e) {
                System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada\n");
            }
            System.out.println("¿Desea comprar algo mas?\n" +
                    "[0] - si\n" +
                    "[1] - no\n");
            Scanner preg = new Scanner(con.reader());
            if(preg.nextInt() == 1)break;
        }

    }
}