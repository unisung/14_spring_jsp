package com.study.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "index";
	}
	
	@RequestMapping("/uploadForm")
	public String uploadForm() {
		return "FileUpload/fileForm";
	}
	
	@RequestMapping("/uploadOk")
	public @ResponseBody String 
	         uploadOk(HttpServletRequest request) {
		//업로드 결과 메세지 출력 객체
		JSONObject obj = new JSONObject();
		try {
			//upload경로 지정
			String filePath 
			 = ResourceUtils
			   .getFile("classpath:static/upload/")
			   .toPath()
			   .toString();
			//업로드된 파일 처리
			List<Part> fileParts =request.getParts()
					                     .stream()
					                     .filter( part-> "files".equals(part.getName()) 
					                    		     && part.getSize() >0) 	
					                     .collect(Collectors.toList());
			//fileParts리스트 처리
			for(Part filePart: fileParts) {
				//form으로부터 전달된 file객체의 이름 추출
				String fileName = Paths
			          .get(filePart.getSubmittedFileName())
			          .getFileName()
			          .toString();
				//추출된 file객체 이름과 저장될 디렉토리 경로를 합쳐서 전체파일경로명을 만듬
				String dst = filePath + "\\" + fileName;
				
				//try~with-resources문-리소스해제를 자동처리해주는 문법
				try(// 업로드된 파일정보를 byte단위로 입력받는 통로(input스트림-단방향)
						BufferedInputStream fin =
					  new BufferedInputStream(filePart.getInputStream());
					//입력받은 파일정보를 dst경로에 byte단위로 저장하는 통로(output스트림-단방향) 	
					BufferedOutputStream fout =
					  new BufferedOutputStream(new FileOutputStream(dst)))	
				{
					int data;//입력받은 파일정보로 부터 byte단위로 읽어들이 정보를 임시저장하는 변수
					while(true)//무한반복처리
					{
						data = fin.read();//1byte씩 읽어서 data변수에 저장
						if(data == -1)//더이상 읽을 byte가 없으면 -1 리턴
							break;// 무한반복 종료
						fout.write(data);//읽어들인 1byte의 정보를 파일로 1byte씩 저장
					}
				}catch(IOException e) {
					e.printStackTrace();//예외 발생시 처리
				}
				//console에 저장이 완료된 파일단위로 파일경로및 이름 출력
				System.out.println("Uploaded Filename: " + dst + "<br>");
			}
			//업로드성공시 생성되는 Javascript 메세지 객체
			obj.put("success","1");
			obj.put("desc", "업로드 성공");	
		} catch (Exception e) {
			e.printStackTrace();
			//업로드 실패시 생성되는 Javascript 메세지 객체
			obj.put("success","0");
			obj.put("desc", "업로드 실패");
		}
		//위에서 만든 JSON Object를 String으로 변환 하여 출력
		return obj.toJSONString();
	}
}
