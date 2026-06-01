package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class jf {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static jf f2774;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    boolean f2775 = false;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Set<jg> f2776 = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends jf {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static boolean f2784 = true;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f2785 = 0;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f2786 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char[] f2787 = {304, 306, 323, 312, 325, 328};

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static boolean f2788 = true;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static int f2789 = 207;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private Context f2790;

        public /* synthetic */ e(byte b8) {
            this();
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ﻐ */
        public final boolean mo2687() {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f2790.getSystemService(m2696(null, (Process.myTid() >> 22) + 127, null, "\u0086\u0083\u0084\u0085\u0084\u0083\u0082\u0081").intern())).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                int i2 = f2786 + 41;
                f2785 = i2 % 128;
                return i2 % 2 != 0;
            }
            String packageName = this.f2790.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    f2786 = (f2785 + 95) % 128;
                    if (runningAppProcessInfo.processName.equals(packageName)) {
                        f2786 = (f2785 + 105) % 128;
                        return true;
                    }
                }
            }
            int i8 = f2786 + 15;
            f2785 = i8 % 128;
            if (i8 % 2 == 0) {
                return false;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ﻛ */
        public final Activity mo2688() {
            f2785 = (f2786 + 99) % 128;
            return null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ｋ */
        public final synchronized void mo2690(Application application, Activity activity) {
            if (application == null) {
                if (activity != null) {
                    this.f2790 = activity.getApplicationContext();
                    f2785 = (f2786 + 101) % 128;
                }
            } else {
                int i2 = f2785 + 37;
                f2786 = i2 % 128;
                if (i2 % 2 != 0) {
                    this.f2790 = application.getApplicationContext();
                } else {
                    this.f2790 = application.getApplicationContext();
                    throw null;
                }
            }
        }

        private e() {
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static String m2696(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
            Object bytes = str2;
            if (str2 != null) {
                bytes = str2.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (m.f2978) {
                try {
                    char[] cArr2 = f2787;
                    int i8 = f2789;
                    if (f2784) {
                        int length = bArr.length;
                        m.f2976 = length;
                        char[] cArr3 = new char[length];
                        m.f2977 = 0;
                        while (m.f2977 < m.f2976) {
                            int i9 = m.f2977;
                            int i10 = m.f2976 - 1;
                            int i11 = m.f2977;
                            cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                            m.f2977 = i11 + 1;
                        }
                        return new String(cArr3);
                    }
                    if (f2788) {
                        int length2 = cArr.length;
                        m.f2976 = length2;
                        char[] cArr4 = new char[length2];
                        m.f2977 = 0;
                        while (m.f2977 < m.f2976) {
                            int i12 = m.f2977;
                            int i13 = m.f2976 - 1;
                            int i14 = m.f2977;
                            cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                            m.f2977 = i14 + 1;
                        }
                        return new String(cArr4);
                    }
                    int length3 = iArr.length;
                    m.f2976 = length3;
                    char[] cArr5 = new char[length3];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i15 = m.f2977;
                        int i16 = m.f2976 - 1;
                        int i17 = m.f2977;
                        cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                        m.f2977 = i17 + 1;
                    }
                    return new String(cArr5);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static synchronized jf m2685() {
        try {
            if (f2774 == null) {
                f2774 = new c((byte) 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2774;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m2686(jg jgVar) {
        this.f2776.add(jgVar);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public abstract boolean mo2687();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public abstract Activity mo2688();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized void m2689(jg jgVar) {
        this.f2776.remove(jgVar);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract void mo2690(Application application, Activity activity);

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final synchronized List<jg> m2691() {
        return new ArrayList(this.f2776);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c extends jf implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f2777 = 1;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f2778;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char[] f2779 = {'#', 'Y', 'm', 'h', 'a', 'f', '\\', 'Z', 'g', 'e', 'd', 'n', 'n', 'g', 'h', 'X', 'Z', 'n', 's', 'l', 'i', 'i', 'k', 'b', '\\', 'k', 't', 'o', 'f', 'd', 129, 281, 304, 302, 302, 263, 258, 297, 261, 261, 300, 277, 272, 297, 300, 301, 301, 300, 308, 291, 281, 298, 306, 303, 295, 290, '2', 'd', 'l', 't', 'k', 'X', 'd', 'v', 'n', 'o', 'o', 'n', 'k', 'R', 'W', 'n', 'G', 'G', 'k', 'D', 'I', 'p', 'p', 'r', '[', '2', 'k', 'Z', '^', 'v', 'n', 'o', 'o', 'n', 'k', 'R', 'W', 'n', 'G', 'G', 'k', 'D', 'I', 'p', 'p', 'r', '[', 'T', 'd', 'l', 'j', '<', 'v', 'n', 'o', 'o', 'n', 'k', 'R', ']', 'x', 's', 'p', 'a', 'a', 'k', 'o', 'm', 'f', '^', 'd', 'v', 'n', 'k', 'a', 'A', 'P', 'k', 'o', 'm', 'f', 'n', 'O', 'I', 'K', 'V', 'v', 'n', 'k', 'q', 'Q', 'M', 'n', 'i', '2', 'd', 'l', 's', 'i', 'j', 'c', 'f', 'v', 'n', 'o', 'o', 'n', 'k', 'R', 'W', 'n', 'G', 'G', 'k', 'D', 'I', 'p', 'p', 'r', '[', 'F', 141, 147, 153, 152, 154, 140, 143, 159, 151, 152, 152, 151, 148, '{', 128, 151, 'p', 'p', 148, 'm', 'r', 153, 153, 155, 132, '\"', '[', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'G', 'n', 'W', 'R', 'k', 'n', 'o', 'o', 'n', 'v', 'f', 'Z', 'k', 'm', 'W', '[', 'p', 's', 'j', 'g', 'h', 'd', '\\', 'c', 'j', 'j', 'l', '\"', '[', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'G', 'n', 'W', 'R', 'k', 'n', 'o', 'o', 'n', 'v', '^', 'T', 'l', 's', 's', 'p', 't', 'o', 'd'};

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private WeakReference<Activity> f2780;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private Map<Activity, Boolean> f2781;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private WeakReference<Application> f2782;

        private c() {
            this.f2781 = new WeakHashMap();
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private void m2695(Activity activity) {
            f2778 = (f2777 + 53) % 128;
            Iterator<jg> it = m2691().iterator();
            while (it.hasNext()) {
                int i2 = f2778 + 51;
                f2777 = i2 % 128;
                if (i2 % 2 == 0) {
                    it.next().mo483(activity);
                    throw null;
                }
                it.next().mo483(activity);
            }
            int i8 = f2778 + 69;
            f2777 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                synchronized (jf.class) {
                    try {
                        if (this.f2780 == null) {
                            m2694(activity);
                            jf.class.notifyAll();
                        }
                    } finally {
                    }
                }
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    it.next().onActivityCreated(activity, bundle);
                }
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001", true, new int[]{81, 26, 0, 22}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            f2777 = (f2778 + 29) % 128;
            try {
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(activity);
                    f2777 = (f2778 + 25) % 128;
                }
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001", false, new int[]{238, 28, 0, 0}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    f2778 = (f2777 + 1) % 128;
                    it.next().onActivityPaused(activity);
                    f2778 = (f2777 + 111) % 128;
                }
                f2778 = (f2777 + 75) % 128;
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", true, new int[]{56, 25, 0, 0}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                m2694(activity);
                Iterator<jg> it = m2691().iterator();
                f2778 = (f2777 + 59) % 128;
                while (it.hasNext()) {
                    f2777 = (f2778 + 19) % 128;
                    it.next().onActivityResumed(activity);
                }
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0001", false, new int[]{30, 26, 190, 0}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            try {
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    f2777 = (f2778 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                    it.next().onActivitySaveInstanceState(activity, bundle);
                    f2777 = (f2778 + 61) % 128;
                }
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", false, new int[]{202, 36, 0, 0}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            try {
                if (this.f2780 == null) {
                    m2694(activity);
                }
                synchronized (this) {
                    this.f2781.put(activity, Boolean.TRUE);
                }
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    it.next().onActivityStarted(activity);
                }
                if (activity.getLocalClassName().equals(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000", true, new int[]{107, 43, 0, 0}).intern())) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.f2781.size() == 1 && !this.f2775) {
                            m2692(activity);
                        }
                    } finally {
                    }
                }
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", true, new int[]{150, 26, 0, 0}).intern(), e, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int size;
            try {
                Iterator<jg> it = m2691().iterator();
                while (it.hasNext()) {
                    it.next().onActivityStopped(activity);
                }
                this.f2775 = activity.isChangingConfigurations();
                synchronized (this) {
                    try {
                        if (!this.f2781.containsKey(activity) || activity.getLocalClassName().equals(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000", true, new int[]{107, 43, 0, 0}).intern())) {
                            size = -1;
                        } else {
                            this.f2781.remove(activity);
                            size = this.f2781.size();
                        }
                    } finally {
                    }
                }
                if (size < 0 || size != 0 || this.f2775) {
                    return;
                }
                m2695(activity);
            } catch (Exception e) {
                kd.m2919(m2693("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", false, new int[]{0, 30, 0, 0}).intern(), m2693("\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", true, new int[]{176, 26, 41, 0}).intern(), e, false);
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ﻐ */
        public final synchronized boolean mo2687() {
            f2777 = (f2778 + 67) % 128;
            if (this.f2781.size() <= 0) {
                return false;
            }
            int i2 = (f2777 + 111) % 128;
            f2778 = i2;
            f2777 = (i2 + 41) % 128;
            return true;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ﻛ */
        public final Activity mo2688() {
            int i2 = f2777;
            f2778 = (i2 + 67) % 128;
            WeakReference<Activity> weakReference = this.f2780;
            if (weakReference == null) {
                return null;
            }
            f2778 = (i2 + 105) % 128;
            return weakReference.get();
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jf
        /* JADX INFO: renamed from: ｋ */
        public final synchronized void mo2690(Application application, Activity activity) {
            try {
                if (this.f2782 == null) {
                    this.f2782 = new WeakReference<>(application);
                    if (activity != null) {
                        m2694(activity);
                        synchronized (this) {
                            this.f2781.put(activity, Boolean.TRUE);
                        }
                    }
                    application.registerActivityLifecycleCallbacks(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public /* synthetic */ c(byte b8) {
            this();
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private void m2692(Activity activity) {
            Iterator<jg> it = m2691().iterator();
            f2778 = (f2777 + 31) % 128;
            while (it.hasNext()) {
                f2778 = (f2777 + 65) % 128;
                it.next().mo484(activity);
                f2777 = (f2778 + 59) % 128;
            }
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private void m2694(final Activity activity) {
            this.f2780 = new WeakReference<>(activity);
            p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jf.c.2
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() throws Exception {
                    ju.m2791(activity);
                }
            });
            int i2 = f2777 + 11;
            f2778 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 4 / 0;
            }
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static String m2693(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
            String str2;
            Object bytes = str;
            if (str != null) {
                bytes = str.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            synchronized (g.f2126) {
                try {
                    int i2 = iArr[0];
                    int i8 = iArr[1];
                    int i9 = iArr[2];
                    int i10 = iArr[3];
                    char[] cArr = new char[i8];
                    System.arraycopy(f2779, i2, cArr, 0, i8);
                    if (bArr != null) {
                        char[] cArr2 = new char[i8];
                        g.f2125 = 0;
                        char c7 = 0;
                        while (true) {
                            int i11 = g.f2125;
                            if (i11 >= i8) {
                                break;
                            }
                            if (bArr[i11] == 1) {
                                cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                            } else {
                                cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                            }
                            c7 = cArr2[i11];
                            g.f2125 = i11 + 1;
                        }
                        cArr = cArr2;
                    }
                    if (i10 > 0) {
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr, 0, cArr3, 0, i8);
                        int i12 = i8 - i10;
                        System.arraycopy(cArr3, 0, cArr, i12, i10);
                        System.arraycopy(cArr3, i10, cArr, 0, i12);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        g.f2125 = 0;
                        while (true) {
                            int i13 = g.f2125;
                            if (i13 >= i8) {
                                break;
                            }
                            cArr4[i13] = cArr[(i8 - i13) - 1];
                            g.f2125 = i13 + 1;
                        }
                        cArr = cArr4;
                    }
                    if (i9 > 0) {
                        g.f2125 = 0;
                        while (true) {
                            int i14 = g.f2125;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr[i14] = (char) (cArr[i14] - iArr[2]);
                            g.f2125 = i14 + 1;
                        }
                    }
                    str2 = new String(cArr);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }
    }
}
