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
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaConversor extends JFrame {
	// elementos graficos
	private JPanel contentPane;
	private JTextField ValorEuros;
	private JTextField ValorDolares;
	private JTextField textField;
	// datos generales
	DatosGenerales dg = new DatosGenerales();

	// valor moneda
	private float valorMoneda = 0f;

	public VentanaConversor() {
		// aqui se detallan las distintas caracteristicas de los componentes
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

		ValorDolares = new JTextField();
		ValorDolares.setBounds(10, 131, 86, 20);
		contentPane.add(ValorDolares);
		ValorDolares.setColumns(10);
		// aqui vamos a poner lo que quiera que haga el boton cuando se pulse en
		// este caso el metodo calcular
		JButton Conversor = new JButton("Convertir");

		Conversor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				calcular();

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

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Eliga una moneda");

		comboBox.setBounds(10, 103, 86, 20);
		contentPane.add(comboBox);

		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				textField.setText("SELECCIONADA LA MONEDA: "
						+ comboBox.getSelectedItem());

				switch ((String) comboBox.getSelectedItem())

				{

				case DatosGenerales.MON_DOL:
					valorMoneda = dg.getValor()[0];
					break;
				/*
				 * case DatosGenerales.MON_EUR: valorMoneda = dg.getValor()[1];
				 * // break; la moneda euro la he añadido por que en el video
				 * esta e imagino que sera para los próximos proyectos ya que en
				 * este es inecesaria por que el euro es la divisa origen
				 */
				case DatosGenerales.MON_LIB:
					valorMoneda = dg.getValor()[1];
					break;
				case DatosGenerales.MON_YEN:
					valorMoneda = dg.getValor()[2];
					break;
				default:
					break;
				}
			}
		});
		for (int i = 0; i < dg.getMoneda().length; i++)
			comboBox.addItem((String) dg.getMoneda()[i]);
	}

	// he creado un metodo para el calculo, en un principio habia pensado en
	// crear otros metodos apartes para controlar las excepciones pero lo hge
	// visto innecesario por las pocas que tiene
	private void calcular() {
		try {
			float euros;
			// he metido todo en el try catch pero con meter la siguiente linea
			// seria suficiente ya que es lo que da el error de tipo de dato
			euros = Float.parseFloat(ValorEuros.getText());
			if (euros >= 0 && euros <= 500) {
				ValorDolares.setText(String.valueOf(euros * valorMoneda));
				textField.setText("Todo OK");
			} else {
				textField.setText("Los euros tienen que estar entre 0 y 500.");
				ValorDolares.setText("");
			}
		} catch (Exception e) {
			textField.setText("Porfavor introduce datos numericos, gracias.");
			ValorDolares.setText("");

		}
	}
}