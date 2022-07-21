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

}
