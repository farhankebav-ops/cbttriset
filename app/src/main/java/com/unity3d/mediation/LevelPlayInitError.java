package com.unity3d.mediation;

import com.ironsource.C2473ne;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayInitError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10924b;

    public LevelPlayInitError(int i2, String errorMessage) {
        k.e(errorMessage, "errorMessage");
        this.f10923a = i2;
        this.f10924b = errorMessage;
    }

    public final int getErrorCode() {
        return this.f10923a;
    }

    public final String getErrorMessage() {
        return this.f10924b;
    }

    public String toString() {
        return "LevelPlayError(errorCode=" + this.f10923a + ", errorMessage='" + this.f10924b + "')";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayInitError(C2473ne sdkError) {
        this(sdkError.c(), sdkError.d());
        k.e(sdkError, "sdkError");
    }
}
