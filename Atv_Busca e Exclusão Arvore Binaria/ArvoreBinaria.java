import Atv 
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
}
