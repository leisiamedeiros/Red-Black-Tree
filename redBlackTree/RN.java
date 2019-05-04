package redBlackTree;

import static java.lang.System.out;

/**
 *
 * @author Leisia
 */
public class RN {

    No raiz;

    //retorna o no raiz da arvore
    public No getRaiz() {
        return raiz;
    }

    //inserir no
    public No inserir(No no, int valor) {

        if (no == null) {
            No novoNo = new No();
            novoNo.setValor(valor);
            novoNo.setCor('R');

            if (raiz == null) {
                novoNo.setCor('N');
                raiz = novoNo;
            }
            return novoNo;
        } else {
            if (valor >= no.getValor()) {
                No filho = inserir(no.getFilhoDireito(), valor);
                if (filho != null) {
                    filho.setPai(no);
                    no.setFilhoDireito(filho);
                    corrigirCor(filho);
                }
            } else {
                No filho = inserir(no.getFilhoEsquerdo(), valor);
                if (filho != null) {
                    filho.setPai(no);
                    no.setFilhoEsquerdo(filho);
                    corrigirCor(filho);
                }
            }
        }
        return null;
    }

    //rotação simples esquerda em no
    public No rotacaoSimplesEsquerda(No no) {
        No novoNo = no.getFilhoDireito();
        no.setFilhoDireito(novoNo.getFilhoEsquerdo());
        if (novoNo.getFilhoEsquerdo() != null) {
            novoNo.getFilhoEsquerdo().setPai(no);
        }
        novoNo.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no == no.getPai().getFilhoEsquerdo()) {
                no.getPai().setFilhoEsquerdo(novoNo);
            } else {
                no.getPai().setFilhoDireito(novoNo);
            }
        } else {
            raiz = novoNo;
        }
        novoNo.setFilhoEsquerdo(no);
        no.setPai(novoNo);
        return novoNo;
    }

    //rotação simples direita em no
    public No rotacaoSimplesDireita(No no) {
        No novoNo = no.getFilhoEsquerdo();
        no.setFilhoEsquerdo(novoNo.getFilhoDireito());
        if (novoNo.getFilhoDireito() != null) {
            novoNo.getFilhoDireito().setPai(no);
        }
        novoNo.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no == no.getPai().getFilhoDireito()) {
                no.getPai().setFilhoDireito(novoNo);
            } else {
                no.getPai().setFilhoEsquerdo(novoNo);
            }
        } else {
            raiz = novoNo;
        }
        novoNo.setFilhoDireito(no);
        no.setPai(novoNo);
        return novoNo;
    }

    //corrigir cor caso inserção
    public void corrigirCor(No filho) {
        //cor do pai eh vermelha
        if (filho.getPai().getCor() == 'R') {
            //pai a esquerda
            if (filho.getPai() == filho.getPai().getPai().getFilhoEsquerdo()) {
                //se tio existe
                //if (filho.getPai().getPai().getFilhoDireito() != null) {
                //se tio a direita existe e se for vermelho CASO 2
                if (filho.getPai().getPai().getFilhoDireito() != null
                        && filho.getPai().getPai().getFilhoDireito().getCor() == 'R') {
                    //recolorir
                    filho.getPai().setCor('N');
                    filho.getPai().getPai().getFilhoDireito().setCor('N');
                    if (filho.getPai().getPai() != raiz) {
                        filho.getPai().getPai().setCor('R');
                        //caso 2 com repeticao de correcao de cor
                        corrigirCor(filho.getPai().getPai());
                    }
                } //} // caso 3 q lado filho esta
                else if (filho == filho.getPai().getFilhoEsquerdo()) {
                    //rotacao dupla esquerda 3c
                    if (filho.getPai() == filho.getPai().getPai().getFilhoDireito()) {
                        No novo = rotacaoSimplesDireita(filho.getPai());
                        No n = rotacaoSimplesEsquerda(novo.getPai());
                        n.getFilhoDireito().setCor('R');
                        n.getFilhoEsquerdo().setCor('R');
                        n.setCor('N');
                    }
                    //rotaca simples direita 3a
                    No novo = rotacaoSimplesDireita(filho.getPai().getPai());
                    novo.getFilhoDireito().setCor('R');
                    novo.getFilhoEsquerdo().setCor('R');
                    novo.setCor('N');
                } else {
                    //rotacao dupla direita 3d
                    if (filho.getPai() == filho.getPai().getPai().getFilhoEsquerdo()) {
                        No novo = rotacaoSimplesEsquerda(filho.getPai());
                        No n = rotacaoSimplesDireita(novo.getPai());
                        n.getFilhoDireito().setCor('R');
                        n.getFilhoEsquerdo().setCor('R');
                        n.setCor('N');
                    }
                }

            }//pai a direita
            else {
                //se tio existe
                //if (filho.getPai().getPai().getFilhoEsquerdo() != null) {
                //se tio a esquerda existe e for vermelho CASO 2
                if (filho.getPai().getPai().getFilhoEsquerdo() != null
                        && filho.getPai().getPai().getFilhoEsquerdo().getCor() == 'R') {
                    //recolorir
                    filho.getPai().setCor('N');
                    filho.getPai().getPai().getFilhoEsquerdo().setCor('N');
                    if (filho.getPai().getPai() != raiz) {
                        filho.getPai().getPai().setCor('R');
                        //caso 2 com repeticao de correcao de cor *****
                        corrigirCor(filho.getPai().getPai());
                    }
                } //se tio for preto                    
                //}
                //caso 3 
                else if (filho == filho.getPai().getFilhoDireito()) {
                    //rotacao dupla direita 3d
                    if (filho.getPai() == filho.getPai().getPai().getFilhoEsquerdo()) {
                        No novo = rotacaoSimplesEsquerda(filho.getPai());
                        No n = rotacaoSimplesDireita(novo.getPai());
                        n.getFilhoDireito().setCor('R');
                        n.getFilhoEsquerdo().setCor('R');
                        n.setCor('N');
                    }
                    //rotaca simples esquerda 3b
                    No novo = rotacaoSimplesEsquerda(filho.getPai().getPai());
                    novo.getFilhoDireito().setCor('R');
                    novo.getFilhoEsquerdo().setCor('R');
                    novo.setCor('N');
                } else {
                    //rotacao dupla esquerda 3c
                    if (filho.getPai() == filho.getPai().getPai().getFilhoDireito()) {
                        No novo = rotacaoSimplesDireita(filho.getPai());
                        No n = rotacaoSimplesEsquerda(novo.getPai());
                        n.getFilhoDireito().setCor('R');
                        n.getFilhoEsquerdo().setCor('R');
                        n.setCor('N');
                    }
                }
            }
        }
        //filho.getPai().getCor() == 'N' => nada fazer        
        //return filho;
    }

    //remoção do nó e verificação de casos
    public void remover(No no, int valor) {
        //vai pro lado direito
        if (valor > no.getValor()) {
            //chama recursivo
            remover(no.getFilhoDireito(), valor);
        } //vai pro lado esquerdo
        else if (valor < no.getValor()) {
            //chama recursivo
            remover(no.getFilhoEsquerdo(), valor);
        }//achou o no
        else {
            //busca sucessor lado direito
            if (no.getFilhoDireito() != null) {
                No sucessor = no.getFilhoDireito();
                while (sucessor.getFilhoEsquerdo() != null) {
                    sucessor = sucessor.getFilhoEsquerdo();
                }
                //se sucessor for filho do no
                if (sucessor == no.getFilhoDireito()) {
                    //no era raiz
                    if (no.getPai() == null) {
                        //se no tiver filho esquerdo
                        if (no.getFilhoEsquerdo() != null) {
                            no.getFilhoEsquerdo().setPai(sucessor);
                            sucessor.setFilhoEsquerdo(no.getFilhoEsquerdo());
                        }
                        sucessor.setPai(null);
                        raiz = sucessor;
                        if (sucessor.getCor() == 'N') {
                            if (sucessor.getFilhoDireito() != null) {
                                sucessor.getFilhoDireito().setCor('N');
                                verCasoEspelhado(sucessor);
                            } else {
                                verCasoEspelhado(sucessor);
                            }
                        }
                        if (sucessor.getFilhoDireito() != null) {
                            sucessor.getFilhoDireito().setCor('R');
                        }
                        sucessor.setCor('N');
                    } //tenho pai, de que lado estou
                    else {
                        //no V do lado esquerdo do pai
                        if (no == no.getPai().getFilhoEsquerdo()) {
                            no.getPai().setFilhoEsquerdo(sucessor);
                        } else {
                            //no V do lado direito
                            no.getPai().setFilhoDireito(sucessor);
                        }
                        //no V tinha filho esquerdo
                        if (no.getFilhoEsquerdo() != null) {
                            no.getFilhoEsquerdo().setPai(sucessor);
                            sucessor.setFilhoEsquerdo(no.getFilhoEsquerdo());
                        }
                        sucessor.setPai(no.getPai());
                        if (sucessor.getCor() == 'N') {
                            //situacao 4
                            if (no.getCor() == 'R') {
                                //pintando x de rubro
                                sucessor.setCor('R');
                                if (sucessor.getFilhoDireito() != null) {
                                    //filho de sucessor toma o seu lugar e cor
                                    sucessor.getFilhoDireito().setCor('N');
                                }
                                verCasoEspelhado(sucessor);
                            } else {
                                if (sucessor.getFilhoDireito() != null) {
                                    //filho de sucessor toma o seu lugar e cor
                                    sucessor.getFilhoDireito().setCor('N');
                                }
                                //situacao 3 ou 4
                                verCasoEspelhado(sucessor);
                            }
                        } else {//sucessor vermelho
                            if (no.getCor() == 'N') {
                                //situacao 2
                                sucessor.setCor('N');
                            }
                        }
                    }
                } else {
                    //sucessor Cordem
                    //sucessor tem filho direito ?                 
                    if (sucessor.getFilhoDireito() != null) {
                        sucessor.getPai().setFilhoEsquerdo(sucessor.getFilhoDireito());
                        sucessor.getFilhoDireito().setPai(sucessor.getPai());
                    } else {
                        //desligar pai do sucessor a ele;
                        sucessor.getPai().setFilhoEsquerdo(null);
                    }
                    //ligar filho Esq d no a sucessor
                    if (no.getFilhoEsquerdo() != null) {
                        no.getFilhoEsquerdo().setPai(sucessor);
                        sucessor.setFilhoEsquerdo(no.getFilhoEsquerdo());
                    }
                    //ligar pai e filho Dir do NO a sucessor
                    sucessor.setFilhoDireito(no.getFilhoDireito());
                    no.getFilhoDireito().setPai(sucessor);
                    
                    //corrigir cor
                    if (sucessor.getCor() == 'N') {
                        verCaso(sucessor.getPai());
                    } else {
                        sucessor.setCor(no.getCor());
                    }
    
                    //setar no pai sucessor
                    if (no.getPai() != null) {
                        if (no == no.getPai().getFilhoEsquerdo()) {
                            no.getPai().setFilhoEsquerdo(sucessor);
                        } else {
                            no.getPai().setFilhoDireito(sucessor);
                        }
                    } //o no era raiz 
                    else {
                        raiz = sucessor;
                    }
                    sucessor.setPai(no.getPai());
                }
            }//sucessor lado esquerdo
            else if (no.getFilhoEsquerdo() != null) {
                //no V raiz com filho esquerdo apenas
                if (no.getPai() == null) {
                    raiz = no.getFilhoEsquerdo();
                    no.getFilhoEsquerdo().setCor('N');
                }//no V nao eh raiz do lado esquerdo  
                else if (no == no.getPai().getFilhoEsquerdo()) {
                    no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
                } else {//lado dir
                    no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
                }
                no.getFilhoEsquerdo().setPai(no.getPai());
                //cores para situações
                if (no.getFilhoEsquerdo().getCor() == 'N') {
                    out.println("Eu sou sucessor negro :O");
                } else {
                    //sucessor rubro
                    //situacao 2
                    no.getFilhoEsquerdo().setCor('N');
                }
            }//sem sucessor
            else if (no.getPai() != null) {
                //sou vermelho e folha
                if (no.getCor() == 'R') {
                    //de que lado estou no V folha
                    if (no == no.getPai().getFilhoEsquerdo()) {
                        no.getPai().setFilhoEsquerdo(null);
                    } else {
                        no.getPai().setFilhoDireito(null);
                    }
                }//no preto folha
                else {
                    //sou preto folha
                    //de que lado estou no V esquerdo folha
                    if (no == no.getPai().getFilhoEsquerdo()) {
                        //tenho irmão
                        if (no.getPai().getFilhoDireito() != null) {
                            //caso 1 irmao direito Rubro
                            if (no.getPai().getFilhoDireito().getCor() == 'R') {
                                no.getPai().setCor('R');
                                no.getPai().getFilhoDireito().setCor('N');
                                //me apaga
                                no.getPai().setFilhoEsquerdo(null);
                                //rotacao retorna novo raiz
                                No novo = rotacaoSimplesEsquerda(no.getPai());
                                //passando o novo x
                                verCaso(novo.getFilhoEsquerdo());
                            } // caso 2, 3 ou 4 irmão preto
                            else {
                                //se meu irmao nao tem filhos
                                if (no.getPai().getFilhoDireito().getFilhoEsquerdo() == null
                                        && no.getPai().getFilhoDireito().getFilhoDireito() == null) {
                                    //caso 2
                                    no.getPai().getFilhoDireito().setCor('R');
                                    //caso 2b
                                    if (no.getPai().getCor() == 'R') {
                                        no.getPai().setCor('N');
                                    }
                                    //me apaga
                                    no.getPai().setFilhoEsquerdo(null);
                                }//meu irmao tem filhos
                                else {
                                    no.getPai().setFilhoEsquerdo(null);
                                    verCaso(no.getPai());                                    
                                }
                            }
                        } else {
                            no.getPai().setFilhoEsquerdo(null);
                        }
                    }//estou lado espelhado direito V
                    else {
                        //tenho irmão
                        if (no.getPai().getFilhoEsquerdo() != null) {
                            //caso 1 irmao esquerdo Rubro
                            if (no.getPai().getFilhoEsquerdo().getCor() == 'R') {
                                no.getPai().setCor('R');
                                no.getPai().getFilhoEsquerdo().setCor('N');
                                //me apaga
                                no.getPai().setFilhoDireito(null);
                                //rotacao retorna novo raiz
                                No novo = rotacaoSimplesDireita(no.getPai());
                                //passando o novo x
                                verCasoEspelhado(novo.getFilhoDireito());
                            } // caso 2, 3 ou 4 irmão preto
                            else {
                                //se meu irmao nao tem filhos
                                if (no.getPai().getFilhoEsquerdo().getFilhoEsquerdo() == null
                                        && no.getPai().getFilhoEsquerdo().getFilhoDireito() == null) {
                                    //caso 2
                                    no.getPai().getFilhoEsquerdo().setCor('R');
                                    //caso 2b
                                    if (no.getPai().getCor() == 'R') {
                                        no.getPai().setCor('N');
                                    }
                                    //me apaga
                                    no.getPai().setFilhoDireito(null);
                                }//meu irmao tem filhos
                                else {
                                    no.getPai().setFilhoDireito(null);
                                    verCasoEspelhado(no.getPai());                                    
                                }
                            }
                        } else {
                            no.getPai().setFilhoDireito(null);
                        }
                    }
                }
            } //no raiz sem filhos 
            else {
                raiz = null;
            }
        }
    }

    //corrigir caso Remoção
    public void verCaso(No novo) {
        //se tenho filho direito
        if (novo.getFilhoDireito() != null) {
            //se filho direito eh preto
            if (novo.getFilhoDireito().getCor() == 'N') {
                //caso 2
                if (novo.getFilhoDireito().getFilhoDireito() == null
                        && novo.getFilhoDireito().getFilhoEsquerdo() == null) {
                    novo.getFilhoDireito().setCor('R');
                    //caso 2b
                    if (novo.getCor() == 'R') {
                        novo.setCor('N');
                    }
                } //filhos de W diferentes de null w preto
                else {
                    //filho direito null 
                    if (novo.getFilhoDireito().getFilhoDireito() == null) {
                        //caso 3 filhoEsq R
                        if (novo.getFilhoDireito().getFilhoEsquerdo().getCor() == 'R') {
                            novo.getFilhoDireito().setCor(novo.getFilhoDireito().getFilhoEsquerdo().getCor());
                            novo.getFilhoDireito().getFilhoEsquerdo().setCor(novo.getFilhoDireito().getCor());
                            rotacaoSimplesDireita(novo.getFilhoDireito());

                            //3 vai para caso 4
                            novo.getFilhoDireito().setCor(novo.getCor());
                            novo.setCor('N');
                            novo.getFilhoDireito().getFilhoDireito().setCor('N');
                            rotacaoSimplesEsquerda(novo);
                        }//filho direito null e filho esquerdo preto 
                        else {
                            novo.getFilhoDireito().setCor('R');
                            //caso 2b
                            if (novo.getCor() == 'R') {
                                novo.setCor('N');
                            }
                        }
                    }//filho direito vermelho ou preto 
                    else {
                        //ja veio caso 4 filho dir verm
                        if (novo.getFilhoDireito().getFilhoDireito().getCor() == 'R') {
                            novo.getFilhoDireito().setCor(novo.getCor());
                            novo.setCor('N');
                            novo.getFilhoDireito().getFilhoDireito().setCor('N');
                            rotacaoSimplesEsquerda(novo);
                        } else {
                            novo.getFilhoDireito().setCor('R');
                            //caso 2b
                            if (novo.getCor() == 'R') {
                                novo.setCor('N');
                            }
                        }
                    }
                }
            }//irmão é rubro            
        }//nao tenho filho direito
    }

    //corrigir caso RemoçãoEspelhado
    public void verCasoEspelhado(No novo) {
        //se tenho filho esquerdo
        if (novo.getFilhoEsquerdo() != null) {
            //se filho esquerdo eh preto caso 2, 3 ou 4
            if (novo.getFilhoEsquerdo().getCor() == 'N') {
                //caso 2
                if (novo.getFilhoEsquerdo().getFilhoDireito() == null
                        && novo.getFilhoEsquerdo().getFilhoEsquerdo() == null) {
                    novo.getFilhoEsquerdo().setCor('R');
                    //caso 2b
                    if (novo.getCor() == 'R') {
                        novo.setCor('N');
                    }
                } //filhos de W diferentes de null w preto
                else {
                    //filho esquerdo null existe filho dir 
                    if (novo.getFilhoEsquerdo().getFilhoEsquerdo() == null) {
                        //caso 3 filhoDir R
                        if (novo.getFilhoEsquerdo().getFilhoDireito().getCor() == 'R') {
                            novo.getFilhoEsquerdo().setCor(novo.getFilhoEsquerdo().getFilhoDireito().getCor());
                            novo.getFilhoEsquerdo().getFilhoDireito().setCor(novo.getFilhoEsquerdo().getCor());
                            rotacaoSimplesEsquerda(novo.getFilhoEsquerdo());

                            //3 vai para caso 4
                            novo.getFilhoEsquerdo().setCor(novo.getCor());
                            novo.setCor('N');
                            novo.getFilhoEsquerdo().getFilhoEsquerdo().setCor('N');
                            rotacaoSimplesDireita(novo);
                        }//filho esquerdo null e filho direito preto 
                        else {
                            novo.getFilhoEsquerdo().setCor('R');
                            //caso 2b
                            if (novo.getCor() == 'R') {
                                novo.setCor('N');
                            }
                        }
                    }//filho esquerdo vermelho ou preto 
                    else {
                        //ja veio caso 4 filho esq verm
                        if (novo.getFilhoEsquerdo().getFilhoEsquerdo().getCor() == 'R') {
                            novo.getFilhoEsquerdo().setCor(novo.getCor());
                            novo.setCor('N');
                            novo.getFilhoEsquerdo().getFilhoEsquerdo().setCor('N');
                            rotacaoSimplesDireita(novo);
                        } else {
                            novo.getFilhoEsquerdo().setCor('R');
                            //caso 2b
                            if (novo.getCor() == 'R') {
                                novo.setCor('N');
                            }
                        }
                    }
                }
            }//irmão é rubro
            else {
                //caso 1
                novo.getFilhoEsquerdo().setCor('N');
                novo.setCor('R');
                No casoUm = rotacaoSimplesDireita(novo);
                verCasoEspelhado(casoUm);
            }
        }//nao tenho filho esquerdo
    }

}
