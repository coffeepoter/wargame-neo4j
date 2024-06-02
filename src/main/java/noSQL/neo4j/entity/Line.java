package noSQL.neo4j.entity;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter
public class Line {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String value;

    @TargetNode
    private User user;
}
