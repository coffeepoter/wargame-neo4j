package noSQL.neo4j.service;

import noSQL.neo4j.entity.User;
import noSQL.neo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> findOneByName(String name) {
        return userRepository.findOneByName(name);
    }

    public Flux<User> findByValue(String value) {
        return userRepository.findByValue(value);
    }

}
