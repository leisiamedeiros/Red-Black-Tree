package newpackage;

/**
 *
 * @author Leisia
 */
public class No {
    
    private int valor;
    private No pai;
    private No filhoDireito;
    private No filhoEsquerdo;
    private char cor;
    private char duploN;

    @Override
    public String toString() {
       return getValor() + " (" + getCor() + ")"; 
    }

    public No getPai() {
        return pai;
    }
    
    public void setPai(No pai) {
        this.pai = pai;
    }
    
    public char getCor() {
        return cor;
    }
    
    public void setCor(char cor) {
        this.cor = cor;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }
    
    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }
    
    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getDuploN() {
        return duploN;
    }

    public void setDuploN(char duploN) {
        this.duploN = duploN;
    }
    
}
