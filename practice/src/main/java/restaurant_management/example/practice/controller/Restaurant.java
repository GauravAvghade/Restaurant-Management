package restaurant_management.example.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurant_management.example.practice.model.AddOwnerToRestaurant;
import restaurant_management.example.practice.model.request.RestaurantRequest;
import restaurant_management.example.practice.model.response.RestaurantsResponse;
import restaurant_management.example.practice.service.implementations.RestaurantServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class Restaurant {

    private final RestaurantServicesImpl restaurantService;
    Restaurant(final RestaurantServicesImpl restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestaurants() {
        try {
            List<RestaurantsResponse> restaurants = this.restaurantService.getAllRestaurants();
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch restaurants: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRequest registerRestaurantRequest) {
        try{
            this.restaurantService.registerRestaurant(registerRestaurantRequest);
            return new ResponseEntity<>("saved" , HttpStatus.OK);
        }catch(Error err){
            return new ResponseEntity<>( err.toString() , HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/addOwner")
    public boolean addOwnerToRestaurant(@RequestBody AddOwnerToRestaurant request) {
        return this.restaurantService.addOwnerToRestaurant(request.getRestaurantId(), request.getOwnerId());
    }


}