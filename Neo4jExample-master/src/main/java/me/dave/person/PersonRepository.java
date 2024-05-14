package me.dave.person;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (u:Person)<-[r:has]-(m:Role2) RETURN u,r,m")
    Collection<Person> getAllPerson();
}
