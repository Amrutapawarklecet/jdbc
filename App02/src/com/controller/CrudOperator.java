package com.controller;

import java.util.List;

import com.beans.UserBean;
import com.service.UserService;
import com.service.UserServiceimpl;
public class CrudOperator {
public static void main(String args[]) {
UserService userService=new UserServiceimpl();

/*add user*/
/*UserBean ubean=new UserBean(1658,"Kaju",4,"banglore");
userService.addUser(ubean);*/


/*update user*/

/*UserBean ubean= new UserBean(1657, "Anu", 3, "marlabs");
userService.updateUser(1234,ubean);*/

/*delete user
userService.deleteUser(1657);*/
  
/*retrieve*/
UserBean userbean=userService.getUserByaadharno(1658);
System.out.println(userbean.getAadharno() + " " +userbean.getUsername()+" "+userbean.getUsertype()+" "+userbean.getPassword());


/*CONSOLE*/
/*List<UserBean> lst=userService.getAllUser();
// 1st way-prints the elements of the List
for (UserBean user : lst) {
    System.out.println(user.getAadharno() + " " + user.getUsername() + " " + user.getUsertype() + " "
            + user.getPassword()); 
}*/
}
}


