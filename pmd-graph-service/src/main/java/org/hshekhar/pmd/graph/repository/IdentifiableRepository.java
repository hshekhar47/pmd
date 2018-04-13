package org.hshekhar.pmd.graph.repository;

import org.hshekhar.pmd.graph.model.identifiable.Identifiable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IdentifiableRepository extends Neo4jRepository<Identifiable, Long>
{
}
