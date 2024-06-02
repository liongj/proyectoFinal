package com.umg.conector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Producto {

	private static final JTextComponent direccion_de_pedido = null;
	protected static final String textdireccion_de_pedid = null;
	private JFrame frmEnvios;
	private JTextField txtIngresaDato;
	private JTextField textcliente;
	private JTextField textdireccion_de_pedido;
	private JTextField textestado_de_pedido;
    Negocio uri =new Negocio();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto window = new Producto();
					window.frmEnvios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Producto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnvios = new JFrame();
		frmEnvios.setTitle("Envios");
		frmEnvios.setBounds(100, 100, 450, 300);
		frmEnvios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnvios.getContentPane().setLayout(null);
		
		txtIngresaDato = new JTextField();
		txtIngresaDato.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtIngresaDato.setText("ingresa dato");
		txtIngresaDato.setBounds(117, 36, 111, 20);
		frmEnvios.getContentPane().add(txtIngresaDato);
		txtIngresaDato.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" cliente:");
		lblNewLabel.setBounds(26, 79, 63, 14);
		frmEnvios.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("direccion_de_pedido");
		lblNewLabel_1.setBounds(26, 107, 120, 14);
		frmEnvios.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado_de_pedodo");
		lblNewLabel_2.setBounds(26, 135, 101, 14);
		frmEnvios.getContentPane().add(lblNewLabel_2);
		
		textcliente = new JTextField();
		textcliente.setBounds(142, 70, 157, 20);
		frmEnvios.getContentPane().add(textcliente);
		textcliente.setColumns(10);
		
		textdireccion_de_pedido = new JTextField();
		textdireccion_de_pedido.setBounds(142, 104, 157, 20);
		frmEnvios.getContentPane().add(textdireccion_de_pedido);
		textdireccion_de_pedido.setColumns(10);
		
		textestado_de_pedido = new JTextField();
		textestado_de_pedido.setBounds(142, 132, 157, 20);
		frmEnvios.getContentPane().add(textestado_de_pedido);
		textestado_de_pedido.setColumns(10);
		
		JButton btnNewButton = new JButton("agregara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					uri.setCliente(textcliente.getText());
					uri.setDireccion_de_pedido(textdireccion_de_pedido.getText());
					uri.setEstado_de_pedido(textestado_de_pedido.getText());
					
					if(uri.Agregara()) {
						JOptionPane.showConfirmDialog(null," se agrego");
					}else {
						JOptionPane.showConfirmDialog(null,"no se agrego");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
			
			
			
		});
		btnNewButton.setBounds(26, 213, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     try {
					
					int id =Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID del dato que desea iliminar:"));
					
					uri.setIdproducto(id);
					
					if(uri.Eliminar()) {
						JOptionPane.showConfirmDialog(null," se elimino");
					}else {
						JOptionPane.showConfirmDialog(null,"no se elimino");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
				
				
			}
		);
		btnNewButton_1.setBounds(139, 213, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                  try {
					
					int id =Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID que desea editar:"));
					
					uri.setIdproducto(id);
					uri.setCliente(textcliente.getText());
					uri.setDireccion_de_pedido(textdireccion_de_pedido.getText());
					uri.setEstado_de_pedido(textestado_de_pedido.getText());
					
					if(uri.Editar()) {
						JOptionPane.showConfirmDialog(null," se edito");
					}else {
						JOptionPane.showConfirmDialog(null,"no se edito");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
				
				
			}
            
		
	);
		btnNewButton_2.setBounds(242, 213, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscara");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					int id =Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID del dato que desea iliminar:"));
					
					uri.setIdproducto(id);
					
					if(uri.Buscara()) {
						textcliente.setText(uri.getCliente());
						textdireccion_de_pedido.setText(""+uri.getDireccion_de_pedido());
						textestado_de_pedido.setText(uri.getEstado_de_pedido());
						
						JOptionPane.showConfirmDialog(null," encontro");
					}else {
						JOptionPane.showConfirmDialog(null,"no se encontro");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
				
				
				
			}
		);
		btnNewButton_3.setBounds(335, 213, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Limpiar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				limpiar();
				
				
				
			}
		});
		btnNewButton_4.setBounds(335, 103, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("salir");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
				
			}
		});
		btnNewButton_5.setBounds(335, 131, 89, 23);
		frmEnvios.getContentPane().add(btnNewButton_5);
	}
	
	public void limpiar() {
		  textcliente.setText(null);
	      textdireccion_de_pedido.setText(null);
	      textestado_de_pedido.setText(null);
	}
}
