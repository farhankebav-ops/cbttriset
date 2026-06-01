package com.ironsource;

import java.util.Arrays;

/* JADX INFO: renamed from: com.ironsource.jd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2398jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8801d;
    private int[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f8802f;

    public C2398jd() {
        this(false, null, false, 0, null, null, 63, null);
    }

    public final boolean a() {
        return this.f8798a;
    }

    public final String b() {
        return this.f8799b;
    }

    public final boolean c() {
        return this.f8800c;
    }

    public final int d() {
        return this.f8801d;
    }

    public final int[] e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2398jd)) {
            return false;
        }
        C2398jd c2398jd = (C2398jd) obj;
        return this.f8798a == c2398jd.f8798a && kotlin.jvm.internal.k.a(this.f8799b, c2398jd.f8799b) && this.f8800c == c2398jd.f8800c && this.f8801d == c2398jd.f8801d && kotlin.jvm.internal.k.a(this.e, c2398jd.e) && kotlin.jvm.internal.k.a(this.f8802f, c2398jd.f8802f);
    }

    public final int[] f() {
        return this.f8802f;
    }

    public final boolean g() {
        return this.f8800c;
    }

    public final int h() {
        return this.f8801d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        boolean z2 = this.f8798a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int iB = androidx.camera.core.processing.util.a.b(r02 * 31, 31, this.f8799b);
        boolean z7 = this.f8800c;
        int i2 = (((iB + (z7 ? 1 : z7)) * 31) + this.f8801d) * 31;
        int[] iArr = this.e;
        int iHashCode = (i2 + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31;
        int[] iArr2 = this.f8802f;
        return iHashCode + (iArr2 != null ? Arrays.hashCode(iArr2) : 0);
    }

    public final boolean i() {
        return this.f8798a;
    }

    public final String j() {
        return this.f8799b;
    }

    public final int[] k() {
        return this.f8802f;
    }

    public final int[] l() {
        return this.e;
    }

    public String toString() {
        boolean z2 = this.f8798a;
        String str = this.f8799b;
        boolean z7 = this.f8800c;
        int i2 = this.f8801d;
        String string = Arrays.toString(this.e);
        String string2 = Arrays.toString(this.f8802f);
        StringBuilder sb = new StringBuilder("PixelSettings(pixelEventsEnabled=");
        sb.append(z2);
        sb.append(", pixelEventsUrl=");
        sb.append(str);
        sb.append(", pixelEventsCompression=");
        sb.append(z7);
        sb.append(", pixelEventsCompressionLevel=");
        sb.append(i2);
        sb.append(", pixelOptOut=");
        return androidx.camera.core.processing.util.a.n(sb, string, ", pixelOptIn=", string2, ")");
    }

    public C2398jd(boolean z2, String pixelEventsUrl, boolean z7, int i2, int[] iArr, int[] iArr2) {
        kotlin.jvm.internal.k.e(pixelEventsUrl, "pixelEventsUrl");
        this.f8798a = z2;
        this.f8799b = pixelEventsUrl;
        this.f8800c = z7;
        this.f8801d = i2;
        this.e = iArr;
        this.f8802f = iArr2;
    }

    public final C2398jd a(boolean z2, String pixelEventsUrl, boolean z7, int i2, int[] iArr, int[] iArr2) {
        kotlin.jvm.internal.k.e(pixelEventsUrl, "pixelEventsUrl");
        return new C2398jd(z2, pixelEventsUrl, z7, i2, iArr, iArr2);
    }

    public final void b(boolean z2) {
        this.f8798a = z2;
    }

    public static /* synthetic */ C2398jd a(C2398jd c2398jd, boolean z2, String str, boolean z7, int i2, int[] iArr, int[] iArr2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z2 = c2398jd.f8798a;
        }
        if ((i8 & 2) != 0) {
            str = c2398jd.f8799b;
        }
        if ((i8 & 4) != 0) {
            z7 = c2398jd.f8800c;
        }
        if ((i8 & 8) != 0) {
            i2 = c2398jd.f8801d;
        }
        if ((i8 & 16) != 0) {
            iArr = c2398jd.e;
        }
        if ((i8 & 32) != 0) {
            iArr2 = c2398jd.f8802f;
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return c2398jd.a(z2, str, z7, i2, iArr3, iArr4);
    }

    public final void b(int[] iArr) {
        this.e = iArr;
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f8799b = str;
    }

    public final void a(boolean z2) {
        this.f8800c = z2;
    }

    public final void a(int i2) {
        this.f8801d = i2;
    }

    public final void a(int[] iArr) {
        this.f8802f = iArr;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ C2398jd(boolean r2, java.lang.String r3, boolean r4, int r5, int[] r6, int[] r7, int r8, kotlin.jvm.internal.f r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 1
        L5:
            r9 = r8 & 2
            if (r9 == 0) goto Lb
            java.lang.String r3 = "https://o-sdk.mediation.unity3d.com/mediation?adUnit=3"
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = 0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = -1
        L15:
            r9 = r8 & 16
            r0 = 0
            if (r9 == 0) goto L1b
            r6 = r0
        L1b:
            r8 = r8 & 32
            if (r8 == 0) goto L27
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L27:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2398jd.<init>(boolean, java.lang.String, boolean, int, int[], int[], int, kotlin.jvm.internal.f):void");
    }
}
