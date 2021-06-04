package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.dao.UsuarioDAO;
import br.com.javatpoint.factory.ConnectionFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AlterarDadosView {

	private JFrame frame;
	private JPasswordField senhaAlt;
	private JTextField EmailAlt;
	private JTextField NomeAlt;
	private String cpf;
	private Connection con;
	private Pessoa pessoa;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AlterarDadosView(Pessoa pessoa) {
		initialize(pessoa);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Pessoa pessoa) {
		this.con = new ConnectionFactory().getConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(33, 33, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(33, 106, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(33, 171, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		NomeAlt = new JTextField();
		NomeAlt.setBounds(33, 56, 96, 19);
		frame.getContentPane().add(NomeAlt);
		NomeAlt.setColumns(10);
		
		EmailAlt = new JTextField();
		EmailAlt.setBounds(33, 118, 96, 19);
		frame.getContentPane().add(EmailAlt);
		EmailAlt.setColumns(10);
		
		senhaAlt = new JPasswordField();
		senhaAlt.setBounds(33, 194, 96, 19);
		frame.getContentPane().add(senhaAlt);
		
		JButton btnSalvarSenha = new JButton("Salvar senha");
		btnSalvarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuario = new UsuarioDAO();
				try {
					if(estaVazio(senhaAlt)) {
						usuario.AlterarDadosSenha(pessoa, senhaAlt.getText());
					}
					JOptionPane.showMessageDialog(null, "Dados alterados!");
					frame.dispose();
				}catch(Exception errorAlt) {
					JOptionPane.showMessageDialog(null, "Erro durante alteração de dados!");
				}
			}
		});
		btnSalvarSenha.setBounds(44, 223, 85, 21);
		frame.getContentPane().add(btnSalvarSenha);
		
		JButton btnSalvarEmail = new JButton("Salvar email");
		btnSalvarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuario = new UsuarioDAO();
				try {
					if(estaVazio(EmailAlt)) {
						usuario.AlterarDadosEmail(pessoa, EmailAlt.getText());
					}
					JOptionPane.showMessageDialog(null, "Dados alterados!");
				frame.dispose();
			}catch(Exception errorAlt) {
				JOptionPane.showMessageDialog(null, "Erro durante alteração de dados!");
			}
			}
		});
		btnSalvarEmail.setBounds(43, 140, 85, 21);
		frame.getContentPane().add(btnSalvarEmail);
		
		JButton btnSalvarNome = new JButton("Salvar nome");
		btnSalvarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usuario = new UsuarioDAO();
				try {
					if(estaVazio(NomeAlt)) {
						usuario.AlterarDadosNome(pessoa, NomeAlt.getText());
					}
					JOptionPane.showMessageDialog(null, "Dados alterados!");
					frame.dispose();
				}catch(Exception errorAlt) {
					JOptionPane.showMessageDialog(null, "Erro durante alteração de dados!");
				}	
			}
		});
		btnSalvarNome.setBounds(43, 76, 85, 21);
		frame.getContentPane().add(btnSalvarNome);
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
	
	public boolean estaVazio(JTextField campo) {
		return campo.getText()!=null && !campo.getText().trim().isEmpty();		
	}
}
