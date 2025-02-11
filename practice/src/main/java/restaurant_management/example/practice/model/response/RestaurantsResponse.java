package restaurant_management.example.practice.model.response;

public class RestaurantsResponse {
    public RestaurantsResponse() {
    }

    public RestaurantsResponse(String restaurantName, String mobileNo, String email, String addressLine1, String addressLine2, String city, String state, String country, String pincode, String restroType, String speciality, String foodLicense, String serviceType, String openingHour, String clossingHour, String logo) {
        this.restaurantName = restaurantName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.restroType = restroType;
        this.speciality = speciality;
        this.foodLicense = foodLicense;
        this.serviceType = serviceType;
        this.openingHour = openingHour;
        this.clossingHour = clossingHour;
        this.logo = logo;
    }

    private String restaurantName;
    private String mobileNo;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String restroType;
    private String speciality;
    private String foodLicense;
    private String serviceType;
    private String openingHour;
    private String clossingHour;
    private String logo;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getRestroType() {
        return restroType;
    }

    public void setRestroType(String restroType) {
        this.restroType = restroType;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getFoodLicense() {
        return foodLicense;
    }

    public void setFoodLicense(String foodLicense) {
        this.foodLicense = foodLicense;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClossingHour() {
        return clossingHour;
    }

    public void setClossingHour(String clossingHour) {
        this.clossingHour = clossingHour;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
