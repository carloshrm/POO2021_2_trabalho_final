package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JPanel implements Serializable {

    private String nome;
    private String cpf;
    private String endereco;
    private String celular;
    private ArrayList<Pedido> pedidosFeitos;

    Cliente() {
        initComponents();
        pedidosFeitos = new ArrayList<>();
        buttonClienteCancelar.setVisible(false);
    }

    public Cliente(String nome, String cpf, String endereco, String celular){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.celular = celular;        
        initComponents();
        setVisible(false);
    }
    
    public String getCpf() {
        return cpf;
    }

    public void iniciarCadastro(Runnable callback) {
        setVisible(true);
        clienteTitulo.setText("Novo cliente: ");
        buttonClienteCancelar.setVisible(true);
        buttonClienteCadastrar.setAction(new AbstractAction("Cadastrar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarCadastro()) {
                        callback.run();
                        setVisible(false);
                    }
                } catch (CpfInvalidoException er) {
                    JOptionPane.showMessageDialog(null, er.getMessage());
                }
            }
        });
    }

    private boolean validarCadastro() {
        String cpfDigitado = fieldCpf.getText();
        if (cpfDigitado.length() != 11) {
            throw new CpfInvalidoException("Cpf com numero de caracteres invalido");
        }
        if (Loja.buscaCliente(cpfDigitado) == null) {
            this.cpf = cpfDigitado;
            this.nome = fieldNome.getText();
            this.endereco = fieldEndereco.getText();
            this.celular = fieldCelular.getText();
            JOptionPane.showMessageDialog(null, "cadastro realizado");
            return true;
        } else {
            throw new CpfInvalidoException("Já existe um cliente com esse CPF.");
        }
    }

    public boolean validarEdicao() {
        if (fieldCpf.getText().length() != 11) {
            throw new CpfInvalidoException("Cpf com numero de carcteres invalido");
        }
        if (!cpf.equals(fieldCpf.getText())) {
            if (Loja.buscaCpf(fieldCpf.getText())) {
                throw new CpfInvalidoException("Cpf ja cadastrado");
            }
        }
        this.nome = fieldNome.getText();
        this.cpf = fieldCpf.getText();
        this.endereco = fieldEndereco.getText();
        this.celular = fieldCelular.getText();
        return true;
    }

    public void editarInfo(Runnable callback) {
        setVisible(true);
        for (var pe : pedidosFeitos) {
            System.out.println(pe.toString());
        }
        clienteTitulo.setText("Editar cliente: ");
        fieldNome.setText(nome);
        fieldCpf.setText(cpf);
        fieldEndereco.setText(endereco);
        fieldCelular.setText(celular);
        buttonClienteCancelar.setVisible(false);
        buttonClienteCadastrar.setAction(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarEdicao()) {
                        callback.run();
                    }
                } catch (CpfInvalidoException er) {
                    JOptionPane.showMessageDialog(null, er.getMessage());
                }
            }
        });
    }

    public void mostrarInfo(Runnable callback) {
        setVisible(true);
        clienteTitulo.setText("Informações do cliente: ");
        //fieldNome.setText(nome);
        //fieldCpf.setText(cpf);
        //fieldEndereco.setText(endereco);
        //fieldCelular.setText(celular);
        buttonClienteCancelar.setAction(new AbstractAction("Cancela") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }
        });
        buttonClienteCadastrar.setAction(new AbstractAction("Ok") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }

        });
    }

    public static boolean validarCPF(String cpf) {
        final String formato = "^(\\d{3}[[.][-]]){3}\\d{2}$";
        return cpf.matches(formato);
    }

    public void cadastrarPedido(Pedido p) {
        pedidosFeitos.add(p);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Celular: %s Cpf: %s %s", nome, celular, cpf, mostrarPedidos());
    }

    public StringBuilder mostrarPedidos() {
        StringBuilder pedidos = new StringBuilder();
        for (var pd : pedidosFeitos) {
            pedidos.append(pd.mostrarDados());
            pedidos.append("\t");
        }
        if(pedidosFeitos.isEmpty()){
            pedidos.append("Não possui pedidos");
        }
        return pedidos;
    }

    public String mostrarDados() {
        return String.format("%s\\%s\\%s\\%s\\%s", nome, cpf, endereco, celular, mostrarPedidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        clienteTitulo = new javax.swing.JLabel();
        panelEntradas = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        fieldCpf = new javax.swing.JTextField();
        labelEndereco = new javax.swing.JLabel();
        fieldEndereco = new javax.swing.JTextField();
        labelCelular = new javax.swing.JLabel();
        fieldCelular = new javax.swing.JTextField();
        panelMenuCliente = new javax.swing.JPanel();
        buttonClienteCadastrar = new javax.swing.JButton();
        buttonClienteCancelar = new javax.swing.JButton();

        setBackground(Loja.corFundoEscura);
        setPreferredSize(new java.awt.Dimension(600, 500));

        panelTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        clienteTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(clienteTitulo);

        add(panelTitulo);

        panelEntradas.setForeground(Loja.corFonteClara);
        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 200));
        panelEntradas.setLayout(new java.awt.GridLayout(5, 0, 0, 10));

        labelNome.setForeground(Loja.corFonteClara);
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Nome: ");
        labelNome.setAlignmentY(0.2F);
        labelNome.setMaximumSize(new java.awt.Dimension(300, 30));
        labelNome.setMinimumSize(new java.awt.Dimension(200, 30));
        labelNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelNome);

        fieldNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldNome.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldNome.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldNome);

        labelCpf.setForeground(Loja.corFonteClara);
        labelCpf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCpf.setText("CPF do Cliente:");
        labelCpf.setAlignmentY(0.2F);
        labelCpf.setMaximumSize(new java.awt.Dimension(300, 30));
        labelCpf.setMinimumSize(new java.awt.Dimension(200, 30));
        labelCpf.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelCpf);

        fieldCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldCpf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldCpf.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldCpf.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldCpf.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldCpf);

        labelEndereco.setForeground(Loja.corFonteClara);
        labelEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEndereco.setText("Endereco: ");
        labelEndereco.setAlignmentY(0.2F);
        labelEndereco.setMaximumSize(new java.awt.Dimension(300, 30));
        labelEndereco.setMinimumSize(new java.awt.Dimension(200, 30));
        labelEndereco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelEndereco);

        fieldEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldEndereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldEndereco.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldEndereco.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldEndereco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldEndereco);

        labelCelular.setForeground(Loja.corFonteClara);
        labelCelular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCelular.setText("Celular: ");
        labelCelular.setAlignmentY(0.2F);
        labelCelular.setMaximumSize(new java.awt.Dimension(300, 30));
        labelCelular.setMinimumSize(new java.awt.Dimension(200, 30));
        labelCelular.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelCelular);

        fieldCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldCelular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldCelular.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldCelular.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldCelular.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldCelular);

        add(panelEntradas);

        panelMenuCliente.setForeground(Loja.corFonteClara);
        panelMenuCliente.setOpaque(false);
        panelMenuCliente.setPreferredSize(new java.awt.Dimension(400, 30));
        panelMenuCliente.setRequestFocusEnabled(false);
        panelMenuCliente.setLayout(new java.awt.GridLayout(0, 2, 50, 0));

        buttonClienteCadastrar.setBackground(Loja.corFundoEscura);
        buttonClienteCadastrar.setForeground(Loja.corFonteClara);
        buttonClienteCadastrar.setText("OK");
        panelMenuCliente.add(buttonClienteCadastrar);

        buttonClienteCancelar.setBackground(Loja.corFundoEscura);
        buttonClienteCancelar.setForeground(Loja.corFonteClara);
        buttonClienteCancelar.setText("Cancela");
        buttonClienteCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClienteCancelarActionPerformed(evt);
            }
        });
        panelMenuCliente.add(buttonClienteCancelar);

        add(panelMenuCliente);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClienteCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClienteCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonClienteCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClienteCadastrar;
    private javax.swing.JButton buttonClienteCancelar;
    private javax.swing.JLabel clienteTitulo;
    private javax.swing.JTextField fieldCelular;
    private javax.swing.JTextField fieldCpf;
    private javax.swing.JTextField fieldEndereco;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JPanel panelMenuCliente;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables

}
