package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa{
    //_____________ Atributos _____________
    //private String nome;
    //private long numero;
    private LinkedList<Aula> aulas;
    private Horario horario;

    //_____________ Construtores _____________
    public Professor(String nome, long numero) {
//        this.nome = nome;
//        this.numero = numero;
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }

    //_____________ Metodos _____________
    public void adicionar(Aula aula) {
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }

        //Adicionar a aula à lista de aulas
        this.aulas.add(aula);

        //Atribuir o professor à aula
        aula.setProfessor(this);
    }

    public void remover(Aula aula) {
        if (/*aula == null ||*/ !this.aulas.contains(aula)) {
            return;
        }

        //Remover a aula da lista
        this.aulas.remove(aula);

        //Desassociar o professor da aula
        aula.desassociarProfessor();
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

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        //criar uma nova lista auxiliar
        LinkedList<Aula>listaAux = new LinkedList<>();
        //percorrer todas as aulas
        for(Aula aula: this.aulas) {
            //para cada aula
            aula.getHorario();
            //comparar os horarios
            if(horario.isSobre(horario) == false) {
                //se horarios sobrepostos
            }
                //adicionar à nova lista
            listaAux.add(aula);
        }
        //devolver uma lista auxiliar de aulas
        return listaAux;
    }
}