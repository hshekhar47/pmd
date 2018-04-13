package org.hshekhar.pmd.graph.model.product;

import java.util.Set;

import org.hshekhar.pmd.graph.StatefulGraphNode;
import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Product extends Identifiable implements StatefulGraphNode<ProductStatefulRelation>
{
    @Relationship(type = "HAS_STATE")
    private Set<ProductStatefulRelation> states;

    public Product(Identifiable identifiable)
    {
        super(identifiable);
    }
}
