package noSQL.neo4j.entity;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Getter
@Node("User")
public class User {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String value;

    @Relationship(type = "LINE", direction = Relationship.Direction.OUTGOING)
    private Set<Line> relationships = new HashSet<>();
}
