package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.ironsource.adqualitysdk.sdk.i.v;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class aa extends v<View> implements View.OnLayoutChangeListener, jl {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f61 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f62 = 46571;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f63 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f64 = 51275;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f65 = 15380;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f66 = 12074;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private Class f67;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private WeakHashMap<View, Boolean> f68;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private e f69;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends v.b {

        /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
        private static int f70 = 1;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f71;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private String f77;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private String f78;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private String f79;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int[] f76 = {-738270424, 1881077753, -1414684862, -939376984, 1006290961, 295703542, 260890606, 1913626910, -280092621, 1016930921, 1165086259, -385708377, -412088728, 1391314251, -131758146, 23689888, 1857504460, -997869261};

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static char f75 = 26551;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static char f74 = 48324;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static char f73 = 35484;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static char f72 = 56956;

        public e(aa aaVar) {
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private e m266(String str) {
            int i2 = f71;
            this.f78 = str;
            f70 = (i2 + 53) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public static /* synthetic */ String m267(e eVar) {
            int i2 = f71 + 33;
            int i8 = i2 % 128;
            f70 = i8;
            int i9 = i2 % 2;
            String str = eVar.f79;
            if (i9 == 0) {
                int i10 = 85 / 0;
            }
            f71 = (i8 + 5) % 128;
            return str;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ String m269(e eVar) {
            int i2 = f70;
            f71 = (i2 + 69) % 128;
            String str = eVar.f78;
            int i8 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f71 = i8 % 128;
            if (i8 % 2 == 0) {
                return str;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static /* synthetic */ String m272(e eVar) {
            int i2 = f71 + 79;
            f70 = i2 % 128;
            int i8 = i2 % 2;
            String str = eVar.f77;
            if (i8 == 0) {
                int i9 = 3 / 0;
            }
            return str;
        }

        public e(aa aaVar, JSONObject jSONObject) {
            m266(jSONObject.optString(m270(new int[]{-1185656862, -1972874879, 1321703755, -1832996330, -1651833804, -719201476, 1548840504, -1095708708, 1538362370, -1473328013, -1945324490, 999248568}, 22 - Color.green(0)).intern()));
            m268(jSONObject.optString(m273("\u137f儏ꉃ\ue7a9諿䵈뫰\ue4a5\uea50῀ⅻ㿔㢔\uf7e8", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 13).intern()));
            m271(jSONObject.optString(m273("ﶮ䢴荳깸裃摿㳎䃓ꉃ\ue7a9\ua83bጩ얔ٳ㳖싊", (ViewConfiguration.getEdgeSlop() >> 16) + 16).intern()));
            m3078(jSONObject.optString(m270(new int[]{62317314, 936284828, 754909611, 19258682, 934067663, 1734239920}, (ViewConfiguration.getTouchSlop() >> 8) + 10).intern()));
            m3083(false);
            m3084(!TextUtils.isEmpty(jSONObject.optString(m270(new int[]{62317314, 936284828, 754909611, 19258682, 934067663, 1734239920}, 9 - TextUtils.indexOf((CharSequence) "", '0', 0)).intern())) || jSONObject.optBoolean(m270(new int[]{-579466394, -1985330324, -89479898, -154622981, 1982882229, 943202192, 1082637033, 361640227}, View.MeasureSpec.makeMeasureSpec(0, 0) + 16).intern()) || jSONObject.optBoolean(m270(new int[]{-579466394, -1985330324, 117319562, -284025448, -1590286986, 1755432113, -678291715, -978369782, -703806030, 1489388461}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18).intern()));
            m3081(jSONObject.optBoolean(m270(new int[]{-579466394, -1985330324, -89479898, -154622981, 1982882229, 943202192, 1082637033, 361640227}, 16 - View.resolveSize(0, 0)).intern()));
            m3075(jSONObject.optBoolean(m273("퇪坥\ue121\ue14f\uf621뀖ﴛ藙ꋉ\uf1e4", KeyEvent.keyCodeFromString("") + 10).intern()));
            m3080(TextUtils.isEmpty(jSONObject.optString(m270(new int[]{-1426883331, 1831347036, 1732345266, -1316112530, -503143582, -798035453}, (ViewConfiguration.getJumpTapTimeout() >> 16) + 9).intern())) ? null : Arrays.asList(jSONObject.optString(m270(new int[]{-1426883331, 1831347036, 1732345266, -1316112530, -503143582, -798035453}, 9 - (Process.myPid() >> 22)).intern()).split(m273("뇭\uda5b", KeyEvent.getDeadChar(0, 0) + 1).intern())));
            m3085(jSONObject.optBoolean(m273("퇪坥쯮앏浲聱뫰\ue4a5鸧۵饾\ue52d\uea82쟨", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 13).intern(), true));
            m3079(false);
            m3076(jSONObject.optBoolean(m270(new int[]{-528908953, -1680978477, 1984677389, -1151871473, -1698980353, -1896790602, -524425728, -1608907316, -2012273476, 756117633}, 16 - Process.getGidForName("")).intern()));
            m3077(jSONObject.optBoolean(m270(new int[]{-38261567, 1572625625, -40815897, -2047656431, -1994081213, -1601958178}, ((Process.getThreadPriority(0) + 20) >> 6) + 9).intern()));
            m3082(kc.m2911(jSONObject.optJSONArray(m273("\u137f儏ꉃ\ue7a9乩臖笱寁䕨즛燃ﵒ㢔\uf7e8", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 12).intern())));
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private e m268(String str) {
            int i2 = (f71 + 29) % 128;
            f70 = i2;
            this.f77 = str;
            f71 = (i2 + 17) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private e m271(String str) {
            int i2 = f71 + 11;
            f70 = i2 % 128;
            if (i2 % 2 != 0) {
                this.f79 = str;
                return this;
            }
            this.f79 = str;
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m270(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f76.clone();
                    d.f1665 = 0;
                    while (true) {
                        int i8 = d.f1665;
                        if (i8 < iArr.length) {
                            int i9 = iArr[i8];
                            char c7 = (char) (i9 >> 16);
                            cArr[0] = c7;
                            char c8 = (char) i9;
                            cArr[1] = c8;
                            char c9 = (char) (iArr[i8 + 1] >> 16);
                            cArr[2] = c9;
                            char c10 = (char) iArr[i8 + 1];
                            cArr[3] = c10;
                            d.f1663 = (c7 << 16) + c8;
                            d.f1666 = (c9 << 16) + c10;
                            d.m1895(iArr2);
                            for (int i10 = 0; i10 < 16; i10++) {
                                int i11 = d.f1663 ^ iArr2[i10];
                                d.f1663 = i11;
                                int iM1894 = d.m1894(i11) ^ d.f1666;
                                int i12 = d.f1663;
                                d.f1663 = iM1894;
                                d.f1666 = i12;
                            }
                            int i13 = d.f1663;
                            int i14 = d.f1666;
                            d.f1663 = i14;
                            d.f1666 = i13;
                            int i15 = i13 ^ iArr2[16];
                            d.f1666 = i15;
                            int i16 = i14 ^ iArr2[17];
                            d.f1663 = i16;
                            cArr[0] = (char) (i16 >>> 16);
                            cArr[1] = (char) i16;
                            cArr[2] = (char) (i15 >>> 16);
                            cArr[3] = (char) i15;
                            d.m1895(iArr2);
                            int i17 = d.f1665;
                            cArr2[i17 << 1] = cArr[0];
                            cArr2[(i17 << 1) + 1] = cArr[1];
                            cArr2[(i17 << 1) + 2] = cArr[2];
                            cArr2[(i17 << 1) + 3] = cArr[3];
                            d.f1665 = i17 + 2;
                        } else {
                            str = new String(cArr2, 0, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m273(String str, int i2) {
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
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f75)) ^ ((c8 >>> 5) + f73)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f74) ^ ((c9 + i9) ^ ((c9 << 4) + f72))));
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
    }

    public aa(JSONObject jSONObject) {
        super(null);
        this.f68 = new WeakHashMap<>();
        this.f69 = new e(this);
        m260(jSONObject);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        f63 = (f61 + 59) % 128;
        try {
            View viewM251 = m251(view, this.f67);
            if (viewM251 != null) {
                f61 = (f63 + 111) % 128;
                m257(viewM251);
                view.removeOnLayoutChangeListener(this);
            }
        } catch (Throwable th) {
            kd.m2919(m256("⋌좉꼊輤丹綕頭\uf4f6矘哇\ue07f\ufddc托䊹꼊輤\ue2f1뎨䈑ᔱ", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 18).intern(), m256("칔ﴮ읧㡓鹍쾉ノ⪓\ue2c3妗⏲侏䚁寧\ua7e6沟톗ꋗ᳠磗犱ꔨ萸乡", Color.alpha(0) + 23).intern(), th, false);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m260(JSONObject jSONObject) {
        e eVar = new e(this, jSONObject);
        m3060((v.b) eVar);
        this.f69 = eVar;
        try {
            this.f67 = Class.forName(e.m272(eVar));
            int i2 = (f61 + 65) % 128;
            f63 = i2;
            int i8 = i2 + 91;
            f61 = i8 % 128;
            int i9 = i8 % 2;
            m255();
            if (i9 == 0) {
                throw null;
            }
        } catch (ClassNotFoundException e4) {
            String strIntern = m256("⋌좉꼊輤丹綕頭\uf4f6矘哇\ue07f\ufddc托䊹꼊輤\ue2f1뎨䈑ᔱ", TextUtils.lastIndexOf("", '0', 0, 0) + 20).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m256("칔ﴮ읧㡓鹍쾉郲겑讌꼟벓쇍ノ⪓\u05ed홧胁\ude8f櫵ꀺ\ue08e溾岜츊\ud8ca烽\uef16惘䊏㲲멽埠", TextUtils.getTrimmedLength("") + 31).intern());
            sb.append(e.m272(eVar));
            sb.append(m256("ḛﱹ", (ViewConfiguration.getEdgeSlop() >> 16) + 2).intern());
            sb.append(e4.getLocalizedMessage());
            k.m2852(strIntern, sb.toString());
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final /* synthetic */ void mo261(View view, List list) {
        f63 = (f61 + 51) % 128;
        m253(view, (List<WebView>) list);
        f61 = (f63 + 53) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final /* synthetic */ View mo262(View view) {
        f63 = (f61 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        View viewM254 = m254(view);
        f61 = (f63 + 111) % 128;
        return viewM254;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m265() {
        int i2 = f61 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f63 = i2 % 128;
        if (i2 % 2 == 0) {
            m3133((s) null);
            ji.m2724().m2728(this);
        } else {
            m3133((s) null);
            ji.m2724().m2728(this);
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m255() {
        f61 = (f63 + 101) % 128;
        ji.m2724().m2727(this);
        f63 = (f61 + 15) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final ab mo263() {
        ac acVar = new ac();
        int i2 = f61 + 53;
        f63 = i2 % 128;
        if (i2 % 2 == 0) {
            return acVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static View m254(View view) {
        int i2 = (f63 + 55) % 128;
        f61 = i2;
        f63 = (i2 + 9) % 128;
        return view;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jl
    /* JADX INFO: renamed from: ﾇ, reason: avoid collision after fix types in other method and contains not printable characters */
    public final void mo264(View view) {
        View viewM252;
        f61 = (f63 + 63) % 128;
        View viewM251 = m251(view, this.f67);
        if (viewM251 != null) {
            int i2 = f63 + 39;
            f61 = i2 % 128;
            if (i2 % 2 != 0) {
                m257(viewM251);
                return;
            } else {
                m257(viewM251);
                throw null;
            }
        }
        if (TextUtils.isEmpty(e.m267(this.f69)) || (viewM252 = m252(view, e.m267(this.f69))) == null) {
            return;
        }
        f63 = (f61 + 113) % 128;
        viewM252.addOnLayoutChangeListener(this);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m257(View view) {
        f61 = (f63 + 3) % 128;
        if (!this.f68.containsKey(view)) {
            int i2 = f61 + 53;
            f63 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f68.put(view, Boolean.TRUE);
                mo3063(view, Integer.toHexString(view.hashCode()));
            } else {
                this.f68.put(view, Boolean.TRUE);
                mo3063(view, Integer.toHexString(view.hashCode()));
                throw null;
            }
        }
        int i8 = f63 + 31;
        f61 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 25 / 0;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final s<WebView, View> mo258() {
        int i2 = f63 + 87;
        int i8 = i2 % 128;
        f61 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        int i9 = i8 + 43;
        f63 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 61 / 0;
        }
        return this;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jl
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void mo259(View view) {
        int i2 = f63 + 67;
        f61 = i2 % 128;
        if (i2 % 2 != 0) {
            View viewM251 = m251(view, this.f67);
            if (viewM251 == null || this.f68.remove(viewM251) == null) {
                return;
            }
            int i8 = f63 + 91;
            f61 = i8 % 128;
            if (i8 % 2 != 0) {
                mo3061(view);
                return;
            } else {
                mo3061(view);
                int i9 = 82 / 0;
                return;
            }
        }
        m251(view, this.f67);
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m256(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f62)) ^ ((c8 >>> 5) + f64)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f65) ^ ((c9 + i9) ^ ((c9 << 4) + f66))));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private View m251(View view, Class cls) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (cls.isAssignableFrom(childAt.getClass())) {
                    return childAt;
                }
                View viewM251 = m251(childAt, cls);
                if (viewM251 != null) {
                    int i8 = (f61 + 39) % 128;
                    f63 = i8;
                    int i9 = i8 + 47;
                    f61 = i9 % 128;
                    if (i9 % 2 != 0) {
                        return viewM251;
                    }
                    throw null;
                }
            }
        }
        f63 = (f61 + 107) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private View m252(View view, String str) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                int i8 = f61 + 5;
                f63 = i8 % 128;
                if (i8 % 2 == 0) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt.getClass().getName().startsWith(str)) {
                        return childAt;
                    }
                    View viewM252 = m252(childAt, str);
                    if (viewM252 != null) {
                        f61 = (f63 + 7) % 128;
                        return viewM252;
                    }
                } else {
                    viewGroup.getChildAt(i2).getClass().getName().startsWith(str);
                    throw null;
                }
            }
        }
        f63 = (f61 + 31) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m253(View view, List<WebView> list) {
        f63 = (f61 + 25) % 128;
        ke.m2934(view, WebView.class, e.m269(this.f69), true, false, null, this.f69.f3131, list);
        int i2 = f61 + 83;
        f63 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }
}
