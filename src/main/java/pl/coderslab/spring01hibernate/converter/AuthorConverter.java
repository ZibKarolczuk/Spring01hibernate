package pl.coderslab.spring01hibernate.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.entity.Author;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return this.authorDao.readAuthor(Long.parseLong(source));
    }

}
