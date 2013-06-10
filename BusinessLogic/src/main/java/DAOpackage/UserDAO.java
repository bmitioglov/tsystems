package DAOpackage;

/**
 * Created with IntelliJ IDEA.
 * Author: Mitioglov Boris
 */

import java.sql.SQLException;
import java.util.List;


import entities.UserEntity;

public interface UserDAO {
    public long addUser(UserEntity user) throws SQLException;
    public void updateUser(UserEntity user) throws SQLException;
    public UserEntity getUserById(Long id) throws SQLException;
    public List getAllUsers() throws SQLException;
    public void deleteUser(UserEntity user) throws SQLException;
}