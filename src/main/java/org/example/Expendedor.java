package org.example;

/** Encargado de almacenar Productos, recibir Monedas y entregar el
producto apropiado si el valor de la moneda es mayor o igual al del
producto*/
public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snicker;
    private Deposito<Moneda> monVu;
    private int precio;

    /**Constructor de Expendedor.
     * Recibe la cantidad i de productos que va a tener cada deposito,
     * y le entrega a cada deposito de Producto i del producto correspondiente.
     * @param i La cantidad de productos que tendrá cada depósito.*/
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
    /**El expendedor recibe una moneda y el número del producto a comprar,
     * y checkea si es que este numero concuerda con el de algún producto (asignados
     * en el enum). Si es asi, calcula el vuelto a devolver, y devuelve el producto
     * si el vuelto es mayor o igual a 0. En caso de tener vuelto mayor a 0, agrega
     * monedas al deposito de monedas para que el comprador despues recupere.
     * @param m Moneda ingresada al expendedor, se obtiene su valor con m.getValor()
     * @param x Numero ingresado al expendedor, se utiliza para checkear que producto
     * quiere comprar el comprador*/
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
    /** Getter de moneda en deposito de vuelto, null si no quedan monedas
     * @return Moneda de vuelto */
    public Moneda getVuelto(){
        return monVu.get();
    }
}