package up_to_date;

import annotations.JSON;
import data_managing.ResourceReader;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class BaseTest {
    protected static final String DATA_PROVIDER_NAME = "jsonDataProvider";
    protected static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    protected static final String PHONE_REGEX = "^\\d-\\d{3}-\\d{3}-\\d{4}$";
    protected static final String ID_REGEX = "\\p{XDigit}{1,32}";

    @DataProvider(name = DATA_PROVIDER_NAME)
    public Object[][] jsonProviderMethod(Method method) {
        String path = method.getAnnotation(JSON.class).path();
        String testData = ResourceReader.getResourceAsString(path);
        return new Object[][]{{testData}};
    }

}