package com.ironsource;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f7028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7029c;

    public Je(String str, List<String> list, boolean z2) {
        this.f7027a = str;
        this.f7028b = list;
        this.f7029c = z2;
    }

    public final boolean a() {
        if (this.f7029c) {
            List<String> list = this.f7028b;
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    String str2 = this.f7027a;
                    if (str2 != null && n6.t.n0(str2, str, false)) {
                        return true;
                    }
                }
            }
            return false;
        }
        List<String> list2 = this.f7028b;
        if (list2 != null && !list2.isEmpty()) {
            for (String str3 : list2) {
                String str4 = this.f7027a;
                if (str4 != null && n6.m.q0(str4, str3, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String b() {
        return this.f7027a;
    }

    public /* synthetic */ Je(String str, List list, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this(str, list, (i2 & 4) != 0 ? false : z2);
    }
}
