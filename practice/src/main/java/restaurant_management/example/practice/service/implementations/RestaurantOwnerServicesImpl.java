package restaurant_management.example.practice.service.implementations;

import org.springframework.stereotype.Service;
import restaurant_management.example.practice.entity.RestaurantOwner;
import restaurant_management.example.practice.model.request.OwnerRequest;
import restaurant_management.example.practice.model.response.OwnerResponse;
import restaurant_management.example.practice.repository.RestaurantOwnerRepository;
import restaurant_management.example.practice.service.RestaurantOwnerServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantOwnerServicesImpl implements RestaurantOwnerServices {

    private final RestaurantOwnerRepository restaurantOwnerRepository;

    RestaurantOwnerServicesImpl(RestaurantOwnerRepository restaurantOwnerRepository){
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }

    private RestaurantOwner mapDTOToEntity(OwnerRequest OwnerRequest){
        RestaurantOwner restaurantOwner = new RestaurantOwner();
        restaurantOwner.setFirstName(OwnerRequest.getFirstName());
        restaurantOwner.setSecondName(OwnerRequest.getSecondName());
        restaurantOwner.setLastName(OwnerRequest.getLastName());
        restaurantOwner.setCountryCode(OwnerRequest.getCountryCode());
        restaurantOwner.setMobileNo(OwnerRequest.getMobileNo());
        restaurantOwner.setEmail(OwnerRequest.getEmail());
        restaurantOwner.setGovernmentId(OwnerRequest.getGovernmentId());
        restaurantOwner.setGovernmentIdType(RestaurantOwner.GovernmentIdType.valueOf(OwnerRequest.getGovernmentIdType()));
        restaurantOwner.setPassword(OwnerRequest.getPassword());
        return restaurantOwner;
    }

    @Override
    public boolean registerOwner(OwnerRequest registerOwnerRequest){
        RestaurantOwner restaurantOwner = mapDTOToEntity(registerOwnerRequest);
        RestaurantOwner response = this.restaurantOwnerRepository.save(restaurantOwner);
        if(response.equals(null)){
            return false;
        }
        return true;
    }

    private List<OwnerResponse> mapEntityToDTO(List<RestaurantOwner> owners){
        List<OwnerResponse> ownerResponses = new ArrayList<OwnerResponse>();
        for(RestaurantOwner owner : owners){
            OwnerResponse ownerResponse = new OwnerResponse();
            ownerResponse.setFirstName(owner.getFirstName());
            ownerResponse.setSecondName(owner.getSecondName());
            ownerResponse.setLastName(owner.getLastName());
            ownerResponse.setCountryCode(owner.getCountryCode());
            ownerResponse.setMobileNo(owner.getMobileNo());
            ownerResponse.setGovernmentIdType(owner.getGovernmentIdType().toString());
            ownerResponse.setGovernmentId(owner.getGovernmentId());
            ownerResponse.setEmail(owner.getEmail());
            ownerResponse.setOwnerId(owner.getOwnerId());
            ownerResponses.add(ownerResponse);
        }
        return ownerResponses;
    }

    @Override
    public List<OwnerResponse> getAllOwner(){
        List<RestaurantOwner> owners = restaurantOwnerRepository.findAll();
        List<OwnerResponse> ownersList = mapEntityToDTO(owners);
        return ownersList;
    }

    private OwnerResponse mapEntityToResponse(RestaurantOwner owner) {
        OwnerResponse ownerResponse = new OwnerResponse();
        ownerResponse.setOwnerId(owner.getOwnerId());
        ownerResponse.setFirstName(owner.getFirstName());
        ownerResponse.setSecondName(owner.getSecondName());
        ownerResponse.setLastName(owner.getLastName());
        ownerResponse.setCountryCode(owner.getCountryCode());
        ownerResponse.setMobileNo(owner.getMobileNo());
        ownerResponse.setEmail(owner.getEmail());
        ownerResponse.setGovernmentIdType(owner.getGovernmentIdType().name());
        ownerResponse.setGovernmentId(owner.getGovernmentId());
        return ownerResponse;
    }

    @Override
    public OwnerResponse getOwner(String ownerId){
        try {
            Integer id = Integer.parseInt(ownerId);
            return restaurantOwnerRepository.findById(id).map(this::mapEntityToResponse)
                    .orElseThrow(() -> new IllegalArgumentException("Owner not found for ID: " + ownerId));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid owner ID: " + ownerId, e);
        }
    }
}
