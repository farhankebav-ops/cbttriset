package com.ironsource;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.na, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2469na {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static C2469na f9507c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet<InterfaceC2233a9> f9508a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, List<String>> f9509b = new ConcurrentHashMap<>();

    public static synchronized C2469na b() {
        try {
            if (f9507c == null) {
                f9507c = new C2469na();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9507c;
    }

    public HashSet<InterfaceC2233a9> a() {
        return this.f9508a;
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.f9509b;
    }

    public void d() {
        synchronized (this) {
            this.f9508a.clear();
        }
    }

    public void a(InterfaceC2233a9 interfaceC2233a9) {
        synchronized (this) {
            this.f9508a.add(interfaceC2233a9);
        }
    }

    public void b(InterfaceC2233a9 interfaceC2233a9) {
        synchronized (this) {
            this.f9508a.remove(interfaceC2233a9);
        }
    }

    public void a(String str, List<String> list) {
        this.f9509b.put(str, list);
    }
}
