package examenmayo2021.ui;

public class JHospital extends JFrame{
  
  private JLabel lblTitulo;
  private int numHospitalesProcesados; 
  
  public JHospital(){
    super("JHospital");
    
    SaludMadrid sm = new SaludMadrid();
    List<Hospital> hospitales = sm.readHospitales();
    HashMap<String,Integer> hospitalNumUrgencias = Hospital.importHospitalesUrgencias("HospitalesAProcesar.csv");
    
    numHospitalesProcesados = 0;
    lblTitulo = new JLabel("Hospitales procesados: 0");
    this.add(lblTitulo,BorderLayout.NORTH);
    
    Panel pnlHospitales = new JPanel();
    pnl.setLayout(new GridLayout(hospitales.size(),2);
    this.add(pnlHospitales/*,BorderLayout.CENTER*/);
    
    GestionUrgencias gu = new GestionUrgencias();
    
    for(Hospital h: hospitales){
      pnlHospitales.add(new JLabel(h.getNombre()));
      
      btnHospital = new JButton("Procesar");
      /*
      JButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
           new Thread(new Runnable(){
            public void run(){
            
            }
           };
        }
      });*/
      
      JButton.addActionListener(e -> {
      
       new Thread(() -> {
         int numUrgenciasProcesar = hospitalNumUrgencias.get(h.getAbreviatura()); 
         Collection<Urgencia> urgencias = h.getUrgencias();
         
         Iterator<Urgencia> itUrgencias = urgencias.iterator();
         int countUrgencias = 0;
         int procesadosOK = 0;
         
         while(it.hasNext() && countUrgencias < numUrgenciasProcesar){
            Urgencia u = it.next();
            int procesado = gu.procesar(u);
            if (procesado == GestionUrgencias.PROCESADO_OK)
              procesadosOK += 1;
            
            countUrgencias += 1;
         }
         if(countUrgencias == procesadosOK)
           incrementarHospitalProcesado();
       
       }.start();
            
        
      });
      
      pnlHospitales.add(btnHospital);
    
    }
    
    
  
  }
  
  public static void main(String ... argv){
    new JHospital();
  
  }
  
  public synchronized void incrementarHospitalProcesado(){
    numHospitalesProcesados+=1;
    lblTitulo = new JLabel("Hospitales procesados: "+numHospitalesProcesados);
  };



}
