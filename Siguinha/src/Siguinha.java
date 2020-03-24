import java.util.Scanner;

public class Siguinha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // crio um aluno
        Aluno aluno = new Aluno(111111);
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(sc.nextLine());

        System.out.println("Aluno cadastrado!");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("DRE: " + aluno.getDre());
        System.out.println("CRA: " + aluno.getCra());

        Disciplina calculo1 = new Disciplina();
        calculo1.setNome("Cálculo 1");
        calculo1.setQuantCreditos(6);

        Disciplina comp1 = new Disciplina();
        comp1.setNome("Computação 1");
        comp1.setQuantCreditos(4);

        aluno.incluirDisciplinaCursada(calculo1, 8);
        System.out.println("CRA: " + aluno.getCra());

        aluno.incluirDisciplinaCursada(comp1, 6);
        System.out.println("CRA: " + aluno.getCra());

    }
}
