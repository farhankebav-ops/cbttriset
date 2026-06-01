package com.ironsource.adqualitysdk.sdk.i;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hl extends ha<View.OnTouchListener> implements View.OnTouchListener {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2337 = -3594642600123577954L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2338 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2339;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private c f2340;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c {
        /* JADX INFO: renamed from: ﻛ */
        boolean mo1874(hl hlVar, View view, MotionEvent motionEvent);
    }

    public hl(View.OnTouchListener onTouchListener, c cVar) {
        super(onTouchListener);
        this.f2340 = cVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2303(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2337);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i2 = f2338 + 109;
        f2339 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2303("집\udcaf\ue374觬鲗ꌦ䧌屋挏\u09baᱜ⋮즄\udc28\ue2de襋鰋ꊲ䥟忡抓डΊ≥", 5471 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern(), m2303("짛钁猶톶뱘\u1a9f凉䐋⋖脦澈쩓꣎睾툛낉Ἣ\ufdcd塑⛻蔺怀캮괁\u0bc9홎듯ᎉ", 23917 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2340.mo1874(this, view, motionEvent);
            throw null;
        }
        this.f2340.mo1874(this, view, motionEvent);
        if (mo831() == null) {
            f2338 = (f2339 + 71) % 128;
            return false;
        }
        int i8 = f2339 + 59;
        f2338 = i8 % 128;
        if (i8 % 2 != 0) {
            return mo831().onTouch(view, motionEvent);
        }
        mo831().onTouch(view, motionEvent);
        throw null;
    }
}
