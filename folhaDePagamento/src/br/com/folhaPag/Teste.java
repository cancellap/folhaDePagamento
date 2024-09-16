package br.com.folhaPag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.folhaPag.entity.Dependente;
import br.com.folhaPag.entity.Funcionario;
import br.com.folhaPag.enums.Parentesco;

public class Teste {

	public static void main(String[] args) {

		List<Dependente> dependentes = new ArrayList<>();
		List<Funcionario> funcionarios = new ArrayList<>();

		Funcionario funcionario = new Funcionario("Carlos Silva", "111.222.333-44", LocalDate.of(1985, 6, 15), 6500.00, dependentes);
		
		funcionarios.add(funcionario);

		Dependente dependente1 = new Dependente("João", "123.456.789-01", LocalDate.of(2015, 5, 10), Parentesco.FILHO, funcionario);
		Dependente dependente2 = new Dependente("Maria", "987.654.321-09", LocalDate.of(2012, 3, 22), Parentesco.SOBRINHO, funcionario);

		dependentes.add(dependente1);
		dependentes.add(dependente2);

		// System.out.println("Funcionário criado: " + funcionario.getNome());


		System.out.println("Salário Bruto: " + funcionario.getSalarioBruto());
		System.out.println("Desconto INSS: " + funcionario.calculoInss());
		System.out.println("Desconto IR: " + funcionario.calculoIR());

		System.out.println("Dependentes do funcionário: " + funcionario.getDependente());
		

		funcionario.somaDependente();
	}

}
