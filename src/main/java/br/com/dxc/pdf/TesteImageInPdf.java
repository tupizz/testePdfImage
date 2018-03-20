package br.com.dxc.pdf;

public class TesteImageInPdf {
	public static final String PDF_SRC = "src/main/resources/pdfs/hello.pdf";
	public static final String PDF_OUT = "src/results/new_pdf.pdf";
	public static final String IMG_SRC = "src/main/resources/images/footo.jpg";

	public static void main(String[] args) {
		BuilderPDFWithImage builder = new BuilderPDFWithImage();
		
		PlacingImageInPdfDocument imgInPdf = builder.configImageSource(IMG_SRC)
													.configPathOutput(PDF_OUT)
													.configPdfSource(PDF_SRC)
													.configImageDimension(50f)
													.configOffset(17f)
													.build();
		
		imgInPdf.inputImageInPDFHeader();
	}
}
