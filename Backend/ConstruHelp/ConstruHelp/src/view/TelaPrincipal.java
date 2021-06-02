package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.javatpoint.dao.UsuarioDAO;
import br.com.javatpoint.factory.ConnectionFactory;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	private String cpfUsuario;
	private Connection con;
	public TelaPrincipal(String cpf) {
		initialize();
		this.cpfUsuario = cpf;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.con = new ConnectionFactory().getConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 34, 106, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Projetos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 145, 106, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton ExcluirBtn = new JButton("Excluir perfil");
		ExcluirBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir seu cadastro?", "Excluir Cadastro", JOptionPane.YES_NO_OPTION);
				if(resp == 0) {
					UsuarioDAO usuario = new UsuarioDAO();
					usuario.excluir(cpfUsuario);
					frame.dispose();
					InterfaceLogin login = new InterfaceLogin();
					login.setVisible();
				}
			}
		});
		ExcluirBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExcluirBtn.setBounds(27, 265, 162, 21);
		frame.getContentPane().add(ExcluirBtn);
		
		JButton AlterarDadosBtn = new JButton("Alterar dados");
		AlterarDadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarDadosView telaAlt = new AlterarDadosView(cpfUsuario);
				telaAlt.setVisible();
			}
		});
		AlterarDadosBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AlterarDadosBtn.setBounds(27, 322, 162, 21);
		frame.getContentPane().add(AlterarDadosBtn);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					con.close();
					InterfaceLogin login = new InterfaceLogin();
					login.setVisible();
				} catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
			}
		});
		btnNewButton.setBounds(27, 381, 162, 21);
		frame.getContentPane().add(btnNewButton);
	}
public void setVisible(boolean b) {
	if(b == true) {
		this.frame.setVisible(b);
	}else {
		return;
	}
}
}
