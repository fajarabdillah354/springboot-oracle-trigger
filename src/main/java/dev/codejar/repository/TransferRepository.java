package dev.codejar.repository;

import dev.codejar.entity.Rekening;
import dev.codejar.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findByPengirim(Rekening rekening);


}
