package restaurant_management.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurantOwner")
public class RestaurantOwner {
    public RestaurantOwner() {
    }

    public RestaurantOwner(Integer ownerId, String firstName, String secondName, String lastName, String countryCode, String mobileNo, String email, GovernmentIdType governmentIdType, String governmentId, String password) {
        this.ownerId = ownerId;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ownerId")
    private Integer ownerId;

    @Column(name = "firstName", length = 50, nullable = true)
    private String firstName;

    @Column(name = "secondName", length = 50, nullable = true)
    private String secondName;

    @Column(name = "lastName", length = 50, nullable = true)
    private String lastName;

    @Column(name = "countryCode", length = 3, nullable = true)
    private String countryCode;

    @Column(name = "mobileNo", length = 20, nullable = true , unique = true)
    private String mobileNo;

    @Column(name = "email", length = 40, nullable = true , unique = true)
    private String email;

    public enum GovernmentIdType{
        panCard,adharCard
    }

    @Enumerated
    @Column(name = "governmentIdType", nullable = true)
    private GovernmentIdType governmentIdType;

    @Column(name = "governmentId", length = 20, nullable = true)
    private String governmentId;

    @Column(name = "password", length = 20, nullable = true)
    private String password;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

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

    public GovernmentIdType getGovernmentIdType() {
        return governmentIdType;
    }

    public void setGovernmentIdType(GovernmentIdType governmentIdType) {
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
