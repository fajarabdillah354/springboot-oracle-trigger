package dev.codejar.service;


import dev.codejar.entity.Rekening;
import dev.codejar.entity.Transfer;
import dev.codejar.payload.request.TransferRequest;
import dev.codejar.repository.TransferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    private ModelMapper modelMapper;


    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }


    //READ
    public List<Transfer> rekeningList(){
        return transferRepository.findAll();
    }


    //CREATE
    @Transactional
    public Transfer createTransfer(TransferRequest transferRequest){
        TransferRequest request = TransferRequest.builder()
                .pengirim(transferRequest.getPengirim())
                .penerima(transferRequest.getPenerima())
                .nominalTransfer(transferRequest.getNominalTransfer())
                .keterangan(transferRequest.getKeterangan())
                .build();

        Transfer saved = modelMapper.map(request, Transfer.class);
        return transferRepository.save(saved);
    }


    //DELETE
    public ResponseEntity<?> deteleTransfer(Rekening pengirim){
        Optional<Transfer> optional = transferRepository.findByPengirim(pengirim);
        if (Optional.empty().isPresent()){
            transferRepository.delete(optional.get());
            return ResponseEntity.ok("transfer successfully deleted");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
