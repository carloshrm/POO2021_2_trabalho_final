package tp2_etapa1_arthurguardieiro_carlosmoraes_rodrigomartins;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;

public class Loja extends JFrame {

    public static Color corFundoEscura = Color.darkGray;
    public static Color corFundoClara = Color.lightGray;
    public static Color corFonteClara = Color.white;
    public static Color corFonteEscura = Color.black;
    public static Color corDestaque = Color.white;

    private static ArrayList<Cliente> clientes;
    private static ArrayList<Pedido> pedidos;
    private static ArrayList<Produto> produtos;

    public Loja() {
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();
        produtos = new ArrayList<>();
        initComponents();
        this.getContentPane().setBackground(Loja.corFundoEscura);
        setBounds(0, 0, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarEstado();
                System.exit(0);
            }
        });
        if (new File("info.ser").exists()) {
            carregarEstado();
        }
    }

    private void carregarEstado() {
        ArrayList<Produto> produtosLidos = null;
        ArrayList<Cliente> clientesLidos = null;
        try {
            FileInputStream araquivoIn = new FileInputStream("info.ser");
            ObjectInputStream objetoIn = new ObjectInputStream(araquivoIn);
            produtosLidos = (ArrayList<Produto>) objetoIn.readObject();
            clientesLidos = (ArrayList<Cliente>) objetoIn.readObject();
            objetoIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        if (produtosLidos != null && !produtosLidos.isEmpty()) {
            for (Produto prr : produtosLidos) {
                produtos.add(new Produto(prr));
            }
        }
        if (clientesLidos != null && !clientesLidos.isEmpty()) {
            for (Cliente cli : clientesLidos) {
                clientes.add(new Cliente(cli, produtosLidos));
            }
        }
        for (Cliente cli : clientes) {
            for (Pedido novo : cli.getPedidosFeitos()) {
                pedidos.add(novo);
            }
        }

    }

    private void salvarEstado() {
        ArrayList<Produto> salvarProdutos = new ArrayList<>();
        ArrayList<Cliente> salvarClientes = new ArrayList<>();
        for (Produto pro : produtos) {
            salvarProdutos.add(new Produto(pro));
        }
        for (Cliente cli : clientes) {
            salvarClientes.add(new Cliente(cli, salvarProdutos));
        }
        try {
            FileOutputStream arqOut = new FileOutputStream("info.ser");
            ObjectOutputStream objetoOut = new ObjectOutputStream(arqOut);
            objetoOut.writeObject(salvarProdutos);
            objetoOut.writeObject(salvarClientes);
            objetoOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static Pedido buscaPedido(int codigo) {
        for (Pedido pd : pedidos) {
            if (pd.getCodPedido() == codigo) {
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

    public static boolean buscaCpf(String cpf) {
        for (Cliente cl : clientes) {
            if (cl.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public static Produto buscaProduto(int cod) {
        for (Produto pr : produtos) {
            if (pr.getCodigo() == cod) {
                return pr;
            }
        }
        return null;
    }

    public static void relatorio(String enderecoArquivo) throws IOException {
        if (enderecoArquivo.isEmpty()) {
            enderecoArquivo = "relatorio.txt";
        }
        try {
            OutputStream os = new FileOutputStream(enderecoArquivo); // nome do arquivo que será escrito
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer
            br.write("Nome\\Cpf\\Endereco\\Celular\\Pedido(s)");
            br.newLine();
            for (Cliente cl : clientes) {
                br.write(cl.gerarStringRelatorio());
                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String salvarComo() {
        JFileChooser janelaSeletora = new JFileChooser();
        janelaSeletora.setDialogTitle("Escolha onde salvar: ");

        int escolha = janelaSeletora.showSaveDialog(frameProcurar);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            File novoArquivo = janelaSeletora.getSelectedFile();
            return novoArquivo.getAbsolutePath() + ".txt";
        }
        return "";
    }

    private void mostrarItemEmPopUp(JPanel encontrado, boolean editar) {
        JFrame popUp = new JFrame(encontrado.getName());
        popUp.setBounds(500, 500, encontrado.getPreferredSize().width, encontrado.getPreferredSize().height);
        popUp.add(encontrado);
        if (editar) {
            ((ISetorLoja) encontrado).editarCadastro(() -> {
                popUp.dispose();
            });
        } else {
            ((ISetorLoja) encontrado).mostrarCadastro(() -> {
                popUp.dispose();
            });
        }
        popUp.setVisible(true);
        popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void mostrarTelaDeBusca(AbstractAction funcaoBotao, String titulo, String label) {
        frameProcurar.setVisible(true);
        frameProcurar.setTitle(titulo);
        labelProcurar.setText(label);
        fieldProcurar.setText("");
        buttonProcurar.setAction(funcaoBotao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        frameProcurar = new javax.swing.JFrame();
        frameProcurar.getContentPane().setBackground(Loja.corFundoEscura);
        labelProcurar = new javax.swing.JLabel();
        fieldProcurar = new javax.swing.JTextField();
        buttonProcurar = new javax.swing.JButton();
        painelCliente = new javax.swing.JPanel();
        menuClientes = new javax.swing.JPanel();
        buttonNovoCliente = new javax.swing.JButton();
        buttonProcurarCliente = new javax.swing.JButton();
        buttonExcluirCliente = new javax.swing.JButton();
        buttonAlterarCliente = new javax.swing.JButton();
        buttonRelatorio = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        menuPedidos = new javax.swing.JPanel();
        buttonNovoPedido = new javax.swing.JButton();
        buttonProcurarPedido = new javax.swing.JButton();
        buttonExcluirPedido = new javax.swing.JButton();
        buttonEditarPedido = new javax.swing.JButton();
        painelProdutos = new javax.swing.JPanel();
        menuProdutos = new javax.swing.JPanel();
        buttonNovoProduto = new javax.swing.JButton();
        buttonProcurarProduto = new javax.swing.JButton();
        buttonExcluirProduto = new javax.swing.JButton();
        buttonEditarProduto = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        Arquivo = new javax.swing.JMenu();
        menuItemRelatorio = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();

        frameProcurar.setTitle("Procurar:");
        frameProcurar.setBackground(Loja.corFundoEscura);
        frameProcurar.setBounds(new java.awt.Rectangle(200, 200, 300, 200));
        frameProcurar.setName("frameProcurar"); // NOI18N
        frameProcurar.setSize(new java.awt.Dimension(400, 250));
        frameProcurar.getContentPane().setLayout(new java.awt.GridBagLayout());

        labelProcurar.setForeground(Loja.corFonteClara);
        labelProcurar.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        frameProcurar.getContentPane().add(labelProcurar, gridBagConstraints);

        fieldProcurar.setText("jTextField1");
        fieldProcurar.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frameProcurar.getContentPane().add(buttonProcurar, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja");
        setBackground(Loja.corFundoEscura);
        setName("frameLoja"); // NOI18N
        getContentPane().setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        painelCliente.setBackground(Loja.corFundoEscura);
        painelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(Loja.corFundoClara, Loja.corFundoEscura), "Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), Loja.corFonteClara
 // NOI18N
        ));
        painelCliente.setPreferredSize(new java.awt.Dimension(200, 200));
        painelCliente.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                painelClienteComponentAdded(evt);
            }
        });
        painelCliente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

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

        buttonRelatorio.setBackground(Loja.corFundoClara);
        buttonRelatorio.setForeground(Loja.corFonteEscura);
        buttonRelatorio.setText("Relatorio");
        buttonRelatorio.setAlignmentX(0.5F);
        buttonRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonRelatorio.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonRelatorio.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonRelatorio.setName("Novo Cliente"); // NOI18N
        buttonRelatorio.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRelatorioActionPerformed(evt);
            }
        });
        menuClientes.add(buttonRelatorio);

        painelCliente.add(menuClientes);

        getContentPane().add(painelCliente);

        painelPedido.setBackground(Loja.corFundoEscura);
        painelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, Loja.corFundoClara, Loja.corFundoEscura), "Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 11), Loja.corFonteClara)); // NOI18N
        painelPedido.setPreferredSize(new java.awt.Dimension(600, 200));
        painelPedido.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                painelPedidoComponentAdded(evt);
            }
        });
        painelPedido.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

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

        painelProdutos.setBackground(Loja.corFundoEscura);
        painelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(Loja.corFundoClara, Loja.corFundoEscura), "Produtos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), Loja.corFonteClara)); // NOI18N
        painelProdutos.setPreferredSize(new java.awt.Dimension(450, 200));
        painelProdutos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                painelProdutosComponentAdded(evt);
            }
        });
        painelProdutos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        menuProdutos.setBackground(new java.awt.Color(153, 153, 153));
        menuProdutos.setOpaque(false);
        menuProdutos.setPreferredSize(new java.awt.Dimension(300, 200));
        menuProdutos.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                menuProdutosAncestorResized(evt);
            }
        });

        buttonNovoProduto.setBackground(Loja.corFundoClara);
        buttonNovoProduto.setForeground(Loja.corFonteEscura);
        buttonNovoProduto.setText("Novo Produto");
        buttonNovoProduto.setAlignmentX(0.5F);
        buttonNovoProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonNovoProduto.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonNovoProduto.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonNovoProduto.setName("Novo Pedido"); // NOI18N
        buttonNovoProduto.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(buttonNovoProduto);

        buttonProcurarProduto.setBackground(Loja.corFundoClara);
        buttonProcurarProduto.setForeground(Loja.corFonteEscura);
        buttonProcurarProduto.setText("Procurar Produto");
        buttonProcurarProduto.setAlignmentX(0.5F);
        buttonProcurarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonProcurarProduto.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonProcurarProduto.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonProcurarProduto.setName("Procurar Pedido"); // NOI18N
        buttonProcurarProduto.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonProcurarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(buttonProcurarProduto);

        buttonExcluirProduto.setBackground(Loja.corFundoClara);
        buttonExcluirProduto.setForeground(Loja.corFonteEscura);
        buttonExcluirProduto.setText("Excluir Produto");
        buttonExcluirProduto.setAlignmentX(0.5F);
        buttonExcluirProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExcluirProduto.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonExcluirProduto.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonExcluirProduto.setName("Excluir Pedido"); // NOI18N
        buttonExcluirProduto.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(buttonExcluirProduto);

        buttonEditarProduto.setBackground(Loja.corFundoClara);
        buttonEditarProduto.setForeground(Loja.corFonteEscura);
        buttonEditarProduto.setText("Editar Produto");
        buttonEditarProduto.setAlignmentX(0.5F);
        buttonEditarProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonEditarProduto.setMargin(new java.awt.Insets(2, 20, 2, 20));
        buttonEditarProduto.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonEditarProduto.setName("Procurar Pedido"); // NOI18N
        buttonEditarProduto.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(buttonEditarProduto);

        painelProdutos.add(menuProdutos);

        getContentPane().add(painelProdutos);

        menuPrincipal.setBackground(Loja.corFundoEscura);
        menuPrincipal.setForeground(Loja.corFonteClara);

        Arquivo.setForeground(new java.awt.Color(255, 255, 255));
        Arquivo.setText("Arquivo");

        menuItemRelatorio.setText("Gerar Relatorio");
        menuItemRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioActionPerformed(evt);
            }
        });
        Arquivo.add(menuItemRelatorio);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        Arquivo.add(menuItemSair);

        menuPrincipal.add(Arquivo);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoClienteActionPerformed
        Cliente novoCliente = new Cliente();
        menuClientes.setVisible(false);
        painelCliente.add(novoCliente);
        novoCliente.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                menuClientes.setVisible(true);
            }
        });
        novoCliente.iniciarCadastro(() -> {
            painelCliente.remove(novoCliente);
            menuClientes.setVisible(true);
            clientes.add(novoCliente);
        });
    }//GEN-LAST:event_buttonNovoClienteActionPerformed

    private void buttonNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoPedidoActionPerformed
        Pedido novoPedido = new Pedido();
        menuPedidos.setVisible(false);
        painelPedido.add(novoPedido);
        novoPedido.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                menuPedidos.setVisible(true);
            }
        });
        novoPedido.iniciarCadastro(() -> {
            painelPedido.remove(novoPedido);
            menuPedidos.setVisible(true);
            pedidos.add(novoPedido);
        });
    }//GEN-LAST:event_buttonNovoPedidoActionPerformed

    private void buttonProcurarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarPedidoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pedido encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                    if (encontrado != null) {
                        frameProcurar.setVisible(false);
                        mostrarItemEmPopUp(encontrado, false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pedido não encontrado");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");
                }
            }
        }, "Procurar Pedido: ", "Codigo do pedido:");
    }//GEN-LAST:event_buttonProcurarPedidoActionPerformed

    private void buttonProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarClienteActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente encontrado = buscaCliente(fieldProcurar.getText());
                if (encontrado != null) {
                    frameProcurar.setVisible(false);
                    mostrarItemEmPopUp(encontrado, false);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            }
        }, "Procurar Cliente: ", "Cpf do Cliente: ");
    }//GEN-LAST:event_buttonProcurarClienteActionPerformed

    private void buttonExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirClienteActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldProcurar.getText().length() != 0) {
                        Cliente encontrado = buscaCliente(fieldProcurar.getText());
                        if (encontrado != null) {
                            clientes.remove(encontrado);
                            frameProcurar.setVisible(false);
                            JOptionPane.showMessageDialog(null, String.format("O cliente - %s - foi excluido.", encontrado.getInfoResumida()));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CPF em branco.");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "CPD inválido.");
                }
            }
        }, "Excluir Cliente: ", "CPF do cliente: ");
    }//GEN-LAST:event_buttonExcluirClienteActionPerformed

    private void buttonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonProcurarActionPerformed

    private void buttonExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirPedidoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldProcurar.getText().length() != 0) {
                        Pedido encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                        if (encontrado != null) {
                            encontrado.getCliente().removerPedido(encontrado);
                            pedidos.remove(encontrado);
                            frameProcurar.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Pedido Excluido.");
                        }
                    } else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Código inválido");
                }
            }
        }, "Excluir Pedido: ", "Código do pedido: ");
    }//GEN-LAST:event_buttonExcluirPedidoActionPerformed

    private void menuPedidosAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuPedidosAncestorResized
        menuPedidos.setPreferredSize(painelPedido.getSize());
    }//GEN-LAST:event_menuPedidosAncestorResized

    private void buttonEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarPedidoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldProcurar.getText().length() != 0) {
                        Pedido encontrado = buscaPedido(Integer.parseInt(fieldProcurar.getText()));
                        if (encontrado != null) {
                            frameProcurar.setVisible(false);
                            mostrarItemEmPopUp(encontrado, true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo invalido");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");

                }
            }
        }, "Editar pedido: ", "Código do pedido: ");
    }//GEN-LAST:event_buttonEditarPedidoActionPerformed

    private void buttonAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarClienteActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente encontrado = buscaCliente(fieldProcurar.getText());
                    if (encontrado != null) {
                        frameProcurar.setVisible(false);
                        mostrarItemEmPopUp(encontrado, true);
                    }
                } catch (CpfInvalidoException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");
                }
            }
        }, "Editar dados de um cliente: ", "CPF: ");
    }//GEN-LAST:event_buttonAlterarClienteActionPerformed

    private void menuClientesAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuClientesAncestorResized
        menuClientes.setPreferredSize(painelCliente.getSize());
    }//GEN-LAST:event_menuClientesAncestorResized

    private void buttonNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoProdutoActionPerformed
        Produto novoProduto = new Produto();
        menuProdutos.setVisible(false);
        painelProdutos.add(novoProduto);
        novoProduto.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                menuProdutos.setVisible(true);
            }
        });
        novoProduto.iniciarCadastro(() -> {
            novoProduto.setVisible(false);
            painelProdutos.remove(novoProduto);
            menuProdutos.setVisible(true);
            produtos.add(novoProduto);
        });
    }//GEN-LAST:event_buttonNovoProdutoActionPerformed

    private void buttonProcurarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarProdutoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Procurar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produto encontrado = buscaProduto(Integer.parseInt(fieldProcurar.getText()));
                    if (encontrado != null) {
                        frameProcurar.setVisible(false);
                        mostrarItemEmPopUp(encontrado, false);
                    } else {
                        throw new IllegalArgumentException("Produto não encontrado");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");
                } catch (IllegalArgumentException f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
        }, "Procurar Produto: ", "Código do produto: ");
    }//GEN-LAST:event_buttonProcurarProdutoActionPerformed

    private void buttonExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirProdutoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldProcurar.getText().length() != 0) {
                        Produto encontrado = buscaProduto(Integer.parseInt(fieldProcurar.getText()));
                        if (encontrado != null) {
                            produtos.remove(encontrado);
                            frameProcurar.setVisible(false);
                            JOptionPane.showMessageDialog(null, String.format("Produto Nome %s Cod %d foi excluido.", encontrado.getNome(), encontrado.getCodigo()));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo invalido");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");
                }
            }
        }, "Excluir Produto: ", "Código do produto: ");
    }//GEN-LAST:event_buttonExcluirProdutoActionPerformed

    private void buttonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarProdutoActionPerformed
        mostrarTelaDeBusca(new AbstractAction("Editar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldProcurar.getText().length() != 0) {
                        Produto encontrado = buscaProduto(Integer.parseInt(fieldProcurar.getText()));
                        if (encontrado != null) {
                            frameProcurar.setVisible(false);
                            mostrarItemEmPopUp(encontrado, true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo invalido");
                    }
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Codigo invalido");
                }
            }
        }, "Editar informações de um produto: ", "Código do produto: ");
    }//GEN-LAST:event_buttonEditarProdutoActionPerformed

    private void menuProdutosAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuProdutosAncestorResized
        menuProdutos.setPreferredSize(painelProdutos.getSize());
    }//GEN-LAST:event_menuProdutosAncestorResized

    private void painelPedidoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_painelPedidoComponentAdded
        painelPedido.setPreferredSize(evt.getChild().getPreferredSize());
    }//GEN-LAST:event_painelPedidoComponentAdded

    private void painelClienteComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_painelClienteComponentAdded
        painelCliente.setPreferredSize(evt.getChild().getPreferredSize());
    }//GEN-LAST:event_painelClienteComponentAdded

    private void painelProdutosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_painelProdutosComponentAdded
        painelProdutos.setPreferredSize(evt.getChild().getPreferredSize());
    }//GEN-LAST:event_painelProdutosComponentAdded

    private void buttonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRelatorioActionPerformed
        try {
            relatorio("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na criação do relatorio");
        }
    }//GEN-LAST:event_buttonRelatorioActionPerformed

    private void menuItemRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioActionPerformed
        try {
            relatorio(salvarComo());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na criação do relatorio");
        }
    }//GEN-LAST:event_menuItemRelatorioActionPerformed

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private transient javax.swing.JMenu Arquivo;
    private transient javax.swing.JButton buttonAlterarCliente;
    private transient javax.swing.JButton buttonEditarPedido;
    private transient javax.swing.JButton buttonEditarProduto;
    private transient javax.swing.JButton buttonExcluirCliente;
    private transient javax.swing.JButton buttonExcluirPedido;
    private transient javax.swing.JButton buttonExcluirProduto;
    private transient javax.swing.JButton buttonNovoCliente;
    private transient javax.swing.JButton buttonNovoPedido;
    private transient javax.swing.JButton buttonNovoProduto;
    private transient javax.swing.JButton buttonProcurar;
    private transient javax.swing.JButton buttonProcurarCliente;
    private transient javax.swing.JButton buttonProcurarPedido;
    private transient javax.swing.JButton buttonProcurarProduto;
    private transient javax.swing.JButton buttonRelatorio;
    private transient javax.swing.JTextField fieldProcurar;
    private transient javax.swing.JFrame frameProcurar;
    private transient javax.swing.JLabel labelProcurar;
    private transient javax.swing.JPanel menuClientes;
    private transient javax.swing.JMenuItem menuItemRelatorio;
    private transient javax.swing.JMenuItem menuItemSair;
    private transient javax.swing.JPanel menuPedidos;
    private transient javax.swing.JMenuBar menuPrincipal;
    private transient javax.swing.JPanel menuProdutos;
    private transient javax.swing.JPanel painelCliente;
    private transient javax.swing.JPanel painelPedido;
    private transient javax.swing.JPanel painelProdutos;
    // End of variables declaration//GEN-END:variables

}
