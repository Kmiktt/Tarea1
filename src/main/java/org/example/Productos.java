package org.example;

public enum Productos {
    COCACOLA(600,1),
    SPRITE(700,2),
    FANTA(600,3),
    SUPER8(400,4),
    SNICKER(500,5);

    private int precio;
    private int num;
    Productos(int p, int n){
        this.precio = p;
        this.num = n;
    }
    public int getPrecio(){
        return precio;
    }
    public int getNum(){
        return num;
    }
}
