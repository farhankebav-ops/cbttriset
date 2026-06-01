package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v<T> extends y<WebView, T> {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ab f3107;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private it f3109;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Map<T, ab> f3106 = new WeakHashMap();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private v<T>.b f3108 = new b();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b {

        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private boolean f3122;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private boolean f3123;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private boolean f3124;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private boolean f3125;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private boolean f3126;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private boolean f3127;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private List<String> f3128;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private String f3129;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private boolean f3130;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        protected List<String> f3131 = new ArrayList();

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private boolean f3132;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        public final v<T>.b m3075(boolean z2) {
            this.f3126 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        public final v<T>.b m3076(boolean z2) {
            this.f3127 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        public final v<T>.b m3077(boolean z2) {
            this.f3122 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final v<T>.b m3078(String str) {
            this.f3129 = str;
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final v<T>.b m3080(List<String> list) {
            this.f3128 = list;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final v<T>.b m3083(boolean z2) {
            this.f3130 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final v<T>.b m3084(boolean z2) {
            this.f3124 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final v<T>.b m3085(boolean z2) {
            this.f3132 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final v<T>.b m3079(boolean z2) {
            this.f3125 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final v<T>.b m3081(boolean z2) {
            this.f3123 = z2;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final v<T>.b m3082(List<String> list) {
            if (list != null) {
                this.f3131 = list;
            }
            return this;
        }
    }

    public v(it itVar) {
        this.f3109 = itVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m3059(final JSONObject jSONObject, final T t3, String str) {
        boolean z2 = ((b) this.f3108).f3132 && !TextUtils.isEmpty(((b) this.f3108).f3129);
        ab abVarMo263 = ((b) this.f3108).f3127 ? this.f3106.get(t3) : this.f3107;
        if (abVarMo263 == null) {
            abVarMo263 = mo263();
            if (((b) this.f3108).f3127) {
                this.f3106.put(t3, abVarMo263);
            } else {
                this.f3107 = abVarMo263;
            }
            abVarMo263.m3133(mo258());
        }
        ab abVar = abVarMo263;
        abVar.m287();
        abVar.m289(((b) this.f3108).f3129, ((b) this.f3108).f3128, z2, ((b) this.f3108).f3123, ((b) this.f3108).f3126);
        abVar.m295(str);
        if (!((b) this.f3108).f3124) {
            super.mo293(jSONObject, (Object) null, t3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        mo261(t3, arrayList);
        List<WebView> arrayList2 = new ArrayList<>();
        it itVar = this.f3109;
        if (itVar != null) {
            arrayList2 = itVar.mo1735(t3);
        }
        final List<WebView> listM2806 = jv.m2806(arrayList, arrayList2);
        if (listM2806.isEmpty() || ((b) this.f3108).f3125) {
            View viewMo262 = mo262(t3);
            if (viewMo262 != null) {
                viewMo262.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.ironsource.adqualitysdk.sdk.i.v.1

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f3110 = 1;

                    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                    private static boolean f3111 = true;

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static int f3112 = 0;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static char[] f3113 = {320, 367, 358, 365, 349, 364, 351, 360, 315, 350, 322, 347, 319, 361, 282, 355, 326, 371, 366, 317, 354, 353};

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static boolean f3114 = true;

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static int f3115 = 250;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static String m3064(String str2, int[] iArr, int i2, String str3) throws UnsupportedEncodingException {
                        Object bytes = str3;
                        if (str3 != null) {
                            bytes = str3.getBytes("ISO-8859-1");
                        }
                        byte[] bArr = (byte[]) bytes;
                        Object charArray = str2;
                        if (str2 != null) {
                            charArray = str2.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (m.f2978) {
                            try {
                                char[] cArr2 = f3113;
                                int i8 = f3115;
                                if (f3111) {
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
                                if (f3114) {
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

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            v.this.mo261(t3, arrayList3);
                            if (arrayList3.isEmpty()) {
                                return;
                            }
                            int i15 = f3110 + 81;
                            f3112 = i15 % 128;
                            if (i15 % 2 != 0) {
                                v.this.mo262(t3);
                                throw null;
                            }
                            View viewMo2622 = v.this.mo262(t3);
                            if (viewMo2622 != null && !v.this.f3108.f3125) {
                                f3112 = (f3110 + 17) % 128;
                                viewMo2622.removeOnLayoutChangeListener(this);
                            }
                            v.this.m3058(t3, arrayList3);
                            v.this.mo328(new JSONObject(), arrayList3.get(0), t3);
                            f3110 = (f3112 + 53) % 128;
                        } catch (Throwable th) {
                            kd.m2919(m3064(null, null, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, "\u0086\u0087\u0083\u008a\u0088\u008c\u008b\u008a\u0089\u0088\u0087\u0087\u0086\u0085\u0084\u0083\u0083\u0082\u0081").intern(), m3064(null, null, TextUtils.indexOf("", "", 0, 0) + 127, "\u0087\u0096\u0088\u008c\u0095\u0094\u0093\u0082\u008e\u0092\u008c\u0091\u0088\u008e\u008f\u0088\u0090\u008f\u0086\u008e\u0086\u0086\u008d").intern(), th, false);
                        }
                    }
                });
            }
            if (listM2806.isEmpty()) {
                super.mo293(jSONObject, (Object) null, t3);
                return;
            }
        }
        if (((b) this.f3108).f3122) {
            p.m2968().post(new Runnable() { // from class: com.ironsource.adqualitysdk.sdk.i.v.2
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.m3058(t3, (List<WebView>) listM2806);
                    v.super.mo293(jSONObject, (WebView) listM2806.get(0), t3);
                }
            });
        } else {
            m3058(t3, listM2806);
            super.mo293(jSONObject, listM2806.get(0), t3);
        }
    }

    /* JADX INFO: renamed from: ﻛ */
    public abstract s<WebView, T> mo258();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m3060(v<T>.b bVar) {
        this.f3108 = bVar;
    }

    /* JADX INFO: renamed from: ｋ */
    public abstract void mo261(T t3, List<WebView> list);

    /* JADX INFO: renamed from: ﾇ */
    public abstract View mo262(T t3);

    /* JADX INFO: renamed from: ﾇ */
    public abstract ab mo263();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m3062(it itVar) {
        this.f3109 = itVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public void mo3061(T t3) {
        mo330(new JSONObject(), (((b) this.f3108).f3127 ? this.f3106.get(t3) : this.f3107).m288(), t3);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public void mo3063(T t3, String str) {
        m3059(new JSONObject(), (Object) t3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public void m3058(T t3, List<WebView> list) {
        ab abVar;
        ab abVar2;
        if (((b) this.f3108).f3127) {
            abVar = this.f3106.get(t3);
        } else {
            abVar = this.f3107;
        }
        abVar.m290(list);
        if (((b) this.f3108).f3130) {
            if (((b) this.f3108).f3127) {
                abVar2 = this.f3106.get(t3);
            } else {
                abVar2 = this.f3107;
            }
            abVar2.m295(Integer.toHexString(list.get(0).hashCode()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ironsource.adqualitysdk.sdk.i.y, com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ｋ */
    public final /* synthetic */ void mo293(JSONObject jSONObject, Object obj, Object obj2) {
        super.mo296(jSONObject, (WebView) obj, obj2);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.y
    /* JADX INFO: renamed from: ｋ */
    public final String mo291(T t3) {
        ab abVar;
        if (((b) this.f3108).f3127) {
            abVar = this.f3106.get(t3);
        } else {
            abVar = this.f3107;
        }
        return abVar.mo291(t3);
    }
}
