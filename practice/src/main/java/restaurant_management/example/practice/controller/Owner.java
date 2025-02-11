package restaurant_management.example.practice.controller;

import org.springframework.web.bind.annotation.*;
import restaurant_management.example.practice.model.request.OwnerRequest;
import restaurant_management.example.practice.model.response.OwnerResponse;
import restaurant_management.example.practice.service.implementations.RestaurantOwnerServicesImpl;

import java.util.List;

@RestController()
@RequestMapping("/owner")
public class Owner {
    private final RestaurantOwnerServicesImpl restaurantOwnerServicesImpl;
    Owner(RestaurantOwnerServicesImpl restaurantOwnerServicesImpl){
        this.restaurantOwnerServicesImpl = restaurantOwnerServicesImpl;
    }

    @PostMapping("/registerOwner")
    public boolean postMethodName(@RequestBody OwnerRequest entity) {
        boolean response = restaurantOwnerServicesImpl.registerOwner(entity);
        return response;
    }

    @GetMapping("/getAllOwners")
    public List<OwnerResponse> getAllOwners() {
        return restaurantOwnerServicesImpl.getAllOwner();
    }

    @GetMapping("/getOwnerDetails")
    public OwnerResponse getOwner(@RequestParam String param) {
        return restaurantOwnerServicesImpl.getOwner(param);
    }

}
