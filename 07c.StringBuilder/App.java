public class App
{
  public static void main(String argv[])
    {
      String s1 = "HOLA";

      String s2 = s1 + "QUE" + "TAL";


      StringBuilder sb1 = new StringBuilder();
      
      sb1.append("HOLA");
      sb1.append("QUE");
      sb1.append("TAL");
      sb1.insert(4,",");
      
      //System.out.println(sb1.toString());
      System.out.println(sb1);
      
    }
}
