package sn.ucad.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.ucad.covid19.entities.Cas;

import java.util.List;

@Repository
public interface ICas extends JpaRepository<Cas,Long> {
    @Query("select c from Cas c where c.ville =:ville")
    List<Cas> findAllByVille(@Param("ville") String ville);
     @Query("select c from Cas c where c.quartier =:quartier")
    List<Cas> findAllByQuartier(@Param("quartier") String quartier);
    @Query("select c from Cas c where c.id=:id")
    public Cas getById(@Param("id") Long id);
}
