package com.pgl.ssdk;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f10798c;

    public n0(Context context, int i2, Object[] objArr) {
        this.f10796a = context;
        this.f10797b = i2;
        this.f10798c = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f10797b == 222) {
                j0.a(this.f10796a).a();
            }
            byte[] bArr = (byte[]) com.pgl.ssdk.ces.a.meta(this.f10797b, this.f10796a, this.f10798c);
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            new o0(this.f10796a, this.f10797b).a(1, 2, bArr);
        } catch (Throwable unused) {
        }
    }
}
