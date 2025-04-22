package org.example;

//Clase Principal, usamos esta clase para polimorfismo
public abstract class Producto{
    public Producto(){
    }
    //Metodo que entrega el sabor
    public abstract String consumir();
}
//Para todas las bebidas, no incluye ningún metodo especifico
abstract class Bebida extends Producto{
    public Bebida(){

    }
}
//Para todos los dulces, no incluye ningún metodo especifico
abstract class Dulce extends Producto {
    public Dulce (){

    }
}
class Sprite extends Bebida {
    public Sprite(){
    }
    public String consumir(){
        return ("sprite");
    }
}
class CocaCola extends Bebida {
    public CocaCola(){

    }
    public String consumir(){
        return ("cocacola");
    }
}
class Fanta extends Bebida {
    public Fanta(){

    }
    public String consumir(){
        return ("fanta");
    }
}
class Super8 extends Dulce {
    public Super8(){

    }
    public String consumir(){return ("super8");}
}
class Snickers extends Dulce {
    public Snickers(){

    }
    public String consumir(){return ("snickers");}
}