package com.legenda.lee.studyurule.override;

import com.bstek.urule.console.DefaultPrincipal;
import com.bstek.urule.console.EnvironmentProvider;
import com.bstek.urule.console.Principal;
import com.bstek.urule.console.servlet.RequestContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-17 7:45 下午
 * @description:
 */
public class OverReadPri implements EnvironmentProvider {

    @Override
    public Principal getLoginPrincipal(RequestContext context) {
        // DefaultPrincipal user=new DefaultPrincipal();
        // user.setCompanyId("bstek");
        // user.setName("admin");
        // user.setAdmin(true);
        // return user;

        return new Principal() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public String getCompanyId() {
                return null;
            }

            @Override
            public boolean isAdmin() {
                return false;
            }
        };
    }
    @Override
    public List<Principal> getPrincipals() {
        // DefaultPrincipal user1=new DefaultPrincipal();
        // user1.setCompanyId("bstek");
        // user1.setName("user1");
        // user1.setDisplayName("张三");
        // DefaultPrincipal user2=new DefaultPrincipal();
        // user2.setCompanyId("bstek");
        // user2.setName("user2");
        // user2.setDisplayName("李四");
        // List<Principal> users=new ArrayList<Principal>();
        // users.add(user1);
        // users.add(user2);
        // return users;
        return null;
    }
}