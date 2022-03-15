import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Persona,Coche> map = new TreeMap<>();

        map.put(new Persona("Beatriz Ordoñez"),new Coche("Audi","a1"));
        map.put(new Persona("Beatriz Royo"),new Coche("Seat","Ibiza"));
        map.put(new Persona("Josephine"),new Coche("Ford","Mustang"));
        map.put(new Persona("Vicente"),new Coche("Ford","Mustang"));


        Coche c1 = map.get(new Persona("Vicente"));
        System.out.println(c1);

        Set<Persona> personas = map.keySet();
        System.out.println(personas);

        Collection<Coche> coches = map.values();
        System.out.println(coches);

        /*
        Set<Map.Entry<Persona, Coche>> entries = map.entrySet();
        for(Map.Entry<Persona, Coche> entrie : entries){
            System.out.println(entrie.getKey()+"-->"+entrie.getValue());
        }*/
        //Iterando usando entrySet
        for(Map.Entry<Persona, Coche> e : map.entrySet()){
            System.out.println(e.getKey()+"-->"+e.getValue());
        }
        //Iterando usando un keyset, y recuperando el coche por la clave
        for(Persona p : map.keySet()){
            System.out.println(p + "--->" + map.get(p));
        }
        //Iterando con foreach usando expresiones lambda
        map.forEach((p,c)->System.out.println(p+"--->"+c));

    }
}
