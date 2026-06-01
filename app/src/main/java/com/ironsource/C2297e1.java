package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.e1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2297e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8265b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8266c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2403k0 f8267a;

    /* JADX INFO: renamed from: com.ironsource.e1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.e1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t3, T t7) {
            return n7.b.j(Integer.valueOf(((LevelPlayAdSize) t7).getWidth()), Integer.valueOf(((LevelPlayAdSize) t3).getWidth()));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.e1$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f8268a;

        public c(Comparator comparator) {
            this.f8268a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t3, T t7) {
            int iCompare = this.f8268a.compare(t3, t7);
            return iCompare != 0 ? iCompare : n7.b.j(Integer.valueOf(((LevelPlayAdSize) t7).getHeight()), Integer.valueOf(((LevelPlayAdSize) t3).getHeight()));
        }
    }

    public C2297e1(C2403k0 adSizeTools) {
        kotlin.jvm.internal.k.e(adSizeTools, "adSizeTools");
        this.f8267a = adSizeTools;
    }

    public final LevelPlayAdSize a(Context context, Integer num) {
        kotlin.jvm.internal.k.e(context, "context");
        if (!this.f8267a.d()) {
            IronLog.API.error(C2403k0.a(this.f8267a, "The SDK must be successfully initialized to create an Adaptive Ad Size", (String) null, 2, (Object) null));
            return null;
        }
        Integer numB = this.f8267a.b(context);
        if (numB == null) {
            IronLog.API.error(C2403k0.a(this.f8267a, "Error getting max current orientation banner height", (String) null, 2, (Object) null));
            return null;
        }
        int iIntValue = numB.intValue();
        int iA = a(num, context);
        int iA2 = this.f8267a.a(iA);
        List<LevelPlayAdSize> listA = a();
        for (LevelPlayAdSize levelPlayAdSizeCreateCustomSize : a(listA, iIntValue, iA)) {
            if (levelPlayAdSizeCreateCustomSize.getWidth() <= iA && (levelPlayAdSizeCreateCustomSize.getHeight() <= iA2 || iA2 == -1)) {
                iA2 = Math.max(iA2, levelPlayAdSizeCreateCustomSize.getHeight());
                break;
            }
        }
        levelPlayAdSizeCreateCustomSize = null;
        if (levelPlayAdSizeCreateCustomSize == null) {
            iA2 = ((LevelPlayAdSize) r5.l.d1(listA)).getHeight();
            levelPlayAdSizeCreateCustomSize = LevelPlayAdSize.Companion.createCustomSize(iA, iA2);
        }
        int i2 = iA2;
        LevelPlayAdSize levelPlayAdSize = levelPlayAdSizeCreateCustomSize;
        IronLog ironLog = IronLog.INTERNAL;
        C2403k0 c2403k0 = this.f8267a;
        StringBuilder sbW = a1.a.w(iA, "Adaptive: ", "x", i2, " Fallback: ");
        sbW.append(levelPlayAdSize);
        ironLog.info(C2403k0.a(c2403k0, sbW.toString(), (String) null, 2, (Object) null));
        return new LevelPlayAdSize(iA, i2, "CUSTOM", true, levelPlayAdSize);
    }

    private final int a(Integer num, Context context) {
        if (num != null && num.intValue() < 0) {
            IronLog.API.info(C2403k0.a(this.f8267a, "Width is invalid, screen width will be used", (String) null, 2, (Object) null));
            return C2301e5.f8427a.b(context);
        }
        if (num == null) {
            return C2301e5.f8427a.b(context);
        }
        return num.intValue();
    }

    private final List<LevelPlayAdSize> a() {
        return r5.l.j1(this.f8267a.b(), new c(new b()));
    }

    private final List<LevelPlayAdSize> a(List<LevelPlayAdSize> list, int i2, int i8) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            LevelPlayAdSize levelPlayAdSize = (LevelPlayAdSize) obj;
            if (levelPlayAdSize.getHeight() <= i2 && levelPlayAdSize.getWidth() <= i8) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
