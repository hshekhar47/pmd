package org.hshekhar.pmd.graph.model.identifiable.builder;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;

public class IdentifiableStateBuilder
{
    private IdentifiableState identifiableState;

    private IdentifiableStateBuilder() { this.identifiableState = new IdentifiableState(); }
    private IdentifiableStateBuilder(IdentifiableState identifiableState) { this.identifiableState = identifiableState; }

    public static IdentifiableStateBuilder getBuilder()
    { return new IdentifiableStateBuilder(); }

    public static IdentifiableStateBuilder getBuilder(IdentifiableState identifiableState)
    { return new IdentifiableStateBuilder(identifiableState); }

    public IdentifiableStateBuilder id(Long id)
    {
        assert null == this.identifiableState.getId();
        this.identifiableState.setId(id);
        return this;
    }

    public IdentifiableStateBuilder code(String code)
    { this.identifiableState.setCode(code); return this; }

    public IdentifiableState build() { return this.identifiableState; }
}
