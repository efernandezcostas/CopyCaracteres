import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Texto texto = new Texto();
        texto.leerTexto();
        texto.copiarTexto();
    }
}

class Texto {
    ArrayList<Integer> listaCaracteres = new ArrayList<>();

    public void leerTexto() {
        int resultado;

        try (
                FileReader fr = new FileReader("texto1.txt");
        ){
            do {
                resultado = fr.read();
                if (resultado != -1)  listaCaracteres.add(resultado);
            } while (resultado!=-1);
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void copiarTexto() {
        try(
                FileWriter fw = new FileWriter("texto2.txt");
        ){
            for (Integer caracter : listaCaracteres){
                fw.write(caracter);
            }
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
