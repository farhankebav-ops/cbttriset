package com.ironsource.sdk.controller;

import com.ironsource.C2569t8;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface m {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f10000d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String funToCall) {
            this(funToCall, null, null, null, 14, null);
            kotlin.jvm.internal.k.e(funToCall, "funToCall");
        }

        @Override // com.ironsource.sdk.controller.m
        public String a() {
            StringBuilder sb = new StringBuilder();
            sb.append("SSA_CORE.SDKController.runFunction('" + this.f9997a);
            String str = this.f9998b;
            if (str != null && str.length() != 0) {
                sb.append("?parameters=" + this.f9998b);
            }
            String str2 = this.f9999c;
            if (str2 != null && str2.length() != 0) {
                sb.append("','" + this.f9999c);
            }
            String str3 = this.f10000d;
            if (str3 != null && str3.length() != 0) {
                sb.append("','" + this.f10000d);
            }
            sb.append("');");
            String string = sb.toString();
            kotlin.jvm.internal.k.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String funToCall, String str) {
            this(funToCall, str, null, null, 12, null);
            kotlin.jvm.internal.k.e(funToCall, "funToCall");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String funToCall, String str, String str2) {
            this(funToCall, str, str2, null, 8, null);
            kotlin.jvm.internal.k.e(funToCall, "funToCall");
        }

        public a(String funToCall, String str, String str2, String str3) {
            kotlin.jvm.internal.k.e(funToCall, "funToCall");
            this.f9997a = funToCall;
            this.f9998b = str;
            this.f9999c = str2;
            this.f10000d = str3;
        }

        public /* synthetic */ a(String str, String str2, String str3, String str4, int i2, kotlin.jvm.internal.f fVar) {
            this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10002b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(m jsMethod, int i2) {
            this(jsMethod.a(), i2);
            kotlin.jvm.internal.k.e(jsMethod, "jsMethod");
        }

        @Override // com.ironsource.sdk.controller.m
        public String a() {
            String str = "console.log(\"JS exception: \" + JSON.stringify(e));";
            if (this.f10001a != C2569t8.d.MODE_0.b() && (this.f10001a < C2569t8.d.MODE_1.b() || this.f10001a > C2569t8.d.MODE_3.b())) {
                str = "empty";
            }
            String strN = androidx.camera.core.processing.util.a.n(new StringBuilder("try{"), this.f10002b, "}catch(e){", str, "}");
            kotlin.jvm.internal.k.d(strN, "StringBuilder()\n        …}\")\n          .toString()");
            return strN;
        }

        public b(String script, int i2) {
            kotlin.jvm.internal.k.e(script, "script");
            this.f10002b = script;
            this.f10001a = i2;
        }
    }

    String a();
}
