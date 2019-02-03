package mappings;

import dtos.PersonDto;
import dtos.PersonDtoWithBook;
import dtos.PersonDtoWithBooksDtoList;
import entities.Book;
import entities.Person;
import entities.PersonWithBook;
import entities.PersonWithBooksList;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonWithBookMappingTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    public void configureMapper(String... mappingFileUrls) {
        mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsSameNameFieldsCorrectlyThenCorrect() {
        configureMapper("mappings/book-mapping.xml");
        PersonWithBook personWithBook = new PersonWithBook("Baeldung", 10);
        personWithBook.setBook(new Book(1, "The metamorphoseis", "Kafka"));
        PersonDtoWithBook personDtoWithBook = mapper.map(personWithBook, PersonDtoWithBook.class);

        assertEquals(personDtoWithBook.getName(), "Baeldung");
        assertEquals(personDtoWithBook.getAge().intValue(), 10);
    }

}
