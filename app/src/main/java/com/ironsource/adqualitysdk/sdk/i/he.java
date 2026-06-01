package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.KeyEvent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class he extends ha<MediaPlayer.OnCompletionListener> implements MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2291 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2292 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2293 = 55979;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2294 = 59635;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2295 = 13866;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2296 = 10054;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private b f2297;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        /* JADX INFO: renamed from: ｋ */
        void mo1877(he heVar, MediaPlayer mediaPlayer);
    }

    public he(MediaPlayer.OnCompletionListener onCompletionListener, b bVar) {
        super(onCompletionListener);
        this.f2297 = bVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2286(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2295)) ^ ((c8 >>> 5) + f2293)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2294) ^ ((c9 + i9) ^ ((c9 << 4) + f2296))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            this.f2297.mo1877(this, mediaPlayer);
        } catch (Throwable th) {
            kd.m2919(m2286("ஆ侨凞\udd72迿댵≴泚荊条筺\ud904덁논ʂ矄푌荳ﯔ࠾晗젩㊽蛳\ue3d8歟ꙟ綾奊飗", 29 - KeyEvent.normalizeMetaState(0)).intern(), m2286("\ud9aaᑡ\ue98d易䨳霪\ud97dꄪ➱폫帙걖덁논ʂ矄푌荳ﯔ࠾ꪍ㹙騗飧똍\uedf5\ue6e7䳤\ua8cdꟆ쫝塩篝恏", 33 - Color.blue(0)).intern(), th, false);
        }
        if (mo831() != null) {
            f2292 = (f2291 + 55) % 128;
            mo831().onCompletion(mediaPlayer);
            f2291 = (f2292 + 21) % 128;
        }
    }
}
