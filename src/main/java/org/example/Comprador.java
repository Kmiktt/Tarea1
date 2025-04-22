package org.example;
public class Comprador{
    private String sonido;
    private int vuelto = 0;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida b = exp.comprarBebida(m,cualBebida);
        if (b==null) sonido = null;
        else sonido = b.consumir();
        Moneda t = exp.getVuelto();
        while (t!=null){
            vuelto+=t.getValor();
            t=exp.getVuelto();
        }
    }
    public String queBebiste(){
        return sonido;
    }
    public int cuantoVuelto(){
        return vuelto;
    }
}