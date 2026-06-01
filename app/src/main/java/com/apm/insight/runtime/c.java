package com.apm.insight.runtime;

import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ICrashCallback> f4619a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ICrashCallback> f4620b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ICrashCallback> f4621c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ICrashCallback> f4622d = new CopyOnWriteArrayList();
    private final List<IOOMCallback> e = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.apm.insight.runtime.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4623a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f4623a = iArr;
            try {
                iArr[CrashType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4623a[CrashType.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4623a[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4623a[CrashType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4623a[CrashType.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public final void a(ICrashCallback iCrashCallback, CrashType crashType) {
        int i2 = AnonymousClass1.f4623a[crashType.ordinal()];
        if (i2 == 1) {
            this.f4619a.add(iCrashCallback);
            this.f4620b.add(iCrashCallback);
            this.f4621c.add(iCrashCallback);
            this.f4622d.add(iCrashCallback);
            return;
        }
        if (i2 == 2) {
            this.f4622d.add(iCrashCallback);
            return;
        }
        if (i2 == 3) {
            this.f4620b.add(iCrashCallback);
        } else if (i2 == 4) {
            this.f4619a.add(iCrashCallback);
        } else {
            if (i2 != 5) {
                return;
            }
            this.f4621c.add(iCrashCallback);
        }
    }

    public final void b(ICrashCallback iCrashCallback, CrashType crashType) {
        int i2 = AnonymousClass1.f4623a[crashType.ordinal()];
        if (i2 == 1) {
            this.f4619a.remove(iCrashCallback);
            this.f4620b.remove(iCrashCallback);
            this.f4621c.remove(iCrashCallback);
            this.f4622d.remove(iCrashCallback);
            return;
        }
        if (i2 == 2) {
            this.f4622d.remove(iCrashCallback);
            return;
        }
        if (i2 == 3) {
            this.f4620b.remove(iCrashCallback);
        } else if (i2 == 4) {
            this.f4619a.remove(iCrashCallback);
        } else {
            if (i2 != 5) {
                return;
            }
            this.f4621c.remove(iCrashCallback);
        }
    }

    @NonNull
    public final List<ICrashCallback> c() {
        return this.f4620b;
    }

    @NonNull
    public final List<ICrashCallback> d() {
        return this.f4621c;
    }

    @NonNull
    public final List<ICrashCallback> e() {
        return this.f4622d;
    }

    public final void a(IOOMCallback iOOMCallback) {
        this.e.add(iOOMCallback);
    }

    public final void b(IOOMCallback iOOMCallback) {
        this.e.remove(iOOMCallback);
    }

    @NonNull
    public final List<IOOMCallback> a() {
        return this.e;
    }

    @NonNull
    public final List<ICrashCallback> b() {
        return this.f4619a;
    }
}
