package sn.ucad.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ucad.covid19.entities.Cas;
@Repository
public interface ICas extends JpaRepository<Cas,Long> {
}
