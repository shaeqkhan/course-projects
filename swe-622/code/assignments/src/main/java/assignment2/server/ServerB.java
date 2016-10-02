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

public class ServerB implements FileReceiver {

	private String directory;

	public ServerB() throws RemoteException {
		super();
	}

	public void setDirectory(String directory) throws RemoteException {
		this.directory = directory;
	}

	public void receiveFile(FilePacket packet) throws RemoteException {

		try {
			File f = new File("/usr/local/shared/SWE622/skhan27/PA2/ServerB/" + packet.getOnlyFileName());
			packet.writeTo(new FileOutputStream(f));
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of receiveFile

	public FilePacket sendFile(String fname) throws RemoteException {

		String serverPath = "/usr/local/shared/SWE622/skhan27/PA2/ServerB/" + fname;
		FilePacket sp = new FilePacket(serverPath);
		sp.readIn();
		return sp;

	} // end of sendFile

	public File[] loadAllFileNames() throws RemoteException {

		File f = new File("/usr/local/shared/SWE622/skhan27/PA2/ServerB/");
		File[] listOfFiles = f.listFiles();

		return listOfFiles;

	} // end of loadAllFileNames

	public static void main(String args[]) {

		try {
			Scanner k = new Scanner(System.in);
			System.out.println("\nEnter a port number for the registry: ");
			System.out.println("(Try different ports if 1099 is busy. e.g. 3333)");
			int port = k.nextInt();

			ServerB sb = new ServerB();
			sb.setDirectory("/usr/local/shared/SWE622/skhan27/PA2/");

			FileReceiver stub = (FileReceiver) UnicastRemoteObject.exportObject(sb, 0);
			System.out.println("Binding object...");

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("ServerB", stub);

			System.out.println("Object is bound to the registry.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main

} // end of ServerB