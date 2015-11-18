import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<String> lista = new ArrayList<String>();
	public static final String SOURCE_FOLDER = "\\Defravapfl21\\21EM0068\\0\\02 PI\\01_ Projectos\\ACTUAIS\\EDP\\2015\\Documentos Suporte\\EDPonCloud\\";
	public static final String DEST_FOLDER = "\\Defravapfl21\\21EM0068\\0\\02 PI\\01_ Projectos\\ACTUAIS\\EDP\\2015\\Documentos Suporte\\EDPonCloud\\nomes.txt";

	public static void main(String[] args) throws IOException, URISyntaxException {

		File folder = new File(new URI("file:" + SOURCE_FOLDER));
		if (folder.exists()) {
			File[] listOfFiles = folder.listFiles();
			for (File ficheiro : listOfFiles) {
				lePastas(ficheiro);
			}

		}
		if (lista.size() > 0) {
			File txt = new File(new URI("file:" + DEST_FOLDER));
			if (!txt.exists()) {
				txt.createNewFile();
			}
			FileWriter writer = new FileWriter(txt);
			for (String str : lista) {
				writer.write(str);
				writer.write(System.lineSeparator());
			}
			writer.close();
		}

	}

	private static void lePastas(File ficheiro) {
		if (!ficheiro.isFile()) {
			for (File insider : ficheiro.listFiles()) {
				lePastas(insider);
			}
		} else {
			lista.add(ficheiro.getPath());
			System.out.println(ficheiro.getPath());
		}
	}

}
