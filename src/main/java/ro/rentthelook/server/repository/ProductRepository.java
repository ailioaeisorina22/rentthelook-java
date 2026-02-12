package ro.rentthelook.server.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.rentthelook.server.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //ignores lazy relationship between entities and does a join fetch to bring the images and product sizes
    //lazy - the relationship does not always loading
    @EntityGraph(attributePaths = {"images", "productSizes"})
    List<Product> findByCategory(String category);

    @EntityGraph(attributePaths = {"images", "productSizes"})
    List<Product> findBySubcategory(String subcategory);

    @Override
    @EntityGraph(attributePaths = {"images", "productSizes"})
    Optional<Product> findById(Integer integer);
}
