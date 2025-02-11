package restaurant_management.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant_management.example.practice.entity.RestaurantLegalDocuments;

@Repository
public interface RestaurantLegalDocumentsRepository extends JpaRepository<RestaurantLegalDocuments, Integer> {
}
