package online.book.store.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import online.book.store.dto.BookDto;
import online.book.store.dto.CreateBookRequestDto;
import online.book.store.exception.EntityNotFoundException;
import online.book.store.mappers.BookMapper;
import online.book.store.model.Book;
import online.book.store.repository.BookRepository;
import online.book.store.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        Book bookToSave = bookMapper.fromDto(book);
        return bookMapper.toDto(bookRepository.save(bookToSave));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id" + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto book) {
        Book bookForSave = bookMapper.fromDto(book);
        bookForSave.setId(id);
        return bookMapper.toDto(bookRepository.save(bookForSave));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
