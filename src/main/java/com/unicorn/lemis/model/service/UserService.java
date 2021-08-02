package com.unicorn.lemis.model.service;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.dao.UserDataAccessObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kano_dayo
 * @date 2021/6/16 0:15
 */

public class UserService {
    private UserDataAccessObject userDataAccessObject;
     public UserService(){
         this.userDataAccessObject = new UserDataAccessObject();
     }

     /**
      * @description 用户操作
      * @param user
      * @return void
      */
     public void addUser(LEMIS_User user)throws Exception{
         userDataAccessObject.insert(user);
     }
     public void updateUser(LEMIS_User user)throws Exception{
         userDataAccessObject.update(user);
     }
     public void deleteUser(String user_id)throws Exception{
         userDataAccessObject.delete(user_id);
     }
     public void radomGenerateUserid(String user_id)throws Exception{
        userDataAccessObject.randomid(user_id);
     }
    public void generateUserid(String user_id)throws Exception{
        userDataAccessObject.genreateuserid(user_id);
    }
    public void randomGenerate(LEMIS_User user)throws Exception{
         userDataAccessObject.randomcode(user);
    }
     public List<LEMIS_User>userList(LEMIS_User user)throws Exception{
         return userDataAccessObject.queryUser(user);
     }
    public List<LEMIS_User>queryTech(String user_title)throws Exception{
         return userDataAccessObject.queryTechnician(user_title);
    }

    // TODO: 2021/6/21 It looks like something is wrong here, I've rewritten it in UserDataAccessObject.java
}
