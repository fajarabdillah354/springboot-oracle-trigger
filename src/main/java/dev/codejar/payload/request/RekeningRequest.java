package dev.codejar.payload.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
public class RekeningRequest {

    @Digits(integer = 8, fraction = 0)
    private Long nomorRekening;

    @NotBlank(message = "nama nasabah cannot blank")
    private String namaNasabah;


    private String tempatLahir;


    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;


    private String alamat;

    @Max(value = 100_000_000, message = "saldo cannot greter then 100 juta")
    private BigDecimal saldo;



}
