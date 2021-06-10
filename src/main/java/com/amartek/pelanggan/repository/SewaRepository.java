package com.amartek.pelanggan.repository;

import java.util.List;
import java.util.Optional;

import com.amartek.pelanggan.entity.Sewa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SewaRepository extends JpaRepository<Sewa, Long> {

    Optional<Sewa> findByISBN(String isbn);

	// join untuk menampilkan data pelanggan dan data buku
    @Query(value =
        "SELECT "
        + " s.id id, s.tglsewa tglsewa, s.lamasewa lamasewa, s.keterangan keterangan, "
        + " s.isbn, b.judul, b.pengarang, "
        + " s.pelangganid, p.kodepel, p.nama, p.telp, p.email "
        + "FROM Sewa s "
        + "INNER JOIN Pelanggan p ON s.pelangganid=p.id "
        + "INNER JOIN Buku b ON s.isbn=b.isbn "
        + "WHERE s.id=:idSewa", nativeQuery = true)


    List<Object[]> getSewaDetailById(@Param("idSewa") Long idSewa);
    
}
