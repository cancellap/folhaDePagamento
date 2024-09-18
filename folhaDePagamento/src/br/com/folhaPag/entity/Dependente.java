package br.com.folhaPag.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.com.folhaPag.enums.Parentesco;
import br.com.folhaPag.exception.DataNascimentoAnteriorException;
import br.com.folhaPag.exception.DependenteException;

public class Dependente extends Pessoa {

	private Parentesco parentesco;
	private final Double valor = 189.59;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {

		return super.toString() + "; Dependente: " + parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Double getValor() {
		return valor;
	}

	public void calculoIdade(LocalDate dataNascimento) throws DependenteException {
		LocalDate dataAtual = LocalDate.now();
		int idade = Period.between(dataNascimento, dataAtual).getYears();
		if (idade >= 18) {
			throw new DependenteException("Exceção: O dependente deve ter menos de 18 anos de idade.");
		}
	}
}