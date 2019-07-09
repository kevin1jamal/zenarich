package zengest.jam.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zengest.jam.domaine.entities.Notification;



public interface NotificationRepository extends JpaRepository<Notification,Long> {
	
	List<Notification> findByDate(Date d);
	

}
