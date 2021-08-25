package com.uniftec.matheus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreçoGasolina  extends JFrame implements ActionListener {

    private JLabel lblPreço, lblLitros, lblResultado;
    private JTextField txtPreço, txtLitros;
    private JButton btnResultado, btnLimpar, btnFechar;
    private GridBagConstraints restricoes = new GridBagConstraints();
    private JPanel pnlDados, pnlBotoes, pnlResultado, pnlPreçoGasolina;


    public PreçoGasolina(){

        this.setTitle("Cálculo Gasto com Gasolina");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setLocation(d.width/4, d.height/4);
        this.setSize(700,300);
        setResizable(false);
        Font f = new Font("Calibri", Font.PLAIN, 20);

        lblPreço = new JLabel("Preço do litro da Gasolina: R$");
        lblPreço.setFont(f);
        txtPreço = new JTextField(20);
        txtPreço.setFont(f);
        txtPreço.setToolTipText("Digite aqui o preço do litro da gasolina em reais");

        lblLitros = new JLabel("Quantidade de litros de gasolina: ");
        lblLitros.setFont(f);
        txtLitros = new JTextField(20);
        txtLitros.setFont(f);
        txtLitros.setToolTipText("Digite aqui a quantidade de litros de gasolina");

        btnResultado = new JButton("Resultado");
        btnResultado.setFont(f);
        btnResultado.setToolTipText("Clique aqui para calcular o valor gasto com gasolina");
        btnResultado.setMnemonic('R');
        btnResultado.addActionListener(this);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(f);
        btnLimpar.setToolTipText("Clique aqui para limpar os dados");
        btnLimpar.setMnemonic('L');
        btnLimpar.addActionListener(this);

        btnFechar = new JButton("Fechar");
        btnFechar.setFont(f);
        btnFechar.setToolTipText("Clique aqui para fechar o programa");
        btnFechar.setMnemonic('F');
        btnFechar.addActionListener(this);

        lblResultado = new JLabel("Resultado: R$");
        lblResultado.setFont(f);

        restricoes.fill = GridBagConstraints.BOTH;
        restricoes.insets = new Insets(8,8,8,8);

        pnlDados = new JPanel(new GridBagLayout());
        addGridBag(0,0,lblPreço,pnlDados);
        addGridBag(1,0,txtPreço,pnlDados);
        addGridBag(0,1,lblLitros,pnlDados);
        addGridBag(1,1,txtLitros,pnlDados);

        pnlBotoes = new JPanel(new GridBagLayout());
        addGridBag(0,0,btnResultado,pnlBotoes);
        addGridBag(1,0,btnLimpar,pnlBotoes);
        addGridBag(2,0,btnFechar,pnlBotoes);

        pnlResultado = new JPanel(new GridBagLayout());
        addGridBag(0,0,lblResultado,pnlResultado);

        pnlPreçoGasolina = new JPanel(new GridBagLayout());
        addGridBag(0,0,pnlDados,pnlPreçoGasolina);
        addGridBag(0,1,pnlBotoes,pnlPreçoGasolina);
        addGridBag(0,2,pnlResultado,pnlPreçoGasolina);

        Container P = getContentPane();
        P.add(pnlPreçoGasolina);

    }

    public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl){

        restricoes.gridx=x;
        restricoes.gridy=y;
        pnl.add(obj, restricoes);

    }


    public void actionPerformed(ActionEvent evento){

        Object origem = evento.getSource();

        if (origem == btnResultado){
            float preço, litros, resultado;
            try {
                preço = Float.parseFloat(txtPreço.getText());
                try {
                    litros = Float.parseFloat(txtLitros.getText());
                    resultado = preço * litros;
                    lblResultado.setText("Resultado: R$"+resultado);
                }catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Quantidade de litros de gasolina informada é inválida","ERRO",JOptionPane.ERROR_MESSAGE);
                    txtPreço.requestFocus();
                    txtPreço.selectAll();
                }
            }catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Preço da gasolina informado é inválido","ERRO",JOptionPane.ERROR_MESSAGE);
                txtPreço.requestFocus();
                txtPreço.selectAll();
            }
        }else if (origem == btnLimpar){
            txtPreço.setText("");
            txtLitros.setText("");
            lblResultado.setText("Resultado: R$");
            txtPreço.requestFocus();
        }else if (origem == btnFechar){
            System.exit(0);
        }

    }

}
