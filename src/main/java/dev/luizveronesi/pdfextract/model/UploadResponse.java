package dev.luizveronesi.pdfextract.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UploadResponse {

	private String name;
	private String originalName;
	private String folder;
	private Integer total;
}
