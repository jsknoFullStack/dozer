package mappings;

import dtos.AnnotatedContact;
import dtos.BookDto;
import entities.Book;
import entities.Contact;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomAnnotationsMappingTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    @Test
    public void givenAnnotatedSrcFieldsWhenMapsToRightDestFieldThenCorrect() {

        Contact contact = new Contact(1L, "Alvaro", "666777");
        AnnotatedContact contactDto = mapper.map(contact, AnnotatedContact.class);

        Assert.assertEquals(contactDto.getContactId(), contact.getId());
        Assert.assertEquals(contactDto.getName(), contact.getName());
        Assert.assertEquals(contactDto.getNumber(), contact.getTelephoneNumber());
    }

    @Test
    public void givenAnnotatedSrcFieldsWhenMapsToRightDestFieldBidirectionallyThenCorrect() {


        AnnotatedContact contactDto = new AnnotatedContact(1L, "Alvaro", "666777");

        Contact contact = mapper.map(contactDto, Contact.class);

        Assert.assertEquals(contactDto.getContactId(), contact.getId());
        Assert.assertEquals(contactDto.getName(), contact.getName());
        Assert.assertEquals(contactDto.getNumber(), contact.getTelephoneNumber());

    }
}
