package com.uniftec.matheus.atividade3;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraLookAndFeel extends JFrame implements ActionListener {

    private JLabel lblValor1, lblValor2, lblResultado;
    private JTextField txtValor1, txtValor2;
    private JButton btnCalcular, btnLimpar, btnFechar, btnMetal, btnMotif, btnWindows;
    private GridBagConstraints restricoes = new GridBagConstraints();
    private JPanel pnlDados, pnlBotoes, pnlResultado, pnlTela;


    public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl) {

        restricoes.gridx = x;
        restricoes.gridy = y;
        pnl.add(obj, restricoes);

    }

    public CalculadoraLookAndFeel() {

        this.setTitle("Calculadora Divisão com Look and Feel");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setLocation(d.width / 4, d.height / 4);
        this.setSize(500, 300);
        this.setResizable(false);
        Font f = new Font("Calibri", Font.PLAIN, 20);

        lblValor1 = new JLabel("Valor 1: ");
        lblValor1.setFont(f);
        txtValor1 = new JTextField(20);
        txtValor1.setFont(f);
        txtValor1.setToolTipText("Digite o primeiro valor: ");

        lblValor2 = new JLabel("Valor 2: ");
        lblValor2.setFont(f);
        txtValor2 = new JTextField(20);
        txtValor2.setFont(f);
        txtValor2.setToolTipText("Digite o segundo valor: ");

        btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(f);
        btnCalcular.setToolTipText("Clique aqui para realizar o cálculo");
        btnCalcular.setMnemonic('C');
        btnCalcular.addActionListener(this);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(f);
        btnLimpar.setToolTipText("Clique aqui para limpar os dados");
        btnLimpar.setMnemonic('L');
        btnLimpar.addActionListener(this);

        btnFechar = new JButton("Fechar");
        btnFechar.setFont(f);
        btnFechar.setToolTipText("Clique aqui para fechar o software");
        btnFechar.setMnemonic('F');
        btnFechar.addActionListener(this);

        btnMetal = new JButton("Metal");
        btnMetal.setFont(f);
        btnMetal.setToolTipText("Clique aqui para alterar o look and feel para Metal");
        btnMetal.setMnemonic('M');
        btnMetal.addActionListener(this);

        btnMotif = new JButton("Motif");
        btnMotif.setFont(f);
        btnMotif.setToolTipText("Clique aqui para alterar o look and feel para Motif");
        btnMotif.setMnemonic('O');
        btnMotif.addActionListener(this);

        btnWindows = new JButton("Windows");
        btnWindows.setFont(f);
        btnWindows.setToolTipText("Clique aqui para alterar o look and feel para Windows");
        btnWindows.setMnemonic('W');
        btnWindows.addActionListener(this);

        lblResultado = new JLabel("Resultado:", JLabel.RIGHT);
        lblResultado.setFont(f);

        restricoes.fill = GridBagConstraints.BOTH;
        restricoes.insets = new Insets(8, 8, 8, 8);

        pnlDados = new JPanel(new GridBagLayout());
        addGridBag(0, 0, lblValor1, pnlDados);
        addGridBag(1, 0, txtValor1, pnlDados);
        addGridBag(0, 1, lblValor2, pnlDados);
        addGridBag(1, 1, txtValor2, pnlDados);

        pnlBotoes = new JPanel(new GridBagLayout());
        addGridBag(0, 0, btnCalcular, pnlBotoes);
        addGridBag(1, 0, btnLimpar, pnlBotoes);
        addGridBag(2, 0, btnFechar, pnlBotoes);
        addGridBag(0, 1, btnMetal, pnlBotoes);
        addGridBag(1, 1, btnMotif, pnlBotoes);
        addGridBag(2, 1, btnWindows, pnlBotoes);

        pnlResultado = new JPanel(new GridBagLayout());
        addGridBag(0, 0, lblResultado, pnlResultado);

        pnlTela = new JPanel(new GridBagLayout());
        addGridBag(0, 0, pnlDados, pnlTela);
        addGridBag(0, 1, pnlBotoes, pnlTela);
        addGridBag(0, 2, pnlResultado, pnlTela);

        Container P = getContentPane();
        P.add(pnlTela);

    }


    public void actionPerformed(ActionEvent event) {

        Object origem = event.getSource();
        if (origem == btnCalcular) {

            float valor1, valor2, resultado;

            try {

                valor1 = Float.parseFloat(txtValor1.getText().toString());

                try {

                    valor2 = Float.parseFloat(txtValor2.getText().toString());

                    if (valor2 == 0) {

                        JOptionPane.showMessageDialog(null, "Não existe divisão por 0!", "ERRO", JOptionPane.ERROR_MESSAGE);

                        txtValor2.requestFocus();
                        txtValor2.selectAll();

                    } else {

                        resultado = valor1 % valor2;
                        lblResultado.setText("Resultado: O resto valor 1/valor 2 é " + resultado);
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Valor 2 inválido!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    txtValor2.requestFocus();
                    txtValor2.selectAll();

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Valor 1 inválido!", "ERRO", JOptionPane.ERROR_MESSAGE);
                txtValor1.requestFocus();
                txtValor1.selectAll();

            }

        } else if (origem == btnLimpar) {

            txtValor1.setText("");
            txtValor2.setText("");
            lblResultado.setText("Resultado:");
            txtValor1.requestFocus();

        } else if (origem == btnFechar) {

            System.exit(0);

        } else if (origem == btnMetal) {

            try {

                MetalLookAndFeel metal = new MetalLookAndFeel();
                OceanTheme ocean = new OceanTheme();
                UIManager.setLookAndFeel(metal);
                SwingUtilities.updateComponentTreeUI(this);
                this.pack();


            } catch (Exception e) {
            }

        } else if (origem == btnMotif) {
            try {

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
                this.pack();


            } catch (Exception e) {
            }

        } else if (origem == btnWindows) {

            try {

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
                this.pack();


            } catch (Exception e) {
            }

        }


    }


}
