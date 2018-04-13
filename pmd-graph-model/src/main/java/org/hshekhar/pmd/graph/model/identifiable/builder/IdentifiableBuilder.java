package org.hshekhar.pmd.graph.model.identifiable.builder;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;

public class IdentifiableBuilder
{
    private Identifiable identifiable;

    private IdentifiableBuilder() { this.identifiable = new Identifiable(); }
    private IdentifiableBuilder(Identifiable identifiable) { this.identifiable = identifiable; }

    public static IdentifiableBuilder getBuilder()
    { return new IdentifiableBuilder(); }

    public static IdentifiableBuilder getBuilder(Identifiable identifiable)
    { return new IdentifiableBuilder(identifiable); }

    public IdentifiableBuilder id(Long id) { this.identifiable.setId(id); return this; }
    public IdentifiableBuilder code(String code) { this.identifiable.setCode(code); return this; }
    public Identifiable build() { return this.identifiable; }
}
