package com.bytedance.sdk.openadsdk.utils;

import a1.a;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class OOq {
    private static String Cc = null;
    public static boolean IlO = false;
    public static boolean MY = false;
    private static int vCE = Integer.MAX_VALUE;
    private static final CharSequence EO = "amigo";
    private static final CharSequence tV = "funtouch";
    private static final ConcurrentHashMap<String, String> Bc = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements Callable<String> {
        private final String IlO;

        public IlO(String str) {
            this.IlO = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) OOq.Bc.get(this.IlO);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String strEO = OOq.EO(this.IlO);
            System.currentTimeMillis();
            if (strEO != null) {
                OOq.Bc.put(this.IlO, strEO);
            }
            return strEO;
        }
    }

    public static boolean Bc() {
        String strTV = tV("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strTV) && strTV.toLowerCase().contains(tV);
    }

    public static boolean Cc() {
        if (!MY) {
            try {
                Class.forName("miui.os.Build");
                IlO = true;
                MY = true;
                return true;
            } catch (Exception unused) {
                MY = true;
            }
        }
        return IlO;
    }

    public static String DmF() {
        return Build.DISPLAY + "_" + tV("ro.gn.sv.version");
    }

    public static String EO() {
        return tV("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean EV() {
        return !TextUtils.isEmpty(tV("ro.letv.release.version"));
    }

    public static String IlO() {
        if (!TextUtils.isEmpty(Cc)) {
            return Cc;
        }
        String strIlO = com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_local_rom_info", 604800000L);
        Cc = strIlO;
        if (TextUtils.isEmpty(strIlO)) {
            String strOeT = oeT();
            Cc = strOeT;
            com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_local_rom_info", strOeT);
        }
        return Cc;
    }

    public static String NV() {
        if (!EV()) {
            return "";
        }
        return "eui_" + tV("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String bWL() {
        return tV("ro.build.version.emui");
    }

    public static boolean cL() {
        if (vCE == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strBc = zLG.Bc("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(strBc)) {
                vCE = 0;
            } else {
                vCE = 1;
            }
        }
        return vCE == 1;
    }

    public static String cl() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean ea() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String es() {
        if (!cL()) {
            return "";
        }
        return "coloros_" + tV(zLG.Bc("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
    }

    public static String hp() {
        String strBWL = bWL();
        if (strBWL == null || !strBWL.toLowerCase().contains("emotionui")) {
            return "";
        }
        StringBuilder sbX = a.x(strBWL, "_");
        sbX.append(Build.DISPLAY);
        return sbX.toString();
    }

    public static boolean lEW() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(EO);
    }

    private static String oeT() {
        if (ea()) {
            return zPa();
        }
        if (Cc()) {
            return rp();
        }
        if (MY()) {
            return cl();
        }
        if (cL()) {
            return es();
        }
        String strHp = hp();
        if (!TextUtils.isEmpty(strHp)) {
            return strHp;
        }
        if (Bc()) {
            return vCE();
        }
        if (lEW()) {
            return DmF();
        }
        if (tV()) {
            return EO();
        }
        String strNV = NV();
        return !TextUtils.isEmpty(strNV) ? strNV : Build.DISPLAY;
    }

    public static String rp() {
        if (!Cc()) {
            return "";
        }
        return "miui_" + tV("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean tV() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String vCE() {
        return tV("ro.vivo.os.build.display.id") + "_" + tV("ro.vivo.product.version");
    }

    public static boolean xF() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String zPa() {
        if (ea()) {
            try {
                return "smartisan_".concat(String.valueOf(tV("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String EO(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String line = "";
        Process process = null;
        try {
            try {
                Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                    try {
                        line = bufferedReader.readLine();
                        processExec.exitValue();
                    } catch (IllegalThreadStateException unused) {
                        process = processExec;
                        try {
                            process.destroy();
                        } catch (Throwable unused2) {
                        }
                        if (bufferedReader != null) {
                        }
                        return line;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.bytedance.sdk.component.utils.oeT.IlO("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                            return line;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    com.bytedance.sdk.component.utils.oeT.IlO("ToolUtils", "Exception while closing InputStream", e);
                                }
                            }
                        }
                    }
                } catch (IllegalThreadStateException unused3) {
                    bufferedReader = null;
                }
            } catch (IllegalThreadStateException unused4) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                com.bytedance.sdk.component.utils.oeT.IlO("ToolUtils", "Exception while closing InputStream", e4);
            }
            return line;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static boolean MY() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String tV(String str) {
        String str2;
        String str3 = Bc.get(str);
        if (str3 != null) {
            return str3;
        }
        if (!TextUtils.isEmpty("")) {
            str2 = "";
        } else {
            final com.bytedance.sdk.component.lEW.Bc bc = new com.bytedance.sdk.component.lEW.Bc(new IlO(str), 5, 2);
            mmj.MY(new com.bytedance.sdk.component.lEW.lEW("_getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.OOq.1
                @Override // java.lang.Runnable
                public void run() {
                    bc.run();
                }
            });
            str2 = (String) bc.get(1L, TimeUnit.SECONDS);
        }
        return str2 == null ? "" : str2;
    }

    public static boolean IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            str = bWL();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || xF();
    }
}
