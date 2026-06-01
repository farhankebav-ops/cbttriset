package com.ironsource;

import com.ironsource.N7;
import com.unity3d.mediation.LevelPlay;

/* JADX INFO: renamed from: com.ironsource.nd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2472nd implements N7, N7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final M3 f9511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S4 f9512b;

    /* JADX INFO: renamed from: com.ironsource.nd$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9513a;

        static {
            int[] iArr = new int[Q3.values().length];
            try {
                iArr[Q3.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Q3.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Q3.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9513a = iArr;
        }
    }

    public C2472nd() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.N7
    public synchronized O3 a(String placementName, LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        String strA = new C2557sd(placementName, adFormat).a();
        O3 o3A = this.f9512b.a(strA);
        if (o3A.d()) {
            return o3A;
        }
        return this.f9511a.a(strA);
    }

    @Override // com.ironsource.N7.a
    public synchronized void b(String placementName, LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        String strA = new C2557sd(placementName, adFormat).a();
        if (!this.f9512b.a(strA).d()) {
            this.f9511a.b(strA);
        }
    }

    public C2472nd(M3 cappingService, S4 deliveryHandler) {
        kotlin.jvm.internal.k.e(cappingService, "cappingService");
        kotlin.jvm.internal.k.e(deliveryHandler, "deliveryHandler");
        this.f9511a = cappingService;
        this.f9512b = deliveryHandler;
    }

    public /* synthetic */ C2472nd(M3 m3, S4 s42, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new M3(null, null, null, 7, null) : m3, (i2 & 2) != 0 ? new S4() : s42);
    }

    @Override // com.ironsource.N7.a
    public synchronized Object a(String placementName, LevelPlay.AdFormat adFormat, Q3 cappingType, InterfaceC2534r7 cappingConfig) {
        Object objA;
        try {
            kotlin.jvm.internal.k.e(placementName, "placementName");
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            kotlin.jvm.internal.k.e(cappingType, "cappingType");
            kotlin.jvm.internal.k.e(cappingConfig, "cappingConfig");
            String strA = new C2557sd(placementName, adFormat).a();
            int i2 = a.f9513a[cappingType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3) {
                    throw new e2.s(3);
                }
                objA = this.f9511a.a(strA, cappingType, cappingConfig);
            } else {
                objA = this.f9512b.a(strA, cappingType, cappingConfig);
            }
        } catch (Throwable th) {
            throw th;
        }
        return objA;
    }
}
