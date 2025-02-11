package restaurant_management.example.practice.service;

import restaurant_management.example.practice.model.request.RestaurantRequest;
import restaurant_management.example.practice.model.response.RestaurantsResponse;

import java.util.List;

public interface RestaurantServices {
    public boolean registerRestaurant(RestaurantRequest registerRestaurantRequest);
    public List<RestaurantsResponse> getAllRestaurants();
    public boolean addOwnerToRestaurant(String restaurantId, String ownerId);

}
