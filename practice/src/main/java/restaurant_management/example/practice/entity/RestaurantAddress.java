package restaurant_management.example.practice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurantAddress")
public class RestaurantAddress {
    public RestaurantAddress() {
    }

    public RestaurantAddress(Integer addressId, Restaurant restaurant, String addressLine1, String addressLine2, String city, String state, String country, String pinCode, List<RestaurantContact> contacts, List<RestaurantLegalDocuments> legalDocuments) {
        this.addressId = addressId;
        this.restaurant = restaurant;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.contacts = contacts;
        this.legalDocuments = legalDocuments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Integer addressId;

    @ManyToOne
    @JoinColumn(name="restroId", nullable = false)
    private Restaurant restaurant;

    @Column(name = "addressLine1", length = 200, nullable = false )
    private String addressLine1;

    @Column(name = "addressLine2", length = 200, nullable = true )
    private String addressLine2;

    @Column(name = "city", length = 50, nullable = false )
    private String city;

    @Column(name = "state", length = 50, nullable = false )
    private String state;

    @Column(name = "country", length = 50, nullable = false )
    private String country;

    @Column(name = "pinCode", length = 10, nullable = false )
    private String pinCode;

    @OneToMany(mappedBy = "addressId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantContact> contacts;

    @OneToMany(mappedBy = "addressId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantLegalDocuments> legalDocuments;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public List<RestaurantContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<RestaurantContact> contacts) {
        this.contacts = contacts;
    }

    public List<RestaurantLegalDocuments> getLegalDocuments() {
        return legalDocuments;
    }

    public void setLegalDocuments(List<RestaurantLegalDocuments> legalDocuments) {
        this.legalDocuments = legalDocuments;
    }
}
