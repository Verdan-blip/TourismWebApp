package ru.kpfu.itis.bagaviev.utils;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    private CloudinaryUtil() { }

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(Map.of(
                    "cloud_name", "doaetvccv",
                    "api_key", "955375793197148",
                    "api_secret", "W2BQCAEMC_10bNiapPXqVSFbf7w"));
        }
        return cloudinary;
    }


}
