package androidx.camera.core.imagecapture;

import androidx.annotation.RestrictTo;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface CameraCapturePipeline {
    q invokePostCapture();

    q invokePreCapture();
}
