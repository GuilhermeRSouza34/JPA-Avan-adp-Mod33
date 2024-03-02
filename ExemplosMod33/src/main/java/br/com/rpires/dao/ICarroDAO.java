import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface ICarroDAO {
    default Carro findById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Carro carro = entityManager.find(Carro.class, id);

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }

    default void save(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void update(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    default void delete(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NomeDaSuaUnidadeDePersistencia");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}