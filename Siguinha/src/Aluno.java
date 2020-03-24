public class Aluno {

    // O nome do aluno
    private String nome;

    // O DRE
    private final long dre;

    // O CR acumulado (atualizado a cada inserção no histórico)
    private float cra;

    // As disciplinas cursadas, cada qual com a nota obtida
    private DisciplinaComNota[] historico;

    // Indica o número de posições ocupadas do histórico
    private int quantDisciplinasCursadas;

    public String getNome() {
        return nome;
    }

    /**
     * Construtor.
     */
    public Aluno(long dreDoAluno) {
        nome = "Anônimo";
        dre = dreDoAluno;
        cra = 0;
        historico = new DisciplinaComNota[100];
        quantDisciplinasCursadas = 0;
    }

    /**
     * Seta o nome do aluno
     * @param nome o novo nome desejado,
     *                 com no máximo 30 caracteres
     */
    public void setNome(String nome) {
        // valido o parâmetro
        if (nome.length() > 30) {
            return;  // ToDo lançar exceção
        }
        this.nome = nome;
    }

    /**
     * @return o CRA do aluno
     */
    public float getCra() {
        return cra;
    }

    /**
     * @return o DRE do aluno
     */
    public long getDre() {
        return dre;
    }

    public void incluirDisciplinaCursada(
            Disciplina disciplinaCursada, float notaObtida) {

        // valida a nota
        if (notaObtida < 0 || notaObtida > 10) {
            return;  // ToDo lançar exceção
        }

        DisciplinaComNota d = new DisciplinaComNota(
                disciplinaCursada, notaObtida);
        historico[quantDisciplinasCursadas] = d;
        quantDisciplinasCursadas++;

        atualizarCra();
    }

    private void atualizarCra() {
        int totalCreditos = 0;
        float acumulado = 0;
        for (int i = 0; i < quantDisciplinasCursadas; i++) {
            DisciplinaComNota dcn = historico[i];
            int quantCreditos = dcn.disciplina.getQuantCreditos();
            acumulado += dcn.nota * quantCreditos;
            totalCreditos += quantCreditos;
        }
        this.cra = acumulado / totalCreditos;
    }

    private class DisciplinaComNota {
        Disciplina disciplina;
        float nota;

        // construtor
        DisciplinaComNota(Disciplina d, float nota) {
            this.disciplina = d;
            this.nota = nota;
        }
    }
}
