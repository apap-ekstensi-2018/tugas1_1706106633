package com.example.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.UniversitasModel;
import com.example.service.UniversitasService;

import com.example.model.FakultasModel;

import com.example.model.StudentModel;
import com.example.service.StudentService;

import com.example.model.ProdiModel;
import com.example.service.ProdiService;



@Controller
public class StudentController
{
    @Autowired
    UniversitasService universitasDAO;

    @Autowired
    ProdiService prodiDAO;

    @Autowired
    StudentService studentDAO;
    
    @RequestMapping("/mahasiswa/tambah/submit")
    public String tambahMahasiswa_aksi (
    		Model model,
            @RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gpa", required = false) double gpa)
    {
        model.addAttribute ("title", "Sukses Tambah");
        StudentModel student = new StudentModel ();
        studentDAO.addStudent (student);

        return "success-add";
    }


//    @RequestMapping("/student/view")
//    public String view (Model model,
//            @RequestParam(value = "npm", required = false) String npm)
//    {
//        StudentModel student = studentDAO.selectMahasiswa (npm);
//
//        if (student != null) {
//            model.addAttribute ("title", "Tampil Mahasiswa");
//            model.addAttribute ("student", student);
//            return "view";
//        } else {
//            model.addAttribute ("title", "Gagal Tampil Mahasiswa");
//            model.addAttribute ("npm", npm);
//            return "not-found";
//        }
//    }


//    @RequestMapping("/student/view/{npm}")
//    public String viewPath (Model model,
//            @PathVariable(value = "npm") String npm)
//    {
//        StudentModel student = studentDAO.selectStudent (npm);
//
//        if (student != null) {
//            model.addAttribute ("student", student);
//            model.addAttribute ("title", "Tampil Mahasiswa");
//            return "view";
//        } else {
//            model.addAttribute ("title", "Gagal Tampil Mahasiswa");
//            model.addAttribute ("npm", npm);
//            return "not-found";
//        }
//    }


    @RequestMapping("/student/viewall")
    public String view (Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents ();
        model.addAttribute ("students", students);
        model.addAttribute ("title", "Tampil Semua Data");

        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {

        StudentModel student = studentDAO.selectMahasiswa (npm);

        if (student != null) {
            model.addAttribute ("title", "Hapus Mahasiswa");
            studentDAO.deleteStudent (npm);
            return "delete";
        } else {
            model.addAttribute ("title", "Hapus Mahasiswa");
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }

    
    @RequestMapping("/student/update/{npm}")
    public String update (Model model, @PathVariable(value = "npm") String npm)
    {

        StudentModel student = studentDAO.selectMahasiswa (npm);

        if (student != null) {
            model.addAttribute ("title", "Update Mahasiswa");
            model.addAttribute ("student", student);
            return "form-update";
        } else {
            model.addAttribute ("title", "Update Mahasiswa");
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
    
    @RequestMapping(value = "/student/update/submit", method =  RequestMethod.POST)
    public String updateSubmit(Model model, @ModelAttribute StudentModel student, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors())
    		return "errorForm";
    		
        studentDAO.updateStudent (student);

        model.addAttribute ("title", "Update Mahasiswa");
        return "success-update";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping("/")
    public String index (Model model)
    {
        model.addAttribute ("title", "Home");
        return "index";
    }    
    

    @RequestMapping(value = "/mahasiswa", method =  RequestMethod.GET)
    public String viewMahasiswa (Model model, @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel mahasiswa = studentDAO.selectMahasiswa (npm);

        if (mahasiswa != null) {
            model.addAttribute ("title", "Tampil Mahasiswa");
            model.addAttribute ("mahasiswa", mahasiswa);
            return "view";
        } else {
            model.addAttribute ("title", "Gagal Tampil Mahasiswa");
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
    
    @RequestMapping(value = "/mahasiswa/tambah")
    public String tambahMahasiswa (Model model)
    {
        model.addAttribute ("title", "Tambah Mahasiswa");
        return "form-add";
    }

    @RequestMapping(value = "/mahasiswa/tambah", method = RequestMethod.POST)
    public String tambahMahasiswa (Model model, @ModelAttribute StudentModel mahasiswa)
    {
    	String arrayJalur_masuk[], npm, npm2;
    	int npm_int;
    	StudentModel kodeUnik = studentDAO.selectKodeUnik (mahasiswa.getId_prodi());

    	arrayJalur_masuk = mahasiswa.getJalur_masuk().split(",");
    	npm = mahasiswa.getTahun_masuk().substring(2)+kodeUnik.getKode_univ()+kodeUnik.getKode_prodi()+arrayJalur_masuk[0];
    	npm2 = mahasiswa.getTahun_masuk().substring(2)+kodeUnik.getKode_univ()+kodeUnik.getKode_prodi();

    	StudentModel mahasiswa2 = studentDAO.cekMahasiswa (npm);
    	
    	if(mahasiswa2 != null){
    		npm = mahasiswa2.getNpm().substring(7);
    		npm_int = Integer.parseInt(npm)+1;
    		npm = npm2+npm_int;
    	}else{
    		npm = npm+"001";
    	}
    	
    	mahasiswa.setJalur_masuk(arrayJalur_masuk[1]);
    	mahasiswa.setNpm(npm);
    	mahasiswa.setStatus("Aktif");
    	
        studentDAO.tambahMahasiswa (mahasiswa);
        return "success-add";
    }

    @RequestMapping("/mahasiswa/ubah/{npm}")
    public String updateMahasiswa (Model model, @PathVariable(value = "npm") String npm)
    {

        StudentModel mahasiswa = studentDAO.selectMahasiswa (npm);

        if (mahasiswa != null) {
            model.addAttribute ("title", "Update Mahasiswa");
            model.addAttribute ("mahasiswa", mahasiswa);
            return "form-update";
        } else {
            model.addAttribute ("title", "Update Mahasiswa");
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }

    
    @RequestMapping(value = "/mahasiswa/ubah/{npm}", method =  RequestMethod.POST)
    public String updateMahasiswa(Model model, @ModelAttribute StudentModel mahasiswa, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors())
    		return "errorForm";

    	String arrayJalur_masuk[], npm, npm2;
    	int npm_int;
    	StudentModel kodeUnik = studentDAO.selectKodeUnik (mahasiswa.getId_prodi());

    	arrayJalur_masuk = mahasiswa.getJalur_masuk().split(",");
    	npm = mahasiswa.getTahun_masuk().substring(2)+kodeUnik.getKode_univ()+kodeUnik.getKode_prodi()+arrayJalur_masuk[0];
    	npm2 = mahasiswa.getTahun_masuk().substring(2)+kodeUnik.getKode_univ()+kodeUnik.getKode_prodi();

    	StudentModel mahasiswa2 = studentDAO.cekMahasiswa (npm);
    	
    	if(mahasiswa2 != null){
    		npm = mahasiswa2.getNpm().substring(7);
    		npm_int = Integer.parseInt(npm)+1;
    		npm = npm2+npm_int;
    	}else{
    		npm = npm+"001";
    	}
    	
    	mahasiswa.setJalur_masuk(arrayJalur_masuk[1]);
    	mahasiswa.setNpm(npm);
    	mahasiswa.setStatus("Aktif");
    	
        studentDAO.updateMahasiswa (mahasiswa);

        model.addAttribute ("title", "Update Mahasiswa");
        return "success-update";
    }
    
    @RequestMapping("/kelulusan")
    public String kelulusan (Model model)
    {
        model.addAttribute ("title", "Presentase Kelulusan");
        return "kelulusan";
    }    

    @RequestMapping(value = "/kelulusan", method =  RequestMethod.GET)
    public String persentaseKelulusan (Model model, 
    		@RequestParam(value = "tahun_masuk", required = false) String tahun_masuk,    		
    		@RequestParam(value = "id_prodi", required = false) String id_prodi)
    {
    	String persentaseKelulusan;
    	DecimalFormat twoDForm = new DecimalFormat("#.#");    	
    	
    	if(id_prodi!=null){
            ProdiModel prodi = prodiDAO.kelulusanProdi (tahun_masuk, id_prodi);

            if (prodi != null) {
                model.addAttribute ("title", "Tampil Prodi");
                persentaseKelulusan = Double.toString(Double.valueOf(twoDForm.format(Double.parseDouble(prodi.getLulus())/Double.parseDouble(prodi.getTotal_mahasiswa())*100)));
                model.addAttribute ("prodi", prodi);
                model.addAttribute ("persentaseKelulusan", persentaseKelulusan);
                return "kelulusan_result";
            } else {
                model.addAttribute ("title", "Gagal Tampil Prodi");
                model.addAttribute ("tahun_masuk", tahun_masuk);
                model.addAttribute ("id_prodi", id_prodi);
                return "not-found";
            }
    	}
        model.addAttribute ("title", "Presentase Kelulusan");
        return "kelulusan";
    }
    
    @RequestMapping(value = "/mahasiswa/cari", method =  RequestMethod.GET)
    public String cariMahasiswa(Model model,
    		@RequestParam(value = "universitas", required = false) String id_universitas,    	
    		@RequestParam(value = "fakultas", required = false) String id_fakultas,    	
    		@RequestParam(value = "prodi", required = false) String id_prodi    	
    ){
    	if(id_universitas == null){
    		List<UniversitasModel> univ = universitasDAO.selectUniversitas();
    		model.addAttribute("universitas", univ);
    		return "cari-mahasiswa";
    	}else if(id_fakultas == null){
    	
    	}else if(id_prodi == null){
    		
    	}else{
    		
    	}
    	
    	return "cariMahasiswa";
    }
    
    
    
    
    
}
