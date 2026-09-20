package dev.felipeazsantos.book_service.controller;

import dev.felipeazsantos.book_service.dto.ExchangeDto;
import dev.felipeazsantos.book_service.environment.InstanceInformationService;
import dev.felipeazsantos.book_service.model.Book;
import dev.felipeazsantos.book_service.proxy.ExchangeProxy;
import dev.felipeazsantos.book_service.repositoy.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeProxy exchangeProxy;

    // http://localhost:8100/book-service/1/BRL
    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        String port = informationService.retrieveServerPort();

        var book = bookRepository.findById(id).orElseThrow();

        ExchangeDto exchangeDto = exchangeProxy.getExchange(book.getPrice(), "USD", currency);
        if (exchangeDto != null) {
            book.setPrice(exchangeDto.getConvertedValue());
        }

        book.setEnvironment(port + " FEIGN");
        book.setCurrency(currency);
        return book;
    }
}
