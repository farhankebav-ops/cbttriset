package com.unity3d.mediation;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayAdError {
    public static final a Companion = new a(null);
    public static final int ERROR_CODE_INVALID_AD_UNIT_ID = 626;
    public static final int ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK = 625;
    public static final int ERROR_CODE_LOAD_FAILED_ALREADY_CALLED = 627;
    public static final int ERROR_CODE_LOAD_WHILE_SHOW = 629;
    public static final int ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED = 624;
    public static final int ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK = 628;
    public static final int ERROR_CODE_SHOW_WHILE_LOAD = 631;
    public static final int ERROR_CODE_SHOW_WHILE_SHOW = 630;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSourceError f10908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10910c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }

    public LevelPlayAdError(IronSourceError ironSourceError, String adId, String str) {
        k.e(adId, "adId");
        this.f10908a = ironSourceError;
        this.f10909b = adId;
        this.f10910c = str;
    }

    public final String getAdId() {
        return this.f10909b;
    }

    public final String getAdUnitId() {
        return this.f10910c;
    }

    public final int getErrorCode() {
        IronSourceError ironSourceError = this.f10908a;
        if (ironSourceError != null) {
            return ironSourceError.getErrorCode();
        }
        return 0;
    }

    public final String getErrorMessage() {
        IronSourceError ironSourceError = this.f10908a;
        String errorMessage = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
        return errorMessage == null ? "" : errorMessage;
    }

    public String toString() {
        String str = this.f10910c;
        IronSourceError ironSourceError = this.f10908a;
        return a1.a.n("adUnitId: ", str, " ", ironSourceError != null ? ironSourceError.toString() : null);
    }

    public /* synthetic */ LevelPlayAdError(IronSourceError ironSourceError, String str, String str2, int i2, f fVar) {
        this(ironSourceError, str, (i2 & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayAdError(String adId, String adUnitId, int i2, String errorMessage) {
        this(new IronSourceError(i2, errorMessage), adId, adUnitId);
        k.e(adId, "adId");
        k.e(adUnitId, "adUnitId");
        k.e(errorMessage, "errorMessage");
    }
}
