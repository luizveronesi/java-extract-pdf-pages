package dev.luizveronesi.pdfextract.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.SystemUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PdfSplitterService {

	// I use this to work at my windows desktop
	private static final String DEFAULT_WINDOWS_DRIVER = "C:\\";

	private static final String JPEG_NAME = "JPEG";
	private static final String JPEG_EXTENSION = ".jpg";
	private static final String SPLIT_PREFIX = "split_";

	// returns the number of generated images
	public List<String> execute(InputStream is, String outputFolder) throws Exception {
		var list = new ArrayList<String>();

		var pd = PDDocument.load(is);
		var pr = new PDFRenderer(pd);
		for (int i = 0; i < pd.getNumberOfPages(); i++) {
			var order = i + 1;
			BufferedImage bi = pr.renderImageWithDPI(i, 300);
			list.add(this.saveImage(bi, order, outputFolder));
		}
		is.close();
		pd.close();

		return list;
	}

	private String saveImage(BufferedImage bi, Integer order, String folder) throws Exception {
		var filename = SPLIT_PREFIX + order + JPEG_EXTENSION;

		if (!new File(folder).exists())
			new File(folder).mkdir();

		ImageIO.write(bi, JPEG_NAME, this.createOutputFile(folder, filename));

		return filename;
	}

	private File createOutputFile(String folder, String filename) {
		File dir = new File(folder);
		if (!dir.exists())
			dir.mkdir();

		String output = dir + File.separator + filename;
		if (SystemUtils.IS_OS_WINDOWS)
			output = DEFAULT_WINDOWS_DRIVER + output;

		return new File(output);
	}

}
