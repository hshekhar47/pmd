package org.hshekhar.pmd.graph.model.product;

import java.util.Set;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.product.attribute.Attribute;
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
public class ProductState extends IdentifiableState
{
    @Relationship(type = "HAS_ATTRIBUTE")
    private Set<Attribute> attributes;

    public ProductState(IdentifiableState identifiableState)
    {
        super(identifiableState);
    }
}
