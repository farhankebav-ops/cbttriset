package androidx.camera.video.internal.compat;

import android.media.AudioManager$AudioRecordingCallback;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class Api29Impl {
    private Api29Impl() {
    }

    public static AudioRecordingConfiguration getActiveRecordingConfiguration(AudioRecord audioRecord) {
        return audioRecord.getActiveRecordingConfiguration();
    }

    public static boolean isClientSilenced(AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.isClientSilenced();
    }

    public static void registerAudioRecordingCallback(AudioRecord audioRecord, Executor executor, AudioManager$AudioRecordingCallback audioManager$AudioRecordingCallback) {
        audioRecord.registerAudioRecordingCallback(executor, audioManager$AudioRecordingCallback);
    }

    public static void unregisterAudioRecordingCallback(AudioRecord audioRecord, AudioManager$AudioRecordingCallback audioManager$AudioRecordingCallback) {
        audioRecord.unregisterAudioRecordingCallback(audioManager$AudioRecordingCallback);
    }
}
