package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.ironsource.adqualitysdk.sdk.i.kc;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class aq extends AnonymousClass1 {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static aq f367;

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.aq$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private JSONObject f368;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private ax f369;

        /* JADX INFO: renamed from: く, reason: contains not printable characters */
        public final ax m564() {
            return this.f369;
        }

        /* JADX INFO: renamed from: っ, reason: contains not printable characters */
        public final synchronized JSONObject m565() {
            return this.f368;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final void m566(ax axVar) {
            this.f369 = axVar;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public synchronized void mo567(JSONObject jSONObject) {
            this.f368 = jSONObject;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        void mo568();

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        void mo569();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends aq {

        /* JADX INFO: renamed from: リ, reason: contains not printable characters */
        private static int f370 = 1;

        /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
        private static int f371;

        /* JADX INFO: renamed from: ヶ, reason: contains not printable characters */
        private boolean f374;

        /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
        private boolean f375;

        /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
        private int f376;

        /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
        private ak f377;

        /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
        private boolean f378;

        /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
        private List f379;

        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private at f380;

        /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
        private List<at> f381;

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        private List<at> f382;

        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        private a f383;

        /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
        private ao f384;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private Handler f385;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private av f386;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private ap f387;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private iy f388;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private ar f389;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private final int f390;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private final int f391;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private jb f392;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private final int f393;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private final int f394;

        /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
        private static char[] f373 = {';', 'r', 'i', '{', 247, 252, '3', 'e', 'k', 'p', '7', 'k', 'g', 'j', ':', 'j', 'a', 'k', '@', 135, 139, '9', 'j', 'i', 'r', '3', 'g', 'h', 'm', 's', 'i', 'b', 'd', 'c', 'a', 'b', 'g', 'L', 'L', 'p', 'R', 'I', 'c', 'H', 'P', 'k', 'i', 'n', 'q', 'l', 'd', 'i', 'n', '`', 191, 189, 188, 186, 180, 149, 158, 186, 178, 184, 185, 186, 158, '~', 161, 184, 183, 188, 184, '9', 'j', 'i', 'n', 'j', 'g', 'h', 'J', 'H', 'b', 'b', 'e', 'f', ')', '[', 'i', 'n', 'q', 'l', 'T', 'Y', 'n', 'j', 'g', 'h', 'G', 165, 188, 186, 186, 147, 139, 180, 181, 173, 180, 184, 181, 180, 141, 139, 171, 180, 182, 140, 140, 183, 183, 179, 187, ':', 'n', 'k', 'k', '2', 'j', 'r', 138, 270, 263, '0', 'b', 'd', 'l', 'v', 238, 230, 297, 278, 280, 'y', 264, 287, 285, 285, 246, 241, 280, 244, 240, 275, 281, 264, 262, 283, 283, 278, 273, 280, 286, 285, 287, 272, 270, 262, 259, 283, 279, 270, 276, 277, '6', 'm', 'n', 'j', 'J', 'G', 'b', 'j', 'O', 'M', 'f', 'j', 's', '[', 'Y', 'n', 'n', 'i', 'd', 'k', 'q', 'p', 'c', 'b', 'j', 'b', 'j', 'l', '\\', '^', 'k', 'i', 'l', 's', 'j', 'g', 'n', 153, 307, 307, 297, 293, 302};

        /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
        private static int[] f372 = {1356832937, 194551326, -797996867, 93998518, -238452070, 1616176177, 1400581063, 1733771752, -480608407, 485696894, -150383125, 43900332, -744392826, 943419649, 351540760, 1923284178, 857534579, 63360855};

        public e() {
            super((byte) 0);
            m582("\u0000\u0000\u0001", true, new int[]{0, 3, 0, 0}).intern();
            m582("\u0001\u0001\u0000", false, new int[]{3, 3, 147, 1}).intern();
            m582("\u0001\u0000\u0001\u0000", true, new int[]{6, 4, 0, 2}).intern();
            m587(new int[]{654859020, -1475791147}, AndroidCharacter.getMirror('0') - ',').intern();
            m582("\u0000\u0001\u0000\u0001", false, new int[]{10, 4, 0, 0}).intern();
            m582("\u0000\u0001\u0001\u0000", true, new int[]{14, 4, 0, 2}).intern();
            m587(new int[]{-1761020864, -1641972423}, 5 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern();
            m582("\u0000\u0001\u0001", false, new int[]{18, 3, 28, 1}).intern();
            m582("\u0001\u0000\u0000\u0000", false, new int[]{21, 4, 0, 4}).intern();
            TimeUnit timeUnit = TimeUnit.HOURS;
            timeUnit.toMillis(24L);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            this.f394 = (int) timeUnit2.toMillis(5L);
            this.f391 = (int) timeUnit.toMillis(12L);
            this.f393 = (int) timeUnit2.toMillis(3L);
            this.f390 = (int) timeUnit2.toMillis(10L);
            this.f376 = 0;
            this.f379 = null;
            this.f374 = false;
        }

        /* JADX INFO: renamed from: Ύ, reason: contains not printable characters */
        private int m570() {
            f370 = (f371 + 7) % 128;
            int iOptInt = m565().optInt(m587(new int[]{1814862327, 1168861348}, AndroidCharacter.getMirror('0') - ',').intern(), 3);
            int i2 = f370 + 83;
            f371 = i2 % 128;
            if (i2 % 2 == 0) {
                return iOptInt;
            }
            throw null;
        }

        /* JADX INFO: renamed from: K, reason: contains not printable characters */
        private JSONObject m571() {
            String strM2637;
            int i2 = f371 + 25;
            f370 = i2 % 128;
            if (i2 % 2 != 0 ? (strM2637 = this.f392.m2637(m582("\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001", false, new int[]{73, 13, 0, 0}).intern())) != null : (strM2637 = this.f392.m2637(m582("\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0001", false, new int[]{73, 13, 0, 0}).intern())) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(strM2637);
                    f370 = (f371 + 69) % 128;
                    return jSONObject;
                } catch (JSONException unused) {
                }
            }
            return new JSONObject();
        }

        /* JADX INFO: renamed from: Ⅽ, reason: contains not printable characters */
        private synchronized void m572() {
            int i2 = f371 + 65;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            Handler handler = this.f385;
            if (handler != null) {
                handler.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        e.this.m593(true);
                        if (e.m574(e.this) != null) {
                            e.m574(e.this).mo383();
                        }
                        ArrayList arrayList = new ArrayList(e.m577(e.this));
                        int size = arrayList.size();
                        int i8 = 0;
                        int i9 = 0;
                        while (i9 < size) {
                            Object obj = arrayList.get(i9);
                            i9++;
                            ((at) obj).mo383();
                        }
                        e.m577(e.this).clear();
                        ArrayList arrayList2 = new ArrayList(e.m580(e.this));
                        int size2 = arrayList2.size();
                        while (i8 < size2) {
                            Object obj2 = arrayList2.get(i8);
                            i8++;
                            ((at) obj2).mo383();
                        }
                    }
                });
                f371 = (f370 + 107) % 128;
            }
        }

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        public static /* synthetic */ int m573(e eVar) {
            f370 = (f371 + 17) % 128;
            int iM570 = eVar.m570();
            f371 = (f370 + 79) % 128;
            return iM570;
        }

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        public static /* synthetic */ at m574(e eVar) {
            int i2 = f371;
            f370 = (i2 + 67) % 128;
            at atVar = eVar.f380;
            int i8 = i2 + 11;
            f370 = i8 % 128;
            if (i8 % 2 != 0) {
                return atVar;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        public static /* synthetic */ Handler m575(e eVar) {
            int i2 = f370 + 53;
            int i8 = i2 % 128;
            f371 = i8;
            int i9 = i2 % 2;
            Handler handler = eVar.f385;
            if (i9 != 0) {
                throw null;
            }
            f370 = (i8 + 83) % 128;
            return handler;
        }

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        public static /* synthetic */ int m576(e eVar) {
            int i2 = f371;
            f370 = (i2 + 83) % 128;
            int i8 = eVar.f376;
            eVar.f376 = i8 + 1;
            f370 = (i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            return i8;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public static /* synthetic */ List m577(e eVar) {
            int i2 = f370 + 107;
            f371 = i2 % 128;
            int i8 = i2 % 2;
            List<at> list = eVar.f381;
            if (i8 == 0) {
                return list;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public static /* synthetic */ List m580(e eVar) {
            int i2 = f371 + 65;
            int i8 = i2 % 128;
            f370 = i8;
            int i9 = i2 % 2;
            List<at> list = eVar.f382;
            if (i9 == 0) {
                int i10 = 41 / 0;
            }
            f371 = (i8 + 91) % 128;
            return list;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public static /* synthetic */ void m583(e eVar) {
            f370 = (f371 + 29) % 128;
            eVar.m572();
            f371 = (f370 + 75) % 128;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ a m585(e eVar) {
            int i2 = f370 + 75;
            f371 = i2 % 128;
            int i8 = i2 % 2;
            a aVar = eVar.f383;
            if (i8 == 0) {
                return aVar;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static /* synthetic */ jb m589(e eVar) {
            int i2 = f371 + 51;
            f370 = i2 % 128;
            int i8 = i2 % 2;
            jb jbVar = eVar.f392;
            if (i8 != 0) {
                return jbVar;
            }
            throw null;
        }

        /* JADX INFO: renamed from: へ, reason: contains not printable characters */
        public final synchronized iy m590() {
            iy iyVar;
            int i2 = (f370 + 105) % 128;
            f371 = i2;
            iyVar = this.f388;
            f370 = (i2 + 53) % 128;
            return iyVar;
        }

        /* JADX INFO: renamed from: ゥ, reason: contains not printable characters */
        public final int m591() {
            f370 = (f371 + 85) % 128;
            int iOptInt = m565().optInt(m582(null, true, new int[]{140, 3, 181, 3}).intern(), this.f391);
            int i2 = f370 + 81;
            f371 = i2 % 128;
            if (i2 % 2 == 0) {
                return iOptInt;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ト, reason: contains not printable characters */
        public final int m592() {
            f370 = (f371 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            int iOptInt = m565().optInt(m582("\u0001\u0000\u0001", false, new int[]{Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 3, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 2}).intern(), this.f394);
            int i2 = f371 + 21;
            f370 = i2 % 128;
            if (i2 % 2 != 0) {
                return iOptInt;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: リ */
        public final List mo531() {
            f370 = (f371 + 87) % 128;
            if (this.f379 == null) {
                this.f379 = kc.m2908(m565().optJSONArray(m582("\u0000\u0001\u0001\u0000", true, new int[]{14, 4, 0, 2}).intern()), new kc.c<ISAdQualityAdType>() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.8
                    @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    public final /* synthetic */ ISAdQualityAdType mo599(JSONArray jSONArray, int i2) {
                        return ISAdQualityAdType.fromInt(jSONArray.optInt(i2));
                    }
                });
                f371 = (f370 + 47) % 128;
            }
            return this.f379;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ヮ */
        public final boolean mo532() {
            f371 = (f370 + 95) % 128;
            boolean zOptBoolean = m565().optBoolean(m582("\u0001\u0000\u0000\u0000", false, new int[]{21, 4, 0, 4}).intern());
            f370 = (f371 + 51) % 128;
            return zOptBoolean;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ヶ */
        public final long mo533() {
            f370 = (f371 + 93) % 128;
            String strM2637 = this.f392.m2637(m582("\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001", false, new int[]{174, 37, 0, 0}).intern());
            if (TextUtils.isEmpty(strM2637)) {
                return 0L;
            }
            long j = Long.parseLong(strM2637);
            f371 = (f370 + 59) % 128;
            return j;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: 丫 */
        public final int mo534() {
            int iOptInt;
            synchronized (this) {
                iOptInt = m565().optInt(m582("\u0000\u0001\u0001", false, new int[]{18, 3, 28, 1}).intern(), 100);
            }
            return iOptInt;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: 乁 */
        public final boolean mo535() {
            JSONObject jSONObjectM565;
            String strM587;
            int i2 = f371 + 49;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                jSONObjectM565 = m565();
                strM587 = m587(new int[]{-1761020864, -1641972423}, 2 / (ViewConfiguration.getKeyRepeatDelay() >>> 75));
            } else {
                jSONObjectM565 = m565();
                strM587 = m587(new int[]{-1761020864, -1641972423}, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 4);
            }
            boolean zOptBoolean = jSONObjectM565.optBoolean(strM587.intern());
            int i8 = f370 + 89;
            f371 = i8 % 128;
            if (i8 % 2 == 0) {
                return zOptBoolean;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: 爫 */
        public final JSONObject mo536() {
            int i2 = f370 + 61;
            f371 = i2 % 128;
            if (i2 % 2 != 0) {
                m564();
                throw null;
            }
            if (m564() == null) {
                return null;
            }
            JSONObject jSONObjectM732 = m564().m732();
            f371 = (f370 + 107) % 128;
            return jSONObjectM732;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﬤ */
        public final int mo537() {
            f371 = (f370 + 17) % 128;
            int iOptInt = m565().optInt(m582("\u0001\u0000\u0001\u0000", true, new int[]{6, 4, 0, 2}).intern(), this.f393);
            f370 = (f371 + 107) % 128;
            return iOptInt;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
        
            r0 = com.ironsource.adqualitysdk.sdk.i.aq.e.f370 + 45;
            com.ironsource.adqualitysdk.sdk.i.aq.e.f371 = r0 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
        
            if ((r0 % 2) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        
            return m564().m731();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        
            m564().m731();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        
            if (m565() != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        
            if (m565() != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        
            r0 = m565().optString(m587(new int[]{626791679, -1146225870}, (android.view.ViewConfiguration.getTouchSlop() >> 8) + 4).intern());
         */
        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: טּ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String mo538() {
            /*
                r4 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.aq.e.f370
                int r0 = r0 + 89
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.aq.e.f371 = r1
                int r0 = r0 % 2
                r1 = 0
                if (r0 == 0) goto L18
                org.json.JSONObject r0 = r4.m565()
                r2 = 16
                int r2 = r2 / 0
                if (r0 == 0) goto L64
                goto L1e
            L18:
                org.json.JSONObject r0 = r4.m565()
                if (r0 == 0) goto L64
            L1e:
                org.json.JSONObject r0 = r4.m565()
                r2 = 626791679(0x255c14ff, float:1.9089072E-16)
                r3 = -1146225870(0xffffffffbbadfb32, float:-0.005309486)
                int[] r2 = new int[]{r2, r3}
                int r3 = android.view.ViewConfiguration.getTouchSlop()
                int r3 = r3 >> 8
                int r3 = r3 + 4
                java.lang.String r2 = m587(r2, r3)
                java.lang.String r2 = r2.intern()
                java.lang.String r0 = r0.optString(r2)
                boolean r2 = android.text.TextUtils.isEmpty(r0)
                if (r2 == 0) goto L63
                int r0 = com.ironsource.adqualitysdk.sdk.i.aq.e.f370
                int r0 = r0 + 45
                int r2 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.aq.e.f371 = r2
                int r0 = r0 % 2
                if (r0 != 0) goto L5b
                com.ironsource.adqualitysdk.sdk.i.ax r0 = r4.m564()
                java.lang.String r0 = r0.m731()
                return r0
            L5b:
                com.ironsource.adqualitysdk.sdk.i.ax r0 = r4.m564()
                r0.m731()
                throw r1
            L63:
                return r0
            L64:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.aq.e.mo538():java.lang.String");
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: סּ */
        public final synchronized void mo539() {
            this.f385.removeCallbacksAndMessages(null);
            this.f385 = null;
            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.1
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    e.m577(e.this).clear();
                    e.m580(e.this).clear();
                    e.m586(e.this, (at) null);
                }
            });
            int i2 = f371 + 101;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ףּ */
        public final int mo540() {
            JSONObject jSONObjectM565;
            String strM587;
            int i2 = f371 + 45;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                jSONObjectM565 = m565();
                strM587 = m587(new int[]{654859020, -1475791147}, 5 << (ViewConfiguration.getKeyRepeatDelay() * 68));
            } else {
                jSONObjectM565 = m565();
                strM587 = m587(new int[]{654859020, -1475791147}, 4 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
            }
            int iOptInt = jSONObjectM565.optInt(strM587.intern(), this.f390);
            int i8 = f370 + 69;
            f371 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 32 / 0;
            }
            return iOptInt;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﭖ */
        public final ao mo541() {
            int i2 = f370;
            ao aoVar = this.f384;
            int i8 = i2 + 31;
            f371 = i8 % 128;
            if (i8 % 2 == 0) {
                return aoVar;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﭴ */
        public final String mo542() {
            f371 = (f370 + 37) % 128;
            String strOptString = m565().optString(m582("\u0000\u0000\u0001", true, new int[]{0, 3, 0, 0}).intern());
            int i2 = f370 + 97;
            f371 = i2 % 128;
            if (i2 % 2 == 0) {
                return strOptString;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﭸ */
        public final ap mo543() {
            int i2 = f371;
            ap apVar = this.f387;
            f370 = (i2 + 105) % 128;
            return apVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﮉ */
        public final ar mo544() {
            int i2 = f371 + 51;
            f370 = i2 % 128;
            if (i2 % 2 != 0) {
                return this.f389;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﮌ */
        public final av mo545() {
            int i2 = f370;
            av avVar = this.f386;
            int i8 = i2 + 83;
            f371 = i8 % 128;
            if (i8 % 2 == 0) {
                return avVar;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﱟ */
        public final int mo547() {
            ax axVarM564;
            int i2 = f370 + 95;
            f371 = i2 % 128;
            if (i2 % 2 != 0) {
                axVarM564 = m564();
                if (axVarM564 == null) {
                    return 31595;
                }
            } else {
                axVarM564 = m564();
                if (axVarM564 == null) {
                    return 3000;
                }
            }
            int iM730 = axVarM564.m730();
            f370 = (f371 + 109) % 128;
            return iM730;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static void m581(JSONObject jSONObject) {
            f371 = (f370 + 113) % 128;
            kc.m2910(jSONObject, jSONObject.optJSONObject(m582("\u0001\u0001\u0000\u0001\u0000\u0001", false, new int[]{211, 6, 192, 1}).intern()));
            f371 = (f370 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public static /* synthetic */ void m584(JSONObject jSONObject, long j) {
            int i2 = f370 + 57;
            f371 = i2 % 128;
            int i8 = i2 % 2;
            m578(jSONObject, j);
            if (i8 != 0) {
                throw null;
            }
            int i9 = f370 + 97;
            f371 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public static /* synthetic */ at m586(e eVar, at atVar) {
            int i2 = (f370 + 29) % 128;
            f371 = i2;
            eVar.f380 = atVar;
            int i8 = i2 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
            f370 = i8 % 128;
            if (i8 % 2 != 0) {
                return atVar;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﮐ */
        public final synchronized boolean mo546() {
            boolean z2;
            int i2 = f371;
            int i8 = i2 + 85;
            f370 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
            z2 = this.f375;
            int i9 = i2 + 85;
            f370 = i9 % 128;
            if (i9 % 2 == 0) {
                throw null;
            }
            return z2;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﱡ */
        public final boolean mo548() {
            int i2 = f370;
            boolean z2 = this.f378;
            int i8 = i2 + 99;
            f371 = i8 % 128;
            if (i8 % 2 == 0) {
                return z2;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﺙ */
        public final double mo549() throws UnsupportedEncodingException {
            JSONObject jSONObjectM565;
            String strM582;
            int i2 = f370 + 73;
            f371 = i2 % 128;
            if (i2 % 2 != 0) {
                jSONObjectM565 = m565();
                strM582 = m582("\u0001\u0001\u0000", false, new int[]{127, 3, 0, 2});
            } else {
                jSONObjectM565 = m565();
                strM582 = m582("\u0001\u0001\u0000", false, new int[]{127, 3, 0, 2});
            }
            return jSONObjectM565.optDouble(strM582.intern(), 5.0d);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﻏ */
        public final double mo550() {
            f371 = (f370 + 71) % 128;
            double dOptDouble = m565().optDouble(m582("\u0000\u0001\u0000\u0001", false, new int[]{10, 4, 0, 0}).intern(), 1.0d);
            f371 = (f370 + 19) % 128;
            return dOptDouble;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final synchronized void m593(boolean z2) {
            int i2 = (f370 + 31) % 128;
            f371 = i2;
            this.f375 = z2;
            int i8 = i2 + 87;
            f370 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾒ */
        public final void mo562(Context context, iy iyVar, ak akVar, a aVar, boolean z2) {
            this.f392 = new jb(context, m582("\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001", false, new int[]{25, 28, 0, 3}).intern(), m582("\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000", false, new int[]{53, 20, 78, 0}).intern());
            this.f388 = iyVar;
            this.f375 = false;
            this.f378 = z2;
            this.f377 = akVar;
            this.f385 = new Handler(Looper.getMainLooper());
            ax axVar = new ax();
            this.f386 = new av(axVar);
            this.f389 = new ar(axVar);
            this.f387 = new ap(axVar);
            this.f384 = new ao();
            mo567(m571());
            m566(axVar);
            this.f383 = aVar;
            this.f381 = new ArrayList();
            this.f382 = new ArrayList();
            int i2 = f371 + 25;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private au m579(String str) {
            f371 = (f370 + 79) % 128;
            if (str == null) {
                return null;
            }
            au auVar = mo557().get(str);
            int i2 = f371 + 45;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 93 / 0;
            }
            return auVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﻐ */
        public final void mo552(iw iwVar) {
            int i2 = f371 + 79;
            f370 = i2 % 128;
            if (i2 % 2 != 0) {
                m564().m738(iwVar);
            } else {
                m564().m738(iwVar);
                throw null;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ｋ */
        public final void mo555(JSONObject jSONObject) {
            f370 = (f371 + 109) % 128;
            mo567(jSONObject);
            m572();
            f371 = (f370 + 57) % 128;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾇ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void mo558(final android.content.Context r8, final com.ironsource.adqualitysdk.sdk.i.as r9, boolean r10) {
            /*
                r7 = this;
                int r0 = com.ironsource.adqualitysdk.sdk.i.aq.e.f371
                int r0 = r0 + 83
                int r1 = r0 % 128
                com.ironsource.adqualitysdk.sdk.i.aq.e.f370 = r1
                int r0 = r0 % 2
                r1 = 0
                if (r0 != 0) goto L13
                r0 = 36
                int r0 = r0 / r1
                if (r10 == 0) goto L26
                goto L15
            L13:
                if (r10 == 0) goto L26
            L15:
                com.ironsource.adqualitysdk.sdk.i.aq$e$4 r10 = new com.ironsource.adqualitysdk.sdk.i.aq$e$4
                r10.<init>()
                com.ironsource.adqualitysdk.sdk.i.aq r0 = com.ironsource.adqualitysdk.sdk.i.aq.m530()
                int r0 = r0.mo537()
                long r2 = (long) r0
                com.ironsource.adqualitysdk.sdk.i.p.m2970(r10, r2)
            L26:
                r7.m593(r1)
                org.json.JSONObject r10 = new org.json.JSONObject
                r10.<init>()
                r0 = 1
                com.ironsource.adqualitysdk.sdk.i.jr r2 = new com.ironsource.adqualitysdk.sdk.i.jr     // Catch: org.json.JSONException -> L4e
                long r3 = r7.mo533()     // Catch: org.json.JSONException -> L4e
                r2.<init>(r8, r9, r3)     // Catch: org.json.JSONException -> L4e
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4e
                r3.<init>()     // Catch: org.json.JSONException -> L4e
                com.ironsource.adqualitysdk.sdk.i.iy r4 = r7.m590()     // Catch: org.json.JSONException -> L4e
                com.ironsource.adqualitysdk.sdk.i.iv r4 = r4.m2611()     // Catch: org.json.JSONException -> L4e
                boolean r4 = r4.m2571()     // Catch: org.json.JSONException -> L4e
                org.json.JSONObject r10 = r2.mo392(r3, r4, r0, r1)     // Catch: org.json.JSONException -> L4e
                goto L78
            L4e:
                r2 = move-exception
                r3 = 86
                r4 = 12
                int[] r3 = new int[]{r3, r4, r1, r1}
                java.lang.String r4 = "\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000"
                java.lang.String r3 = m582(r4, r1, r3)
                java.lang.String r3 = r3.intern()
                r4 = 25
                r5 = 74
                r6 = 98
                int[] r4 = new int[]{r6, r4, r5, r1}
                java.lang.String r5 = "\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000"
                java.lang.String r4 = m582(r5, r1, r4)
                java.lang.String r4 = r4.intern()
                com.ironsource.adqualitysdk.sdk.i.k.m2861(r3, r4, r2)
            L78:
                com.ironsource.adqualitysdk.sdk.i.iy r2 = r7.m590()
                com.ironsource.adqualitysdk.sdk.i.ak r3 = r7.f377
                r4 = 123(0x7b, float:1.72E-43)
                r5 = 4
                int[] r4 = new int[]{r4, r5, r1, r1}
                java.lang.String r5 = "\u0000\u0001\u0001\u0001"
                java.lang.String r0 = m582(r5, r0, r4)
                java.lang.String r0 = r0.intern()
                java.lang.String r0 = r3.m504(r0)
                com.ironsource.adqualitysdk.sdk.i.aq$e$5 r3 = new com.ironsource.adqualitysdk.sdk.i.aq$e$5
                r3.<init>()
                r2.m2613(r0, r10, r3)
                int r8 = com.ironsource.adqualitysdk.sdk.i.aq.e.f370
                int r8 = r8 + 63
                int r9 = r8 % 128
                com.ironsource.adqualitysdk.sdk.i.aq.e.f371 = r9
                int r8 = r8 % 2
                if (r8 == 0) goto Laa
                r8 = 52
                int r8 = r8 / r1
            Laa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.aq.e.mo558(android.content.Context, com.ironsource.adqualitysdk.sdk.i.as, boolean):void");
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﻐ */
        public final void mo551(final at atVar) {
            f370 = (f371 + 21) % 128;
            Handler handler = this.f385;
            if (handler != null) {
                handler.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.9
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        if (e.this.mo546()) {
                            atVar.mo383();
                        } else {
                            e.m577(e.this).add(atVar);
                        }
                    }
                });
                f371 = (f370 + 45) % 128;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ｋ */
        public final void mo554(final at atVar) {
            f371 = (f370 + 37) % 128;
            Handler handler = this.f385;
            if (handler != null) {
                handler.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.7
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        e.m586(e.this, atVar);
                        if (e.this.mo546()) {
                            atVar.mo383();
                        }
                    }
                });
            }
            f371 = (f370 + 111) % 128;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﻐ */
        public final boolean mo553() {
            f370 = (f371 + 93) % 128;
            boolean zOptBoolean = m565().optBoolean(m587(new int[]{-299846367, 901062462}, View.MeasureSpec.getMode(0) + 3).intern(), false);
            int i2 = f370 + 35;
            f371 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 39 / 0;
            }
            return zOptBoolean;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static void m578(JSONObject jSONObject, long j) {
            int i2 = f371 + 9;
            f370 = i2 % 128;
            if (i2 % 2 == 0) {
                if (!jSONObject.has(m587(new int[]{-440044683, -812843744}, 5 / Color.alpha(0)).intern())) {
                    return;
                }
            } else if (!jSONObject.has(m587(new int[]{-440044683, -812843744}, 3 - Color.alpha(0)).intern())) {
                return;
            }
            try {
                jSONObject.put(m587(new int[]{-440044683, -812843744}, KeyEvent.normalizeMetaState(0) + 3).intern(), jSONObject.optLong(m587(new int[]{-440044683, -812843744}, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2).intern()) + (j / 2));
                f370 = (f371 + 31) % 128;
            } catch (JSONException unused) {
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ｋ */
        public final boolean mo556() {
            int i2 = f371 + 99;
            f370 = i2 % 128;
            boolean zOptBoolean = i2 % 2 == 0 ? m565().optBoolean(m582("\u0001\u0000\u0001\u0000", false, new int[]{Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 4, 0, 4}).intern(), false) : m565().optBoolean(m582("\u0001\u0000\u0001\u0000", true, new int[]{Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 4, 0, 4}).intern(), true);
            f371 = (f370 + 85) % 128;
            return zOptBoolean;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static String m582(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
            String str2;
            Object bytes = str;
            if (str != null) {
                bytes = str.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            synchronized (g.f2126) {
                try {
                    int i2 = iArr[0];
                    int i8 = iArr[1];
                    int i9 = iArr[2];
                    int i10 = iArr[3];
                    char[] cArr = new char[i8];
                    System.arraycopy(f373, i2, cArr, 0, i8);
                    if (bArr != null) {
                        char[] cArr2 = new char[i8];
                        g.f2125 = 0;
                        char c7 = 0;
                        while (true) {
                            int i11 = g.f2125;
                            if (i11 >= i8) {
                                break;
                            }
                            if (bArr[i11] == 1) {
                                cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                            } else {
                                cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                            }
                            c7 = cArr2[i11];
                            g.f2125 = i11 + 1;
                        }
                        cArr = cArr2;
                    }
                    if (i10 > 0) {
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr, 0, cArr3, 0, i8);
                        int i12 = i8 - i10;
                        System.arraycopy(cArr3, 0, cArr, i12, i10);
                        System.arraycopy(cArr3, i10, cArr, 0, i12);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        g.f2125 = 0;
                        while (true) {
                            int i13 = g.f2125;
                            if (i13 >= i8) {
                                break;
                            }
                            cArr4[i13] = cArr[(i8 - i13) - 1];
                            g.f2125 = i13 + 1;
                        }
                        cArr = cArr4;
                    }
                    if (i9 > 0) {
                        g.f2125 = 0;
                        while (true) {
                            int i14 = g.f2125;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr[i14] = (char) (cArr[i14] - iArr[2]);
                            g.f2125 = i14 + 1;
                        }
                    }
                    str2 = new String(cArr);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾇ */
        public final void mo559(final at atVar) {
            f370 = (f371 + 115) % 128;
            Handler handler = this.f385;
            if (handler != null) {
                handler.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.2
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        e.m580(e.this).add(atVar);
                        if (e.this.mo546()) {
                            atVar.mo383();
                        }
                    }
                });
                f371 = (f370 + 81) % 128;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾇ */
        public final Map<String, au> mo557() {
            HashMap map = new HashMap();
            try {
                String strOptString = m565().optString(m587(new int[]{2078833056, -1220890097}, View.combineMeasuredStates(0, 0) + 3).intern());
                if (TextUtils.isEmpty(strOptString)) {
                    return map;
                }
                Map<String, au> mapM2902 = kc.m2902(new JSONObject(strOptString), new kc.b<au>() { // from class: com.ironsource.adqualitysdk.sdk.i.aq.e.10
                    @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    public final /* synthetic */ au mo595(JSONObject jSONObject, String str) {
                        return new au(jSONObject.optJSONObject(str));
                    }
                });
                f371 = (f370 + 99) % 128;
                return mapM2902;
            } catch (JSONException e) {
                kd.m2919(m582("\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", false, new int[]{86, 12, 0, 0}).intern(), m582("\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001", false, new int[]{143, 31, 173, 0}).intern(), e, false);
                return map;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq.AnonymousClass1
        /* JADX INFO: renamed from: ﾒ */
        public final synchronized void mo567(JSONObject jSONObject) {
            try {
                f370 = (f371 + 85) % 128;
                if (m588(jSONObject)) {
                    m581(jSONObject);
                }
                super.mo567(jSONObject);
                this.f386.mo567(jSONObject);
                this.f389.mo567(jSONObject);
                this.f387.mo567(jSONObject);
                this.f384.mo567(jSONObject);
                int i2 = f371 + 115;
                f370 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾇ */
        public final boolean mo560(String str, String str2) {
            au auVarM579 = m579(str);
            if (auVarM579 == null) {
                return true;
            }
            int i2 = f370 + 107;
            f371 = i2 % 128;
            if (i2 % 2 != 0) {
                auVarM579.m634(str2);
                throw null;
            }
            if (!auVarM579.m634(str2)) {
                return true;
            }
            int i8 = f370 + 23;
            f371 = i8 % 128;
            if (i8 % 2 == 0) {
                return false;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾒ */
        public final boolean mo563() {
            int i2 = f371 + 37;
            f370 = i2 % 128;
            boolean zOptBoolean = i2 % 2 == 0 ? m565().optBoolean(m582("\u0001\u0000\u0001", true, new int[]{Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 3, 163, 3}).intern(), false) : m565().optBoolean(m582("\u0001\u0000\u0001", false, new int[]{Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 3, 163, 3}).intern(), true);
            int i8 = f371 + 51;
            f370 = i8 % 128;
            if (i8 % 2 != 0) {
                return zOptBoolean;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final void m594(long j) {
            int i2 = f370 + 25;
            int i8 = i2 % 128;
            f371 = i8;
            if (i2 % 2 != 0) {
                int i9 = 46 / 0;
                if (this.f374) {
                    return;
                }
            } else if (this.f374) {
                return;
            }
            f370 = (i8 + 11) % 128;
            this.f392.m2639(m582("\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001", false, new int[]{174, 37, 0, 0}).intern(), String.valueOf(j));
            this.f374 = true;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.aq
        /* JADX INFO: renamed from: ﾒ */
        public final String mo561(String str) {
            au auVarM579 = m579(str);
            if (auVarM579 == null) {
                return null;
            }
            f371 = (f370 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
            String strM635 = auVarM579.m635();
            int i2 = f371 + 19;
            f370 = i2 % 128;
            if (i2 % 2 != 0) {
                return strM635;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static boolean m588(JSONObject jSONObject) {
            int i2 = f370 + 55;
            f371 = i2 % 128;
            return jSONObject.has((i2 % 2 != 0 ? m582("\u0001\u0001\u0000\u0001\u0000\u0001", false, new int[]{211, 6, 192, 1}) : m582("\u0001\u0001\u0000\u0001\u0000\u0001", false, new int[]{211, 6, 192, 1})).intern());
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m587(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f372.clone();
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
    }

    public /* synthetic */ aq(byte b8) {
        this();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static synchronized aq m530() {
        try {
            if (f367 == null) {
                f367 = new e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f367;
    }

    /* JADX INFO: renamed from: リ, reason: contains not printable characters */
    public abstract List mo531();

    /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
    public abstract boolean mo532();

    /* JADX INFO: renamed from: ヶ, reason: contains not printable characters */
    public abstract long mo533();

    /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
    public abstract int mo534();

    /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
    public abstract boolean mo535();

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    public abstract JSONObject mo536();

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    public abstract int mo537();

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    public abstract String mo538();

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    public abstract void mo539();

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    public abstract int mo540();

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public abstract ao mo541();

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public abstract String mo542();

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public abstract ap mo543();

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public abstract ar mo544();

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public abstract av mo545();

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public abstract boolean mo546();

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public abstract int mo547();

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public abstract boolean mo548();

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public abstract double mo549();

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public abstract double mo550();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public abstract void mo551(at atVar);

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public abstract void mo552(iw iwVar);

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public abstract boolean mo553();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract void mo554(at atVar);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract void mo555(JSONObject jSONObject);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract boolean mo556();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public abstract Map<String, au> mo557();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public abstract void mo558(Context context, as asVar, boolean z2);

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public abstract void mo559(at atVar);

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public abstract boolean mo560(String str, String str2);

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public abstract String mo561(String str);

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public abstract void mo562(Context context, iy iyVar, ak akVar, a aVar, boolean z2);

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public abstract boolean mo563();

    private aq() {
    }
}
