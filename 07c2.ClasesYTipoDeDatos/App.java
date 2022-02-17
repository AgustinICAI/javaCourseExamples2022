import java.util.Calendar;

public class App{
  public static void main (String ... argv){
    int i0 = 5;
    //NO USAR ya que está deprecado, usar siempre autoboxing
    //Integer i1 = new Integer(5);
    
    Integer i2 = 5;
    
    Double d1 = 45.5234;
    
    double d2 = d1;
    
    System.out.println(d1.compareTo(44894d));
    
    
    long l0 = 5;
    
    int i3 = (int)l0;
    
    double d0 = 6.4123412314;
    
    int i4 = (int)d0;
    
    String s0 = "1231234123";
    String s1 = new String("4814092384109238");
    
    
    //int a = 65 → Integer → float →char → String → devolver el primer carácter en
    //mayúsculas como char → int → byte
    
    int a = 65;
    Integer a1 = a;
    float f2 = a1;
    char c3 = (char)f2;
    //Opción 1
    Character c31 = c3;
    String s41 = c31.toString();
    //Opción 2
    char [] c3s = {c3};
    String s42 = new String(c3s);
    //Opción 3 - opción preferida
    String s43 = String.valueOf(c3);
    char c5 = s43.substring(0,1).toUpperCase().charAt(0);
    int i6 = c5;
    byte i7 = (byte)i6;
    
    
    System.out.println(Math.sin(Math.toRadians(30)));
    
    Calendar c1 = Calendar.getInstance();
    System.out.println(c1);
    Calendar c2 = new GregorianCalendar(2022,3,4);
    
    
    
    
  }
}
