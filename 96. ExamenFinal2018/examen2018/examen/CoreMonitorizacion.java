package examen;

import jdk.internal.jimage.ImageStrings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CoreMonitorizacion {
    ArrayList<JVentanaMonitorizacion> ventanas;
    Collection<Sensor> sensores;
    ArrayList<Sensor> eventosNuevos;

    CoreMonitorizacion()
    {
        ventanas = new ArrayList<>();
        ventanas.add(new JVentanaMonitorizacion("23"));
        ventanas.add(new JVentanaMonitorizacion("25"));

        sensores = IOSensores.readObjects("sensores.obj");
        eventosNuevos = new ArrayList<>();
        empezarEscuchaEventos();
    }

    private void empezarEscuchaEventos() {
        //Comprobar si todas las ventanas siguen abiertas
        boolean ventanasAbiertas = true;
        while(ventanasAbiertas)
        {
            //Rellena eventosNuevos
            actualizarLecturas();
            //En base a eventosNuevos actualiza las ventanas
            actualizarVentanas();
            //Limpia eventos nuevos
            this.eventosNuevos.clear();
            //Esperamos hasta el siguiente segundo
            try {
                Util.wait(1);
            }catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            ventanasAbiertas = false;
            for(JVentanaMonitorizacion v : ventanas)
            {
                if(!v.isVentanaCerrada())
                    ventanasAbiertas = true;
            }
        }
    }

    private void actualizarLecturas() {
        Iterator<Sensor> itSensores = sensores.iterator();
        while(itSensores.hasNext()) {
            Sensor s = itSensores.next();
            try {
                List<String> lineas = Files.readAllLines(Path.of(s.getId() + ".txt"));
                String ultimoEvento = lineas.get(lineas.size()-1);
                if(s.seteaValor(ultimoEvento))
                {
                    this.eventosNuevos.add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void actualizarVentanas() {
        //En la realidad hubiera sido mejor usar hashmap directamente, pero en este ejericcio se hace con iterators ya que es lo que pide el enunciado
        while(ventanasAbiertas())
        {
            Iterator<JVentanaMonitorizacion> it = ventanas.iterator();
            while(it.hasNext())
            {
                JVentanaMonitorizacion ventanaMonitorizacion = it.next();
                if(!ventanaMonitorizacion.isVentanaCerrada()) {
                    Iterator<Sensor> itSensoresVentana = ventanaMonitorizacion.getSensoresSubscritos().iterator();
                    while(itSensoresVentana.hasNext())
                    {
                        Sensor sensorVentana = itSensoresVentana.next();

                        Iterator<Sensor> itEventosNuevos = eventosNuevos.iterator();
                        while(itEventosNuevos.hasNext())
                        {
                            Sensor eventoNuevo = itEventosNuevos.next();
                            if(eventoNuevo.equals(sensorVentana))
                                ventanaMonitorizacion.addEventoMonitorizacion(eventoNuevo);
                        }
                    }
                }
            }
    }

}

    private boolean ventanasAbiertas() {
        Iterator<JVentanaMonitorizacion> it = ventanas.iterator();
        while(it.hasNext())
        {
            JVentanaMonitorizacion v = it.next();
            if(v.isDisplayable())
                return true;
        }
        return false;
    }

}
