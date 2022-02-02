public class App
{
  public static void main (String... argv)
  {
    Concursante c1 = new Concursante("masculino", "Manuel", 24, true);
    Concursante c2 = new Concursante("masculino", "Manuel", 24, true);

    System.out.println(c1 == c2);
    
    int i = 5;
    int j = 5;
    
    System.out.println(i == j);
    

  }



}
