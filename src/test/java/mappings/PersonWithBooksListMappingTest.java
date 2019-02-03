package mappings;

import customconverters.CustomCitizenConverter;
import dtos.PersonDto;
import dtos.PersonDtoWithBooksDtoList;
import dtos.PersonDtoWithBooksDtoList2;
import entities.Book;
import entities.Citizen;
import entities.PersonWithBooksList;
import enums.CitizenStatus;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonWithBooksListMappingTest {

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
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        PersonDtoWithBooksDtoList personDto = mapper.map(person, PersonDtoWithBooksDtoList.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsNotSameNameFieldsNotCorrectly() {
        configureMapper("mappings/book-mapping.xml");
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        PersonDtoWithBooksDtoList2 personDto = mapper.map(person, PersonDtoWithBooksDtoList2.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsNotSameNameFieldsNotCorrectlyThenCorrect() {
        configureMapper("mappings/book-mapping.xml");
        configureMapper("mappings/personwithlist-mapping.xml");
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        PersonDtoWithBooksDtoList2 personDto = mapper.map(person, PersonDtoWithBooksDtoList2.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsNotSameNameFieldsCorrectlyThenCorrect() {
        configureMapper("mappings/book-mapping.xml");
        configureMapper("mappings/personwithlist2-mapping.xml");
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        PersonDtoWithBooksDtoList2 personDto = mapper.map(person, PersonDtoWithBooksDtoList2.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsNotSameNameFieldsorrectlyThenCorrect() {
        configureMapper("mappings/personwithlist3-mapping.xml");
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        PersonDtoWithBooksDtoList2 personDto = mapper.map(person, PersonDtoWithBooksDtoList2.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestObjectWhenMapsSameNameFieldsCorrectlyThenCorrect() {
        PersonWithBooksList person = new PersonWithBooksList("Baeldung", 10);
        person.setBooks(getBooks());
        Citizen citizen = new Citizen(person, CitizenStatus.ACTIVE);
        CustomCitizenConverter customCitizenConverter = new CustomCitizenConverter();
        PersonDtoWithBooksDtoList2 personDto = customCitizenConverter.convertTo(citizen, new PersonDtoWithBooksDtoList2());

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book(1, "The machine", "Delibes");
        Book book2 = new Book(2, "Tha lynx", "Kafka");
        books.add(book1);
        books.add(book2);
        return books;
    }
}
