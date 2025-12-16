package Desafio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Curso {
    private int codCurso;
    ///private List<Aluno> alunosCurso = new ArrayList<>();
    /// Constructor
    public Curso(int codCurso){
        this.codCurso = codCurso;
    }
    /// Function que recebe uma instancia de aluno e adiciona na lista alunosCurso
    /// public void addAluno(Aluno aluno){this.alunosCurso.add(aluno);}
    /// get
    public int getCodCurso(){return codCurso;}
    /// Recebe uma lista de alunos(alunosDoCurso) e um hashmap de inteiros com lista de registroNota (mapRegistroDoAluno)
    public double mediaCurso(List<Aluno> alunosDoCurso, HashMap<Integer, List<RegistroNota>> mapRegistrosDoAluno){
        double somaCr = 0;
        for (Aluno aluno : alunosDoCurso){
            ///  Inicia uma lista de registrosNota puxando(get) a matricula do hashmap de registros do aluno
            List<RegistroNota> listaRegistrosDoAluno = mapRegistrosDoAluno.get(aluno.getMatricula());
            /// soma cr soma o cr de todos os alunos que pertencem a um determinado curso
            /// A lista recebe todos os registros pertencentes a aquele curso especifico
            /// somaCr chama calcularCr para todos os alunos registrados naquele curso e a func retorna esse numero/ tamanho da lista(numero de alunos)
            List<RegistroNota> registrosDoCurso = new ArrayList<>();
            for (RegistroNota registro : listaRegistrosDoAluno){
                if(registro.getCod_curso() == this.codCurso){
                    registrosDoCurso.add(registro);
                }
            }
            somaCr += aluno.calcularCr(registrosDoCurso);
        }
        return somaCr/alunosDoCurso.size();
    }
}
