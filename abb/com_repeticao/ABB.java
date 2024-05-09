public class ABB {
    private No raiz;
    boolean estaVazia() {
        return raiz == null;
    }
    public void insere(int i) {
        if (estaVazia())
            raiz = new No(i);
        else
            insereRec(i, raiz);
    }
    public void insereRec(int i, No atual) {
        if (i == atual.getInfo()) {
            atual.somaQuantidade();
        } 
        else if (i < atual.getInfo()) {
            if (atual.getEsquerda() == null)
                atual.setEsquerda(new No(i));
            else
                insereRec(i, atual.getEsquerda());
        } 
        else {
            if (atual.getDireita() == null)
                atual.setDireita(new No(i));
            else    
                insereRec(i, atual.getDireita());
        }
    }
    public String stringInOrder() {
        if (estaVazia()) return "arvore vazia";
        return stringInOrderRec(raiz);
    }
    public String stringInOrderRec(No atual) {
        if (atual == null) return "";
        
        String s = "";

        s += stringInOrderRec(atual.getEsquerda());

        for (int i = 1; i <= atual.getQuantidade(); i++)
            s += atual.getInfo() + " ";

        s += stringInOrderRec(atual.getDireita());

        return s;
    }
}