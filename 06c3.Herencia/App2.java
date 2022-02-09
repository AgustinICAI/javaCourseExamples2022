public class App2{
  public static void main(String argv[]){
    Concurso concurso = new Concurso(); 
    
       
    concurso.addPareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Manuel", 24, 5, false),
                       new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Lucía", 25, 5, true));
    concurso.addConcursante(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Vinsenso", 26));
    concurso.addConcursante(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stephany", 26));
    concurso.addConcursante(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Simone", 26));
    concurso.addConcursante(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stassy", 26));
    
    System.out.println(concurso);
    
    System.out.println("EXPULSANDO CONCURSANTE");
    Concursante concursanteABorrar = new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Manuel", 24, 5, false);
    concurso.eliminarConcursante(concursanteABorrar);
    System.out.println(concurso);
  
  }

}
