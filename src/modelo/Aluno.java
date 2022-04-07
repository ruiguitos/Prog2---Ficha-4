package modelo;

import java.util.LinkedList;

public class Aluno extends Pessoa  {

    //atributos
//    private String nome;
//    private long numero;
    private LinkedList<Aula> aulas;


    //construtores
    public Aluno(String nome, long numero) {
//        this.nome = nome;
//        this.numero = numero;
        super(nome,numero);
        this.aulas = new LinkedList<>();
    }

    //métodos
//    public void adicionar(Aula aula) {
//        if (aula == null || this.aulas.contains(aula)) {
//            return;
//        }
//
//        //adicionar aula à lista
//        this.aulas.add(aula);
//        //aula adicionar este aluno

//    }


//    public void remover(Aula aula) {
//        if (!this.aulas.contains(aula)) {
//            return;
//        }
//
//        //remover aula à lista
//        aulas.remove(aula);
//        //aula remover este aluno
//        aula.remover(this);
//
//    }

//    public String getNome() {
//        return nome;
//    }
//
//    public long getNumero() {
//        return numero;
//    }
//
//    public void setNumero(long numero) {
//        this.numero = numero;
//    }

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

    @Override
    public void adicionar(Aula aula) {
        super.adicionar(aula);
        aula.adicionar(this);
    }

    @Override
    public void remover(Aula aula) {
        super.remover(aula);
        aula.remover(this);
    }
}


