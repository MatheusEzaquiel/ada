package com.ada.api.service.imagem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	@Autowired
	HashImage hashImage;

	Path currentPath = Paths.get(".");
	Path absolutePath = currentPath.toAbsolutePath();
	String folderPath = "/src/main/resources/static/images/admins/";

	public String saveImage(MultipartFile imageFile) throws IOException {

		byte[] bytes = imageFile.getBytes();

		String extension = getExtensionImage(imageFile);
		String imageName = getImageName(imageFile.getOriginalFilename());
	
		String hashImageName = hashImage.hashFileName(imageName);
		
		String image = hashImageName + "." + extension;


		Path path = Paths.get(absolutePath + folderPath + image);
		Files.write(path, bytes);

		return image;

	}

	public String getImage(String imageName) {

		String pathImage = Paths.get(absolutePath + folderPath + imageName).toString();

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