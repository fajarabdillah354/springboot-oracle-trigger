package dev.codejar.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rekening")
public class Rekening {

    @Id
    @Column(name = "nomor_rekening")
    private Long nomorRekening;

    @Column(name = "nama_nasabah", nullable = false, length = 50)
    private String namaNasabah;

    @Column(name = "tempat_lahir", nullable = false, length = 20)
    private String tempatLahir;


    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;


    @Column(name = "alamat", length = 50)
    private String alamat;


    @Column(name = "saldo")
    private BigDecimal saldo;

    @OneToMany(mappedBy = "pengirim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transfer> transaksiDikirim;

    @OneToMany(mappedBy = "penerima", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transfer> transaksiDiterima;

}
