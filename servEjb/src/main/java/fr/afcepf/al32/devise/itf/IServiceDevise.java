package fr.afcepf.al32.devise.itf;

//import java.rmi.RemoteException;

import javax.ejb.Remote;

import fr.afcepf.al32.devise.dto.Devise;

@Remote //(ejb) accessible à distance via rmi
public interface IServiceDevise { //extends java.rmi.Remote {
	public Double convertir(double montant, String monnaieSource, String monnaieCible);
	public Devise getDevise(String monnaie); // monnaie ="EUR" ou "USD", etc
}
	