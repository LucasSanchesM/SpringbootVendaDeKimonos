package projetospring.sitedevendaquimono.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetospring.sitedevendaquimono.dtos.CreateKimonoDto;
import projetospring.sitedevendaquimono.dtos.UpdateKimonoDto;
import projetospring.sitedevendaquimono.entity.Kimono;
import projetospring.sitedevendaquimono.service.KimonoService;





@RestController
@RequestMapping("/v1/kimonos")
@CrossOrigin(origins = "*")
public class KimonoController {
    private KimonoService kimonoService;

    public KimonoController(KimonoService kimonoService) {
        this.kimonoService = kimonoService;
    }

    @PostMapping
    public ResponseEntity<Kimono> createKimono(@RequestBody CreateKimonoDto createKimonoDto) {
        var kimonoCreatedId = kimonoService.createKimono(createKimonoDto);

        return ResponseEntity.created(URI.create("/v1/kimonos/" + kimonoCreatedId.toString())).build();
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Kimono>> listKimonos() {
        return ResponseEntity.ok(kimonoService.listarKimonos());
    }
    
    @GetMapping("/{kimonoId}")
    public ResponseEntity<Kimono> getKimonoById(@PathVariable("kimonoId") String kimonoId) {
        var kimonoinfo = kimonoService.getKimonoById(kimonoId);
        return ResponseEntity.ok(kimonoinfo);
    }
    @PutMapping("/{kimonoId}")
    public ResponseEntity<Void> editKimonoById(@PathVariable("kimonoId") String kimonoId, @RequestBody UpdateKimonoDto updateKimonoDto) {
        kimonoService.editKimonoById(kimonoId, updateKimonoDto);
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{kimonoId}")
    public ResponseEntity<Void> deleteKimonoById(@PathVariable("kimonoId") String kimonoID){
        kimonoService.deleteKimonoById(kimonoID);
        return ResponseEntity.ok().build();
    }

}
