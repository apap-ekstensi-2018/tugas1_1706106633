package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;

public interface FakultasService
{
    List<FakultasModel> selectFakultas (String id_univ);
}
