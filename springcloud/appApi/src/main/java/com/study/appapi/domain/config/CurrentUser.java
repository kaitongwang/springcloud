package com.study.appapi.domain.config;

import com.study.appapi.domain.dto.User;
import org.springframework.stereotype.Component;
@Component
public class CurrentUser {

    private static ThreadLocal<User> filterThreadLocal = new ThreadLocal<User>();

    public static User getCurrentAuthToken() {
        User authToken = filterThreadLocal.get();
        return authToken;
    }

    public static void setFilterThreadLocal(User user) {
       filterThreadLocal.set(user);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前线程的对象启用gc回收机制"
                +":--------------------------" +
                "-----------------------------------------" +
                "---------------------------------------");
        super.finalize();
    }
}