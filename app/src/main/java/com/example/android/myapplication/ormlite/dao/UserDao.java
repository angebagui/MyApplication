package com.example.android.myapplication.ormlite.dao;

import android.content.Context;

import com.example.android.myapplication.ormlite.entity.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;

import java.sql.SQLException;
import java.util.List;



/**
 * Created by angebagui on 02/06/15.
 */
public class UserDao implements BaseDao<User> {
    private Context mContext;
    private Dao<User, Long> mUserLongDao;
    private DatabaseHelper mDatabaseHelper;

    public UserDao(Context mContext) {
        this.mContext = mContext;
        try {
            this.mDatabaseHelper = DatabaseHelper.getHelper(mContext);
            this.mUserLongDao = mDatabaseHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Does not exist, returns false
     *
     * @param username
     * @return
     */
    public boolean findByUsername(String username) {
        boolean flag = false;
        try {
            List<User> users = mUserLongDao.queryForEq("username", username);
            if (users.size() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean save(final User entity) {
        boolean flag = false;
        try {
            int result = mUserLongDao.create(entity);
            if (result > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(final User entity) {
        boolean flag = false;
        try {
            int result = mUserLongDao.update(entity);
            if (result > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(final User entity) {
        boolean flag = false;
        try {
            int result = mUserLongDao.delete(entity);
            if (result > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            users = mUserLongDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findOneById(final long id) {
        User user = null;
        try {
            user = mUserLongDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public long countAll() {
        long count = 0;
        try {
            count = mUserLongDao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Stitching inquiry, paging query
     *
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public List<User> findAllByLimit(final long offset, final long limit) {
        List<User> query = null;
        try {
            query = mUserLongDao.queryBuilder().
                    orderBy("create_date", false).
                    offset(offset).
                    limit(limit).
                    query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * This can be considered Primal sql query
     * @return
     */
    public List<User> findUNP() {
        GenericRawResults<User> rawResults = null;
        List<User> results = null;
        try {
            String sql = "SELECT username, password FROM tb_user";
            RawRowMapper<User> mapper = new RawRowMapper<User>() {
                @Override
                public User mapRow(String[] columnNames, String[] resultColumns) throws SQLException {
                    User user = new User();
                    //user.setUsername(resultColumns[0]);
                    //user.setPassword(resultColumns[1]);
                    return user;
                }
            };
            rawResults = mUserLongDao.queryRaw(sql, mapper);
            results = rawResults.getResults();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rawResults != null) {
                try {
                    rawResults.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return results;
        }
    }
}