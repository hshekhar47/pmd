package org.hshekhar.pmd.graph.model.contract;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.neo4j.ogm.annotation.NodeEntity;

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
public class ContractStateGraph extends IdentifiableState
{
    private String description;
}
