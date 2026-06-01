package com.cbt.exam.browser.activity;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f5182b;

    public /* synthetic */ m(SslErrorHandler sslErrorHandler, int i2) {
        this.f5181a = i2;
        this.f5182b = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        switch (this.f5181a) {
            case 0:
                this.f5182b.proceed();
                break;
            case 1:
                this.f5182b.cancel();
                break;
            case 2:
                this.f5182b.proceed();
                break;
            default:
                this.f5182b.cancel();
                break;
        }
    }
}
