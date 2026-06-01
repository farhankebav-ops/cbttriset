package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface NativeAdViewTypeApi {
    public static final int HEIGHT_100 = 0;
    public static final int HEIGHT_120 = 1;

    @Deprecated
    public static final int HEIGHT_300 = 2;

    @Deprecated
    public static final int HEIGHT_400 = 3;
    public static final int HEIGHT_50 = 4;
    public static final int RECT_DYNAMIC = 5;

    int getHeight();

    int getValue();

    int getWidth();
}
