package girnara.abhay.parking.domain.model.commons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;

import java.io.IOException;
import java.util.List;

/**
 * Created by abhay on 30/03/19.
 */
public class JsonUtility {
    private JsonUtility(){
        throw new UnsupportedOperationException();
    }
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper OBJECT_MAPPER_IGNORE_UNKNOWN = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  /**
   * From string t.
   *
   * @param <T>      the type parameter
   * @param jsonData the json data
   * @param clazz    the clazz
   * @return the t
   * @throws NonRecoverableException the non recoverable exception
   */
  public static <T> T fromString(String jsonData, Class<T> clazz) throws NonRecoverableException {
        try {
            return OBJECT_MAPPER.readValue(jsonData, clazz);
        }catch (IOException ex) {
            throw new NonRecoverableException(ex, ex.getMessage(), AbstractConstants.ExceptionCode.DESERIALIZATION_FAILED_ERROR);
        }
    }

  /**
   * From string ignore unknown fields t.
   *
   * @param <T>      the type parameter
   * @param jsonData the json data
   * @param clazz    the clazz
   * @return the t
   * @throws NonRecoverableException the non recoverable exception
   */
  public static <T> T fromStringIgnoreUnknownFields(String jsonData, Class<T> clazz) throws NonRecoverableException {
        try {
            return OBJECT_MAPPER_IGNORE_UNKNOWN.readValue(jsonData, clazz);
        }catch (IOException ex) {
            throw new NonRecoverableException(ex, ex.getMessage(), AbstractConstants.ExceptionCode.DESERIALIZATION_FAILED_ERROR);
        }
    }

  /**
   * To string string.
   *
   * @param object the object
   * @return the string
   * @throws NonRecoverableException the non recoverable exception
   */
  public static String toString(Object object) throws NonRecoverableException {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new NonRecoverableException(ex, ex.getMessage(), AbstractConstants.ExceptionCode.SERIALIZATION_FAILED_ERROR);
        }
    }

  /**
   * From string array to list list.
   *
   * @param <S>      the type parameter
   * @param jsonData the json data
   * @param source   the source
   * @return the list
   * @throws NonRecoverableException the non recoverable exception
   */
  public static <S> List<S> fromStringArrayToList(String jsonData, Class<S> source) throws NonRecoverableException{
        try {
            return OBJECT_MAPPER.readValue(jsonData, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, source));
        } catch (IOException ex) {
            throw new NonRecoverableException(ex, ex.getMessage(), AbstractConstants.ExceptionCode.SERIALIZATION_FAILED_ERROR);
        }
    }

}
