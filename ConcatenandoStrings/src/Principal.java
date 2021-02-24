public class Principal {

    public static void main(String[] args) {

//        String resultado = "";
//
//        for (int i = 1; i <= 100; i++) {
//            resultado = resultado + i;
//        }
//

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            sb.append(i);
        }

        String resultado = sb.toString();



        System.out.println(resultado);
        // ToDo comparar a performance dos dois jeitos
    }
}
