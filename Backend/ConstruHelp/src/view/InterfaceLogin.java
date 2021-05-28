package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

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
				try {
				String sql = "SELECT nome, senha FROM pessoa WHERE nome = ? and senha = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, txtLogin.getText());
				stmt.setString(2, txtSenha.getText());
				ResultSet rs = stmt.executeQuery();
				boolean autentifica = false;
				
				while(rs.next() && !autentifica) {
					if(rs.getString("nome").equals(txtLogin.getText())) {
						if(rs.getString("senha").equals(txtSenha.getText())) {
							autentifica = true;
						}	
					}
				}
				
				if(autentifica == true) {
					JOptionPane.showInternalMessageDialog(null, "Autenticado com sucesso!!");
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
					frame.dispose();
				}else {
					JOptionPane.showInternalMessageDialog(null, "Dados incorretos!");
				}
				
				}catch (Exception erroLogin) {
					JOptionPane.showInternalMessageDialog(null, "Problemas na execução do Login!");
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\raul_\\eclipse-workspace\\ConstruHelp\\img\\download.png"));
		lblNewLabel_1.setBounds(204, 10, 219, 206);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
