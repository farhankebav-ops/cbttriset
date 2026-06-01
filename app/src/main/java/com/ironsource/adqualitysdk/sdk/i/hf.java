package com.ironsource.adqualitysdk.sdk.i;

import android.media.MediaPlayer;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hf extends ha<MediaPlayer.OnPreparedListener> implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2298 = 8112596109064534292L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2299 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2300;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private a f2301;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        /* JADX INFO: renamed from: ｋ */
        void mo1876(hf hfVar, MediaPlayer mediaPlayer);
    }

    public hf(MediaPlayer.OnPreparedListener onPreparedListener, a aVar) {
        super(onPreparedListener);
        this.f2301 = aVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2287(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2298, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2298));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        int i2 = f2299 + 3;
        f2300 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2287("\ue946\uf726\ue909㙐\u0e5c廂쐨떌൳⨲\ue049鄼Ↄ㛶賔\ued77䗅兖꤭욀硣紀땼⋛鲵駭冚㹯냒ꖽ稪", ExpandableListView.getPackedPositionGroup(0L)).intern(), m2287("ऴ\ue45cॱ饭ᴺﴍ欷ᙞ\ued16㤘佼㋯솴▅⏱亳ꖈ䈱؆敕頑湦᩠脃粄誗ﺻ鶑傦뛍픕롰㝶퍽ꥑ", 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2301.mo1876(this, mediaPlayer);
            throw null;
        }
        this.f2301.mo1876(this, mediaPlayer);
        if (mo831() != null) {
            f2299 = (f2300 + 33) % 128;
            mo831().onPrepared(mediaPlayer);
        }
        f2300 = (f2299 + 39) % 128;
    }
}
