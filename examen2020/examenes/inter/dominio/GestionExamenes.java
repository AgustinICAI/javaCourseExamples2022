public GestionExamenes{
  Collection<Examen> examenes = new TreeSet<>();
  
  Collection<Examen> getExamenesEntre(double limiteInferior, double limiteSuperior){
    TreeSet<Examen > tsExamenes = (TreeSet<Examen>)examenes;
    return tsExamenes.subset(new Examen(limiteInferior),new Examen(limiteSuperior));
  }
  
  Collection<Examen> getExamenesMayor(double limiteInferior){
    TreeSet<Examen > tsExamenes = (TreeSet<Examen>)examenes;
    return tsExamenes.tailSet(new Examen(limiteInferior));
  }

  Examen getExamenAleatorio(){
    double semilla = Math.ramdom();
    
    int tamano = examenes.size();
    
    int pos = (int) semilla*tamano;
    
    Iterator<Examen> it = examenes.iterator();
    int i = 0;
    while(it.hasNext()){
      if (pos == i)
        return it.next();
      i += 1;    
    }
    else return null;
  }
  //Si examenes hubiera sido un arraylist
  Examen getExamenAleatorio(){
    ArrayList<Examen > arExamenes = (ArrayList<Examen>)examenes;
    .....
    return ar.get(pos);
  }
  

}
