package dev.codejar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_transaksi")
    private Long noTransaksi;

    @Column(name = "waktu_transaksi", nullable = false, updatable = false)
    private LocalDateTime waktuTransaksi = LocalDateTime.now();


    @Column(name = "nominal_transfer")
    private BigDecimal nominalTransfer;


    @Column(name = "keterangan", length = 20)
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "norek_pengirim", referencedColumnName = "nomor_rekening")
    private Rekening pengirim;

    @ManyToOne
    @JoinColumn(name = "norek_penerima", referencedColumnName = "nomor_rekening")
    private Rekening penerima;



}
