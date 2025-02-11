package restaurant_management.example.practice.model;

public class AddOwnerToRestaurant {
    public AddOwnerToRestaurant() {
    }

    public AddOwnerToRestaurant(String restaurantId, String ownerId) {
        this.restaurantId = restaurantId;
        this.ownerId = ownerId;
    }

    private String restaurantId;
    private String ownerId;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
