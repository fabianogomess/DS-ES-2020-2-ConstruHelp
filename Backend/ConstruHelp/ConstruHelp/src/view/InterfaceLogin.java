package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.dao.UsuarioDAO;
import br.com.javatpoint.factory.ConnectionFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.ImageIcon;

public class InterfaceLogin{

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceLogin window = new InterfaceLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(204, 226, 104, 30);
		frame.getContentPane().add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLogin.setBounds(204, 266, 247, 30);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(204, 306, 104, 30);
		frame.getContentPane().add(lblSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuario = new UsuarioDAO();
				Pessoa pessoa = new Pessoa();
				pessoa.setCPF(txtLogin.getText());
				pessoa.setSenha(txtSenha.getText());
				boolean autentifica = usuario.Login(pessoa, txtSenha.getText());
				if(autentifica == true) {
				JOptionPane.showInternalMessageDialog(null, "Autenticado com sucesso!!");
				frame.dispose();
				pessoa = usuario.retorno(pessoa, autentifica);
				TelaPrincipal tela = new TelaPrincipal(pessoa);
				tela.setVisible(true);
				}else {
				JOptionPane.showInternalMessageDialog(null, "Dados incorretos!");
				}
		}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(204, 407, 104, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCadastro form = new FormCadastro();
				form.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(347, 407, 104, 30);
		frame.getContentPane().add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(204, 346, 247, 34);
		frame.getContentPane().add(txtSenha);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\raul_\\git\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\download.png"));
		lblNewLabel_1.setBounds(204, 10, 219, 206);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
	
}
