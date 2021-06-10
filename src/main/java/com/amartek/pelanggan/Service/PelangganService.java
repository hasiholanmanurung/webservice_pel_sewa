package com.amartek.pelanggan.Service;

import java.util.List;
import java.util.Optional;

import com.amartek.pelanggan.entity.Pelanggan;
import com.amartek.pelanggan.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
        @Autowired
        private PelangganRepository pelangganRepository;
        public List<Pelanggan> getAll(){
            return pelangganRepository.findAll();
        }   

        public Pelanggan getPelangganById(Long id) {
            return pelangganRepository.findById(id).get();
        }
                
        public List<Pelanggan> getByEMAIL(String email){
            return pelangganRepository.findByEMAILContainsIgnoreCase(email);
        }

        public List<Pelanggan> getByNAMA(String nama){
            // return pelangganRepository.findByNAMAConstainsIgnoreCase(nama);
            if (pelangganRepository.findByNAMAContainsIgnoreCase(nama).isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nama pelanggan belum terdaftar");
            }
            return pelangganRepository.findByNAMAContainsIgnoreCase(nama);
        }

        public List<Pelanggan> getByKODEPEL(String kodepel){
            return pelangganRepository.findByKODEPELContainsIgnoreCase(kodepel);
        }

        public void createPelanggan(Pelanggan pelanggan){
            Optional<Pelanggan> pelangganOptional = pelangganRepository.findByKODEPEL(pelanggan.getKODEPEL());
            
            if (pelangganOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Kode pelanggan telah ada");
    
            }
            else {
                pelangganRepository.save(pelanggan);
                throw new ResponseStatusException(HttpStatus.OK, "Data Pelanggan Berhasil ditambahkan");
            }
        }

        public void deletePelanggan(Long IdPelanggan){
            Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(IdPelanggan);

            if (pelangganOptional.isPresent()){
                pelangganRepository.deleteById(IdPelanggan);
                throw new ResponseStatusException(HttpStatus.OK, "Data pelanggan berhasil di hapus");
            }
            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data pelanggan tidak dapat dihapus");
            }
        }

        public void editPelanggan(Long IdPelanggan, Pelanggan pelanggan){
            Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(IdPelanggan);
            
            if (pelangganOptional.isPresent()){
                pelangganRepository.save(pelanggan);
                throw new ResponseStatusException(HttpStatus.OK, "Data pelanggan berhasil di update");
            }
            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data pelanggan gagal di update");
            }
        }
        
}
