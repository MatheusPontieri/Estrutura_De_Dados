public class PilhaDinamica <T>{
    private No <T> topo;

    public PilhaDinamica(){
        this.topo = null;
    }

    public void push(T elemento){
        No<T> noAux = new No<T>(elemento);
        noAux.setProximo(this.topo);
        this.topo = noAux;
    }

    public void pop(){
        if (this.topo == null)
            return;
            
        No<T> noAux = this.topo;
        this.topo = noAux.getProximo();
    }

    public int retornaTamanho(){
        No<T> noAux = topo;
        int tamanho = 0;

        while (noAux != null){
            noAux = noAux.getProximo();
            tamanho++;
        }
    
        return tamanho;
    }

    public boolean pilhaVazia(){
        return topo == null;
    }

    public void imprimir(){
        imprimir(topo);
    }

    private void imprimir(No<T> no){
        if(no == null)
            return;
    
        System.out.println(no.getElemento());
        imprimir(no.getProximo());
    }

    public static void main(String[] args) {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>();
        pilha.imprimir();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);

        pilha.imprimir();
        
        System.out.println(pilha.retornaTamanho());

        pilha.pop();
        pilha.pop();

        System.out.println(pilha.retornaTamanho());
    }
}