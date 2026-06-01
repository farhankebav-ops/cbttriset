package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.MutableConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ExtendableBuilder<T> {
    T build();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    MutableConfig getMutableConfig();
}
