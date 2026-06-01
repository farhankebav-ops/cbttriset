package com.ironsource;

import com.ironsource.InterfaceC2268c8;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.t2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2563t2 extends InterfaceC2268c8.a<ISDemandOnlyBannerListener> {

    /* JADX INFO: renamed from: com.ironsource.t2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f10251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f10252c;

        public a(String str, IronSourceError ironSourceError, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f10250a = str;
            this.f10251b = ironSourceError;
            this.f10252c = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2563t2.this.a(this.f10250a, "onBannerAdLoadFailed() error = " + this.f10251b.getErrorMessage());
            this.f10252c.onBannerAdLoadFailed(this.f10250a, this.f10251b);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t2$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f10255b;

        public b(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f10254a = str;
            this.f10255b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2563t2.this.a(this.f10254a, "onBannerAdLoaded()");
            this.f10255b.onBannerAdLoaded(this.f10254a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t2$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f10258b;

        public c(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f10257a = str;
            this.f10258b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2563t2.this.a(this.f10257a, "onBannerAdShown()");
            this.f10258b.onBannerAdShown(this.f10257a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t2$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f10261b;

        public d(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f10260a = str;
            this.f10261b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2563t2.this.a(this.f10260a, "onBannerAdClicked()");
            this.f10261b.onBannerAdClicked(this.f10260a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t2$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f10264b;

        public e(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f10263a = str;
            this.f10264b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2563t2.this.a(this.f10263a, "onBannerAdLeftApplication()");
            this.f10264b.onBannerAdLeftApplication(this.f10263a);
        }
    }

    public void a(String str, IronSourceError ironSourceError) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new a(str, ironSourceError, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void b(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new e(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void c(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new b(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void d(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new c(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void a(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new d(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }
}
