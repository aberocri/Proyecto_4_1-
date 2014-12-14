//Alberto Criado Andrés

package Conversor;

public class Principal {

	public static void main(String[] args) {
		float dolar = 1.25f;
		float libra = 0.79f;
		float yen = 147.8f;
		VentanaConversor frame = new VentanaConversor(dolar,libra, yen);
		frame.setVisible(true);
	}

}
