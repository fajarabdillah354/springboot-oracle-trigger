package dev.codejar.controller;


import dev.codejar.entity.Rekening;
import dev.codejar.payload.request.RekeningRequest;
import dev.codejar.payload.response.BaseResponse;
import dev.codejar.service.RekeningService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rekening")
public class RekeningController {

    private final RekeningService rekeningService;


    public RekeningController(RekeningService rekeningService) {
        this.rekeningService = rekeningService;
    }


    @GetMapping
    public List<Rekening> rekeningList(){
        return rekeningService.rekeningList();
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Rekening>> create(@Valid @RequestBody RekeningRequest rekeningRequest){
        Rekening savedRekening = rekeningService.createRekening(rekeningRequest);

        BaseResponse<Rekening> response = BaseResponse.<Rekening>builder()
                .status(true)
                .message("create rekening successfully")
                .data(savedRekening)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRekening(@RequestBody String nasabah){
        return rekeningService.deleteRekening(nasabah);
    }





}
