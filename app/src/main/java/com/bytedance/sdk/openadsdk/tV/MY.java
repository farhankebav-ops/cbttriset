package com.bytedance.sdk.openadsdk.tV;

import com.bytedance.sdk.openadsdk.tV.EO.IlO;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static final String IlO = IlO.InterfaceC0116IlO.IlO;
    public static final String MY = IlO.InterfaceC0116IlO.MY;
    public static final String EO = IlO.InterfaceC0116IlO.EO;
    public static final String tV = IlO.InterfaceC0116IlO.tV;
    public static final String Cc = IlO.InterfaceC0116IlO.Cc;
    public static final String vCE = IlO.InterfaceC0116IlO.vCE;
    public static final Set<String> Bc = new HashSet(Arrays.asList(C2318f4.f8523d, C2461n2.f9471v, "insight_log"));

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public static String EO = "direct";
        public static String IlO = "openDetailPage";
        public static String MY = "openAdLandPageLinks";
        public static String tV = "saLandingPageLinks";
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tV.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0120MY {
        public static int EO = 100;
        public static int IlO = 1;
        public static int MY = 2;
    }

    public static boolean IlO(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
