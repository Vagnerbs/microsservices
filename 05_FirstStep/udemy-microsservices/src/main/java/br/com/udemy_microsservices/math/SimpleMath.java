package br.com.udemy_microsservices.math;

public class SimpleMath {

	// Soma
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	// Subtração
	public Double sub(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}

	// Multiplicação
	public Double mul(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}

	// Divisão
	public Double div(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}

	// Média
	public Double med(Double numberOne, Double numberTwo) {
		return (numberOne / numberTwo) / 2;
	}

	// Raiz
	public Double rai(Double number) {
		return Math.sqrt(number);
	}
}
