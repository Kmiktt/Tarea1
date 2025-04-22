package org.example;

public abstract class Bebida {
    private int serie;
    public Bebida(int x){
        serie=x;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();

}
class Sprite extends Bebida {
    public Sprite(int x){
        super(x);
    }
    public String beber(){
        return ("sprite");
    }
}
class CocaCola extends Bebida {
    public CocaCola(int x){
        super(x);
    }
    public String beber(){
        return ("cocacola");
    }
}
