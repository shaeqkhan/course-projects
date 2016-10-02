/* SWE 622 - Distributed Software Engineering
 * Programming assignment 1
 * Client.java
 * 
 * @author shaeqkhan
 * @lastmodified 10/14/2012
 */

package assignment1.client;

import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Client {

	public static void main(String[] args) {

		// declare server's port address
		int serverPort;

		// client enters port to connect
		System.out.println("\nAvailable ports : 3333,3334,3335");
		System.out.println("\nEnter the port you want to connect to: ");
		Scanner a = new Scanner(System.in);
		serverPort = a.nextInt();

		// ip address of server program's computer i.e the same computer in
		// this case
		String address = "127.0.0.1";

		try {

			// create object to represent above ip address
			InetAddress ipAddress = InetAddress.getByName(address);

			// create socket with server ip and server port
			System.out.println("\nInitializing socket...");
			Socket socket = new Socket(ipAddress, serverPort);

			// initialize input and output streams of the socket to receive
			// and send data to client
			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();

			// streams converted to handle strings
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			// to read request from client
			Scanner keyboard = new Scanner(System.in);

			// variable to store client request made to server
			int choice = 0;

			// menu displayed
			System.out.println("\nClient menu");
			System.out.println("1. View files on server");
			System.out.println("2. Upload file to server");
			System.out.println("3. Download file from server");
			System.out.println("4. Exit");

			// read client request
			System.out.println("\nWhat do you want to do? (1,2,3 or 4)");
			choice = keyboard.nextInt();

			// inform server of client request
			out.writeInt(choice);

			// flush stream to make sure choice reaches server
			out.flush();

			// boolean variable to record server response to client request
			boolean ok = false;
			ok = in.readBoolean();

			// client requests to view files on the server
			if (ok && choice == 1) {

				// store path of server entered by client
				String path = "";

				// request client to enter server folder path they want to
				// access
				System.out.println("\nEnter server folder path: ");
				Scanner p = new Scanner(System.in);
				path = p.nextLine();

				System.out.println("\nSending request to server...");

				// send path to server
				out.writeUTF(path);

				// flush stream to make sure path reaches server
				out.flush();

				// string variable to store names of files and folders sent from
				// server
				String files = "";

				// wait for server to send line of text and then close socket
				files = in.readUTF();
				socket.close();

				// display files to client
				System.out.println("\nFiles on server: \n" + files);

			}

			// client requests to upload file to server
			if (ok && choice == 2) {

				// boolean variable to record if the file to be uploaded is
				// available
				// with client
				boolean fileFound = true;

				// streams converted to write bytes
				BufferedOutputStream bout = new BufferedOutputStream(sout);

				// string to store path of file from client side
				String path = "";
				Scanner q = new Scanner(System.in);
				System.out.println("\nEnter file path on client side: ");
				path = q.nextLine();

				// create file with path
				File f = new File(path);

				try {

					// string to store path to which file has to be uploaded on
					// server
					String serverPath = "";
					System.out.println("\nEnter file path for server side to upload file on this location: ");
					Scanner r = new Scanner(System.in);
					serverPath = r.nextLine();

					// send this path to server
					out.writeUTF(serverPath);

					// flush stream to make sure path reaches server
					out.flush();

				} catch (IOException e) {
					fileFound = false;
					System.out.println("The requested file was NOT found on the client side.");
				}

				// flag variable to check if the path reached the server
				boolean flag = false;

				// server flags client to go ahead
				try {

					flag = in.readBoolean();

				} catch (IOException e) {
					e.printStackTrace();
				}

				// server says true
				if (flag) {

					// byte array to store content of file in bytes
					byte[] clientByteArray = new byte[(int) f.length()];

					// obtain input bytes in a file
					FileInputStream fis = null;

					// bind the input stream to the file
					try {
						fis = new FileInputStream(f);
					} catch (FileNotFoundException e) {
						fileFound = false;
						System.out.println("The requested file was NOT found on the client side.");
					}

					// adding functionality to the file input stream
					BufferedInputStream bis = new BufferedInputStream(fis);

					try {

						// read bytes from input stream and write to output
						// stream
						bis.read(clientByteArray, 0, clientByteArray.length);
						bout.write(clientByteArray, 0, clientByteArray.length);

						// flush stream to make sure contents of stream reaches
						// server
						bout.flush();

						// close stream and socket
						bout.close();
						socket.close();

						if (fileFound)
							System.out.println("\nFile sent to server successfully!");

					} catch (FileNotFoundException e) {
						System.out.println("The requested file was NOT found on the client side.");
					}
				} // end of server says true

			} // end of choice==2, client uploading file to server

			// client downloads file from server
			if (ok && choice == 3) {

				String path = "";

				Scanner t = new Scanner(System.in);
				System.out.println("\nEnter file path on server: ");
				path = t.nextLine();

				System.out.println("\nSending request to server...");

				// send path to server
				out.writeUTF(path);

				// flush stream to make sure line reaches server
				out.flush();

				// wait for server to send name of file that was requested
				String fileName = in.readUTF();

				// create file with path
				File f = new File(fileName);
				System.out.println("\nFile created : " + fileName);

				// indication to server that instance of file is created and
				// client is ready to recieve byte stream from server
				out.writeBoolean(true);

				// file output stream to write data into a file
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				// byte array as temp storage
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] aByte = new byte[1];
				int bytesRead = 0;

				try {

					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bytesRead = sin.read(aByte, 0, aByte.length);

					do {
						baos.write(aByte);
						bytesRead = sin.read(aByte);
					} while (bytesRead != -1);

					bos.write(baos.toByteArray());

					bos.flush();
					bos.close();

					socket.close();

					System.out.println("\nFile received from server successfully!");

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if (ok && choice == 4) {
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} // end of big try block

	} // end of main

} // end of Client