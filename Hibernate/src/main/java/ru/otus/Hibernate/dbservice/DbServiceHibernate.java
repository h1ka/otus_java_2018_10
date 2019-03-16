package ru.otus.Hibernate.dbservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.otus.Hibernate.model.Address;
import ru.otus.Hibernate.model.Phone;
import ru.otus.Hibernate.model.User;



public class DbServiceHibernate<T> implements DbService<T> {
    private final SessionFactory sessionFactory;

    public DbServiceHibernate() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Phone.class)
                .addAnnotatedClass(Address.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    @Override
    public void save(T objectData) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(objectData);
            session.getTransaction().commit();
        }
    }

    @Override
    public <T> T load(long id, Class<T> clazz) {
        try (Session session = sessionFactory.openSession()) {
            T selected = session.get(clazz, id);
            System.out.println(">>>>>>>>>>> selected:" + selected);
            return selected;
        }
    }
}
