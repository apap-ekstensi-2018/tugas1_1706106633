package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProdiMapper;
import com.example.model.ProdiModel;
import com.example.model.ProdiModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdiServiceDatabase implements ProdiService
{
    @Autowired
    private ProdiMapper prodiMapper;


    @Override
    public ProdiModel kelulusanProdi (String tahun_masuk, String id_prodi)
    {
        log.info ("persentase kelulusan Prodi {} pada tahun {} ", id_prodi, tahun_masuk);
        return prodiMapper.kelulusanProdi (tahun_masuk, id_prodi);
    }

    @Override
    public List<ProdiModel> selectProdi (String id_fakultas)
    {
        log.info ("select all students");
        return prodiMapper.selectProdi (id_fakultas);
    }
}
