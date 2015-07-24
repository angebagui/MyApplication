package com.example.android.myapplication.ormlite.service;

import android.content.Context;
import android.util.Log;

import com.example.android.myapplication.ormlite.dao.DatabaseHelper;
import com.example.android.myapplication.ormlite.dao.UserDao;
import com.example.android.myapplication.ormlite.entity.User;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.support.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;



/**
 * Created by angebagui on 02/06/15.
 */
public class UserService {
    private static final String LOG_TAG = UserService.class.getSimpleName();

    public DatabaseConnection connection;
    private UserDao mUserDao;
    private Context mContext;

    public UserService(Context mContext) {
        this.mContext = mContext;
        mUserDao = new UserDao(mContext);
        connection = new AndroidDatabaseConnection(
                DatabaseHelper.getHelper(mContext).getWritableDatabase(), true);
    }

    /**
     *
     * @param user
     * @return
     */
    public int saveUser(User user) {
        int flag = -1;
        Savepoint savepoint = null;
        try {
            boolean byUsername = mUserDao.findByUsername(user.getUsername());
            if (byUsername) {
                flag = 0;
            } else {
                savepoint = connection.setSavePoint("save");
                if (mUserDao.save(user)) {
                    flag = 1;
                    connection.commit(savepoint);
                    Log.d(LOG_TAG, "Saved");
                }
            }
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return flag;
    }

    public boolean updateUser(User user) {
        return mUserDao.update(user);
    }

    public boolean deleteUser(User user) {
        return mUserDao.delete(user);
    }

    public User getUserById(long id) {
        return mUserDao.findOneById(id);
    }

    public List<User> getAll() {
        List<User> users = mUserDao.findAll();
        return users;
    }

    public long countAll() {
        return mUserDao.countAll();
    }

    public List<User> getAllByLimit(long currentPage, long size) {
        return mUserDao.findAllByLimit(currentPage - 1, size);
    }

    public List<User> getAllUserOnlyUsernamePassword() {
        return mUserDao.findUNP();
    }
}
