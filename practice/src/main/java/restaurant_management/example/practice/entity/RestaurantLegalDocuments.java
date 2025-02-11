package restaurant_management.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurantLegalDocuments")
public class RestaurantLegalDocuments {
    public RestaurantLegalDocuments() {
    }

    public RestaurantLegalDocuments(Integer legalDocumentId, RestaurantAddress addressId, String foodLicence) {
        this.legalDocumentId = legalDocumentId;
        this.addressId = addressId;
        this.foodLicence = foodLicence;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legalDocumentId")
    private Integer legalDocumentId;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private RestaurantAddress addressId;

    @Column(name = "foodLicence",nullable = false,length = 200)
    private String foodLicence;

    public Integer getLegalDocumentId() {
        return legalDocumentId;
    }

    public void setLegalDocumentId(Integer legalDocumentId) {
        this.legalDocumentId = legalDocumentId;
    }

    public RestaurantAddress getAddressId() {
        return addressId;
    }

    public void setAddressId(RestaurantAddress addressId) {
        this.addressId = addressId;
    }

    public String getFoodLicence() {
        return foodLicence;
    }

    public void setFoodLicence(String foodLicence) {
        this.foodLicence = foodLicence;
    }
}
