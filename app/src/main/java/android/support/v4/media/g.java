package android.support.v4.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.view.OnApplyWindowInsetsListener;
import com.cbt.exam.browser.activity.BaseActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.ironsource.adqualitysdk.sdk.i.a0;
import e6.l;
import e6.p;
import f7.b1;
import f7.m0;
import f7.q;
import f7.u0;
import i4.n1;
import i4.r1;
import j4.l1;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.o;
import kotlin.jvm.internal.k;
import l7.m;
import r5.n;
import s4.j;
import s4.r;
import t6.t0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements r, s4.b, j, OnApplyWindowInsetsListener, t6.e, t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3264c;

    public /* synthetic */ g(int i2, Object obj, Object obj2) {
        this.f3262a = i2;
        this.f3263b = obj;
        this.f3264c = obj2;
    }

    public static String s(l7.j jVar) {
        long j = jVar.f12868b;
        if (j <= 64) {
            return jVar.t().e();
        }
        return jVar.u((int) Math.min(j, 64L)).e() + "...";
    }

    @Override // s4.r
    public void a(u4.b bVar) {
        switch (this.f3262a) {
            case 1:
                y4.a.c((e5.i) this.f3263b, bVar);
                break;
            case 2:
                ((b5.b) this.f3264c).c(bVar);
                break;
            case 3:
            default:
                ((r) this.f3263b).a(bVar);
                break;
            case 4:
                y4.a.e((e5.r) this.f3264c, bVar);
                break;
            case 5:
                y4.a.e((e5.i) this.f3264c, bVar);
                break;
        }
    }

    public i4.b b() {
        if (((IdentityHashMap) this.f3264c) != null) {
            for (Map.Entry entry : ((i4.b) this.f3263b).f11822a.entrySet()) {
                if (!((IdentityHashMap) this.f3264c).containsKey(entry.getKey())) {
                    ((IdentityHashMap) this.f3264c).put((i4.a) entry.getKey(), entry.getValue());
                }
            }
            this.f3263b = new i4.b((IdentityHashMap) this.f3264c);
            this.f3264c = null;
        }
        return (i4.b) this.f3263b;
    }

    public void c() {
        ((r1) this.f3263b).f11947b = true;
        ((ScheduledFuture) this.f3264c).cancel(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Type inference failed for: r4v4, types: [e6.p, x5.i] */
    @Override // t6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(t6.f r6, v5.c r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.g.collect(t6.f, v5.c):java.lang.Object");
    }

    public b7.c f(l6.c cVar) {
        Object objPutIfAbsent;
        switch (this.f3262a) {
            case 6:
                Object obj = ((q) this.f3264c).get(a.a.B(cVar));
                k.d(obj, "get(...)");
                u0 u0Var = (u0) obj;
                Object kVar = u0Var.f11525a.get();
                if (kVar == null) {
                    synchronized (u0Var) {
                        kVar = u0Var.f11525a.get();
                        if (kVar == null) {
                            kVar = new f7.k((b7.c) ((l) this.f3263b).invoke(cVar));
                            u0Var.f11525a = new SoftReference(kVar);
                        }
                    }
                }
                return ((f7.k) kVar).f11474a;
            default:
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f3264c;
                Class clsB = a.a.B(cVar);
                Object kVar2 = concurrentHashMap.get(clsB);
                if (kVar2 == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsB, (kVar2 = new f7.k((b7.c) ((l) this.f3263b).invoke(cVar))))) != null) {
                    kVar2 = objPutIfAbsent;
                }
                return ((f7.k) kVar2).f11474a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.datatransport.cct.CctBackendFactory g(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.g.g(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public Object h(l6.c cVar, ArrayList arrayList) {
        Object objM;
        Object objM2;
        Object objPutIfAbsent;
        switch (this.f3262a) {
            case 7:
                Object obj = ((q) this.f3264c).get(a.a.B(cVar));
                k.d(obj, "get(...)");
                u0 u0Var = (u0) obj;
                Object b1Var = u0Var.f11525a.get();
                if (b1Var == null) {
                    synchronized (u0Var) {
                        b1Var = u0Var.f11525a.get();
                        if (b1Var == null) {
                            b1Var = new b1();
                            u0Var.f11525a = new SoftReference(b1Var);
                        }
                    }
                }
                b1 b1Var2 = (b1) b1Var;
                ArrayList arrayList2 = new ArrayList(n.L0(arrayList, 10));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    arrayList2.add(new m0((l6.r) obj2));
                }
                ConcurrentHashMap concurrentHashMap = b1Var2.f11422a;
                Object obj3 = concurrentHashMap.get(arrayList2);
                if (obj3 == null) {
                    try {
                        objM = (b7.c) ((p) this.f3263b).invoke(cVar, arrayList);
                    } catch (Throwable th) {
                        objM = r2.q.M(th);
                    }
                    q5.k kVar = new q5.k(objM);
                    Object objPutIfAbsent2 = concurrentHashMap.putIfAbsent(arrayList2, kVar);
                    obj3 = objPutIfAbsent2 == null ? kVar : objPutIfAbsent2;
                    break;
                }
                return ((q5.k) obj3).f13501a;
            default:
                ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) this.f3264c;
                Class clsB = a.a.B(cVar);
                Object b1Var3 = concurrentHashMap2.get(clsB);
                if (b1Var3 == null && (objPutIfAbsent = concurrentHashMap2.putIfAbsent(clsB, (b1Var3 = new b1()))) != null) {
                    b1Var3 = objPutIfAbsent;
                }
                b1 b1Var4 = (b1) b1Var3;
                ArrayList arrayList3 = new ArrayList(n.L0(arrayList, 10));
                int size2 = arrayList.size();
                int i8 = 0;
                while (i8 < size2) {
                    Object obj4 = arrayList.get(i8);
                    i8++;
                    arrayList3.add(new m0((l6.r) obj4));
                }
                ConcurrentHashMap concurrentHashMap3 = b1Var4.f11422a;
                Object obj5 = concurrentHashMap3.get(arrayList3);
                if (obj5 == null) {
                    try {
                        objM2 = (b7.c) ((p) this.f3263b).invoke(cVar, arrayList);
                    } catch (Throwable th2) {
                        objM2 = r2.q.M(th2);
                    }
                    q5.k kVar2 = new q5.k(objM2);
                    Object objPutIfAbsent3 = concurrentHashMap3.putIfAbsent(arrayList3, kVar2);
                    obj5 = objPutIfAbsent3 == null ? kVar2 : objPutIfAbsent3;
                    break;
                }
                return ((q5.k) obj5).f13501a;
        }
    }

    public void i(String str, String str2) {
        ArrayList arrayList = ((l1) this.f3264c).f12300b;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        int i2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt <= 31 || cCharAt >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i8), str));
            }
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        }
        int length2 = str2.length();
        for (int i9 = 0; i9 < length2; i9++) {
            char cCharAt2 = str2.charAt(i9);
            if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i9), str2));
            }
        }
        while (i2 < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i2))) {
                arrayList.remove(i2);
                arrayList.remove(i2);
                i2 -= 2;
            }
            i2 += 2;
        }
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    public boolean j() {
        return ((Logger) this.f3263b).isLoggable((Level) this.f3264c);
    }

    public void k(int i2, int i8, l7.j jVar, int i9, boolean z2) {
        if (j()) {
            ((Logger) this.f3263b).log((Level) this.f3264c, a0.r(i2) + " DATA: streamId=" + i8 + " endStream=" + z2 + " length=" + i9 + " bytes=" + s(jVar));
        }
    }

    public void l(int i2, int i8, m4.a aVar, m mVar) {
        if (j()) {
            Logger logger = (Logger) this.f3263b;
            Level level = (Level) this.f3264c;
            StringBuilder sb = new StringBuilder();
            sb.append(a0.r(i2));
            sb.append(" GO_AWAY: lastStreamId=");
            sb.append(i8);
            sb.append(" errorCode=");
            sb.append(aVar);
            sb.append(" length=");
            sb.append(mVar.d());
            sb.append(" bytes=");
            l7.j jVar = new l7.j();
            jVar.w(mVar);
            sb.append(s(jVar));
            logger.log(level, sb.toString());
        }
    }

    public void m(int i2, long j) {
        if (j()) {
            ((Logger) this.f3263b).log((Level) this.f3264c, a0.r(i2) + " PING: ack=false bytes=" + j);
        }
    }

    public void n(int i2, int i8, m4.a aVar) {
        if (j()) {
            ((Logger) this.f3263b).log((Level) this.f3264c, a0.r(i2) + " RST_STREAM: streamId=" + i8 + " errorCode=" + aVar);
        }
    }

    public void o(int i2, com.unity3d.scar.adapter.common.a aVar) {
        if (j()) {
            Logger logger = (Logger) this.f3263b;
            Level level = (Level) this.f3264c;
            StringBuilder sb = new StringBuilder();
            sb.append(a0.r(i2));
            sb.append(" SETTINGS: ack=false settings=");
            EnumMap enumMap = new EnumMap(o.class);
            for (o oVar : o.values()) {
                if (aVar.d(oVar.f12677a)) {
                    enumMap.put(oVar, Integer.valueOf(((int[]) aVar.f10959c)[oVar.f12677a]));
                }
            }
            sb.append(enumMap.toString());
            logger.log(level, sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r18, androidx.core.view.WindowInsetsCompat r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r3 = r0.f3263b
            g1.c r3 = (g1.c) r3
            java.lang.Object r4 = r0.f3264c
            q1.o r4 = (q1.o) r4
            int r5 = r4.f13427a
            int r6 = r4.f13428b
            int r4 = r4.f13429c
            int r7 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            androidx.core.graphics.Insets r7 = r2.getInsets(r7)
            int r8 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
            androidx.core.graphics.Insets r8 = r2.getInsets(r8)
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r3.f11562b
            int r10 = r7.top
            r9.f5289w = r10
            int r10 = r1.getLayoutDirection()
            r12 = 1
            if (r10 != r12) goto L33
            r10 = r12
            goto L34
        L33:
            r10 = 0
        L34:
            int r13 = r1.getPaddingBottom()
            int r14 = r1.getPaddingLeft()
            int r15 = r1.getPaddingRight()
            boolean r11 = r9.f5282o
            if (r11 == 0) goto L4b
            int r13 = r2.getSystemWindowInsetBottom()
            r9.f5288v = r13
            int r13 = r13 + r4
        L4b:
            boolean r4 = r9.p
            if (r4 == 0) goto L57
            if (r10 == 0) goto L53
            r4 = r6
            goto L54
        L53:
            r4 = r5
        L54:
            int r14 = r7.left
            int r14 = r14 + r4
        L57:
            boolean r4 = r9.f5283q
            if (r4 == 0) goto L63
            if (r10 == 0) goto L5e
            goto L5f
        L5e:
            r5 = r6
        L5f:
            int r4 = r7.right
            int r15 = r5 + r4
        L63:
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            boolean r5 = r9.f5285s
            if (r5 == 0) goto L78
            int r5 = r4.leftMargin
            int r6 = r7.left
            if (r5 == r6) goto L78
            r4.leftMargin = r6
            r16 = r12
            goto L7a
        L78:
            r16 = 0
        L7a:
            boolean r5 = r9.f5286t
            if (r5 == 0) goto L88
            int r5 = r4.rightMargin
            int r6 = r7.right
            if (r5 == r6) goto L88
            r4.rightMargin = r6
            r16 = r12
        L88:
            boolean r5 = r9.f5287u
            if (r5 == 0) goto L95
            int r5 = r4.topMargin
            int r6 = r7.top
            if (r5 == r6) goto L95
            r4.topMargin = r6
            goto L97
        L95:
            r12 = r16
        L97:
            if (r12 == 0) goto L9c
            r1.setLayoutParams(r4)
        L9c:
            int r4 = r1.getPaddingTop()
            r1.setPadding(r14, r4, r15, r13)
            boolean r1 = r3.f11561a
            if (r1 == 0) goto Lab
            int r3 = r8.bottom
            r9.m = r3
        Lab:
            if (r11 != 0) goto Lb1
            if (r1 == 0) goto Lb0
            goto Lb1
        Lb0:
            return r2
        Lb1:
            r9.r()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.g.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    @Override // s4.b, s4.j
    public void onComplete() {
        switch (this.f3262a) {
            case 2:
                ((s4.b) this.f3263b).onComplete();
                break;
            case 3:
            default:
                ((j) this.f3263b).onComplete();
                break;
            case 4:
                ((j) this.f3263b).onComplete();
                break;
        }
    }

    @Override // s4.r
    public void onError(Throwable th) {
        switch (this.f3262a) {
            case 1:
                ((r) this.f3264c).onError(th);
                break;
            case 2:
                s4.b bVar = (s4.b) this.f3263b;
                try {
                    s4.c cVarLambda$createFirebaseInAppMessageStream$5 = InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$5(th);
                    if (cVarLambda$createFirebaseInAppMessageStream$5 != null) {
                        ((s4.a) cVarLambda$createFirebaseInAppMessageStream$5).d(new a4.a(this, 7));
                    } else {
                        NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                        nullPointerException.initCause(th);
                        bVar.onError(nullPointerException);
                    }
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    bVar.onError(new v4.b(th2, th));
                    return;
                }
                break;
            case 3:
            default:
                ((r) this.f3263b).onError(th);
                break;
            case 4:
                ((j) this.f3263b).onError(th);
                break;
            case 5:
                ((j) this.f3263b).onError(th);
                break;
        }
    }

    @Override // s4.r
    public void onSuccess(Object obj) {
        switch (this.f3262a) {
            case 1:
                ((r) this.f3264c).onSuccess(obj);
                break;
            case 2:
            case 3:
            default:
                r rVar = (r) this.f3263b;
                try {
                    ((x4.b) ((g5.b) this.f3264c).f11593c).accept(obj);
                    rVar.onSuccess(obj);
                } catch (Throwable th) {
                    r2.q.y0(th);
                    rVar.onError(th);
                }
                break;
            case 4:
                ((j) this.f3263b).onSuccess(obj);
                break;
            case 5:
                ((j) this.f3263b).onSuccess(obj);
                break;
        }
    }

    public void p(int i2, int i8, long j) {
        if (j()) {
            ((Logger) this.f3263b).log((Level) this.f3264c, a0.r(i2) + " WINDOW_UPDATE: streamId=" + i8 + " windowSizeIncrement=" + j);
        }
    }

    public void q(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
        Message messageObtain = Message.obtain();
        messageObtain.what = i2;
        messageObtain.arg1 = 1;
        messageObtain.setData(bundle);
        messageObtain.replyTo = messenger;
        ((Messenger) this.f3263b).send(messageObtain);
    }

    public void r(i4.a aVar, Object obj) {
        if (((IdentityHashMap) this.f3264c) == null) {
            this.f3264c = new IdentityHashMap(1);
        }
        ((IdentityHashMap) this.f3264c).put(aVar, obj);
    }

    public String toString() {
        switch (this.f3262a) {
            case 17:
                return "Request{url=" + ((n4.a) this.f3263b) + '}';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ g(int i2, boolean z2) {
        this.f3262a = i2;
    }

    public g(BaseActivity baseActivity) {
        this.f3262a = 14;
        SharedPreferences sharedPreferences = baseActivity.getSharedPreferences("com.cbt.exam.browser", 0);
        this.f3263b = sharedPreferences;
        this.f3264c = sharedPreferences.edit();
    }

    public g(g gVar) {
        this.f3262a = 17;
        this.f3263b = (n4.a) gVar.f3263b;
        l1 l1Var = (l1) gVar.f3264c;
        l1Var.getClass();
        this.f3264c = new a4.a(l1Var);
    }

    public g(g5.b bVar, r rVar) {
        this.f3262a = 10;
        this.f3264c = bVar;
        this.f3263b = rVar;
    }

    public g(int i2, l lVar) {
        this.f3262a = i2;
        switch (i2) {
            case 8:
                this.f3263b = lVar;
                this.f3264c = new ConcurrentHashMap();
                break;
            default:
                this.f3263b = lVar;
                this.f3264c = new q();
                break;
        }
    }

    public g(n1 n1Var, Object obj) {
        this.f3262a = 12;
        r2.q.D(n1Var, "status");
        this.f3263b = n1Var;
        this.f3264c = obj;
    }

    public g(c5.d dVar, s4.b bVar, b5.b bVar2) {
        this.f3262a = 2;
        this.f3263b = bVar;
        this.f3264c = bVar2;
    }

    public g(Context context) {
        this.f3262a = 18;
        this.f3264c = null;
        this.f3263b = context;
    }

    public g(p pVar, int i2) {
        this.f3262a = i2;
        switch (i2) {
            case 9:
                this.f3263b = pVar;
                this.f3264c = new ConcurrentHashMap();
                break;
            default:
                this.f3263b = pVar;
                this.f3264c = new q();
                break;
        }
    }

    public g(s6.h hVar, s6.b bVar) {
        this.f3262a = 28;
        s6.d dVar = s6.d.f13726b;
        s6.e eVar = s6.e.f13727b;
        this.f3263b = hVar;
        this.f3264c = bVar;
    }

    public g(i4.b bVar) {
        this.f3262a = 11;
        this.f3263b = bVar;
    }

    public g(r1 r1Var, ScheduledFuture scheduledFuture) {
        this.f3262a = 13;
        this.f3263b = r1Var;
        r2.q.D(scheduledFuture, "future");
        this.f3264c = scheduledFuture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(t0 t0Var, p pVar) {
        this.f3262a = 25;
        this.f3263b = t0Var;
        this.f3264c = (x5.i) pVar;
    }

    public g(int i2) {
        this.f3262a = i2;
        switch (i2) {
            case 15:
                Level level = Level.FINE;
                Logger logger = Logger.getLogger(k4.n.class.getName());
                r2.q.D(level, FirebaseAnalytics.Param.LEVEL);
                this.f3264c = level;
                r2.q.D(logger, "logger");
                this.f3263b = logger;
                break;
            case 21:
                this.f3263b = new AtomicLong();
                this.f3264c = new AtomicLong();
                break;
            case 27:
                this.f3263b = new HashMap();
                this.f3264c = null;
                break;
            default:
                this.f3263b = new Rect();
                this.f3264c = new Rect();
                break;
        }
    }
}
