package restaurant_management.example.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurantOwnerRelationship")
public class RestaurantOwnerRelationship {
    public RestaurantOwnerRelationship() {
    }

    public RestaurantOwnerRelationship(int restaurantOwnerRelationshipId, Restaurant restaurantId, RestaurantOwner restaurantOwnerId) {
        this.restaurantOwnerRelationshipId = restaurantOwnerRelationshipId;
        this.restaurantId = restaurantId;
        this.restaurantOwnerId = restaurantOwnerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantOwnerRelationshipId")
    private int restaurantOwnerRelationshipId;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurantId;

    @ManyToOne
    @JoinColumn(name = "restaurantOwnerId")
    private RestaurantOwner restaurantOwnerId;

    public int getRestaurantOwnerRelationshipId() {
        return restaurantOwnerRelationshipId;
    }

    public void setRestaurantOwnerRelationshipId(int restaurantOwnerRelationshipId) {
        this.restaurantOwnerRelationshipId = restaurantOwnerRelationshipId;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public RestaurantOwner getRestaurantOwnerId() {
        return restaurantOwnerId;
    }

    public void setRestaurantOwnerId(RestaurantOwner restaurantOwnerId) {
        this.restaurantOwnerId = restaurantOwnerId;
    }
}
