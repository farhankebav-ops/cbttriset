package com.unity3d.ads.beta;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediationInfo {
    private final String adapterVersion;
    private final String name;
    private final String version;

    public MediationInfo(String name, String version, String adapterVersion) {
        k.e(name, "name");
        k.e(version, "version");
        k.e(adapterVersion, "adapterVersion");
        this.name = name;
        this.version = version;
        this.adapterVersion = adapterVersion;
    }

    public final String getAdapterVersion() {
        return this.adapterVersion;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }
}
