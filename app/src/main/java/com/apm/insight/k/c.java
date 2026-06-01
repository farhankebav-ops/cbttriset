package com.apm.insight.k;

import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f4474a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4475a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f4475a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4475a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4475a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f4476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f4477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CrashType f4478c;

        public a(JSONObject jSONObject, CrashType crashType) {
            this.f4478c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f4476a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f4476a = jSONObject;
            }
            this.f4477b = jSONObject.optJSONObject("header");
        }

        @Nullable
        public final String a() {
            return this.f4476a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f4476a.optInt("app_start_time", -1);
        }

        @Nullable
        public final String c() {
            int i2 = AnonymousClass1.f4475a[this.f4478c.ordinal()];
            if (i2 == 1) {
                return this.f4476a.optString("data", null);
            }
            if (i2 == 2) {
                return this.f4476a.optString("stack", null);
            }
            if (i2 != 3) {
                return null;
            }
            return this.f4476a.optString("data", null);
        }
    }

    public static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f4474a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f4474a.isEmpty()) {
            f4474a.poll();
        }
        f4474a = null;
    }
}
