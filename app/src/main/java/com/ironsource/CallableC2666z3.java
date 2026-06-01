package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.ironsource.z3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class CallableC2666z3 implements Callable<D3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdData f10614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final B3 f10615d;
    private final A3 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NetworkSettings f10616f;

    /* JADX INFO: renamed from: com.ironsource.z3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements BiddingDataCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2426l5 f10617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f10618b;

        public a(C2426l5 c2426l5, BlockingQueue blockingQueue) {
            this.f10617a = c2426l5;
            this.f10618b = blockingQueue;
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onFailure(String str) {
            this.f10618b.add(new D3(CallableC2666z3.this.d(), CallableC2666z3.this.c(), null, C2426l5.a(this.f10617a), str));
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onSuccess(Map<String, Object> map) {
            this.f10618b.add(new D3(CallableC2666z3.this.d(), CallableC2666z3.this.c(), map, C2426l5.a(this.f10617a), null));
        }
    }

    public CallableC2666z3(int i2, String str, AdData adData, B3 b32, A3 a32, NetworkSettings networkSettings) {
        this.f10612a = i2;
        this.f10613b = str;
        this.f10614c = adData;
        this.f10615d = b32;
        this.e = a32;
        this.f10616f = networkSettings;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public D3 call() throws Exception {
        C2426l5 c2426l5 = new C2426l5();
        IronLog.INTERNAL.verbose(c() + " fetching bidding data");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        try {
            b().collectBiddingData(this.f10614c, ContextProvider.getInstance().getActiveContext(), new a(c2426l5, arrayBlockingQueue));
        } catch (Exception e) {
            C2531r4.d().a(e);
            String strJ = a1.a.j(e, new StringBuilder("Exception while calling collectBiddingData - "));
            IronLog.INTERNAL.error(strJ);
            A3 a32 = this.e;
            if (a32 != null) {
                a32.a(strJ);
            }
        } catch (NoClassDefFoundError e4) {
            C2531r4.d().a(e4);
            String str = "Error while calling collectBiddingData - " + e4.getMessage();
            IronLog.INTERNAL.error(str);
            A3 a33 = this.e;
            if (a33 != null) {
                a33.a(str);
            }
        }
        A3 a34 = this.e;
        if (a34 != null) {
            a34.a(this.f10616f);
        }
        return (D3) arrayBlockingQueue.take();
    }

    public B3 b() {
        return this.f10615d;
    }

    public String c() {
        return this.f10613b;
    }

    public int d() {
        return this.f10612a;
    }
}
