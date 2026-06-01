package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f6151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f6152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f6153c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f6154d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f6151a = linkedBlockingQueue;
        this.f6152b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f6153c.poll();
        this.f6154d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f6152b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f6153c.add(bVar);
        if (this.f6154d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.a
    public void a(b bVar) {
        this.f6154d = null;
        a();
    }
}
