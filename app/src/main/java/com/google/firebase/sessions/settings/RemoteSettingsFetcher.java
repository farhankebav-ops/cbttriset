package com.google.firebase.sessions.settings;

import android.net.Uri;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.sessions.ApplicationInfo;
import e6.p;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import v5.c;
import v5.h;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    public static final Companion Companion = new Companion(null);
    private static final String FIREBASE_PLATFORM = "android";
    private static final String FIREBASE_SESSIONS_BASE_URL_STRING = "firebase-settings.crashlytics.com";
    private final ApplicationInfo appInfo;
    private final h blockingDispatcher;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {73, 75, 78}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Map<String, String> $headerOptions;
        final /* synthetic */ p $onFailure;
        final /* synthetic */ p $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map<String, String> map, p pVar, p pVar2, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$headerOptions = map;
            this.$onSuccess = pVar;
            this.$onFailure = pVar2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return RemoteSettingsFetcher.this.new AnonymousClass2(this.$headerOptions, this.$onSuccess, this.$onFailure, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
        
            if (r8.invoke(r1, r7) == r0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d7, code lost:
        
            if (r1.invoke(r3, r7) != r0) goto L37;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettingsFetcher.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo appInfo, @Blocking h blockingDispatcher) {
        k.e(appInfo, "appInfo");
        k.e(blockingDispatcher, "blockingDispatcher");
        this.appInfo = appInfo;
        this.blockingDispatcher = blockingDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL settingsUrl() {
        return new URL(new Uri.Builder().scheme("https").authority(FIREBASE_SESSIONS_BASE_URL_STRING).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.appInfo.getAppId()).appendPath("settings").appendQueryParameter("build_version", this.appInfo.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter("display_version", this.appInfo.getAndroidAppInfo().getVersionName()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public Object doConfigFetch(Map<String, String> map, p pVar, p pVar2, c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(map, pVar, pVar2, null), this.blockingDispatcher, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
