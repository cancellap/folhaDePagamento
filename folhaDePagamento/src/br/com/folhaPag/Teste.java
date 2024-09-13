package br.com.folhaPag;

import java.time.LocalDate;

import br.com.folhaPag.entity.Funcionario;
import br.com.folhaPag.entity.Pessoa;


public class Teste {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario("Matheus", "555.444.333-45", LocalDate.of(2000, 05, 20),7786.02);

		
		System.out.println(funcionario.calculoInss());
		
	} 

}
