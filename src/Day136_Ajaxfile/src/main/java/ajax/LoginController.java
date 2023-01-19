package ajax;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class LoginController {

	@GetMapping("/loginajax")
	public String loginajax() {
		return "ajax/loginform";
	}
	
	@ResponseBody
	@PostMapping(value = "/uploadajax", 
			produces = "application/json;charset=utf-8")
	public String uploadajax(MultipartFile uploadfile) throws IOException {
		String savePath = "c:/upload/";
		//파일명1 추출
		String filename1 = uploadfile.getOriginalFilename();
		//파일이름 . 확장자 분리
		String beforeext1 = filename1.substring(0, filename1.lastIndexOf('.'));
		String ext1 = filename1.substring(filename1.lastIndexOf('.'));
		//	UUID.randomUUID()
		String newfilename1 = beforeext1 +"(" + UUID.randomUUID().toString() +")" + ext1;
		//파일내용1 추출해서 c:/upload/filename1 저장 
		File serverfile1 = new File(savePath + newfilename1);
		uploadfile.transferTo(serverfile1);
		
		return "{ \"result\" : \"잘받았습니다.\"}";
	}
	
	
}
