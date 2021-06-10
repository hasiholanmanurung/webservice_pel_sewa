package com.amartek.pelanggan.repository;

import java.util.List;
import com.amartek.pelanggan.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {

    java.util.Optional<Pelanggan> findByKODEPEL(String kodepel);

    List<Pelanggan> findByEMAILContainsIgnoreCase(String email);

    List<Pelanggan> findByKODEPELContainsIgnoreCase(String kodepel);

    List<Pelanggan> findByNAMAContainsIgnoreCase(String nama);

    
}
