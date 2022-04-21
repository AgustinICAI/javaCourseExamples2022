import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class MainRead {

    public static void main(String[] args) {
        Collection<Persona> personas = new ArrayList<>();
        try {
            /*
            File f = new File("Alumnos.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr);
            */

            BufferedReader br = new BufferedReader(new FileReader(new File("Alumnos.csv")));
            /*
            String linea = br.readLine();
            while (linea != null){
                Persona p = Persona.fromCSV(linea);
                personas.add(p);
                linea = br.readLine();
            }*/
            String linea;
            while((linea = br.readLine())!=null){
                personas.add(Persona.fromCSV(linea));
            }


            System.out.println(personas);

            br.close();
        }/*
        catch (FileNotFoundException e){
            e.printStackTrace();
        } */catch (IOException e) {
            e.printStackTrace();
        }


    }
}
