package com.educom.server.awsimage.bucket;

public enum BucketName {
    PROFILE_IMGE("concon-image-upload-123");
    private final String bucket;

    BucketName(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }
}
