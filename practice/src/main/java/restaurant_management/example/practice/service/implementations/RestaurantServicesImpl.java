package restaurant_management.example.practice.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import restaurant_management.example.practice.entity.*;
import restaurant_management.example.practice.model.request.RestaurantRequest;
import restaurant_management.example.practice.model.response.RestaurantsResponse;
import restaurant_management.example.practice.repository.RestaurantOwnerRelationshipRepository;
import restaurant_management.example.practice.repository.RestaurantOwnerRepository;
import restaurant_management.example.practice.repository.RestaurantRepository;
import restaurant_management.example.practice.service.RestaurantServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServicesImpl implements RestaurantServices {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestaurantOwnerRelationshipRepository restaurantOwnerRelationshipRepository;

    public RestaurantServicesImpl(RestaurantRepository restaurantRepository , RestaurantOwnerRelationshipRepository restaurantOwnerRelationshipRepository, RestaurantOwnerRepository restaurantOwnerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantOwnerRelationshipRepository = restaurantOwnerRelationshipRepository;
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }

    private Restaurant mapDTOToEntity(RestaurantRequest registerRestaurantRequest){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(null);
        restaurant.setRestaurantName(registerRestaurantRequest.getRestaurantName());
        restaurant.setMobileNo(registerRestaurantRequest.getMobileNo());
        restaurant.setRestaurantType(
                        "Veg".equalsIgnoreCase(registerRestaurantRequest.getRestroType())
                                ? Restaurant.RestroType.Veg
                                : Restaurant.RestroType.NonVeg );
        restaurant.setSpeciality(registerRestaurantRequest.getSpeciality());
        restaurant.setClosingHours(registerRestaurantRequest.getClossingHour());
        restaurant.setOpeningHours(registerRestaurantRequest.getClossingHour());
        restaurant.setLogo(registerRestaurantRequest.getLogo());
        restaurant.setServiceType(registerRestaurantRequest.getServiceType());

        RestaurantAddress restaurantAddress = new RestaurantAddress();
        restaurantAddress.setAddressLine1(registerRestaurantRequest.getAddressLine1());
        restaurantAddress.setAddressLine2(registerRestaurantRequest.getAddressLine2());
        restaurantAddress.setCity(registerRestaurantRequest.getCity());
        restaurantAddress.setState(registerRestaurantRequest.getState());
        restaurantAddress.setCountry(registerRestaurantRequest.getCountry());
        restaurantAddress.setRestaurant(restaurant);
        restaurantAddress.setPinCode(registerRestaurantRequest.getPincode());

        RestaurantContact restaurantContact = new RestaurantContact();
        restaurantContact.setAddressId(restaurantAddress);
        restaurantContact.setMobileNo(registerRestaurantRequest.getMobileNo());
        restaurantContact.setEmail(registerRestaurantRequest.getEmail());

        RestaurantLegalDocuments restaurantLegalDocuments = new RestaurantLegalDocuments();
        restaurantLegalDocuments.setAddressId(restaurantAddress);
        restaurantLegalDocuments.setFoodLicence(registerRestaurantRequest.getFoodLicense());

        restaurantAddress.setContacts(List.of(restaurantContact));
        restaurantAddress.setLegalDocuments(List.of(restaurantLegalDocuments));
        restaurant.setBaseAddress(List.of(restaurantAddress));
        return restaurant;
    }

    @Override
    public boolean registerRestaurant(RestaurantRequest registerRestaurantRequest){
        Restaurant restaurant = mapDTOToEntity(registerRestaurantRequest);
        Restaurant persistedData = restaurantRepository.save(restaurant);

        if(ObjectUtils.isEmpty(persistedData)){
            return false;
        }
        return true;
    }

    public List<RestaurantsResponse> mapEnityToDTO(List<Restaurant> restaurants) {
        List<RestaurantsResponse> restaurantResponseList = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            RestaurantAddress address = null;
            if (restaurant.getBaseAddress() != null && !restaurant.getBaseAddress().isEmpty()) {
                address = restaurant.getBaseAddress().get(0);
            }

            String addressLine1 = address != null ? address.getAddressLine1() : "N/A";
            String addressLine2 = address != null ? address.getAddressLine2() : "N/A";
            String city = address != null ? address.getCity() : "N/A";
            String state = address != null ? address.getState() : "N/A";
            String country = address != null ? address.getCountry() : "N/A";
            String pincode = address != null ? address.getPinCode() : "N/A";

            List<RestaurantContact> contacts = address != null ? address.getContacts() : null;
            String mobileNo = "N/A";
            String email = "N/A";
            if (contacts != null && !contacts.isEmpty()) {
                RestaurantContact contact = contacts.get(0);
                mobileNo = contact.getMobileNo() ;
                email = contact.getEmail();
            }

            List<RestaurantLegalDocuments> legalDocuments = address != null ? address.getLegalDocuments() : null;
            String legalDocumentDetails = "N/A";
            if (legalDocuments != null && !legalDocuments.isEmpty()) {
                RestaurantLegalDocuments doc = legalDocuments.get(0);
                legalDocumentDetails = doc.getFoodLicence() != null ? doc.getFoodLicence() : "N/A";
            }
            RestaurantsResponse restaurantsResponse = new RestaurantsResponse();
            restaurantsResponse.setRestaurantName(restaurant.getRestaurantName());
            restaurantsResponse.setMobileNo(mobileNo);
            restaurantsResponse.setEmail(email);
            restaurantsResponse.setAddressLine1(addressLine1);
            restaurantsResponse.setAddressLine2(addressLine2);
            restaurantsResponse.setCity(city);
            restaurantsResponse.setState(state);
            restaurantsResponse.setCountry(country);
            restaurantsResponse.setPincode(pincode);
            restaurantsResponse.setRestroType(restaurant.getRestaurantType().name());
            restaurantsResponse.setSpeciality(restaurant.getSpeciality());
            restaurantsResponse.setFoodLicense(legalDocumentDetails);
            restaurantsResponse.setServiceType(restaurant.getServiceType());
            restaurantsResponse.setOpeningHour(restaurant.getOpeningHours());
            restaurantsResponse.setClossingHour(restaurant.getClosingHours());
            restaurantsResponse.setLogo(restaurant.getLogo());
            restaurantResponseList.add(restaurantsResponse);
        }

        return restaurantResponseList;
    }

    @Override
    public List<RestaurantsResponse> getAllRestaurants() {
        List<Restaurant> restaurantDetails = restaurantRepository.findAll();
        return mapEnityToDTO(restaurantDetails);
    }

    @Override
    public boolean addOwnerToRestaurant(String restaurantId, String ownerId){
        try{
            Integer rId = Integer.parseInt(restaurantId);
            Integer oId = Integer.parseInt(ownerId);
            Restaurant restaurant = restaurantRepository.findById(rId).orElse(null);
            RestaurantOwner restaurantOwner = restaurantOwnerRepository.findById(oId).orElse(null);
            if(restaurant.equals(null) || restaurantOwner.equals(null)){
                return false;
            }
            RestaurantOwnerRelationship restaurantOwnerRelationship = new RestaurantOwnerRelationship();
            restaurantOwnerRelationship.setRestaurantId(restaurant);
            restaurantOwnerRelationship.setRestaurantOwnerId(restaurantOwner);

            if(restaurantOwnerRelationship.equals(null)){
                return false;
            }
            RestaurantOwnerRelationship response = restaurantOwnerRelationshipRepository.save(restaurantOwnerRelationship);
            if(response.equals(null)){
                return false;
            }
            return true;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid owner ID: " + ownerId, e);
        }
    }

}
