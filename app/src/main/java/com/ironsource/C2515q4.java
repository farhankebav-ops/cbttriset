package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.q4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2515q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f9692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f9694c;

    public C2515q4(Throwable throwable) {
        kotlin.jvm.internal.k.e(throwable, "throwable");
        this.f9692a = throwable;
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        kotlin.jvm.internal.k.d(stackTrace, "throwable.stackTrace");
        sb.append(throwable.toString());
        sb.append(System.lineSeparator());
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(";" + System.lineSeparator());
            String string = stackTraceElement.toString();
            kotlin.jvm.internal.k.d(string, "elem.toString()");
            String strE = C2531r4.d().e();
            kotlin.jvm.internal.k.d(strE, "getInstance().keyword");
            if (n6.m.q0(string, strE, false)) {
                z2 = true;
            }
        }
        Throwable cause = this.f9692a.getCause();
        if (cause != null) {
            sb.append("--CAUSE");
            sb.append(System.lineSeparator());
            sb.append(cause.toString());
            sb.append(System.lineSeparator());
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            kotlin.jvm.internal.k.d(stackTrace2, "cause.stackTrace");
            for (StackTraceElement stackTraceElement2 : stackTrace2) {
                sb.append(stackTraceElement2.toString());
                sb.append(";" + System.lineSeparator());
                String string2 = stackTraceElement2.toString();
                kotlin.jvm.internal.k.d(string2, "elem.toString()");
                String strE2 = C2531r4.d().e();
                kotlin.jvm.internal.k.d(strE2, "getInstance().keyword");
                if (n6.m.q0(string2, strE2, false)) {
                    z2 = true;
                }
            }
        }
        String string3 = sb.toString();
        kotlin.jvm.internal.k.d(string3, "builder.toString()");
        this.f9693b = string3;
        this.f9694c = z2;
    }

    public final Throwable a() {
        return this.f9692a;
    }

    public final String b() {
        return this.f9693b;
    }

    public final Throwable c() {
        return this.f9692a;
    }

    public final boolean d() {
        return this.f9694c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2515q4) && kotlin.jvm.internal.k.a(this.f9692a, ((C2515q4) obj).f9692a);
    }

    public int hashCode() {
        return this.f9692a.hashCode();
    }

    public String toString() {
        return "CrashReportWrapper(throwable=" + this.f9692a + ")";
    }

    public final C2515q4 a(Throwable throwable) {
        kotlin.jvm.internal.k.e(throwable, "throwable");
        return new C2515q4(throwable);
    }

    public static /* synthetic */ C2515q4 a(C2515q4 c2515q4, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = c2515q4.f9692a;
        }
        return c2515q4.a(th);
    }
}
