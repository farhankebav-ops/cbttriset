package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.fe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2328fe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f8533a = new a(2001, a("initsdk"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f8534b = new a(2026, a("sdkrecoverstart"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f8535c = new a(2002, a("createcontrollerweb"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f8536d = new a(2003, a("createcontrollernative"));
    public static a e = new a(2004, a("controllerstageready"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f8537f = new a(2005, a("loadad"));
    public static a g = new a(2006, a("loadadfailed"));
    public static a h = new a(2007, a("initproduct"));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f8538i = new a(2008, a("initproductfailed"));
    public static a j = new a(2009, a("loadproduct"));
    public static a k = new a(2010, a("parseadmfailed"));
    public static a l = new a(2011, a("loadadsuccess"));
    public static a m = new a(2027, a("destroyproduct"));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static a f8539n = new a(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, a("registerad"));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static a f8540o = new a(2013, a("controllerfailed"));
    public static a p = new a(2015, a("appendnativefeaturesdatafailed"));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static a f8541q = new a(2016, a("adunitcouldnotloadtowebview"));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static a f8542r = new a(2017, a("webviewcleanupfailed"));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static a f8543s = new a(2018, a("removewebviewfailed"));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static a f8544t = new a(IronSourceError.ERROR_NEW_INIT_API_ALREADY_CALLED, a("banneralreadydestroyed"));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static a f8545u = new a(2021, a("fialedregactlifecycle"));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static a f8546v = new a(2022, a("loadcontrollerhtml"));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static a f8547w = new a(2023, a("controllerhtmlsuccess"));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static a f8548x = new a(2024, a("controllerhtmlfailed"));
    public static a y = new a(2025, a("webviewcrashrpg"));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static a f8549z = new a(2031, a("getorientationcalled"));
    public static a A = new a(2032, a("webviewunavailable"));
    public static final a B = new a(2033, a("controller_init_delayed"));

    /* JADX INFO: renamed from: com.ironsource.fe$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8551b;

        public a(int i2, String str) {
            this.f8551b = i2;
            this.f8550a = str;
        }
    }

    public static String a(String str) {
        return a1.a.l(G5.f6804c, str);
    }
}
