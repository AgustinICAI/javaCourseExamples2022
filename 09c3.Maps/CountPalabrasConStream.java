import java.util.*;
import java.util.stream.Collectors;

public class CountPalabrasConStream {
    public static void main(String argv[]){
        String discurso = Util.FileToString("/home/agus/ICAI/2022/prueba/src/discurso.txt");
        String stopWords = Util.FileToString("/home/agus/ICAI/2022/prueba/src/stopwords.txt");

        Set<String> hsStopWords = Set.of(stopWords.split("\n"));

        List<String> palabras = List.of(discurso.toLowerCase().split("\n|\s|,|\\.|-|;|\""));

        Map<String, Long> countPalabras = palabras.stream()
                .filter(p -> !hsStopWords.contains(p))
                .collect(Collectors.groupingBy(String::toString,Collectors.counting()));

        countPalabras.keySet()
                .stream()
                .sorted((e1,e2)-> countPalabras.get(e2).compareTo(countPalabras.get(e1)))
                .limit(5).forEach(p -> System.out.println(p +"-->"+countPalabras.get(p)));


    }
}
