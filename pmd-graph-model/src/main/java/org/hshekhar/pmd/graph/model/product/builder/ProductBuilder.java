package org.hshekhar.pmd.graph.model.product.builder;

import java.util.Set;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.product.Product;
import org.hshekhar.pmd.graph.model.product.ProductStatefulRelation;

public class ProductBuilder
{
    private Product product;

    private ProductBuilder()
    {
        this.product = new Product();
    }

    private ProductBuilder(Identifiable identifiable)
    {
        this.product = new Product(identifiable);
    }

    private ProductBuilder(Product product)
    {
        this.product = product;
    }

    public static ProductBuilder getBuilder()
    {
        return new ProductBuilder();
    }

    public static ProductBuilder getBuilder(Identifiable identifiable)
    {
        return new ProductBuilder(identifiable);
    }

    public static ProductBuilder getBuilder(Product product)
    {
        return new ProductBuilder(product);
    }

    public ProductBuilder state(Set<ProductStatefulRelation> productStatefulRelations)
    {
        this.state(productStatefulRelations);
        return this;
    }

    public Product build()
    {
        return this.product;
    }

}
