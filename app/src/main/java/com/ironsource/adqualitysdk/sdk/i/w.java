package com.ironsource.adqualitysdk.sdk.i;

import android.R;
import android.app.Activity;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.v;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends v<Activity> implements jg {

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static char f3133 = 0;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char f3134 = 0;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f3135 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f3136;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char f3137;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f3138;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String f3139;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private boolean f3140;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private boolean f3141;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private a f3142;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private boolean f3143;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private jg f3144;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f3145;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Class f3146;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends v.b {

        /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
        private static int f3177 = 0;

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        private static int f3178 = 1;

        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        private static char f3179 = 1862;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static char f3180 = 46277;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static char f3181 = 31727;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static long f3182 = -210346782525895221L;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static char f3183 = 3767;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private boolean f3184 = false;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private boolean f3185;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private int f3186;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private String f3187;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private String f3188;

        public a(w wVar, JSONObject jSONObject) {
            m3122(jSONObject.optString(m3119("춪韢礐썏ꒋร큳떹ῗ\ue107䪇⳥\uf63a塇", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 23116).intern()));
            m3120(jSONObject.optString(m3119("춼\uedff贋굮䳦氻ౚ⾿켯\uef73躒껃义榷ৈ⤑좋\ue8d8蠜ꮮ䯶欖", 8273 - KeyEvent.keyCodeFromString("")).intern()));
            m3124(jSONObject.optInt(m3119("춼䏍텯暴\uf42eੁ鯮⤷뺷", (ViewConfiguration.getScrollBarSize() >> 8) + 36451).intern(), -1));
            m3117(jSONObject.optBoolean(m3126("쭲\uf1b4龭㮁샍꣩퇤종ﻙ\ue45a퇎⣵큌柢\u171d쐑\ude6a蓨", 17 - View.MeasureSpec.getMode(0)).intern()));
            m3116(jSONObject.optBoolean(m3119("춪\ue825蚥봯实癦⳩쭲\ue1c2鱝먢傷༙▍쀹ﻭ長돷湘", 9614 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern()));
            m3078(jSONObject.optString(m3119("춡\u0ff3䤉譅쒮ے䁣鶣\udff0ᤜ", View.combineMeasuredStates(0, 0) + 49739).intern()));
            m3080(TextUtils.isEmpty(jSONObject.optString(m3126("폱똋㱤ᩬ巭笪鯘黣䈤曥", 9 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)).intern())) ? null : Arrays.asList(jSONObject.optString(m3126("폱똋㱤ᩬ巭笪鯘黣䈤曥", (ViewConfiguration.getScrollBarSize() >> 8) + 9).intern()).split(m3119("췧", ExpandableListView.getPackedPositionChild(0L) + 62274).intern())));
            m3083(jSONObject.optBoolean(m3119("춾ͱ值ꇇ\uf68a쑄ᔫ櫝믦袭\ude59⼉糔䶖", 52937 - TextUtils.getOffsetAfter("", 0)).intern()));
            boolean z2 = true;
            m3085(jSONObject.optBoolean(m3126("\ue92bﻒ闚ꨘ鉶緐ٍ䣸藷툆\uf195鍗渿蘐", 13 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), true));
            if (TextUtils.isEmpty(jSONObject.optString(m3119("춡\u0ff3䤉譅쒮ے䁣鶣\udff0ᤜ", TextUtils.getOffsetBefore("", 0) + 49739).intern())) && !jSONObject.optBoolean(m3119("춾棙蝬㶿堪\uf74cⷛ䠅\ue6a6ᷕ롂회മꡃ웫紐", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 42337).intern()) && !jSONObject.optBoolean(m3126("\ue92bﻒ疇訝ᩜ\u187c￠ዳ椶\uf2c8맹汉視崨\uf78e牳崤⇢", TextUtils.getOffsetBefore("", 0) + 18).intern())) {
                z2 = false;
            }
            m3084(z2);
            m3081(jSONObject.optBoolean(m3119("춾棙蝬㶿堪\uf74cⷛ䠅\ue6a6ᷕ롂회മꡃ웫紐", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 42337).intern()));
            m3075(jSONObject.optBoolean(m3119("춾⪅ϔ砹兇䦎ꛗ鼁\uf469\uec9d", 59197 - TextUtils.getOffsetBefore("", 0)).intern()));
            m3079(jSONObject.optBoolean(m3126("\ue92bﻒ\uef68遅杖\ue853眹俧㨟ꃚ疇訝ᩜ\u187c䞵≦饫㍮㭍훷", TextUtils.lastIndexOf("", '0') + 20).intern()));
            m3076(jSONObject.optBoolean(m3119("춦妁\ue5d9焂鵞⢀득쀗決ﮒߎ錊㽞䪖훚戟蹈", 37952 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern()));
            m3077(jSONObject.optBoolean(m3126("䀔\ue2eb둄궀\ud91d牆\ueac3櫰渿蘐", 9 - View.MeasureSpec.getSize(0)).intern()));
            m3082(kc.m2911(jSONObject.optJSONArray(m3119("춽霙磘\udd8dꝔ࠸\uedc6뚟ᡴﴶ䛪⮰赪", 23227 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern())));
        }

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private a m3116(boolean z2) {
            int i2 = (f3177 + 73) % 128;
            f3178 = i2;
            this.f3184 = z2;
            int i8 = i2 + 53;
            f3177 = i8 % 128;
            if (i8 % 2 == 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private a m3117(boolean z2) {
            int i2 = f3178;
            this.f3185 = z2;
            f3177 = (i2 + 53) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public static /* synthetic */ int m3118(a aVar) {
            int i2 = (f3178 + 11) % 128;
            f3177 = i2;
            int i8 = aVar.f3186;
            f3178 = (i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            return i8;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public static /* synthetic */ boolean m3121(a aVar) {
            int i2 = (f3177 + 93) % 128;
            f3178 = i2;
            boolean z2 = aVar.f3185;
            int i8 = i2 + 41;
            f3177 = i8 % 128;
            if (i8 % 2 == 0) {
                return z2;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public static /* synthetic */ String m3123(a aVar) {
            int i2 = (f3178 + 53) % 128;
            f3177 = i2;
            String str = aVar.f3187;
            f3178 = (i2 + 89) % 128;
            return str;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ String m3125(a aVar) {
            int i2 = f3177;
            f3178 = (i2 + 1) % 128;
            String str = aVar.f3188;
            int i8 = i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f3178 = i8 % 128;
            if (i8 % 2 != 0) {
                return str;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static /* synthetic */ boolean m3127(a aVar) {
            int i2 = f3177;
            f3178 = (i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            boolean z2 = aVar.f3184;
            int i8 = i2 + 91;
            f3178 = i8 % 128;
            if (i8 % 2 != 0) {
                return z2;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m3119(String str, int i2) {
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
                            cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f3182);
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

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private a m3120(String str) {
            int i2 = f3178 + 99;
            f3177 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f3187 = str;
                return this;
            }
            this.f3187 = str;
            int i8 = 2 / 0;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private a m3122(String str) {
            int i2 = f3178 + 73;
            f3177 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f3188 = str;
                return this;
            }
            this.f3188 = str;
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private a m3124(int i2) {
            int i8 = (f3178 + 9) % 128;
            f3177 = i8;
            this.f3186 = i2;
            int i9 = i8 + 27;
            f3178 = i9 % 128;
            if (i9 % 2 != 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m3126(String str, int i2) {
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
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f3183)) ^ ((c8 >>> 5) + f3179)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f3180) ^ ((c9 + i9) ^ ((c9 << 4) + f3181))));
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

    static {
        m3086();
        f3139 = m3103("⸂莇䀰嬙繽敧낙\uf52d者좨ȅ뎥\ue1ef䁢䩼鴀䃀ᷮꋔ蘥ꉦ⌼瓢ᑒ뮒ʱ\uf476眎뮒ʱ\uf476眎ꃁ䆩\ue421腤㣈堂\ue5f0⍙", 39 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern();
        int i2 = f3136 + 81;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public w(JSONObject jSONObject, it itVar) {
        super(itVar);
        this.f3143 = false;
        this.f3145 = false;
        this.f3141 = false;
        this.f3140 = false;
        m3113(jSONObject);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static void m3086() {
        f3133 = (char) 10632;
        f3138 = (char) 43474;
        f3134 = (char) 58198;
        f3137 = (char) 32457;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ String m3087() {
        int i2 = f3136;
        int i8 = i2 + 31;
        f3135 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = f3139;
        int i9 = i2 + 59;
        f3135 = i9 % 128;
        if (i9 % 2 != 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3089(w wVar) {
        int i2 = f3135 + 93;
        f3136 = i2 % 128;
        int i8 = i2 % 2;
        boolean z2 = wVar.f3141;
        if (i8 != 0) {
            int i9 = 14 / 0;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private jg m3090() {
        int i2 = f3136;
        int i8 = i2 + 13;
        f3135 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        jg jgVar = this.f3144;
        int i9 = i2 + 65;
        f3135 = i9 % 128;
        if (i9 % 2 != 0) {
            return jgVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ jg m3092(w wVar) {
        int i2 = f3136 + 45;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            wVar.m3090();
            throw null;
        }
        jg jgVarM3090 = wVar.m3090();
        f3136 = (f3135 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return jgVarM3090;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ a m3098(w wVar) {
        int i2 = f3136 + 43;
        int i8 = i2 % 128;
        f3135 = i8;
        int i9 = i2 % 2;
        a aVar = wVar.f3142;
        if (i9 == 0) {
            int i10 = 73 / 0;
        }
        f3136 = (i8 + 89) % 128;
        return aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
        m3093(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.4
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).onActivityCreated(activity, bundle);
                    w.m3100();
                    w.m3101(w.this, false);
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        w.m3097(w.this, false);
                        return;
                    }
                    w.m3097(w.this, bundle2.getBoolean(w.m3087()));
                    if (w.m3105(w.this)) {
                        w.m3101(w.this, true);
                    }
                    w.m3108(w.this, true);
                }
            }
        });
        f3136 = (f3135 + 77) % 128;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(final Activity activity) {
        m3093(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.5.3
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            w.m3092(w.this).onActivityDestroyed(activity);
                        }
                    });
                    if (w.m3095(w.this) && w.m3105(w.this) && activity.isFinishing()) {
                        w.this.m3110(activity);
                    }
                }
            }
        });
        int i2 = f3136 + 59;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 7 / 0;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(final Activity activity) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.8
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).onActivityPaused(activity);
                }
            }
        });
        int i2 = f3136 + 65;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity activity) {
        m3093(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.9
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.9.5
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            w.m3092(w.this).onActivityResumed(activity);
                        }
                    });
                    w.m3106(w.this, false);
                    w.m3101(w.this, true);
                    if ((!w.m3105(w.this) || w.m3107(w.this)) && !activity.isFinishing()) {
                        w wVar = w.this;
                        Activity activity2 = activity;
                        wVar.m3112(activity2, w.m3102(activity2));
                    }
                    w.m3108(w.this, false);
                }
            }
        });
        int i2 = f3136 + 5;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 26 / 0;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        m3093(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.6
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).onActivitySaveInstanceState(activity, bundle);
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        bundle2.putBoolean(w.m3087(), w.m3105(w.this));
                    }
                    w.m3106(w.this, true);
                }
            }
        });
        int i2 = f3136 + 77;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(final Activity activity) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.10
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).onActivityStarted(activity);
                }
            }
        });
        int i2 = f3135 + 69;
        f3136 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 92 / 0;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(final Activity activity) {
        m3093(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.7
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.7.2
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            w.m3092(w.this).onActivityStopped(activity);
                        }
                    });
                    if (w.m3095(w.this) && !w.m3089(w.this) && activity.isFinishing()) {
                        w.this.m3110(activity);
                    }
                }
            }
        });
        f3135 = (f3136 + 57) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﻛ */
    public final /* synthetic */ void mo3061(Activity activity) {
        int i2 = f3135 + 5;
        f3136 = i2 % 128;
        int i8 = i2 % 2;
        m3110(activity);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f3135 + 17;
        f3136 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﾇ */
    public final /* synthetic */ View mo262(Activity activity) {
        f3135 = (f3136 + 5) % 128;
        View viewM3094 = m3094(activity);
        int i2 = f3135 + 31;
        f3136 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 46 / 0;
        }
        return viewM3094;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﾒ */
    public final /* synthetic */ void mo3063(Activity activity, String str) {
        int i2 = f3136 + 45;
        f3135 = i2 % 128;
        int i8 = i2 % 2;
        m3112(activity, str);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f3135 + 97;
        f3136 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static String m3088(Activity activity) {
        f3136 = (f3135 + 7) % 128;
        String hexString = Integer.toHexString(activity.hashCode());
        int i2 = f3135 + 83;
        f3136 = i2 % 128;
        if (i2 % 2 == 0) {
            return hexString;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private boolean m3091(Activity activity) {
        f3135 = (f3136 + 53) % 128;
        Class<?> cls = activity.getClass();
        if (this.f3146 != null) {
            return a.m3121(this.f3142) ? this.f3146.equals(cls) : this.f3146.isAssignableFrom(cls);
        }
        int i2 = f3136 + 23;
        f3135 = i2 % 128;
        if (i2 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3095(w wVar) {
        int i2 = f3136;
        f3135 = (i2 + 63) % 128;
        boolean z2 = wVar.f3145;
        int i8 = i2 + 79;
        f3135 = i8 % 128;
        if (i8 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ Class m3099(w wVar, Class cls) {
        int i2 = f3135 + 101;
        f3136 = i2 % 128;
        int i8 = i2 % 2;
        wVar.f3146 = cls;
        if (i8 == 0) {
            return cls;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: avoid collision after fix types in other method and contains not printable characters */
    public static /* synthetic */ String m3102(Activity activity) {
        int i2 = f3136 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f3135 = i2 % 128;
        int i8 = i2 % 2;
        String strM3088 = m3088(activity);
        if (i8 == 0) {
            int i9 = 17 / 0;
        }
        return strM3088;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3107(w wVar) {
        int i2 = (f3136 + 75) % 128;
        f3135 = i2;
        boolean z2 = wVar.f3140;
        int i8 = i2 + 101;
        f3136 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 19 / 0;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m3109() {
        int i2 = f3136 + 111;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            m3133((s) null);
            m3111((jg) null);
            jf.m2685().m2689(this);
            throw null;
        }
        m3133((s) null);
        m3111((jg) null);
        jf.m2685().m2689(this);
        int i8 = f3135 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f3136 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 96 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3096(w wVar, Activity activity) {
        f3136 = (f3135 + 45) % 128;
        boolean zM3091 = wVar.m3091(activity);
        int i2 = f3136 + 101;
        f3135 = i2 % 128;
        if (i2 % 2 != 0) {
            return zM3091;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3105(w wVar) {
        int i2 = f3136 + 9;
        int i8 = i2 % 128;
        f3135 = i8;
        int i9 = i2 % 2;
        boolean z2 = wVar.f3143;
        if (i9 == 0) {
            throw null;
        }
        f3136 = (i8 + 9) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3108(w wVar, boolean z2) {
        int i2 = (f3135 + 53) % 128;
        f3136 = i2;
        wVar.f3140 = z2;
        int i8 = i2 + 43;
        f3135 = i8 % 128;
        if (i8 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ｋ */
    public final /* synthetic */ void mo261(Activity activity, List list) {
        int i2 = f3135 + 77;
        f3136 = i2 % 128;
        int i8 = i2 % 2;
        m3104(activity, (List<WebView>) list);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3097(w wVar, boolean z2) {
        int i2 = f3135 + 1;
        int i8 = i2 % 128;
        f3136 = i8;
        int i9 = i2 % 2;
        wVar.f3143 = z2;
        if (i9 != 0) {
            throw null;
        }
        f3135 = (i8 + 107) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3100() {
        f3135 = (f3136 + 31) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3106(w wVar, boolean z2) {
        int i2 = (f3136 + 115) % 128;
        f3135 = i2;
        wVar.f3141 = z2;
        int i8 = i2 + 93;
        f3136 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 64 / 0;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m3114() {
        int i2 = f3136 + 101;
        f3135 = i2 % 128;
        if (i2 % 2 != 0) {
            jf.m2685().m2686(this);
        } else {
            jf.m2685().m2686(this);
            int i8 = 3 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m3101(w wVar, boolean z2) {
        int i2 = f3136 + 59;
        f3135 = i2 % 128;
        int i8 = i2 % 2;
        wVar.f3145 = z2;
        if (i8 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m3111(jg jgVar) {
        int i2 = f3135;
        this.f3144 = jgVar;
        f3136 = (i2 + 33) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m3113(JSONObject jSONObject) {
        a aVar = new a(this, jSONObject);
        m3060((v.b) aVar);
        this.f3142 = aVar;
        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.3

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static int f3153 = 1;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f3154 = 0;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f3155 = 0;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static long f3156 = 0;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static char f3157 = 46398;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m3115(String str, int i2, String str2, String str3, char c7) {
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
                        char[] cArr4 = (char[]) cArr2.clone();
                        char[] cArr5 = (char[]) cArr.clone();
                        cArr4[0] = (char) (c7 ^ cArr4[0]);
                        cArr5[2] = (char) (cArr5[2] + ((char) i2));
                        int length = cArr3.length;
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
                                cArr6[i12] = (char) (((((long) (c9 ^ cArr3[i12])) ^ f3156) ^ ((long) f3154)) ^ ((long) f3157));
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                try {
                    w wVar = w.this;
                    w.m3099(wVar, Class.forName(a.m3125(w.m3098(wVar))));
                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.3.2
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            w.this.m3114();
                        }
                    });
                    f3153 = (f3155 + 75) % 128;
                } catch (ClassNotFoundException e) {
                    String strIntern = m3115("俛宩⺵눭鵳晣끾댶须Ƛῠﬕ\udb1a꼍傲뒝㩲", TextUtils.indexOf((CharSequence) "", '0') + 1996300716, "\uabfcﴡ륶쉚", "\u0000\u0000\u0000\u0000", (char) (View.resolveSize(0, 0) + 23225)).intern();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m3115("\ue0c8ᇒ\u20c1폩\uf5db\u0af6샕\uf83dꊊ叇튚链ꝡ캩媴ᭉⵘ釄닮ꕫ煻癚䖧⚹晱＜\uf093ᕒ併", (-1712183083) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), "풼\uf228⪙\uef70", "\u0000\u0000\u0000\u0000", (char) (ExpandableListView.getPackedPositionChild(0L) + 28715)).intern());
                    sb.append(a.m3125(w.m3098(w.this)));
                    sb.append(m3115("ྐྵ辉", ViewConfiguration.getLongPressTimeout() >> 16, "\u1718項❢㽱", "\u0000\u0000\u0000\u0000", (char) (28967 - View.combineMeasuredStates(0, 0))).intern());
                    sb.append(e.getLocalizedMessage());
                    k.m2863(strIntern, sb.toString());
                }
            }
        });
        int i2 = f3135 + 91;
        f3136 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 89 / 0;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jg
    /* JADX INFO: renamed from: ﾒ */
    public final void mo484(final Activity activity) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).mo484(activity);
                }
            }
        });
        f3135 = (f3136 + 71) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: avoid collision after fix types in other method and contains not printable characters */
    private static View m3094(Activity activity) {
        int i2 = f3135 + 89;
        f3136 = i2 % 128;
        if (i2 % 2 == 0) {
            return activity.findViewById(R.id.content);
        }
        activity.findViewById(R.id.content);
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jg
    /* JADX INFO: renamed from: ｋ */
    public final void mo483(final Activity activity) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.w.1
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (w.m3096(w.this, activity)) {
                    w.m3092(w.this).mo483(activity);
                }
            }
        });
        int i2 = f3135 + 49;
        f3136 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 47 / 0;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﻛ */
    public final s<WebView, Activity> mo258() {
        int i2 = (f3136 + 61) % 128;
        f3135 = i2;
        int i8 = i2 + 113;
        f3136 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 4 / 0;
        }
        return this;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m3093(iu iuVar) {
        f3135 = (f3136 + 45) % 128;
        if (a.m3127(this.f3142)) {
            p.m2967(iuVar);
            int i2 = f3136 + 9;
            f3135 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            return;
        }
        p.m2969(iuVar);
        int i8 = f3136 + 111;
        f3135 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 78 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m3104(Activity activity, List<WebView> list) {
        int i2 = f3136 + 57;
        f3135 = i2 % 128;
        if (i2 % 2 == 0) {
            ke.m2933(activity, WebView.class, a.m3118(this.f3142), a.m3123(this.f3142), false, false, null, this.f3142.f3131, list);
        } else {
            ke.m2933(activity, WebView.class, a.m3118(this.f3142), a.m3123(this.f3142), false, false, null, this.f3142.f3131, list);
        }
        int i8 = f3136 + 7;
        f3135 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m3112(Activity activity, String str) {
        if (!this.f3143) {
            int i2 = f3136 + 39;
            f3135 = i2 % 128;
            int i8 = i2 % 2;
            this.f3143 = true;
            super.mo3063(activity, str);
            int i9 = f3135 + 75;
            f3136 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ig.f2473, true);
        } catch (JSONException e) {
            String strIntern = m3103("藋湇\u3101鎕巓\ue0ad瓢ᑒꃁ䆩盼\u173c⎸沴숗詈嶼옣", 17 - Drawable.resolveOpacity(0, 0)).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m3103("ꈑ扫兂\u171d⭉㏦ᔸ茴\uf61d\uf5fd嗚頁粜\uf21e푆♢ⷃ糀⏁∻⎸沴㽛㱠\uf4c3ᑉ楮辴낙\uf52d\ueaca༆", ExpandableListView.getPackedPositionType(0L) + 32).intern());
            sb.append(e.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
        }
        m3059(jSONObject, activity, str);
        int i10 = f3136 + 1;
        f3135 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 10 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m3110(Activity activity) {
        int i2 = f3136 + 61;
        f3135 = i2 % 128;
        int i8 = i2 % 2;
        super.mo3061(activity);
        this.f3143 = false;
        f3135 = (f3136 + 33) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.v
    /* JADX INFO: renamed from: ﾇ */
    public final ab mo263() {
        z zVar = new z();
        f3135 = (f3136 + 53) % 128;
        return zVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m3103(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f3133)) ^ ((c8 >>> 5) + f3134)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f3138) ^ ((c9 + i9) ^ ((c9 << 4) + f3137))));
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
