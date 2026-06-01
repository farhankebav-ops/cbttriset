package androidx.camera.core.impl.compat;

import a1.a;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class EncoderProfilesProxyCompat {
    private static final String TAG = "EncoderProfilesProxyCompat";

    private EncoderProfilesProxyCompat() {
    }

    @RequiresApi(31)
    public static EncoderProfilesProxy from(EncoderProfiles encoderProfiles) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            return EncoderProfilesProxyCompatApi33Impl.from(encoderProfiles);
        }
        if (i2 >= 31) {
            return EncoderProfilesProxyCompatApi31Impl.from(encoderProfiles);
        }
        throw new RuntimeException(a.h(i2, "Unable to call from(EncoderProfiles) on API ", ". Version 31 or higher required."));
    }

    public static EncoderProfilesProxy from(CamcorderProfile camcorderProfile) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            Logger.w(TAG, "Should use from(EncoderProfiles) on API " + i2 + "instead. CamcorderProfile is deprecated on API 31.");
        }
        return EncoderProfilesProxyCompatBaseImpl.from(camcorderProfile);
    }
}
