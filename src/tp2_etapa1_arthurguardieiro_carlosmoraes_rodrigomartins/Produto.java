package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Produto extends javax.swing.JPanel implements Serializable, ISetorLoja {

    private static final long serialVersionUID = 20220807;
    private int codigo;
    private String nome;
    private double preco;
    private String descricao;

    Produto() {
        initComponents();
    }

    public Produto(Produto p) {
        this(p.nome, p.preco, p.descricao, p.codigo);
        fieldCodigo.setText(String.format("%d", codigo));
        fieldNome.setText(String.format("%s", nome));
        fieldPreco.setText(String.format("R$%.2f", preco));
        fieldDesc.setText(String.format("%s", descricao));
    }

    public Produto(String nome, double preco, String descricao, int cod) {
        this();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.codigo = cod;
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
    public void iniciarCadastro(Runnable callback) {
        setVisible(true);
        produtoTitulo.setText("Novo produto: ");
        buttonProdutoOK.setAction(new AbstractAction("Confirmar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarProduto()) {
                        callback.run();
                        setVisible(false);
                    }
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        });
    }

    @Override
    public void mostrarCadastro(Runnable callback) {
        setVisible(true);
        produtoTitulo.setText("Informações do Produto: ");
        buttonProdutoCCL.setAction(new AbstractAction("Cancelar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }
        });
        buttonProdutoOK.setAction(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
                setVisible(false);
            }
        });
    }

    public boolean validarProduto() {
        Produto p = Loja.buscaProduto(Integer.parseInt(fieldCodigo.getText()));
        if (p != null) {
            throw new IllegalArgumentException("Já existe um produto com esse código.");
        } else {
            if (fieldNome.getText().length() > 0) {
                this.nome = fieldNome.getText();
                this.codigo = Integer.parseInt(fieldCodigo.getText());
                this.descricao = fieldDesc.getText().length() > 0 ? fieldDesc.getText() : "Sem descrição";
                Double precoDigitado = Double.parseDouble(fieldPreco.getText());
                this.preco = precoDigitado;
                JOptionPane.showMessageDialog(null, "Produto cadastrado");
                return true;
            } else {
                throw new IllegalArgumentException("O nome não pode ficar em branco");
            }
        }
    }

    public boolean validarEdicao() {
        Produto existente = Loja.buscaProduto(Integer.parseInt(fieldCodigo.getText()));
        if (existente == this) {
            this.codigo = Integer.parseInt(fieldCodigo.getText());
            this.nome = fieldNome.getText();
            this.descricao = fieldDesc.getText();
            this.preco = Double.parseDouble(fieldPreco.getText().replace("R$", ""));
            return true;
        } else {
            throw new IllegalArgumentException("Codigo invalido");
        }
    }

    @Override
    public void editarCadastro(Runnable callback) {
        setVisible(true);
        produtoTitulo.setText("Editar Produto: ");
        buttonProdutoCCL.setAction(new AbstractAction("Cancelar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.run();
            }
        });
        buttonProdutoOK.setAction(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validarEdicao()) {
                        callback.run();
                    }
                } catch (IllegalArgumentException f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
        });
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s Preço unit.: %.2f", nome, preco);
    }

    @Override
    public String gerarStringRelatorio() {
        return String.format("%d\\%s\\%f\\%s", codigo, nome, preco, descricao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        produtoTitulo = new javax.swing.JLabel();
        panelEntradas = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        fieldPreco = new javax.swing.JTextField();
        labelDesc = new javax.swing.JLabel();
        fieldDesc = new javax.swing.JTextField();
        painelMenuProduto = new javax.swing.JPanel();
        buttonProdutoOK = new javax.swing.JButton();
        buttonProdutoCCL = new javax.swing.JButton();

        setBackground(Loja.corFundoEscura);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setName("containerProduto"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 500));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        panelTitulo.setOpaque(false);
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 30));

        produtoTitulo.setForeground(Loja.corFonteClara);
        panelTitulo.add(produtoTitulo);

        add(panelTitulo);

        panelEntradas.setName("panelPedido"); // NOI18N
        panelEntradas.setOpaque(false);
        panelEntradas.setPreferredSize(new java.awt.Dimension(400, 250));
        panelEntradas.setLayout(new java.awt.GridLayout(6, 0, 0, 10));

        labelCodigo.setForeground(Loja.corFonteClara);
        labelCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCodigo.setText("Codigo do Produto:");
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
        fieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCodigoKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldCodigo);

        labelNome.setForeground(Loja.corFonteClara);
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("Nome: ");
        labelNome.setAlignmentY(0.2F);
        labelNome.setMaximumSize(new java.awt.Dimension(300, 30));
        labelNome.setMinimumSize(new java.awt.Dimension(200, 30));
        labelNome.setName(""); // NOI18N
        labelNome.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelNome);

        fieldNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldNome.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldNome.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldNome.setName("fieldNome"); // NOI18N
        fieldNome.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNomeKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldNome);

        labelPreco.setForeground(Loja.corFonteClara);
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("Preço: ");
        labelPreco.setAlignmentY(0.2F);
        labelPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        labelPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        labelPreco.setName(""); // NOI18N
        labelPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelPreco);

        fieldPreco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPreco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldPreco.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldPreco.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldPreco.setName("fieldPreco"); // NOI18N
        fieldPreco.setPreferredSize(new java.awt.Dimension(300, 20));
        fieldPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldPrecoKeyReleased(evt);
            }
        });
        panelEntradas.add(fieldPreco);

        labelDesc.setForeground(Loja.corFonteClara);
        labelDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDesc.setText("Descrição: ");
        labelDesc.setAlignmentY(0.2F);
        labelDesc.setMaximumSize(new java.awt.Dimension(300, 30));
        labelDesc.setMinimumSize(new java.awt.Dimension(200, 30));
        labelDesc.setName(""); // NOI18N
        labelDesc.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(labelDesc);

        fieldDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldDesc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fieldDesc.setMaximumSize(new java.awt.Dimension(300, 30));
        fieldDesc.setMinimumSize(new java.awt.Dimension(200, 30));
        fieldDesc.setName("fieldProduto"); // NOI18N
        fieldDesc.setPreferredSize(new java.awt.Dimension(300, 20));
        panelEntradas.add(fieldDesc);

        add(panelEntradas);

        painelMenuProduto.setOpaque(false);
        painelMenuProduto.setPreferredSize(new java.awt.Dimension(400, 30));
        painelMenuProduto.setRequestFocusEnabled(false);
        painelMenuProduto.setLayout(new java.awt.GridLayout(0, 2, 50, 0));

        buttonProdutoOK.setBackground(Loja.corFundoEscura);
        buttonProdutoOK.setForeground(Loja.corFonteClara);
        buttonProdutoOK.setText("OK");
        painelMenuProduto.add(buttonProdutoOK);

        buttonProdutoCCL.setBackground(Loja.corFundoEscura);
        buttonProdutoCCL.setForeground(Loja.corFonteClara);
        buttonProdutoCCL.setText("Cancela");
        buttonProdutoCCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProdutoCCLActionPerformed(evt);
            }
        });
        painelMenuProduto.add(buttonProdutoCCL);

        add(painelMenuProduto);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProdutoCCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProdutoCCLActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonProdutoCCLActionPerformed

    private void fieldPrecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPrecoKeyReleased
        String limpa = fieldPreco.getText().replaceAll("[^0-9,.]", "");
        try {
            Double.parseDouble(limpa);
            fieldPreco.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
        } catch (NumberFormatException e) {
            fieldPreco.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }//GEN-LAST:event_fieldPrecoKeyReleased

    private void fieldNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeKeyReleased
        if (fieldNome.getText().length() > 0 && fieldNome.getText().length() < 40) {
            fieldNome.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
        } else {
            fieldNome.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }
    }//GEN-LAST:event_fieldNomeKeyReleased

    private void fieldCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodigoKeyReleased
        String limpa = fieldCodigo.getText().replaceAll("[^0-9]", "");
        fieldCodigo.setText(limpa);
        if (!limpa.isEmpty()) {
            fieldCodigo.setBorder(BorderFactory.createLineBorder(Loja.corFundoClara, 1));
        } else {
            fieldCodigo.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        }

    }//GEN-LAST:event_fieldCodigoKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        fieldCodigo.setText(String.format("%d", codigo));
        fieldNome.setText(String.format("%s", nome));
        fieldPreco.setText(String.format("R$%.2f", preco));
        fieldDesc.setText(String.format("%s", descricao));
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private transient javax.swing.JButton buttonProdutoCCL;
    private transient javax.swing.JButton buttonProdutoOK;
    private transient javax.swing.JTextField fieldCodigo;
    private transient javax.swing.JTextField fieldDesc;
    private transient javax.swing.JTextField fieldNome;
    private transient javax.swing.JTextField fieldPreco;
    private transient javax.swing.JLabel labelCodigo;
    private transient javax.swing.JLabel labelDesc;
    private transient javax.swing.JLabel labelNome;
    private transient javax.swing.JLabel labelPreco;
    private transient javax.swing.JPanel painelMenuProduto;
    private transient javax.swing.JPanel panelEntradas;
    private transient javax.swing.JPanel panelTitulo;
    private transient javax.swing.JLabel produtoTitulo;
    // End of variables declaration//GEN-END:variables
}
