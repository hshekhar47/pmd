package org.hshekhar.pmd.graph.model.version;

import java.util.Date;

import org.hshekhar.pmd.graph.helper.DateTimeHelper;
import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Version extends Identifiable
{
    @Relationship(type = "PREVIOUS_VERSION")
    private Version previous;

    @DateLong private Date effectiveFrom;
    @DateLong private Date effectiveUpTo;

    public Version(Identifiable identifiable)
    {
        super(identifiable);
    }
}
