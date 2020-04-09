package data_managing.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("unid")
    private String unid;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("consentForDetails")
    private Boolean consentForDetails;
    @JsonProperty("marketingConsent")
    private Boolean marketingConsent;

    @JsonProperty("unid")
    public String getUnid() {
        return unid;
    }

    @JsonProperty("unid")
    public void setUnid(String unid) {
        this.unid = unid;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("consentForDetails")
    public Boolean getConsentForDetails() {
        return consentForDetails;
    }

    @JsonProperty("consentForDetails")
    public void setConsentForDetails(Boolean consentForDetails) {
        this.consentForDetails = consentForDetails;
    }

    @JsonProperty("marketingConsent")
    public Boolean getMarketingConsent() {
        return marketingConsent;
    }

    @JsonProperty("marketingConsent")
    public void setMarketingConsent(Boolean marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

}
