package dev.luizveronesi.pdfextract.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luizveronesi.pdfextract.controller.documentation.UploadControllerDocumentation;
import dev.luizveronesi.pdfextract.model.UploadRequest;
import dev.luizveronesi.pdfextract.model.UploadResponse;
import dev.luizveronesi.pdfextract.service.UploadService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UploadController implements UploadControllerDocumentation {

    private final UploadService uploadService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<UploadResponse> upload(@ModelAttribute UploadRequest request) {
        return new ResponseEntity<>(uploadService.execute(request), HttpStatus.OK);
    }
}
