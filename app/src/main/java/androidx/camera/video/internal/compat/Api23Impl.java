package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class Api23Impl {
    private Api23Impl() {
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public static AudioRecord build(AudioRecord.Builder builder) throws UnsupportedOperationException {
        return builder.build();
    }

    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    public static void setAudioFormat(AudioRecord.Builder builder, AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    public static void setAudioSource(AudioRecord.Builder builder, int i2) {
        builder.setAudioSource(i2);
    }

    public static void setBufferSizeInBytes(AudioRecord.Builder builder, int i2) {
        builder.setBufferSizeInBytes(i2);
    }
}
