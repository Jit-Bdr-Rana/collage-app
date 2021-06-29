package com.college.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.college.model.Program;
import com.college.model.Result;
import com.college.model.ResultCategory;
import com.college.service.ProgramService;
import com.college.service.ResultService;

@Controller
@RequestMapping("/admin/result")
public class ResultController {
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/static/admin/csv";
	@Autowired
	private ProgramService programService;
	
	@Autowired 
	private ResultService resultService;

	
    @GetMapping("")
	public String showResultTable(Model model) {
    	
    	List<ResultCategory> listOfResulCategories=resultService.showAllResultCategory();
    	String result_link="active";
    	model.addAttribute("result_link",result_link);
    	model.addAttribute("listOfResulCategories",listOfResulCategories);
		return  "admin/result_table";
	}
    
    @GetMapping("/form")
    public String showResultForm(Model model) {
        List<Program> listOfPrograms =programService.showAllProgram();
    	String result_link="active";
    	model.addAttribute("result_link",result_link);
    	model.addAttribute("listOfPrograms",listOfPrograms);
    	return "admin/result_form";
    }
    
    @PostMapping("/save")
    public String saveResult(HttpServletRequest request,@RequestParam("csv") MultipartFile csv,Model model) throws IOException {
    	new File(uploadDirectory).mkdir();
    	ResultCategory currentResultCategory=null;
    	String program=request.getParameter("program");
    	String term=request.getParameter("term");
    	String semester=request.getParameter("semester");
    	String subject=request.getParameter("subject");
    	
    	System.out.println(program);
    	System.out.println(term);
    	System.out.println(semester);
    	System.out.println(subject);
    	System.out.println("semester");
    	if(program==null || term==null || semester==null || subject==null) {
    		model.addAttribute("pro_sem_term","make sure you select program semester and term");
			return showResultForm(model);
    	}else {
    		
    		String ext= csv.getOriginalFilename().substring(csv.getOriginalFilename().length() - 4);
    		if(!ext.equals(".csv"))
    		{
    			model.addAttribute("file_error","Invalide file type only csv allowed");
    			return showResultForm(model);
    		}
    		
    		ResultCategory resultCategory=new ResultCategory();
    		resultCategory.setProgram(program);
    		resultCategory.setSemester(Integer.parseInt(semester));
    		resultCategory.setCreatedAt(date);
    		resultCategory.setTerm(Integer.parseInt(term));
    		resultCategory.setSubject(subject);

    		currentResultCategory=resultService.saveResultCategory(resultCategory);
    		
    		
    	}
    	
    	
    	String fileName =csv.getOriginalFilename();
				
		Path fileAndPath = Paths.get(uploadDirectory, fileName);
		
		try {
			Files.write(fileAndPath, csv.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader reader=new BufferedReader(new FileReader(uploadDirectory+"/"+fileName));
		String line="";
		  while((line=reader.readLine())!=null) {
			  Result result=new Result();
			  String[] row=line.split(",");
			  System.out.println(row.length);
			  if(row.length==4) {
				 result.setCreatedAt(date);
				 result.setFullMark(Integer.parseInt(row[1]));
				 result.setStudent(row[0]);
				 result.setPassMark(Integer.parseInt(row[2]));
				 result.setObtainMark(Integer.parseInt(row[3]));
				 result.setResultCategory(currentResultCategory);
				 resultService.saveResult(result);
			  }
			  
			  
		  }
		
		reader.close();

		
		  Path path = Paths.get(uploadDirectory+"/"+fileName);
		  Files.delete(path);
    	  model.addAttribute("success","successfully added marks of "+program+" "+semester+" semester "+term+"term with subject "+subject);
		  return showResultTable(model);
    	
    }
    
    @GetMapping("/view/{id}")
    public String viewMarksTable(@PathVariable(name="id") Integer id,Model model) {
    	
    List<Result> listOfResults=resultService.showAllResult(id);
      ResultCategory resultCategory=resultService.findResultCategoryById(id);
     	String result_link="active";
     	model.addAttribute("result_link",result_link);
     	model.addAttribute("resultCategory",resultCategory);
    	model.addAttribute("listOfResults",listOfResults);
    	
    	return "admin/marks_table";
    }
    
    
    @GetMapping("/marks/form/{id}")
    public String showMarksForm(@PathVariable(name="id") Integer category_id ,Model model) {
    	
    	String result_link="active";
    	model.addAttribute("result_link",result_link);
    	model.addAttribute("category_id",category_id);
    	model.addAttribute("result",new Result());
    	return "admin/marks_form";
    }
    
    @PostMapping("/marks/save")
    public String saveMarks(Result result,@RequestParam("category_id") Integer category_id,Model model ) {
    	
        ResultCategory resutlCategory=resultService.findResultCategoryById(category_id);
        result.setResultCategory(resutlCategory);
        model.addAttribute("success","marks has been added ");
    	resultService.saveResult(result);
    	
    	return viewMarksTable(category_id,model);
    }
    
    @GetMapping("/delete/category/{id}")
    public String deleteCategory(@PathVariable(name="id")Integer id,Model model) {
    	resultService.deleteResultCategory(id);
    	System.out.println(id);
    	return "redirect:/admin/result";
    }
	
    @GetMapping("/delete/marks/{id}")
    public String deleteMarks(@PathVariable(name="id")Integer id,@RequestParam("category_id")Integer category_id) {
    	resultService.deleteMarks(id);
    	return "redirect:/admin/result/view/"+category_id;
    }
}
