package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FakultasMapper;
import com.example.model.FakultasModel;
import com.example.model.UniversitasModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FakultasServiceDatabase implements FakultasService
{
    @Autowired
    private FakultasMapper fakultasMapper;

    @Override
    public List<FakultasModel> selectFakultas (String id_univ)
    {
        log.info ("select all students");
        return fakultasMapper.selectFakultas (id_univ);
    }
    
}
