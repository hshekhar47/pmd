package org.hshekhar.pmd.graph.model.product.attribute.builder;

import java.util.Date;
import java.util.HashSet;

import org.hshekhar.pmd.graph.helper.TestHelper;
import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.product.attribute.Attribute;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeState;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeStatefulRelation;
import org.hshekhar.pmd.graph.model.product.attribute.DataType;
import org.hshekhar.pmd.graph.model.product.attribute.Name;
import org.hshekhar.pmd.graph.model.product.attribute.Purpose;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AttributeBuilderTest extends TestHelper
{
    @Test
    public void testBuild() throws Exception
    {
        Identifiable identifiable = getIdentifiableByIdAndCode(1L, "P001");
        Attribute attribute = AttributeBuilder.getBuilder(identifiable)
                                              .name(Name.ACTUAL_START_DATE)
                                              .build();

        assertNotNull(attribute);
        assertEquals("Code should match", identifiable.getCode(), attribute.getCode());
        assertEquals("Id should match", identifiable.getId(), attribute.getId());
        assertEquals("Name should match", Name.ACTUAL_START_DATE, attribute.getName());
    }

    @Test
    public void testAddRelation() throws Exception
    {
        Identifiable identifiable = getIdentifiableByIdAndCode(1L, "P001");
        Attribute attribute = AttributeBuilder.getBuilder(identifiable)
                                              .name(Name.ACTUAL_START_DATE)
                                              .states(new HashSet<>())
                                              .build();

        IdentifiableState attrStateId = getIdentifiableStateByIdAndCode(2L, "PS002");
        AttributeState attributeState1 = buildAttributeState(attrStateId, Purpose.DESCRIPTOR, DataType.DATE, true);

        AttributeStatefulRelation relation = buildAttributeStatefulRelation(attribute,
                                                                            attributeState1,
                                                                            getOriginDateTime().toDate());

        attribute.getStates().add(relation);

        assertEquals("Id should match", attrStateId.getId(), attributeState1.getId());
        assertEquals("Code should match", attrStateId.getCode(), attributeState1.getCode());
        assertEquals("Name should match", Name.ACTUAL_START_DATE, attribute.getName());
        assertNotNull("AttributeState should be added", attribute.getStates());
    }

    private AttributeStatefulRelation buildAttributeStatefulRelation(Attribute attribute,
            AttributeState attributeState, Date effectiveFrom)
    {
        return AttributeStatefulRelationBuilder.getBuilder()
                                               .attribute(attribute)
                                               .attributeState(attributeState)
                                               .effectiveFrom(effectiveFrom)
                                               .build();
    }

    private AttributeState buildAttributeState(IdentifiableState attrStateId,
            Purpose purpose,
            DataType dataType,
            boolean isRequired)
    {
        return AttributeStateBuilder.getBuilder(attrStateId)
                                    .purpose(purpose)
                                    .dataType(dataType)
                                    .required(isRequired)
                                    .build();
    }

}