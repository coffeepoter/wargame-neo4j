package noSQL.neo4j.repository;

import noSQL.neo4j.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class UserRepository {

    private final ReactiveNeo4jOperations neo4jOperations;

    @Autowired
    public UserRepository(ReactiveNeo4jOperations neo4jOperations){
        this.neo4jOperations = neo4jOperations;
    }

    public Flux<User> findOneByName(String name) {
        String cypher = "MATCH (u:User) WHERE u.name = '" + name + "' RETURN u";
        return neo4jOperations.findAll(cypher, User.class);
    }

    public Flux<User> findByValue(String value) {
        String cypher = value;
        return neo4jOperations.findAll(cypher, User.class);
    }

}
