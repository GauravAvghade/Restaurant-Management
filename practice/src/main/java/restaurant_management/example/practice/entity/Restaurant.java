package restaurant_management.example.practice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    public Restaurant() {
    }

    public Restaurant(Integer restaurantId, String restaurantName, String mobileNo, RestroType restaurantType, String speciality, String serviceType, String openingHours, String closingHours, String logo, List<RestaurantAddress> baseAddress) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.mobileNo = mobileNo;
        this.restaurantType = restaurantType;
        this.speciality = speciality;
        this.serviceType = serviceType;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.logo = logo;
        this.baseAddress = baseAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private Integer restaurantId;

    @Column(name = "restaurantName", length = 100, nullable = false)
    private String restaurantName;

    @Column(name = "mobileNo", length = 100, nullable = false , unique = true)
    private String mobileNo;

    public enum RestroType {
        Veg, NonVeg;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "restaurantType", nullable = false)
    private RestroType restaurantType;

    @Column(name = "speciality", length = 200, nullable = true)
    private String speciality;

    @Column(name = "serviceType", length = 20, nullable = false)
    private String serviceType;

    @Column(name = "openingHours", length = 10, nullable = true)
    private String openingHours;

    @Column(name = "closingHours", length = 10, nullable = true)
    private String closingHours;

    @Column(name = "logo", length = 100, nullable = true)
    private String logo;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantAddress> baseAddress;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public RestroType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestroType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<RestaurantAddress> getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(List<RestaurantAddress> baseAddress) {
        this.baseAddress = baseAddress;
    }
}
