package com.pgl.ssdk;

import com.pgl.ssdk.b1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class c1<T extends b1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BlockingQueue<T> f10719b = new LinkedBlockingQueue();

    private c1(int i2) {
        this.f10718a = i2;
    }

    public static c1 a(int i2) {
        return new c1(i2);
    }

    public T a() {
        return this.f10719b.poll();
    }
}
