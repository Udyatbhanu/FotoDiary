package com.home.ubbs.foto.diary.utils;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by udyatbhanu-mac on 4/28/16.
 */
public class CameraUtils {
    private static final int MEDIA_TYPE_IMAGE = 1;
    private static final int MEDIA_TYPE_VIDEO = 2;

    public static Uri getPhotoMediaUri(String folderName) {
        return getOutputMediaFileUri(folderName, MEDIA_TYPE_IMAGE);
    }

    /**
     * Create a file Uri for saving an image or video
     */
    private static Uri getOutputMediaFileUri(String folderName, int type) {
        return Uri.fromFile(getOutputMediaDirectory(folderName, type));
    }

    /**
     * @param folderName
     * @param type
     * @return
     */
    private static File getOutputMediaDirectory(String folderName, int type) {

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), folderName);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }

        }
        return mediaStorageDir;
    }
}
