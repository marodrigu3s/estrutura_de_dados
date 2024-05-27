public class NovoHash {
    private final String mapa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Lista[] tabela;
    public NovoHash (){
        tabela = new Lista[26];
        for (int i=0; i<26; i++) {
            tabela[i] = new Lista();
        }
    }
    public void insere (Pessoa pessoa) {
        char primeira = pessoa.getNome().charAt(0);
        int posicao = mapa.indexOf(primeira);
        tabela[posicao].insere(pessoa);
    }
    @Override 
    public String toString () {
        String s = "";
        for (int i=0; i<26; i++)
            s += tabela[i] + "\n";
        return s;
    }
}