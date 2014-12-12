import com.titanic.ventapasajes.modelo.Terminal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by josediaz on 7/18/14.
 */
public class TestTerminal {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        Terminal terminal1 = new Terminal();
        terminal1.setNombreTerminal("FIORI");
        terminal1.setDireccionTerminal("Direccion de Fiori");

        Terminal terminal2 = new Terminal();
        terminal2.setNombreTerminal("PLAZA NORTE");
        terminal2.setDireccionTerminal("Dirección de Plaza Norte");

        Terminal terminal3 = new Terminal();
        terminal3.setNombreTerminal("ZAPALLAL");
        terminal3.setDireccionTerminal("Dirección de Zapallal");

        Terminal terminal4 = new Terminal();
        terminal4.setNombreTerminal("CHICLAYO");
        terminal4.setDireccionTerminal("Dirección de Chiclayo");


        manager.persist(terminal1);
        manager.persist(terminal2);
        manager.persist(terminal3);
        manager.persist(terminal4);

        trx.commit();
    }
}
