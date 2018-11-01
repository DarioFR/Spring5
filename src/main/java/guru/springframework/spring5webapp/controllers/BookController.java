package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        //popola il modello che servirà alla view di Thymeleaf in seguito
        model.addAttribute("books",bookRepository.findAll());

        //redirige l'applicazione ad una view Thymeleaf di nome "books"
        return "books";
    }
}
