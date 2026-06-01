package com.ironsource;

import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.xc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2641xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2387j2 f10516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10517b;

    /* JADX INFO: renamed from: com.ironsource.xc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10518a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f10519b = "adm";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f10520c = "isOneFlow";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f10521d = "isMultipleAdObjects";
        public static final String e = "adsInternalInfo";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f10522f = "success";
        public static final String g = "error";
        public static final String h = "data";

        private a() {
        }
    }

    public C2641xc() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public final HashMap<String, String> a() {
        C2479o2 c2479o2G;
        HashMap<String, String> map = new HashMap<>();
        map.put("isOneFlow", String.valueOf(this.f10517b));
        map.put("isMultipleAdObjects", com.ironsource.mediationsdk.metadata.a.g);
        List<N> listA = Mb.f7131s.d().G().a();
        String string = listA != null ? new JSONObject().put("success", true).put("data", listA).toString() : new JSONObject().put("success", false).put("error", "Failed to get ad internal info").toString();
        kotlin.jvm.internal.k.d(string, "if (jsonAdInternalInfo !…    .toString()\n        }");
        map.put(a.e, string);
        C2387j2 c2387j2 = this.f10516a;
        if (c2387j2 != null && (c2479o2G = c2387j2.g()) != null) {
            map.put("adm", c2479o2G.a());
            map.putAll(c2479o2G.b());
        }
        return map;
    }

    public C2641xc(C2387j2 c2387j2, boolean z2) {
        this.f10516a = c2387j2;
        this.f10517b = z2;
    }

    public /* synthetic */ C2641xc(C2387j2 c2387j2, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? null : c2387j2, (i2 & 2) != 0 ? false : z2);
    }
}
