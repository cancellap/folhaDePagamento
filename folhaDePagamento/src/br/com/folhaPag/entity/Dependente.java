package br.com.folhaPag.entity;

import java.time.LocalDate;

import br.com.folhaPag.enums.Parentesco;

public class Dependente extends Pessoa {

	private Parentesco parentesco;
	private final Double valor = 189.59;
	

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {

		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	@Override
	public String toString() {
		return "Dependente [parentesco=" + parentesco + "]";
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

}
