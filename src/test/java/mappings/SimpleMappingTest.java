package mappings;

import dtos.PersonDto;
import entities.Person;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleMappingTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    @Test
    public void givenSourceObjectAndDestClassWhenMapsSameNameFieldsCorrectlyThenCorrect() {
        Person person = new Person("Baeldung", 10);
        PersonDto personDto = mapper.map(person, PersonDto.class);

        assertEquals(personDto.getName(), "Baeldung");
        assertEquals(personDto.getAge().intValue(), 10);
    }

    @Test
    public void givenSourceObjectAndDestObjectWhenMapsSameNameFieldsCorrectlyThenCorrect() {
        Person source = new Person("Baeldung", 10);
        PersonDto dest = new PersonDto();
        mapper.map(source, dest);

        assertEquals(dest.getName(), "Baeldung");
        assertEquals(dest.getAge().intValue(), 10);
    }
}
