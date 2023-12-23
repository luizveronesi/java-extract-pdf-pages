package dev.luizveronesi.pdfextract.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import dev.luizveronesi.pdfextract.model.UploadRequest;
import dev.luizveronesi.pdfextract.model.UploadResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UploadService {

	private final PdfSplitterService pdfSplitterService;

	public UploadResponse execute(UploadRequest request) {
		this.validate(request);
		return this.upload(request);
	}

	private UploadResponse upload(UploadRequest request) {
		try {
			pdfSplitterService.execute(request.getFile().getInputStream(), request.getFolder());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return UploadResponse.builder()
				.originalName(request.getFile().getOriginalFilename())
				.name(request.getFile().getOriginalFilename())
				.folder(request.getFolder())
				.build();
	}

	private void validate(UploadRequest request) {
		if (StringUtils.isEmpty(request.getFolder())
				|| request.getFile().isEmpty()
				|| !request.getFile().getOriginalFilename().endsWith(".pdf"))
			throw new RuntimeException("folder or file is empty");
	}
}