package com.google.gson.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class GsonPreconditions {
    private GsonPreconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }
}
