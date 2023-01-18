package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	//파일리스트 출력
	@RequestMapping("/filelist")
	public ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
		File f = new File("c:/upload");
		String filelist[] = f.list();
		
		mv.addObject("filelist",filelist);
		mv.setViewName("upload/filelist");
		
		return mv;
	}
	@RequestMapping("/filedownload")
	public void filedownload(String onefile, HttpServletResponse response) 
	throws IOException{
		//onefile이라는 이름의 파일을 c:/upload에서 찾는다
		File f = new File("c:/upload/" + onefile);
		int f_length = (int)f.length();//byte타입
		
		// 응답할 컨텐트 다운로드 파일
		response.setContentType("application/download");
		response.setContentLength(f_length);
		response.setHeader("Content-Disposition" , "attachment;filename=\"" + onefile + "\"");
		
		OutputStream out = response.getOutputStream(); //다운로드 설정
		FileInputStream f_in = new FileInputStream(f); //다운로드 설정
		FileCopyUtils.copy(f_in, out); //다운로드
		f_in.close();
		out.close();
	}
}
