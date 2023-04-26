package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.PdfFile;
import com.bezkoder.springjwt.repository.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class PdfFileService {
   @Autowired
    PdfFileRepository pdffilerepository ;

    @Autowired
    private ServletContext servletContext;


    public PdfFile saveFile(MultipartFile file, String fileName) throws IOException {
        PdfFile pdfFile = new PdfFile();
        pdfFile.setFileName(fileName);
        pdfFile.setData(file.getBytes());
        return pdffilerepository.save(pdfFile);
    }

    public ByteArrayResource loadFileAsResource(String fileName) throws FileNotFoundException {
        PdfFile pdfFile = pdffilerepository.findByFileName(fileName);
        if(pdfFile == null) {
            throw new FileNotFoundException("File not found with filename: " + fileName);
        }
        return new ByteArrayResource(pdfFile.getData());
    }

    public List<PdfFile> getAllFiles() {
        return pdffilerepository.findAll();
    }


}
