package com.ironsource;

import android.content.Context;
import com.ironsource.D0;
import com.ironsource.D9;
import com.ironsource.L8;
import com.ironsource.Mb;
import com.ironsource.N7;
import com.ironsource.Td;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import com.unity3d.mediation.segment.LevelPlaySegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: renamed from: com.ironsource.vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2606vb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2606vb f10443a = new C2606vb();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C2623wb f10444b = new C2623wb();

    /* JADX INFO: renamed from: com.ironsource.vb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2541re {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f10445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f10446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ C2426l5 f10447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitListener f10448d;

        public a(LevelPlayInitRequest levelPlayInitRequest, Context context, C2426l5 c2426l5, LevelPlayInitListener levelPlayInitListener) {
            this.f10445a = levelPlayInitRequest;
            this.f10446b = context;
            this.f10447c = c2426l5;
            this.f10448d = levelPlayInitListener;
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2435le sdkConfig) {
            kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
            C2606vb.f10444b.a(new androidx.camera.core.w(this.f10445a, sdkConfig, this.f10446b, this.f10447c, this.f10448d, 3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, C2435le sdkConfig, Context context, C2426l5 initDuration, LevelPlayInitListener levelPlayInitListener) {
            kotlin.jvm.internal.k.e(initRequest, "$initRequest");
            kotlin.jvm.internal.k.e(sdkConfig, "$sdkConfig");
            kotlin.jvm.internal.k.e(context, "$context");
            kotlin.jvm.internal.k.e(initDuration, "$initDuration");
            C2606vb.f10443a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2473ne error) {
            kotlin.jvm.internal.k.e(error, "error");
            C2606vb.f10444b.a(new androidx.camera.core.processing.c(this.f10448d, this.f10447c, error, 24));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, C2426l5 initDuration, C2473ne error) throws JSONException {
            kotlin.jvm.internal.k.e(initDuration, "$initDuration");
            kotlin.jvm.internal.k.e(error, "$error");
            C2606vb.f10443a.a(levelPlayInitListener, initDuration, error);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.vb$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2235ab f10449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2426l5 f10450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitListener f10452d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2235ab c2235ab, C2426l5 c2426l5, long j, LevelPlayInitListener levelPlayInitListener) {
            super(0);
            this.f10449a = c2235ab;
            this.f10450b = c2426l5;
            this.f10451c = j;
            this.f10452d = levelPlayInitListener;
        }

        public final void a() throws JSONException {
            C2606vb.f10443a.a(this.f10449a, this.f10450b, this.f10451c, this.f10452d);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() throws JSONException {
            a();
            return q5.x.f13520a;
        }
    }

    private C2606vb() {
    }

    private final void c(Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener) {
        IronLog ironLog = IronLog.API;
        String appKey = levelPlayInitRequest.getAppKey();
        String userId = levelPlayInitRequest.getUserId();
        List<LevelPlay.AdFormat> legacyAdFormats = levelPlayInitRequest.getLegacyAdFormats();
        String simpleName = context.getClass().getSimpleName();
        StringBuilder sbZ = a1.a.z("LevelPlay.init() appkey: ", appKey, ", userId: ", userId, ", legacyAdFormats: ");
        sbZ.append(legacyAdFormats);
        sbZ.append(", context: ");
        sbZ.append(simpleName);
        ironLog.info(sbZ.toString());
        C2426l5 c2426l5 = new C2426l5();
        C2623wb c2623wb = f10444b;
        LevelPlay.AdFormat[] adFormatArr = (LevelPlay.AdFormat[]) levelPlayInitRequest.getLegacyAdFormats().toArray(new LevelPlay.AdFormat[0]);
        Ae.f6342a.a(context, new C2575te(levelPlayInitRequest.getAppKey(), levelPlayInitRequest.getUserId(), r5.j.t0(c2623wb.a((LevelPlay.AdFormat[]) Arrays.copyOf(adFormatArr, adFormatArr.length)))), new a(levelPlayInitRequest, context, c2426l5, levelPlayInitListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener levelPlayInitListener) {
        kotlin.jvm.internal.k.e(context, "$context");
        kotlin.jvm.internal.k.e(initRequest, "$initRequest");
        f10443a.c(context, initRequest, levelPlayInitListener);
    }

    public final void b(LevelPlaySegment segment) {
        kotlin.jvm.internal.k.e(segment, "segment");
        com.ironsource.mediationsdk.r.m().a(a(segment));
    }

    public final void b(LevelPlayImpressionDataListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        com.ironsource.mediationsdk.r.m().b(new C2307eb(listener));
    }

    public static /* synthetic */ void a(C2606vb c2606vb, Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            levelPlayInitListener = null;
        }
        c2606vb.a(context, levelPlayInitRequest, levelPlayInitListener);
    }

    public final void a(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener levelPlayInitListener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initRequest, "initRequest");
        f10444b.d(new androidx.camera.core.processing.c(context, initRequest, levelPlayInitListener, 23));
    }

    public final void a(LevelPlayImpressionDataListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        com.ironsource.mediationsdk.r.m().a(new C2307eb(listener));
    }

    private final C2270ca a(LevelPlaySegment levelPlaySegment) {
        C2270ca c2270ca = new C2270ca();
        c2270ca.a(levelPlaySegment.getLevel());
        c2270ca.a(levelPlaySegment.getIapTotal());
        c2270ca.a(levelPlaySegment.isPaying());
        c2270ca.a(levelPlaySegment.getUserCreationDate());
        c2270ca.a(levelPlaySegment.getSegmentName());
        ArrayList<q5.i> customs$mediationsdk_release = levelPlaySegment.getCustoms$mediationsdk_release();
        int size = customs$mediationsdk_release.size();
        int i2 = 0;
        while (i2 < size) {
            q5.i iVar = customs$mediationsdk_release.get(i2);
            i2++;
            q5.i iVar2 = iVar;
            c2270ca.a((String) iVar2.f13498a, (String) iVar2.f13499b);
        }
        return c2270ca;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LevelPlayInitRequest levelPlayInitRequest, C2435le c2435le, Context context, C2426l5 c2426l5, LevelPlayInitListener levelPlayInitListener) {
        Mb.b bVar = Mb.f7131s;
        L8.a aVarD = bVar.a().D();
        C2235ab c2235ab = new C2235ab(c2435le);
        if (c2235ab.k()) {
            f10444b.a(context);
        }
        N7.a aVarA = bVar.a().a();
        C2623wb c2623wb = f10444b;
        c2235ab.b(c2623wb).a(aVarA);
        c2235ab.a(c2623wb).a(bVar.a().l());
        c2235ab.c(c2623wb).a(bVar.a().v());
        C2606vb c2606vb = f10443a;
        c2606vb.a(levelPlayInitRequest, c2235ab);
        long jE = bVar.d().g().e();
        c2606vb.a(jE, new b(c2235ab, c2426l5, jE, levelPlayInitListener));
        aVarD.a(c2235ab);
        if (c2435le.a().e()) {
            new Fd(null, null, null, IronSourceThreadManager.INSTANCE.getThreadPoolExecutor(), 7, null).c(context);
        }
    }

    private final void a(long j, e6.a aVar) {
        if (!Mb.f7131s.d().e().c() && j > 0) {
            f10444b.a(aVar, j);
        } else {
            aVar.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C2235ab c2235ab, C2426l5 c2426l5, long j, LevelPlayInitListener levelPlayInitListener) throws JSONException {
        Mb.f7131s.a().D().d();
        long jA = C2426l5.a(c2426l5);
        C2623wb c2623wb = f10444b;
        c2623wb.a(jA, c2235ab.f(), j);
        c2623wb.e(new ti(25, levelPlayInitListener, c2235ab));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, C2235ab levelPlayConfig) {
        kotlin.jvm.internal.k.e(levelPlayConfig, "$levelPlayConfig");
        IronLog.CALLBACK.info("LevelPlayInitListener.onInitSuccess()");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitSuccess(new LevelPlayConfiguration(levelPlayConfig.j()));
        }
    }

    private final void a(LevelPlayInitRequest levelPlayInitRequest, C2235ab c2235ab) {
        LevelPlay.AdFormat adFormat = LevelPlay.AdFormat.REWARDED;
        if (a(levelPlayInitRequest, adFormat) && c2235ab.d().c().f() != null) {
            Td.a aVar = Td.f7636z;
            IronSource.a aVar2 = IronSource.a.REWARDED_VIDEO;
            Td tdA = aVar.a(new C2314f0(aVar2, C2670z7.f10631a.a(), "", null, null, null, 56, null), c2235ab, true);
            List<C2675zc> listC = c2235ab.c(adFormat);
            D0.b bVar = D0.b.MEDIATION;
            new C2659yd(new V0(new C2459n0(aVar2, bVar), tdA, bVar), adFormat, listC, tdA).a();
        }
        LevelPlay.AdFormat adFormat2 = LevelPlay.AdFormat.INTERSTITIAL;
        if (a(levelPlayInitRequest, adFormat2) && c2235ab.d().c().d() != null) {
            D9.a aVar3 = D9.f6605z;
            IronSource.a aVar4 = IronSource.a.INTERSTITIAL;
            D9 d9A = aVar3.a(new C2314f0(aVar4, C2670z7.f10631a.a(), "", null, null, null, 56, null), c2235ab, true);
            List<C2675zc> listC2 = c2235ab.c(adFormat2);
            D0.b bVar2 = D0.b.MEDIATION;
            new C2659yd(new V0(new C2459n0(aVar4, bVar2), d9A, bVar2), adFormat2, listC2, d9A).a();
        }
        LevelPlay.AdFormat adFormat3 = LevelPlay.AdFormat.BANNER;
        if (!a(levelPlayInitRequest, adFormat3) || c2235ab.d().c().c() == null) {
            return;
        }
        N2 n2A = N2.f7262z.a(new K2(), c2235ab, true);
        List<C2675zc> listC3 = c2235ab.c(adFormat3);
        IronSource.a aVar5 = IronSource.a.BANNER;
        D0.b bVar3 = D0.b.MEDIATION;
        new C2659yd(new V0(new C2459n0(aVar5, bVar3), n2A, bVar3), adFormat3, listC3, n2A).a();
    }

    private final boolean a(LevelPlayInitRequest levelPlayInitRequest, LevelPlay.AdFormat adFormat) {
        return !levelPlayInitRequest.getLegacyAdFormats().contains(adFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LevelPlayInitListener levelPlayInitListener, C2426l5 c2426l5, C2473ne c2473ne) throws JSONException {
        long jA = C2426l5.a(c2426l5);
        C2623wb c2623wb = f10444b;
        c2623wb.a(c2473ne, jA);
        c2623wb.e(new ti(24, c2473ne, levelPlayInitListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2473ne error, LevelPlayInitListener levelPlayInitListener) {
        kotlin.jvm.internal.k.e(error, "$error");
        IronLog.CALLBACK.info("LevelPlayInitListener.LevelPlayInitError() error: " + error);
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitFailed(new LevelPlayInitError(error));
        }
    }

    public final void a(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add(value);
        com.ironsource.mediationsdk.r.m().a(key, arrayList);
    }
}
