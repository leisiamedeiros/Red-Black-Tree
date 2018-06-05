package newpackage;

/**
 *
 * @author Leisia
 */
public class Teste {

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

        rn.inserir(rn.getRaiz(), 8);
        rn.inserir(rn.getRaiz(), 7);
        rn.inserir(rn.getRaiz(), 6);
        rn.inserir(rn.getRaiz(), 5);
        rn.inserir(rn.getRaiz(), 4);
        rn.inserir(rn.getRaiz(), 3);
        rn.inserir(rn.getRaiz(), 2);
        rn.inserir(rn.getRaiz(), 1);

//        rn.inserir(rn.getRaiz(), 29);
//        rn.inserir(rn.getRaiz(), 12);
//        rn.inserir(rn.getRaiz(), 41);
//        rn.inserir(rn.getRaiz(), 5);
//        rn.inserir(rn.getRaiz(), 25);
//        rn.inserir(rn.getRaiz(), 3);
//        rn.inserir(rn.getRaiz(), 4);
//        rn.inserir(rn.getRaiz(), 2);
//
//        rn.remover(rn.getRaiz(), 25);
//        rn.remover(rn.getRaiz(), 29);
//        rn.remover(rn.getRaiz(), 41);
//        rn.remover(rn.getRaiz(), 12);
//        rn.remover(rn.getRaiz(), 5);
//        rn.remover(rn.getRaiz(), 2);

//        rn.inserir(rn.getRaiz(), 30);
//        rn.inserir(rn.getRaiz(), 10);
//        rn.inserir(rn.getRaiz(), 40);
//        rn.inserir(rn.getRaiz(), 5);
//        rn.inserir(rn.getRaiz(), 25);
//        rn.inserir(rn.getRaiz(), 3);
//        rn.inserir(rn.getRaiz(), 4);
//        rn.inserir(rn.getRaiz(), 1);
//
//        rn.remover(rn.getRaiz(), 25);
//        rn.remover(rn.getRaiz(), 30);
//        rn.remover(rn.getRaiz(), 40);
//        rn.remover(rn.getRaiz(), 10);
//        rn.remover(rn.getRaiz(), 5);
//        rn.remover(rn.getRaiz(), 1);

//        rn.inserir(rn.getRaiz(), 30);
//        rn.inserir(rn.getRaiz(), 20);
//        rn.inserir(rn.getRaiz(), 50);
//        rn.inserir(rn.getRaiz(), 70);
//        rn.inserir(rn.getRaiz(), 40);
//        rn.inserir(rn.getRaiz(), 80);

        rn.remover(rn.getRaiz(), 7);
        rn.remover(rn.getRaiz(), 8);
        rn.remover(rn.getRaiz(), 6);
        rn.remover(rn.getRaiz(), 2);
        rn.remover(rn.getRaiz(), 1);
        rn.remover(rn.getRaiz(), 3);
        System.out.println("Raiz " + rn.getRaiz());
        //emOrdem(rn.getRaiz());
        print(rn.getRaiz(), 4);

    }

}
