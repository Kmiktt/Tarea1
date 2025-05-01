package org.example;
public class Comprador{
    private String sabor;
    private int vuelto = 0;
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
    public String queConsumiste(){
        return sabor;
    }
    public int cuantoVuelto(){
        return vuelto;
    }
}