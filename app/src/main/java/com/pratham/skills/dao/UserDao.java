package com.pratham.skills.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.pratham.skills.modal.User;

@Dao
public interface UserDao {

    @Insert
    long insert(User user);
}
