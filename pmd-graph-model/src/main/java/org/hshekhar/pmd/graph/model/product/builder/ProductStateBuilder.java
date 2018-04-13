package org.hshekhar.pmd.graph.model.product.builder;

import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.product.ProductState;

public class ProductStateBuilder
{
    private ProductState productState;

    private ProductStateBuilder()
    {
        this.productState = new ProductState();
    }

    private ProductStateBuilder(IdentifiableState identifiableState)
    {
        this.productState = new ProductState(identifiableState);
    }

    private ProductStateBuilder(ProductState productState)
    {
        this.productState = productState;
    }

    public static ProductStateBuilder getBuilder()
    {
        return new ProductStateBuilder();
    }

}
