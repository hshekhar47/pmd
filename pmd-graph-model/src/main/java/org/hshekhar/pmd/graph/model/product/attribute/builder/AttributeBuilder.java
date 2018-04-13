package org.hshekhar.pmd.graph.model.product.attribute.builder;

import java.util.HashSet;
import java.util.Set;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.product.attribute.Attribute;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeStatefulRelation;
import org.hshekhar.pmd.graph.model.product.attribute.Name;

public class AttributeBuilder
{
    private Attribute attribute;

    private AttributeBuilder()
    {
        this.attribute = new Attribute();
    }

    private AttributeBuilder(Identifiable identifiable)
    {
        this.attribute = new Attribute(identifiable);
    }

    private AttributeBuilder(Attribute attribute)
    {
        this.attribute = attribute;
    }

    public static AttributeBuilder getBuilder()
    {
        return new AttributeBuilder();
    }

    public static AttributeBuilder getBuilder(Identifiable identifiable)
    {
        return new AttributeBuilder(identifiable);
    }

    public static AttributeBuilder getBuilder(Attribute attribute)
    {
        return new AttributeBuilder(attribute);
    }

    public AttributeBuilder name(Name name)
    {
        this.attribute.setName(name);
        return this;
    }

    public AttributeBuilder states(Set<AttributeStatefulRelation> attributeStatefulRelations)
    {
        this.attribute.setStates(attributeStatefulRelations);
        return this;
    }

    public AttributeBuilder addStatefulRelation(AttributeStatefulRelation attributeStatefulRelation)
    {
        if (null == this.attribute.getStates())
        {
            this.attribute.setStates(new HashSet<>());
        }
        this.attribute.getStates().add(attributeStatefulRelation);

        return this;
    }

    public Attribute build() { return this.attribute; }

}
