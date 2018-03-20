package br.com.dxc.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PlacingImageInPdfDocument {

	private String pdfSource;
	private String pdfDestination;
	private String imgSource;
	private Float imageDimension;
	private Float imageOffset;

	/**
	 * Construtor utilizado pelo BuilderPDFWithImage
	 * 
	 * @param pdfSource - Path até PDF original, que deverá ser alterado no processo.
	 * @param pdfDestination - Onde o novo arquivo em PDF deve ser salvo.
	 * @param imgSource - Fonte da imagem a ser utilizada para inserção no PDF.
	 * @param imageDimension - Definição da dimensão a ser seguida pela imagem.
	 * @param imageOffset - Offset/Padding da imagem em relação ao seu ponto de inserção.
	 */
	public PlacingImageInPdfDocument(String pdfSource, String pdfDestination, String imgSource, Float imageDimension, Float imageOffset) {
		this.pdfSource = pdfSource;
		this.pdfDestination = pdfDestination;
		this.imgSource = imgSource;
		this.imageDimension = imageDimension;
		this.imageOffset = imageOffset;
	}

	/**
	 * Função de inserção da imagem no arquivo PDF.
	 */
	public void inputImageInPDFHeader() {
		try {
			PdfReader reader = new PdfReader(pdfSource);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pdfDestination));
			
			Image image = Image.getInstance(this.imgSource);
			image.scaleToFit(imageDimension, imageDimension);
			final float Y_POSITION_OF_IMAGE = reader.getPageSize(1).getHeight() - image.getScaledHeight();
			image.setAbsolutePosition(imageOffset, Y_POSITION_OF_IMAGE - imageOffset);

			PdfContentByte over = stamper.getOverContent(1);
			over.addImage(image);

			stamper.close();
			reader.close();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
