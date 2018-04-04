package com.example.service;

import java.util.List;

import com.example.model.StudentModel;

public interface StudentService
{
    StudentModel selectMahasiswa (String npm);
    void tambahMahasiswa (StudentModel mahasiswa);
    StudentModel selectKodeUnik (String id_prodi);
    StudentModel cekMahasiswa (String npm);
    void updateMahasiswa (StudentModel mahasiswa);
    List<StudentModel> selectListMahasiswa (String id_prodi);
}
