package com.iab.omid.library.ironsrc.walking.async;

import com.iab.omid.library.ironsrc.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f6049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f6050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f6051c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f6052d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f6049a = linkedBlockingQueue;
        this.f6050b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f6051c.poll();
        this.f6052d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f6050b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f6051c.add(bVar);
        if (this.f6052d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.ironsrc.walking.async.b.a
    public void a(b bVar) {
        this.f6052d = null;
        a();
    }
}
