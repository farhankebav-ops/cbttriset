package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresExtension;
import com.ironsource.C2300e4;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.services.core.device.MimeTypes;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;
    public static final int MIN_EXTENSION_VERSION_FOR_OPEN_FILE_APIS = 17;

    private MediaStoreUtil() {
    }

    public static boolean isAndroidPickerUri(Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }

    @ChecksSdkIntAtLeast(api = 17, extension = 30)
    public static boolean isMediaStoreOpenFileApisAvailable() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && C2300e4.h.I0.equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i2, int i8) {
        return i2 != Integer.MIN_VALUE && i8 != Integer.MIN_VALUE && i2 <= 512 && i8 <= MINI_THUMB_HEIGHT;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains(MimeTypes.BASE_TYPE_VIDEO);
    }

    @RequiresExtension(extension = 30, version = 17)
    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, null);
    }
}
