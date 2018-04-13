package org.hshekhar.pmd.graph.model.product.attribute;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class AttributeState extends IdentifiableState
{
    private Purpose purpose;
    private DataType dataType;
    private boolean required;

    public AttributeState(IdentifiableState identifiableState)
    {
        super(identifiableState);
    }
}
