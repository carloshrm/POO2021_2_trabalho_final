package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Pedido extends javax.swing.JPanel {

    private int codPedido;
    private int quantidade;
    private double preco;
    private String data;
    private Cliente cliente;
    private Produto produto;

    Pedido() {
        initComponents();
        setVisible(false);
        buttonPedidoCCL.setVisible(false);
        fieldData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        quantidade = 1;
    }

    public int getCodigo() {
        return codPedido;
    }

    public void iniciarCadastro(Runnable callback) {
        setVisible(true);
        pedidoTitulo.setText("Novo pedido: ");
        buttonPedidoOK.setAction(new AbstractAction("Cadastrar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarPedido()) {
                        callback.run();
                    }
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
    }

    private boolean validarPedido() {
        int codigoDigitado = Integer.parseInt(fieldCodigo.getText());
        if (Loja.buscaPedido(codigoDigitado) == null) {
            if (cliente != null) {
                this.codPedido = codigoDigitado;
                this.quantidade = Integer.parseInt(fieldQuantidade.getText());
                this.data = fieldData.getText();
                cliente.cadastrarPedido(this);
                fieldCodigo.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Cadastro OK");
                return true;
            } else {
                throw new IllegalArgumentException("Cliente não encontrado");
            }
        } else {
            throw new IllegalArgumentException("Já existe um pedido com o o codigo digitado.");
        }
    }

    public boolean validarEdicao() {
        this.quantidade = Integer.parseInt(fieldQuantidade.getText());
        this.data = fieldData.getText();
        return true;
    }

    public void editarInfo(Runnable callback) {
        setVisible(true);
        pedidoTitulo.setText("Editar Pedido: ");
        buttonPedidoCCL.setVisible(true);
        buttonPedidoOK.setAction(new AbstractAction("Editar") {
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

    public void mostrarInfo(Runnable callback) {
        setVisible(true);
        pedidoTitulo.setText("Informações do pedido: ");
        buttonPedidoOK.setAction(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
                setVisible(false);
            }
        });
    }

    public void setPreco() {
        if (produto != null) {
            preco = quantidade * produto.getPreco();
        } else {
            preco = 0;
        }
        fieldPreco.setText(String.format("R$%.2f", preco));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        pedidoTitulo = new javax.swing.JLabel();
        panelEntradas = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        labelClienteCPF = new javax.swing.JLabel();
        fieldClienteCPF = new javax.swing.JTextField();
        labelClienteNome = new javax.swing.JLabel();
        fieldClienteNome = new javax.swing.JTextField();
        labelProdutoCod = new javax.swing.JLabel();
        fieldProdutoCod = new javax.swing.JTextField();
        labelProdutoNome = new javax.swing.JLabel();
        fieldProdutoNome = new javax.swing.JTextField();
        labelQtd = new javax.swing.JLabel();
        fieldQuantidade = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        fieldPreco = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        fieldData = new javax.swing.JFormattedTextField();
        panelMenuPedido = new javax.swing.JPanel();
        buttonPedidoOK = new javax.swing.JButton();
        buttonPedidoCCL = new javax.swing.JButton();

        setBackground(Loja.corFundoEscura);
        setMinimumSize(new java.awt.Dimension(800, 350));
        setName("containerPedido"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 500));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));
        panelTitulo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelTituloComponentShown(evt);
            }
        });

        pedidoTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(pedidoTitulo);

        add(panelTitulo);

        panelEntradas.setMinimumSize(new java.awt.Dimension(500, 320));
        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 350));
        panelEntradas.setLayout(new java.awt.GridLayout(8, 0, 0, 10));

        labelCodigo.setForeground(Loja.corFonteClara);
        labelCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCodigo.setText("Codigo do Pedido: ");
        labelCodigo.setAlignmentY(0.2F);
        labelCodigo.setMaximumSize(new java.awt.Dimension(300, 30));
        labelCodigo.setMinimumSize(new java.awt.Dimension(200, 30));
        labelCodigo.setName(""); // NOI18N
        labelCodigo.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelCodigo);

        fieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldCodigo.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldCodigo.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldCodigo.setName("fieldCodigo"); // NOI18N
        fieldCodigo.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldCodigo);

        labelClienteCPF.setForeground(Loja.corFonteClara);
        labelClienteCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClienteCPF.setText("CPF do Cliente:");
        labelClienteCPF.setAlignmentY(0.2F);
        labelClienteCPF.setMaximumSize(new java.awt.Dimension(300, 30));
        labelClienteCPF.setMinimumSize(new java.awt.Dimension(200, 30));
        labelClienteCPF.setName(""); // NOI18N
        labelClienteCPF.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelClienteCPF);

        fieldClienteCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldClienteCPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldClienteCPF.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldClienteCPF.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldClienteCPF.setName("fieldClienteCPF"); // NOI18N
        fieldClienteCPF.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldClienteCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldClienteCPFKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldClienteCPF);

        labelClienteNome.setForeground(Loja.corFonteClara);
        labelClienteNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClienteNome.setText("Cliente: ");
        labelClienteNome.setAlignmentY(0.2F);
        labelClienteNome.setMaximumSize(new java.awt.Dimension(300, 30));
        labelClienteNome.setMinimumSize(new java.awt.Dimension(200, 30));
        labelClienteNome.setName(""); // NOI18N
        labelClienteNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelClienteNome);

        fieldClienteNome.setEditable(false);
        fieldClienteNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldClienteNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldClienteNome.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldClienteNome.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldClienteNome.setName("fieldClienteCPF"); // NOI18N
        fieldClienteNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldClienteNome);

        labelProdutoCod.setForeground(Loja.corFonteClara);
        labelProdutoCod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProdutoCod.setText("Codigo do Produto: ");
        labelProdutoCod.setAlignmentY(0.2F);
        labelProdutoCod.setMaximumSize(new java.awt.Dimension(300, 30));
        labelProdutoCod.setMinimumSize(new java.awt.Dimension(200, 30));
        labelProdutoCod.setName(""); // NOI18N
        labelProdutoCod.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelProdutoCod);

        fieldProdutoCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldProdutoCod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldProdutoCod.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldProdutoCod.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldProdutoCod.setName("fieldProdutoCod"); // NOI18N
        fieldProdutoCod.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldProdutoCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldProdutoCodKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldProdutoCod);

        labelProdutoNome.setForeground(Loja.corFonteClara);
        labelProdutoNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProdutoNome.setText("Produto: ");
        labelProdutoNome.setAlignmentY(0.2F);
        labelProdutoNome.setMaximumSize(new java.awt.Dimension(300, 30));
        labelProdutoNome.setMinimumSize(new java.awt.Dimension(200, 30));
        labelProdutoNome.setName(""); // NOI18N
        labelProdutoNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelProdutoNome);

        fieldProdutoNome.setEditable(false);
        fieldProdutoNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldProdutoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldProdutoNome.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldProdutoNome.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldProdutoNome.setName("fieldProdutoCod"); // NOI18N
        fieldProdutoNome.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldProdutoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldProdutoNomeKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldProdutoNome);

        labelQtd.setForeground(Loja.corFonteClara);
        labelQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtd.setText("Quantidade: ");
        labelQtd.setAlignmentY(0.2F);
        labelQtd.setMaximumSize(new java.awt.Dimension(300, 30));
        labelQtd.setMinimumSize(new java.awt.Dimension(200, 30));
        labelQtd.setName(""); // NOI18N
        labelQtd.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelQtd);

        fieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldQuantidade.setText("1");
        fieldQuantidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldQuantidade.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldQuantidade.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldQuantidade.setName("fieldQuantidade"); // NOI18N
        fieldQuantidade.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldQuantidadeKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldQuantidade);

        labelPreco.setForeground(Loja.corFonteClara);
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("Preço: ");
        labelPreco.setAlignmentY(0.2F);
        labelPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        labelPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        labelPreco.setName(""); // NOI18N
        labelPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelPreco);

        fieldPreco.setEditable(false);
        fieldPreco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPreco.setText("R$0.00");
        fieldPreco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldPreco.setName("fieldPreco"); // NOI18N
        fieldPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldPreco);

        labelData.setForeground(Loja.corFonteClara);
        labelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelData.setText("Data (dd/mm/ano): ");
        labelData.setAlignmentY(0.2F);
        labelData.setMaximumSize(new java.awt.Dimension(300, 30));
        labelData.setMinimumSize(new java.awt.Dimension(200, 30));
        labelData.setName(""); // NOI18N
        labelData.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelData);

        fieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/y"))));
        fieldData.setText("dd/mm/aa");
        fieldData.setToolTipText("Formato: 01/12/2022");
        fieldData.setName("fieldData"); // NOI18N
        fieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldDataKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldData);

        add(panelEntradas);

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

        add(panelMenuPedido);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPedidoCCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPedidoCCLActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonPedidoCCLActionPerformed

    private void fieldQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldQuantidadeKeyReleased
        try {
            int val = Integer.parseInt(fieldQuantidade.getText());
            if (val <= 0) {
                fieldQuantidade.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            } else {
                fieldQuantidade.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara));
                quantidade = val;
                setPreco();
            }
        } catch (NumberFormatException e) {
            fieldQuantidade.setText("");
        }
    }//GEN-LAST:event_fieldQuantidadeKeyReleased

    private void fieldProdutoCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProdutoCodKeyReleased
        try {
            Produto p = Loja.buscaProduto(Integer.parseInt(fieldProdutoCod.getText()));
            produto = p;
            if (p == null) {
                fieldProdutoCod.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                fieldProdutoNome.setText("Não encontrado");
            } else {
                fieldProdutoCod.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
                fieldProdutoNome.setText(produto.toString());
            }
            setPreco();
        } catch (NumberFormatException e) {
            fieldProdutoCod.setText("");
        }
    }//GEN-LAST:event_fieldProdutoCodKeyReleased

    private void panelTituloComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelTituloComponentShown
        fieldCodigo.setText(String.format("%d", codPedido));
        fieldData.setText(String.format("%s", data));
        fieldProdutoCod.setText(String.format("%d", produto.getCodigo()));
        fieldQuantidade.setText(String.format("%d", quantidade));
        fieldPreco.setText(String.format("%.2f", preco));
    }//GEN-LAST:event_panelTituloComponentShown

    private void fieldDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDataKeyReleased
        // ...
    }//GEN-LAST:event_fieldDataKeyReleased

    private void fieldClienteCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldClienteCPFKeyReleased
        Cliente cli = Loja.buscaCliente(fieldClienteCPF.getText());
        if (cli != null) {
            fieldClienteCPF.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
            fieldClienteNome.setText(cli.toString());
        } else {
            fieldClienteCPF.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }//GEN-LAST:event_fieldClienteCPFKeyReleased

    private void fieldProdutoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProdutoNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProdutoNomeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPedidoCCL;
    private javax.swing.JButton buttonPedidoOK;
    private javax.swing.JTextField fieldClienteCPF;
    private javax.swing.JTextField fieldClienteNome;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JFormattedTextField fieldData;
    private javax.swing.JTextField fieldPreco;
    private javax.swing.JTextField fieldProdutoCod;
    private javax.swing.JTextField fieldProdutoNome;
    private javax.swing.JTextField fieldQuantidade;
    private javax.swing.JLabel labelClienteCPF;
    private javax.swing.JLabel labelClienteNome;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelProdutoCod;
    private javax.swing.JLabel labelProdutoNome;
    private javax.swing.JLabel labelQtd;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JPanel panelMenuPedido;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel pedidoTitulo;
    // End of variables declaration//GEN-END:variables
}
