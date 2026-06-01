package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class Api26Impl {
    private Api26Impl() {
    }

    public static MediaMuxer createMediaMuxer(FileDescriptor fileDescriptor, int i2) throws IOException {
        return new MediaMuxer(fileDescriptor, i2);
    }
}
