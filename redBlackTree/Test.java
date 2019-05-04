package redBlackTree;

/**
 *
 * @author Leisia
 */
public class Test {

    private static final int INDENT_STEP = 4;

    public static void print(No raiz, int indent) {
        if (raiz.getFilhoDireito() != null) {
            print(raiz.getFilhoDireito(), indent + INDENT_STEP);
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        if (raiz.getCor() == 'N') {
            System.out.println(raiz.getValor());
        } else {
            System.out.println("<" + raiz.getValor() + ">");
        }
        if (raiz.getFilhoEsquerdo() != null) {
            print(raiz.getFilhoEsquerdo(), indent + INDENT_STEP);
        }

    }

    public static void emOrdem(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + "(" + raiz.getCor() + ")");
            emOrdem(raiz.getFilhoEsquerdo());
            emOrdem(raiz.getFilhoDireito());
        }
    }

    public static void main(String[] args) {
        RN rn = new RN();

       rn.inserir(rn.getRaiz(), 29);
       rn.inserir(rn.getRaiz(), 12);
       rn.inserir(rn.getRaiz(), 41);
       rn.inserir(rn.getRaiz(), 5);
       rn.inserir(rn.getRaiz(), 25);
       rn.inserir(rn.getRaiz(), 3);
       rn.inserir(rn.getRaiz(), 4);
       rn.inserir(rn.getRaiz(), 2);

       rn.remover(rn.getRaiz(), 25);
       rn.remover(rn.getRaiz(), 29);
       rn.remover(rn.getRaiz(), 41);
       rn.remover(rn.getRaiz(), 12);
       //rn.remover(rn.getRaiz(), 5);
       //rn.remover(rn.getRaiz(), 2);

        System.out.println("Raiz " + rn.getRaiz());
        emOrdem(rn.getRaiz());
        System.out.println('\n');

        // the tree root is being printed on the left
        print(rn.getRaiz(), 3);

    }

}
