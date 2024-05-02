public class ArvoreBinaria {
    public No noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void inserirNo(No noAtual, int elemento) {
        if (this.noRaiz == null) {
            this.noRaiz = new No(elemento);
        } else {
            if (elemento < noAtual.elemento) {
                if (noAtual.esquerda == null) {
                    noAtual.esquerda = new No(elemento);
                } else {
                    inserirNo(noAtual.esquerda, elemento);
                }
            } else if (elemento > noAtual.elemento) {
                if (noAtual.direita == null) {
                    noAtual.direita = new No(elemento);
                } else {
                    inserirNo(noAtual.direita, elemento);
                }
            }
        }
    }

    public void inOrder(No no) {
        if (no != null) {
            inOrder(no.esquerda);
            System.out.println(no.elemento);
            inOrder(no.direita);
        }
    }

    public void preOrder(No no) {
        if (no != null) {
            System.out.println(no.elemento);
            preOrder(no.esquerda);
            preOrder(no.direita);
        }
    }

    public void postOrder(No no) {
        if (no != null) {
            postOrder(no.esquerda);
            postOrder(no.direita);
            System.out.println(no.elemento);
        }
    }

    public boolean buscar(int valor) {
        return buscarNo(this.noRaiz, valor);
    }

    private boolean buscarNo(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.elemento == valor) {
            return true;
        }

        if (valor < raiz.elemento) {
            return buscarNo(raiz.esquerda, valor);
        } else {
            return buscarNo(raiz.direita, valor);
        }
    }

    void excluir(No raiz, int valor) {
        if (raiz == null) 
            return;
        
        if (valor < raiz.elemento) 
            excluir(raiz.esquerda, valor);
        else if (valor > raiz.elemento) 
            excluir(raiz.direita, valor);
        else 
            raiz = null;
    
    }
}