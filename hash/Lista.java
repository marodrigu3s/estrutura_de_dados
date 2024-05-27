public class Lista {
    private No primeiro;
    public boolean estaVazia() {
        return primeiro == null;
    }
    public void insere(Pessoa info) {
        No novo = new No(info);
        if (!estaVazia()) {
            novo.setProximo(primeiro);
        }
        primeiro = novo;
    }
    @Override
    public String toString() {
        String s = "lista: ";
        if (estaVazia()) {
            s += "vazia";
        } else {
            No aux = primeiro;
            while (aux != null) { //percorrer até o final
                s += aux;
                aux = aux.getProximo();
            }
            s += "//";
        }
        return s + "\n";
    }
    public Pessoa remove() {
        Pessoa temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        return temp;
    }
}
