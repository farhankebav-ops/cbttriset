package com.ironsource.sdk.controller;

import android.content.Context;
import android.content.Intent;
import com.ironsource.InterfaceC2331g;
import com.ironsource.InterfaceC2349h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface k {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2331g {
        @Override // com.ironsource.InterfaceC2331g
        public Intent a() {
            return new Intent("android.intent.action.VIEW");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2349h {
        @Override // com.ironsource.InterfaceC2349h
        public Intent a(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            return new Intent(context, (Class<?>) OpenUrlActivity.class);
        }
    }
}
