package androidx.camera.video.internal.compat;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class Api24Impl {
    private Api24Impl() {
    }

    public static int getClientAudioSessionId(AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.getClientAudioSessionId();
    }

    public static int getTimestamp(AudioRecord audioRecord, AudioTimestamp audioTimestamp, int i2) {
        return audioRecord.getTimestamp(audioTimestamp, i2);
    }
}
