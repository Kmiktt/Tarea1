package org.example;

/**Enum encargado de almacenar los precios y el valor numerico que
 * ingresar al expendedor para comprar cada producto (Cocacola, Sprite, Fanta,
 * Super8 y Snickers)*/
public enum Productos {
    COCACOLA(600,1),
    SPRITE(700,2),
    FANTA(600,3),
    SUPER8(400,4),
    SNICKER(500,5);

    private int precio;
    private int num;
    /**Constructor de enum
     *@param p Precio del producto
     *@param n Numero que ingresar en Expendedor para comprar el producto*/
    Productos(int p, int n){
        this.precio = p;
        this.num = n;
    }
    /**Getter de precio*/
    public int getPrecio(){
        return precio;
    }
    /**Getter de número de compra*/
    public int getNum(){
        return num;
    }
}
