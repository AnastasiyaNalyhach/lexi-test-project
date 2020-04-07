import data_managing.PojoObjectMapper;
import data_managing.ResourceReader;
import data_managing.models.Data;
import data_managing.models.ThirdPartyRequest;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class TestUpToDateModel {
    private String emailRegex = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private String phoneRegex = "\\d-\\d{3}-\\d{3}-\\d{4}$";
    private String pathWithinResFolder = "json/pojo/testData.json";


    @Test(testName = "Validate UpToDate request model")
    public void validateUpToDateModel() {
        String requestModelAsString = ResourceReader.getResourceAsString(pathWithinResFolder);
        ThirdPartyRequest thirdPartyRequest =
                                (ThirdPartyRequest) PojoObjectMapper.map(ThirdPartyRequest.class, requestModelAsString);

        Data requestData = thirdPartyRequest.getData();
        boolean isEmailValid = isStringMatches(requestData.getEmailAddress(), emailRegex);
        boolean isPhoneValid = isStringMatches(requestData.getPhoneNumber(), phoneRegex);

        assertThat("Check email format is valid", isEmailValid, is(true));
        assertThat("Check userId is not zero-valued", requestData.getUnid(), greaterThan(0));
        assertThat("Check phone number format is valid", isPhoneValid, is(true));
    }

    private boolean isStringMatches(String source, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(source);

        return matcher.matches();
    }
}
