package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Util.getConnection()) {
            UserServiceImpl service = new UserServiceImpl();
            service.createUsersTable();
            service.saveUser("Вася", "Пупкин",  Byte.valueOf("7"));
            service.saveUser("тетя", "Мотя",  Byte.valueOf("64"));
            service.saveUser("дядя", "Вася",  Byte.valueOf("57"));
            service.saveUser("бабка", "На скамейке",  Byte.valueOf("81"));
            service.getAllUsers().stream().forEach(System.out::println);
            service.cleanUsersTable();
            service.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
