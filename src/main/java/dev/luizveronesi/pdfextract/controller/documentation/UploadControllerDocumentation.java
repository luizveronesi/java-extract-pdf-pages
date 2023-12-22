package dev.luizveronesi.pdfextract.controller.documentation;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import dev.luizveronesi.pdfextract.model.UploadRequest;
import dev.luizveronesi.pdfextract.model.UploadResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UploadControllerDocumentation {

        @Operation
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Retrieves logged user", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                        }),
                        @ApiResponse(responseCode = "404", description = "Resource not found", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                        }),
                        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                        })
        })
        ResponseEntity<UploadResponse> upload(@ModelAttribute UploadRequest request);
}