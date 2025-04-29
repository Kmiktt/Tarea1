package org.example;

public abstract class Moneda implements Comparable<Moneda>{

    public abstract int getValor();
    @Override
    public int compareTo(Moneda o) {
        if (this.getValor() > o.getValor()) {
            return 1;
        } else if (this.getValor() < o.getValor()) {
            return -1;
        } else {
            return 0;
        }
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}