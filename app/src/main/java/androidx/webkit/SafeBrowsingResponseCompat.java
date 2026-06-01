package androidx.webkit;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SafeBrowsingResponseCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SafeBrowsingResponseCompat() {
    }

    public abstract void backToSafety(boolean z2);

    public abstract void proceed(boolean z2);

    public abstract void showInterstitial(boolean z2);
}
