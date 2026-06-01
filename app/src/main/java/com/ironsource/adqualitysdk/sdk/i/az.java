package com.ironsource.adqualitysdk.sdk.i;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.adqualitysdk.sdk.i.ay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class az {

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Map<String, ay> f650 = new HashMap();

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.az$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass4 extends iu {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private /* synthetic */ String f657;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private /* synthetic */ ay.d f658;

        public AnonymousClass4(String str, ay.d dVar) {
            this.f657 = str;
            this.f658 = dVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            ay ayVarM757 = az.m757(az.this, this.f657);
            if (ayVarM757 != null) {
                ayVarM757.m749(this.f658);
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.az$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass5 extends iu {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private /* synthetic */ ay.a f660;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private /* synthetic */ String f661;

        public AnonymousClass5(String str, ay.a aVar) {
            this.f661 = str;
            this.f660 = aVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            ay ayVarM757 = az.m757(az.this, this.f661);
            if (ayVarM757 != null) {
                ayVarM757.m750(this.f660);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface e extends s {
    }

    public az() {
        new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ ay m757(az azVar, String str) {
        Map<String, ay> map = azVar.f650;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m760(String str) {
        this.f650.put(str, new ay(str));
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m759(String str) {
        Map<String, ay> map = this.f650;
        ay ayVar = map != null ? map.get(str) : null;
        if (ayVar != null) {
            return ayVar.m748();
        }
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final synchronized boolean m761() {
        ArrayList arrayList = new ArrayList(this.f650.values());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (((ay) obj).m751()) {
                return false;
            }
        }
        return true;
    }
}
