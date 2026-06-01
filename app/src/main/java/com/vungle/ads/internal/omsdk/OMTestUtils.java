package com.vungle.ads.internal.omsdk;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.Omid;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OMTestUtils {
    public static final OMTestUtils INSTANCE = new OMTestUtils();

    private OMTestUtils() {
    }

    @VisibleForTesting
    public final boolean isOmidActive() {
        return Omid.isActive();
    }
}
