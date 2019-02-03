package customconverters;

import dtos.StudentDto;
import entities.Student;
import org.dozer.CustomConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentCustomConverter implements CustomConverter {

    @Override
    public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
        if (source == null)
            return null;

        if (source instanceof Student) {
            Student person = (Student) source;
            Date date = new Date(person.getDtob());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String isoDate = format.format(date);
            return new StudentDto(person.getName(), isoDate);

        } else if (source instanceof StudentDto) {
            StudentDto person = (StudentDto) source;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMANY);
            Date date = null;
            try {
                date = format.parse(person.getDtob());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long timestamp = date.getTime();
            return new Student(person.getName(), timestamp);
        }
        return null;
    }
}
