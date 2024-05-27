public class Hash {
    private final String mapa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //final - valor que não pode ser alterado
    private Pessoa[] tabela;
    public Hash (){
        tabela = new Pessoa[26];
    }
    public void insere (Pessoa pessoa) {
        char primeira = pessoa.getNome().charAt(0);
        int posicao = mapa.indexOf(primeira);
        tabela[posicao] = pessoa;
    }
    public boolean busca (Pessoa pessoa) {
        char primeira = pessoa.getNome().charAt(0);
        int posicao = mapa.indexOf(primeira);
        if (pessoa.equals(tabela[posicao])) 
            return true;
        return false;
    }
    @Override
    public String toString () {
        String s = "";
        for (int i = 0; i < 26; i++) 
            s += tabela[i] + "\n";
        return s;
    }
}