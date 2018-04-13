package org.hshekhar.pmd.graph.model.identifiable;

import org.hshekhar.pmd.graph.GraphNode;
import org.neo4j.ogm.annotation.Index;
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
public class Identifiable implements GraphNode
{
    private Long id;

    @Index(unique = true)
    private String code;

    public Identifiable(Identifiable identifiable)
    {
        this.id = identifiable.getId();
        this.code = identifiable.getCode();
    }
}
