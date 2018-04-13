package org.hshekhar.pmd.graph.model.contract;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hshekhar.pmd.graph.StatefulRelation;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RelationshipEntity(type = "HAS_STATE")
public class ContractStatefulRelation implements StatefulRelation<Contract, ContractStateGraph>
{
    @JsonIgnore
    @StartNode private Contract contract;
    @EndNode private ContractStateGraph contractState;

    @DateLong private Date effectiveFrom;
    @DateLong private Date effectiveUpTo;
}
