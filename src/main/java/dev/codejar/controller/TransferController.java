package dev.codejar.controller;


import dev.codejar.entity.Rekening;
import dev.codejar.entity.Transfer;
import dev.codejar.payload.request.TransferRequest;
import dev.codejar.payload.response.BaseResponse;
import dev.codejar.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tf")
public class TransferController {

    @Autowired
    private TransferService transferService;


    @GetMapping
    public List<Transfer> transferList(){
        return transferService.rekeningList();
    }


    @PostMapping("/transfer")
    public ResponseEntity<BaseResponse<Transfer>> transfer(@Valid @RequestBody TransferRequest transferRequest){
        Transfer savedTf = transferService.createTransfer(transferRequest);

        BaseResponse<Transfer> response = BaseResponse.<Transfer>builder()
                .status(true)
                .message("transfer successfully")
                .data(savedTf)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deteleTf(@RequestBody Rekening rekening){
        return transferService.deteleTransfer(rekening);
    }


}
