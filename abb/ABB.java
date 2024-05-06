//arvore binaria de busca - abb
// esq-raiz-dir (in)
//esq-dir-raiz (pos)
//raiz-esq-sir (pre)
public class ABB {
    private No raiz;
    // raiz nasce nula
    // para saber se uma arvore esta vazia:
    public boolean estaVazia () {
        return raiz == null;
    }
    // como colocar elementos na árvore
    public void insere (int info) {
        No novo = new No(info);
        if (estaVazia()) {
            raiz = novo;
        }
        else {
            insereRec (novo, raiz);

        }
    }
    void insereRec (No novo, No atual) {
        if (novo.getInfo() <= atual.getInfo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novo);
            }
            else {
                insereRec(novo, atual);
            }
        }
        else{
            if (atual.getDireita() == null) {
                atual.setDireita(novo);
            }
            else{
                insereRec(novo, atual);
            }
        }
    }
    public String stringInOrder() {
        if (estaVazia())return "arvore vazia";
        return
            stringRecInOrder (raiz);
    }
    String stringRecInOrder(No atual) {
        if (atual != null)
            return stringRecInOrder (atual.getEsquerda()) +
            " " + atual.getInfo() + " " +
            stringRecInOrder (atual.getDireita());
        return ""; 

    }
}
