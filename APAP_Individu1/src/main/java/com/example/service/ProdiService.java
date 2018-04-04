package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;
import com.example.model.ProdiModel;

public interface ProdiService
{
    ProdiModel kelulusanProdi (String tahun_masuk, String id_prodi);
    List<ProdiModel> selectAllProdi ();
    List<ProdiModel> selectProdi (String id_fakultas);
}
