package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f6260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f6261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f6262c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f6263d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f6260a = linkedBlockingQueue;
        this.f6261b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f6262c.poll();
        this.f6263d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f6261b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f6262c.add(bVar);
        if (this.f6263d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.a
    public void a(b bVar) {
        this.f6263d = null;
        a();
    }
}
