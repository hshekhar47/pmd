package org.hshekhar.pmd.graph.model.version;

import java.util.Date;

import org.hshekhar.pmd.graph.helper.DateTimeHelper;
import org.hshekhar.pmd.graph.helper.TestHelper;
import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.version.builder.VersionBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class VersionBuilderTest extends TestHelper
{
    @Test
    public void testDefaultBuilder() throws Exception
    {
        Version version = VersionBuilder.getBuilder().build();
        assertNull("id should be null", version.getId());
        assertNull("code should be null", version.getCode());
        assertNull("effectiveFrom date should be null", version.getEffectiveFrom());
        assertNull("effectiveUpTo date should be null", version.getEffectiveUpTo());
        assertNull("previous version should be nnull", version.getPrevious());
    }

    @Test
    public void testIdentifiableBuilder() throws Exception
    {
        DateTime dateTime = getOriginDateTime();

        Date effectiveStartDateV1 = dateTime.toDate();
        Identifiable identifiableV1 = getIdentifiableByIdAndCode(1L, "v0.0.1");
        Version versionV1 = getVersion(identifiableV1, effectiveStartDateV1, null);

        Date effectiveStartDateV2 = dateTime.plusYears(1).toDate();
        Identifiable identifiableV2 = getIdentifiableByIdAndCode(2L, "v0.0.2");
        Version versionV2 = getVersion(identifiableV2, effectiveStartDateV2, versionV1);

        assertEquals("id should be 2L",
                     identifiableV2.getId(), versionV2.getId());
        assertEquals("code should be v0.0.2",
                     identifiableV2.getCode(), versionV2.getCode());
        assertEquals("effectiveFrom date should match",
                     effectiveStartDateV2, versionV2.getEffectiveFrom());
        assertEquals("previous version should match",
                     versionV1.getId(), versionV2.getPrevious().getId());
        assertEquals("previous version effectiveUpTo should be updated",
                     versionV1.getEffectiveUpTo(), versionV2.getEffectiveFrom());
    }

    @Test
    public void testCopyBuilder() throws Exception
    {
        DateTime dateTime = getOriginDateTime();

        Date effectiveStartDateV1 = dateTime.toDate();
        Identifiable identifiableV1 = getIdentifiableByIdAndCode(1L, "v0.0.1");
        Version versionV1 = getVersion(identifiableV1, effectiveStartDateV1, null);

        Date effectiveStartDateV2 = dateTime.plusYears(1).toDate();
        Identifiable identifiableV2 = getIdentifiableByIdAndCode(2L, "v0.0.2");
        Version versionV2 = getVersion(identifiableV2, effectiveStartDateV2, versionV1);

        Version clonedVersion = VersionBuilder.getBuilder(versionV2).build();

        assertEquals("id should be 2L",
                     versionV2.getId(), clonedVersion.getId());
        assertEquals("code should be v0.0.2",
                     versionV2.getCode(), clonedVersion.getCode());
        assertEquals("effectiveFrom date should match",
                     versionV2.getEffectiveFrom(), clonedVersion.getEffectiveFrom());
        assertEquals("previous version should match",
                     versionV2.getPrevious().getId(), clonedVersion.getPrevious().getId());
        assertEquals("previous version effectiveUpTo should be updated",
                     versionV2.getPrevious().getEffectiveUpTo(), clonedVersion.getPrevious().getEffectiveUpTo());
    }

    @Test
    public void build() throws Exception
    {
        Version version = getVersion(getIdentifiableByIdAndCode(1L, "v0.0.1"),
                                     getOriginDateTime().toDate(),
                                     null);

        assertNotNull("Version instance should be created.", version);
        assertEquals("Title should match.",
                     "v0.0.1", version.getCode());
        assertEquals("Effective from date should match.",
                     "2016-01-01", DateTimeHelper.dateToString(version.getEffectiveFrom()));
    }

    private Version getVersion(Identifiable identifiable, Date v2EffectiveFrom, Version previousVersion )
    {
        return VersionBuilder.getBuilder(identifiable)
                             .effectiveFrom(v2EffectiveFrom)
                             .previous(previousVersion)
                             .build();
    }




}