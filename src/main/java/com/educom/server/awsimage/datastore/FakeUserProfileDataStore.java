package com.educom.server.awsimage.datastore;


import com.educom.server.awsimage.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES=new ArrayList<>();
    static{
        USER_PROFILES.add(new UserProfile(UUID.fromString("3620b0b0-162a-45c1-9019-2d9f945456d7"),"Donaltduck",""));
        USER_PROFILES.add(new UserProfile(UUID.fromString("7c04c06c-3d2e-4654-b4f7-a3760c721647"),"MickeyMouse",""));
    }
    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }

}
