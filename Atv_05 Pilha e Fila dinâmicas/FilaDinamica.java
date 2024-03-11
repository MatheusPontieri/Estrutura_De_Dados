public class FilaDinamica<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public void push(T elemento){
        if (this.primeiro == null) {
            this.primeiro = new No<T>(elemento);
            this.ultimo = primeiro;
        }

        else {
            No<T> noAux = new No<>(elemento);
            ultimo.setProximo(noAux); // Atualiza o próximo do primeiro (e do último tbm).
            ultimo = noAux; // Deixa o último apenas com o último adicionado. Mesmo assim, ainda apontam pro mesmo objeto
        }
    }

    public void pop(){
        if (primeiro != null) {
            primeiro = primeiro.getProximo(); 
            if (primeiro == null)
                ultimo = null;
        }
    }

    public int retornaTamanho(){
        int tamanho = 0;
        No<T> noAux = primeiro;

        while(noAux != null){
            noAux = noAux.getProximo();
            tamanho++;
        }

        return tamanho;
    }

    public boolean filaVazia(){
        return primeiro == null;
    }

    public void imprimir(){
        imprimir(primeiro);
    }

    private void imprimir(No<T> no){
        if (no == null)
            return;
        System.out.println(no.getElemento());
        imprimir(no.getProximo());
    }

    public static void main(String[] args) {
        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.push(1);
        fila.push(2);
        fila.push(3);

        System.out.println("---");
        fila.imprimir();
        System.out.println("---");
        
        System.out.println(fila.retornaTamanho());

        fila.pop();
        fila.pop();
        System.out.println(fila.retornaTamanho());

        fila.pop();
        fila.pop();
        System.out.println(fila.filaVazia());
        fila.push(1);
    }
}
