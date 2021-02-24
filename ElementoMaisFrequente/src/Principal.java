import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {

        List<String> listaDePalavras = new ArrayList<>();

        File arquivo = new File("arquivo.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(arquivo);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não existe!");
            return;
        }

        while (scanner.hasNext()) {

            String linha = scanner.nextLine();
            String[] palavrasDessaLinha = linha.split(" ");
            for (String palavra : palavrasDessaLinha) {
                listaDePalavras.add(
                        palavra.replace(".", "").replace(",", ""));
            }
        }

        ContadorOcorrencias<String> contadorOcorrencias =
                new ContadorOcorrenciasUsandoHashMap<>();

        String elementoMaisFrequente =
                contadorOcorrencias.retornarElementoMaisFrequente(listaDePalavras);

        System.out.println("Palavra mais frequente = " + elementoMaisFrequente);



        /* Uma outra forma é usando FileReader, BufferedReader
         */

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            // leitura
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            while (br.ready()) {
                String linha = br.readLine();
            }

            // escrita
            fw = new FileWriter(arquivo);
            bw = new BufferedWriter(fw);
            bw.write("linha nova");

        } finally {

            bw.close();
            fw.close();

            br.close();
            fr.close();
        }
    }
}
