package org.example;

public class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    //public int num;

    public Expendedor(int i, int p){
        coca = new Deposito();
        sprite = new Deposito();
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
    public Bebida comprarBebida(Moneda m, int x){
        if (m!=null) {
            if (m.getValor()<precio || x<1 || x>2){
                monVu.add(m);
                return null;
            } else {
                Bebida b;
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
