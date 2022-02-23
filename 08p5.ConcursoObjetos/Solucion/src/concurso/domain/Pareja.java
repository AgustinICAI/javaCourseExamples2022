package concurso.domain;

import java.time.Duration;
import java.time.LocalDate;

public class Pareja {
    private final TipoRelacion tipoRelacion;
    private ConcursanteConPareja chico;
    private ConcursanteConPareja chica;
    LocalDate inicioRelacion;

    public enum TipoRelacion{
        NATURAL(10), CONCURSO(5), DESCONOCIDO(3);

        public int getFactor() {
            return factor;
        }
        private final int factor;

        TipoRelacion(int factor)
        {
            this.factor = factor;
        }
    }

    public Pareja(ConcursanteConPareja chico, ConcursanteConPareja chica, LocalDate inicioRelacion, TipoRelacion tipoRelacion) {
        this.chico = chico;
        this.chica = chica;
        this.inicioRelacion = inicioRelacion;
        this.tipoRelacion = tipoRelacion;
        chico.setPareja(chica);
        chica.setPareja(chico);

    }


    public ConcursanteConPareja getChico() {
        return chico;
    }

    public void setChico(ConcursanteConPareja chico) {
        this.chico = chico;
    }

    public ConcursanteConPareja getChica() {
        return chica;
    }

    public void setChica(ConcursanteConPareja chica) {
        this.chica = chica;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "tipoRelacion=" + tipoRelacion +
                ", chico=" + chico +
                ", chica=" + chica +
                ", inicioRelacion=" + inicioRelacion +
                ", factorEstabilidadADíaPresente=" + this.getFactorEstabilidad(LocalDate.now()) +
                '}';
    }

    public double getFactorEstabilidad(LocalDate diaEnCurso){
        long diasRelacion = Duration.between(inicioRelacion.atStartOfDay(),diaEnCurso.atStartOfDay()).toDays();
        return diasRelacion * (chico.getEdad()+chica.getEdad())/2 * tipoRelacion.getFactor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pareja pareja = (Pareja) o;
        return chico.equals(pareja.getChico()) && chica.equals(pareja.getChica());
    }



}
