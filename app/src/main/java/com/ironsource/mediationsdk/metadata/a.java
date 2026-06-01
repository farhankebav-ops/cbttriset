package com.ironsource.mediationsdk.metadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9237a = "do_not_sell";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9238b = "is_child_directed";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9239c = "is_deviceid_optout";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9240d = "google_family_self_certified_sdks";
    public static final String e = "iiqf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9241f = "is_test_suite";
    public static final String g = "true";
    protected static final String h = "false";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9242i = "google_water_mark";
    public static final String j = "enable";
    static final Set<String> k;
    static final Set<String> l;
    static final Set<String> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9243n = 2048;

    static {
        HashSet hashSet = new HashSet(Arrays.asList(f9238b, f9239c, f9241f, f9240d, e));
        k = hashSet;
        l = new HashSet(Arrays.asList(f9239c, f9240d, f9241f, e));
        HashSet hashSet2 = new HashSet(hashSet);
        m = hashSet2;
        hashSet2.add(f9237a);
    }
}
