package ejerciciosClase;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Collection<Politico> politicos = new ArrayList<>();
        politicos.add(new Politico("Isabel Díaz Ayuso",3500));
        politicos.add(new Politico("Yolanda Diez",1000));
        politicos.add(new Politico("Echenique",0));
        politicos.add(new Politico("Zelenski",-99));

        for(Politico p : politicos)
            System.out.println(p);

        //Ejemplo trabajando con Arraylist

        ArrayList<Politico> alPoliticos = (ArrayList<Politico>) politicos;
        System.out.println(alPoliticos.get(3));
        System.out.println(politicos.remove(2));


        //Ejemplo linkedlist
        LinkedList<Politico> llPoliticos = new LinkedList<>();
        llPoliticos.addAll(politicos);
        llPoliticos.addFirst(new Politico("Rajoy",57));
        llPoliticos.addLast(new Politico("Rajoy",57));

        for(Politico p : llPoliticos)
            System.out.println(p);
        System.out.println("###EJEMPLO TRABAJANDO HASHSET###");

        //Ejemplo HashSet
        HashSet<Politico> hsPoliticos = new HashSet<>();
        hsPoliticos.addAll(llPoliticos);
        for(Politico p : hsPoliticos){
            System.out.println(p.hashCode()+","+p);
        }

        //Ejemplo TreeSet
        System.out.println("###EJEMPLO TRABAJANDO TREESET###");
        TreeSet<Politico> tsPoliticos = new TreeSet<>();
        tsPoliticos.addAll(hsPoliticos);
        Politico p1 = new Politico("Rajoy",60);
        if (tsPoliticos.contains(p1))
            tsPoliticos.remove(p1);
        tsPoliticos.add(p1);

        for(Politico p : tsPoliticos){
            System.out.println(p);
        }

    }
}
