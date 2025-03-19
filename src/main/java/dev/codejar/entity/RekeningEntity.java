package dev.codejar.entity;


import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "rekening")
public class RekeningEntity {

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


    @Column(name = "saldo", nullable = false)
    private Double saldo = 0.0;

    @OneToMany(mappedBy = "rekeningPengirim")
    private List<TransactionEntity> transferOut;

    @OneToMany(mappedBy = "rekeningPenerima")
    private List<TransactionEntity> transferIn;

}
