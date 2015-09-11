package RSA;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;

import javax.media.jai.Histogram;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.sun.media.jai.widget.DisplayJAI;

//import javax.media.jai.operator.*;

public class clsImage1 {
	PlanarImage image, outputImage, sobelImage;
	private SampleModel sm;
	private ParameterBlock pb;
	private Histogram ht;
	private String fileName = "";
	// private clsDisplayHistogram frameH;
	private JFrame frameI;
	private Container c;
	private int[][] intensityM;
	private int[] edgeM;
	private WritableRaster outputRaster;
	private Raster inputRaster;
	private int[][] matAux, matAux2;
	private double[] vecLocalThreshold;
	public int Cn, Tn;

	// constructor mas usado!
	clsImage1(String cadena) {
		defineAttibutes(cadena);
	}

	public PlanarImage getImage() {
		return this.image;
	}

	private void defineAttibutes(String cadena) {
		int nbrOfBands = 1; // trabajare con grayscale.
		this.image = JAI.create("fileload", cadena);
		this.sm = this.image.getSampleModel();
		this.pb = new ParameterBlock();
		this.fileName = cadena;
		this.frameI = new JFrame();
		this.intensityM = new int[getHeight()][getWidth()]; // info de
															// intensidad
		this.edgeM = new int[nbrOfBands * getWidth() * getHeight()];// matriz
																	// boolean.
																	// cada
																	// pixel es
																	// o no
																	// borde.
		this.vecLocalThreshold = new double[getHeight() * getWidth() * 1];
		setMatTam(3, 3);
		this.Cn = 5;
		this.Tn = 35;
	}

	private void setMatTam(int fila, int columna) {
		this.matAux = new int[fila][columna];
		this.matAux = new int[fila][columna];
	}

	protected int getWidth() {
		return this.image.getWidth();
	}

	protected int getNbrOfBands() {
		return this.image.getNumBands();
	}

	protected int getHeight() {
		return this.image.getHeight();
	}

	private PlanarImage getPlanarImage() {
		return this.image;
	}

	// opcion para retocar la imagen original (input)
	public void applySobelEdgeDetection() {
		float[] kernelMatriz = { 0, -1, 0, -1, 4, -1, 0, -1, 0 };
		KernelJAI kernel = new KernelJAI(3, 3, kernelMatriz);
		this.sobelImage = JAI.create("convolve", this.image, kernel);
	}

	// obtiene la matriz de intensidad
	public void generateIntensityM() {
		int offset = 0, nbrOfBands, h, w;
		this.sm = this.image.getSampleModel();
		this.inputRaster = this.image.getData();
		nbrOfBands = 1; // es para grayscale.
		int[] pixels = new int[nbrOfBands * getWidth() * getHeight()];
		this.inputRaster.getPixels(0, 0, getWidth(), getHeight(), pixels);
		for (h = 0; h < getHeight(); h++) {
			for (w = 0; w < getWidth(); w++) {
				offset = h * getWidth() * nbrOfBands + w * nbrOfBands;
				this.intensityM[h][w] = pixels[offset];
				System.out.println(this.intensityM[h][w]);
			}
		}
	}

	// viene desde afuera una matriz booleana. debo transformarla en array.
	private void generateEdgeM(int[][] edgeM) {
		int offset, nbrOfBands, h, w;
		nbrOfBands = 1;
		for (h = 0; h < getHeight(); h++) {
			for (w = 0; w < getWidth(); w++) {
				offset = h * getWidth() * nbrOfBands + w * nbrOfBands;
				this.edgeM[offset] = edgeM[h][w];
			}
		}
	}

	// para generar la salida, debo tomar la matriz booleana y transformarla en
	// vector
	public void generateOutputImage(int[][] edgeM) {
		this.outputRaster = this.inputRaster.createCompatibleWritableRaster();
		generateEdgeM(edgeM); // invoco al metodo de arriba
		this.outputRaster.setPixels(0, 0, getWidth(), getHeight(), this.edgeM);
		TiledImage ti = new TiledImage(getPlanarImage(), 1, 1);
		ti.setData(this.outputRaster);
		this.outputImage = ti;
	}

	// graba la imagen umbralizada
	public void saveOutputImage() {
		JAI.create("filestore", this.outputImage, "output.tiff", "TIFF");
		System.out.println("result file saved successfully...!");
	}

	// devuelve la matriz intensidad
	public int[][] getIntensityM() {
		return this.intensityM;
	}

