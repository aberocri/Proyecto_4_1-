package Conversor;


public class DatosGenerales {
	//lista monedas y valores
final  static String MON_DOL  = "Dolar";
final static float VAL_DOL  = 1.13f;
/*final  static String MON_EUR  = "Euro";
final static float VAL_EUR  = 1f;*/
final  static String MON_LIB  = "Libra";
final static float VAL_LIB  = 0.75f;
final  static String MON_YEN  = "Yen";
final static float VAL_YEN  = 132.47f;
private String textoMoneda[] = {MON_DOL, /*MON_EUR,*/ MON_LIB, MON_YEN};
private float  valorConversion[] = {VAL_DOL, /*VAL_EUR,*/ VAL_LIB, VAL_YEN};
public DatosGenerales(){
	
}

public String[] getMoneda(){
	return textoMoneda;
}
public float[] getValor(){
	return valorConversion;
}

}
