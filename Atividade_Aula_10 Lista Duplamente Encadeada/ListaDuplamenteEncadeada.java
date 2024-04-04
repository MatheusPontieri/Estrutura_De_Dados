package aula_21_03;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    public void inserirInicio(int elemento){
        No noAux = new No(elemento);
        
        if(listaVazia()) {
            this.inicio = noAux; 
            this.fim = noAux;
        } else {
            inicio.setAnterior(noAux);
            noAux.setProximo(inicio);
            this.inicio = noAux;
        }
        
        this.tamanho++;
    }

    public void inserirMeio(int elemento){
        No noAux = new No(elemento); // No do meio que será inserido
        No noAtual = this.inicio;

        while(elemento > noAtual.getElemento() && elemento > noAtual.getProximo().getElemento()){
            noAtual = noAtual.getProximo();
        }

        noAux.setProximo(noAtual.getProximo());
        noAtual.setProximo(noAux);

        noAux.getProximo().setAnterior(noAux);
        noAux.setAnterior(noAtual);

        this.tamanho++;
    }

    public void inserirFim(int elemento){
        No noAux = new No(elemento);

        noAux.setAnterior(this.fim);
        this.fim.setProximo(noAux);

        this.fim = noAux;

        this.tamanho++;
    }

    public void removerInicio(){
        No noAux = this.inicio;

        this.inicio = noAux.getProximo();
        this.inicio.setAnterior(null);
        noAux.setProximo(null);

        this.tamanho--;
    }

    public void removerMeio(int elemento){
        No noAux = this.inicio;

        while (noAux.getProximo().getElemento() != elemento) {
            noAux = noAux.getProximo();
        }

        noAux.setProximo(noAux.getProximo().getProximo());
        noAux.getProximo().setAnterior(noAux);

        this.tamanho--;
    }

    public void removerFim(){
        this.fim = this.fim.getAnterior();
        this.fim.setProximo(null);

        this.tamanho--;
    }

    public void remover(int elemento){
        if(elemento == this.inicio.getElemento()){
            removerInicio();
        }
        else if(elemento == this.fim.getElemento()){
            removerFim();
        }
        else {
            removerMeio(elemento);
        }
    }

    public void inserir(int elemento){
        if (listaVazia() ||  elemento < this.inicio.getElemento()){
            inserirInicio(elemento);
        }
        else if(elemento > fim.getElemento()){
            inserirFim(elemento);
        }
        else{
            inserirMeio(elemento);
        }
    }

    public void imprimir(){
        No noAux = this.inicio;

        while (noAux != null) {
            System.out.println(noAux.getElemento());
            noAux = noAux.getProximo();
        }
    }

    public int tamanhoLista(){
        return this.tamanho;
    }

    public boolean listaVazia(){
        return inicio == null ? true : false;
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(4);
        lista.inserir(3);
        lista.imprimir();

        System.out.println("\nTamanho: "+lista.tamanho+"\n");

        lista.remover(1);
        lista.remover(3);
        lista.remover(4);
        lista.imprimir();

        System.out.println("\nTamanho: "+lista.tamanho+"\n");

        lista.inserir(3);
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
