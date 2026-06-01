package com.unity3d.services.store.gpbl.bridges.billingclient;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FallbackException extends Exception {
    private final int detectedVersion;

    public FallbackException(int i2) {
        this.detectedVersion = i2;
    }

    public final int getDetectedVersion() {
        return this.detectedVersion;
    }
}
