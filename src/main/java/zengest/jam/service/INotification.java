package zengest.jam.service;

import java.util.List;

import zengest.jam.domaine.entities.Notification;

public interface INotification {
	
	public Notification creer_notif(Notification not);
	public  List<Notification> affichertous();

}
