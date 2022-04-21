import java.io.*;

public class MainWrite {
    public static void main(String... argv){

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("Alumnos.csv"),true)));
            Persona p1 = new Persona("Adriana","Tur","El diario de bridget",20);

            pw.println(p1.toCSV());

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
