package org.hshekhar.pmd.graph.service;

import java.util.List;
import java.util.Optional;

public interface VersionedGraphService<T> extends GraphService<T>
{
    Optional<T> findOneByIdInVersion(Long versionId, Long id);
    List<T> findInVersion(Long versionId, int pageIndex, int pageSize);
}
