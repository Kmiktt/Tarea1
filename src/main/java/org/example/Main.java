package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Moneda> money = new ArrayList<Moneda>();
        /*
        el siguiente for verifica:
        i=0: moneda inexistente
        i=1: moneda insuficiente
        i=2: producto fuera de rango
         */
        money.add(null);
        money.add(new Moneda100());
        money.add(new Moneda1000());
        money.add(new Moneda1000());
        Expendedor exp = new Expendedor(1);

        for (int i = 0; i < 4; i++) {
            try {
                Comprador comp = new Comprador(money.removeFirst(), i + 3, exp);
            } catch (NoHayProductoException e) {
                System.out.println("El producto no se encuentra o no existe");
            } catch (PagoIncorrectoException e) {
                System.out.println("La moneda ingresada no existe");
            } catch (PagoInsuficienteException e) {
                System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada");
            }
        }
        //aqui prueba sacar un producto que no queda mas
        try {
            Comprador comp = new Comprador(new Moneda1000(), 5, exp);
        } catch (NoHayProductoException e) {
            System.out.println("El producto no se encuentra o no existe");
        } catch (PagoIncorrectoException e) {
            System.out.println("La moneda ingresada no existe");
        } catch (PagoInsuficienteException e) {
            System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada");
        }
        //y aqui compra 1 de cada producto y muestra el vuelto recibido acorde a cada uno
        Expendedor exp2 = new Expendedor(1);
        for (int i = 1; i < 6; i++) {
            try {
                Comprador comp = new Comprador(new Moneda1000(), i, exp2);
                System.out.println("Compro "+comp.queConsumiste()+" y de vuelto tuvo "+comp.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("El producto no se encuentra o no existe");
            } catch (PagoIncorrectoException e) {
                System.out.println("La moneda ingresada no existe");
            } catch (PagoInsuficienteException e) {
                System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada");
            }
        }
        //aqui va la prueba del buen funcionamiento del compareto de Moneda
        ArrayList<Moneda> monedasort = new ArrayList<Moneda>();
        monedasort.add(new Moneda500());
        monedasort.add(new Moneda500());
        monedasort.add(new Moneda1000());
        monedasort.add(new Moneda1000());
        monedasort.add(new Moneda100());
        monedasort.add(new Moneda100());
        monedasort.add(new Moneda500());
        monedasort.add(new Moneda100());
        monedasort.add(new Moneda1000());

        monedasort.sort(null);
        for (int i = 0; i < monedasort.size(); i++) {
            System.out.println(monedasort.get(i)+" "+monedasort.get(i).getValor());

        }
    }
}
