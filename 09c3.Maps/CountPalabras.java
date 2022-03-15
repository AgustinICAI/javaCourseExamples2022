import java.util.*;

public class CountPalabras {
    public static void main(String argv[]){
        String discurso = Util.FileToString("/home/agus/ICAI/2022/prueba/src/discurso.txt");
        String stopWords = Util.FileToString("/home/agus/ICAI/2022/prueba/src/stopwords.txt");
        /*
        HashSet<String> hsStopWords = new HashSet<>();
        for(String s : stopWords.split("\n")){
            hsStopWords.add(s);
        }*/
        HashSet<String> hsStopWords = new HashSet<>(Set.of(stopWords.split("\n")) );
        String [] palabras = discurso.toLowerCase().split("\n|\s|,|\\.|-|;");


        HashMap<String,Integer> palabrasCount = new HashMap<>();

        for(String palabra : palabras){
            if(!hsStopWords.contains(palabra))
                if(palabrasCount.containsKey(palabra)){
                    palabrasCount.put(palabra,palabrasCount.get(palabra)+1);
                }else{
                    palabrasCount.put(palabra,1);
                }
        }

        TreeMap<Integer, ArrayList<String>> palabrasOrdenadas = new TreeMap<>();

        palabrasCount.forEach((palabra,count)-> {
            if(!palabrasOrdenadas.containsKey(count))
                palabrasOrdenadas.put(count,new ArrayList<>());
            palabrasOrdenadas.get(count).add(palabra);
        });

        for(int count : palabrasOrdenadas.descendingKeySet()){
            System.out.println(count+""+palabrasOrdenadas.get(count));
        }
    }
}
