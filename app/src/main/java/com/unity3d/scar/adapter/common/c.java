package com.unity3d.scar.adapter.common;

import com.ironsource.mediationsdk.l;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static final c A;
    public static final c B;
    public static final c C;
    public static final c D;
    public static final c E;
    public static final c F;
    public static final /* synthetic */ c[] G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f10961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f10962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f10963d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f10964f;
    public static final c g;
    public static final c h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f10965i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f10966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f10967o;
    public static final c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f10968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f10969r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f10970s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f10971t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c f10972u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f10973v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f10974w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f10975x;
    public static final c y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c f10976z;

    static {
        c cVar = new c("SCAR_PRESENT", 0);
        f10960a = cVar;
        c cVar2 = new c("SCAR_NOT_PRESENT", 1);
        f10961b = cVar2;
        c cVar3 = new c("ALREADY_INITIALIZED", 2);
        f10962c = cVar3;
        c cVar4 = new c("INIT_SUCCESS", 3);
        f10963d = cVar4;
        c cVar5 = new c("INIT_ERROR", 4);
        e = cVar5;
        c cVar6 = new c("VERSION", 5);
        f10964f = cVar6;
        c cVar7 = new c("SCAR_UNSUPPORTED", 6);
        g = cVar7;
        c cVar8 = new c("SIGNALS", 7);
        h = cVar8;
        c cVar9 = new c("SIGNALS_ERROR", 8);
        f10965i = cVar9;
        c cVar10 = new c("INTERNAL_SIGNALS_ERROR", 9);
        j = cVar10;
        c cVar11 = new c("AD_LOADED", 10);
        k = cVar11;
        c cVar12 = new c("INTERSTITIAL_IMPRESSION_RECORDED", 11);
        l = cVar12;
        c cVar13 = new c("REWARDED_IMPRESSION_RECORDED", 12);
        m = cVar13;
        c cVar14 = new c("INTERNAL_LOAD_ERROR", 13);
        f10966n = cVar14;
        c cVar15 = new c("QUERY_NOT_FOUND_ERROR", 14);
        c cVar16 = new c("LOAD_ERROR", 15);
        f10967o = cVar16;
        c cVar17 = new c("NO_AD_ERROR", 16);
        p = cVar17;
        c cVar18 = new c("AD_STARTED", 17);
        f10968q = cVar18;
        c cVar19 = new c("INTERNAL_SHOW_ERROR", 18);
        f10969r = cVar19;
        c cVar20 = new c("AD_NOT_LOADED_ERROR", 19);
        f10970s = cVar20;
        c cVar21 = new c("REWARDED_SHOW_ERROR", 20);
        f10971t = cVar21;
        c cVar22 = new c("INTERSTITIAL_SHOW_ERROR", 21);
        f10972u = cVar22;
        c cVar23 = new c("FIRST_QUARTILE", 22);
        f10973v = cVar23;
        c cVar24 = new c("MIDPOINT", 23);
        f10974w = cVar24;
        c cVar25 = new c("THIRD_QUARTILE", 24);
        f10975x = cVar25;
        c cVar26 = new c("LAST_QUARTILE", 25);
        y = cVar26;
        c cVar27 = new c("AD_EARNED_REWARD", 26);
        f10976z = cVar27;
        c cVar28 = new c("AD_CLICKED", 27);
        A = cVar28;
        c cVar29 = new c("AD_SKIPPED", 28);
        B = cVar29;
        c cVar30 = new c("AD_LEFT_APPLICATION", 29);
        C = cVar30;
        c cVar31 = new c("AD_CLOSED", 30);
        D = cVar31;
        c cVar32 = new c("METHOD_ERROR", 31);
        E = cVar32;
        c cVar33 = new c(l.f9204a, 32);
        F = cVar33;
        G = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11, cVar12, cVar13, cVar14, cVar15, cVar16, cVar17, cVar18, cVar19, cVar20, cVar21, cVar22, cVar23, cVar24, cVar25, cVar26, cVar27, cVar28, cVar29, cVar30, cVar31, cVar32, cVar33};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) G.clone();
    }
}
