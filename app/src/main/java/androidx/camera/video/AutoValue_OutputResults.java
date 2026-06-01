package androidx.camera.video;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_OutputResults extends OutputResults {
    private final Uri outputUri;

    public AutoValue_OutputResults(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("Null outputUri");
        }
        this.outputUri = uri;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OutputResults) {
            return this.outputUri.equals(((OutputResults) obj).getOutputUri());
        }
        return false;
    }

    @Override // androidx.camera.video.OutputResults
    public Uri getOutputUri() {
        return this.outputUri;
    }

    public int hashCode() {
        return this.outputUri.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.outputUri + "}";
    }
}
