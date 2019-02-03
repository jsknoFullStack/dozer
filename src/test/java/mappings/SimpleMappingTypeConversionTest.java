package mappings;

import dtos.FilmDto;
import entities.Film;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleMappingTypeConversionTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper();
    }

    @Test
    public void givenSourceAndDestWithDifferentFieldTypesWhenMapsAndAutoConvertsThenCorrect() {
        Film source = new Film("320", "A title", 15.2);
        FilmDto dest = mapper.map(source, FilmDto.class);

        Assert.assertEquals(dest.getId().intValue(), 320);
        Assert.assertEquals(dest.getPoints().intValue(), 15);
    }
}
