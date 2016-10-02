/*
 * SWE 622 - Programming Assignment 2
 * @author shaeqkhan
 */

package assignment2.client;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import assignment2.intf.FileReceiver;
import assignment2.model.FilePacket;

public class Client {

	public static void main(String args[]) throws Exception {

		// the remote receiver
		FileReceiver stub;
		Scanner k = new Scanner(System.in);
		Registry registry;

		System.out.println("\nEnter a port number for the registry: ");
		System.out.println("(Try different ports if 1099 is busy. e.g. 3333,5555)");
		int port = k.nextInt();

		// client enters port to connect
		System.out.println("\nAvailable Servers");
		System.out.println("\nServer A \t Server B");
		System.out.println("\nEnter choice 1 for A, 2 for B: ");
		int server = k.nextInt();

		System.out.println("\n1. View files on server");
		System.out.println("2. Upload file to server");
		System.out.println("3. Download file from server");
		System.out.println("\nWhat do you want to do?");
		int option = k.nextInt();

		if (server == 1) {

			if (option == 1) {

				registry = LocateRegistry.getRegistry(port);
				stub = (FileReceiver) registry.lookup("ServerA");

				File[] allFiles = stub.loadAllFileNames();

				System.out.println("\nFiles available on Server A");
				for (File l : allFiles)
					System.out.println("--" + l.getName());

			} // end of option 1

			if (option == 2) {

				try {

					registry = LocateRegistry.getRegistry(port);
					stub = (FileReceiver) registry.lookup("ServerA");

					System.out.println("\nEnter path of the file to upload: ");
					Scanner p = new Scanner(System.in);
					String uploadPath = p.nextLine();

					System.out.println("Sending: " + uploadPath);

					FilePacket packet = new FilePacket(uploadPath);
					packet.readIn();
					stub.receiveFile(packet);

					System.out.println("File sent to ServerA successfully!");

				} catch (Exception e) {
					System.out.println("Error: option 2: " + e);
				}

			} // end of option 2

			if (option == 3) {

				registry = LocateRegistry.getRegistry(port);
				stub = (FileReceiver) registry.lookup("ServerA");

				Scanner i = new Scanner(System.in);
				System.out.println("Enter the name of the file you want to download: ");
				String fileToDownload = i.nextLine();

				boolean found = false;

				File[] allFiles = stub.loadAllFileNames();

				for (File l : allFiles) {

					if (fileToDownload.equals(l.getName())) {

						System.out.println("File " + fileToDownload + " found on Server A.");
						found = true;

						// download the file.
						FilePacket fp = stub.sendFile(fileToDownload);
						byte[] b = fp.getData();

						String clientPath = "/usr/local/shared/SWE622/skhan27/PA2/" + fileToDownload;
						File newF = new File(clientPath);

						FileOutputStream fout = new FileOutputStream(newF);

						fout.write(b);
						fout.close();

						System.out.println("\nFile copied successfully.");

					} // end of if

				} // end of for

				if (!found) {

					System.out.println("\nThe requested file " + fileToDownload + " is not available on ServerA");

					FileReceiver temp_stub;

					temp_stub = (FileReceiver) registry.lookup("ServerB");

					File[] allFilesOnB = temp_stub.loadAllFileNames();

					for (File l : allFilesOnB) {

						if (fileToDownload.equals(l.getName())) {

							System.out.println("ServerA says: " + fileToDownload + " is on ServerB");
							return;

						} // end of if
					} // end of for
					System.out.println("ServerA says: " + fileToDownload + " was not found on any server.");
				}

			} // end of option 3

		} // end of server 1

		if (server == 2) {

			if (option == 1) {

				registry = LocateRegistry.getRegistry(port);
				stub = (FileReceiver) registry.lookup("ServerB");

				File[] allFiles = stub.loadAllFileNames();

				System.out.println("\nFiles available on Server B");
				for (File l : allFiles)
					System.out.println("--" + l.getName());

			} // end of option 1

			if (option == 2) {

				try {

					registry = LocateRegistry.getRegistry(port);
					stub = (FileReceiver) registry.lookup("ServerB");

					System.out.println("\nEnter path of the file to upload: ");
					Scanner p = new Scanner(System.in);
					String uploadPath = p.nextLine();

					System.out.println("Sending: " + uploadPath);

					FilePacket packet = new FilePacket(uploadPath);
					packet.readIn();
					stub.receiveFile(packet);

					System.out.println("File sent to Server B successfully!");

				} catch (Exception e) {
					System.out.println("Error: option 2: " + e);
				}

			} // end of option 2

			if (option == 3) {

				registry = LocateRegistry.getRegistry(port);
				stub = (FileReceiver) registry.lookup("ServerB");

				Scanner i = new Scanner(System.in);
				System.out.println("Enter the name of the file you want to download: ");
				String fileToDownload = i.nextLine();

				boolean found = false;

				File[] allFiles = stub.loadAllFileNames();

				for (File l : allFiles) {

					if (fileToDownload.equals(l.getName())) {

						System.out.println("File " + fileToDownload + " found on Server B.");
						found = true;

						// download the file.
						FilePacket fp = stub.sendFile(fileToDownload);
						byte[] b = fp.getData();

						String clientPath = "/usr/local/shared/SWE622/skhan27/PA2/" + fileToDownload;
						File newF = new File(clientPath);

						FileOutputStream fout = new FileOutputStream(newF);

						fout.write(b);
						fout.close();

						System.out.println("\nFile copied successfully.");

					} // end of if

				} // end of for

				if (!found) {

					System.out.println("\nThe requested file " + fileToDownload + " is not available on ServerB");

					FileReceiver temp_stub;

					temp_stub = (FileReceiver) registry.lookup("ServerA");

					File[] allFilesOnB = temp_stub.loadAllFileNames();

					for (File l : allFilesOnB) {

						if (fileToDownload.equals(l.getName())) {

							System.out.println("ServerA says: " + fileToDownload + " is on ServerA");
							return;

						} // end of if
					} // end of for
					System.out.println("ServerB says: " + fileToDownload + " was not found on any server.");
				}

			} // end of option 3

		} // end of server 2

	} // end of main

} // end of Client class