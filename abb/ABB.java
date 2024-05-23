//arvore binaria de busca - abb
// esq-raiz-dir (in)
//esq-dir-raiz (pos)
//raiz-esq-sir (pre)

import java.util.ArrayList;

public class ABB {
    private No raiz;

    // raiz nasce nula
    // para saber se uma arvore esta vazia:
    public boolean estaVazia() {
        return raiz == null;
    }

    public void insere(int info) {
        No novo = new No(info);
        if (estaVazia())
            raiz = novo;
        else
            insereRec(novo, raiz);
    }

    void insereRec(No novo, No atual) {
        if (novo.getInfo() <= atual.getInfo()) {
            if (atual.getEsquerda() == null)
                atual.setEsquerda(novo);
            else
                insereRec(novo, atual.getEsquerda());
        } else {
            if (atual.getDireita() == null)
                atual.setDireita(novo);
            else
                insereRec(novo, atual.getDireita());
        }
    }

    public String stringInOrder() {
        if (estaVazia())
            return "arvore vazia";
        return stringRecInOrder(raiz);
    }

    String stringRecInOrder(No atual) {
        if (atual != null)
            return stringRecInOrder(atual.getEsquerda()) +
                    " " + atual.getInfo() + " " +
                    stringRecInOrder(atual.getDireita());
        return "";
    }

    public int nivel() {
        if (estaVazia())
            return 0;
        return nivelRec(raiz);
    }

    int nivelRec(No atual) {
        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        int nivelEsq = 0, nivelDir = 0;
        if (atual.getEsquerda() != null)
            nivelEsq = nivelRec(atual.getEsquerda());
        if (atual.getDireita() != null)
            nivelDir = nivelRec(atual.getDireita());
        return nivelEsq > nivelDir ? nivelEsq + 1 : nivelDir + 1;
    }

    public int numeroNos() {
        if (estaVazia())
            return 0;
        return numeroNosRec(raiz);
    }

    int numeroNosRec(No atual) {
        if (atual == null)
            return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
    }

    public int maior() {
        if (estaVazia())
            return -1;
        No aux = raiz;
        while (aux.getDireita() != null) {
            aux = aux.getDireita();
        }
        return aux.getInfo();
    }

    public int chamaMaiorRec() {
        if (estaVazia())
            return -1;
        return maiorRec(raiz);
    }

    int maiorRec(No atual) {
        if (atual.getDireita() == null)
            return atual.getInfo();
        return maiorRec(atual.getDireita());
    }

    public int folhas() {
        if (estaVazia())
            return 0;
        return folhasRec(raiz);
    }

    int folhasRec(No atual) {
        if (atual == null)
            return 0;
        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 1;
        return folhasRec(atual.getEsquerda()) + folhasRec(atual.getDireita());
    }

    // a busca pelo próximo elemento pode ser muito complicada, pois aas
    // ramificações podem acontecer de
    // várias maneiras; uma possibilidade é percorrer a árvore "emOrdem" e buscar o
    // elemento na lista
    // o curso é O(n)
    // public int proximo (int i) {
    // if (estaVazia()) return -1;

    // if (referencia(i) == null) return -1;
    // }
    // public No referencia (int i) {
    // if (raiz.getInfo() == i) return raiz;
    // if (i > raiz.getInfo()) return referenciaRec(i, raiz.getDireita());
    // return refereciaRec(i, raiz.getEsquerda());
    // }

    public int proximo(int x) {
        if (estaVazia())
            return -1; // decisão de projeto
        // int n = numeroNos(); //custo, pois já percorreu a árvore completa uma vez
        // int[] lista = new int[n]; cortei essas duas linhas de codigos depois de
        // implementar o arraylist
        ArrayList<Integer> lista = new ArrayList<>();
        constroiLista(lista, raiz);
        System.out.println(lista);
        if (!lista.contains(x))
            return -1; // decisão de projeto
        int posicao = lista.indexOf(x);
        // if (posicao == lista.size() -1) return -1;
        return posicao == lista.size() - 1 ? -1 : lista.get(posicao + 1);
    }

    void constroiLista(ArrayList lista, No atual) {
        if (atual != null) {
            constroiLista(lista, atual.getEsquerda());
            lista.add(atual.getInfo()); // add adiciona sempre no final
            constroiLista(lista, atual.getDireita());
        }
    }

    public boolean buscaBinaria(int x) {
        if (estaVazia())
            return false;
        return buscaBinariaRec(x, raiz);

    }

    boolean buscaBinariaRec(int x, No atual) {
        if (atual == null)
            return false;
        if (atual.getInfo() == x)
            return true;
        if (x < atual.getInfo())
            return buscaBinariaRec(x, atual.getEsquerda());
        return buscaBinariaRec(x, atual.getDireita());
    }

    public boolean remove(int x) {
        if (estaVazia())
            return false;
        return removeRec(x, raiz, null, false);
    }

    boolean removeRec(int x, No atual, No pai, boolean eFilhoEsquerdo) {
        if (atual != null) {
            if (x == atual.getInfo()) {
                if (atual.getDireita() == null && atual.getEsquerda() == null) { // atual não tem filhos
                if (pai == null) {
                    raiz = null;
                }
                else if (eFilhoEsquerdo) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                } else if (atual.getDireita() == null) {// tem só o filho da esquerda
                if (pai == null) {
                    raiz = atual.getEsquerda();
                }
                 else if (eFilhoEsquerdo) {
                        pai.setEsquerda(atual.getEsquerda());
                    } else {
                        pai.setDireita(atual.getEsquerda());
                    }
                } else if (atual.getEsquerda() == null) {// tem só o filho da direita
                if (pai == null) {
                    raiz = atual.getDireita();
                }
                else if (eFilhoEsquerdo) {
                        pai.setEsquerda(atual.getDireita());
                    } else {
                        pai.setDireita(atual.getDireita());
                    }
                } else { // tem os 2 filhos
                    if (pai == null) { //se for a raiz
                        raiz = atual.getDireita();
                    } 
                    else {
                        // o pai sempre adota a sub arvore da direita
                        if (eFilhoEsquerdo) {
                            pai.setEsquerda(atual.getDireita());
                        } else {
                            pai.setDireita(atual.getDireita());
                        }
                    }

                    // encontrar o sucessor para adotar a sub arvore da esquerda
                    No sucessor = atual.getDireita();
                    while (sucessor.getEsquerda() != null) {
                        sucessor = sucessor.getEsquerda();
                    }
                    sucessor.setEsquerda(atual.getEsquerda());
                }
                return true;
            } else if (x < atual.getInfo()) {
                eFilhoEsquerdo = true;
                pai = atual;
                removeRec(x, atual.getEsquerda(), pai, eFilhoEsquerdo);
            } else {
                eFilhoEsquerdo = false;
                pai = atual;
                removeRec(x, atual.getDireita(), pai, eFilhoEsquerdo);
            }
        }
        return false;
    }
}