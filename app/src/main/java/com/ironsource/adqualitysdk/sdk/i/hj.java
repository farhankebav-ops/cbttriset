package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.PointF;
import android.media.MediaPlayer;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hj extends ha<MediaPlayer.OnSeekCompleteListener> implements MediaPlayer.OnSeekCompleteListener {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2327 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2328 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private e f2330;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2329 = {46457, 24115, 25523, 30482, 6399, 11338, 12791, 55988, 60931, 62341, 34676, 43210, 48198, 16700, 27296, 32282, 1013, 5977, 14549, 52649, 53519, 64131, 36416, 37838, 42845, 18474, 23962, 24862, 2806, 7750, 9166, 39438, 29010, 19695, 22629, 14229, 892, 7840, 62920, 49459, 56549, 43057, 34736, 37635, 28237, 17890, 20858, 11422, 14398, 6056, 58056, 65079, 54755, 41239, 48261, 34854, 26461, 29438, 20033, 9616, 12601, 3249, 7122, 63310, 49908, 56856};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f2326 = 789044889205992299L;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface e {
        /* JADX INFO: renamed from: ｋ */
        void mo1878(hj hjVar, MediaPlayer mediaPlayer);
    }

    public hj(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener, e eVar) {
        super(onSeekCompleteListener);
        this.f2330 = eVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2299(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2329[i8 + i9]) ^ (((long) i9) * f2326)) ^ ((long) c7));
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

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        try {
            this.f2330.mo1878(this, mediaPlayer);
            f2327 = (f2328 + 13) % 128;
        } catch (Throwable th) {
            kd.m2919(m2299((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 46390), AndroidCharacter.getMirror('0') - 17, View.MeasureSpec.makeMeasureSpec(0, 0)).intern(), m2299((char) (39498 - TextUtils.indexOf((CharSequence) "", '0', 0)), TextUtils.indexOf("", "", 0) + 35, 31 - TextUtils.getCapsMode("", 0, 0)).intern(), th, false);
        }
        if (mo831() != null) {
            int i2 = f2327 + 7;
            f2328 = i2 % 128;
            if (i2 % 2 == 0) {
                mo831().onSeekComplete(mediaPlayer);
                throw null;
            }
            mo831().onSeekComplete(mediaPlayer);
            f2327 = (f2328 + 43) % 128;
        }
        int i8 = f2328 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2327 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }
}
