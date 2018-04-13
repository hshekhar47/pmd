package org.hshekhar.pmd.graph.model.product;

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
@RelationshipEntity(type = "HAS_VERSION")
public class ProductStatefulRelation implements StatefulRelation<Product, ProductState>
{
    private Long id;

    @JsonIgnore
    @StartNode
    private Product product;

    @EndNode
    private ProductState productState;

    @DateLong
    private Date effectiveFrom;

    @DateLong
    private Date effectiveUpTo;
}
