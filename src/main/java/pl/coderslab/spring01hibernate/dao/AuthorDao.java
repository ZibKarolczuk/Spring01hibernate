package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.spring01hibernate.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createAuthor(Author entity){
        entityManager.persist(entity);
    }

    public Author readAuthor(long id){
        return entityManager.find(Author.class, id);
    }

    public void updateAuthor(Author entity){
        entityManager.merge(entity);
    }

    public void deleteAuthor(Author entity){
        entityManager.remove(
                entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Author> getAll(){
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

}
