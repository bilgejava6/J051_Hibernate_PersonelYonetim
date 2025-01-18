package com.muhammet;

import com.muhammet.entity.Departman;
import com.muhammet.entity.Envanter;
import com.muhammet.entity.Personel;
import com.muhammet.repository.DepartmanRepository;
import com.muhammet.repository.EnvanterRepository;
import com.muhammet.repository.PersonelRepository;

public class HrApplication {
    public static void main(String[] args) {
        // Start
//        DepartmanRepository departmanRepository = new DepartmanRepository();
//        Departman departman = Departman.builder().ad("Muhasebe").kapasite(5).personelSayisi(0).build();
//        departmanRepository.save(departman);
//
//        PersonelRepository personelRepository = new PersonelRepository();
//        Personel personel = Personel.builder().ad("Ahmet").soyad("TAŞ").adres("Ankara").build();
//        personelRepository.save(personel);

//        new EnvanterRepository().save(Envanter.builder().ad("Masa").stokAdedi(5).build());
        new PersonelRepository().findAll(new Personel()).forEach(System.out::println);
    }
}
