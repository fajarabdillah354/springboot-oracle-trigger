package dev.codejar.payload.request;

import dev.codejar.entity.Rekening;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransferRequest {


    private Rekening pengirim;

    private Rekening penerima;

    private BigDecimal nominalTransfer;

    @NotBlank(message = "please fill keterangan")
    private String keterangan;



}
