package data_managing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_managing.exceptions.ObjectMappingException;

import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

public class PojoObjectMapper {
    public static Object map(Class clazz, String jsonString) {
        try {
            LoggerSupplier.getLogger().debug(String.format("Start to map json to %s class", clazz.getSimpleName()));
            return getObjectMapper().readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new ObjectMappingException("Could not create object from JSON", e);
        }
    }

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(FAIL_ON_EMPTY_BEANS, true)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }
}
