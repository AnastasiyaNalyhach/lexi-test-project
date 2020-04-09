import annotations.JSON;
import data_managing.PojoObjectMapper;
import data_managing.models.Data;
import data_managing.models.ThirdPartyRequest;
import data_provider.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestUpToDateModel extends BaseTest {

    private static final String EMAIL_DATA_INDEX = "email";
    private static final String ID_DATA_INDEX = "id";
    private static final String PHONE_DATA_INDEX = "phone";

    @Test(testName = "Validate UpToDate request model fields - positive", dataProvider = DATA_PROVIDER_NAME)
    @JSON(path = "json/pojo/testDataPositive.json")
    public void validateUpToDateModel(String testData) {
        ThirdPartyRequest thirdPartyRequest =
                (ThirdPartyRequest) PojoObjectMapper.map(ThirdPartyRequest.class, testData);

        Map<String, Boolean> validationResult = areParametersValid(thirdPartyRequest.getData());

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(validationResult.get(ID_DATA_INDEX)).as("UserId format is valid").isTrue();
            softly.assertThat(validationResult.get(PHONE_DATA_INDEX)).as("Phone number format is valid").isTrue();
            softly.assertThat(validationResult.get(EMAIL_DATA_INDEX)).as("Email format is valid").isTrue();
        });
    }

    @Test(testName = "Validate UpToDate request model fields - negative", dataProvider = DATA_PROVIDER_NAME)
    @JSON(path = "json/pojo/testDataNegative.json")
    public void validateUpToDateModelNegative(String testData) {
        ThirdPartyRequest thirdPartyRequest =
                (ThirdPartyRequest) PojoObjectMapper.map(ThirdPartyRequest.class, testData);

        Map<String, Boolean> validationResult = areParametersValid(thirdPartyRequest.getData());

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(validationResult.get(ID_DATA_INDEX)).as("UserId format is valid").isTrue();
            softly.assertThat(validationResult.get(PHONE_DATA_INDEX)).as("Phone number format is valid").isTrue();
            softly.assertThat(validationResult.get(EMAIL_DATA_INDEX)).as("Email format is valid").isTrue();
        });
    }

    private Map<String, Boolean> areParametersValid(Data requestData) {
        Map<String, Boolean> result = new HashMap<>();

        result.put(EMAIL_DATA_INDEX,isStringMatch(requestData.getEmailAddress(), EMAIL_REGEX));
        result.put(PHONE_DATA_INDEX,isStringMatch(requestData.getPhoneNumber(), PHONE_REGEX));
        result.put(ID_DATA_INDEX,isStringMatch(requestData.getUnid(), ID_REGEX));
        return result;
    }

    private boolean isStringMatch(String source, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(source);

        return matcher.matches();
    }
}
