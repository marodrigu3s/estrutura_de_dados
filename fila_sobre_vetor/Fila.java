public class Fila {
    private int[] dados;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public static final int CAPACIDADE_MIN = 10; // Varável "final" é sempre constante, método "final" não pode ser sobrescrito, classe "final" nao pode ser herdada

    public Fila () { 
        dados = new int[CAPACIDADE_MIN];
        ultimo = dados.length-1;
        primeiro = 0;
        tamanho = 0;
    }

    public Fila (int capacidade) {
        if (capacidade > 10)
           dados = new int[capacidade];
        else
            dados = new int[CAPACIDADE_MIN];
        ultimo = dados.length - 1;
        primeiro = 0;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }

    //Criar método de controle 
    int proxima (int pos) {
        return (pos + 1) % dados.length;
    }

    public void enfileira(int i) {
        if (!estaCheia()) {
            ultimo = proxima(ultimo);
            dados[ultimo] = i;
            tamanho++;
        }
    }

    public int desenfileira() {
        if (estaVazia()) return - 1;
        int temp = dados[primeiro];
        primeiro = proxima(primeiro);
        tamanho--;
        return temp;
    }
    @Override
    public String toString(){
        if(v.estavazia()){
            return "Fila Vazia";
        }
        String s = "";
        int i = primeiro;
        do{
            s = s + dados[i] + "";
            i = proxima(i);
        }
        while(i != proxima(i));
        return s;
    }
}
