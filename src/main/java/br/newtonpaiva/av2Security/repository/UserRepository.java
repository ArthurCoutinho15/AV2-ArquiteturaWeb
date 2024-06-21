package br.newtonpaiva.av2Security.repository;


import br.newtonpaiva.av2Security.model.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<UserRequest, String> {
    UserRequest findByUsername(String username);

}
