package com.vungle.ads.internal.model;

import androidx.camera.core.processing.util.a;
import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class AppNode {
    public static final Companion Companion = new Companion(null);
    private final String appId;
    private final String bundle;
    private final String ver;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return AppNode$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AppNode(int i2, String str, String str2, String str3, m1 m1Var) {
        if (7 != (i2 & 7)) {
            c1.j(AppNode$$serializer.INSTANCE.getDescriptor(), i2, 7);
            throw null;
        }
        this.bundle = str;
        this.ver = str2;
        this.appId = str3;
    }

    public static /* synthetic */ AppNode copy$default(AppNode appNode, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appNode.bundle;
        }
        if ((i2 & 2) != 0) {
            str2 = appNode.ver;
        }
        if ((i2 & 4) != 0) {
            str3 = appNode.appId;
        }
        return appNode.copy(str, str2, str3);
    }

    public static final void write$Self(AppNode self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.bundle);
        output.encodeStringElement(serialDesc, 1, self.ver);
        output.encodeStringElement(serialDesc, 2, self.appId);
    }

    public final String component1() {
        return this.bundle;
    }

    public final String component2() {
        return this.ver;
    }

    public final String component3() {
        return this.appId;
    }

    public final AppNode copy(String bundle, String ver, String appId) {
        k.e(bundle, "bundle");
        k.e(ver, "ver");
        k.e(appId, "appId");
        return new AppNode(bundle, ver, appId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppNode)) {
            return false;
        }
        AppNode appNode = (AppNode) obj;
        return k.a(this.bundle, appNode.bundle) && k.a(this.ver, appNode.ver) && k.a(this.appId, appNode.appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getVer() {
        return this.ver;
    }

    public int hashCode() {
        return this.appId.hashCode() + a.b(this.bundle.hashCode() * 31, 31, this.ver);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppNode(bundle=");
        sb.append(this.bundle);
        sb.append(", ver=");
        sb.append(this.ver);
        sb.append(", appId=");
        return a1.a.e(')', this.appId, sb);
    }

    public AppNode(String bundle, String ver, String appId) {
        k.e(bundle, "bundle");
        k.e(ver, "ver");
        k.e(appId, "appId");
        this.bundle = bundle;
        this.ver = ver;
        this.appId = appId;
    }

    public static /* synthetic */ void getAppId$annotations() {
    }
}
