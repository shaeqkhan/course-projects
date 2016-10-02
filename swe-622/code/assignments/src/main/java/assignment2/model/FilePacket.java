/*
 * SWE 622 - Programming Assignment 2
 * @author shaeqkhan
 */

package assignment2.model;

import java.io.*;

/*
 * Class to represent a File object that can be sent
 * and received by client and server
 */
public class FilePacket implements Serializable {

	// file path name
	private String name;
	// data in the file
	private byte[] data;

	// constructor
	public FilePacket(String name) {
		this.name = name;
	}

	// getters of file names
	public String getFilePacketName() {
		return name;
	}

	public String getOnlyFileName() {
		File f = new File(name);
		return f.getName();
	}

	public byte[] getData() {
		return data;
	}

	// reading the contents of the file in a byte array
	public void readIn() {
		try {
			File file = new File(name);
			data = new byte[(int) (file.length())];
			(new FileInputStream(file)).read(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of readIn

	// writing content of a file using an outputstream
	public void writeTo(OutputStream out) {
		try {
			out.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of writeTo

} // end of FilePacket