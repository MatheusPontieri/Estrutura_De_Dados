public class No {
    private No proximo;
    private int elemento;

    public No(){
        
    }

    public No(int elemento){
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public int getElemento() {
        return elemento;
    }
    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

}
