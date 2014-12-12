import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.titanic.ventapasajes.modelo.Grupo;
import com.titanic.ventapasajes.modelo.Usuario;


public class TestUsuario {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Jose Diaz");
		usuario.setEmail("jose.diaz@joedayz.pe");
		usuario.setPassword("123");
        usuario.setActivo(true);

		Grupo grupo1 = new Grupo();
		grupo1.setNombreGrupo("VENDEDORES");
		grupo1.setDescripcion("Vendedores de la empresa");
		usuario.getGrupos().add(grupo1);

        Grupo grupo2 = new Grupo();
        grupo2.setNombreGrupo("ADMINISTRADORES");
        grupo2.setDescripcion("Administradores de la empresa");
        usuario.getGrupos().add(grupo2);

		manager.persist(usuario);

		trx.commit();
	}
}
