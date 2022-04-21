package modelo;

import java.util.LinkedList;

public class Aluno extends Pessoa  {

    //atributos

    private LinkedList<Aula> aulas;


    //construtores
    public Aluno(String nome, long numero) {

        super(nome,numero);
    }

    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }

        //assinar o sumario
        aula.adicionarLinhaSumario(nome);
    }

    @Override
    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    public void remover(Aula aula) {
        super.remover(aula);
        aula.remover(this);
    }
}


