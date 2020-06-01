package com.spring.eventsplanner.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.eventsplanner.storage.StorageFileNotFoundException;
import com.spring.eventsplanner.storage.StorageService;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@PostMapping("/image")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("locationName", file.getOriginalFilename());

		String directoryString = "src/main/resources/static/img/docs";
		File theFile = new File(directoryString, file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(theFile, file.getBytes());

		return "redirect:/locations/add";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
