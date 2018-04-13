package org.hshekhar.pmd.graph.helper;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.identifiable.builder.IdentifiableBuilder;
import org.hshekhar.pmd.graph.model.identifiable.builder.IdentifiableStateBuilder;
import org.joda.time.DateTime;

public class TestHelper
{
    protected Identifiable getIdentifiableByIdAndCode(Long id, String code)
    {
        return IdentifiableBuilder.getBuilder()
                                  .id(id)
                                  .code(code)
                                  .build();
    }

    protected IdentifiableState getIdentifiableStateByIdAndCode(Long id, String code)
    {
        return IdentifiableStateBuilder.getBuilder()
                                       .id(id)
                                       .code(code)
                                       .build();
    }

    protected DateTime getOriginDateTime()
    {
        return DateTime.now()
                       .withDate(2016, 1, 1)
                       .withTime(0, 0, 0, 0);
    }
}
