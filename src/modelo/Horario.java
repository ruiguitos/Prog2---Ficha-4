package modelo;

public class Horario {

    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;


    //construtor
    public Horario(DiaSemana diaSemana, int horaInicio, int duracao){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario){
        int horaFimThis = horaInicio + duracao;
        int horaFimHorario = horario.horaInicio + horario.duracao;
        if(this.diaSemana == horario.diaSemana && horaFimHorario > this.horaInicio && horaFimThis > horario.horaInicio){
            return true;
        }
        return false;
    }
}
