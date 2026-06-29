package projetospring.sitedevendaquimono.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import projetospring.sitedevendaquimono.dtos.CreateKimonoDto;
import projetospring.sitedevendaquimono.dtos.UpdateKimonoDto;
import projetospring.sitedevendaquimono.entity.Kimono;
import projetospring.sitedevendaquimono.repository.KimonoRepository;

@Service
public class KimonoService {
    private KimonoRepository kimonoRepository;

    public KimonoService(KimonoRepository kimonoRepository) {
        this.kimonoRepository = kimonoRepository;
    }
    
    public UUID createKimono(CreateKimonoDto createKimonoDto){
        var kimono = new Kimono(
                        null,
                        createKimonoDto.nome(),
                        createKimonoDto.tamanho(),
                        createKimonoDto.cor(),
                        createKimonoDto.categoria(),
                        createKimonoDto.preco(),
                        createKimonoDto.quantidade(),
                        createKimonoDto.caminhoImagem(),
                        Instant.now(),
                        null
        );
        var kimonoCreated = kimonoRepository.save(kimono);

        return kimonoCreated.getKimonoId();
        
    }

    public Kimono getKimonoById(String kimonoId){
        UUID id = UUID.fromString(kimonoId);
        var kimono = kimonoRepository.findById(id)
                        .orElseThrow(()-> (new ResponseStatusException(HttpStatus.NOT_FOUND)));
        
        return kimono;
    }

    public List<Kimono> listarKimonos(){
        
        return kimonoRepository.findAll();
    }

    public void editKimonoById(String kimonoId ,UpdateKimonoDto updateKimonoDto){

    }

}