	// Muestra el histograma de una imagen cargada
	/*
	 * public void displayHistogram(){ JFrame f = new JFrame("Histograma");
	 * clsDisplayHistogram dh = new clsDisplayHistogram(ht,"256 bins");
	 * dh.setBinWidth(2); dh.setHeight(160); dh.setIndexMultiplier(1);
	 * f.getContentPane().add(dh); f.pack(); f.setVisible(true); }
	 */
	// Genera el histograma
	public void generateHistogram() {
		pb.addSource(getPlanarImage());
		pb.add(null); // The ROI.
		pb.add(1); // Samplings.
		pb.add(1);
		pb.add(new int[] { 256 }); // Num. bins.
		pb.add(new double[] { 0 }); // Min value to be considered.
		pb.add(new double[] { 256 }); // Max value to be considered.
		// Creates the histogram.
		PlanarImage temp = JAI.create("histogram", pb);
		ht = (Histogram) temp.getProperty("histogram");
	}

	protected Histogram getHistogram() {
		return ht;
	}

	// Muestra la imagen creada por el filtro de sobel
	public void displayImage() {
		DisplayJAI dj;
		String imageInfo = "Dimensions: " + image.getWidth() + " x "
				+ image.getHeight();
		frameI.setTitle("Original Image: " + fileName);
		Container contentPane = frameI.getContentPane();
		contentPane.setLayout(new BorderLayout());
		dj = new DisplayJAI(image);
		contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);
		contentPane.add(new JLabel(imageInfo), BorderLayout.SOUTH);
		frameI.setSize(800, 800); // adjust the frame size.
		frameI.setVisible(true); // show the frame.
	}

	// Muestra la imagen tratada por el algortimo
	public void displayBordes() {
		DisplayJAI dj;
		String imageInfo = "Dimensions: " + image.getWidth() + " x "
				+ image.getHeight();
		frameI.setTitle("Original Image: " + fileName);
		Container contentPane2 = frameI.getContentPane();
		contentPane2.setLayout(new BorderLayout());
		dj = new DisplayJAI(image);
		contentPane2.add(new JScrollPane(dj), BorderLayout.CENTER);
		contentPane2.add(new JLabel(imageInfo), BorderLayout.SOUTH);
		frameI.setSize(800, 800); // adjust the frame size.
		frameI.setVisible(true); // show the frame.
	}

	// Se comunica con la interfaz para aplicar el algoritmo
	public void FinalImage() {
		this.generateIntensityM();
		int[][] LocalMat = createLocalMat();
		int[][] GlobalMat = createGlobalMat();
		int[][] FinalMat = createMatFinal(LocalMat, GlobalMat);
		generateOutputImage(FinalMat);
	}

	// compara las 2 matrices para generar el borde final
	private int[][] createMatFinal(int[][] LocalMat, int[][] GlobalMat) {
		int i, j;
		int[][] Final = new int[this.getWidth()][this.getHeight()];
		for (i = 1; i < this.getWidth() - 3; i++) {
			for (j = 0; j < this.getHeight() - 3; j++) {
				if (LocalMat[i + 1][j + 1] == 255
						&& GlobalMat[i + 1][j + 1] == 255) {
					Final[i + 1][j + 1] = 255;
				} else {
					Final[i + 1][j + 1] = 0;
				}
			}
		}
		return Final;
	}

	// Crea la matriz apartir del umbral local y las 16 comparaciones
	private int[][] createLocalMat() {
		this.intensityM = getIntensityM();
		int i, j, ind = 1, k, l;
		int[][] aux2 = new int[3][3];
		int[][] LocalMat = new int[image.getWidth()][image.getHeight()];
		for (i = 1; i <= image.getWidth() - 3; i++) {
			for (j = 0; j <= image.getHeight() - 3; j++) {
				this.matAux = cargaMatrix3x3(this.intensityM[i][j],
						this.intensityM[i][j + 1], this.intensityM[i][j + 2],
						this.intensityM[i + 1][j],
						this.intensityM[i + 1][j + 1],
						this.intensityM[i + 1][j + 2],
						this.intensityM[i + 2][j],
						this.intensityM[i + 2][j + 1],
						this.intensityM[i + 2][j + 2]);
				this.vecLocalThreshold[ind] = LocalThreshold();
				for (k = 0; k < 3; k++) {
					for (l = 0; l < 3; l++) {
						if (this.matAux[k][l] > this.vecLocalThreshold[ind])
							aux2[k][l] = 255;
						else
							aux2[k][l] = 0;
					}
				}
				if (iqualMat(aux2))
					LocalMat[i + 1][j + 1] = 255;
				else
					LocalMat[i + 1][j + 1] = 0;

				ind++;
			}
		}
		return LocalMat;
	}

	// genera el umbral local
	private double LocalThreshold() {
		int f, c;
		double Mean = 0.0;
		for (f = 0; f <= 2; f++) {
			for (c = 0; c <= 2; c++)
				Mean = Mean + this.matAux[f][c];
		}
		return Mean = (Mean / 9) - this.Cn;
	}

	// entra por parametro una matriz de 3x3 con valores 0 ó 255,
	// la compara con los 16 patrones precargados
	private boolean iqualMat(int[][] matA) {
		boolean flag = false;
		int i = 0;
		Object[] matB = new Object[16];
		matB = MatPrecarg();
		while (i < 16 && !flag) {
			this.matAux = (int[][]) matB[i];
			if (comp(matA, this.matAux))
				flag = true;
			else
				i++;
		}
		return flag;
	}

	// compara si dos matrices son iguales
	private boolean comp(int[][] matA, int[][] matB) {
		int i = 0, j = 0, cont = 0;
		while (i < 3) {
			j = 0;
			while (j < 3) {
				if (matA[i][j] == matB[i][j])
					cont++;
				j++;
			}
			i++;
		}
		if (cont == 9)
			return true;
		else
			return false;
	}

	// aplica el umbral global
	private int[][] createGlobalMat() {
		int i, j, ind = 0;
		int[][] GlobalMat = new int[image.getWidth()][image.getHeight()];
		for (i = 0; i <= image.getHeight() - 3; i++) {
			for (j = 0; j <= image.getWidth() - 3; j++) {
				this.matAux = cargaMatrix3x3(this.intensityM[i][j],
						this.intensityM[i][j + 1], this.intensityM[i][j + 2],
						this.intensityM[i + 1][j],
						this.intensityM[i + 1][j + 1],
						this.intensityM[i + 1][j + 2],
						this.intensityM[i + 2][j],
						this.intensityM[i + 2][j + 1],
						this.intensityM[i + 2][j + 2]);
				if (this.Tn < GlobalThreshold(ind))
					GlobalMat[i + 1][j + 1] = 255;
				else
					GlobalMat[i + 1][j + 1] = 0;
				ind++;
			}
		}
		return GlobalMat;
	}

	// genera el umbral global para cada matriz
	private double GlobalThreshold(int i) {
		int f, c;
		double Tg = 0, Aux;
		for (f = 0; f < 2; f++) {
			for (c = 0; c < 2; c++) {
				Aux = Math.pow((this.matAux[f][c] - this.vecLocalThreshold[i]),
						2);
				Tg = Tg + Aux;
			}
		}
		return Tg / 9;
	}

	// carga especifimanente matrices de 3x3
	private int[][] cargaMatrix3x3(int i, int j, int k, int l, int m, int n,
			int o, int p, int q) {
		int[][] aux = new int[3][3];
		aux[0][0] = i;
		aux[0][1] = j;
		aux[0][2] = k;
		aux[1][0] = l;
		aux[1][1] = m;
		aux[1][2] = n;
		aux[2][0] = o;
		aux[2][1] = p;
		aux[2][2] = q;
		return aux;
	}

	// genera matrices precargadas
	private Object[] MatPrecarg() {
		Object[] Vec = new Object[16];
		Vec[0] = cargaMatrix3x3(0, 255, 255, 0, 255, 255, 0, 255, 255);
		Vec[1] = cargaMatrix3x3(0, 0, 0, 255, 255, 255, 255, 255, 255);
		Vec[2] = cargaMatrix3x3(255, 255, 0, 255, 255, 0, 255, 255, 0);
		Vec[3] = cargaMatrix3x3(255, 255, 255, 255, 255, 255, 0, 0, 0);
		Vec[4] = cargaMatrix3x3(255, 255, 255, 0, 255, 255, 0, 0, 255);
		Vec[5] = cargaMatrix3x3(255, 0, 0, 255, 255, 0, 255, 255, 255);
		Vec[6] = cargaMatrix3x3(0, 0, 255, 0, 255, 255, 255, 255, 255);
		Vec[7] = cargaMatrix3x3(255, 255, 255, 255, 255, 0, 255, 0, 0);
		Vec[8] = cargaMatrix3x3(0, 255, 255, 0, 255, 255, 0, 0, 255);
		Vec[9] = cargaMatrix3x3(255, 0, 0, 255, 255, 0, 255, 255, 0);
		Vec[10] = cargaMatrix3x3(255, 255, 255, 0, 255, 255, 0, 0, 0);
		Vec[11] = cargaMatrix3x3(255, 255, 255, 255, 255, 0, 0, 0, 0);
		Vec[12] = cargaMatrix3x3(0, 0, 0, 0, 255, 255, 255, 255, 255);
		Vec[13] = cargaMatrix3x3(0, 0, 0, 255, 255, 0, 255, 255, 255);
		Vec[14] = cargaMatrix3x3(0, 0, 255, 0, 255, 255, 0, 255, 255);
		Vec[15] = cargaMatrix3x3(255, 255, 0, 255, 255, 0, 255, 0, 0);
		return Vec;
	}
}