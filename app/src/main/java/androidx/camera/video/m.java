package androidx.camera.video;

import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.camera.video.Recorder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements MediaScannerConnection.OnScanCompletedListener {
    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String str, Uri uri) {
        Recorder.RecordingRecord.lambda$initializeRecording$3(str, uri);
    }
}
