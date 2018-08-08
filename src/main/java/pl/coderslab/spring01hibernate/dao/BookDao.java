package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

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
        Query query = entityManager.createQuery("SELECT b FROM Book WHERE proposition=false");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b where rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public Book getBookById(long id){
        Query query = entityManager.createQuery("SELECT b FROM Book b where id = :id");
        query.setParameter("id", id);
        return (Book) query.getResultList().get(0);
    }

}
