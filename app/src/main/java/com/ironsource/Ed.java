package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Ed extends C2598v3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Ed f6679d = new Ed();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2555sb f6680b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2555sb f6681c = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6683b;

        public a(boolean z2, AdInfo adInfo) {
            this.f6682a = z2;
            this.f6683b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                if (!this.f6682a) {
                    ((InterfaceC2572tb) interfaceC2555sb).a();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                    return;
                }
                ((InterfaceC2572tb) interfaceC2555sb).d(ed.a(this.f6683b));
                IronLog.CALLBACK.info("onAdAvailable() adInfo = " + Ed.this.a(this.f6683b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2434ld f6685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6686b;

        public b(C2434ld c2434ld, AdInfo adInfo) {
            this.f6685a = c2434ld;
            this.f6686b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.b(this.f6685a, ed.a(this.f6686b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f6685a + ", adInfo = " + Ed.this.a(this.f6686b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2434ld f6688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6689b;

        public c(C2434ld c2434ld, AdInfo adInfo) {
            this.f6688a = c2434ld;
            this.f6689b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.b(this.f6688a, ed.a(this.f6689b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f6688a + ", adInfo = " + Ed.this.a(this.f6689b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f6691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6692b;

        public d(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f6691a = ironSourceError;
            this.f6692b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.a(this.f6691a, ed.a(this.f6692b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + Ed.this.a(this.f6692b) + ", error = " + this.f6691a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f6694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6695b;

        public e(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f6694a = ironSourceError;
            this.f6695b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.a(this.f6694a, ed.a(this.f6695b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + Ed.this.a(this.f6695b) + ", error = " + this.f6694a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2434ld f6697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6698b;

        public f(C2434ld c2434ld, AdInfo adInfo) {
            this.f6697a = c2434ld;
            this.f6698b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.a(this.f6697a, ed.a(this.f6698b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f6697a + ", adInfo = " + Ed.this.a(this.f6698b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2434ld f6700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6701b;

        public g(C2434ld c2434ld, AdInfo adInfo) {
            this.f6700a = c2434ld;
            this.f6701b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.a(this.f6700a, ed.a(this.f6701b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f6700a + ", adInfo = " + Ed.this.a(this.f6701b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6703a;

        public h(AdInfo adInfo) {
            this.f6703a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                ((InterfaceC2589ub) interfaceC2555sb).a(ed.a(this.f6703a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + Ed.this.a(this.f6703a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6705a;

        public i(AdInfo adInfo) {
            this.f6705a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                ((InterfaceC2589ub) interfaceC2555sb).a(ed.a(this.f6705a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + Ed.this.a(this.f6705a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f6707a;

        public j(IronSourceError ironSourceError) {
            this.f6707a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2555sb interfaceC2555sb = Ed.this.f6681c;
            if (interfaceC2555sb != null) {
                ((InterfaceC2589ub) interfaceC2555sb).b(this.f6707a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f6707a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f6709a;

        public k(IronSourceError ironSourceError) {
            this.f6709a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2555sb interfaceC2555sb = Ed.this.f6680b;
            if (interfaceC2555sb != null) {
                ((InterfaceC2589ub) interfaceC2555sb).b(this.f6709a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f6709a.getErrorMessage());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6711a;

        public l(AdInfo adInfo) {
            this.f6711a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.c(ed.a(this.f6711a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + Ed.this.a(this.f6711a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6713a;

        public m(AdInfo adInfo) {
            this.f6713a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.c(ed.a(this.f6713a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + Ed.this.a(this.f6713a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6715a;

        public n(AdInfo adInfo) {
            this.f6715a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.b(ed.a(this.f6715a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + Ed.this.a(this.f6715a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f6717a;

        public o(AdInfo adInfo) {
            this.f6717a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6680b;
            if (interfaceC2555sb != null) {
                interfaceC2555sb.b(ed.a(this.f6717a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + Ed.this.a(this.f6717a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f6720b;

        public p(boolean z2, AdInfo adInfo) {
            this.f6719a = z2;
            this.f6720b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ed ed = Ed.this;
            InterfaceC2555sb interfaceC2555sb = ed.f6681c;
            if (interfaceC2555sb != null) {
                if (!this.f6719a) {
                    ((InterfaceC2572tb) interfaceC2555sb).a();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                    return;
                }
                ((InterfaceC2572tb) interfaceC2555sb).d(ed.a(this.f6720b));
                IronLog.CALLBACK.info("onAdAvailable() adInfo = " + Ed.this.a(this.f6720b));
            }
        }
    }

    private Ed() {
    }

    public static Ed a() {
        return f6679d;
    }

    public void b() {
    }

    public void c() {
    }

    public void d(AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
            return;
        }
        InterfaceC2555sb interfaceC2555sb = this.f6680b;
        if (interfaceC2555sb == null || !(interfaceC2555sb instanceof InterfaceC2589ub)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
    }

    public void a(InterfaceC2555sb interfaceC2555sb) {
        this.f6680b = interfaceC2555sb;
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(ironSourceError));
            return;
        }
        InterfaceC2555sb interfaceC2555sb = this.f6680b;
        if (interfaceC2555sb == null || !(interfaceC2555sb instanceof InterfaceC2589ub)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(ironSourceError));
    }

    public void b(InterfaceC2555sb interfaceC2555sb) {
        this.f6681c = interfaceC2555sb;
    }

    public void c(AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f6680b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void b(AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.f6680b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(adInfo));
        }
    }

    public void a(boolean z2, AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(z2, adInfo));
            return;
        }
        InterfaceC2555sb interfaceC2555sb = this.f6680b;
        if (interfaceC2555sb == null || !(interfaceC2555sb instanceof InterfaceC2572tb)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(z2, adInfo));
    }

    public void b(C2434ld c2434ld, AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(c2434ld, adInfo));
        } else if (this.f6680b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(c2434ld, adInfo));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(ironSourceError, adInfo));
        } else if (this.f6680b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(ironSourceError, adInfo));
        }
    }

    public void a(C2434ld c2434ld, AdInfo adInfo) {
        if (this.f6681c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(c2434ld, adInfo));
        } else if (this.f6680b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(c2434ld, adInfo));
        }
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
