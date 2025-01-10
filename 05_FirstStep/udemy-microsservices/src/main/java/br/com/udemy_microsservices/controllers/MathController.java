package br.com.udemy_microsservices.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy_microsservices.converters.NumberConverter;
import br.com.udemy_microsservices.exceptions.UnsupportedMathOperationException;
import br.com.udemy_microsservices.math.SimpleMath;

@RestController
public class MathController {
	
	//Essa variavél com esse tipo vai mokar um ID
	private static final AtomicLong counter = new AtomicLong();
	
	//Instânciando a classe SimpleMath aonde temos nossos calculos
	//Obs.: Precisa ser intanciado para termos acesso por "não ser um método static"
	private SimpleMath math = new SimpleMath();
	
	//@RequestMapping: Mapeia requisições HTTP para métodos específicos do controlador. 
	//Pode lidar com todos os tipos de métodos HTTP (GET, POST, PUT, DELETE, etc.).
	
	//Soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			
	//@PathVariable: É utilizada para extrair valores de variáveis diretamente da URL
	@PathVariable(value = "numberOne")String numberOne,
	@PathVariable(value = "numberTwo")String numberTwo

	//Tratamento para ver se o caractere é numerico
	) throws Exception {	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		//Passa os parametros para o metodo
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Subtração
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			
		@PathVariable(value = "numberOne")String numberOne,
		@PathVariable(value = "numberTwo")String numberTwo
		
	) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Multiplicação
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mul(
			
		@PathVariable(value = "numberOne")String numberOne,
		@PathVariable(value = "numberTwo")String numberTwo
		
	) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		return math.mul(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Divisão
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
			
		@PathVariable(value = "numberOne")String numberOne,
		@PathVariable(value = "numberTwo")String numberTwo
		
	) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Média
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(
			
	@PathVariable(value = "numberOne")String numberOne,
	@PathVariable(value = "numberTwo")String numberTwo
	
	) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Raiz
	@RequestMapping(value = "/rai/{number}", method=RequestMethod.GET)
	public Double rai(
			
		@PathVariable(value = "number")String number

	) throws Exception {
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");	
		}
		return math.rai(NumberConverter.convertToDouble(number));
	}
}
