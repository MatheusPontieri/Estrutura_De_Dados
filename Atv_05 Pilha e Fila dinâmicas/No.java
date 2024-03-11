public class No<T> {
    private T elemento;
    private No<T> proximo;

    public No(T valor){
        this.elemento = valor;
        this.proximo = null;
    }

    public T getElemento(){
        return this.elemento;
    }

    public void setElemento(T valor){
        this.elemento = valor;
    }

    public No<T> getProximo(){
        return this.proximo;
    }

    public void setProximo(No<T> no){
        this.proximo = no;
    }
}
