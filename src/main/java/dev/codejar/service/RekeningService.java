package dev.codejar.service;


import dev.codejar.entity.Rekening;
import dev.codejar.payload.request.RekeningRequest;
import dev.codejar.repository.RekeningRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RekeningService {


    @Autowired
    private RekeningRepository rekeningRepository;

    @Autowired
    private ModelMapper modelMapper;


    //READ
    public List<Rekening> rekeningList(){
        return rekeningRepository.findAll();
    }



    //CREATE
    @Transactional
    public Rekening createRekening(RekeningRequest rekeningRequest){
        RekeningRequest request = RekeningRequest.builder()
                .nomorRekening(rekeningRequest.getNomorRekening())
                .namaNasabah(rekeningRequest.getNamaNasabah())
                .tempatLahir(rekeningRequest.getTempatLahir())
                .tanggalLahir(rekeningRequest.getTanggalLahir())
                .alamat(rekeningRequest.getAlamat())
                .saldo(rekeningRequest.getSaldo())
                .build();
        Rekening saved = modelMapper.map(request, Rekening.class);
        return rekeningRepository.save(saved);
    }


    //DELETE
    public ResponseEntity<?> deleteRekening(String nasabah){
        Optional<Rekening> optional = rekeningRepository.findByNamaNasabah(nasabah);
        if (Optional.empty().isPresent()){
            rekeningRepository.delete(optional.get());
            return ResponseEntity.ok("nasabah berhasil dihapus");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
