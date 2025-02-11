package restaurant_management.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurantContact")
public class RestaurantContact {
    public RestaurantContact() {
    }

    public RestaurantContact(Integer contactId, RestaurantAddress addressId, String mobileNo, String email) {
        this.contactId = contactId;
        this.addressId = addressId;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId")
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "addressId",nullable = false)
    private RestaurantAddress addressId;

    @Column(name = "mobileNo",length = 20,nullable = false,unique = true)
    private String mobileNo;

    @Column(name = "email",length = 50,nullable = false,unique = true)
    private String email;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public RestaurantAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(RestaurantAddress addressId) {
        this.addressId = addressId;
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
}
