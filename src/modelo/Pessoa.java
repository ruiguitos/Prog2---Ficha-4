package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {

    protected LinkedList<Aula> aulas;

    public Pessoa(String nome, long numero) {
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }

    /*
        public String getNome() {
            return nome;
        }

        public long getNumero() {
            return numero;
        }                                      ###### Sai por causa da superclass Identificador #####

        public void setNumero(long numero) {
            this.numero = numero;
        }
    */

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        //criar uma nova lista auxiliar
        LinkedList<Aula> listaAux = new LinkedList<>();
        //percorrer todas as aulas do professor

        for (Aula aula : this.aulas) {
            aula.getHorario();
            //para cada aula comparar os horarios -> se os horaios sobrespostos -> adicionar à nova lista
            if (aula.getHorario().isSobre(horario) == false) {
                listaAux.add(aula);
            }

        }
        //devolver uma lista de auls
        return listaAux;
    }
    //---------------------------------------------------------------------------
    public void adicionar(Aula aula) {

        if (aula == null || this.aulas.contains(aula)) {
            return;
        }
        //adicionar a aula à lista de aulas
        this.aulas.add(aula);
        //associar a pessoa à aula
        associar(aula);

    }

    protected abstract void associar(Aula aula);

    //---------------------------------------------------------------------
    public void remover(Aula aula) {
        if (/*aula==null ||*/ !this.aulas.contains(aula)) {
            return;
        }
        //remover aula da lista
        this.aulas.remove(aula);
        desassociar(aula);
    }

    protected abstract void desassociar(Aula aula);
    //--------------------------------------------------------------------------
    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula))
            return;

        escreverSumario(aula);
    }

    protected void escreverSumario(Aula aula) {
    }

    protected void assinarSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }
}