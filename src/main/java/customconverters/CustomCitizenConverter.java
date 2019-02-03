package customconverters;

import dtos.PersonDtoWithBooksDtoList;
import dtos.PersonDtoWithBooksDtoList2;
import entities.Citizen;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

import java.util.Arrays;

public class CustomCitizenConverter extends DozerConverter<Citizen, PersonDtoWithBooksDtoList2> implements MapperAware {

    private Mapper mapper;

    public CustomCitizenConverter() {
        super(Citizen.class, PersonDtoWithBooksDtoList2.class);
        setMapper(new DozerBeanMapper());
    }

    @Override
    public PersonDtoWithBooksDtoList2 convertTo(Citizen citizen, PersonDtoWithBooksDtoList2 personDtoWithBooksDtoList2) {
        return this.mapper.map(citizen.getPerson(), PersonDtoWithBooksDtoList2.class);
    }

    @Override
    public Citizen convertFrom(PersonDtoWithBooksDtoList2 personDtoWithBooksDtoList2, Citizen citizen) {
        return null;
    }

    @Override
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
//        configureMapper("mappings/book-mapping.xml");
        configureMapper("mappings/personwithlist-mapping.xml");
//        configureMapper("mappings/personwithlist2-mapping.xml");
//        configureMapper("mappings/personwithlist3-mapping.xml");

    }

    private void configureMapper(String... mappingFileUrls) {
        ((DozerBeanMapper) this.mapper).setMappingFiles(Arrays.asList(mappingFileUrls));
    }
}
