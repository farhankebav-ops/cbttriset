package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class iy {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2642 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2643 = -4250919849605584923L;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2644 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private boolean f2645 = false;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final iv f2646;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        /* JADX INFO: renamed from: ﻐ */
        ir mo2614();
    }

    public iy(Context context) {
        this.f2646 = new iv(context.getApplicationContext());
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m2607(iy iyVar, iz izVar, d dVar) {
        int i2 = f2644 + 27;
        f2642 = i2 % 128;
        int i8 = i2 % 2;
        iyVar.m2608(izVar, dVar);
        if (i8 != 0) {
            int i9 = 13 / 0;
        }
        f2644 = (f2642 + 111) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2608(final iz izVar, final d dVar) {
        int i2 = f2642 + 1;
        f2644 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (!this.f2645) {
            jv.m2807(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iy.5

                /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                private static int f2649 = 1;

                /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                private static char f2650 = 15585;

                /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                private static char f2651 = 20229;

                /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                private static int f2652 = 0;

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static char f2653 = 27721;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static char f2654 = 11593;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private void m2615(final iz izVar2, final d dVar2) {
                    iy.m2609(iy.this).m2570(new iq() { // from class: com.ironsource.adqualitysdk.sdk.i.iy.5.1
                        @Override // com.ironsource.adqualitysdk.sdk.i.iq
                        /* JADX INFO: renamed from: ﻛ */
                        public final void mo481() {
                            iy.m2609(iy.this).m2573(this);
                            iy.m2607(iy.this, izVar2, dVar2);
                        }
                    });
                    int i8 = f2649 + 81;
                    f2652 = i8 % 128;
                    if (i8 % 2 != 0) {
                        int i9 = 72 / 0;
                    }
                }

                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                private static String m2616(String str, int i8) {
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
                                int i9 = o.f2986;
                                if (i9 < cArr.length) {
                                    cArr3[0] = cArr[i9];
                                    cArr3[1] = cArr[i9 + 1];
                                    int i10 = 58224;
                                    for (int i11 = 0; i11 < 16; i11++) {
                                        char c7 = cArr3[1];
                                        char c8 = cArr3[0];
                                        char c9 = (char) (c7 - (((c8 + i10) ^ ((c8 << 4) + f2650)) ^ ((c8 >>> 5) + f2651)));
                                        cArr3[1] = c9;
                                        cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2653) ^ ((c9 + i10) ^ ((c9 << 4) + f2654))));
                                        i10 -= 40503;
                                    }
                                    int i12 = o.f2986;
                                    cArr2[i12] = cArr3[0];
                                    cArr2[i12 + 1] = cArr3[1];
                                    o.f2986 = i12 + 2;
                                } else {
                                    str2 = new String(cArr2, 0, i8);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return str2;
                }

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private void m2617(final iz izVar2, d dVar2) {
                    int i8 = f2649 + 101;
                    f2652 = i8 % 128;
                    if (i8 % 2 != 0) {
                        iy.m2609(iy.this).m2571();
                        throw null;
                    }
                    if (!iy.m2609(iy.this).m2571()) {
                        m2615(izVar2, dVar2);
                        int i9 = f2652 + 115;
                        f2649 = i9 % 128;
                        if (i9 % 2 == 0) {
                            throw null;
                        }
                        return;
                    }
                    try {
                        final ir irVarMo2614 = dVar2.mo2614();
                        if (irVarMo2614 == null) {
                            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iy.5.2

                                /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                                private static int f2661 = 1;

                                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                                private static char[] f2662 = {61471, 7704, 11378, 15093, 18565, 22163, 25905, 29556, 33106, 44937, 48619, 52271, 55884, 59486, 63160, 1259, 4807, 8501, 20278, 23882, 27526, 31139, 34849, 38421, 42065, 45755, 49387, 61150, 64860, 2920, 6581, 10125, 13789, 17527, 20994, 24668, 36514, 40181, 43719, 47363, 51045, 54705, 58266, 61853, '8', 11891, 15435, 19095, 22696, 26261, 30022, 33589, 37364, 49036, 52672, 56417, 60030, 63552, 1758, 5375, 9017, 12568, 24394, 28070, 31734, 35268, 38947, 42543, 46084};

                                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                                private static long f2663 = -5850150711423013329L;

                                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                private static int f2664;

                                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                private static String m2618(char c7, int i10, int i11) {
                                    String str;
                                    synchronized (c.f1192) {
                                        try {
                                            char[] cArr = new char[i10];
                                            c.f1193 = 0;
                                            while (true) {
                                                int i12 = c.f1193;
                                                if (i12 < i10) {
                                                    cArr[i12] = (char) ((((long) f2662[i11 + i12]) ^ (((long) i12) * f2663)) ^ ((long) c7));
                                                    c.f1193 = i12 + 1;
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

                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() throws Exception {
                                    int iM2558;
                                    int i10 = f2664 + 13;
                                    f2661 = i10 % 128;
                                    if (i10 % 2 == 0) {
                                        throw null;
                                    }
                                    ir irVar = irVarMo2614;
                                    if (irVar != null) {
                                        iM2558 = irVar.m2557().m2558();
                                        f2661 = (f2664 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                                    } else {
                                        iM2558 = -1;
                                    }
                                    iz izVar3 = izVar2;
                                    ir irVar2 = irVarMo2614;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(m2618((char) (61528 - (Process.myPid() >> 22)), 69 - Color.alpha(0), ExpandableListView.getPackedPositionChild(0L) + 1).intern());
                                    sb.append(iM2558);
                                    izVar3.mo465(irVar2, sb.toString());
                                }
                            });
                            return;
                        }
                        String strM2593 = ix.m2593(irVarMo2614);
                        String strIntern = m2616("췌냫粕蝽ᗇ\uf36e쫄勼ߑ\ue8f6섇욚囫濿", TextUtils.getTrimmedLength("") + 14).intern();
                        StringBuilder sb = new StringBuilder();
                        sb.append(m2616("㼦☶㡿璠鍸萺\ue24a멘\uf3d1钾犠Ʒ\uab6f쯲颋㠕嶧챝✅㷰ࡄ䮠骤彩╼ബꪇ⩫ࡄ䮠᥏㏉囫濿\uf0be㕽梾恊⍬㘳끥䧇⋺Ť锐淚", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 45).intern());
                        sb.append(strM2593);
                        k.m2852(strIntern, sb.toString());
                        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iy.5.4
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() throws Exception {
                                izVar2.mo467(irVarMo2614);
                            }
                        });
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(m2616("銹㏤詃暤魨癶ꇫ\uf80dꤋԕࡄ䮠七劫⤠\ufadf撢웨\uf4a5犐ꪇ⩫颋㠕\udc07蝽犠Ʒ㡿璠", TextUtils.lastIndexOf("", '0') + 31).intern());
                        sb2.append(e.getLocalizedMessage());
                        izVar2.mo465(null, sb2.toString());
                    }
                }

                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    int i8 = f2649 + 47;
                    f2652 = i8 % 128;
                    if (i8 % 2 != 0) {
                        m2617(izVar, dVar);
                        int i9 = 59 / 0;
                    } else {
                        m2617(izVar, dVar);
                    }
                    f2649 = (f2652 + 81) % 128;
                }
            });
        } else {
            k.m2863(m2610("⋭⊣⧃ใ༽䂃푚ꎂ봖\ueec8꾶썔ᶤ亠츐拪ﰴ⼐", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), m2610("⣚⢉᷅㩏ળ䔔盈Ă뜡\udad2ꨯ憫ឆ窺쮏쁺\uf602᭄毦\u20cc嚪뮙譠荁㕑塧⣟\ue309闇\uf8e9䠣䎊疥饀\ue9e2ꈄ퐒㤥ऐʧ뒠\ud9b9꺞敜\u137d縚컭엲\uf3e7Ừ湓▤剏뽢辎萠㈿忟⽺\ue488銪ﱍ䲂䝫焙鰣\uec0c", 1 - TextUtils.getOffsetBefore("", 0)).intern());
            f2644 = (f2642 + 91) % 128;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ iv m2609(iy iyVar) {
        int i2 = f2642 + 41;
        f2644 = i2 % 128;
        int i8 = i2 % 2;
        iv ivVar = iyVar.f2646;
        if (i8 != 0) {
            return ivVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2612() {
        f2644 = (f2642 + 95) % 128;
        this.f2646.m2575();
        this.f2645 = true;
        f2642 = (f2644 + 13) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2610(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2643, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2643));
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

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final iv m2611() {
        int i2 = f2644;
        int i8 = i2 + 65;
        f2642 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        iv ivVar = this.f2646;
        f2642 = (i2 + 57) % 128;
        return ivVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        m2608(r5, new com.ironsource.adqualitysdk.sdk.i.iy.AnonymousClass2());
        r3 = com.ironsource.adqualitysdk.sdk.i.iy.f2642 + 89;
        com.ironsource.adqualitysdk.sdk.i.iy.f2644 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0055, code lost:
    
        if ((r3 % 2) != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
    
        r3 = 37 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.k.m2851(m2610("⋭⊣⧃ใ༽䂃푚ꎂ봖\ueec8꾶썔ᶤ亠츐拪ﰴ⼐", -android.view.MotionEvent.axisFromString("")).intern(), m2610("줁쥔睼僷◴機椤ứ囹끠蔡縓\uf646ၑ\ue4dd\udf9c៎熩䓹㼬뜤턺ꐱ鲴품㊕ރﳒ琈鉔杸屰鑹\uf3ad웬뷶㗕厑♐ᴙ唕댰至窋\uf2e9ᒾ\ue1bf\uda73ሯ瑘䄊㩟뎞헇ꂖ鯞폍㕴\u007fﭳ獵雤描壃郚\uf688썛렚ち嘷⌺ᦿ凵략芳秈\uf11f\u1758\ue209\ud956ẙ", -android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0')).intern());
     */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2613(final java.lang.String r3, final org.json.JSONObject r4, com.ironsource.adqualitysdk.sdk.i.iz r5) {
        /*
            r2 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.iy.f2642
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.iy.f2644 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L17
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 69
            int r1 = r1 / 0
            if (r0 == 0) goto L43
            goto L1d
        L17:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L43
        L1d:
            java.lang.String r3 = ""
            int r4 = android.view.MotionEvent.axisFromString(r3)
            int r4 = -r4
            java.lang.String r5 = "⋭⊣⧃ใ༽䂃푚ꎂ봖\ueec8꾶썔ᶤ亠츐拪ﰴ⼐"
            java.lang.String r4 = m2610(r5, r4)
            java.lang.String r4 = r4.intern()
            r5 = 48
            int r3 = android.text.TextUtils.indexOf(r3, r5)
            int r3 = -r3
            java.lang.String r5 = "줁쥔睼僷◴機椤ứ囹끠蔡縓\uf646ၑ\ue4dd\udf9c៎熩䓹㼬뜤턺ꐱ鲴품㊕ރﳒ琈鉔杸屰鑹\uf3ad웬뷶㗕厑♐ᴙ唕댰至窋\uf2e9ᒾ\ue1bf\uda73ሯ瑘䄊㩟뎞헇ꂖ鯞폍㕴\u007fﭳ獵雤描壃郚\uf688썛렚ち嘷⌺ᦿ凵략芳秈\uf11f\u1758\ue209\ud956ẙ"
            java.lang.String r3 = m2610(r5, r3)
            java.lang.String r3 = r3.intern()
            com.ironsource.adqualitysdk.sdk.i.k.m2851(r4, r3)
            return
        L43:
            com.ironsource.adqualitysdk.sdk.i.iy$2 r0 = new com.ironsource.adqualitysdk.sdk.i.iy$2
            r0.<init>()
            r2.m2608(r5, r0)
            int r3 = com.ironsource.adqualitysdk.sdk.i.iy.f2642
            int r3 = r3 + 89
            int r4 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.iy.f2644 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L5b
            r3 = 37
            int r3 = r3 / 0
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.iy.m2613(java.lang.String, org.json.JSONObject, com.ironsource.adqualitysdk.sdk.i.iz):void");
    }
}
