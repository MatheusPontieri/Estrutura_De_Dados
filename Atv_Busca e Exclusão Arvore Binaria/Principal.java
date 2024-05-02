public class Principal {

        public static void main(String[] args) {
            ArvoreBinaria arvore = new ArvoreBinaria();
            arvore.inserirNo(arvore.noRaiz, 3);
            arvore.inserirNo(arvore.noRaiz, 1);
            arvore.inserirNo(arvore.noRaiz, 10);

            System.out.println("In-Order:");
            arvore.inOrder(arvore.noRaiz);

            System.out.println("Pre-Order:");
            arvore.preOrder(arvore.noRaiz);

            System.out.println("Post-Order:");
            arvore.postOrder(arvore.noRaiz);
        }
}
