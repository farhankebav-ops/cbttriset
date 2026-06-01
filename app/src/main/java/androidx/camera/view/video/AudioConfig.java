package androidx.camera.view.video;

import androidx.annotation.RequiresPermission;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AudioConfig {
    public static final AudioConfig AUDIO_DISABLED = new AudioConfig(false);
    private final boolean mIsAudioEnabled;

    public AudioConfig(boolean z2) {
        this.mIsAudioEnabled = z2;
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public static AudioConfig create(boolean z2) {
        return new AudioConfig(z2);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }
}
