package com.ironsource;

import com.ironsource.InterfaceC2268c8;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.a8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2232a8 extends InterfaceC2268c8.a<ISDemandOnlyInterstitialListener> implements ISDemandOnlyInterstitialListener {

    /* JADX INFO: renamed from: com.ironsource.a8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7963b;

        public a(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7962a = str;
            this.f7963b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7962a, "onInterstitialAdReady()");
            this.f7963b.onInterstitialAdReady(this.f7962a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f7966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7967c;

        public b(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7965a = str;
            this.f7966b = ironSourceError;
            this.f7967c = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7965a, "onInterstitialAdLoadFailed() error = " + this.f7966b.getErrorMessage());
            this.f7967c.onInterstitialAdLoadFailed(this.f7965a, this.f7966b);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a8$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7970b;

        public c(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7969a = str;
            this.f7970b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7969a, "onInterstitialAdOpened()");
            this.f7970b.onInterstitialAdOpened(this.f7969a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a8$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f7973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7974c;

        public d(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7972a = str;
            this.f7973b = ironSourceError;
            this.f7974c = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7972a, "onInterstitialAdShowFailed() error = " + this.f7973b.getErrorMessage());
            this.f7974c.onInterstitialAdShowFailed(this.f7972a, this.f7973b);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a8$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7977b;

        public e(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7976a = str;
            this.f7977b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7976a, "onInterstitialAdClicked()");
            this.f7977b.onInterstitialAdClicked(this.f7976a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.a8$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyInterstitialListener f7980b;

        public f(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f7979a = str;
            this.f7980b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2232a8.this.a(this.f7979a, "onInterstitialAdClosed()");
            this.f7980b.onInterstitialAdClosed(this.f7979a);
        }
    }

    public C2232a8(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        b(iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClicked(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new e(str, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClosed(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new f(str, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new b(str, ironSourceError, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdOpened(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new c(str, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdReady(String str) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new a(str, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdShowFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = a();
        a(new d(str, ironSourceError, iSDemandOnlyInterstitialListenerA), iSDemandOnlyInterstitialListenerA != null);
    }

    public C2232a8() {
    }
}
