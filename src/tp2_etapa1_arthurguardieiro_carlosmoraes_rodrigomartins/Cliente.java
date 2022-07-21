/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
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
        pedidoTitulo.setText("Novo pedido: ");
        buttonPedidoOK.setAction(new AbstractAction("Cadastrar") {
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
    
    public void alterarCadastro(){
        frameAlterar.setVisible(true);
        frameAlterar.setSize(500, 370);
        frameAlterar.setTitle("Alterar cadastro");
        bCadastrar.addActionListener((e) -> {
            String cpfDigitado = fieldCpfAlterar.getText();
            if(Loja.confirmaCadastro(cpfDigitado)){
                this.altera(fieldNomeAlterar.getText(), cpfDigitado, fieldEnderecoAlterar.getText(), fieldCelularAlterar.getText());
                JOptionPane.showMessageDialog(null, "Alteração feita");
            }
            JOptionPane.showMessageDialog(null, "CPF já cadastrado");
        });
    }
    
    private void altera(String nome, String cpf, String endereco, String celular){
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.celular = celular;
    }

    private boolean validarCadastro() {
        String cpfDigitado = JTCpf.getText();
        if (Loja.confirmaCadastro(cpfDigitado)) {
            this.cpf = cpfDigitado;
            this.nome = JTNome.getText();
            this.endereco = JTEndereco.getText();
            this.celular = JTCelular.getText();
            confirmaCadastro.setText("cadastro realizado");
            JOptionPane.showMessageDialog(null, "cadastro realizado");
            setVisible(false);
            return true;
        } else {
            confirmaCadastro.setText("cpf já utilizado");
            JOptionPane.showMessageDialog(null, "cadastro inválido", "alerta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void mostrarInfo() {
        setVisible(true);
        JTCelular.setText(celular);
        JTCpf.setText(cpf);
        JTEndereco.setText(endereco);
        JTNome.setText(nome);
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
        pedidoTitulo = new javax.swing.JLabel();
        panelEntradas = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        fieldCliente = new javax.swing.JTextField();
        labelProduto = new javax.swing.JLabel();
        fieldProduto = new javax.swing.JTextField();
        labelQtd = new javax.swing.JLabel();
        fieldQtd = new javax.swing.JTextField();
        panelMenuPedido = new javax.swing.JPanel();
        buttonPedidoOK = new javax.swing.JButton();
        buttonPedidoCCL = new javax.swing.JButton();

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        pedidoTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(pedidoTitulo);

        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 250));
        panelEntradas.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        labelCodigo.setForeground(Loja.corFonteClara);
        labelCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCodigo.setText("Codigo do Pedido: ");
        labelCodigo.setAlignmentY(0.2F);
        labelCodigo.setMaximumSize(new java.awt.Dimension(300, 30));
        labelCodigo.setMinimumSize(new java.awt.Dimension(200, 30));
        labelCodigo.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelCodigo);

        fieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldCodigo.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldCodigo.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldCodigo.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldCodigo);

        labelCliente.setForeground(Loja.corFonteClara);
        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCliente.setText("CPF do Cliente:");
        labelCliente.setAlignmentY(0.2F);
        labelCliente.setMaximumSize(new java.awt.Dimension(300, 30));
        labelCliente.setMinimumSize(new java.awt.Dimension(200, 30));
        labelCliente.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelCliente);

        fieldCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldCliente.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldCliente.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldCliente.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldCliente);

        labelProduto.setForeground(Loja.corFonteClara);
        labelProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProduto.setText("Codigo do Produto: ");
        labelProduto.setAlignmentY(0.2F);
        labelProduto.setMaximumSize(new java.awt.Dimension(300, 30));
        labelProduto.setMinimumSize(new java.awt.Dimension(200, 30));
        labelProduto.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelProduto);

        fieldProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldProduto.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldProduto.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldProduto.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldProduto);

        labelQtd.setForeground(Loja.corFonteClara);
        labelQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtd.setText("Quantidade: ");
        labelQtd.setAlignmentY(0.2F);
        labelQtd.setMaximumSize(new java.awt.Dimension(300, 30));
        labelQtd.setMinimumSize(new java.awt.Dimension(200, 30));
        labelQtd.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelQtd);

        fieldQtd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldQtd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldQtd.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldQtd.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldQtd.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldQtd);

        panelMenuPedido.setOpaque(false);
        panelMenuPedido.setPreferredSize(new java.awt.Dimension(400, 30));
        panelMenuPedido.setRequestFocusEnabled(false);
        panelMenuPedido.setLayout(new java.awt.GridLayout(0, 2, 50, 0));

        buttonPedidoOK.setBackground(Loja.corFundoEscura);
        buttonPedidoOK.setForeground(Loja.corFonteClara);
        buttonPedidoOK.setText("OK");
        panelMenuPedido.add(buttonPedidoOK);

        buttonPedidoCCL.setBackground(Loja.corFundoEscura);
        buttonPedidoCCL.setForeground(Loja.corFonteClara);
        buttonPedidoCCL.setText("Cancela");
        buttonPedidoCCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPedidoCCLActionPerformed(evt);
            }
        });
        panelMenuPedido.add(buttonPedidoCCL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMenuPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMenuPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPedidoCCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPedidoCCLActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonPedidoCCLActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPedidoCCL;
    private javax.swing.JButton buttonPedidoOK;
    private javax.swing.JTextField fieldCliente;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldProduto;
    private javax.swing.JTextField fieldQtd;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelQtd;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JPanel panelMenuPedido;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel pedidoTitulo;
    // End of variables declaration//GEN-END:variables

    private void setDefaultCloseOperation() {
        //
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Celular: %s", nome, celular);
    }
}
