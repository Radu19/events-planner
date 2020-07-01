package com.spring.eventsplanner.controller;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
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
	
	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@PostMapping("/location-image")
	public String locationImageUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("locationImg", file.getOriginalFilename());

		String directoryString = "src/main/resources/static/img/locations";
		File theFile = new File(directoryString, file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(theFile, file.getBytes());

		return "redirect:/locations/add";
	}
	
	@PostMapping("/organizer-image")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("organizerImg", file.getOriginalFilename());

		String directoryString = "src/main/resources/static/img/team";
		File theFile = new File(directoryString, file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(theFile, file.getBytes());

		return "redirect:/register/form";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
