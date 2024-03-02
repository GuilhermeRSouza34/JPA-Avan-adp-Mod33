import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IMarcaDAO {
    default Marca findById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Marca marca = entityManager.find(Marca.class, id);

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }

    default void save(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void update(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void delete(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}