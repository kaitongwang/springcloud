package com.study.management.domain.vo;

import com.study.common.vo.base.CurrentUser;
import org.springframework.stereotype.Component;

/**
 * 描述: 当前线程中的用户
 *
 * @Author;wangkaitong
 * @Date;2019/7/23
 * @Version;1.0
 * @Senice;1.0
 */
@Component
public class CurrentUserLocal {

    private static ThreadLocal<CurrentUser> filterThreadLocal = new ThreadLocal<CurrentUser>();

    public static CurrentUser getCurrentAuthToken() {
        CurrentUser authToken = filterThreadLocal.get();
        return authToken;
    }

    public static void setFilterThreadLocal(CurrentUser userVo) {
       filterThreadLocal.set(userVo);
    }

}
