package modelo;

import java.util.LinkedList;

public class Pessoa extends Identificador {

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
    }

    public void remover(Aula aula) {
        if (!this.aulas.contains(aula)) {
            return;
        }

        //remover aula à lista
        aulas.remove(aula);
    }



}
