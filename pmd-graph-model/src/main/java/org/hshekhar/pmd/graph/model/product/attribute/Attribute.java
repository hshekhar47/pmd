package org.hshekhar.pmd.graph.model.product.attribute;

import java.util.Set;

import org.hshekhar.pmd.graph.StatefulGraphNode;
import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Attribute extends Identifiable implements StatefulGraphNode<AttributeStatefulRelation>
{
    private Name name;

    @Relationship(type = "HAS_STATE")
    private Set<AttributeStatefulRelation> states;

    public Attribute(Identifiable identifiable)
    {
        super(identifiable);
    }
}
