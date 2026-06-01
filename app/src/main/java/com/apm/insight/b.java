package com.apm.insight;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2605va;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ICrashCallback, IOOMCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOOMCallback f4256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICrashCallback f4257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4258c;

    public b(String str, ICrashCallback iCrashCallback) {
        this.f4258c = str;
        this.f4257b = iCrashCallback;
    }

    public final void a(@NonNull CrashType crashType, @Nullable Throwable th, @Nullable Thread thread, long j, JSONArray jSONArray) {
        CrashType crashType2;
        Throwable th2;
        Thread thread2;
        long j3;
        if (this.f4256a == null || jSONArray == null) {
            return;
        }
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i2), "header", C2605va.f10440b), this.f4258c)) {
                crashType2 = crashType;
                th2 = th;
                thread2 = thread;
                j3 = j;
                this.f4256a.onCrash(crashType2, th2, thread2, j3);
            } else {
                crashType2 = crashType;
                th2 = th;
                thread2 = thread;
                j3 = j;
            }
            i2++;
            crashType = crashType2;
            th = th2;
            thread = thread2;
            j = j3;
        }
    }

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
    }

    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable Throwable th, @Nullable Thread thread, long j) {
    }

    public b(String str, IOOMCallback iOOMCallback) {
        this.f4258c = str;
        this.f4256a = iOOMCallback;
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread, JSONArray jSONArray) {
        if (this.f4257b == null || jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i2), "header", C2605va.f10440b), this.f4258c)) {
                this.f4257b.onCrash(crashType, str, thread);
            }
        }
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable String str2, String str3) {
        d dVarA;
        if (this.f4257b == null || (dVarA = d.a(this.f4258c)) == null || !dVarA.a(str3, str2)) {
            return;
        }
        this.f4257b.onCrash(crashType, str, null);
    }
}
