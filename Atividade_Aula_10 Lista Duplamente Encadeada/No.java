package aula_21_03;

public class No {
    private int elemento;
    private No proximo;
    private No anterior;

    public No(int valor){
        this.elemento = valor;
        this.anterior = null;
        this.proximo = null;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public int getElemento() {
        return elemento;
    }
}