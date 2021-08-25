import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class AtividadeAvaliativa1 extends JFrame implements ActionListener {

	private JLabel lblComidaPreferida;
	private JTextField txtComidaPreferida;
	private JButton btnComida, btnInformarComida, btnAzul, btnClick, btnSair;
	private JPanel painel;
	
	public AtividadeAvaliativa1()
	{
		this.setTitle("Comida Preferida");
		this.setSize(320,180);
		this.setLocation(700,400);
		this.setResizable(false);
		lblComidaPreferida=new JLabel("Comida Preferida:", JLabel.RIGHT);
		txtComidaPreferida=new JTextField(20);
		txtComidaPreferida.setToolTipText("Digite aqui a sua comida preferida");
		btnComida=new JButton("Comida");
		btnComida.setMnemonic('C');
		btnComida.setToolTipText("Clique aqui para mostrar a sua comida preferida na tela");
		btnComida.addActionListener(this);
		btnInformarComida=new JButton("Informar Comida");
		btnInformarComida.setMnemonic('I');
		btnInformarComida.addActionListener(this);
		btnInformarComida.setToolTipText("Clique aqui para informar a sua comida preferida");
		btnAzul=new JButton("Azul");
		btnAzul.setMnemonic('A');
		btnAzul.setToolTipText("Clique aqui para alterar a cor de fundo da tela");
		btnAzul.addActionListener(this);
		btnClick=new JButton("Click");
		btnClick.setMnemonic('M');
		btnClick.setToolTipText("Clique aqui informar que o botão foi clicado");
		btnClick.addActionListener(this);
		btnSair=new JButton("Sair");
		btnSair.setMnemonic('S');
		btnSair.setToolTipText("Clique aqui para sair do programa");
		btnSair.addActionListener(this);
		painel=new JPanel();
		painel.add(lblComidaPreferida);
		painel.add(txtComidaPreferida);
		painel.add(btnComida);
		painel.add(btnInformarComida);
		painel.add(btnAzul);
		painel.add(btnClick);
		painel.add(btnSair);
		add(painel);		
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		Object origem=evento.getSource();
		if (origem == btnComida)
		{
			JOptionPane.showMessageDialog(null, "Comida Preferida: " + txtComidaPreferida.getText(), "Comida Preferida", JOptionPane.INFORMATION_MESSAGE);
		}else if (origem == btnInformarComida)
		{
			String comida=JOptionPane.showInputDialog(null, "Informe a comida preferida:", "Comida Preferida", JOptionPane.QUESTION_MESSAGE);
			txtComidaPreferida.setText(comida);
		}else if (origem == btnAzul)
		{
			painel.setBackground(Color.blue);
		}else if (origem == btnClick)
		{
			JOptionPane.showMessageDialog(null, "O Botão click foi pressionado", "Click", JOptionPane.INFORMATION_MESSAGE);
		}else if (origem == btnSair)
		{
			Object[] opcoes= {"Sim", "Não"};
			int retorno=JOptionPane.showOptionDialog(null,"Tem certeza que deseja sair do programa?", "Sair", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes,opcoes[0]);
			if (retorno ==0)
			{
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		AtividadeAvaliativa1 atividade=new AtividadeAvaliativa1();
		atividade.setVisible(true);
		
	}

}
