package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bb {

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f750 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f751 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static long f752 = -4777614816681188125L;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f753 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f754 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static long f755 = 3298352059009476285L;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Handler f756;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ah f757;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ISAdQualityAdListener f758;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Set<io> f759 = new HashSet();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Set<String> f760 = new HashSet();

    public bb(Handler handler, ah ahVar) {
        this.f757 = ahVar;
        this.f756 = handler;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m840(bb bbVar, String str, JSONObject jSONObject) {
        int i2 = f753 + 77;
        f750 = i2 % 128;
        int i8 = i2 % 2;
        bbVar.m844(str, jSONObject);
        if (i8 == 0) {
            throw null;
        }
        f750 = (f753 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ ah m841(bb bbVar) {
        int i2 = f750 + 9;
        f753 = i2 % 128;
        int i8 = i2 % 2;
        ah ahVar = bbVar.f757;
        if (i8 == 0) {
            return ahVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final void m845(JSONObject jSONObject) {
        int i2 = f750 + 35;
        f753 = i2 % 128;
        int i8 = i2 % 2;
        long packedPositionForChild = ExpandableListView.getPackedPositionForChild(0, 0);
        m854((i8 != 0 ? m842("㞧뛶떋\ued6a", (char) (32085 % (packedPositionForChild > 0L ? 1 : (packedPositionForChild == 0L ? 0 : -1))), "㘾㌍딺ㅃ蒟쨈\udff5䇋晹㦾Ⅎ\udbbb\u05fa돎⬴", TextUtils.indexOf((CharSequence) "", (char) 29, 1, 0) - 1950943690, "⚽\ue570ᦸⷆ") : m842("㞧뛶떋\ued6a", (char) (27316 - (packedPositionForChild > 0L ? 1 : (packedPositionForChild == 0L ? 0 : -1))), "㘾㌍딺ㅃ蒟쨈\udff5䇋晹㦾Ⅎ\udbbb\u05fa돎⬴", (-1950943690) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), "⚽\ue570ᦸⷆ")).intern(), jSONObject);
        f750 = (f753 + 41) % 128;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final void m846(JSONObject jSONObject) {
        f750 = (f753 + 49) % 128;
        m854(m842("쀝\u2e75冑呂", (char) (Color.green(0) + 16977), "筱袶\uddbb峉䦣뛐ᅤ즒䖙勯奥쁍孄", (-1859226176) - (ViewConfiguration.getTouchSlop() >> 8), "⚽\ue570ᦸⷆ").intern(), jSONObject);
        int i2 = f750 + 69;
        f753 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final void m847(JSONObject jSONObject) {
        int i2 = f753 + 47;
        f750 = i2 % 128;
        m854(m843("垒ق埳⋂䤶\u0084ꂖ칠쑮빌\udda3ꋐ烯䷝", i2 % 2 == 0 ? 0 - ExpandableListView.getPackedPositionType(1L) : ExpandableListView.getPackedPositionType(0L) + 1).intern(), jSONObject);
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final void m848(JSONObject jSONObject) {
        f750 = (f753 + 93) % 128;
        m854(m842("凷ឮ∯蟳", (char) ((Process.getThreadPriority(0) + 20) >> 6), "䡫襫⨇ָ놠鮧ꜘ題噱ᐩ⺥", Drawable.resolveOpacity(0, 0) + 790081105, "⚽\ue570ᦸⷆ").intern(), jSONObject);
        f750 = (f753 + 7) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m849(ISAdQualityAdListener iSAdQualityAdListener) {
        int i2 = (f750 + 1) % 128;
        f753 = i2;
        this.f758 = iSAdQualityAdListener;
        f750 = (i2 + 27) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m852(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt(ig.f2523);
        ISAdQualityAdListener iSAdQualityAdListener = this.f758;
        if (iSAdQualityAdListener != null) {
            int i2 = f753 + 55;
            f750 = i2 % 128;
            if (i2 % 2 == 0) {
                iSAdQualityAdListener.adDisplayed(jSONObject.optString(ig.f2524), ISAdQualityAdType.fromInt(iOptInt));
                throw null;
            }
            iSAdQualityAdListener.adDisplayed(jSONObject.optString(ig.f2524), ISAdQualityAdType.fromInt(iOptInt));
        }
        f750 = (f753 + 105) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m855(JSONObject jSONObject) {
        f753 = (f750 + 9) % 128;
        m854(m843("̴汨͕䣨ꅆ\ue8f4ኮ籘郋푳㗇ჩ\u2458⟶顎", -ExpandableListView.getPackedPositionChild(0L)).intern(), jSONObject);
        int i2 = f753 + 49;
        f750 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m850(JSONObject jSONObject) {
        int i2 = f753 + 91;
        f750 = i2 % 128;
        m854(m843("ꮓꑢ꯲胢ᴫ咙ﻘ逮㡼᱿覮ﲌ賿\ueffc␣", i2 % 2 == 0 ? 0 - (ViewConfiguration.getScrollBarFadeDuration() / 84) : (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1).intern(), jSONObject);
        int i8 = f750 + 93;
        f753 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 70 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m854(final String str, final JSONObject jSONObject) {
        this.f756.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.bb.4
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                bb.m840(bb.this, str, jSONObject);
            }
        });
        int i2 = f753 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f750 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m857(JSONObject jSONObject) {
        int i2 = f753 + 1;
        f750 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        ISAdQualityAdListener iSAdQualityAdListener = this.f758;
        if (iSAdQualityAdListener != null) {
            iSAdQualityAdListener.adClosed(jSONObject.optString(ig.f2524), ISAdQualityAdType.fromInt(jSONObject.optInt(ig.f2523)));
            f753 = (f750 + 3) % 128;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m858(JSONObject jSONObject) {
        f750 = (f753 + 23) % 128;
        m854(m842("㝴볷揹ﭗ", (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), "焪啍怿竗縩喓쎯퐪䐡眫摴", (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 105056457, "⚽\ue570ᦸⷆ").intern(), jSONObject);
        f753 = (f750 + 7) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m838(String str, JSONObject jSONObject) {
        Iterator it = new HashSet(this.f759).iterator();
        while (it.hasNext()) {
            f750 = (f753 + 95) % 128;
            JSONObject jSONObjectMo716 = ((io) it.next()).mo716(str, jSONObject);
            if (jSONObjectMo716 != null) {
                int i2 = f753 + 57;
                f750 = i2 % 128;
                int i8 = i2 % 2;
                kc.m2910(jSONObject, jSONObjectMo716);
                if (i8 == 0) {
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m844(final String str, JSONObject jSONObject) {
        m838(str, jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        try {
            String str2 = ig.f2524;
            jSONObject2.put(str2, jSONObject.remove(str2));
            String str3 = ig.f2480;
            jSONObject2.put(str3, jSONObject.remove(str3));
            f753 = (f750 + 51) % 128;
        } catch (JSONException unused) {
        }
        this.f757.m459(str, jSONObject, jSONObject2, new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.bb.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (ig.f2472.contains(str)) {
                    p.m2969(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.bb.2.5
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            bb.m841(bb.this).m457();
                        }
                    });
                }
            }
        });
        f750 = (f753 + 9) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m853(io ioVar) {
        int i2 = f750 + 11;
        f753 = i2 % 128;
        if (i2 % 2 != 0) {
            this.f759.add(ioVar);
            int i8 = 68 / 0;
        } else {
            this.f759.add(ioVar);
        }
        f750 = (f753 + 15) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static double m839() {
        f750 = (f753 + 47) % 128;
        if (aq.m530().mo548()) {
            return 100.0d;
        }
        f753 = (f750 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        double dMo549 = aq.m530().mo549();
        f750 = (f753 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return dMo549;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m843(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f752, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f752));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m851(String str, String str2, String str3, String str4) {
        int i2 = f753 + 75;
        f750 = i2 % 128;
        if (i2 % 2 == 0) {
            m856(str, str2, str3, str4, null, false);
        } else {
            m856(str, str2, str3, str4, null, false);
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m856(String str, String str2, String str3, String str4, JSONObject jSONObject, boolean z2) {
        synchronized (this.f760) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(m842("\uee1d䖆枞湠", (char) (24679 - View.combineMeasuredStates(0, 0)), "㕳", AndroidCharacter.getMirror('0') - 31042, "⚽\ue570ᦸⷆ").intern());
                sb.append(str2);
                String string = sb.toString();
                if (!this.f760.contains(string) || z2 || aq.m530().mo553()) {
                    this.f760.add(string);
                    if (Math.random() * 100.0d < m839()) {
                        JSONObject jSONObjectM449 = ah.m449(str, str2, str3, str4, jSONObject);
                        m838(m843("\ufde0⑤ﶔ÷蹘쟁\udf67놫渞鱹\u1afc\udd20", -((byte) KeyEvent.getModifierMetaStateMask())).intern(), jSONObjectM449);
                        this.f757.m458(m843("\ufde0⑤ﶔ÷蹘쟁\udf67놫渞鱹\u1afc\udd20", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1).intern(), jSONObjectM449);
                        return;
                    }
                    k.m2852(m843("ꆲ塰ꇷ糥趁쐢횁롆㉊\ue04cᤕ퓚蛎Ꮾ뒎", -((byte) KeyEvent.getModifierMetaStateMask())).intern(), m843("ฅ⌼แ\u07b6칈蟽큍뺇鷨鬡嫋툑⥳梠\uf703䗸듑ﳤ菲沈䁇偀ၹ沴\uefdc◕갚聆笹뤷㣞㎜ڵ\u0ee2픃Ꝟ鉂\ue20b懻\udb34ↈ瞀︼仸촉쬏誱\ue209奲墳❘ᖌ\ue4f1", TextUtils.getOffsetBefore("", 0) + 1).intern());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m842(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f755) ^ ((long) f751)) ^ ((long) f754));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }
}
