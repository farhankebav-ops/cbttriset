package com.unity3d.ironsourceads;

import com.google.mlkit.common.MlKitException;
import com.ironsource.mediationsdk.l;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdSize {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10858c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AdSize banner() {
            return new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, l.f9204a, null);
        }

        public final AdSize large() {
            return new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90, l.f9205b, null);
        }

        public final AdSize leaderboard() {
            return new AdSize(728, 90, l.f9207d, null);
        }

        public final AdSize mediumRectangle() {
            return new AdSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250, l.g, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AdSize(int i2, int i8, String str, f fVar) {
        this(i2, i8, str);
    }

    public static final AdSize banner() {
        return Companion.banner();
    }

    public static final AdSize large() {
        return Companion.large();
    }

    public static final AdSize leaderboard() {
        return Companion.leaderboard();
    }

    public static final AdSize mediumRectangle() {
        return Companion.mediumRectangle();
    }

    public final int getHeight() {
        return this.f10857b;
    }

    public final String getSizeDescription() {
        return this.f10858c;
    }

    public final int getWidth() {
        return this.f10856a;
    }

    private AdSize(int i2, int i8, String str) {
        this.f10856a = i2;
        this.f10857b = i8;
        this.f10858c = str;
    }
}
