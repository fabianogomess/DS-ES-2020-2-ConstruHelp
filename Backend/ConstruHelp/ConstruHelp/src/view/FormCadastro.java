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
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.Insets;

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
		frame.getContentPane().setBackground(Color.WHITE);
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
		lblNewLabel_1.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(186, 109, 71, 13);
		lblNewLabel_1.setForeground(new Color(90, 93, 169));
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNomeCadst = new JTextField();
		txtNomeCadst.setBounds(186, 123, 280, 35);
		frame.getContentPane().add(txtNomeCadst);
		txtNomeCadst.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Senha");
		lblNewLabel_1_2.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(186, 169, 71, 13);
		lblNewLabel_1_2.setForeground(new Color(90, 93, 169));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtSenhaCadst = new JPasswordField();
		txtSenhaCadst.setBounds(186, 184, 280, 35);
		frame.getContentPane().add(txtSenhaCadst);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(186, 230, 45, 13);
		lblNewLabel_1_1.setForeground(new Color(90, 93, 169));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtCPFCadst = new JTextField();
		txtCPFCadst.setColumns(10);
		txtCPFCadst.setBounds(186, 244, 280, 36);
		frame.getContentPane().add(txtCPFCadst);
		
		JLabel label23 = new JLabel("E-mail");
		label23.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		label23.setBounds(186, 291, 71, 13);
		label23.setForeground(new Color(90, 93, 169));
		frame.getContentPane().add(label23);
		
		txtEmailCadst = new JTextField();
		txtEmailCadst.setColumns(10);
		txtEmailCadst.setBounds(186, 305, 280, 36);
		frame.getContentPane().add(txtEmailCadst);
		
		
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setMargin(new Insets(2, 2, 2, 2));
		btnSair.setBackground(Color.WHITE);
		btnSair.setForeground(new Color(90, 93, 169));
		btnSair.setBounds(367, 371, 95, 36);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		btnSair.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		frame.getContentPane().add(btnSair);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.setMargin(new Insets(2, 2, 2, 2));
		btnSalvar.setBackground(new Color(90, 93, 169));
		btnSalvar.setForeground(Color.WHITE);
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
		btnSalvar.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnSalvar.setBounds(186, 371, 95, 35);
		frame.getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usu\u00E1rio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(90, 93, 169));
		lblNewLabel.setFont(new Font("Alfa Slab One", Font.PLAIN, 25));
		lblNewLabel.setBounds(165, 39, 322, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\logo (2).png"));
		lblNewLabel_2.setBounds(10, 7, 71, 66);
		frame.getContentPane().add(lblNewLabel_2);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(90, 93, 169));
		canvas.setBounds(26, 88, 600, 2);
		frame.getContentPane().add(canvas);
		
		
		
			
		
	}

	public void setVisible(boolean b) {
		if(b == true) {
			this.frame.setVisible(b);
		}else {
			return;
		}
	}
}
