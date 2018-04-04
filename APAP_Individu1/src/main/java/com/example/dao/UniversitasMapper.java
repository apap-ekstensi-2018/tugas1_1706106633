package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.ProdiModel;
import com.example.model.StudentModel;
import com.example.model.UniversitasModel;

@Mapper
public interface UniversitasMapper
{
    @Select("SELECT * FROM UNIVERSITAS")
    List<UniversitasModel> selectUniversitas ();
}


