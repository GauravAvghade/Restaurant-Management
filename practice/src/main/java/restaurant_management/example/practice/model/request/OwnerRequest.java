package restaurant_management.example.practice.model.request;

public class OwnerRequest {
    public OwnerRequest() {
    }

    public OwnerRequest(String firstName, String secondName, String lastName, String countryCode, String mobileNo, String email, String governmentIdType, String governmentId, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.mobileNo = mobileNo;
        this.email = email;
        this.governmentIdType = governmentIdType;
        this.governmentId = governmentId;
        this.password = password;
    }

    private String firstName;
    private String secondName;
    private String lastName;
    private String countryCode;
    private String mobileNo;
    private String email;
    private String governmentIdType;
    private String governmentId;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGovernmentIdType() {
        return governmentIdType;
    }

    public void setGovernmentIdType(String governmentIdType) {
        this.governmentIdType = governmentIdType;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
