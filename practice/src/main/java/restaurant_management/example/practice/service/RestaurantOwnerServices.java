package restaurant_management.example.practice.service;

import org.springframework.stereotype.Service;
import restaurant_management.example.practice.model.request.OwnerRequest;
import restaurant_management.example.practice.model.response.OwnerResponse;

import java.util.List;

public interface RestaurantOwnerServices {
    public boolean registerOwner(OwnerRequest registerOwnerRequest);
    public List<OwnerResponse> getAllOwner();
    public OwnerResponse getOwner(String ownerId);
}
