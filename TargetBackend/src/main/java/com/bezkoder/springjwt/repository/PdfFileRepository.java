package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {

    PdfFile findByFileName(String fileName);
    public PdfFile getFileById(Long id) ;
}