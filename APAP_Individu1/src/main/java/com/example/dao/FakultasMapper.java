package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.ProdiModel;

@Mapper
public interface FakultasMapper
{
    @Select("select (select count(m.status) as total_mahasiswa from mahasiswa m, program_studi p, fakultas f, universitas u where m.id_prodi = p.id AND p.id_fakultas = f.id AND f.id_univ = u.id AND m.tahun_masuk = #{tahun_masuk} AND m.id_prodi = #{id_prodi}) as total_mahasiswa, m.tahun_masuk, p.nama_prodi, count(m.status) as lulus, f.nama_fakultas, u.nama_univ from mahasiswa m, program_studi p, fakultas f, universitas u where m.id_prodi = p.id AND p.id_fakultas = f.id AND f.id_univ = u.id AND m.tahun_masuk = #{tahun_masuk} AND m.id_prodi = #{id_prodi} AND m.status = 'Lulus'")
    ProdiModel kelulusanProdi (@Param("tahun_masuk") String tahun_masuk, @Param("id_prodi") String id_prodi);
}


