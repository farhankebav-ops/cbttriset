package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraFilter {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    List<CameraInfo> filter(List<CameraInfo> list);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Identifier getIdentifier();
}
