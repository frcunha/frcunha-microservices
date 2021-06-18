package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportMathOperationException;

@RestController
@RequestMapping
public class GreetingController {
	
	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
	@GetMapping("/sum/{number1}/{number2}")
	public Double sum(@PathVariable String number1, @PathVariable String number2) throws Exception {
		if (!isNumeric(number1) || !isNumeric(number2)) {
			throw new UnsuportMathOperationException("Informe um número valido");
		}
		
		Double sum = convertToDouble(number1) + convertToDouble(number2); 
		
		return sum;
	}


	private Double convertToDouble(String strToNumber) {
		if (strToNumber == null) {
			return 0D;
		}

		String number = strToNumber.replaceAll(",", ".");
		
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		
		return 1D;
	}


	private boolean isNumeric(String strToNumber) {
		if (strToNumber == null) {
			return false;
		}
		
		String number = strToNumber.replaceAll(",", ".");
		
		
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
