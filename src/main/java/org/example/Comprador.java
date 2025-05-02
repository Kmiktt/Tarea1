package org.example;
/**Objeto encargado de comprar productos con moneda ingresada al inicializarse, y
 * dejar registrado el sabor y el vuelto de la compra si esta es exitosa.
 * La compra solo se realiza al inicializar el objeto, tras su creación solo se
 * puede consultar por el sabor y por el vuelto.*/
public class Comprador{
    private String sabor;
    private int vuelto = 0;
    /**Metodo constructor, se encarga de intentar comprar el producto indicada con la
     * moneda que se le entrega, registrando el sabor de este y el vuelto que se le devolvió.
     * @param m Moneda para comprar el producto indicado
     * @param cualBebida Numero que se le ingresara al expendedor para comprar el producto indicado
     * @param exp Referencia al expendedor al cual se le va a comprar el Producto*/
    public Comprador(Moneda m, int cualBebida, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto b = exp.comprarProducto(m,cualBebida);
        if (b==null) sabor = null;
        else sabor = b.consumir();
        Moneda t = exp.getVuelto();
        while (t!=null){
            vuelto+=t.getValor();
            t=exp.getVuelto();
        }
    }
    /**Getter de sabor, devuelve null si hubo un error en la compra
     * @return String con sabor del producto*/
    public String queConsumiste(){
        return sabor;
    }
    /**Getter de vuelto, valor default 0 en caso de que la compra no se realize
     * @return Entero que representa dinero restante de la compra*/
    public int cuantoVuelto(){
        return vuelto;
    }
}