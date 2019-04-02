package ru.otus.DI;

import org.hibernate.SessionFactory;
import ru.otus.DI.dbservice.DataSourceH2;
import ru.otus.DI.dbservice.DbService;
import ru.otus.DI.model.Address;
import ru.otus.DI.dbservice.DbServiceHibernate;
import ru.otus.DI.model.Phone;
import ru.otus.DI.model.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

public class DBInitialize
{
    private static final String URL = "jdbc:h2:mem:testDB;DB_CLOSE_DELAY=-1";

    public  void start() throws SQLException {

        DataSource dataSource = new DataSourceH2(); //!!!!
        long id = 1;
        User user = new User(1l,"NNika",23);
        Address userAddress = new Address("Kaluga", user);
        Phone userPhone = new Phone("89533188826",user);
        user.setAddress(userAddress);
        user.setPhone(Collections.singletonList(userPhone));

        User notUser = new User(1l,"Nika",25);
        Address notUserAddress = new Address("Saint Petersburg",notUser);
        Phone notUserPhone = new Phone("89533188826",notUser);
        notUser.setAddress(notUserAddress);
        notUser.setPhone(Collections.singletonList(notUserPhone));

        User user2 = new User(2l,"User",25);
        Address user2Address = new Address("Moscow",user2);
        Phone user2Phone = new Phone("89999999999",user2);
        Phone user2Phone2 = new Phone("81111111111",user2);
        Phone user2Phone3 = new Phone("81234567890",user2);
        user2.setAddress(user2Address);
        user2.setPhone(Arrays.asList(user2Phone,user2Phone2,user2Phone3));


        DbService<User> dbService = new DbServiceHibernate<>();
        dbService.save(user);
        dbService.save(notUser);
        dbService.save(user2);

    }

}
