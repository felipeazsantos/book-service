package dev.felipeazsantos.book_service.repositoy;

import dev.felipeazsantos.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
