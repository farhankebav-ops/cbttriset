package com.onesignal.core.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.internal.backend.FCMParamsObject;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.InfluenceParamsObject;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.session.internal.outcomes.impl.OutcomeConstants;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ParamsBackendService implements IParamsBackendService {
    private final IHttpClient _http;

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.backend.impl.ParamsBackendService", f = "ParamsBackendService.kt", l = {35}, m = "fetchParams")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ParamsBackendService.this.fetchParams(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ a0 $influenceParams;
        final /* synthetic */ ParamsBackendService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a0 a0Var, ParamsBackendService paramsBackendService) {
            super(1);
            this.$influenceParams = a0Var;
            this.this$0 = paramsBackendService;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject it) {
            k.e(it, "it");
            this.$influenceParams.f12717a = this.this$0.processOutcomeJson(it);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$fetchParams$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 extends l implements e6.l {
        final /* synthetic */ a0 $fcmParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(a0 a0Var) {
            super(1);
            this.$fcmParams = a0Var;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject it) {
            k.e(it, "it");
            a0 a0Var = this.$fcmParams;
            String strSafeString = JSONObjectExtensionsKt.safeString(it, "api_key");
            a0Var.f12717a = new FCMParamsObject(JSONObjectExtensionsKt.safeString(it, "project_id"), JSONObjectExtensionsKt.safeString(it, "app_id"), strSafeString);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26931 extends l implements e6.l {
        final /* synthetic */ a0 $isDirectEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26931(a0 a0Var) {
            super(1);
            this.$isDirectEnabled = a0Var;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject it) {
            k.e(it, "it");
            this.$isDirectEnabled.f12717a = JSONObjectExtensionsKt.safeBool(it, "enabled");
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26942 extends l implements e6.l {
        final /* synthetic */ a0 $iamLimit;
        final /* synthetic */ a0 $indirectIAMAttributionWindow;
        final /* synthetic */ a0 $indirectNotificationAttributionWindow;
        final /* synthetic */ a0 $isIndirectEnabled;
        final /* synthetic */ a0 $notificationLimit;

        /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ a0 $indirectNotificationAttributionWindow;
            final /* synthetic */ a0 $notificationLimit;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(a0 a0Var, a0 a0Var2) {
                super(1);
                this.$indirectNotificationAttributionWindow = a0Var;
                this.$notificationLimit = a0Var2;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JSONObject) obj);
                return x.f13520a;
            }

            public final void invoke(JSONObject it) {
                k.e(it, "it");
                this.$indirectNotificationAttributionWindow.f12717a = JSONObjectExtensionsKt.safeInt(it, "minutes_since_displayed");
                this.$notificationLimit.f12717a = JSONObjectExtensionsKt.safeInt(it, "limit");
            }
        }

        /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C02102 extends l implements e6.l {
            final /* synthetic */ a0 $iamLimit;
            final /* synthetic */ a0 $indirectIAMAttributionWindow;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02102(a0 a0Var, a0 a0Var2) {
                super(1);
                this.$indirectIAMAttributionWindow = a0Var;
                this.$iamLimit = a0Var2;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JSONObject) obj);
                return x.f13520a;
            }

            public final void invoke(JSONObject it) {
                k.e(it, "it");
                this.$indirectIAMAttributionWindow.f12717a = JSONObjectExtensionsKt.safeInt(it, "minutes_since_displayed");
                this.$iamLimit.f12717a = JSONObjectExtensionsKt.safeInt(it, "limit");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26942(a0 a0Var, a0 a0Var2, a0 a0Var3, a0 a0Var4, a0 a0Var5) {
            super(1);
            this.$isIndirectEnabled = a0Var;
            this.$indirectNotificationAttributionWindow = a0Var2;
            this.$notificationLimit = a0Var3;
            this.$indirectIAMAttributionWindow = a0Var4;
            this.$iamLimit = a0Var5;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws JSONException {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject indirectJSON) throws JSONException {
            k.e(indirectJSON, "indirectJSON");
            this.$isIndirectEnabled.f12717a = JSONObjectExtensionsKt.safeBool(indirectJSON, "enabled");
            JSONObjectExtensionsKt.expandJSONObject(indirectJSON, "notification_attribution", new AnonymousClass1(this.$indirectNotificationAttributionWindow, this.$notificationLimit));
            JSONObjectExtensionsKt.expandJSONObject(indirectJSON, "in_app_message_attribution", new C02102(this.$indirectIAMAttributionWindow, this.$iamLimit));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.backend.impl.ParamsBackendService$processOutcomeJson$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26953 extends l implements e6.l {
        final /* synthetic */ a0 $isUnattributedEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26953(a0 a0Var) {
            super(1);
            this.$isUnattributedEnabled = a0Var;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject it) {
            k.e(it, "it");
            this.$isUnattributedEnabled.f12717a = JSONObjectExtensionsKt.safeBool(it, "enabled");
        }
    }

    public ParamsBackendService(IHttpClient _http) {
        k.e(_http, "_http");
        this._http = _http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InfluenceParamsObject processOutcomeJson(JSONObject jSONObject) throws JSONException {
        a0 a0Var = new a0();
        a0 a0Var2 = new a0();
        a0 a0Var3 = new a0();
        a0 a0Var4 = new a0();
        a0 a0Var5 = new a0();
        a0 a0Var6 = new a0();
        a0 a0Var7 = new a0();
        JSONObjectExtensionsKt.expandJSONObject(jSONObject, "direct", new C26931(a0Var5));
        JSONObjectExtensionsKt.expandJSONObject(jSONObject, OutcomeConstants.INDIRECT, new C26942(a0Var6, a0Var, a0Var2, a0Var3, a0Var4));
        JSONObjectExtensionsKt.expandJSONObject(jSONObject, "unattributed", new C26953(a0Var7));
        return new InfluenceParamsObject((Integer) a0Var.f12717a, (Integer) a0Var2.f12717a, (Integer) a0Var3.f12717a, (Integer) a0Var4.f12717a, (Boolean) a0Var5.f12717a, (Boolean) a0Var6.f12717a, (Boolean) a0Var7.f12717a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.onesignal.core.internal.backend.IParamsBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchParams(java.lang.String r31, java.lang.String r32, v5.c<? super com.onesignal.core.internal.backend.ParamsObject> r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams(java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }
}
