public class App
{
  static int i; 
  static String s2;
  
  public static void main (String... argv)
  {
  
    
    ConcursanteConPareja ccp1 = new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Manuel", 24, 5, false);
    ConcursanteConPareja ccp2 = new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Lucía", 25, true, ccp1);
    //ccp1.setPareja(ccp2); Se evita con la linea añadida en el setter:     pareja.setPareja(this);
    
    ConcursanteSoltero cs1 = new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Vinsenso", 26);
    ConcursanteSoltero cs2 = new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stephany", 26);
    ConcursanteSoltero cs3 = new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Simone", 26);
    ConcursanteSoltero cs4 = new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stassy", 26);
   
  
    Concursante[] concursantes = new Concursante[30];
    concursantes[0] = ccp1;
    concursantes[1] = ccp2;
    concursantes[2] = cs1;
    concursantes[3] = cs2;  
    concursantes[4] = cs3;  
    concursantes[5] = cs4;  
    
    //for (int i = 0; i < concursantes.length; i++)
    //  System.out.println(concursantes[i]);
       
    
    for (Concursante concursante : concursantes)
      if (concursante != null)
        System.out.println(concursante.getNombre() + " - " + concursante.getVilla());
    
    System.out.println("Mostrando sólo parejas para mostrar un ejemplo de DOWNCASTING");
    for (Concursante concursante : concursantes)
      if (concursante != null && concursante instanceof ConcursanteConPareja){
        ConcursanteConPareja ccp = (ConcursanteConPareja) concursante;
        System.out.println(ccp.getNombre() +"-"+ ccp.getPareja().getNombre());
      }
        

    
  }



}
