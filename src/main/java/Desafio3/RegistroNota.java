package Desafio3;

public class RegistroNota {
    ///Uma classe para guardar as tuplas da tabela. Cada instância guarda um registro.
    int matricula;
    String cod_disciplina;
    int cod_curso;
    int nota;
    int carga_horaria;
    int ano_semestre;

    ///Constructor
    public RegistroNota(int matricula, String cod_disciplina, int cod_curso, int nota, int carga_horaria, int ano_semestre){
        this.matricula = matricula;
        this.cod_disciplina = cod_disciplina;
        this.cod_curso = cod_curso;
        this.nota = nota;
        this.carga_horaria = carga_horaria;
        this.ano_semestre = ano_semestre;
    }
    ///------------------------------------------//
    public int getMatricula(){return matricula;}
    public void setMatricula(int matricula){this.matricula = matricula;}
    ///------------------------------------------//
    public String getCod_disciplina(){return cod_disciplina;}
    public void setCod_disciplina(String cod_disciplina){this.cod_disciplina = cod_disciplina;}
    ///------------------------------------------//
    public int getCod_curso(){return cod_curso;}
    public void setCod_curso(int cod_curso){this.cod_curso = cod_curso;}
    ///------------------------------------------//
    public int getNota(){return nota;}
    public void setNota(int nota){this.nota = nota;}
    ///------------------------------------------//
    public int getCarga_horaria(){return carga_horaria;}
    public void setCarga_horaria(int carga_horaria){this.carga_horaria = carga_horaria;}
    ///------------------------------------------//
    public int getAno_semestre(){return ano_semestre;}
    public void setAno_semestre(int ano_semestre){this.ano_semestre = ano_semestre;}
}
