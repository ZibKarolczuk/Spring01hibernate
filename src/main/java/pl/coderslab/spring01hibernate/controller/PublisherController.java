package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private BookDao bookDao;

    @GetMapping("/add/{pub}")
    @ResponseBody
    public String add(@PathVariable String pub){
        Publisher p = new Publisher();
        p.setName(pub);

        this.publisherDao.create(p);

        return "Dodano, id=" + p.getId();
    }

    @GetMapping("/addbook/{pubid}/{bookid}")
    @ResponseBody
    public String add(@PathVariable long pubid,
                      @PathVariable long bookid){
        Publisher p = this.publisherDao.read(pubid);
        Book b = this.bookDao.read(bookid);
        p.getBooks().add(b);

        this.publisherDao.update(p);

        return "Dodano książkę, id=" + b.getId();
    }
}
