package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Pedido extends javax.swing.JPanel implements Serializable, ISetorLoja {

    private int codPedido;
    private int quantidade;
    private double preco;
    private String data;
    private Cliente cliente;
    private Produto produto;

    public Pedido() {
        data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        quantidade = 1;
        initComponents();
    }

    public Pedido(int codPedido, int quantidade, double preco, String data) {
        this.codPedido = codPedido;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
        initComponents();
    }

    public Pedido(Pedido p, Cliente c, Produto pd) {
        this(p.codPedido, p.quantidade, p.preco, p.data);
        cliente = c;
        produto = pd;
        fieldCodigo.setText(codPedido < 0 ? "" : String.format("%d", codPedido));
        fieldClienteCPF.setText(c.getCpf());
        fieldClienteNome.setText(c.toString());
        fieldData.setText(String.format("%s", data));
        fieldProdutoCod.setText(produto != null ? String.format("%d", produto.getCodigo()) : "");
        fieldProdutoNome.setText(pd.toString());
        fieldQuantidade.setText(String.format("%d", quantidade));
        fieldPreco.setText(String.format("R$%.2f", preco));
    }

    public int getCodigo() {
        return codPedido;
    }

    public int getCodProduto() {
        return produto.getCodigo();
    }

    @Override
    public void iniciarCadastro(Runnable callback) {
        setVisible(true);
        pedidoTitulo.setText("Novo pedido: ");
        buttonPedidoCCL.setVisible(true);
        buttonPedidoOK.setAction(new AbstractAction("Confirmar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarCampos()) {
                        cadastrarNoCliente();
                        callback.run();
                        setVisible(false);
                    }
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                } catch (DateTimeParseException dateEx) {
                    JOptionPane.showMessageDialog(null, "Data Invalida");
                }
            }
        });
    }

    private void cadastrarNoCliente() {
        cliente.cadastrarPedido(this);
        JOptionPane.showMessageDialog(null, "Cadastro OK");
    }

    private boolean validarCampos() {
        setCodigo();
        setCliente();
        setProduto();
        setQuantidade();
        setData();
        setPreco();
        return true;
    }

    @Override
    public void editarCadastro(Runnable callback) {
        setVisible(true);
        pedidoTitulo.setText("Editar Pedido: ");
        buttonPedidoCCL.setAction(new AbstractAction("Cancelar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }
        });
        buttonPedidoOK.setAction(new AbstractAction("Editar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarCampos()) {
                        callback.run();
                    }
                } catch (IllegalArgumentException f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
        });
    }

    @Override
    public void mostrarCadastro(Runnable callback) {
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

    private void setQuantidade() {
        int val = Integer.parseInt(fieldQuantidade.getText());
        if (val > 0) {
            this.quantidade = val;
        }
    }

    private void setData() {
        if (fieldData.getText().length() > 0) {
            LocalDate a = LocalDate.parse(fieldData.getText().replace(" ", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            data = a.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            throw new IllegalArgumentException("A data não pode ficar em branco.");
        }
    }

    private void setCodigo() {
        if (fieldCodigo.getText().length() <= 0) {
            throw new IllegalArgumentException("O código não pode ficar em branco.");
        } else {
            int codigoDigitado = Integer.parseInt(fieldCodigo.getText());
            Pedido encontrado = Loja.buscaPedido(codigoDigitado);
            if (encontrado != null) {
                if (encontrado != this) {
                    throw new IllegalArgumentException("Já existe um outro pedido com o o codigo digitado.");
                } else {
                    this.codPedido = codigoDigitado;
                }
            } else {
                this.codPedido = codigoDigitado;
            }
        }
    }

    private void setProduto() {
        Produto p = Loja.buscaProduto(Integer.parseInt(fieldProdutoCod.getText()));
        if (p != null) {
            produto = p;
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    private void setCliente() {
        Cliente c = Loja.buscaCliente(fieldClienteCPF.getText());
        if (c != null) {
            cliente = c;
        } else {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
    }

    private void setPreco() {
        if (produto != null) {
            preco = quantidade * produto.getPreco();
        } else {
            preco = 0;
        }
    }

    @Override
    public String gerarStringRelatorio() {
        return String.format("codigo: %s, quantidade: %s, preco: %s, data: %s", codPedido, quantidade, preco, data);
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
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("containerPedido"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        pedidoTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(pedidoTitulo);

        add(panelTitulo);

        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 320));
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
        fieldCodigo.setName("fieldCodigoPedidoIn"); // NOI18N
        fieldCodigo.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCodigoKeyReleased(evt);
            }
        });
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
        fieldClienteCPF.setName("fieldClienteCPFIn"); // NOI18N
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
        fieldClienteNome.setForeground(Loja.corFonteClara);
        fieldClienteNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldClienteNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldClienteNome.setFocusable(false);
        fieldClienteNome.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldClienteNome.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldClienteNome.setName("fieldClienteInfo"); // NOI18N
        fieldClienteNome.setOpaque(false);
        fieldClienteNome.setPreferredSize(new java.awt.Dimension(300, 40));
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
        fieldProdutoCod.setName("fieldCodigoProdutoIn"); // NOI18N
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
        fieldProdutoNome.setFocusable(false);
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
        fieldQuantidade.setName("fieldQuantidadeIn"); // NOI18N
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
        fieldPreco.setForeground(Loja.corFonteClara);
        fieldPreco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPreco.setText("R$0.00");
        fieldPreco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldPreco.setFocusable(false);
        fieldPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldPreco.setName("fieldPreco"); // NOI18N
        fieldPreco.setOpaque(false);
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
        fieldData.setText(data);
        fieldData.setToolTipText("Formato: 01/12/2022");
        fieldData.setName("fieldDataIn"); // NOI18N
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
        String limpa = fieldQuantidade.getText().replaceAll("[^0-9]", "");
        fieldQuantidade.setText(limpa);
        if (!limpa.isEmpty()) {
            try {
                int val = Integer.parseInt(limpa);
                if (val <= 0) {
                    fieldQuantidade.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                } else {
                    fieldQuantidade.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara));
                    if (fieldProdutoCod.getText().length() > 0) {
                        Produto p = Loja.buscaProduto(Integer.parseInt(fieldProdutoCod.getText()));
                        fieldPreco.setText(String.format("R$%.2f", val * (p == null ? 0 : p.getPreco())
                        ));
                    }
                }
            } catch (NumberFormatException e) {
                fieldQuantidade.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                fieldPreco.setText("R$0.00");
            }
        }
    }//GEN-LAST:event_fieldQuantidadeKeyReleased

    private void fieldProdutoCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProdutoCodKeyReleased
        fieldProdutoCod.setText(fieldProdutoCod.getText().replaceAll("[^0-9]", ""));
        try {
            Produto p = Loja.buscaProduto(Integer.parseInt(fieldProdutoCod.getText()));
            if (p == null) {
                fieldProdutoCod.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                fieldProdutoNome.setText("Não encontrado");
            } else {
                fieldProdutoCod.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
                fieldProdutoNome.setText(p.toString());
                fieldPreco.setText(String.format("R$%.2f", quantidade * p.getPreco()));
            }
        } catch (NumberFormatException e) {
            fieldProdutoCod.setText("");
        }
    }//GEN-LAST:event_fieldProdutoCodKeyReleased

    private void fieldDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDataKeyReleased
        //..
    }//GEN-LAST:event_fieldDataKeyReleased

    private void fieldClienteCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldClienteCPFKeyReleased
        Cliente encontrado = Loja.buscaCliente(fieldClienteCPF.getText());
        if (encontrado != null) {
            fieldClienteCPF.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
            fieldClienteNome.setText(encontrado.getInfoResumida());
        } else {
            fieldClienteNome.setText("Não encontrado.");
            fieldClienteCPF.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }//GEN-LAST:event_fieldClienteCPFKeyReleased

    private void fieldProdutoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProdutoNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProdutoNomeKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        fieldCodigo.setText(codPedido < 0 ? "" : String.format("%d", codPedido));
        fieldData.setText(String.format("%s", data));
        fieldProdutoCod.setText(produto != null ? String.format("%d", produto.getCodigo()) : "");
        fieldQuantidade.setText(String.format("%d", quantidade));
        fieldPreco.setText(String.format("%.2f", preco));
    }//GEN-LAST:event_formComponentShown

    private void fieldCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodigoKeyReleased
        fieldCodigo.setText(fieldCodigo.getText().replaceAll("[^0-9]", ""));
        if (fieldCodigo.getText().length() > 0) {
            fieldCodigo.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
        } else {
            fieldCodigo.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }//GEN-LAST:event_fieldCodigoKeyReleased


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
