import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		File file = new File(args[0]);
		Reader ir = new InputStreamReader(
				new FileInputStream(file));
		BufferedReader in = new BufferedReader(ir);
		String line;
		try {
			while ((line = in.readLine()) != null)
				System.out.println(line);
		} catch (FileNotFoundException e) {
			System.out.println("File Disappeared");
		}
	}
}
