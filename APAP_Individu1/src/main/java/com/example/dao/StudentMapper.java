package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.FakultasModel;
import com.example.model.StudentModel;

@Mapper
public interface StudentMapper
{
    @Select("select m.*, p.nama_prodi, f.nama_fakultas, u.nama_univ from mahasiswa m, program_studi p, fakultas f, universitas u where m.id_prodi = p.id AND p.id_fakultas = f.id AND f.id_univ = u.id AND npm = #{npm}")
    StudentModel selectMahasiswa (@Param("npm") String npm);
    
    @Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi) "
    		+ "VALUES (#{npm}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{agama}, #{golongan_darah}, #{status}, #{tahun_masuk}, #{jalur_masuk}, #{id_prodi})")
    void tambahMahasiswa (StudentModel mahasiswa);    
    
    @Select("select p.kode_prodi, f.kode_fakultas, u.kode_univ from program_studi p, fakultas f, universitas u where p.id_fakultas = f.id AND f.id_univ = u.id AND p.id = #{id_prodi}")
    StudentModel selectKodeUnik (@Param("id_prodi") String id_prodi);

    @Select("select npm from mahasiswa where npm LIKE CONCAT(#{npm}, '%') ORDER BY npm DESC LIMIT 1")
    StudentModel cekMahasiswa (@Param("npm") String npm);

    @Update("UPDATE mahasiswa SET npm = #{npm}, nama = #{nama}, tempat_lahir = #{tempat_lahir}, tanggal_lahir = #{tanggal_lahir}, jenis_kelamin = #{jenis_kelamin}, agama = #{agama}, golongan_darah = #{golongan_darah}, status = #{status}, tahun_masuk = #{tahun_masuk}, jalur_masuk = #{jalur_masuk}, id_prodi = #{id_prodi}  WHERE id = #{id}")
    void updateMahasiswa (StudentModel mahasiswa);

    @Select("SELECT * FROM FAKULTAS WHERE id_univ=#{id_univ}")
    List<FakultasModel> selectFakultas (@Param("id_univ") String id_univ);
 
    @Select("select m.*, p.nama_prodi, f.nama_fakultas, u.nama_univ from mahasiswa m, program_studi p, fakultas f, universitas u where m.id_prodi = p.id AND p.id_fakultas = f.id AND f.id_univ = u.id AND id_prodi = #{id_prodi}")
    List<StudentModel> selectListMahasiswa (@Param("id_prodi") String id_prodi);
    
}


