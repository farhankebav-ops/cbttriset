package com.ironsource;

import android.content.Context;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.InterfaceC2568t7;
import com.ironsource.environment.ContextProvider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class M3 implements InterfaceC2568t7, InterfaceC2568t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Zc f7112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2474nf f7113b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7114a;

        static {
            int[] iArr = new int[Q3.values().length];
            try {
                iArr[Q3.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Q3.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Q3.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f7114a = iArr;
        }
    }

    public M3() {
        this(null, null, null, 7, null);
    }

    @Override // com.ironsource.InterfaceC2568t7
    public synchronized O3 a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        O3 o3A = this.f7112a.a(identifier);
        if (o3A.d()) {
            return o3A;
        }
        return this.f7113b.a(identifier);
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public synchronized void b(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        this.f7112a.b(identifier);
        this.f7113b.b(identifier);
    }

    public M3(InterfaceC2565t4 currentTimeProvider, M7 pacingDataRepository, T8 showCountDataRepository) {
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(pacingDataRepository, "pacingDataRepository");
        kotlin.jvm.internal.k.e(showCountDataRepository, "showCountDataRepository");
        this.f7112a = new Zc(currentTimeProvider, pacingDataRepository);
        this.f7113b = new C2474nf(currentTimeProvider, showCountDataRepository);
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public synchronized Object a(String identifier, Q3 cappingType, InterfaceC2534r7 cappingConfig) {
        Object objA;
        try {
            kotlin.jvm.internal.k.e(identifier, "identifier");
            kotlin.jvm.internal.k.e(cappingType, "cappingType");
            kotlin.jvm.internal.k.e(cappingConfig, "cappingConfig");
            int i2 = a.f7114a[cappingType.ordinal()];
            if (i2 == 1) {
                objA = this.f7112a.a(identifier, cappingType, cappingConfig);
            } else if (i2 == 2) {
                objA = this.f7113b.a(identifier, cappingType, cappingConfig);
            } else if (i2 == 3) {
                objA = q5.x.f13520a;
            } else {
                throw new e2.s(3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return objA;
    }

    public /* synthetic */ M3(InterfaceC2565t4 interfaceC2565t4, M7 m72, T8 t8, int i2, kotlin.jvm.internal.f fVar) {
        interfaceC2565t4 = (i2 & 1) != 0 ? new InterfaceC2565t4.a() : interfaceC2565t4;
        if ((i2 & 2) != 0) {
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            kotlin.jvm.internal.k.d(applicationContext, "getInstance().applicationContext");
            m72 = new C2237ad(new Cif(applicationContext, "pacing_service", null, 4, null));
        }
        if ((i2 & 4) != 0) {
            Context applicationContext2 = ContextProvider.getInstance().getApplicationContext();
            kotlin.jvm.internal.k.d(applicationContext2, "getInstance().applicationContext");
            t8 = new C2436lf(new Cif(applicationContext2, "capping_service", null, 4, null));
        }
        this(interfaceC2565t4, m72, t8);
    }
}
