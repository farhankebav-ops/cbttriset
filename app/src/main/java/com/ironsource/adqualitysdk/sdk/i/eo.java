package com.ironsource.adqualitysdk.sdk.i;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class eo extends el {

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f1995 = {'C', 18462, 37008, 55571, 8595, 27151, 45786, 64282, 17303, 35866, 54406, 7444, 25990, 44566, 63186, 30280, 15990, 59128, 44913, 22452};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1994 = 2753404354581842047L;

    public eo(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2210(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1995[i8 + i9]) ^ (((long) i9) * f1994)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ﻛ */
    public final boolean mo2204(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(m2210((char) ExpandableListView.getPackedPositionType(0L), AndroidCharacter.getMirror('0') - '!', ViewConfiguration.getKeyRepeatDelay() >> 16).intern());
        sb.append(obj);
        sb.append(m2210((char) (TextUtils.getOffsetAfter("", 0) + 30312), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14).intern());
        sb.append(obj2);
        throw new RuntimeException(sb.toString());
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.el
    /* JADX INFO: renamed from: ｋ */
    public final boolean mo2206(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(m2210((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 14 - TextUtils.lastIndexOf("", '0', 0), ViewConfiguration.getPressedStateDuration() >> 16).intern());
        sb.append(str);
        throw new RuntimeException(a0.d(sb, m2210((char) (30313 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 5, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15), str2));
    }
}
