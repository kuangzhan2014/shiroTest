package com.maitianer.shirodemo.realm;

import com.maitianer.shirodemo.domain.User;
import com.maitianer.shirodemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zhou
 * @Date: 2019/06/26 14:54
 */
public class UserRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获取当前登陆的用户
//        Subject subject = SecurityUtils.getSubject();
//        //获取用户名
//        String userName = subject.getPrincipal()+"";
//        //通过用户名查当前用户
//        List<Map> maps = userService.selectUserList(userName);
//        //获取当前的权限字符
//        String roleId = maps.get(0).get("ROLE_ID")+"";
//        //设置只有是这个字符才可以访问
//        info.addStringPermission(roleId);
//        return info;
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名密码是否正确
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user =userService.findByUsername(token.getUsername());
//        String username = token.getUsername();
//        //1.判断用户名
//        List<Map> mapList = userService.selectUserList(token.getUsername());
//        if (mapList.size() == 0) {
//            return null;
//        } else {
//            return new SimpleAuthenticationInfo(username, mapList.get(0).get("PASSWORD"),"");
//        }
        //1.判断用户名
        if (null==user) {
            //用户名不存在
            return null;//shiro底层会自动抛出UnknownAccountException
        }else {
            return new SimpleAuthenticationInfo("", user.getPassword(), "");
        }
    }
}


