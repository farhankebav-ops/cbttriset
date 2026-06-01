package com.ironsource;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class O5 {
    private static final String e = "EventsTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2518q7 f7314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private I5 f7315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private J7 f7316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f7317d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7318a;

        public a(String str) {
            this.f7318a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Gd gd = new Gd();
                ArrayList<Pair<String, String>> arrayListD = O5.this.f7315b.d();
                if ("POST".equals(O5.this.f7315b.e())) {
                    gd = C2340g8.b(O5.this.f7315b.b(), this.f7318a, arrayListD);
                } else if ("GET".equals(O5.this.f7315b.e())) {
                    gd = C2340g8.a(O5.this.f7315b.b(), this.f7318a, arrayListD);
                }
                O5.this.a("response status code: " + gd.f6881a);
            } catch (Exception e) {
                C2531r4.d().a(e);
            }
        }
    }

    public O5(I5 i52, InterfaceC2518q7 interfaceC2518q7) {
        if (i52 == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        }
        if (i52.c() == null) {
            throw new InvalidParameterException("Null formatter not supported ");
        }
        this.f7315b = i52;
        this.f7314a = interfaceC2518q7;
        this.f7316c = i52.c();
        this.f7317d = Executors.newSingleThreadExecutor();
    }

    private void b(String str) {
        this.f7317d.submit(new a(str));
    }

    public void a(String str, Map<String, Object> map) {
        Locale locale = Locale.ENGLISH;
        a(a1.a.D(str, " ", map.toString()));
        if (this.f7315b.a() && !str.isEmpty()) {
            HashMap mapU = androidx.camera.core.processing.util.a.u("eventname", str);
            a(mapU, this.f7314a.a());
            a(mapU, map);
            b(this.f7316c.a(mapU));
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f7315b.f()) {
            Log.d(e, str);
        }
    }
}
