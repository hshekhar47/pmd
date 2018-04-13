package org.hshekhar.pmd.graph.repository;

import org.hshekhar.pmd.graph.model.version.Version;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface VersionRepository extends Neo4jRepository<Version, Long>
{
    /*
    @Query("WITH {timestamp} as today MATCH(v:Version) WHERE v.effectiveFrom < today AND today < v.effectiveUpTo RETURN v")
    Version findOneWithTimestamp(@Param("timestamp") Long timestamp);

    @Query("MATCH (v:Version) WITH MIN(v.effectiveFrom) as origin MATCH(v:Version {effectiveFrom: origin}) RETURN v")
    Version findFirstOne();

    @Query("MATCH (v:Version) WITH MAX(v.effectiveFrom) as origin MATCH(v:Version {effectiveFrom: origin}) RETURN v")
    Version findLastOne();
    */

    //Version findOneByTitle(@Param("title") String title);
}
