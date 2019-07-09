package zengest.jam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zengest.jam.domaine.entities.Notification;
import zengest.jam.repository.NotificationRepository;

@Service
public class NotificationImpl implements INotification{
      @Autowired
      NotificationRepository notifrep;
	
	@Override
	public Notification creer_notif(Notification not) {
		// creer une notification
		return notifrep.save(not);
	}

	@Override
	public List<Notification> affichertous() {
		// afficher toutes les notifications
		return notifrep.findAll();
	}

}
