package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface EncoderConfig {
    public static final int CODEC_PROFILE_NONE = -1;
    public static final String KEY_CSD_0 = "csd-0";
    public static final String KEY_CSD_1 = "csd-1";
    public static final String KEY_CSD_2 = "csd-2";

    Timebase getInputTimebase();

    String getMimeType();

    int getProfile();

    MediaFormat toMediaFormat() throws InvalidConfigException;
}
