package restaurant_management.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant_management.example.practice.entity.RestaurantOwnerRelationship;

@Repository
public interface RestaurantOwnerRelationshipRepository extends JpaRepository<RestaurantOwnerRelationship, Integer> {
}
