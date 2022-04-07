package modelo;

import java.util.LinkedList;

public class Aluno {

    //atributos
    private final String nome;
    private final LinkedList<Aula> aulas;
    private long numero;

    //construtores
    public Aluno(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        this.aulas = new LinkedList<>();
    }

    //métodos
    public void adicionar(Aula aula) {
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }

        //adicionar aula à lista
        this.aulas.add(aula);
        //aula adicionar este aluno
        aula.adicionar(this);

    }

    public void remover(Aula aula) {
        if (!this.aulas.contains(aula)) {
            return;
        }

        //remover aula à lista
        aulas.remove(aula);
        //aula remover este aluno
        aula.remover(this);

    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }

        //assinar o sumario
        aula.adicionarLinhaSumario(nome);
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return new LinkedList<>(aulas);
    }
}
