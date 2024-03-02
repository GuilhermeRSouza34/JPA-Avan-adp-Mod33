import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IAcessorioDAO {
    default Acessorio findById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Acessorio acessorio = entityManager.find(Acessorio.class, id);

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }

    default void save(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void update(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void delete(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        acessorio = entityManager.merge(acessorio);
        entityManager.remove(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}