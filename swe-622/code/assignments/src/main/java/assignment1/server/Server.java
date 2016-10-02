/* SWE 622 - Distributed Software Engineering
 * Programming assignment 1
 * Server.java
 * 
 * @author shaeqkhan
 * @lastmodified 10/14/2012
 */

package assignment1.server;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {

		// creating 3 threads with ports 3333,3334,3335 which allows client to
		// connect to any
		// one of them to upload or download files
		try {

			new Thread() {

				public void run() {

					try {

						ServerSocket ss = new ServerSocket(3333);
						System.out.println("\nWaiting for client...");

						while (true) {

							// make server listen for connection and inform when
							// it gets one
							Socket socket = ss.accept();
							System.out.println("\nClient connected \n");
							Connection c = new Connection(socket);

						} // end of while

					} catch (Exception e) {
						e.printStackTrace();
					}
				} // end of run
			}.start(); // end of thread

			new Thread() {

				public void run() {

					try {

						ServerSocket ss = new ServerSocket(3334);
						System.out.println("\nWaiting for client...");

						while (true) {

							// make server listen for connection and inform when
							// it gets one
							Socket socket = ss.accept();
							System.out.println("\nClient connected \n");
							Connection c = new Connection(socket);

						} // end of while

					} catch (Exception e) {
						e.printStackTrace();
					}

				} // end of run

			}.start(); // end of thread

			new Thread() {

				public void run() {

					try {

						ServerSocket ss = new ServerSocket(3335);
						System.out.println("\nWaiting for client...");

						while (true) {

							// make server listen for connection and inform when
							// it gets one
							Socket socket = ss.accept();
							System.out.println("\nClient connected \n");
							Connection c = new Connection(socket);

						} // end of while

					} catch (Exception e) {
						e.printStackTrace();
					}

				} // end of run

			}.start(); // end of thread

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main

} // end of Server

class Connection extends Thread {

	Socket ss;

	// streams converted to handle strings
	DataInputStream in;
	DataOutputStream out;

	// initialize input and output streams of the socket to receive
	// and send data to client
	InputStream sin;
	OutputStream sout;

	// constructor
	public Connection(Socket clientSocket) {

		try {

			ss = clientSocket;
			sin = ss.getInputStream();
			sout = ss.getOutputStream();
			in = new DataInputStream(sin);
			out = new DataOutputStream(sout);

			this.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of constructor

	public void run() {

		// variable to record client request
		int choice = 0;

		try {

			choice = in.readInt();
			out.writeBoolean(true);
			out.flush();

			if (choice == 1) {

				// store path for server received from client
				String path = "";

				// copy path sent from client
				path = in.readUTF();
				System.out.println("\nServer path received: " + path + "\n");

				// create file with specified path
				File f = new File(path);

				// array of files to store and view all folders and files
				File[] listOfFiles = f.listFiles();

				// variable to store all file and folder names
				String names = "";

				// for-each loop to traverse through the files and get their
				// names
				for (File l : listOfFiles) {
					if (!l.isDirectory())
						names = names + " --- " + l.getName() + "\n";
					else
						names = names + " * " + l.getName() + "\n";
				}

				// send name of files and folders to client
				out.writeUTF(names);
				out.flush();

				System.out.println("\nFile names sent!");
				System.out.println("\nWaiting...\n");

			} // end of choice 1, view files on server

			// upload file to server
			if (choice == 2) {

				// read path for server from client
				String pathName = in.readUTF();

				// new file created
				File f = new File(pathName);
				String fileName = f.getName();
				System.out.println("\nFile created : " + fileName);

				// sent confirmation to client
				out.writeBoolean(true);

				// output stream to write to the file f
				FileOutputStream fos = null;

				try {
					fos = new FileOutputStream(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				// output stream to write bytes
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] aByte = new byte[1];
				int bytesRead = 0;

				try {

					// output stream bound to the file output stream
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bytesRead = sin.read(aByte, 0, aByte.length);

					do {
						baos.write(aByte);
						bytesRead = sin.read(aByte);
					} while (bytesRead != -1);

					bos.write(baos.toByteArray());

					bos.flush();
					bos.close();

					System.out.println("\nFile received from client successfully!");

				} catch (Exception e) {
					e.printStackTrace();
				}

			} // end of choice 2, upload file to server

			// download file from server
			if (choice == 3) {

				boolean fileFound = true;
				String path = "";

				// copy path sent from client
				path = in.readUTF();
				System.out.println("Server received path: " + path + "\n");

				File f = new File(path);

				try {

					String fileName = f.getName();
					out.writeUTF(fileName);
					out.flush();

				} catch (IOException e) {
					fileFound = false;
					System.out.println("\nRequested file was not found on the server.");
				}

				boolean flag = false;

				try {

					flag = in.readBoolean();

				} catch (IOException e) {
					e.printStackTrace();
				}

				if (flag) {

					byte[] serverByteArray = new byte[(int) f.length()];
					FileInputStream fis = null;

					try {

						fis = new FileInputStream(f);

					} catch (FileNotFoundException e) {
						fileFound = false;
						System.out.println("\nRequested file was not found on the server.");
					}

					BufferedInputStream bis = new BufferedInputStream(fis);
					BufferedOutputStream bos = new BufferedOutputStream(sout);

					try {

						bis.read(serverByteArray, 0, serverByteArray.length);
						bos.write(serverByteArray, 0, serverByteArray.length);
						bos.flush();
						bos.close();
						ss.close();
						if (fileFound)
							System.out.println("\nFile transferred to client successfully!");

					} catch (FileNotFoundException e) {
						System.out.println("\nRequested file was not found on the server.");
					}

				} // end of if(flag)

			} // end of choice 3, download file from server

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of run

} // end of Connection