package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: renamed from: com.ironsource.h8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2358h8 extends C2598v3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C2358h8 f8645d = new C2358h8();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2361hb f8646b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2361hb f8647c = null;

    /* JADX INFO: renamed from: com.ironsource.h8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8648a;

        public a(AdInfo adInfo) {
            this.f8648a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.e(c2358h8.a(this.f8648a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + C2358h8.this.a(this.f8648a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f8650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f8651b;

        public b(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f8650a = ironSourceError;
            this.f8651b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.a(this.f8650a, c2358h8.a(this.f8651b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C2358h8.this.a(this.f8651b) + ", error = " + this.f8650a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f8653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f8654b;

        public c(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f8653a = ironSourceError;
            this.f8654b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.a(this.f8653a, c2358h8.a(this.f8654b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C2358h8.this.a(this.f8654b) + ", error = " + this.f8653a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8656a;

        public d(AdInfo adInfo) {
            this.f8656a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.d(c2358h8.a(this.f8656a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C2358h8.this.a(this.f8656a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8658a;

        public e(AdInfo adInfo) {
            this.f8658a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.d(c2358h8.a(this.f8658a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C2358h8.this.a(this.f8658a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8660a;

        public f(AdInfo adInfo) {
            this.f8660a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.a(c2358h8.a(this.f8660a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C2358h8.this.a(this.f8660a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$g */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8662a;

        public g(AdInfo adInfo) {
            this.f8662a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.a(c2358h8.a(this.f8662a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C2358h8.this.a(this.f8662a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$h */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f8664a;

        public h(IronSourceError ironSourceError) {
            this.f8664a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2361hb interfaceC2361hb = C2358h8.this.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.b(this.f8664a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f8664a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$i */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f8666a;

        public i(IronSourceError ironSourceError) {
            this.f8666a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2361hb interfaceC2361hb = C2358h8.this.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.b(this.f8666a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f8666a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$j */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8668a;

        public j(AdInfo adInfo) {
            this.f8668a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.c(c2358h8.a(this.f8668a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C2358h8.this.a(this.f8668a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$k */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8670a;

        public k(AdInfo adInfo) {
            this.f8670a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.c(c2358h8.a(this.f8670a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C2358h8.this.a(this.f8670a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$l */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8672a;

        public l(AdInfo adInfo) {
            this.f8672a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.b(c2358h8.a(this.f8672a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C2358h8.this.a(this.f8672a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$m */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8674a;

        public m(AdInfo adInfo) {
            this.f8674a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8646b;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.b(c2358h8.a(this.f8674a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C2358h8.this.a(this.f8674a));
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.h8$n */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f8676a;

        public n(AdInfo adInfo) {
            this.f8676a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2358h8 c2358h8 = C2358h8.this;
            InterfaceC2361hb interfaceC2361hb = c2358h8.f8647c;
            if (interfaceC2361hb != null) {
                interfaceC2361hb.e(c2358h8.a(this.f8676a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + C2358h8.this.a(this.f8676a));
            }
        }
    }

    private C2358h8() {
    }

    public static synchronized C2358h8 a() {
        return f8645d;
    }

    public void d(AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public synchronized void a(InterfaceC2361hb interfaceC2361hb) {
        this.f8646b = interfaceC2361hb;
    }

    public synchronized void b(InterfaceC2361hb interfaceC2361hb) {
        this.f8647c = interfaceC2361hb;
    }

    public void c(AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(ironSourceError));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(ironSourceError));
        }
    }

    public void b(AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.f8647c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(ironSourceError, adInfo));
        } else if (this.f8646b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(ironSourceError, adInfo));
        }
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
