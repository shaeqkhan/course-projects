/*
 * SWE 622 - Programming Assignment 2
 * @author shaeqkhan
 */

package assignment2.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import assignment2.intf.FileReceiver;
import assignment2.model.FilePacket;

public class ServerA implements FileReceiver {

	private String directory;

	public ServerA() throws RemoteException {
		super();
	}

	public void setDirectory(String directory) throws RemoteException {
		this.directory = directory;
	}

	public void receiveFile(FilePacket packet) throws RemoteException {

		try {
			File f = new File("/usr/local/shared/SWE622/skhan27/PA2/ServerA/" + packet.getOnlyFileName());
			packet.writeTo(new FileOutputStream(f));
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of receiveFile

	public FilePacket sendFile(String fname) throws RemoteException {

		String serverPath = "/usr/local/shared/SWE622/skhan27/PA2/ServerA/" + fname;
		FilePacket sp = new FilePacket(serverPath);
		sp.readIn();
		return sp;

	} // end of sendFile

	public File[] loadAllFileNames() throws RemoteException {

		File f = new File("/usr/local/shared/SWE622/skhan27/PA2/ServerA/");
		File[] listOfFiles = f.listFiles();

		return listOfFiles;

	} // end of loadAllFileNames

	public static void main(String args[]) {

		try {
			Scanner k = new Scanner(System.in);
			System.out.println("\nEnter a port number for the registry: ");
			System.out.println("(Try different ports if 1099 is busy. e.g. 3333)");
			int port = k.nextInt();

			ServerA sa = new ServerA();
			sa.setDirectory("/usr/local/shared/SWE622/skhan27/PA2/");

			FileReceiver stub = (FileReceiver) UnicastRemoteObject.exportObject(sa, 0);
			System.out.println("\nBinding object...");

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("ServerA", stub);

			System.out.println("\nObject is bound to the registry.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main

} // end of Server A
