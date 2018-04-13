package org.hshekhar.pmd.graph.model.product.attribute.builder;

import java.util.Date;
import java.util.HashSet;

import org.hshekhar.pmd.graph.model.product.attribute.Attribute;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeState;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeStatefulRelation;

public class AttributeStatefulRelationBuilder
{
    private AttributeStatefulRelation relation;

    private AttributeStatefulRelationBuilder()
    {
        this.relation = new AttributeStatefulRelation();
    }

    public static AttributeStatefulRelationBuilder getBuilder()
    {
        return new AttributeStatefulRelationBuilder();
    }

    public AttributeStatefulRelationBuilder attribute(Attribute attribute)
    {
        this.relation.setAttribute(attribute);
        return this;
    }

    public AttributeStatefulRelationBuilder attributeState(AttributeState attributeState)
    {
        this.relation.setAttributeState(attributeState);
        return this;
    }

    public AttributeStatefulRelationBuilder effectiveFrom(Date effectiveFrom)
    {
        this.relation.setEffectiveFrom(effectiveFrom);
        return this;
    }

    public AttributeStatefulRelationBuilder effectiveupTo(Date effectiveUpTo)
    {
        this.relation.setEffectiveUpTo(effectiveUpTo);
        return this;
    }

    public AttributeStatefulRelation build()
    {
        return this.relation;
    }
}
