/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;

/**
 *
 * @author Carlos
 */
public class Pedido extends javax.swing.JPanel {

    private int codProduto;
    private int codPedido;
    private int quantidade;
    private double preco;
    private String data;
    private Cliente cliente;

    /**
     * Creates new form Pedido
     */
    Pedido() {
        initComponents();
        setVisible(false);
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
            Cliente cli = Loja.buscaCliente(fieldCliente.getText());
            if (cli != null) {
                this.codPedido = codigoDigitado;
                this.codProduto = Integer.parseInt(fieldProduto.getText());
                this.quantidade = Integer.parseInt(fieldQuantidade.getText());
                this.data = fieldData.getText();
                this.cliente = cli;
                cli.cadastrarPedido(this);
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
        this.codProduto = Integer.parseInt(fieldProduto.getText());
        this.quantidade = Integer.parseInt(fieldQuantidade.getText());
        return true;
    }

    public void mostrarInfo(Runnable callback, String msgLabel) {
        setVisible(true);
        pedidoTitulo.setText(msgLabel);
        fieldCodigo.setText(String.format("%d", codPedido));
        fieldCodigo.setEnabled(false);
        fieldData.setText(String.format("%s", data));
        fieldProduto.setText(String.format("%d", codProduto));
        fieldQuantidade.setText(String.format("%d", quantidade));
        fieldPreco.setText(String.format("%.2f", Loja.buscaProduto(codProduto).getPreco() * quantidade));
        buttonPedidoCCL.setVisible(false);
        buttonPedidoOK.setAction(new AbstractAction("OK") {
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

    public void setPreco() {
        if (codProduto != 0) {
            preco = quantidade * Loja.buscaProduto(codProduto).getPreco();
        } else {
            preco = 0;
        }
    }

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
        fieldQuantidade = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        fieldPreco = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        fieldData = new javax.swing.JFormattedTextField();
        panelMenuPedido = new javax.swing.JPanel();
        buttonPedidoOK = new javax.swing.JButton();
        buttonPedidoCCL = new javax.swing.JButton();

        setBackground(Loja.corFundoEscura);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName("containerPedido"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        pedidoTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(pedidoTitulo);

        add(panelTitulo);

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
        fieldProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldProdutoKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldProduto);

        labelQtd.setForeground(Loja.corFonteClara);
        labelQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtd.setText("Quantidade: ");
        labelQtd.setAlignmentY(0.2F);
        labelQtd.setMaximumSize(new java.awt.Dimension(300, 30));
        labelQtd.setMinimumSize(new java.awt.Dimension(200, 30));
        labelQtd.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelQtd);

        fieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldQuantidade.setText("1");
        fieldQuantidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldQuantidade.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldQuantidade.setMinimumSize(new java.awt.Dimension(200, 30));
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
        labelPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelPreco);

        fieldPreco.setEditable(false);
        fieldPreco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPreco.setText("R$0.00");
        fieldPreco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldPreco);

        labelData.setForeground(Loja.corFonteClara);
        labelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelData.setText("Data (dd/mm/ano): ");
        labelData.setAlignmentY(0.2F);
        labelData.setMaximumSize(new java.awt.Dimension(300, 30));
        labelData.setMinimumSize(new java.awt.Dimension(200, 30));
        labelData.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelData);

        fieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/y"))));
        fieldData.setText("dd/mm/aa");
        fieldData.setToolTipText("Formato: 01/12/2022");
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
            }
        } catch (NumberFormatException e) {
            fieldQuantidade.setText("");
        }
        setPreco();
    }//GEN-LAST:event_fieldQuantidadeKeyReleased

    private void fieldProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProdutoKeyReleased
        try {
            int val = Integer.parseInt(fieldProduto.getText());
            Produto p = Loja.buscaProduto(val);
            if (val <= 0 || p == null) {
                fieldProduto.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            } else {
                labelProduto.setText(labelProduto.getText() + p.getNome());
                fieldProduto.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara));
            }
        } catch (NumberFormatException e) {
            fieldProduto.setText("");
        }
        setPreco();
    }//GEN-LAST:event_fieldProdutoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPedidoCCL;
    private javax.swing.JButton buttonPedidoOK;
    private javax.swing.JTextField fieldCliente;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JFormattedTextField fieldData;
    private javax.swing.JTextField fieldPreco;
    private javax.swing.JTextField fieldProduto;
    private javax.swing.JTextField fieldQuantidade;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelQtd;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JPanel panelMenuPedido;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel pedidoTitulo;
    // End of variables declaration//GEN-END:variables
}
