package com.ada.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ada.api.utils.HashImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	@Autowired
	HashImage hashImage;

	private Path currentPath = Paths.get(".");
	private Path absolutePath = currentPath.toAbsolutePath();
	private String folderPathImage = "/src/main/resources/static/images";
	private String folderPath;

	public String saveImage(MultipartFile imageFile, String typeUser) throws IOException {

		byte[] bytes = imageFile.getBytes();

		String extension = getExtensionImage(imageFile);
		String imageName = getImageName(imageFile.getOriginalFilename());
	
		String hashImageName = hashImage.hashFileName(imageName);
		
		String image = hashImageName + "." + extension;
		
		if(typeUser == "admin") {
			
			folderPath = "/admins/";
			
		} else if(typeUser == "funcionario"){
			
			folderPath = "/funcionarios/";
			
		}
		
		Path path = Paths.get(absolutePath + folderPathImage + folderPath + image);
		Files.write(path, bytes);

		return image;

	}

	public String getImage(String imageName, String typeUser) {
		
		if(typeUser == "admin") {
			folderPath = "/admins/";
		} else {
			folderPath = "/funcionarios/";
		}


		String pathImage = Paths.get(absolutePath + folderPathImage + folderPath + imageName).toString();

		return pathImage;
	}

	private String getExtensionImage(MultipartFile imageFile) {

		String imageName = imageFile.getOriginalFilename();

		int lastDotIndex = imageName.lastIndexOf(".");

		String extension = "";

		if (lastDotIndex != -1 && lastDotIndex < imageName.length() - 1) {
			
			return imageName.substring(lastDotIndex + 1).toLowerCase();

		} else {
			return null;
		}

	}

	private String getImageName(String fileName) {

		int lastDotIndex = fileName.lastIndexOf(".");

		if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {

			return fileName.substring(0, lastDotIndex);
		} else {
			return fileName;
		}
	}
}