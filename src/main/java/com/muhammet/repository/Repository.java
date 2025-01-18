package com.muhammet.repository;

import java.util.List;

public interface Repository<T> {
    /**
     * Örneğin, aynı anda 2 kişi personel ve departman bilgilerini DB ye işliyor.
     * A kişisi, İnsan Kaynakları Deparmanını eklediği anda, B Kişisi Muhasebe
     * departmanını sisteme girmiştir.
     * A kişisi departmana ait personeleli eklemek istediğinde  departmanın Id sini
     * nasıl bulabilir?
     * Kayıt edilen veriyi, kaydetme işleminden sonra id si atanmış olarak return
     * ederiz.
     */
    T save(T t);
    T update(T t);
    boolean delete(Long id);
    List<T> findAll(T t);
}
