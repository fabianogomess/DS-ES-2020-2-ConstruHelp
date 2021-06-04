package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

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
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Insets;

public class InterfaceLogin{

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private Connection con;

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
		this.con = new ConnectionFactory().getConnection();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 673, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setForeground(new Color(90, 93, 169));
		lblNewLabel.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		lblNewLabel.setBounds(181, 264, 104, 30);
		frame.getContentPane().add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLogin.setBounds(181, 290, 294, 30);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(90, 93, 169));
		lblSenha.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		lblSenha.setBounds(181, 322, 104, 30);
		frame.getContentPane().add(lblSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(90, 93, 169));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuario = new UsuarioDAO();
				boolean autentifica = usuario.Login(txtLogin.getText(), txtSenha.getText());
				if(autentifica == true) {
				JOptionPane.showInternalMessageDialog(null, "Autenticado com sucesso!!");
				frame.dispose();
				String cpfUsuario = usuario.cpfRetornado(txtLogin.getText(), txtSenha.getText());
				TelaPrincipal tela = new TelaPrincipal(cpfUsuario);
				tela.setVisible(true);
				}else {
				JOptionPane.showInternalMessageDialog(null, "Dados incorretos!");
				}
		}
		});
		btnNewButton.setFont(new Font("Alfa Slab One", Font.PLAIN, 15));
		btnNewButton.setBounds(181, 423, 95, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setMargin(new Insets(2, 2, 2, 2));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setForeground(new Color(90, 93, 169));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormCadastro form = new FormCadastro();
				form.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Alfa Slab One", Font.PLAIN, 15));
		btnCadastrar.setBounds(380, 423, 95, 36);
		frame.getContentPane().add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(181, 347, 294, 34);
		frame.getContentPane().add(txtSenha);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\logo.png"));
		lblNewLabel_1.setBounds(204, -13, 247, 245);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
}
