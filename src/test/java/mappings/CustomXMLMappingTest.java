package mappings;

import dtos.BookDto;
import entities.Book;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CustomXMLMappingTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    public void configureMapper(String... mappingFileUrls) {
        mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapperWhenMapsThenCorrect() {

        configureMapper("mappings/book-mapping.xml");
        Book book = new Book(1, "Rambo", "Delibes");
        BookDto bookDto = mapper.map(book, BookDto.class);

        Assert.assertEquals(bookDto.getId(), book.getBookId());
        Assert.assertEquals(bookDto.getTitle(), book.getTitle());
        Assert.assertEquals(bookDto.getAuthor(), book.getBookAuthor());
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapperWhenMapsBidirectionallyThenCorrect(){

        configureMapper("mappings/book-mapping.xml");
        BookDto bookDto = new BookDto(1, "Rambo", "Delibes");
        Book book = mapper.map(bookDto, Book.class);

        Assert.assertEquals(book.getBookId(), bookDto.getId());
        Assert.assertEquals(book.getTitle(), bookDto.getTitle());
        Assert.assertEquals(book.getBookAuthor(), bookDto.getAuthor());
    }

    @Test
    public void givenSrcAndDestWhenMapsOnlySpecifiedFieldsThenCorrect() {

        configureMapper("mappings/book2-mapping.xml");
        Book book = new Book(1, "Rambo", "Delibes");
        BookDto bookDto = mapper.map(book, BookDto.class);

        Assert.assertEquals(bookDto.getId(), book.getBookId());
        Assert.assertNull(bookDto.getTitle());
        Assert.assertEquals(bookDto.getAuthor(), book.getBookAuthor());
    }
}
