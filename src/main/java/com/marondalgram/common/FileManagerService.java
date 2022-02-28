package com.marondalgram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	public final static String FILE_UPLOAD_PATH = "D:\\신보람\\web_211015\\6_spring-project\\sns\\workspace\\images/";
	
	public String saveFile(String userLoginId, MultipartFile file) {
		// 파일 디렉토리 경로 예: marobiana_16456453342/sun.png
		// 파일명이 겹치지 않게 하기 위해 현재시간을 경로에 붙여준다.
		String directoryName = userLoginId + "_" + System.currentTimeMillis() + "/";
		// D:\\신보람\\web_211015\\6_spring-project\\memo\\workspace\\images/marobiana_16456453342/
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 만들기
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;   // 디렉토리 생성 시 실패하면 null 리턴
		}
		
		// 파일 업로드: byte 단위로 업로드 한다.
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename()); // getOriginalFilename()는 input에서 올린 파일명이다.(한글 X)
			Files.write(path, bytes);
			
			// 이미지 URL을 리턴한다. (WebMvcConfig에서 매핑한 이미지 path)
			// 예) http://localhost/images/marobiana_16456453342/sun.png
			return "/images/" + directoryName + file.getOriginalFilename();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
