package com.ironsource.adqualitysdk.sdk.i;

import android.media.MediaPlayer;
import android.os.Process;
import android.view.KeyEvent;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hd extends ha<MediaPlayer.OnInfoListener> implements MediaPlayer.OnInfoListener {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2284 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2285 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f2286 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2287 = 96;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean f2288 = true;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2289 = {175, 206, 169, 198, 207, 172, 201, 211, 212, 197, 210, 164, 195, 193, 165, 128, 205, 180, 194};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private d f2290;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        /* JADX INFO: renamed from: ﻛ */
        boolean mo1875(hd hdVar, MediaPlayer mediaPlayer, int i2, int i8);
    }

    public hd(MediaPlayer.OnInfoListener onInfoListener, d dVar) {
        super(onInfoListener);
        this.f2290 = dVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2285(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f2289;
                int i8 = f2287;
                if (f2288) {
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
                if (f2286) {
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

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i8) {
        int i9 = f2284 + 85;
        f2285 = i9 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2285(null, KeyEvent.keyCodeFromString("") + 127, null, "\u008b\u0085\u0089\u008e\u008b\u0085\u008d\u008a\u008c\u008b\u008a\u0082\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0082\u0083\u0082\u0081").intern(), m2285(null, 127 - ((Process.getThreadPriority(0) + 20) >> 6), null, "\u0085\u0084\u0082\u0083\u0082\u0085\u0090\u008b\u008a\u0082\u008a\u0089\u0088\u0087\u0086\u0093\u0092\u0091\u0090\u0082\u0087\u0090\u008b\u0085\u008b\u008b\u008f").intern(), th, false);
        }
        if (i9 % 2 == 0) {
            this.f2290.mo1875(this, mediaPlayer, i2, i8);
            throw null;
        }
        this.f2290.mo1875(this, mediaPlayer, i2, i8);
        if (mo831() != null) {
            return mo831().onInfo(mediaPlayer, i2, i8);
        }
        int i10 = f2285 + 87;
        f2284 = i10 % 128;
        if (i10 % 2 == 0) {
            return false;
        }
        throw null;
    }
}
