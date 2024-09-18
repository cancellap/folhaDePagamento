package br.com.folhaPag;

import java.util.List;

import br.com.folhaPag.arquivo.GravacaoArquivo;
import br.com.folhaPag.arquivo.LeitorDeArquivo;
import br.com.folhaPag.connection.ConnectionFactory;
import br.com.folhaPag.dao.FuncionarioDao;
import br.com.folhaPag.entity.Funcionario;

public class Teste {

    public static void main(String[] args) {
        try {
            LeitorDeArquivo leitor = new LeitorDeArquivo();
            List<Funcionario> funcionarios = leitor.lerFuncionarios("C:/curso/funcionarios.csv");

            for (Funcionario funcionario : funcionarios) {
                funcionario.calculoInss();
                funcionario.calculoIR();
            }

            GravacaoArquivo ga = new GravacaoArquivo();
            ga.escreverArquivo("C:/curso/funcionariossaida.txt", funcionarios);

            ConnectionFactory c = new ConnectionFactory();
            c.getConnection();

            FuncionarioDao funcDao = new FuncionarioDao();
            for (Funcionario funcionario : funcionarios) {
                funcDao.inserir(funcionario);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
