//Alberto Criado Andrés
package Conversor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaConversor extends JFrame {

	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorDolares;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaConversor(float valorDivisa) {
		setTitle("Conversor de Divisa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Euros = new JLabel("Euros:");
		Euros.setBounds(10, 47, 46, 14);
		contentPane.add(Euros);

		ValorEuros = new JTextField();
		ValorEuros.setBounds(10, 72, 86, 20);
		contentPane.add(ValorEuros);
		ValorEuros.setColumns(10);

		JLabel Dolares = new JLabel("Dolares:");
		Dolares.setBounds(10, 103, 63, 17);
		contentPane.add(Dolares);

		ValorDolares = new JTextField();
		ValorDolares.setBounds(10, 131, 86, 20);
		contentPane.add(ValorDolares);
		ValorDolares.setColumns(10);

		JButton Conversor = new JButton("Convertir");

		Conversor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					float euros;
					// he metido todo en el try catch pero con meter la siguiente linea  seria suficiente ya que es lo que da el error de tipo de dato 
					euros = Float.parseFloat(ValorEuros.getText());
					if (euros >= 0 && euros <= 500) {
						ValorDolares.setText(String
								.valueOf(euros * valorDivisa));
						textField.setText("Todo OK");
					} else {
						textField
								.setText("Los euros tienen que estar entre 0 y 500.");
						ValorDolares.setText("");
					}
				} catch (Exception e) {
					textField
							.setText("Porfavor introduce datos numericos, gracias.");
					ValorDolares.setText("");

				}

			}

		});
		Conversor.setBounds(151, 130, 89, 23);
		contentPane.add(Conversor);

		JLabel lblNewLabel = new JLabel(
				"INTRODUZCA UN VALOR EN EUROS ENTRE 0 Y 500 ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 22, 291, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textField.setForeground(Color.RED);
		textField.setEditable(false);
		textField.setBounds(10, 191, 291, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mensaje de control");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 166, 114, 14);
		contentPane.add(lblNewLabel_1);
	}
}
