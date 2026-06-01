package com.iab.omid.library.bigosg.walking.a;

import com.iab.omid.library.bigosg.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f5836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f5837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f5838c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f5839d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f5836a = linkedBlockingQueue;
        this.f5837b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f5838c.poll();
        this.f5839d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f5837b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f5838c.add(bVar);
        if (this.f5839d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.bigosg.walking.a.b.a
    public void a(b bVar) {
        this.f5839d = null;
        a();
    }
}
