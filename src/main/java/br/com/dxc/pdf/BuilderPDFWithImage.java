package br.com.dxc.pdf;

import java.io.File;

public class BuilderPDFWithImage {
	
	private String pdfSource;
	private String pdfOutput;
	private String imgSource;
	private Float imageDimension;
	private Float imageOffset;
	
	/**
	 * 
	 * @param pdfSource - Path até PDF original, que deverá ser alterado no processo.
	 * @return BuilderPDFWithImage
	 */
	public BuilderPDFWithImage configPdfSource(String pdfSource) {
		this.pdfSource = pdfSource;
		return this;
	}
	
	/**
	 * 
	 * @param pathOutput - Onde o novo arquivo em PDF deve ser salvo.
	 * @return BuilderPDFWithImage
	 */
	public BuilderPDFWithImage configPathOutput(String pathOutput) {
		this.pdfOutput = pathOutput;
		File file = new File(pathOutput);
		file.getParentFile().mkdirs();
		return this;
	}
	
	/**
	 * 
	 * @param imgSource - Fonte da imagem a ser utilizada para inserção no PDF.
	 * @return BuilderPDFWithImage
	 */
	public BuilderPDFWithImage configImageSource(String imgSource) {
		this.imgSource = imgSource;
		return this;
	}
	
	/**
	 * 
	 * @param imageDimension - Definição da dimensão a ser seguida pela imagem.
	 * @return BuilderPDFWithImage
	 */
	public BuilderPDFWithImage configImageDimension(Float imageDimension) {
		this.imageDimension = imageDimension;
		return this;
	}
	
	/**
	 *
	 * @param imageOffset - Offset/Padding da imagem em relação ao seu ponto de inserção.
	 * @return BuilderPDFWithImage
	 */
	public BuilderPDFWithImage configOffset(Float imageOffset) {
		this.imageOffset = imageOffset;
		return this;
	}
	
	/**
	 * Builder para função de inserção de imagem em PDF.
	 * 
	 * @return PlacingImageInPdfDocument
	 */
	public PlacingImageInPdfDocument build() {
		return new PlacingImageInPdfDocument(pdfSource,pdfOutput,imgSource,imageDimension,imageOffset);
	}
	
	
}
