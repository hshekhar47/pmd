package org.hshekhar.pmd.graph.service;

import java.util.List;
import java.util.Optional;

import org.hshekhar.pmd.graph.model.version.Version;
import org.hshekhar.pmd.graph.repository.VersionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionService implements GraphService<Version>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(VersionService.class);

    private VersionRepository versionRepository;

    public VersionService(VersionRepository versionRepository)
    {
        this.versionRepository = versionRepository;
    }

    @Override
    public Version save(Version entity)
    {
        return this.versionRepository.save(entity);
    }

    @Override
    public Optional<Version> findOneById(Long id)
    {
        return null;
    }

    @Override
    public List<Version> find(int pageIndex, int pageSize)
    {
        return null;
    }
}
