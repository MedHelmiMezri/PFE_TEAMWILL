package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.PdfFile;
import com.bezkoder.springjwt.services.PdfFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfFileService pdfFileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPdfFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {
        pdfFileService.saveFile(file, fileName);
        return ResponseEntity.ok("File uploaded successfully!");
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadPdfFile(@PathVariable("fileName") String fileName, HttpServletRequest request) throws FileNotFoundException {
        Resource resource = pdfFileService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/files")
    public List<PdfFile> getAllPdfFiles() {
        return pdfFileService.getAllFiles();
    }


}
