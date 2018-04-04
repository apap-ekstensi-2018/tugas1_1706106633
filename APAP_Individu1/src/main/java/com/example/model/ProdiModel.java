package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiModel
{
    private String id, kode_prodi, nama_prodi, id_fakultas, nama_univ, nama_fakultas, total_mahasiswa, lulus, tahun_masuk;    
}
