package com.ironsource;

import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.t1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2562t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10237a = b.f10249a;

    /* JADX INFO: renamed from: com.ironsource.t1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a extends InterfaceC2562t1 {

        /* JADX INFO: renamed from: com.ironsource.t1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0202a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10238b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f10239c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final C2569t8.e f10240d;
            private final String e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final String f10241f;
            private final C0203a g;
            private final int h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final int f10242i;

            /* JADX INFO: renamed from: com.ironsource.t1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class C0203a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final int f10243a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final int f10244b;

                public C0203a(int i2, int i8) {
                    this.f10243a = i2;
                    this.f10244b = i8;
                }

                public final int a() {
                    return this.f10243a;
                }

                public final int b() {
                    return this.f10244b;
                }

                public final int c() {
                    return this.f10243a;
                }

                public final int d() {
                    return this.f10244b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0203a)) {
                        return false;
                    }
                    C0203a c0203a = (C0203a) obj;
                    return this.f10243a == c0203a.f10243a && this.f10244b == c0203a.f10244b;
                }

                public int hashCode() {
                    return (this.f10243a * 31) + this.f10244b;
                }

                public String toString() {
                    return "Coordinates(x=" + this.f10243a + ", y=" + this.f10244b + ")";
                }

                public final C0203a a(int i2, int i8) {
                    return new C0203a(i2, i8);
                }

                public static /* synthetic */ C0203a a(C0203a c0203a, int i2, int i8, int i9, Object obj) {
                    if ((i9 & 1) != 0) {
                        i2 = c0203a.f10243a;
                    }
                    if ((i9 & 2) != 0) {
                        i8 = c0203a.f10244b;
                    }
                    return c0203a.a(i2, i8);
                }
            }

            public C0202a(String successCallback, String failCallback, C2569t8.e productType, String demandSourceName, String url, C0203a coordinates, int i2, int i8) {
                kotlin.jvm.internal.k.e(successCallback, "successCallback");
                kotlin.jvm.internal.k.e(failCallback, "failCallback");
                kotlin.jvm.internal.k.e(productType, "productType");
                kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.e(url, "url");
                kotlin.jvm.internal.k.e(coordinates, "coordinates");
                this.f10238b = successCallback;
                this.f10239c = failCallback;
                this.f10240d = productType;
                this.e = demandSourceName;
                this.f10241f = url;
                this.g = coordinates;
                this.h = i2;
                this.f10242i = i8;
            }

            public final C0202a a(String successCallback, String failCallback, C2569t8.e productType, String demandSourceName, String url, C0203a coordinates, int i2, int i8) {
                kotlin.jvm.internal.k.e(successCallback, "successCallback");
                kotlin.jvm.internal.k.e(failCallback, "failCallback");
                kotlin.jvm.internal.k.e(productType, "productType");
                kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.e(url, "url");
                kotlin.jvm.internal.k.e(coordinates, "coordinates");
                return new C0202a(successCallback, failCallback, productType, demandSourceName, url, coordinates, i2, i8);
            }

            @Override // com.ironsource.InterfaceC2562t1.a
            public String b() {
                return this.f10241f;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String c() {
                return this.f10239c;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public C2569t8.e d() {
                return this.f10240d;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0202a)) {
                    return false;
                }
                C0202a c0202a = (C0202a) obj;
                return kotlin.jvm.internal.k.a(this.f10238b, c0202a.f10238b) && kotlin.jvm.internal.k.a(this.f10239c, c0202a.f10239c) && this.f10240d == c0202a.f10240d && kotlin.jvm.internal.k.a(this.e, c0202a.e) && kotlin.jvm.internal.k.a(this.f10241f, c0202a.f10241f) && kotlin.jvm.internal.k.a(this.g, c0202a.g) && this.h == c0202a.h && this.f10242i == c0202a.f10242i;
            }

            public final String f() {
                return this.f10238b;
            }

            public final String g() {
                return this.f10239c;
            }

            public final C2569t8.e h() {
                return this.f10240d;
            }

            public int hashCode() {
                return ((((this.g.hashCode() + androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b((this.f10240d.hashCode() + androidx.camera.core.processing.util.a.b(this.f10238b.hashCode() * 31, 31, this.f10239c)) * 31, 31, this.e), 31, this.f10241f)) * 31) + this.h) * 31) + this.f10242i;
            }

            public final String i() {
                return this.e;
            }

            public final String j() {
                return this.f10241f;
            }

            public final C0203a k() {
                return this.g;
            }

            public final int l() {
                return this.h;
            }

            public final int m() {
                return this.f10242i;
            }

            public final int n() {
                return this.h;
            }

            public final C0203a o() {
                return this.g;
            }

            public final int p() {
                return this.f10242i;
            }

            public String toString() {
                String str = this.f10238b;
                String str2 = this.f10239c;
                C2569t8.e eVar = this.f10240d;
                String str3 = this.e;
                String str4 = this.f10241f;
                C0203a c0203a = this.g;
                int i2 = this.h;
                int i8 = this.f10242i;
                StringBuilder sbZ = a1.a.z("Click(successCallback=", str, ", failCallback=", str2, ", productType=");
                sbZ.append(eVar);
                sbZ.append(", demandSourceName=");
                sbZ.append(str3);
                sbZ.append(", url=");
                sbZ.append(str4);
                sbZ.append(", coordinates=");
                sbZ.append(c0203a);
                sbZ.append(", action=");
                sbZ.append(i2);
                sbZ.append(", metaState=");
                sbZ.append(i8);
                sbZ.append(")");
                return sbZ.toString();
            }

            public static /* synthetic */ C0202a a(C0202a c0202a, String str, String str2, C2569t8.e eVar, String str3, String str4, C0203a c0203a, int i2, int i8, int i9, Object obj) {
                if ((i9 & 1) != 0) {
                    str = c0202a.f10238b;
                }
                if ((i9 & 2) != 0) {
                    str2 = c0202a.f10239c;
                }
                if ((i9 & 4) != 0) {
                    eVar = c0202a.f10240d;
                }
                if ((i9 & 8) != 0) {
                    str3 = c0202a.e;
                }
                if ((i9 & 16) != 0) {
                    str4 = c0202a.f10241f;
                }
                if ((i9 & 32) != 0) {
                    c0203a = c0202a.g;
                }
                if ((i9 & 64) != 0) {
                    i2 = c0202a.h;
                }
                if ((i9 & 128) != 0) {
                    i8 = c0202a.f10242i;
                }
                int i10 = i2;
                int i11 = i8;
                String str5 = str4;
                C0203a c0203a2 = c0203a;
                return c0202a.a(str, str2, eVar, str3, str5, c0203a2, i10, i11);
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String a() {
                return this.f10238b;
            }
        }

        /* JADX INFO: renamed from: com.ironsource.t1$a$b */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10245b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f10246c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final C2569t8.e f10247d;
            private final String e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final String f10248f;

            public b(String successCallback, String failCallback, C2569t8.e productType, String demandSourceName, String url) {
                kotlin.jvm.internal.k.e(successCallback, "successCallback");
                kotlin.jvm.internal.k.e(failCallback, "failCallback");
                kotlin.jvm.internal.k.e(productType, "productType");
                kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.e(url, "url");
                this.f10245b = successCallback;
                this.f10246c = failCallback;
                this.f10247d = productType;
                this.e = demandSourceName;
                this.f10248f = url;
            }

            public final b a(String successCallback, String failCallback, C2569t8.e productType, String demandSourceName, String url) {
                kotlin.jvm.internal.k.e(successCallback, "successCallback");
                kotlin.jvm.internal.k.e(failCallback, "failCallback");
                kotlin.jvm.internal.k.e(productType, "productType");
                kotlin.jvm.internal.k.e(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.e(url, "url");
                return new b(successCallback, failCallback, productType, demandSourceName, url);
            }

            @Override // com.ironsource.InterfaceC2562t1.a
            public String b() {
                return this.f10248f;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String c() {
                return this.f10246c;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public C2569t8.e d() {
                return this.f10247d;
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return kotlin.jvm.internal.k.a(this.f10245b, bVar.f10245b) && kotlin.jvm.internal.k.a(this.f10246c, bVar.f10246c) && this.f10247d == bVar.f10247d && kotlin.jvm.internal.k.a(this.e, bVar.e) && kotlin.jvm.internal.k.a(this.f10248f, bVar.f10248f);
            }

            public final String f() {
                return this.f10245b;
            }

            public final String g() {
                return this.f10246c;
            }

            public final C2569t8.e h() {
                return this.f10247d;
            }

            public int hashCode() {
                return this.f10248f.hashCode() + androidx.camera.core.processing.util.a.b((this.f10247d.hashCode() + androidx.camera.core.processing.util.a.b(this.f10245b.hashCode() * 31, 31, this.f10246c)) * 31, 31, this.e);
            }

            public final String i() {
                return this.e;
            }

            public final String j() {
                return this.f10248f;
            }

            public String toString() {
                String str = this.f10245b;
                String str2 = this.f10246c;
                C2569t8.e eVar = this.f10247d;
                String str3 = this.e;
                String str4 = this.f10248f;
                StringBuilder sbZ = a1.a.z("Impression(successCallback=", str, ", failCallback=", str2, ", productType=");
                sbZ.append(eVar);
                sbZ.append(", demandSourceName=");
                sbZ.append(str3);
                sbZ.append(", url=");
                return a1.a.r(sbZ, str4, ")");
            }

            public static /* synthetic */ b a(b bVar, String str, String str2, C2569t8.e eVar, String str3, String str4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = bVar.f10245b;
                }
                if ((i2 & 2) != 0) {
                    str2 = bVar.f10246c;
                }
                if ((i2 & 4) != 0) {
                    eVar = bVar.f10247d;
                }
                if ((i2 & 8) != 0) {
                    str3 = bVar.e;
                }
                if ((i2 & 16) != 0) {
                    str4 = bVar.f10248f;
                }
                String str5 = str4;
                C2569t8.e eVar2 = eVar;
                return bVar.a(str, str2, eVar2, str3, str5);
            }

            @Override // com.ironsource.InterfaceC2562t1
            public String a() {
                return this.f10245b;
            }
        }

        String b();
    }

    String a();

    String c();

    C2569t8.e d();

    String e();

    /* JADX INFO: renamed from: com.ironsource.t1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f10249a = new b();

        private b() {
        }

        public final InterfaceC2562t1 a(String jsonString) {
            kotlin.jvm.internal.k.e(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            String strOptString = jSONObject.optString("type", "none");
            if (kotlin.jvm.internal.k.a(strOptString, C2318f4.f8522c)) {
                return a(jSONObject);
            }
            throw new IllegalArgumentException(a1.a.l("unsupported message type: ", strOptString));
        }

        private final a a(JSONObject jSONObject) throws JSONException {
            String successCallback = jSONObject.getString("success");
            String failCallback = jSONObject.getString(C2300e4.f.e);
            String demandSourceName = jSONObject.getString("demandSourceName");
            String string = jSONObject.getString(C2300e4.h.m);
            kotlin.jvm.internal.k.d(string, "json.getString(ParametersKeys.PRODUCT_TYPE)");
            C2569t8.e eVarValueOf = C2569t8.e.valueOf(string);
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            String url = jSONObject2.getString("url");
            String strOptString = jSONObject2.optString("type");
            if (kotlin.jvm.internal.k.a(strOptString, C2318f4.f8523d)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(C2318f4.f8524f);
                int i2 = jSONObject3.getInt(C2318f4.g);
                int i8 = jSONObject3.getInt(C2318f4.h);
                int iOptInt = jSONObject2.optInt("action", 0);
                int iOptInt2 = jSONObject2.optInt(C2318f4.j, 0);
                kotlin.jvm.internal.k.d(successCallback, "successCallback");
                kotlin.jvm.internal.k.d(failCallback, "failCallback");
                kotlin.jvm.internal.k.d(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.d(url, "url");
                return new a.C0202a(successCallback, failCallback, eVarValueOf, demandSourceName, url, new a.C0202a.C0203a(i2, i8), iOptInt, iOptInt2);
            }
            if (kotlin.jvm.internal.k.a(strOptString, "impression")) {
                kotlin.jvm.internal.k.d(successCallback, "successCallback");
                kotlin.jvm.internal.k.d(failCallback, "failCallback");
                kotlin.jvm.internal.k.d(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.k.d(url, "url");
                return new a.b(successCallback, failCallback, eVarValueOf, demandSourceName, url);
            }
            throw new IllegalArgumentException(a1.a.l("JSON does not contain valid type: ", jSONObject2.optString("type")));
        }
    }
}
