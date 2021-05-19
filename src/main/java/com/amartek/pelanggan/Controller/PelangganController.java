package com.amartek.pelanggan.Controller;

import java.util.List;
import com.amartek.pelanggan.Service.PelangganService;
import com.amartek.pelanggan.entity.Pelanggan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PelangganController {
  private PelangganService pelangganService;

    public PelangganController(PelangganService pelangganService){
        this.pelangganService = pelangganService;
    }

    // get semua data
    @GetMapping("/get")
    public List<Pelanggan> getAll() {
        return pelangganService.getAll();
    }
  
    // get email
    @GetMapping("get_email/{email}")
    public List<Pelanggan> getByEMAIL(@PathVariable final String email){
        return pelangganService.getByEMAIL(email);
    }

    // get kodepelajaran
    @GetMapping("get_kode/{kodepel}")
    public List<Pelanggan> getByKODEPEL(@PathVariable final String kodepel){
        return pelangganService.getByKODEPEL(kodepel);
    }

    // @GetMapping("get_nama/{nama}")
    // public List<Pelanggan> getByNAMA(@PathVariable final String nama){
    //     return pelangganService.getByNAMA(nama);
    // }

    // input data pelanggan baru
    @PostMapping("/create")
    public void createPelanggan(@RequestBody final Pelanggan pelanggan) {
        pelangganService.createPelanggan(pelanggan);
    }

    // menghapus data pelanggan
    @DeleteMapping("/delete/{IdPelanggan}")
    public void deletePelanggan(@PathVariable final Long IdPelanggan){
            pelangganService.deletePelanggan(IdPelanggan);
    }


    // update data pelanggan
    @PutMapping("edit/{IdPelanggan}")
    public void editPelanggan(@PathVariable final Long IdPelanggan, @RequestBody final Pelanggan pelanggan){
        pelangganService.editPelanggan(IdPelanggan, pelanggan);
    }    


    


  
}
  
  

