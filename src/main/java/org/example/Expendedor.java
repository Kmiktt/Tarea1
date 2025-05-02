package org.example;

public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snicker;
    private Deposito<Moneda> monVu;
    private int precio;

    public Expendedor(int i){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        snicker = new Deposito<Producto>();
        monVu = new Deposito<Moneda>();
        Producto b;
        for (int x =0; x<i; x++){
            b= new CocaCola();
            coca.add(b);
            b = new Sprite();
            sprite.add(b);
            b = new Fanta();
            fanta.add(b);
            b = new Snickers();
            snicker.add(b);
            b = new Super8();
            super8.add(b);
        }
    }
    public Producto comprarProducto(Moneda m, int x) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto p=null;
        int vuelto=0;
        boolean check = false;
        if (m!=null) {
            if (x == Productos.COCACOLA.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.COCACOLA.getPrecio();
                if (vuelto>=0){
                    p = coca.get();
                }
            }
            if (x == Productos.SPRITE.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SPRITE.getPrecio();
                if (vuelto>=0){
                    p = sprite.get();
                }
            }
            if (x == Productos.FANTA.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.FANTA.getPrecio();
                if (vuelto>=0){
                    p = fanta.get();
                }
            }
            if (x == Productos.SNICKER.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SNICKER.getPrecio();
                if (vuelto>=0){
                    p = snicker.get();
                }
            }
            if (x == Productos.SUPER8.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SUPER8.getPrecio();
                if (vuelto>=0){
                    p = super8.get();
                }
            }
            // dependiendo del problema se lanza la excepción correspondiente:
            if(x > 6 || x < 0){
                monVu.add(m);
                throw new NoHayProductoException();
            }
            if (!check){
                monVu.add(m);
                throw new NoHayProductoException();
            }
            if (vuelto<0){
                monVu.add(m);
                throw new PagoInsuficienteException();
            }
            if (p==null){
                monVu.add(m);
                throw new NoHayProductoException();
            }
            Moneda place;
            while (vuelto>0){place = new Moneda100(); monVu.add(place); vuelto-=100;}
        }
        else throw new PagoIncorrectoException();
        return p;
    }
    public Moneda getVuelto(){
        return monVu.get();
    }
}