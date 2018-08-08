package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.spring01hibernate.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PropositionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Book entity){
        entityManager.persist(entity);
    }

    public Book read (long id){
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity){
        entityManager.merge(entity);
    }

    public void delete(Book entity){
        entityManager.remove(
                entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Book> getAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE proposition=true");
        return query.getResultList();
    }

}
