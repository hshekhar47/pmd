package org.hshekhar.pmd.graph.model.product.attribute.builder;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeState;
import org.hshekhar.pmd.graph.model.product.attribute.DataType;
import org.hshekhar.pmd.graph.model.product.attribute.Purpose;

public class AttributeStateBuilder
{
    private AttributeState attributeState;

    private AttributeStateBuilder()
    {
        this.attributeState = new AttributeState();
    }

    private AttributeStateBuilder(IdentifiableState identifiableState)
    {
        this.attributeState = new AttributeState(identifiableState);
    }

    public static AttributeStateBuilder getBuilder()
    {
        return new AttributeStateBuilder();
    }

    public static AttributeStateBuilder getBuilder(IdentifiableState identifiableState)
    {
        return new AttributeStateBuilder(identifiableState);
    }

    public AttributeStateBuilder purpose(Purpose purpose)
    {
        this.attributeState.setPurpose(purpose);
        return this;
    }

    public AttributeStateBuilder dataType(DataType dataType)
    {
        this.attributeState.setDataType(dataType);
        return this;
    }

    public AttributeStateBuilder required(boolean flag)
    {
        this.attributeState.setRequired(flag);
        return this;
    }

    public AttributeState build()
    {
        return this.attributeState;
    }
}
