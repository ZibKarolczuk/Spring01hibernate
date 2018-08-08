package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Person entity){
        entityManager.persist(entity);
    }

    public Person read(long id){
        return entityManager.find(Person.class, id);
    }

    public void update(Person entity){
        entityManager.merge(entity);
    }

    public void delete(Person entity){
        entityManager.remove(
                entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Person> getAll(){
        Query query = entityManager.createQuery("SELECT pe FROM Person pe");
        return query.getResultList();
    }

}
