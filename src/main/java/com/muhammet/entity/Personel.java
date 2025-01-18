package com.muhammet.entity;

import com.muhammet.utility.Unvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblpersonel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long departmanId;
    String ad;
    String soyad;
    String adres;
    String telefon;
    String email;
    String avatar;
    /**
     * Not!!! Eski hibernate sürümlerinde JPA nedeniyle
     * enumların tanımlanması gereklidir. Bu işlemi
     * @Enumarated kullanarak yaparız. Mantık olarak
     * enum key-value şeklinde String-Integer tutar,
     * bu nedenle DB ye kayıt edilecek şeklini belirtmeniz
     * gereklidir. Güncel sürümlerde Integer default
     * olarak kayıt edilir.
     * @Enumerated(EnumType.STRING) -> Metin olarak kayıt eder
     * @Enumerated(EnumType.ORDINAL) -> Sayıdal olarak kayıt eder.
     */
    @Enumerated(EnumType.ORDINAL)
    Unvan unvan;
}
