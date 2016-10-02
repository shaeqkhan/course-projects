/*
 * SWE 622 - Programming Assignment 2
 * @author shaeqkhan
 */

package assignment2.intf;

import java.rmi.*;

import assignment2.model.FilePacket;

import java.io.*;

public interface FileReceiver extends Remote {

	public void setDirectory(String directory) throws RemoteException;

	public void receiveFile(FilePacket packet) throws RemoteException;

	public File[] loadAllFileNames() throws RemoteException;

	public FilePacket sendFile(String fname) throws RemoteException;

}