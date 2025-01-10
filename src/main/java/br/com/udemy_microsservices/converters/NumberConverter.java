package br.com.udemy_microsservices.converters;

public class NumberConverter {

	//Faz a conversão para Double
	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D; //Tratando nulidade
		String number = strNumber.replaceAll(",", "."); //Aqui trocamos a "," pelo "." devido a moeda local BR 10.25 US 10.25 
		if(isNumeric(number)) return Double.parseDouble(number);//Se for numérico eu converto para double pois pode vir um inteiro
		return 0D;
	}

	//Verifica se é um valor numerico
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false; //Tratando nulidade
		String number = strNumber.replaceAll(",", "."); //Aqui trocamos a "," pelo "." devido a moeda local BR 10.25 US 10.25
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //Verifica se é numérico, temos forma mais eficiente para fazer isso
	}	

}
