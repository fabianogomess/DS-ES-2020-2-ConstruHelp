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
import javax.swing.JPopupMenu;
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
import javax.swing.Box;
import java.awt.Canvas;

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
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setFocusTraversalPolicyProvider(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setForeground(new Color(90, 93, 169));
		btnNewButton.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
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
		btnNewButton.setBounds(605, 11, 31, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("logo");
		lblNewLabel_2.setBounds(new Rectangle(10, 0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\logo (2).png"));
		lblNewLabel_2.setBounds(28, 11, 69, 66);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Projetos");
		btnNewButton_3.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_3.setForeground(new Color(90, 93, 169));
		btnNewButton_3.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBounds(403, 10, 61, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Perfil");
		btnNewButton_1.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_1.setForeground(new Color(90, 93, 169));
		btnNewButton_1.setFont(new Font("Alfa Slab One", Font.PLAIN, 14));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfil novatela = new TelaPerfil(cpfUsuario);
				novatela.setVisible();
			}
		});
		btnNewButton_1.setBounds(514, 10, 41, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html>Adicionar<br/>Projeto</html>");
		btnNewButton_2.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\Downloads\\Designer de Software\\Trabalho\\DS-ES-2020-2-ConstruHelp\\Backend\\ConstruHelp\\ConstruHelp\\img\\fluent_document-add-16-regular.png"));
		btnNewButton_2.setFont(new Font("Alfa Slab One", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(90, 93, 169));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(529, 115, 111, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Projetos");
		lblNewLabel.setForeground(new Color(90, 93, 169));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Alfa Slab One", Font.PLAIN, 25));
		lblNewLabel.setBounds(270, 65, 144, 36);
		frame.getContentPane().add(lblNewLabel);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(90, 93, 169));
		canvas.setBounds(29, 107, 625, 2);
		frame.getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(90, 93, 169));
		canvas_1.setBounds(28, 164, 625, 2);
		frame.getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setForeground(new Color(90, 93, 169));
		canvas_2.setBackground(new Color(90, 93, 169));
		canvas_2.setBounds(488, 9, 2, 25);
		frame.getContentPane().add(canvas_2);
		
		Canvas canvas_2_1 = new Canvas();
		canvas_2_1.setForeground(new Color(90, 93, 169));
		canvas_2_1.setBackground(new Color(90, 93, 169));
		canvas_2_1.setBounds(579, 9, 2, 25);
		frame.getContentPane().add(canvas_2_1);
	}
public void setVisible(boolean b) {
	if(b == true) {
		this.frame.setVisible(b);
	}else {
		return;
	}
}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
