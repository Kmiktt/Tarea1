package org.example;

public class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private int precio;
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    //public int num;

    public Expendedor(int i, int p){
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();
        precio = p;
        //num = i;
        Bebida b;
        Bebida s;
        for (int x =0; x<i; x++){
            b= new CocaCola();
            s= new Sprite();
            coca.addBebida(b);
            sprite.addBebida(s);
        }
    }
    public Bebida comprarBebida(Moneda m, int x){
        if (m!=null) {
            if (m.getValor()<precio || x<1 || x>2){
                monVu.addMoneda(m);
                return null;
            } else {
                Bebida b;
                if (x==COCA) b = coca.getBebida();
                else b=sprite.getBebida();
                if (b==null){
                    monVu.addMoneda(m);
                    return b;
                } else if (m.getValor()>precio) {
                    int cuanto = m.getValor()-precio;
                    Moneda place;
                    while (cuanto>0){place = new Moneda100(); monVu.addMoneda(place); cuanto-=100;}
                }
                return b;

            }
        }
        return null;
    }
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}

