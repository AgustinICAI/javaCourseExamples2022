import java.io.*;

public class Util {
    static String FileToString(String ruta) {
        String s="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(ruta)));
            String linea;
            while((linea = br.readLine()) != null){
                s+=linea+"\n";
            }}
        catch (IOException e){
            e.printStackTrace();
        }
        return s;
    }
}
