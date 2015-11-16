import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<String> lista = new ArrayList<String>();
	public static final String SOURCE_FOLDER = "C:\\Users\\your.user\\Downloads\\folder\\";
	public static final String DEST_FOLDER = "C:\\Users\\your.user\\Downloads\\folder\\nomes.txt";

	public static void main(String[] args) throws IOException {

		File folder = new File(SOURCE_FOLDER);
		if (folder.exists()) {
			File[] listOfFiles = folder.listFiles();
			for (File ficheiro : listOfFiles) {
				lePastas(ficheiro);
			}

		}
		if (lista.size() > 0) {
			File txt = new File(DEST_FOLDER);
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
			lista.add(ficheiro.getName());
			System.out.println(ficheiro.getName());
		}
	}

}
