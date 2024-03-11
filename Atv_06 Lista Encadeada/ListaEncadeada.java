public class ListaEncadeada {
    private No inicio;
    private No fim;

    public void inserir(int elemento){ // Inserir no Fim
        if (this.inicio == null){
            inicio = new No(elemento);
            fim = inicio;
        }
        else {
            No noAux = new No(elemento);
            fim.setProximo(noAux);
            fim = noAux;
        }
    }

    public void inserirComeco(int elemento){
        No noAux = new No(elemento);
        noAux.setProximo(this.inicio);
        this.inicio = noAux;
    }

    public void inserirMeio(int elemento, int objetivo){
        No noMeio = new No(elemento);

        No noInicio = percorrer(this.inicio,0, objetivo - 1);
        No noFim = noInicio.getProximo();

        noInicio.setProximo(noMeio);
        noMeio.setProximo(noFim);
    }

    public void inserirOrdenado(int elemento){ // Verificar se o próximo é maior que o atual. 0, 1, 2, 3, 4, 5
        int cont = 1;
        No noAux = this.inicio;

        if (this.estaVazia()) inserirComeco(elemento);

        while (noAux.getProximo().getElemento() < elemento) {
            noAux = noAux.getProximo();
            cont++;
        }

        inserirMeio(elemento, cont);
    }    

    public void remover(){ // Remover no Fim
        No noAux = this.inicio; 
        
        while(true){
            if (noAux.getProximo() == null) {
                fim = null;
                return;
            }

            else if (noAux.getProximo().getProximo() == null) {
                this.fim = noAux;
                fim.setProximo(null);
                return;
            }
            else 
                noAux = noAux.getProximo();
        }
    }

    public void removerComeco(){
        this.inicio = inicio.getProximo(); 
    }

    public void removerMeio(int objetivo){
        No noInicio = percorrer(this.inicio, 0, objetivo - 1);
        No noFim = noInicio.getProximo().getProximo();

        noInicio.setProximo(noFim);
    }

    public void imprimir(){
        No noAux = this.inicio;

        while(noAux != null) {
            System.out.println(noAux.getElemento());
            noAux = noAux.getProximo();
        }
        System.out.println("---\n");
    }

    public int tamanho(){
        int cont = 0;
        No noAux = this.inicio;
        while (noAux != null){
            noAux = noAux.getProximo();
            cont++;
        }

        return cont;
    }

    public boolean estaVazia(){
        return this.inicio == null;
    }

    private No percorrer(No no, int atual, int objetivo){
        if (atual == objetivo)
            return no;

        return percorrer(no.getProximo(), ++atual, objetivo);
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        
        System.out.println("Está vazia: "+lista.estaVazia());
        lista.inserir(1);
        lista.inserir(3);
        lista.inserirOrdenado(2);
        System.out.println("Tamanho: "+lista.tamanho());
        lista.imprimir();

        lista.inserirMeio(2, 1);
        lista.imprimir();

        lista.inserirComeco(0);
        lista.imprimir();

        lista.remover();
        lista.imprimir();

        lista.removerMeio(1);
        lista.imprimir();

        lista.removerComeco();
        System.out.println("Tamanho: "+lista.tamanho());
        System.out.println("Está vazia: "+lista.estaVazia());
        lista.imprimir();
    }
}