package projetospring.sitedevendaquimono.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetospring.sitedevendaquimono.entity.Kimono;
@Repository
public interface KimonoRepository extends JpaRepository<Kimono, UUID>{

}
