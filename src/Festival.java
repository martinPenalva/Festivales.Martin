
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

/**
 * Un objeto de esta clase almacena los datos de un
 * festival.
 * Todo festival tiene un nombre, se celebra en un lugar
 * en una determinada fecha, dura una serie de d�as y
 * se engloba en un conjunto determinado de estilos
 *
 */
public class Festival {
    private final String nombre;
    private final String lugar;
    private final LocalDate fechaInicio;
    private final int duracion;
    private final HashSet<Estilo> estilos;
    
    
    public Festival(String nombre, String lugar, LocalDate fechaInicio,
                    int duracion, HashSet<Estilo> estilos) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.estilos = estilos;
        
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public HashSet<Estilo> getEstilos() {
        return estilos;
    }
    
    public void addEstilo(Estilo estilo) {
        this.estilos.add(estilo);
        
    }

    /**
     * devuelve el mes de celebraci�n del festival, como
     * valor enumerado
     *
     */
    public Mes getMes() {
        return Mes.valueOf(fechaInicio.getMonth().name());
    }

    public boolean empiezaAntesQue(Festival otroFestival) {
        return fechaInicio.isBefore(otroFestival.fechaInicio);
    }

    public boolean empiezaDespuesQue(LocalDate otroFestival) {
        boolean after = fechaInicio.isAfter(otroFestival.fechaInicio);
        return after;
    }

    public boolean haConcluido() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(duracion - 1);
        return hoy.isAfter(fechaFin);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String fechaInicioStr = fechaInicio.format(formatter);

        StringBuilder result = new StringBuilder();
        result.append(nombre).append(" ").append(estilos).append("\n")
                .append(lugar.toUpperCase()).append("\n");

        if (duracion == 1) {
            result.append(fechaInicioStr);
        } else {
            LocalDate fechaFin = fechaInicio.plusDays(duracion - 1);
            String fechaFinStr = fechaFin.format(formatter);
            result.append(fechaInicioStr).append(" - ").append(fechaFinStr);
        }

        result.append(" (");
        if (haConcluido()) {
            result.append("concluido");
        } else if (empiezaDespuesQue(LocalDate.now())) {
            long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio);
            result.append("quedan ").append(diasRestantes).append(" días");
        } else {
            result.append("ON");
        }
        result.append(")\n").append("-".repeat(60)).append("\n");

        return result.toString();
    }

    /**
     * Representaci�n textual del festival, exactamente
     * como se indica en el enunciado
     *
     */


    /**
     * C�digo para probar la clase Festival
     *
     */
    public static void main(String[] args) {
        System.out.println("Probando clase Festival");
        String datosFestival = "Gazpatxo Rock : " +
                "valencia: 28-02-2022  :1  :rock" +
                ":punk " +
                ": hiphop ";
        Festival f1 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f1);
        
        datosFestival = "black sound fest:badajoz:05-02-2022:  21" +
                ":rock" + ":  blues";
        Festival f2 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f2);
    
        datosFestival = "guitar bcn:barcelona: 28-01-2022 :  170" +
                ":indie" + ":pop:fusion";
        Festival f3 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f3);
    
        datosFestival = "  benidorm fest:benidorm:26-01-2022:3" +
                ":indie" + ": pop  :rock";
        Festival f4 = FestivalesIO.parsearLinea(datosFestival);
        System.out.println(f4);
      
        
        System.out.println("\nProbando empiezaAntesQue() empiezaDespuesQue()" +
                "\n");
        if (f1.empiezaAntesQue(f2)) {
            System.out.println(f1.getNombre() + " empieza antes que " + f2.getNombre());
        } else if (f1.empiezaDespuesQue(f2)) {
            System.out.println(f1.getNombre() + " empieza despu�s que " + f2.getNombre());
        } else {
            System.out.println(f1.getNombre() + " empieza el mismo d�a que " + f2.getNombre());
        }

        System.out.println("\nProbando haConcluido()\n");
        System.out.println(f4);
        System.out.println(f4.getNombre() + " ha concluido? " + f4.haConcluido());
        System.out.println(f1);
        System.out.println(f1.getNombre() + " ha concluido? " + f1.haConcluido());
 
        
        
    }
}
