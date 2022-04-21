package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {

    protected LinkedList<Aula> aulas;


    public Pessoa(String nome, long numero) {
        super(nome, numero);
        this.aulas = aulas;
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public void adicionar(Aula aula) {
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }

        //adicionar aula à lista
        this.aulas.add(aula);
        associar(aula);
    }

    public abstract void associar(Aula aula);

    public abstract void desassociar(Aula aula);

    public void remover(Aula aula) {
        if (!this.aulas.contains(aula)) {
            return;
        }

        //remover aula à lista
        this.aulas.remove(aula);
        desassociar(aula);
    }

    public void preencherSumario(Aula aula) {

        if (!aulas.contains(aula)) {
            return;
        }
        //adicionar o nome da aula
        aula.adicionarLinhaSumario(aula.getNome());

        //adicionar o numero da aula
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));

        //assinar com o nome do professor
        aula.adicionarLinhaSumario(nome);

        //dar aos alunos a preencher sumario
        //percorrer a lista de alunos da aula
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }


}
