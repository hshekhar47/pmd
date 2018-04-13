package org.hshekhar.pmd.graph;

import java.util.Set;

public interface StatefulGraphNode<T extends StatefulRelation> extends GraphNode
{
    Set<T> getStates();
}
