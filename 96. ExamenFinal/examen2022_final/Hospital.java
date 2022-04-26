package examenmayo2021.domain;

public class Hospital{
  String nombre;
  String id;
  int capacidad;
  Collection<Urgencia> urgencias;
  
  public Hospital(String nombre, String id, int capacidad){
    this.nombre = nombre;
    this.id = id;
    this.capacidad = capacidad;
    
    urgencias = new ArrayList<>();
  }
  
  public Collection<Urgencia> getUrgencias(){
    return urgencias;
  }
  

  public String getAbreviatura(){
    return this.nombre.substring(0,1) + this.id.substring(0,1);
  }
  
  
  public String getNombre(){
    return this.nombre;
  }


  public static HashMap<String,Integer> importHospitalesUrgencias(String ruta) throws IOException, NumberFormatException{
      BufferedReader br = new BufferedReader(new FileReader(new File(ruta)));
      String linea;
      
      HashMap<String, Integer> hm = new HashMap<>();
      
      while((linea = br.readLine()) != null){
        String[] campos = linea.split(",");
        hm.put(campos[0].trim(), Integer.parseInt(campos[1].trim()));      
      }
      
      br.close();
      
      return hm;
  }  
  
}
