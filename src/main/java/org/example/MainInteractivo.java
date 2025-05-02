package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        //el código inicia con cada
        var con = System.console();
        int cantProd;
        System.out.println("elija la cantidad de productos por expendendor:");
        Scanner preg = new Scanner(con.reader());
        cantProd = preg.nextInt();
        Expendedor exp = new Expendedor(cantProd);
        while(con != null) {
            //variables principales
            int cualProd;
            //selección de moneda
            System.out.println("""
                    ¿Que moneda deseas seleccionar?
                    [0] - Moneda de 100 pesos
                    [1] - Moneda de 500 pesos
                    [2] - Moneda de 1000 pesos
                    """);
            cantProd = preg.nextInt();
            //moneda inicializada dependiendo del valor, es nula si no está dentro del menú
            Moneda mon = null;
            switch (cantProd){
                case 0: {
                    mon = new Moneda100();
                }
                case 1: {
                    mon = new Moneda500();
                }
                case 2: {
                    mon = new Moneda1000();
                }
            }
            //elección de producto
            System.out.println("""
                    ¿Que producto deseas comprar?
                    [1] - COCACOLA
                    [2] - SPRITE
                    [3] - FANTA
                    [4] - SUPER8
                    [5] - SNICKER
                    """);
            cualProd = preg.nextInt();
            try {
                // el comprador obtiene la moneda, el producto y el expendedor y
                // luego se imprime lo que compró y su vuelto
                Comprador comp = new Comprador(mon, cualProd, exp);
                System.out.println("El cliente consumio: " + comp.queConsumiste());
                System.out.println("Y su vuelto es: " + comp.cuantoVuelto() + "\n");
            } catch (NoHayProductoException e) {
                System.out.println("El producto no se encuentra o no existe\n");
            } catch (PagoIncorrectoException e) {
                System.out.println("La moneda ingresada no existe\n");
            } catch (PagoInsuficienteException e) {
                System.out.println("El valor del producto es mayor a la cantidad de dinero ingresada\n");
            }
            //menú de salida
            System.out.println("""
                    ¿Desea comprar algo mas?
                    [0] - si
                    [1] - no
                    """);
            if(preg.nextInt() == 1)break;
            con = System.console();
        }
    }
}