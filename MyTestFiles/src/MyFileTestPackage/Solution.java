package MyFileTestPackage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		File f = new File("mytest.txt");
		Writer writer = new FileWriter(f);
		StringBuilder sb = new StringBuilder();
		char buf[] = new char[16];
		int line = 100;
		while (line-- > 0) {
			writer.write("hell");
			writer.write("\n");
		}
		writer.flush();
		writer.close();
		Reader reader = new FileReader(f);
		int read = reader.read(buf);
		while (read > 0) {
			sb.append(buf, 0, read);
			System.out.println(sb.toString() + " " + read);
			read=reader.read(buf);
		}
		System.out.println(reader.read());
		reader.close();
		System.out.println(f.exists() + " " + f.getAbsolutePath());
		System.out.println("Executed");
		
		Path p=Path.of("myPath.txt");
		System.out.println(p.isAbsolute());
		System.out.println(p.getRoot());
		Path dir=Path.of("myDir/dir1/dir2");
		Files.createDirectories(dir);
		
		
		
	}
}
