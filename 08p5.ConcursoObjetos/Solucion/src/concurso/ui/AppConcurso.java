package concurso.ui;
import concurso.domain.*;
import concurso.util.Tiempo;

import java.time.LocalDate;
import java.time.Month;


class AppConcurso {
  public static void main(String argv[]){
    Concurso concurso = init();

    System.out.println("<--- INICIAN EL CONCURSO ---> \n" + concurso);

    for (LocalDate diaEnCurso = concurso.getStartDate(); diaEnCurso.isBefore(concurso.getEndDate()); diaEnCurso = diaEnCurso.plusDays(1)) {
      System.out.println(concurso.celebrarDia(diaEnCurso));
      Tiempo.wait(300);
    }

   System.out.println("<--- FINALIZAN EL CONCURSO ---> \n" + concurso);


  }

  private static Concurso init() {
    LocalDate startDate = LocalDate.of(2022,Month.JANUARY,1);
    LocalDate endDate = startDate.plusDays(30);
    Concurso concurso = new Concurso(startDate,endDate);
    concurso.addPareja(new Pareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Manuel", 24, false),
            new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Lucía", 25, true),
            LocalDate.of(2021, Month.JANUARY,1),Pareja.TipoRelacion.NATURAL));
    concurso.addPareja(new Pareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Paco", 24, false),
            new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Manuela", 25, true),
            LocalDate.of(2021,Month.APRIL,6),Pareja.TipoRelacion.NATURAL));
    concurso.addPareja(new Pareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Pepe", 24, false),
            new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Enriqueta", 25, true),
            LocalDate.of(2020,Month.FEBRUARY,1),Pareja.TipoRelacion.CONCURSO));
    concurso.addPareja(new Pareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Juan", 24, true),
            new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Cecilia", 25, true),
            LocalDate.of(2019,Month.JUNE,30),Pareja.TipoRelacion.DESCONOCIDO));
    concurso.addPareja(new Pareja(new ConcursanteConPareja(Concursante.Sexo.MASCULINO, "Fernando", 24, false),
            new ConcursanteConPareja(Concursante.Sexo.FEMENINO, "Luisa", 25, true),
            LocalDate.of(2021,Month.DECEMBER,31),Pareja.TipoRelacion.CONCURSO));

    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Vinsenso", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stephany", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Simone", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Stassy", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Matt", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Mary", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Joe", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Eli", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.MASCULINO, "Andrew", 26));
    concurso.addConcursanteSoltero(new ConcursanteSoltero(Concursante.Sexo.FEMENINO, "Vicky", 26));

    return concurso;
  }

}
