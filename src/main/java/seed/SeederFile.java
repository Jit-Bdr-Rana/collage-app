package seed;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.college.model.AdmissionFee;
import com.college.model.Program;
import com.college.model.SecurityFee;
import com.college.repository.ProgramRepository;
import com.college.service.ProgramService;

@Component
public class SeederFile implements CommandLineRunner {
	
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	
	@Autowired
	private ProgramService programService;

	@Override
	public void run(String... args) throws Exception {
		
		loadProgramData();
	}
	
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		loadProgramData();
	}

	private void loadProgramData() {
		Program program=new Program();
		program.setName("BE Civil");
		program.setHasSecurity(true);
		program.setHasFee(true);
		program.setCreatedAt(date);
		
		SecurityFee securityFee=new SecurityFee();
		securityFee.setAmount(0);
		securityFee.setCreatedAt(date);
		
		AdmissionFee admissionFee=new AdmissionFee();
		admissionFee.setAmount(0);
		admissionFee.setCreatedAt(date);
		program.setAdmissionFee(admissionFee);
		
		programService.saveProgram(program);
		
	}

}
