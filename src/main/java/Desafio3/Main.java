package Desafio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /// path do arquivo.csv
        String arquivo = "C:\\Users\\Thiago\\Desktop\\Programação\\Java\\Lista de Revisão Intro a Dev Web\\Desafio_STI\\src\\main\\resources\\notas.csv";
        /// Hashmap<chave, valor>
        HashMap<Integer, Aluno> mapAlunos = new HashMap<>();
        HashMap<Integer, Curso> mapCursos = new HashMap<>();
        HashMap<Integer, List<RegistroNota>> mapRegistrosDoAluno = new HashMap<>();
        HashMap<Integer, List<Aluno>> mapAlunosDoCurso = new HashMap<>();
        /// Instancia o buffered reader para leitura de texto e o file reader para ler o csv
        /// buffered reader faz o file reader ler uma linha por vez
        BufferedReader breader = new BufferedReader(new FileReader(arquivo));
        /// chama o metodo readLine para ler uma linha de texto
        /// chama readline para ler primeira linha e pular o header
        String linha = breader.readLine();
        /// Enquanto a linha não for vazia(loop para iterar nas linhas do arquivo)
        while ((linha = breader.readLine()) != null) {
            /// split para separar os dados onde aparece , (o csv separa as colunas por ',')
            String[] dados = linha.split(",");
            /// variaveis para receber os dados do csv
            int matricula = Integer.parseInt(dados[0]);
            String cod_disciplina = dados[1];
            int cod_curso = Integer.parseInt(dados[2]);
            int nota = Integer.parseInt(dados[3]);
            int carga_horaria = Integer.parseInt(dados[4]);
            int ano_semestre = Integer.parseInt(dados[5]);
            /// Instancia o registro nota usando as variaveis com os dados do csv
            RegistroNota registro = new RegistroNota(matricula, cod_disciplina, cod_curso, nota, carga_horaria, ano_semestre);

            /// verifica se o aluno ja esta na lista
            /// containsKey verifica se no hashmap mapalunos existe a chave(id) matricula
            if (!mapAlunos.containsKey(matricula)){
                /// adiciona aluno na lista
                mapAlunos.put(matricula, new Aluno(matricula));
            }
            /// verifica se o curso ja esta na lista
            if(!mapCursos.containsKey(cod_curso)){
                /// adiciona curso na lista
                mapCursos.put(cod_curso, new Curso(cod_curso));
            }

            /// cria uma nova lista para registrar os registros(linhas) do aluno
            List<RegistroNota> listaRegistroDoAluno = new ArrayList<>();

            /// verifica se o aluno ja possui lista de registros, se sim, busca a lista
            if (mapRegistrosDoAluno.containsKey(matricula)){
                /// adiciona o registro de um aluno(linha) na lista de registros do aluno com a determinada matricula
                listaRegistroDoAluno = mapRegistrosDoAluno.get(matricula);
            }

            /// adiciona o registro do aluno
            listaRegistroDoAluno.add(registro);

            /// atualiza a lista do aluno
            mapRegistrosDoAluno.put(matricula, listaRegistroDoAluno);

            /// Cria lista para guardar alunos por curso
            List<Aluno> listaAlunosDoCurso = new ArrayList<>();

            /// verifica se o curso ja possui lista de alunos, se sim, busca a lista
            if(mapAlunosDoCurso.containsKey(cod_curso)){
                /// adiciona o aluno no mapping de alunos do curso linkando com o cod_curso
                listaAlunosDoCurso = mapAlunosDoCurso.get(cod_curso);
            }

            /// busca aluno na mapalunos pela matricula e adiciona o aluno na listaalunosCurso caso o aluno não esteja presente
            Aluno alunoAtual = mapAlunos.get(matricula);
            if(!listaAlunosDoCurso.contains(alunoAtual)){
                listaAlunosDoCurso.add(alunoAtual);
            }

            /// atualiza a lista do aluno
            mapAlunosDoCurso.put(cod_curso, listaAlunosDoCurso);
        }
        //Prints

        System.out.println("O CR Dos Alunos é: ");
        /// values retorna uma visão de coleção dos valores no hashmap
        for (Aluno a : mapAlunos.values()) {
            /// busca todos os registros do aluno
            /// Cria lista de registros de aluno agrupados por matricula
            List<RegistroNota> listaRegistrosDoAluno = mapRegistrosDoAluno.get(a.getMatricula());
            System.out.println("Matrícula: " + a.getMatricula() + " | CR: " + a.calcularCr(listaRegistrosDoAluno));
        }

        System.out.println("\nA Média de CR dos Cusos é: ");
        for (Curso c : mapCursos.values()) {
            /// busca todos os alunos do curso
            /// Cria lista de alunos agrupados por cod_curso
            List<Aluno> listaAlunosDoCurso = mapAlunosDoCurso.get(c.getCodCurso());
            System.out.println("Curso: " + c.getCodCurso() + " | Média: " + c.mediaCurso(listaAlunosDoCurso, mapRegistrosDoAluno));
        }
        breader.close();
    }

}