package com.amartek.pelanggan.Controller;

import java.util.List;

import com.amartek.pelanggan.Service.SewaService;
import com.amartek.pelanggan.entity.PelangganSewa;
import com.amartek.pelanggan.entity.Sewa;
import com.amartek.pelanggan.entity.SewaDetail;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SewaController {

    private SewaService sewaService;

    //Constructor
    public SewaController(SewaService sewaService) {
        this.sewaService = sewaService;
    }
    
    // paling crucial
    @GetMapping("/getsewa")
    public List<Sewa> getAll() {
        return sewaService.getAll();
    }

    @GetMapping("/{idSewa}")
    public Sewa get(@PathVariable final Long idSewa) {
        return sewaService.getById(idSewa);
    }

    @GetMapping("/detail/{idSewa}")
    public List<SewaDetail> getSewaDetailById (@PathVariable final Long idSewa) {
        return sewaService.getSewaDetailById(idSewa);
    }

    @PostMapping("/save")
    public void createSewa(@RequestBody final Sewa sewa) {
        sewaService.save(sewa);
    }

    @DeleteMapping("/{idSewa}")
    public void deleteSewa(@PathVariable final Long idSewa) {
        sewaService.delete(idSewa);
    }

    @GetMapping("/detailarray/{idSewa}")
    public List<Object[]> getSewaDetailArrayById (@PathVariable final Long idSewa) {
        return sewaService.getSewaDetailArrayById(idSewa);
    }

    @GetMapping("/pelanggan/")
    public List<PelangganSewa> getAllSewaPelanggan () {
        return sewaService.getAllSewaPelanggan();
    }




}
