package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.dao.UsuarioDAO;
import br.com.javatpoint.factory.ConnectionFactory;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Canvas;
import javax.swing.border.BevelBorder;

public class TelaPerfil {

	
	private JFrame frame;
	private JPasswordField senhaPerfil;
	private JTextField EmailPerfil;
	private JTextField NomePerfil;
	private String cpfPerfil;
	private Connection con;
	
	
	public TelaPerfil(String cpfUsuario) {
		initialize();
		this.cpfPerfil = cpfUsuario;
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.con = new ConnectionFactory().getConnection();
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setFocusTraversalPolicyProvider(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ExcluirBtn = new JButton("<html>Excluir<br/>Perfil</html>");
		ExcluirBtn.setBackground(Color.WHITE);
		ExcluirBtn.setMargin(new Insets(2, 2, 2, 5));
		ExcluirBtn.setForeground(new Color(90, 93, 169));
		ExcluirBtn.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\ant-design_delete-outlined.png"));
		ExcluirBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir seu cadastro?", "Excluir Cadastro", JOptionPane.YES_NO_OPTION);
				if(resp == 0) {
					UsuarioDAO usuario = new UsuarioDAO();
					usuario.excluir(cpfPerfil);
					frame.dispose();
					InterfaceLogin login = new InterfaceLogin();
					login.setVisible();
				}
			}
		});
		ExcluirBtn.setFont(new Font("Alfa Slab One", Font.PLAIN, 12));
		ExcluirBtn.setBounds(525, 112, 100, 43);
		frame.getContentPane().add(ExcluirBtn);
		
		JButton AlterarDadosBtn = new JButton("<html>Alterar<br/>Dados</html>");
		AlterarDadosBtn.setMargin(new Insets(2, 1, 2, 1));
		AlterarDadosBtn.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\akar-icons_edit (2).png"));
		AlterarDadosBtn.setBackground(new Color(90, 93, 169));
		AlterarDadosBtn.setForeground(Color.WHITE);
		AlterarDadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarDadosView telaAlt = new AlterarDadosView(cpfPerfil);
				telaAlt.setVisible();
				
			}
		});
		AlterarDadosBtn.setFont(new Font("Alfa Slab One", Font.PLAIN, 12));
		AlterarDadosBtn.setBounds(403, 112, 100, 43);
		frame.getContentPane().add(AlterarDadosBtn);
		
		JLabel lblNewLabel_2 = new JLabel("logo");
		lblNewLabel_2.setBounds(new Rectangle(10, 0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\logo (2).png"));
		lblNewLabel_2.setBounds(28, 11, 69, 66);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Perfil");
		lblNewLabel.setForeground(new Color(90, 93, 169));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Alfa Slab One", Font.PLAIN, 25));
		lblNewLabel.setBounds(270, 66, 144, 35);
		frame.getContentPane().add(lblNewLabel);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(90, 93, 169));
		canvas.setBounds(28, 104, 625, 2);
		frame.getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(90, 93, 169));
		canvas_1.setBounds(28, 161, 625, 2);
		frame.getContentPane().add(canvas_1);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setOpaque(false);
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setForeground(new Color(90, 93, 169));
		btnNewButton.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
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
		btnNewButton.setBounds(622, 13, 31, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Projetos");
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_3.setForeground(new Color(90, 93, 169));
		btnNewButton_3.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(420, 12, 61, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Perfil");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_1.setForeground(new Color(90, 93, 169));
		btnNewButton_1.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(531, 12, 41, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setForeground(new Color(90, 93, 169));
		canvas_2.setBackground(new Color(90, 93, 169));
		canvas_2.setBounds(505, 11, 2, 25);
		frame.getContentPane().add(canvas_2);
		 
		Canvas canvas_2_1 = new Canvas();
		canvas_2_1.setForeground(new Color(90, 93, 169));
		canvas_2_1.setBackground(new Color(90, 93, 169));
		canvas_2_1.setBounds(596, 11, 2, 25);
		frame.getContentPane().add(canvas_2_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		editorPane.setBounds(119, 269, 107, 20);
		frame.getContentPane().add(editorPane);
		
	}

	public boolean estaVazio(JTextField campo) {
		return campo.getText()!=null && !campo.getText().trim().isEmpty();		
	}
}
