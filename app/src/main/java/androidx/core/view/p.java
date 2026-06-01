package androidx.core.view;

import android.media.session.MediaSessionManager;
import android.text.PrecomputedText;
import android.webkit.TracingConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class p {
    public static /* synthetic */ MediaSessionManager.RemoteUserInfo b(int i2, int i8, String str) {
        return new MediaSessionManager.RemoteUserInfo(str, i2, i8);
    }

    public static /* synthetic */ TracingConfig.Builder i() {
        return new TracingConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ boolean x(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
