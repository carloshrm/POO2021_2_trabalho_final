package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Loja extends JFrame {

    public static Color corFundoEscura = Color.darkGray;
    public static Color corFundoClara = Color.lightGray;
    public static Color corFonteClara = Color.white;
    public static Color corFonteEscura = Color.black;
    public static Color corDestaque = Color.white;

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public Loja() {
        initComponents();
        setBounds(0, 0, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println(e);
            }
        });
        adicionarExemplosProdutos();
    }

    private void adicionarExemplosProdutos() {
        produtos.add(new Produto("P1", 11.22, "Prod 1"));
        produtos.add(new Produto("P2", 9.99, "Prod 2"));
        produtos.add(new Produto("P3", 33.44, "Prod 3"));
    }

    public static Pedido buscaPedido(int codigo) {
        for (Pedido pd : pedidos) {
            if (pd.getCodigo() == codigo) {
                return pd;
            }
        }
        return null;
    }

    public static Cliente buscaCliente(String cpf) {
        for (Cliente cl : clientes) {
            if (cl.getCpf().equalsIgnoreCase(cpf)) {
                return cl;
            }
        }
        return null;
    }

    public static Produto buscaProduto(int cod) {
        for (Produto pr : produtos) {
            if (pr.getCodigo() == cod) {
                return pr;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        frameProcurar = new javax.swing.JFrame();
        labelProcurar = new javax.swing.JLabel();
        fieldProcurar = new javax.swing.JTextField();
        buttonProcurar = new javax.swing.JButton();
        frameExcluirPedido = new javax.swing.JFrame();
        labelExcluirPedido = new javax.swing.JLabel();
        fieldExcluirPedido = new javax.swing.JTextField();
        buttonExcluirOK = new javax.swing.JButton();
        frameAlterar = new javax.swing.JFrame();
        labelAlterar = new javax.swing.JLabel();
        fieldAlterar = new javax.swing.JTextField();
        buttonAlterar = new javax.swing.JButton();
        frameExcluirCliente = new javax.swing.JFrame();
        labelExcluirCliente = new javax.swing.JLabel();
        fieldExcluirCliente = new javax.swing.JTextField();
        buttonExcluirCl = new javax.swing.JButton();
        painelCliente = new javax.swing.JPanel();
        menuClientes = new javax.swing.JPanel();
        buttonNovoCliente = new javax.swing.JButton();
        buttonProcurarCliente = new javax.swing.JButton();
        buttonAlterarCliente = new javax.swing.JButton();
        buttonExcluirCliente = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        menuPedidos = new javax.swing.JPanel();
        buttonNovoPedido = new javax.swing.JButton();
        buttonProcurarPedido = new javax.swing.JButton();
        buttonExcluirPedido = new javax.swing.JButton();
        buttonEditarPedido = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        Arquivo = new javax.swing.JMenu();
        Sair = new javax.swing.JMenuItem();

        frameProcurar.setTitle("Procurar:");
        frameProcurar.setBackground(Loja.corFundoEscura);
        frameProcurar.setBounds(new java.awt.Rectangle(200, 200, 300, 200));
        frameProcurar.setName("frameProcurar"); // NOI18N
        frameProcurar.setSize(new java.awt.Dimension(400, 250));
        frameProcurar.getContentPane().setLayout(new java.awt.GridBagLayout());

        labelProcurar.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        frameProcurar.getContentPane().add(labelProcurar, gridBagConstraints);

        fieldProcurar.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        frameProcurar.getContentPane().add(fieldProcurar, gridBagConstraints);

        buttonProcurar.setBackground(Loja.corFundoClara);
        buttonProcurar.setForeground(Loja.corFonteEscura);
        buttonProcurar.setText("OK");
        buttonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frameProcurar.getContentPane().add(buttonProcurar, gridBagConstraints);

        frameExcluirPedido.setTitle("Procurar:");
        frameExcluirPedido.setBackground(Loja.corFundoEscura);
        frameExcluirPedido.setBounds(new java.awt.Rectangle(200, 200, 300, 200));
        frameExcluirPedido.setName("frameProcurar"); // NOI18N
        frameExcluirPedido.setSize(new java.awt.Dimension(400, 250));
        frameExcluirPedido.getContentPane().setLayout(new java.awt.GridBagLayout());

        labelExcluirPedido.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        frameExcluirPedido.getContentPane().add(labelExcluirPedido, gridBagConstraints);

        fieldExcluirPedido.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        frameExcluirPedido.getContentPane().add(fieldExcluirPedido, gridBagConstraints);

        buttonExcluirOK.setBackground(Loja.corFundoClara);
        buttonExcluirOK.setForeground(Loja.corFonteEscura);
        buttonExcluirOK.setText("OK");
        buttonExcluirOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frameExcluirPedido.getContentPane().add(buttonExcluirOK, gridBagConstraints);

        frameAlterar.setTitle("Procurar:");
        frameAlterar.setBackground(Loja.corFundoEscura);
        frameAlterar.setBounds(new java.awt.Rectangle(200, 200, 300, 200));
        frameAlterar.setName("frameProcurar"); // NOI18N
        frameAlterar.setSize(new java.awt.Dimension(400, 250));
        frameAlterar.getContentPane().setLayout(new java.awt.GridBagLayout());

        labelAlterar.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        frameAlterar.getContentPane().add(labelAlterar, gridBagConstraints);

        fieldAlterar.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        frameAlterar.getContentPane().add(fieldAlterar, gridBagConstraints);

        buttonAlterar.setBackground(Loja.corFundoClara);
        buttonAlterar.setForeground(Loja.corFonteEscura);
        buttonAlterar.setText("OK");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frameAlterar.getContentPane().add(buttonAlterar, gridBagConstraints);

        frameExcluirCliente.setTitle("Procurar:");
        frameExcluirCliente.setBackground(Loja.corFundoEscura);
        frameExcluirCliente.setBounds(new java.awt.Rectangle(200, 200, 300, 200));
        frameExcluirCliente.setName("frameProcurar"); // NOI18N
        frameExcluirCliente.setSize(new java.awt.Dimension(400, 250));
        frameExcluirCliente.getContentPane().setLayout(new java.awt.GridBagLayout());

        labelExcluirCliente.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        frameExcluirCliente.getContentPane().add(labelExcluirCliente, gridBagConstraints);

        fieldExcluirCliente.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        frameExcluirCliente.getContentPane().add(fieldExcluirCliente, gridBagConstraints);

        buttonExcluirCl.setBackground(Loja.corFundoClara);
        buttonExcluirCl.setForeground(Loja.corFonteEscura);
        buttonExcluirCl.setText("OK");
        buttonExcluirCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirClActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frameExcluirCliente.getContentPane().add(buttonExcluirCl, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja");
        setBackground(Loja.corFundoEscura);
        setName("frameLoja"); // NOI18N
        getContentPane().setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        painelCliente.setBackground(Loja.corFundoEscura);
        painelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(Loja.corFundoClara, Loja.corFundoEscura), "Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), Loja.corDestaque)); // NOI18N
        painelCliente.setPreferredSize(new java.awt.Dimension(200, 200));
        painelCliente.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                painelClienteComponentResized(evt);
            }
        });
        painelCliente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        menuClientes.setBackground(new java.awt.Color(153, 153, 153));
        menuClientes.setOpaque(false);
        menuClientes.setPreferredSize(new java.awt.Dimension(300, 200));
        menuClientes.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                menuClientesAncestorResized(evt);
            }
        });

        buttonNovoCliente.setBackground(Loja.corFundoClara);
        buttonNovoCliente.setForeground(Loja.corFonteEscura);
        buttonNovoCliente.setText("Novo Cliente");
        buttonNovoCliente.setAlignmentX(0.5F);
        buttonNovoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonNovoCliente.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonNovoCliente.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonNovoCliente.setName("Novo Cliente"); // NOI18N
        buttonNovoCliente.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoClienteActionPerformed(evt);
            }
        });
        menuClientes.add(buttonNovoCliente);

        buttonProcurarCliente.setBackground(Loja.corFundoClara);
        buttonProcurarCliente.setForeground(Loja.corFonteEscura);
        buttonProcurarCliente.setText("Procurar Cliente");
        buttonProcurarCliente.setAlignmentX(0.5F);
        buttonProcurarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonProcurarCliente.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonProcurarCliente.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonProcurarCliente.setName("Novo Cliente"); // NOI18N
        buttonProcurarCliente.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(buttonProcurarCliente);

        buttonAlterarCliente.setBackground(Loja.corFundoClara);
        buttonAlterarCliente.setForeground(Loja.corFonteEscura);
        buttonAlterarCliente.setText("Alterar Cliente");
        buttonAlterarCliente.setAlignmentX(0.5F);
        buttonAlterarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAlterarCliente.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonAlterarCliente.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonAlterarCliente.setName("Novo Cliente"); // NOI18N
        buttonAlterarCliente.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(buttonAlterarCliente);

        buttonExcluirCliente.setBackground(Loja.corFundoClara);
        buttonExcluirCliente.setForeground(Loja.corFonteEscura);
        buttonExcluirCliente.setText("Excluir Cliente");
        buttonExcluirCliente.setAlignmentX(0.5F);
        buttonExcluirCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExcluirCliente.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonExcluirCliente.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonExcluirCliente.setName("Novo Cliente"); // NOI18N
        buttonExcluirCliente.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirClienteActionPerformed(evt);
            }
        });
        menuClientes.add(buttonExcluirCliente);

        painelCliente.add(menuClientes);

        getContentPane().add(painelCliente);

        painelPedido.setBackground(Loja.corFundoEscura);
        painelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(Loja.corDestaque, Loja.corFundoClara), "Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), Loja.corFonteClara)); // NOI18N
        painelPedido.setPreferredSize(new java.awt.Dimension(450, 200));
        painelPedido.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        menuPedidos.setBackground(new java.awt.Color(153, 153, 153));
        menuPedidos.setOpaque(false);
        menuPedidos.setPreferredSize(new java.awt.Dimension(300, 200));
        menuPedidos.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                menuPedidosAncestorResized(evt);
            }
        });

        buttonNovoPedido.setBackground(Loja.corFundoClara);
        buttonNovoPedido.setForeground(Loja.corFonteEscura);
        buttonNovoPedido.setText("Novo Pedido");
        buttonNovoPedido.setAlignmentX(0.5F);
        buttonNovoPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonNovoPedido.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonNovoPedido.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonNovoPedido.setName("Novo Pedido"); // NOI18N
        buttonNovoPedido.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(buttonNovoPedido);

        buttonProcurarPedido.setBackground(Loja.corFundoClara);
        buttonProcurarPedido.setForeground(Loja.corFonteEscura);
        buttonProcurarPedido.setText("Procurar Pedido");
        buttonProcurarPedido.setAlignmentX(0.5F);
        buttonProcurarPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonProcurarPedido.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonProcurarPedido.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonProcurarPedido.setName("Procurar Pedido"); // NOI18N
        buttonProcurarPedido.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonProcurarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(buttonProcurarPedido);

        buttonExcluirPedido.setBackground(Loja.corFundoClara);
        buttonExcluirPedido.setForeground(Loja.corFonteEscura);
        buttonExcluirPedido.setText("Excluir Pedido");
        buttonExcluirPedido.setAlignmentX(0.5F);
        buttonExcluirPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExcluirPedido.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonExcluirPedido.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonExcluirPedido.setName("Excluir Pedido"); // NOI18N
        buttonExcluirPedido.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(buttonExcluirPedido);

        buttonEditarPedido.setBackground(Loja.corFundoClara);
        buttonEditarPedido.setForeground(Loja.corFonteEscura);
        buttonEditarPedido.setText("Editar Pedido");
        buttonEditarPedido.setAlignmentX(0.5F);
        buttonEditarPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonEditarPedido.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonEditarPedido.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonEditarPedido.setName("Procurar Pedido"); // NOI18N
        buttonEditarPedido.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(buttonEditarPedido);

        painelPedido.add(menuPedidos);

        getContentPane().add(painelPedido);

        menuPrincipal.setBackground(Loja.corFundoEscura);
        menuPrincipal.setForeground(Loja.corFonteClara);

        Arquivo.setForeground(new java.awt.Color(255, 255, 255));
        Arquivo.setText("Arquivo");

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Arquivo.add(Sair);

        menuPrincipal.add(Arquivo);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoClienteActionPerformed
        Cliente novoCliente = new Cliente();
        novoCliente.setVisible(true);
        novoCliente.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                menuClientes.setVisible(true);
            }
        });
        menuClientes.setVisible(false);
        painelCliente.add(novoCliente);
        novoCliente.iniciarCadastro(() -> {
            novoCliente.setVisible(false);
            painelCliente.remove(novoCliente);
            menuClientes.setVisible(true);
            clientes.add(novoCliente);
        });
    }//GEN-LAST:event_buttonNovoClienteActionPerformed

    private void buttonNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoPedidoActionPerformed
        Pedido novoPedido = new Pedido();
        novoPedido.setVisible(true);
        novoPedido.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                menuPedidos.setVisible(true);
            }
        });
        menuPedidos.setVisible(false);
        painelPedido.add(novoPedido);
        novoPedido.iniciarCadastro(() -> {
            novoPedido.setVisible(false);
            painelPedido.remove(novoPedido);
            menuPedidos.setVisible(true);
            pedidos.add(novoPedido);
        });
    }//GEN-LAST:event_buttonNovoPedidoActionPerformed

    private void buttonProcurarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarPedidoActionPerformed
        frameProcurar.setVisible(true);
        frameProcurar.setTitle("Procurar Pedido: ");
        labelProcurar.setText("Codigo do pedido: ");
        fieldProcurar.setText("");
        buttonProcurar.setAction(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido encontrado = null;
                encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                if (encontrado != null) {
                    frameProcurar.setVisible(false);
                    JFrame popUp = new JFrame(encontrado.getName());
                    popUp.setBounds(500, 500, encontrado.getWidth(), encontrado.getHeight());
                    popUp.add(encontrado);
                    encontrado.mostrarInfo(() -> {
                        popUp.dispose();
                    }, "Pedido Encontrado: ");
                    popUp.setVisible(true);
                    popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido não encontrado.");
                }
            }
        });
    }//GEN-LAST:event_buttonProcurarPedidoActionPerformed

    private void buttonProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarClienteActionPerformed
        frameProcurar.setVisible(true);
        frameProcurar.setTitle("Procurar Cliente: ");
        labelProcurar.setText("cpf do cliente: ");
        fieldProcurar.setText("");
        buttonProcurar.setAction(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente encontrado = null;
                encontrado = buscaCliente(fieldProcurar.getText());
                if (encontrado != null) {
                    frameProcurar.setVisible(false);
                    JFrame popUp = new JFrame(encontrado.getName());
                    popUp.setBounds(500, 500, encontrado.getWidth(), encontrado.getHeight());
                    popUp.add(encontrado);
                    encontrado.mostrarInfo(() -> {
                        popUp.dispose();
                    }, "Cliente Encontrado: ");
                    popUp.setVisible(true);
                    popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            }
        });
    }//GEN-LAST:event_buttonProcurarClienteActionPerformed

    private void buttonExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirClienteActionPerformed
        frameExcluirCliente.setVisible(true);
        frameExcluirCliente.setTitle("Excluir cliente");
        labelExcluirCliente.setText("Digite o cpf: ");
        fieldExcluirCliente.setText("");
        buttonExcluirCl.addActionListener((e) -> {
            Cliente encontrado = buscaCliente(fieldExcluirCliente.getText());
            if (encontrado != null) {
                System.out.println("Excluido " + encontrado.getName());
                clientes.remove(encontrado);
                JOptionPane.showMessageDialog(null, "Cliente excluido.");
            } else {
                JOptionPane.showMessageDialog(null, "CPF não encontrado.");
                System.out.println("cpf nao encontrado");
            }
        });
    }//GEN-LAST:event_buttonExcluirClienteActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairActionPerformed

    private void buttonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonProcurarActionPerformed

    private void buttonExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirPedidoActionPerformed
        frameProcurar.setVisible(true);
        frameProcurar.setTitle("Excluir Pedido: ");
        labelProcurar.setText("Codigo do pedido: ");
        fieldProcurar.setText("");
        buttonProcurar.setAction(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido encontrado = null;
                encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                if (encontrado != null) {
                    pedidos.remove(encontrado);
                    frameProcurar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Pedido Excluido.");
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido não encontrado.");
                }
            }
        });
    }//GEN-LAST:event_buttonExcluirPedidoActionPerformed

    private void menuPedidosAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuPedidosAncestorResized
        menuPedidos.setPreferredSize(painelPedido.getSize());
    }//GEN-LAST:event_menuPedidosAncestorResized

    private void buttonEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarPedidoActionPerformed
        frameProcurar.setVisible(true);
        frameProcurar.setTitle("Editar Pedido: ");
        labelProcurar.setText("Codigo do pedido: ");
        fieldProcurar.setText("");
        buttonProcurar.setAction(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido encontrado = null;
                encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                if (encontrado != null) {
                    frameProcurar.setVisible(false);
                    JFrame popUp = new JFrame(encontrado.getName());
                    popUp.setBounds(500, 500, encontrado.getWidth(), encontrado.getHeight());
                    popUp.add(encontrado);
                    encontrado.mostrarInfo(() -> {
                        popUp.dispose();
                    }, "Editar Pedido: ");
                    popUp.setVisible(true);
                    popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido não encontrado.");
                }
            }
        });
    }//GEN-LAST:event_buttonEditarPedidoActionPerformed

    private void buttonAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarClienteActionPerformed
        frameAlterar.setVisible(true);
        frameAlterar.setTitle("Alterar dados");
        labelAlterar.setText("Digite o cpf: ");
        fieldAlterar.setText("");
        buttonProcurar.setAction(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente encontrado = null;
                encontrado = buscaCliente(fieldProcurar.getText());
                if (encontrado != null) {
                    frameProcurar.setVisible(false);
                    JFrame popUp = new JFrame(encontrado.getName());
                    popUp.setBounds(500, 500, encontrado.getWidth(), encontrado.getHeight());
                    popUp.add(encontrado);
                    encontrado.mostrarInfo(() -> {
                        popUp.dispose();
                    }, "Editar Cliente: ");
                    popUp.setVisible(true);
                    popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            }
        });
    }//GEN-LAST:event_buttonAlterarClienteActionPerformed

    private void painelClienteComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_painelClienteComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_painelClienteComponentResized

    private void buttonExcluirOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExcluirOKActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonExcluirClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExcluirClActionPerformed

    private void menuClientesAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuClientesAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_menuClientesAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Arquivo;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonAlterarCliente;
    private javax.swing.JButton buttonEditarPedido;
    private javax.swing.JButton buttonExcluirCl;
    private javax.swing.JButton buttonExcluirCliente;
    private javax.swing.JButton buttonExcluirOK;
    private javax.swing.JButton buttonExcluirPedido;
    private javax.swing.JButton buttonNovoCliente;
    private javax.swing.JButton buttonNovoPedido;
    private javax.swing.JButton buttonProcurar;
    private javax.swing.JButton buttonProcurarCliente;
    private javax.swing.JButton buttonProcurarPedido;
    private javax.swing.JTextField fieldAlterar;
    private javax.swing.JTextField fieldExcluirCliente;
    private javax.swing.JTextField fieldExcluirPedido;
    private javax.swing.JTextField fieldProcurar;
    private javax.swing.JFrame frameAlterar;
    private javax.swing.JFrame frameExcluirCliente;
    private javax.swing.JFrame frameExcluirPedido;
    private javax.swing.JFrame frameProcurar;
    private javax.swing.JLabel labelAlterar;
    private javax.swing.JLabel labelExcluirCliente;
    private javax.swing.JLabel labelExcluirPedido;
    private javax.swing.JLabel labelProcurar;
    private javax.swing.JPanel menuClientes;
    private javax.swing.JPanel menuPedidos;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelPedido;
    // End of variables declaration//GEN-END:variables

}
