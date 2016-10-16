package com.testography.androidmiddlegot.data.storage.models;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.testography.androidmiddlegot.data.storage.models.House;
import com.testography.androidmiddlegot.data.storage.models.SwornMember;

import com.testography.androidmiddlegot.data.storage.models.HouseDao;
import com.testography.androidmiddlegot.data.storage.models.SwornMemberDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig houseDaoConfig;
    private final DaoConfig swornMemberDaoConfig;

    private final HouseDao houseDao;
    private final SwornMemberDao swornMemberDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        houseDaoConfig = daoConfigMap.get(HouseDao.class).clone();
        houseDaoConfig.initIdentityScope(type);

        swornMemberDaoConfig = daoConfigMap.get(SwornMemberDao.class).clone();
        swornMemberDaoConfig.initIdentityScope(type);

        houseDao = new HouseDao(houseDaoConfig, this);
        swornMemberDao = new SwornMemberDao(swornMemberDaoConfig, this);

        registerDao(House.class, houseDao);
        registerDao(SwornMember.class, swornMemberDao);
    }
    
    public void clear() {
        houseDaoConfig.clearIdentityScope();
        swornMemberDaoConfig.clearIdentityScope();
    }

    public HouseDao getHouseDao() {
        return houseDao;
    }

    public SwornMemberDao getSwornMemberDao() {
        return swornMemberDao;
    }

}
