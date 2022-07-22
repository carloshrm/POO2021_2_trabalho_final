package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JPanel { 
    
    private String nome;
    private String cpf;
    private String endereco;
    private String celular;
    private ArrayList<Pedido> pedidosFeitos;

    Cliente() {
        initComponents();
        setVisible(false);
    }

    public String getCpf() {
        return cpf;
    }     
    
    public void iniciarCadastro(Runnable callback) {
        setVisible(true);
        clienteTitulo.setText("Novo cliente: ");
        buttonClienteCadastrar.setAction(new AbstractAction("Cadastrar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarCadastro()) {
                        callback.run();
                    }
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
    }    
    
    public void altera(String nome, String cpf, String endereco, String celular){
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.celular = celular;
    }

    private boolean validarCadastro() {
        String cpfDigitado = fieldCpf.getText();
        if (Loja.buscaCliente(cpfDigitado) == null) {
            this.cpf = cpfDigitado;
            this.nome = fieldNome.getText();
            this.endereco = fieldEndereco.getText();
            this.celular = fieldCelular.getText();
            JOptionPane.showMessageDialog(null, "cadastro realizado");
            setVisible(false);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "cadastro inválido", "alerta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean validarEdicao() {
        this.nome = fieldNome.getText();
        this.cpf = fieldCpf.getText();
        this.endereco = fieldEndereco.getText();
        this.celular = fieldCelular.getText();
        return true;
    }

    public void mostrarInfo(Runnable callback, String msgLabel) {
        setVisible(true);
        clienteTitulo.setText(msgLabel);
        fieldNome.setText(String.format("%d", nome));
        fieldCpf.setText(cpf);
        fieldEndereco.setText(String.format("%s", endereco));
        fieldCelular.setText(String.format("%d", celular));
        buttonClienteCancelar.setVisible(false);
        buttonClienteCadastrar.setAction(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarEdicao()) {
                    callback.run();
                } else {
                    JOptionPane.showMessageDialog(null, "Valores invalidos");
                }
            }
        });
    }
    
    public void cadastrarPedido(Pedido p) {
        pedidosFeitos.add(p);
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

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        clienteTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(clienteTitulo);

        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 250));
        panelEntradas.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        labelNome.setForeground(Loja.corFonteClara);
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Nome:");
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
        labelCpf.setText("CPF:");
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
        labelCelular.setText("Celular:");
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

        panelMenuCliente.setOpaque(false);
        panelMenuCliente.setPreferredSize(new java.awt.Dimension(400, 30));
        panelMenuCliente.setRequestFocusEnabled(false);
        panelMenuCliente.setLayout(new java.awt.GridLayout(0, 2, 50, 0));

        buttonClienteCadastrar.setBackground(Loja.corFundoEscura);
        buttonClienteCadastrar.setForeground(Loja.corFonteClara);
        buttonClienteCadastrar.setText("Cadastrar");
        panelMenuCliente.add(buttonClienteCadastrar);

        buttonClienteCancelar.setBackground(Loja.corFundoEscura);
        buttonClienteCancelar.setForeground(Loja.corFonteClara);
        buttonClienteCancelar.setText("Cancelar");
        buttonClienteCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClienteCancelarActionPerformed(evt);
            }
        });
        panelMenuCliente.add(buttonClienteCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMenuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMenuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClienteCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClienteCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonClienteCancelarActionPerformed

    // Variables declaration - do not modify                     
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
    // End of variables declaration         
    
}
