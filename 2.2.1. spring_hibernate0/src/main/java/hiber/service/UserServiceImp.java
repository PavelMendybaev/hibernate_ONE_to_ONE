package hiber.service;

import com.sun.security.auth.login.ConfigFile;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManagerFactory;
import javax.security.auth.login.AppConfigurationEntry;
import java.util.List;

@Service
public class UserServiceImp implements UserService {




   @Autowired
   private UserDao userDao;

   @Autowired
   private SessionFactory sessionFactory;



   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }



   @Override
   @Transactional
   public User getCar(int series, String model) {
      Session session = sessionFactory.openSession();



     Query query = session.createQuery("FROM User ");


     List<User> resultList = query.list();

     User returnUser = null;

     for(User user :resultList){
        Car car = user.getCar();
        if(car.getSeries() == series & car.getModel().equals(model)){
            returnUser = user;
        }
     }
      return returnUser;
   }

}
