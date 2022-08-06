package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

public interface ISetorLoja {

    public void iniciarCadastro(Runnable callback);

    public void editarCadastro(Runnable callback);

    public void mostrarCadastro(Runnable callback);

    public String gerarStringRelatorio();

}
