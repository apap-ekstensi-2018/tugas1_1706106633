package com.example.service;

import java.util.List;

import com.example.model.StudentModel;

public interface StudentService
{


    List<StudentModel> selectAllStudents ();

    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);



    StudentModel selectMahasiswa (String npm);
    void tambahMahasiswa (StudentModel mahasiswa);
    StudentModel selectKodeUnik (String id_prodi);
    StudentModel cekMahasiswa (String npm);
    void updateMahasiswa (StudentModel mahasiswa);
}
