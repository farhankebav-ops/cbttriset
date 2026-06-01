package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.d1;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a1 extends d1 implements b1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f10714b;

    public a1(HandlerThread handlerThread, d1.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.f10714b = handlerThread;
    }

    public void a(d1.a aVar) {
        this.f10748a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.f10714b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
