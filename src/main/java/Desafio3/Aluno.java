package Desafio3;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int matricula;
    /// lista de linhas do csv
    //private List<RegistroNota> historico = new ArrayList<>();
    /// constructor
    public Aluno(int matricula){this.matricula = matricula;}
    /// Adiciona uma instancia do RegistroNota na lista de historicos
    /// public void addRegistro(RegistroNota registro){this.historico.add(registro);}
    ///  get matricula pro aluno, não usamos set para evitar mudanças nos dados de matricula que é um identificador
    public int getMatricula(){return matricula;}
    /// get para pegar o primeiro registro de historico
    /// public List<RegistroNota> getHistorico(){return historico;}

    /// método para calcular cr que recebe uma lista de registros nota(historico)
    public double calcularCr(List<RegistroNota> historico){
        double notaHora = 0;
        int totalHoras = 0;
        double cr = 0;
        /// para cada registro(instancia de registronota) na lista (historico)
        for (RegistroNota registro : historico){
            /// notahora recebe ele mesmo + a nota * carga horaria
            notaHora += registro.getNota() * registro.getCarga_horaria();
            /// totalhoras soma todas as cargas horarias
            totalHoras += registro.getCarga_horaria();
        }

        cr = notaHora/totalHoras;
        return cr;
    }

}
