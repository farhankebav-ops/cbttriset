package com.ironsource;

import android.content.Context;
import android.os.Handler;
import android.view.Choreographer;
import com.ironsource.C2486o9;
import com.ironsource.Me;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.wb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2623wb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2520q9 f10486a = new C2520q9(null, 1, 0 == true ? 1 : 0);

    /* JADX INFO: renamed from: com.ironsource.wb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f10487b;

        public a(Runnable runnable) {
            this.f10487b = runnable;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f10487b.run();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.wb$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e6.a f10488b;

        public b(e6.a aVar) {
            this.f10488b = aVar;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            this.f10488b.invoke();
        }
    }

    public final void a(AbstractRunnableC2382ie safeRunnable) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final void b(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        a(this, new xi(this, runnable, 0), 0L, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2623wb this$0, Runnable runnable) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(runnable, "$runnable");
        this$0.f10486a.b(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final C2623wb this$0, final Runnable runnable) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(runnable, "$runnable");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.ironsource.yi
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                C2623wb.a(this.f10589a, runnable, j);
            }
        });
    }

    public final void c(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        a(this, new xi(this, runnable, 1), 0L, 2, (Object) null);
    }

    public final void d(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        this.f10486a.b(runnable);
    }

    public final void e(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C2623wb this$0, Runnable runnable, long j) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(runnable, "$runnable");
        this$0.b(runnable);
    }

    public final void b(AbstractRunnableC2382ie safeRunnable) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        this.f10486a.a(safeRunnable);
    }

    public static /* synthetic */ void a(C2623wb c2623wb, Runnable runnable, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOnUIThread");
        }
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2623wb.a(runnable, j);
    }

    public final void b(String adUnitId, int i2, String str) throws JSONException {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
        jSONObject.putOpt("reason", str);
        jSONObject.put("mediationAdUnitId", adUnitId);
        jSONObject.put("isMultipleAdUnits", 1);
        C2627wf.a(D5.TROUBLESHOOTING_AD_UNIT_REWARD_PARSE_ERROR, jSONObject);
    }

    public final void a(Runnable runnable, long j) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(runnable), j);
    }

    public final void a(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        this.f10486a.a(callback);
    }

    public final void a(AbstractRunnableC2382ie safeRunnable, long j) {
        kotlin.jvm.internal.k.e(safeRunnable, "safeRunnable");
        this.f10486a.a(safeRunnable, j);
    }

    public static /* synthetic */ void a(C2623wb c2623wb, AbstractRunnableC2382ie abstractRunnableC2382ie, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2623wb.a(abstractRunnableC2382ie, j);
    }

    public static /* synthetic */ void a(C2623wb c2623wb, e6.a aVar, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2623wb.a(aVar, j);
    }

    public final void a(e6.a action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        a((AbstractRunnableC2382ie) new b(action), j);
    }

    public final Handler a() {
        return this.f10486a.a();
    }

    public final void a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        C2486o9.a aVar = C2486o9.f9556a;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.k.d(applicationContext, "context.applicationContext");
        aVar.a(applicationContext);
    }

    public final IronSource.a[] a(LevelPlay.AdFormat... adFormats) {
        kotlin.jvm.internal.k.e(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        for (LevelPlay.AdFormat adFormat : adFormats) {
            arrayList.add(a(adFormat));
        }
        return (IronSource.a[]) arrayList.toArray(new IronSource.a[0]);
    }

    public final IronSource.a a(LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        return com.unity3d.mediation.a.a(adFormat);
    }

    public final boolean a(AdapterBaseInterface networkAdapter, IronSource.a adFormat, String providerName) {
        kotlin.jvm.internal.k.e(networkAdapter, "networkAdapter");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(providerName, "providerName");
        return C2627wf.a(networkAdapter, adFormat, providerName);
    }

    public final void a(long j, Me.a responseOrigin, long j3) throws JSONException {
        kotlin.jvm.internal.k.e(responseOrigin, "responseOrigin");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j);
        String strB = responseOrigin.b();
        kotlin.jvm.internal.k.d(strB, "responseOrigin.value");
        jSONObject.put(IronSourceConstants.EVENTS_EXT1, a(strB, j3));
        C2627wf.a(D5.SDK_INIT_SUCCESS, jSONObject);
    }

    private final String a(String str, long j) {
        return "responseOrigin=" + str + ";delayTimeAfterInitProcess=" + j;
    }

    public final void a(C2473ne error, long j) throws JSONException {
        kotlin.jvm.internal.k.e(error, "error");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
        jSONObject.put("reason", error.d());
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j);
        C2627wf.a(D5.SDK_INIT_FAILED, jSONObject);
    }

    public final void a(String placementName, LevelPlay.AdFormat adFormat, int i2, String str) throws JSONException {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
        jSONObject.putOpt("reason", str);
        jSONObject.put("placement", placementName);
        jSONObject.put(C2253bb.f8068f, adFormat.getValue());
        jSONObject.put("adf", C2627wf.c(com.unity3d.mediation.a.a(adFormat)));
        jSONObject.put("isMultipleAdUnits", 1);
        C2627wf.a(D5.TROUBLESHOOTING_PLACEMENT_CAPPING_PARSE_ERROR, jSONObject);
    }

    public final void a(String adUnitId, int i2, String str) throws JSONException {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
        jSONObject.putOpt("reason", str);
        jSONObject.put("mediationAdUnitId", adUnitId);
        jSONObject.put("isMultipleAdUnits", 1);
        C2627wf.a(D5.TROUBLESHOOTING_AD_UNIT_CAPPING_PARSE_ERROR, jSONObject);
    }
}
