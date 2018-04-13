package org.hshekhar.pmd.api.config;

import org.hshekhar.pmd.graph.repository.VersionRepository;
import org.hshekhar.pmd.graph.service.VersionService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig
{
    @Bean
    public VersionService versionService(VersionRepository versionRepository)
    {
        return new VersionService(versionRepository);
    }
}
