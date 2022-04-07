package modelo;

import java.util.LinkedList;

public class Aula {
    private Horario horario;
    private String nome;
    private LinkedList<Aluno> alunos;
    private StringBuilder sumario;
    private long numero;
    private Professor professor;



    //_____________ Construtores _____________
    public Aula(String nome, long numero, Horario horario) {
        this(nome, numero,horario, null, new LinkedList<>());

        /*
        this.nome = nome;
        this.numero = numero;
        //this.sumario = "";  --> por causa do String builder nao pudemos usar este construtor
        this.sumario=new StringBuilder(); // ---> usamos este

        this.professor = null;
        this.alunos = new LinkedList<>(); */
    }

    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos) {
        this.nome = nome;
        this.numero = numero;
        this.horario = horario;
        this.sumario = new StringBuilder();
        //this.professor = professor;
        setProfessor(professor);
        //this.alunos = alunos;
        this.alunos = new LinkedList<>();
        for(Aluno aluno:alunos){
            adicionar(aluno);
        }
    }

    //Ou desassociar professor
    public void desassociarProfessor() {
        if (this.professor == null) {
            return;
        }
        Professor professorARemover = this.professor;
        this.professor = null;
        professorARemover.remover(this);
    }

    // Funcionalidades
    public void adicionar(Aluno aluno) {
        if (aluno == null || this.alunos.contains(aluno)) {
            return;
        }

        //Adicionar a aula à lista de alunos
        this.alunos.add(aluno);

        //Atribuir o professor à aula
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno) {
        if (!this.alunos.contains(aluno)) {
            return;
        }

        //remover a aula à lista de alunos
        alunos.remove(aluno);

        //remover o aluno à aula
        aluno.remover(this);
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

    public String getSumario() {
//        return sumario;
        return sumario.toString();
    }

    public Professor getProfessor() {
        return professor;
    }

    //_____________ Metodos _____________
    public void setProfessor(Professor professor) {
        if (this.professor == null || this.professor == professor) {
            return;
        }

        // Se a aula ja tinha professor
        if (this.professor != null) {
            this.professor.remover(this);
        }

        //Atribuir professor
        this.professor = professor;

        //Adicionar a aula ao professor
        professor.adicionar(this);
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }


    public void adicionarLinhaSumario(String linha) {
//        sumario += sumario + linha +"\n";
//        StringBuilder sb = new StringBuilder(sumario);
//        sb.append(linha).append("\n");
//        sumario = sb.toString();
        sumario.append(linha).append("\n");
    }

    public Horario getHorario() {
        return horario;
    }

}