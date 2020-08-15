package com.educom.server.awsimage.profile;


import com.educom.server.awsimage.bucket.BucketName;
import com.educom.server.awsimage.filestrore.FileStore;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;


@Service
public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }
  List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
  }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        isFileEmpty(file);
        isImage(file);

        UserProfile user = getUserProfile(userProfileId);

        Map<String, String> metadata = extractMetadata(file);

        String path=String.format("%s/%s", BucketName.PROFILE_IMGE.getBucket(), user.getUserProfileId());
        String filename=String.format("%s-%s",file.getOriginalFilename(),UUID.randomUUID());
        try {
            fileStore.save(path,filename,Optional.of(metadata),file.getInputStream());
            user.setUserProfileImageLink(filename);
        } catch (IOException e) {
           throw new IllegalStateException(e);
        }

    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String,String> metadata= new HashMap<>();
        metadata.put("Content-Type",file.getContentType());
        metadata.put("Content-Length",String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfile(UUID userProfileId) {
        return userProfileDataAccessService
                    .getUserProfiles()
                    .stream()
                    .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                    .findFirst()
                    .orElseThrow(()->new IllegalStateException(String.format("User Profile %s not found",userProfileId)));
    }

    private void isImage(MultipartFile file) {
        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be image [" +file.getContentType()+"]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file [" +file.getSize()+"]");
        }
    }

    public byte[] downloadUserProfileImage(UUID userProfileId) {

        UserProfile user=getUserProfile(userProfileId);
        String path=String.format("%s/%s",BucketName.PROFILE_IMGE.getBucket(),user.getUserProfileId());
       return user.getUserProfileImageLink()
                .map(key-> fileStore.download(path,key))
                .orElse(new byte[0]);


    }
}
