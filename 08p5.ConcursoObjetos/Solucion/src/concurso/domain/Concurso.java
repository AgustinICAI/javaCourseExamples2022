package concurso.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Concurso{
  private LocalDate startDate;
  private LocalDate endDate;
  static int NUM_CONCURSANTES_SOLTEROS=10;
  static int NUM_PAREJAS=5;
  private ConcursanteSoltero[] solterosActivos;
  private Pareja[] parejasActivas;
  private int numConcursantesSolteros = 0, numParejas = 0,  numConcursantesEliminados = 0;
  private Concursante[] concursantesEliminados;

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }


  public Concurso(LocalDate startDate, LocalDate endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
    solterosActivos = new ConcursanteSoltero[NUM_CONCURSANTES_SOLTEROS];
    parejasActivas = new Pareja[NUM_PAREJAS];
    //Uso este array para ir metiendo los concursantes
    concursantesEliminados = new Concursante[NUM_PAREJAS + NUM_CONCURSANTES_SOLTEROS];
  }

  public void addPareja(Pareja p){
    this.parejasActivas[numParejas] = p;
    numParejas += 1;
  }
  
  public void addConcursanteSoltero(ConcursanteSoltero c)
  {
    solterosActivos[numConcursantesSolteros] = c;
    numConcursantesSolteros +=1;
  }
  
  public void addRelacion(ConcursanteSoltero cSoltero, Concursante c){
    cSoltero.addRelacion(c);
  }
  
  public int buscarConcursanteSoltero(ConcursanteSoltero c){
    int i = 0;
    while(i < solterosActivos.length)
    {
      if(solterosActivos[i].equals(c))
        return i;
      
      i += 1;
    }    
    return -1;
  }

  public int buscarPareja(Pareja p){
    int i = 0;
    while(i < parejasActivas.length)
    {
      if(parejasActivas[i].equals(p))
        return i;

      i += 1;
    }
    return -1;
  }
  public boolean eliminarConcursanteSoltero(ConcursanteSoltero c){
    if (c == null)
      return false;
    int pos = this.buscarConcursanteSoltero(c);
    if(pos == -1)
      return false;
    else{
      solterosActivos[pos] = null;
      for(int i = pos; i < solterosActivos.length-1; i++){
        solterosActivos[i] = solterosActivos[i+1];
      }
      solterosActivos[--numConcursantesSolteros] = null;
      return true;
    }
  }

  public boolean eliminarPareja(Pareja p){
    if (p == null)
      return false;
    int pos = this.buscarPareja(p);
    if(pos == -1)
      return false;
    else{
      parejasActivas[pos] = null;
      for(int i = pos; i < parejasActivas.length-1; i++){
        parejasActivas[i] = parejasActivas[i+1];
      }
      parejasActivas[--numParejas] = null;
      return true;
    }
  }


  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("LISTADO DE CONCURSANTES\n");
    //String salida = "";
    sb.append("~~~~~PAREJAS ACTIVAS~~~~~\n");
    for(Pareja p : parejasActivas)
    {
      if (p != null)
        sb.append(p + "\n");
    }
    sb.append("~~~~~SOLTEROS/AS ACTIVOS~~~~~\n");
    for(ConcursanteSoltero s : solterosActivos)
    {
      if (s != null)
        sb.append(s + "\n");
    }
    sb.append("~~~~~CONCURSANTES ELIMINADOS~~~~~\n");
    for(Concursante c : concursantesEliminados)
    {
      if (c != null)
        sb.append(c + "\n");
    }
    return sb.toString();
  }


  public ConcursanteSoltero getConcursanteRamdom(){
    Random r = new Random();
    return this.solterosActivos[r.nextInt(this.numConcursantesSolteros)];
  }

  public Pareja[] getParejasRotasNormalRamdom(LocalDate diaEnCurso){
    Pareja[] parejasRotas = new Pareja[NUM_PAREJAS];
    int numParejasRotas = 0;
    for (Pareja p : parejasActivas){
      if(p!=null)
        for(ConcursanteSoltero cs : solterosActivos){
          if (cs != null) {
            double factorTentador = cs.getFactorTentadorNormalRamdom();
            //System.out.println(p.getFactorEstabilidad(diaEnCurso) + "---" + factorTentador);
            if (p.getFactorEstabilidad(diaEnCurso) < factorTentador) { //PAREJA ROTA POR TENTADOR
              parejasRotas[numParejasRotas] = p;
              numParejasRotas += 1;
              if(cs.getSexo()== Concursante.Sexo.MASCULINO)
                cs.addRelacion(p.getChica());
              else
                cs.addRelacion(p.getChico());
              break;//Salimos del primer for porque la pareja se ha roto
            }
          }
        }
    }
    return parejasRotas;

  }

  public ConcursanteSoltero expulsarSolteroAleatorio() {
    ConcursanteSoltero concursanteRamdom = this.getConcursanteRamdom();
    this.eliminarConcursanteSoltero(concursanteRamdom);
    concursantesEliminados[numConcursantesEliminados++] = concursanteRamdom;
    return concursanteRamdom;
  }


  public Pareja[] getParejasTentadasYExpulsadas(LocalDate diaEnCurso) {
    Pareja[] ps = this.getParejasRotasNormalRamdom(diaEnCurso);
    for (Pareja p : ps) {
      if(p!=null) {
        this.eliminarPareja(p);
        concursantesEliminados[numConcursantesEliminados++] = p.getChico();
        concursantesEliminados[numConcursantesEliminados++] = p.getChica();
      }

    }
    return ps;
  }

  public String celebrarDia(LocalDate diaEnCurso) {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("[%tA] [%s] %n", diaEnCurso,diaEnCurso.format(DateTimeFormatter.ofPattern("dd-MM"))));
    if(diaEnCurso.getDayOfWeek() == DayOfWeek.MONDAY)
      sb.append(String.format(">>> Soltero/a expulsado: %s %n", this.expulsarSolteroAleatorio()));
    Pareja[] parejasTentadasYExpulsadas = this.getParejasTentadasYExpulsadas(diaEnCurso);
    for (Pareja p : parejasTentadasYExpulsadas)
      if(p!=null)
        sb.append(String.format(">>> Pareja expulsada: %s %n", p));

    return sb.toString();
  }
}
