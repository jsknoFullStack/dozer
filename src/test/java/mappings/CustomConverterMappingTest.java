package mappings;

import dtos.StudentDto;
import entities.Student;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CustomConverterMappingTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    public void configureMapper(String... mappingFileUrls) {
        mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldTypesWhenAbleToCustomConvertThenCorrect() {

        configureMapper("mappings/custom-converters-mapping.xml");
        String dateTime = "2007-06-26T21:22:39Z";
        long timestamp = new Long("1182885759000");
        StudentDto studentDto = new StudentDto("Rich", dateTime);
        Student student = mapper.map(studentDto, Student.class);

        Assert.assertEquals(timestamp, student.getDtob().longValue());
    }


}
