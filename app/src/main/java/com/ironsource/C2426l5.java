package com.ironsource;

import java.util.Date;

/* JADX INFO: renamed from: com.ironsource.l5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2426l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8912a = new Date().getTime();

    public static long a(C2426l5 c2426l5) {
        if (c2426l5 == null) {
            return 0L;
        }
        return new Date().getTime() - c2426l5.f8912a;
    }
}
