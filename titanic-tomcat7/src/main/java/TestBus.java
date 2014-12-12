import com.titanic.ventapasajes.modelo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josediaz on 7/18/14.
 */
public class TestBus {

    public static void main(String[] args){

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
//        EntityManager manager = factory.createEntityManager();
//
//        EntityTransaction trx = manager.getTransaction();
//        trx.begin();
//
//        Bus bus = new Bus();
//        bus.setDescripcionBus("TITANIC SPRINTER 1");
//        bus.setNumeroMotor("123-456-789-ABC");
//        bus.setPlaca("B8N-555");
//        bus.setTipoPlanta(TipoPlanta.DOS_PLANTA);
//        bus.setTipoBus(TipoBus.COMUN);
//        bus.setConAireAcondicionado(true);
//
//        Fila fInf1 = new Fila();
//        fInf1.setBus(bus);
//        fInf1.setUbicacionPlanta(UbicacionPlanta.INFERIOR);
//
//        List<Celda> celdasFilaInferior1 = new ArrayList<>();
//        Celda celdaInf11 = new Celda();
//        celdaInf11.setFila(fInf1);
//        celdaInf11.setEstadoCelda(EstadoCelda.LIBRE);
//        celdaInf11.setTipoCelda(TipoCelda.ASIENTO);
//        celdaInf11.setNumeroCelda("L-63");
//
//        celdasFilaInferior1.add(celdaInf11);
//
//        Celda celdaInf12 = new Celda();
//        celdaInf12.setFila(fInf1);
//        celdaInf12.setEstadoCelda(EstadoCelda.LIBRE);
//        celdaInf12.setTipoCelda(TipoCelda.ASIENTO);
//        celdaInf12.setNumeroCelda("L-64");
//
//        celdasFilaInferior1.add(celdaInf12);
//
//
//        Celda celdaInf13 = new Celda();
//        celdaInf13.setFila(fInf1);
//        celdaInf13.setEstadoCelda(EstadoCelda.LIBRE);
//        celdaInf13.setTipoCelda(TipoCelda.PASILLO);
//        celdaInf13.setNumeroCelda("");
//
//        celdasFilaInferior1.add(celdaInf13);
//
//
//        Celda celdaInf14 = new Celda();
//        celdaInf14.setFila(fInf1);
//        celdaInf14.setEstadoCelda(EstadoCelda.LIBRE);
//        celdaInf14.setTipoCelda(TipoCelda.ASIENTO);
//        celdaInf14.setNumeroCelda("L-66");
//
//        celdasFilaInferior1.add(celdaInf14);
//
//        Celda celdaInf15 = new Celda();
//        celdaInf15.setFila(fInf1);
//        celdaInf15.setEstadoCelda(EstadoCelda.LIBRE);
//        celdaInf15.setTipoCelda(TipoCelda.ASIENTO);
//        celdaInf15.setNumeroCelda("L-65");
//
//        celdasFilaInferior1.add(celdaInf15);
//
//
//        Fila f1 = new Fila();
//        f1.setBus(bus);
//        f1.setUbicacionPlanta(UbicacionPlanta.SUPERIOR);
//
//
//        List<Celda> celdasFila1 = new ArrayList<>();
//        Celda celda11 = new Celda();
//        celda11.setFila(f1);
//        celda11.setEstadoCelda(EstadoCelda.LIBRE);
//        celda11.setTipoCelda(TipoCelda.ASIENTO);
//        celda11.setNumeroCelda("L-1");
//
//        celdasFila1.add(celda11);
//
//        Celda celda12 = new Celda();
//        celda12.setFila(f1);
//        celda12.setEstadoCelda(EstadoCelda.LIBRE);
//        celda12.setTipoCelda(TipoCelda.ASIENTO);
//        celda12.setNumeroCelda("L-2");
//
//        celdasFila1.add(celda12);
//
//        Celda celda13= new Celda();
//        celda13.setFila(f1);
//        celda13.setEstadoCelda(EstadoCelda.LIBRE);
//        celda13.setTipoCelda(TipoCelda.TELEVISOR);
//        celda13.setNumeroCelda("TV-1");
//
//        celdasFila1.add(celda13);
//
//
//        Celda celda14= new Celda();
//        celda14.setFila(f1);
//        celda14.setEstadoCelda(EstadoCelda.LIBRE);
//        celda14.setTipoCelda(TipoCelda.ASIENTO);
//        celda14.setNumeroCelda("L-4");
//
//        celdasFila1.add(celda14);
//
//        Celda celda15 = new Celda();
//        celda15.setFila(f1);
//        celda15.setEstadoCelda(EstadoCelda.LIBRE);
//        celda15.setTipoCelda(TipoCelda.ASIENTO);
//        celda15.setNumeroCelda("L-3");
//
//        celdasFila1.add(celda15);
//
//
//        Fila f2 = new Fila();
//        f2.setBus(bus);
//        f2.setUbicacionPlanta(UbicacionPlanta.SUPERIOR);
//
//        List<Celda> celdasFila2 = new ArrayList<>();
//        Celda celda21 = new Celda();
//        celda21.setFila(f2);
//        celda21.setEstadoCelda(EstadoCelda.LIBRE);
//        celda21.setTipoCelda(TipoCelda.ASIENTO);
//        celda21.setNumeroCelda("L-5");
//
//        celdasFila2.add(celda21);
//
//
//        Celda celda22 = new Celda();
//        celda22.setFila(f2);
//        celda22.setEstadoCelda(EstadoCelda.LIBRE);
//        celda22.setTipoCelda(TipoCelda.ASIENTO);
//        celda22.setNumeroCelda("L-6");
//
//
//        celdasFila2.add(celda22);
//
//        Celda celda23 = new Celda();
//        celda23.setFila(f2);
//        celda23.setEstadoCelda(EstadoCelda.LIBRE);
//        celda23.setTipoCelda(TipoCelda.PASILLO);
//        celda23.setNumeroCelda("");
//
//        celdasFila2.add(celda23);
//
//        Celda celda24= new Celda();
//        celda24.setFila(f2);
//        celda24.setEstadoCelda(EstadoCelda.LIBRE);
//        celda24.setTipoCelda(TipoCelda.ASIENTO);
//        celda24.setNumeroCelda("L-8");
//
//        celdasFila1.add(celda24);
//
//        Celda celda25 = new Celda();
//        celda25.setFila(f2);
//        celda25.setEstadoCelda(EstadoCelda.LIBRE);
//        celda25.setTipoCelda(TipoCelda.ASIENTO);
//        celda25.setNumeroCelda("L-7");
//
//        celdasFila1.add(celda25);
//
//
//        f1.setCeldasInferiores(celdasFila1);
//        f2.setCeldasInferiores(celdasFila2);
//
//
//        List<Fila> filasSegundaPlanta = new ArrayList<>();
//        filasSegundaPlanta.add(f1);
//        filasSegundaPlanta.add(f2);
//
//        List<Fila> filasPrimeraPlanta = new ArrayList<>();
//        filasSegundaPlanta.add(fInf1);
//
//        bus.setFilasInferiores(filasPrimeraPlanta);
//        //bus.setFilasSegundaPlanta(filasSegundaPlanta);
//
//        manager.persist(bus);
//
//
//        trx.commit();
    }
}
