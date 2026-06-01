package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ej implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC2662z f8473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f8475d;

    public /* synthetic */ ej(AbstractC2662z abstractC2662z, int i2, String str, int i8) {
        this.f8472a = i8;
        this.f8473b = abstractC2662z;
        this.f8474c = i2;
        this.f8475d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8472a) {
            case 0:
                AbstractC2662z.b(this.f8473b, this.f8474c, this.f8475d);
                break;
            default:
                AbstractC2662z.a(this.f8473b, this.f8474c, this.f8475d);
                break;
        }
    }
}
