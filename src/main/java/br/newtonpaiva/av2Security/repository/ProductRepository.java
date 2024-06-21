package br.newtonpaiva.av2Security.repository;


import br.newtonpaiva.av2Security.model.ProductsRequest;
import br.newtonpaiva.av2Security.model.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductsRequest, String> {
    UserRequest findByProductName(String productName);

}
