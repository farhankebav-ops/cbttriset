package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2331g;
import com.ironsource.InterfaceC2349h;
import com.ironsource.Tc;
import com.ironsource.Uc;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface p {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Uc f10046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final InterfaceC2331g f10047b;

            public a(Uc configurations, InterfaceC2331g intentFactory) {
                kotlin.jvm.internal.k.e(configurations, "configurations");
                kotlin.jvm.internal.k.e(intentFactory, "intentFactory");
                this.f10046a = configurations;
                this.f10047b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Tc openUrl) {
                kotlin.jvm.internal.k.e(context, "context");
                kotlin.jvm.internal.k.e(openUrl, "openUrl");
                if (TextUtils.isEmpty(openUrl.d())) {
                    return new c.a("url is empty");
                }
                Intent intentA = this.f10047b.a();
                intentA.setData(Uri.parse(openUrl.d()));
                String strC = openUrl.c();
                if (strC != null && strC.length() != 0) {
                    intentA = intentA.setPackage(openUrl.c());
                    kotlin.jvm.internal.k.d(intentA, "this.setPackage(openUrl.packageName)");
                }
                if (!(context instanceof Activity)) {
                    intentA = intentA.addFlags(this.f10046a.c());
                }
                kotlin.jvm.internal.k.d(intentA, "intentFactory\n          …ations.flags) else this }");
                context.startActivity(intentA);
                return c.b.f10054a;
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0198b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10048a;

            public C0198b(String method) {
                kotlin.jvm.internal.k.e(method, "method");
                this.f10048a = method;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Tc openUrl) {
                kotlin.jvm.internal.k.e(context, "context");
                kotlin.jvm.internal.k.e(openUrl, "openUrl");
                return new c.a(a1.a.m("method ", this.f10048a, " is unsupported"));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Uc f10049a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final InterfaceC2349h f10050b;

            public c(Uc configurations, InterfaceC2349h intentFactory) {
                kotlin.jvm.internal.k.e(configurations, "configurations");
                kotlin.jvm.internal.k.e(intentFactory, "intentFactory");
                this.f10049a = configurations;
                this.f10050b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Tc openUrl) {
                kotlin.jvm.internal.k.e(context, "context");
                kotlin.jvm.internal.k.e(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.f10050b).a(this.f10049a.c()).a(openUrl.d()).b(true).c(true).a(context));
                return c.b.f10054a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class d implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Uc f10051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final InterfaceC2349h f10052b;

            public d(Uc configurations, InterfaceC2349h intentFactory) {
                kotlin.jvm.internal.k.e(configurations, "configurations");
                kotlin.jvm.internal.k.e(intentFactory, "intentFactory");
                this.f10051a = configurations;
                this.f10052b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Tc openUrl) {
                kotlin.jvm.internal.k.e(context, "context");
                kotlin.jvm.internal.k.e(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.f10052b).a(this.f10051a.c()).a(openUrl.d()).a(this.f10051a.d()).b(true).a(context));
                return c.b.f10054a;
            }
        }

        c a(Context context, Tc tc);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class c {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10053a;

            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public final String a() {
                return this.f10053a;
            }

            public final String b() {
                return this.f10053a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f10053a, ((a) obj).f10053a);
            }

            public int hashCode() {
                return this.f10053a.hashCode();
            }

            public String toString() {
                return a1.a.m("Error(errorMessage=", this.f10053a, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String errorMessage) {
                super(null);
                kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
                this.f10053a = errorMessage;
            }

            public final a a(String errorMessage) {
                kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
                return new a(errorMessage);
            }

            public /* synthetic */ a(String str, int i2, kotlin.jvm.internal.f fVar) {
                this((i2 & 1) != 0 ? "" : str);
            }

            public static /* synthetic */ a a(a aVar, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = aVar.f10053a;
                }
                return aVar.a(str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f10054a = new b();

            private b() {
                super(null);
            }
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }

        private c() {
        }
    }

    c a(Context context, Tc tc);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f10045a;

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r3, com.ironsource.Uc r4, com.ironsource.InterfaceC2349h r5, com.ironsource.InterfaceC2331g r6) {
            /*
                r2 = this;
                java.lang.String r0 = "method"
                kotlin.jvm.internal.k.e(r3, r0)
                java.lang.String r0 = "openUrlConfigurations"
                kotlin.jvm.internal.k.e(r4, r0)
                java.lang.String r0 = "activityIntentFactory"
                kotlin.jvm.internal.k.e(r5, r0)
                java.lang.String r0 = "actionIntentFactory"
                kotlin.jvm.internal.k.e(r6, r0)
                r2.<init>()
                int r0 = r3.hashCode()
                r1 = -1455867212(0xffffffffa9393ab4, float:-4.112917E-14)
                if (r0 == r1) goto L49
                r6 = 109770977(0x68af8e1, float:5.2275525E-35)
                if (r0 == r6) goto L3a
                r6 = 1224424441(0x48fb3bf9, float:514527.78)
                if (r0 == r6) goto L2b
                goto L57
            L2b:
                java.lang.String r6 = "webview"
                boolean r6 = r3.equals(r6)
                if (r6 != 0) goto L34
                goto L57
            L34:
                com.ironsource.sdk.controller.p$b$d r3 = new com.ironsource.sdk.controller.p$b$d
                r3.<init>(r4, r5)
                goto L5d
            L3a:
                java.lang.String r6 = "store"
                boolean r6 = r3.equals(r6)
                if (r6 != 0) goto L43
                goto L57
            L43:
                com.ironsource.sdk.controller.p$b$c r3 = new com.ironsource.sdk.controller.p$b$c
                r3.<init>(r4, r5)
                goto L5d
            L49:
                java.lang.String r5 = "external_browser"
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L57
                com.ironsource.sdk.controller.p$b$a r3 = new com.ironsource.sdk.controller.p$b$a
                r3.<init>(r4, r6)
                goto L5d
            L57:
                com.ironsource.sdk.controller.p$b$b r4 = new com.ironsource.sdk.controller.p$b$b
                r4.<init>(r3)
                r3 = r4
            L5d:
                r2.f10045a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.p.a.<init>(java.lang.String, com.ironsource.Uc, com.ironsource.h, com.ironsource.g):void");
        }

        @Override // com.ironsource.sdk.controller.p
        public c a(Context context, Tc openUrl) {
            kotlin.jvm.internal.k.e(context, "context");
            kotlin.jvm.internal.k.e(openUrl, "openUrl");
            try {
                return this.f10045a.a(context, openUrl);
            } catch (Exception e) {
                C2531r4.d().a(e);
                String message = e.getMessage();
                String message2 = (message == null || message.length() == 0) ? "" : e.getMessage();
                kotlin.jvm.internal.k.b(message2);
                return new c.a(message2);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String method, Uc openUrlConfigurations) {
            this(method, openUrlConfigurations, new k.b(), new k.a());
            kotlin.jvm.internal.k.e(method, "method");
            kotlin.jvm.internal.k.e(openUrlConfigurations, "openUrlConfigurations");
        }
    }
}
