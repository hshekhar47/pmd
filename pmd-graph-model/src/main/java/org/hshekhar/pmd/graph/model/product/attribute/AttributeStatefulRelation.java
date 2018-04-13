package org.hshekhar.pmd.graph.model.product.attribute;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hshekhar.pmd.graph.StatefulRelation;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RelationshipEntity(type = "HAS_STATE")
public class AttributeStatefulRelation implements StatefulRelation<Attribute, AttributeState>
{
    @JsonIgnore
    @StartNode private Attribute attribute;
    @EndNode private AttributeState attributeState;

    @DateLong private Date effectiveFrom;
    @DateLong private Date effectiveUpTo;
}
