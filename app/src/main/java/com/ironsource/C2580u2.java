package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.u2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2580u2 extends C2598v3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C2580u2 f10327d = new C2580u2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Fa f10328b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Fa f10329c = null;

    /* JADX INFO: renamed from: com.ironsource.u2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10330a;

        public a(AdInfo adInfo) {
            this.f10330a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10328b;
            if (fa != null) {
                fa.g(c2580u2.a(this.f10330a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + C2580u2.this.a(this.f10330a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10332a;

        public b(AdInfo adInfo) {
            this.f10332a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10329c;
            if (fa != null) {
                fa.d(c2580u2.a(this.f10332a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C2580u2.this.a(this.f10332a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10334a;

        public c(AdInfo adInfo) {
            this.f10334a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10328b;
            if (fa != null) {
                fa.d(c2580u2.a(this.f10334a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C2580u2.this.a(this.f10334a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10336a;

        public d(AdInfo adInfo) {
            this.f10336a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10329c;
            if (fa != null) {
                fa.e(c2580u2.a(this.f10336a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + C2580u2.this.a(this.f10336a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10338a;

        public e(AdInfo adInfo) {
            this.f10338a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10328b;
            if (fa != null) {
                fa.e(c2580u2.a(this.f10338a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + C2580u2.this.a(this.f10338a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f10340a;

        public f(IronSourceError ironSourceError) {
            this.f10340a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            Fa fa = C2580u2.this.f10329c;
            if (fa != null) {
                fa.b(this.f10340a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f10340a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$g */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f10342a;

        public g(IronSourceError ironSourceError) {
            this.f10342a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            Fa fa = C2580u2.this.f10328b;
            if (fa != null) {
                fa.b(this.f10342a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f10342a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$h */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10344a;

        public h(AdInfo adInfo) {
            this.f10344a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10329c;
            if (fa != null) {
                fa.h(c2580u2.a(this.f10344a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + C2580u2.this.a(this.f10344a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$i */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10346a;

        public i(AdInfo adInfo) {
            this.f10346a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10328b;
            if (fa != null) {
                fa.h(c2580u2.a(this.f10346a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + C2580u2.this.a(this.f10346a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$j */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10348a;

        public j(AdInfo adInfo) {
            this.f10348a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10329c;
            if (fa != null) {
                fa.f(c2580u2.a(this.f10348a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + C2580u2.this.a(this.f10348a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$k */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10350a;

        public k(AdInfo adInfo) {
            this.f10350a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10328b;
            if (fa != null) {
                fa.f(c2580u2.a(this.f10350a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + C2580u2.this.a(this.f10350a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u2$l */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f10352a;

        public l(AdInfo adInfo) {
            this.f10352a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2580u2 c2580u2 = C2580u2.this;
            Fa fa = c2580u2.f10329c;
            if (fa != null) {
                fa.g(c2580u2.a(this.f10352a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + C2580u2.this.a(this.f10352a));
            }
        }
    }

    private C2580u2() {
    }

    public static C2580u2 a() {
        return f10327d;
    }

    public void d(AdInfo adInfo) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
        }
    }

    public void a(Fa fa) {
        this.f10328b = fa;
    }

    public void b(Fa fa) {
        this.f10329c = fa;
    }

    public void c(AdInfo adInfo) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(ironSourceError));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(ironSourceError));
        }
    }

    public Fa b() {
        return this.f10328b;
    }

    public void b(AdInfo adInfo) {
        if (this.f10329c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(adInfo));
        } else if (this.f10328b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(adInfo));
        }
    }
}
