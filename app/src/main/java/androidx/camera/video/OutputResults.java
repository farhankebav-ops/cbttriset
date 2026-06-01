package androidx.camera.video;

import android.net.Uri;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OutputResults {
    public static OutputResults of(Uri uri) {
        Preconditions.checkNotNull(uri, "OutputUri cannot be null.");
        return new AutoValue_OutputResults(uri);
    }

    public abstract Uri getOutputUri();
}
