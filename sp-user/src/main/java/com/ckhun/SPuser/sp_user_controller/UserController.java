package com.ckhun.SPuser.sp_user_controller;

import com.ckhun.SPuser.service.UserService;

import org.springframework.web.bind.annotation.*;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:08
 * @Description
 */
@RestController
@RequestMapping("/select")
public class UserController {

    private UserService userService;
    //Select By Id
    @RequestMapping("/selectUser/{id}")
    public String selectUser(@PathVariable int id){
        return userService.selectUser(id).toString();
    }

    //Select All
    @RequestMapping("/selectUserAll")
    public String selectAll() {
        return userService.selectUserAll().toString();
    }

    @RequestMapping("/selectUserById/{id}")
    public String selectUserById(@PathVariable int id)
    {
        return userService.selectUserById(id).toString();
    }
    @RequestMapping("/insertUser/{username}/{password}/{email}")
    public String insertUser(@PathVariable String username, String password, String email){
        return userService.insertUser(username,password,email).toString();
    }
    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id){
        return userService.updateUser(id).toString();
    }
    @RequestMapping("/updateUserPassword/{id}")
    public String updateUserPassword(@PathVariable int id){
        return userService.updateUserPassword(id).toString();
    }
    @RequestMapping("/updateUserAge/{id}")
    public String updateUserAge(@PathVariable int id){
        return userService.updateUserAge(id).toString();
    }
    @RequestMapping("/updateUserPhone/{id}")
    public String updateUserPhone(@PathVariable int id){
        return userService.updateUserPhone(id).toString();
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id).toString();
    }
}