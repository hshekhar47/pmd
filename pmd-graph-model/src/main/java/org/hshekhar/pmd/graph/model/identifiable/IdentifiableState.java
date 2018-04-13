package org.hshekhar.pmd.graph.model.identifiable;

import org.hshekhar.pmd.graph.StateGraphNode;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.AccessLevel;
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
public class IdentifiableState implements StateGraphNode
{
    private Long id;

    @Index(unique = true)
    private String code;

    public IdentifiableState(IdentifiableState identifiableState)
    {
        this.id = identifiableState.getId();
        this.code = identifiableState.getCode();
    }
}
