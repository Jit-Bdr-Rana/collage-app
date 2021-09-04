package helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.repository.GalleryRepository;
import com.college.service.GalleryInterface;
import com.college.service.GalleryInterfaceImpl;

@Service
public class HelperClass {
	@Autowired
	private static GalleryInterface galleryService;
	
	public static String getGalleryImageName(int id) {
	  return	galleryService.getFirstGalleryFromCategory(id).getImage();
	}
}
