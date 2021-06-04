package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.javatpoint.classes.Endereco;
import br.com.javatpoint.classes.Fornecedor;
import br.com.javatpoint.classes.Gestor;
import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.classes.Projeto;
import br.com.javatpoint.dao.FornecedorDAO;
import br.com.javatpoint.dao.GestorDAO;
import br.com.javatpoint.dao.ProjetoDAO;
import br.com.javatpoint.factory.ConnectionFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ProjetosPagina {

	private JFrame frame;
	private JTextField NomeProjTxt;
	private JTextField descProjTxt;
	private JTextField txtStatus;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtComp;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private Connection con;
	private Pessoa pessoa;
	/**
	 * Launch the application.
	

	/**
	 * Create the application.
	 */
	public ProjetosPagina(Pessoa pessoa) {
		initialize();
		this.pessoa = pessoa;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.con = new ConnectionFactory().getConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de projeto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(30, 24, 263, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do projeto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 105, 143, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		NomeProjTxt = new JTextField();
		NomeProjTxt.setBounds(30, 141, 160, 19);
		frame.getContentPane().add(NomeProjTxt);
		NomeProjTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o do projeto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 170, 160, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		descProjTxt = new JTextField();
		descProjTxt.setBounds(30, 199, 160, 19);
		frame.getContentPane().add(descProjTxt);
		descProjTxt.setColumns(10);
		
		JLabel aed = new JLabel("Status do projeto");
		aed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aed.setBounds(30, 242, 143, 13);
		frame.getContentPane().add(aed);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(30, 265, 160, 19);
		frame.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Rua");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(286, 114, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bairro");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(286, 175, 45, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Complemento");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(286, 244, 117, 13);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Cidade");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(286, 315, 82, 13);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Estado");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(286, 386, 45, 13);
		frame.getContentPane().add(lblNewLabel_3_4);
		
		txtRua = new JTextField();
		txtRua.setBounds(286, 141, 96, 19);
		frame.getContentPane().add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(286, 199, 96, 19);
		frame.getContentPane().add(txtBairro);
		
		txtComp = new JTextField();
		txtComp.setColumns(10);
		txtComp.setBounds(286, 265, 96, 19);
		frame.getContentPane().add(txtComp);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(286, 333, 96, 19);
		frame.getContentPane().add(txtCidade);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(286, 409, 96, 19);
		frame.getContentPane().add(txtEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//instância de classes
				Projeto projeto = new Projeto();
				Endereco endereco = new Endereco();
				Gestor gestor = new Gestor();
				Fornecedor fornecedor = new Fornecedor();
				FornecedorDAO forn = new FornecedorDAO();
				ProjetoDAO projetoD = new ProjetoDAO();
				GestorDAO gestorDAO = new GestorDAO();
				
				//gestor cadastro
				gestor.setCPF(pessoa.getCPF());
				
				//projeto cadastro
				projeto.setNomeProjeto(NomeProjTxt.getText());
				projeto.setDescricao(descProjTxt.getText());
				projeto.setStatus(txtStatus.getText());
				
				//endereco cadastro
				endereco.setRua(txtRua.getText());
				endereco.setBairro(txtBairro.getText());
				endereco.setComplemento(txtComp.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado(txtEstado.getText());
				
				//DAO banco de dados
				gestorDAO.adiciona(gestor);
				projetoD.adicionaProjeto(projeto, endereco);
				gestorDAO.adicionarProj(projeto, gestor);
				projetoD.adicionaGestorProj(projeto, gestor);
				JOptionPane.showMessageDialog(null, "Projeto criado com sucesso!");
				frame.dispose();
				}catch(Exception err) {
					JOptionPane.showMessageDialog(null, err);
					frame.dispose();
				}
			}
		});
		btnSalvar.setBounds(444, 408, 85, 21);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSair.setBounds(44, 408, 85, 21);
		frame.getContentPane().add(btnSair);
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
