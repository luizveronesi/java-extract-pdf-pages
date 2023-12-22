package dev.luizveronesi.pdfextract.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadRequest {

    private String folder;

    private MultipartFile file;
}
