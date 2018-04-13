package org.hshekhar.pmd.graph;

import java.util.Date;

public interface StatefulRelation<V extends StatefulGraphNode, S  extends StateGraphNode>
{
    default boolean isActive(Date date)
    {
       return getEffectiveFrom().compareTo(date) * date.compareTo(getEffectiveUpTo()) >= 0;
    }

    Date getEffectiveFrom();
    Date getEffectiveUpTo();
}
