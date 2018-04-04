package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.StudentModel;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentModel selectMahasiswa (String npm)
    {
        log.info ("select mahasiswa with npm {}", npm);
        return studentMapper.selectMahasiswa (npm);
    }

    @Override
    public void tambahMahasiswa (StudentModel mahasiswa)
    {
        log.info ("tambah mahasiswa");
        studentMapper.tambahMahasiswa (mahasiswa);
    }

    
    @Override
    public StudentModel selectKodeUnik (String id_prodi)
    {
        log.info ("select kodeUnik with id_prodi {}", id_prodi);
        return studentMapper.selectKodeUnik (id_prodi);
    }

    
    @Override
    public StudentModel cekMahasiswa (String npm)
    {
        log.info ("cek Mahasiswa with npm {}", npm);
        return studentMapper.cekMahasiswa (npm);
    }

    
    @Override
    public void updateMahasiswa (StudentModel mahasiswa)
    {
        log.info ("update Mahasiswa");
        studentMapper.updateMahasiswa (mahasiswa);
    }

    @Override
    public List<StudentModel> selectListMahasiswa (String id_prodi)
    {
        log.info ("select all students by id_prodi");
        return studentMapper.selectListMahasiswa (id_prodi);
    }
}
