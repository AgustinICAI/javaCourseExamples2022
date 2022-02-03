public class App
{
  static int i; 
  static String s2;
  
  public static void main (String... argv)
  {
    ConcursanteConPareja ccp1 = new ConcursanteConPareja(Concursante.MASCULINO, "Manuel", 24, 5, false);
    ConcursanteConPareja ccp2 = new ConcursanteConPareja(Concursante.FEMENINO, "Lucía", 25, true, ccp1);
    //ccp1.setPareja(ccp2); Se evita con la linea añadida en el setter:     pareja.setPareja(this);
    
    
    String s1 = "123";

    
    
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(i);

  }



}
