package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

/**
 *
 * @author Carlos
 */
public class Produto {

    private static int controleCodigo = 0;

    private int codigo;
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.codigo = controleCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }  

    @Override
    public String toString() {
        return String.format("\n Produto Cod %d - Nome: %s Preço: %.2f \nDescrição: %s", codigo, nome, preco, descricao);
    }

}
