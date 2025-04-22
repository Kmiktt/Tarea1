package org.example;

public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snicker;
    private Deposito<Moneda> monVu;
    private int precio;
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    //public int num;

    public Expendedor(int i, int p){
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        super8 = new Deposito();
        snicker = new Deposito();
        monVu = new Deposito();
        precio = p;
        //num = i;
        Bebida b;
        Bebida s;
        for (int x =0; x<i; x++){
            b= new CocaCola();
            s= new Sprite();
            coca.add(b);
            sprite.add(s);
        }
    }
    public Producto comprarProducto(Moneda m, int x){
        Producto p;
        int vuelto;
        if (m!=null) {
            if (x == Productos.COCACOLA.getNum()){
                vuelto = m.getValor()-Productos.COCACOLA.getPrecio();
                if (vuelto>=0){
                    p = coca.get();
                }
            }
            if (x == Productos.SPRITE.getNum()){

            }
            if (x == Productos.FANTA.getNum()){

            }
            if (x == Productos.SNICKER.getNum()){

            }
            if (x == Productos.SUPER8.getNum()){

            }
            if (m.getValor()<precio || x<1 || x>2){
                monVu.add(m);
                return null;
            } else {
                Producto b;
                if (x==COCA) b = coca.get();
                else b=sprite.get();
                if (b==null){
                    monVu.add(m);
                    return b;
                } else if (m.getValor()>precio) {
                    int cuanto = m.getValor()-precio;
                    Moneda place;
                    while (cuanto>0){place = new Moneda100(); monVu.add(place); cuanto-=100;}
                }
                return b;

            }
        }
        return null;
    }
    public Moneda getVuelto(){
        return monVu.get();
    }
}
