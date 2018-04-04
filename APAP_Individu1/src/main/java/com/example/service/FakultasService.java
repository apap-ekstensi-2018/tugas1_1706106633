package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;
import com.example.model.UniversitasModel;

public interface FakultasService
{
    List<FakultasModel> selectFakultas (String id_univ);
}
