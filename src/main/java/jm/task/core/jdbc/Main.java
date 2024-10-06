package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try (Connection connection = Util.getConnection()) {
            UserServiceImpl service = new UserServiceImpl();
            service.createUsersTable();
            service.saveUser("Вася", "Пупкин",  Byte.valueOf("7"));
            service.saveUser("Мотя", "Тетя",  Byte.valueOf("64"));
            service.saveUser("Петр", "Петров",  Byte.valueOf("57"));
            service.saveUser("Иван", "Иванов",  Byte.valueOf("81"));
            service.getAllUsers().stream().forEach(System.out::println);
            service.cleanUsersTable();
            service.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
