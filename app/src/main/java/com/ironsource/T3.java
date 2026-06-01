package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class T3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7614a = a.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f7615b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7616c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        NOT_READY,
        READY
    }

    public T3(String str) {
        this.f7616c = str;
    }

    public synchronized void a(Runnable runnable) {
        if (this.f7614a != a.READY) {
            this.f7615b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public synchronized void b() {
        this.f7614a = a.NOT_READY;
    }

    public synchronized void c() {
        this.f7614a = a.READY;
    }

    public synchronized void a() {
        try {
            Object[] array = this.f7615b.toArray();
            for (int i2 = 0; i2 < array.length; i2++) {
                ((Runnable) array[i2]).run();
                array[i2] = null;
            }
            this.f7615b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
