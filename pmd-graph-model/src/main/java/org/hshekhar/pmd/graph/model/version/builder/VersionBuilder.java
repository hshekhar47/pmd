package org.hshekhar.pmd.graph.model.version.builder;

import java.util.Date;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.version.Version;

public class VersionBuilder
{
    private Version version;

    private VersionBuilder() { this.version = new Version(); }
    private VersionBuilder(Identifiable identifiable) { this.version = new Version(identifiable); }
    private VersionBuilder(Version version) { this.version = version; }

    public static VersionBuilder getBuilder()
    { return new VersionBuilder(); }

    public static VersionBuilder getBuilder(Identifiable identifiable)
    { return new VersionBuilder(identifiable); }

    public static VersionBuilder getBuilder(Version version)
    { return new VersionBuilder(version); }

    public VersionBuilder effectiveFrom(Date fromDate)
    {
        this.version.setEffectiveFrom(fromDate);
        return this;
    }

    public VersionBuilder effectiveUpTo(Date upToDate)
    {
        this.version.setEffectiveUpTo(upToDate);
        return this;
    }

    public VersionBuilder previous(Version version)
    {
        if(null != version)
        {
            assert null != this.version.getEffectiveFrom();
            version.setEffectiveUpTo(this.version.getEffectiveFrom());
            this.version.setPrevious(version);
        }
        return this;
    }

    public Version build()
    {
        return this.version;
    }
}
