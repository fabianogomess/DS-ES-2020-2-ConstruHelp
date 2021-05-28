package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.dao.UsuarioDAO;
import javax.swing.JPasswordField;

public class FormCadastro extends JFrame{

	private JFrame frame;
	private JTextField txtNomeCadst;
	private JTextField txtCPFCadst;
	private JTextField txtEmailCadst;
	private JPasswordField txtSenhaCadst;

	/**
	 * Create the application.
	 */
	public FormCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			int resp = JOptionPane.showConfirmDialog(null, "Deseja sair desta operação?", "Finalizar", JOptionPane.YES_NO_OPTION);
			if(resp == 0) {
				frame.dispose();
			}
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(108, 71, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNomeCadst = new JTextField();
		txtNomeCadst.setBounds(108, 91, 240, 35);
		frame.getContentPane().add(txtNomeCadst);
		txtNomeCadst.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Senha");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(108, 142, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtSenhaCadst = new JPasswordField();
		txtSenhaCadst.setBounds(108, 165, 240, 35);
		frame.getContentPane().add(txtSenhaCadst);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(108, 213, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtCPFCadst = new JTextField();
		txtCPFCadst.setColumns(10);
		txtCPFCadst.setBounds(108, 236, 240, 36);
		frame.getContentPane().add(txtCPFCadst);
		
		JLabel label23 = new JLabel("E-mail");
		label23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label23.setBounds(108, 282, 71, 13);
		frame.getContentPane().add(label23);
		
		txtEmailCadst = new JTextField();
		txtEmailCadst.setColumns(10);
		txtEmailCadst.setBounds(108, 305, 240, 36);
		frame.getContentPane().add(txtEmailCadst);
		
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(108, 358, 119, 36);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnSair);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoaNew = new Pessoa();
				UsuarioDAO usuario = new UsuarioDAO();
				
				try {
				pessoaNew.setNome(txtNomeCadst.getText());
				pessoaNew.setSenha(txtSenhaCadst.getText());
				pessoaNew.setCPF(txtCPFCadst.getText());
				pessoaNew.setEmail(txtEmailCadst.getText());
				usuario.adiciona(pessoaNew);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
				frame.dispose();
			}catch (Exception erroCadastro) {
				JOptionPane.showMessageDialog(null, "Erro no cadastro de usuário, coloque os dados novamente!!");
				frame.dispose();
			}
		}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.setBounds(399, 358, 119, 36);
		frame.getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("Cadastro de novo usu\u00E1rio");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		lblNewLabel.setBounds(108, 10, 518, 51);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		if(b == true) {
			this.frame.setVisible(b);
		}else {
			return;
		}
	}
}
