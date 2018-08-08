package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/add/{title}/{author}/{rating}")
    @ResponseBody
    public String add(@PathVariable String title,
                      @PathVariable String author,
                      @PathVariable int rating){
        Book b = new Book();
        b.setTitle(title);
//        b.setAuthor(author);
        b.setRating(rating);

        this.bookDao.create(b);

        return "Dodano, id=" + b.getId();
    }

    @GetMapping("/addform")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());

        return "book/addForm";
    }

    @PostMapping("/addform")
    public String addBookFormPost(@ModelAttribute Book book){
        this.bookDao.create(book);

        return "redirect:list";
    }



    @GetMapping("/addformv")
    public String addBookFormValidated(Model model){
        model.addAttribute("book", new Book());

        return "book/addFormValidated";
    }

    @PostMapping("/addformv")
    public String addBookFormValidatedPost(@Valid Book book,
                                           BindingResult result){
        if(result.hasErrors()){
            return "book/addFormValidated";
        }
        // if validation passed
        this.bookDao.create(book);

        return "redirect:list";
    }











    @GetMapping("/list")
    public String list(){
        return "book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        Book b = this.bookDao.read(id);
        model.addAttribute("book", b);

        return "book/addForm";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@ModelAttribute Book book){
        this.bookDao.update(book);

        return "redirect:../list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return this.publisherDao.readAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return this.authorDao.getAll();
    }

    @ModelAttribute("books")
    public List<Book> books(){
        return this.bookDao.getAll();
    }
}
