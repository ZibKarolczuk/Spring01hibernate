package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Person;
import pl.coderslab.spring01hibernate.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(PersonDetails entity){
        entityManager.persist(entity);
    }

    public PersonDetails read(long id){
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails entity){
        entityManager.merge(entity);
    }

    public void delete(PersonDetails entity){
        entityManager.remove(
                entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<PersonDetails> getAll(){
        Query query = entityManager.createQuery("SELECT pd FROM PersonDetails pd");
        return query.getResultList();
    }

}
