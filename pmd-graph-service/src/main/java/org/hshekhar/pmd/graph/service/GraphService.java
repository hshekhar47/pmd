package org.hshekhar.pmd.graph.service;

import java.util.List;
import java.util.Optional;

public interface GraphService<T>
{
    T save(T entity);

    Optional<T> findOneById(Long id);
    List<T> find(int pageIndex, int pageSize);
}
