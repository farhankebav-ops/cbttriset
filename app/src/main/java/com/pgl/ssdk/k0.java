package com.pgl.ssdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.Y1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k0 f10778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f10780c = new ArrayList();

    private k0(Context context) {
        this.f10779b = null;
        this.f10779b = context;
    }

    public static k0 a(Context context) {
        if (f10778a == null) {
            synchronized (k0.class) {
                try {
                    if (f10778a == null) {
                        f10778a = new k0(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10778a;
    }

    public int b() {
        Intent intentRegisterReceiver = this.f10779b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return 0;
        }
        return intentRegisterReceiver.getIntExtra("plugged", 0);
    }

    public int c() {
        if (this.f10779b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return 0;
        }
        return Math.round(((r0.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) / r0.getIntExtra("scale", 0)) * 100.0f) * 10.0f) / 10;
    }

    public synchronized String d() {
        if (this.f10780c.size() <= 0) {
            return Y1.f7808f;
        }
        return String.valueOf(this.f10780c.get(r0.size() - 1).intValue() % 10000);
    }

    public synchronized String e() {
        return new JSONArray((Collection) this.f10780c).toString();
    }

    public int f() {
        int iC;
        int iB = 0;
        try {
            synchronized (this) {
                iB = b();
                iC = c();
            }
            return (iB * 10000) + iC;
        } catch (Exception unused) {
            return iB * 10000;
        }
    }

    public void a() {
        int iF = f();
        if (iF == -1) {
            return;
        }
        this.f10780c.add(Integer.valueOf(iF));
        try {
            int size = this.f10780c.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f10780c.subList(size - 10, size));
                this.f10780c.clear();
                this.f10780c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }
}
