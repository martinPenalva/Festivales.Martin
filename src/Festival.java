
import java.time.LocalDate;
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
    public Mes getMes() {
        Mes mes = null;
        switch(fechaInicio.getMonth())
        {
            case JANUARY:
                mes = Mes.ENERO;
                break;

            case FEBRUARY:
                mes = Mes.FEBRERO;
                break;

            case MARCH:
                mes = Mes.MARZO;
                break;

            case APRIL:
                mes = Mes.ABRIL;
                break;

            case MAY:
                mes = Mes.MAYO;
                break;

            case JUNE:
                mes = Mes.JUNIO;
                break;

            case JULY:
                mes = Mes.JULIO;
                break;

            case AUGUST:
                mes = Mes.AGOSTO;
                break;

            case SEPTEMBER:
                mes = Mes.SEPTIEMBRE;
                break;

            case OCTOBER:
                mes = Mes.OCTUBRE;
                break;

            case NOVEMBER:
                mes = Mes.NOVIEMBRE;
                break;

            case DECEMBER:
                mes = Mes.DICIEMBRE;
                break;

            default:
                System.out.println("El mes no existe.");
                break;

        }
        return mes;
    }
    public boolean empiezaAntesQue(Festival otro) {
        //hecho

        return this.fechaInicio.isBefore(otro.fechaInicio);
    }


    public boolean empiezaDespuesQue(Festival otro) {
        //hecho

        return this.fechaInicio.isAfter(otro.fechaInicio);
    }
    public boolean haConcluido() {
        //hecho

        return this.fechaInicio.plusDays(duracion).isBefore(LocalDate.now());
    }



