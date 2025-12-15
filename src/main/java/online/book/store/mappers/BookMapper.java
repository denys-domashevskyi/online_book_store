package online.book.store.mappers;

import online.book.store.config.MapperConfig;
import online.book.store.dto.BookDto;
import online.book.store.dto.CreateBookRequestDto;
import online.book.store.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book fromDto(CreateBookRequestDto requestDto);
}
