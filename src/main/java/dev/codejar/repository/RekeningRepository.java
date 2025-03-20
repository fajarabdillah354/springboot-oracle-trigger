package dev.codejar.repository;

import dev.codejar.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RekeningRepository extends JpaRepository<Rekening, Long> {
    Optional<Rekening> findByNamaNasabah(String nasabah);
}
