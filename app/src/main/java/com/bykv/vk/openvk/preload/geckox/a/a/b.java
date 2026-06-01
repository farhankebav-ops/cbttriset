package com.bykv.vk.openvk.preload.geckox.a.a;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4925a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f4927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected File f4928d;
    protected List<String> e;

    static {
        new f();
        f4926b = new e();
    }

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f4927c = aVar;
        this.f4928d = file;
        this.e = list;
    }
}
