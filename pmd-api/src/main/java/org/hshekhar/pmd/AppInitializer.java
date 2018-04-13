package org.hshekhar.pmd;

import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.hshekhar.pmd.graph.model.identifiable.IdentifiableState;
import org.hshekhar.pmd.graph.model.identifiable.builder.IdentifiableBuilder;
import org.hshekhar.pmd.graph.model.identifiable.builder.IdentifiableStateBuilder;
import org.hshekhar.pmd.graph.model.product.Product;
import org.hshekhar.pmd.graph.model.product.ProductState;
import org.hshekhar.pmd.graph.model.product.attribute.Attribute;
import org.hshekhar.pmd.graph.model.product.attribute.AttributeState;
import org.hshekhar.pmd.graph.model.product.attribute.DataType;
import org.hshekhar.pmd.graph.model.product.attribute.Name;
import org.hshekhar.pmd.graph.model.product.attribute.Purpose;
import org.hshekhar.pmd.graph.model.product.attribute.builder.AttributeBuilder;
import org.hshekhar.pmd.graph.model.product.attribute.builder.AttributeStateBuilder;
import org.hshekhar.pmd.graph.model.product.builder.ProductBuilder;
import org.hshekhar.pmd.graph.model.version.Version;
import org.hshekhar.pmd.graph.model.version.builder.VersionBuilder;
import org.hshekhar.pmd.graph.repository.IdentifiableRepository;
import org.hshekhar.pmd.graph.service.VersionService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer
{
    private static Logger LOGGER = LoggerFactory.getLogger(AppInitializer.class);

    @Autowired
    private IdentifiableRepository identifiableRepository;

    @Autowired
    private VersionService versionService;

    @PostConstruct
    public void doInitialization()
    {
        identifiableRepository.deleteAll();
        LOGGER.info("Database cleanUp Done");
        LOGGER.info("Enter: doInitialization()---------------------------------------");
        doSetUpVersion();
        doSetUpProducts();

        LOGGER.info("Exit: doInitialization()---------------------------------------");
    }

    private Product getProduct(String code)
    {
        Identifiable id = IdentifiableBuilder.getBuilder().code(code).build();
        return ProductBuilder.getBuilder(id).state(new HashSet<>()).build();
    }

    private AttributeState

    private ProductState getProductAttribute(Product product,
            String code,
            Name name,
            Purpose purpose,
            DataType dataType,
            boolean isRequired)
    {
        Identifiable id = IdentifiableBuilder.getBuilder().code(code).build();
        Attribute productAttribute = AttributeBuilder.getBuilder(id)
                                          .name(name)
                                          .states(new HashSet<>())
                                          .build();

        IdentifiableState idState = IdentifiableStateBuilder.getBuilder().code()
    }

    private void doProductAddition(Version version, Product product)
    {

    }

    private void doSetUpProducts()
    {

    }

    private void doSetUpVersion()
    {
        DateTime dt2015 = new DateTime()
                .withDate(2015, 1, 1)
                .withTime(0, 0, 0, 0);

        Version v1 = VersionBuilder.getBuilder(IdentifiableBuilder.getBuilder().code("v1").build())
                                   .effectiveFrom(dt2015.withDayOfYear(1).toDate())
                                   .build();
        v1 = versionService.save(v1);
        LOGGER.info("Version {} is created", v1);

        Version v2 = VersionBuilder.getBuilder(IdentifiableBuilder.getBuilder().code("v2").build())
                                   .effectiveFrom(dt2015.plusYears(1).toDate())
                                   .previous(v1)
                                   .build();
        v2 = versionService.save(v2);
        LOGGER.info("Version {} is created", v2);

        Version v3 = VersionBuilder.getBuilder(IdentifiableBuilder.getBuilder().code("v3").build())
                                   .effectiveFrom(dt2015.plusYears(2).toDate())
                                   .previous(v2)
                                   .build();
        v3 = versionService.save(v3);
        LOGGER.info("Version {} is created", v3);

        Version v4 = VersionBuilder.getBuilder(IdentifiableBuilder.getBuilder().code("v4").build())
                                   .effectiveFrom(dt2015.plusYears(3).toDate())
                                   .previous(v3)
                                   .build();
        v4 = versionService.save(v4);
        LOGGER.info("Version {} is created", v4);
    }
}
