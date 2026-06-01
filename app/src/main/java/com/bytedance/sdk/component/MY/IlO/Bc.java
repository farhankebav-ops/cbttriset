package com.bytedance.sdk.component.MY.IlO;

import a1.a;
import androidx.webkit.ProxyConfig;
import com.ironsource.G5;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Bc {
    private static final char[] tV = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> Bc;
    private final String Cc;
    private final String DmF;
    final int EO;
    final String IlO;
    final String MY;
    private final String NV;
    private final List<String> lEW;
    private final String vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        List<String> Bc;
        String IlO;
        String lEW;
        String tV;
        final List<String> vCE;
        String MY = "";
        String EO = "";
        int Cc = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.MY.IlO.Bc$IlO$IlO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public enum EnumC0047IlO {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public IlO() {
            ArrayList arrayList = new ArrayList();
            this.vCE = arrayList;
            arrayList.add("");
        }

        private boolean Cc(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean vCE(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public IlO EO(String str) {
            if (str != null) {
                return IlO(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public IlO IlO(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                this.IlO = ProxyConfig.MATCH_HTTP;
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.IlO = "https";
            return this;
        }

        public IlO MY(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strCc = Cc(str, 0, str.length());
            if (strCc == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.tV = strCc;
            return this;
        }

        public IlO tV(String str) {
            this.Bc = str != null ? Bc.MY(Bc.IlO(str, _UrlKt.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.IlO);
            sb.append("://");
            if (!this.MY.isEmpty() || !this.EO.isEmpty()) {
                sb.append(this.MY);
                if (!this.EO.isEmpty()) {
                    sb.append(':');
                    sb.append(this.EO);
                }
                sb.append('@');
            }
            if (this.tV.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.tV);
                sb.append(']');
            } else {
                sb.append(this.tV);
            }
            int iIlO = IlO();
            if (iIlO != Bc.IlO(this.IlO)) {
                sb.append(':');
                sb.append(iIlO);
            }
            Bc.IlO(sb, this.vCE);
            if (this.Bc != null) {
                sb.append('?');
                Bc.MY(sb, this.Bc);
            }
            if (this.lEW != null) {
                sb.append('#');
                sb.append(this.lEW);
            }
            return sb.toString();
        }

        private static String Cc(String str, int i2, int i8) {
            return com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(Bc.IlO(str, i2, i8, false));
        }

        private void EO() {
            if (this.vCE.remove(r0.size() - 1).isEmpty() && !this.vCE.isEmpty()) {
                this.vCE.set(r0.size() - 1, "");
            } else {
                this.vCE.add("");
            }
        }

        private static int tV(String str, int i2, int i8) {
            while (i2 < i8) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ':') {
                    return i2;
                }
                if (cCharAt == '[') {
                    do {
                        i2++;
                        if (i2 < i8) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i8;
        }

        private static int vCE(String str, int i2, int i8) {
            int i9;
            try {
                i9 = Integer.parseInt(Bc.IlO(str, i2, i8, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i9 <= 0 || i9 > 65535) {
                return -1;
            }
            return i9;
        }

        public Bc MY() {
            if (this.IlO != null) {
                if (this.tV != null) {
                    return new Bc(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int EO(String str, int i2, int i8) {
            int i9 = 0;
            while (i2 < i8) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i9++;
                i2++;
            }
            return i9;
        }

        public int IlO() {
            int i2 = this.Cc;
            return i2 != -1 ? i2 : Bc.IlO(this.IlO);
        }

        private IlO IlO(String str, boolean z2) {
            boolean z7;
            IlO ilO;
            String str2;
            boolean z8;
            int i2 = 0;
            while (true) {
                int iIlO = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str, i2, str.length(), "/\\");
                if (iIlO < str.length()) {
                    z7 = true;
                    str2 = str;
                    z8 = z2;
                    ilO = this;
                } else {
                    z7 = false;
                    ilO = this;
                    str2 = str;
                    z8 = z2;
                }
                ilO.IlO(str2, i2, iIlO, z7, z8);
                i2 = iIlO + 1;
                if (i2 > str2.length()) {
                    return ilO;
                }
                str = str2;
                z2 = z8;
            }
        }

        private static int MY(String str, int i2, int i8) {
            if (i8 - i2 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i8) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public IlO IlO(String str, String str2) {
            if (str != null) {
                if (this.Bc == null) {
                    this.Bc = new ArrayList();
                }
                this.Bc.add(Bc.IlO(str, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                this.Bc.add(str2 != null ? Bc.IlO(str2, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public EnumC0047IlO IlO(Bc bc, String str) {
            int iIlO;
            String str2;
            int i2;
            String str3;
            String str4 = str;
            int iIlO2 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str4, 0, str4.length());
            int iMY = com.bytedance.sdk.component.MY.IlO.MY.DmF.MY(str4, iIlO2, str4.length());
            if (MY(str4, iIlO2, iMY) != -1) {
                if (str4.regionMatches(true, iIlO2, "https:", 0, 6)) {
                    this.IlO = "https";
                    iIlO2 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, iIlO2, "http:", 0, 5)) {
                        this.IlO = ProxyConfig.MATCH_HTTP;
                        iIlO2 += 5;
                    } else {
                        return EnumC0047IlO.UNSUPPORTED_SCHEME;
                    }
                }
            } else if (bc != null) {
                this.IlO = bc.IlO;
            } else {
                return EnumC0047IlO.MISSING_SCHEME;
            }
            int iEO = EO(str4, iIlO2, iMY);
            char c7 = '#';
            if (iEO < 2 && bc != null && bc.IlO.equals(this.IlO)) {
                this.MY = bc.MY();
                this.EO = bc.EO();
                this.tV = bc.MY;
                this.Cc = bc.EO;
                this.vCE.clear();
                this.vCE.addAll(bc.tV());
                if (iIlO2 == iMY || str4.charAt(iIlO2) == '#') {
                    tV(bc.Cc());
                }
                str2 = str4;
            } else {
                int i8 = iIlO2 + iEO;
                boolean z2 = false;
                boolean z7 = false;
                while (true) {
                    iIlO = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str4, i8, iMY, "@/\\?#");
                    byte bCharAt = iIlO != iMY ? str4.charAt(iIlO) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c7 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z2) {
                            int iIlO3 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str4, i8, iIlO, ':');
                            String strIlO = Bc.IlO(str, i8, iIlO3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z7) {
                                strIlO = a.s(new StringBuilder(), this.MY, "%40", strIlO);
                            }
                            this.MY = strIlO;
                            if (iIlO3 != iIlO) {
                                i2 = iIlO;
                                this.EO = Bc.IlO(str, iIlO3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z2 = true;
                            } else {
                                i2 = iIlO;
                            }
                            str3 = str;
                            z7 = true;
                        } else {
                            i2 = iIlO;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.EO);
                            sb.append("%40");
                            str3 = str;
                            sb.append(Bc.IlO(str3, i8, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.EO = sb.toString();
                        }
                        i8 = i2 + 1;
                        str4 = str3;
                        c7 = '#';
                    }
                }
                str2 = str4;
                int i9 = i8;
                int iTV = tV(str2, i9, iIlO);
                int i10 = iTV + 1;
                if (i10 < iIlO) {
                    this.tV = Cc(str2, i9, iTV);
                    int iVCE = vCE(str2, i10, iIlO);
                    this.Cc = iVCE;
                    if (iVCE == -1) {
                        return EnumC0047IlO.INVALID_PORT;
                    }
                } else {
                    this.tV = Cc(str2, i9, iTV);
                    this.Cc = Bc.IlO(this.IlO);
                }
                if (this.tV == null) {
                    return EnumC0047IlO.INVALID_HOST;
                }
                iIlO2 = iIlO;
            }
            int iIlO4 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str2, iIlO2, iMY, "?#");
            IlO(str2, iIlO2, iIlO4);
            if (iIlO4 < iMY && str2.charAt(iIlO4) == '?') {
                int iIlO5 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str2, iIlO4, iMY, '#');
                this.Bc = Bc.MY(Bc.IlO(str2, iIlO4 + 1, iIlO5, _UrlKt.QUERY_ENCODE_SET, true, false, true, true, null));
                iIlO4 = iIlO5;
            }
            if (iIlO4 < iMY && str2.charAt(iIlO4) == '#') {
                this.lEW = Bc.IlO(str2, iIlO4 + 1, iMY, "", true, false, false, false, null);
            }
            return EnumC0047IlO.SUCCESS;
        }

        private void IlO(String str, int i2, int i8) {
            if (i2 == i8) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.vCE;
                list.set(list.size() - 1, "");
            } else {
                this.vCE.clear();
                this.vCE.add("");
                i2++;
            }
            int i9 = i2;
            while (i9 < i8) {
                int iIlO = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str, i9, i8, "/\\");
                boolean z2 = iIlO < i8;
                String str2 = str;
                IlO(str2, i9, iIlO, z2, true);
                if (z2) {
                    iIlO++;
                }
                i9 = iIlO;
                str = str2;
            }
        }

        private void IlO(String str, int i2, int i8, boolean z2, boolean z7) {
            String strIlO = Bc.IlO(str, i2, i8, _UrlKt.PATH_SEGMENT_ENCODE_SET, z7, false, false, true, null);
            if (Cc(strIlO)) {
                return;
            }
            if (vCE(strIlO)) {
                EO();
                return;
            }
            if (this.vCE.get(r11.size() - 1).isEmpty()) {
                this.vCE.set(r11.size() - 1, strIlO);
            } else {
                this.vCE.add(strIlO);
            }
            if (z2) {
                this.vCE.add("");
            }
        }
    }

    public Bc(IlO ilO) {
        this.IlO = ilO.IlO;
        this.Cc = IlO(ilO.MY, false);
        this.vCE = IlO(ilO.EO, false);
        this.MY = ilO.tV;
        this.EO = ilO.IlO();
        this.Bc = IlO(ilO.vCE, false);
        List<String> list = ilO.Bc;
        this.lEW = list != null ? IlO(list, true) : null;
        String str = ilO.lEW;
        this.DmF = str != null ? IlO(str, false) : null;
        this.NV = ilO.toString();
    }

    public String Cc() {
        if (this.lEW == null) {
            return null;
        }
        int iIndexOf = this.NV.indexOf(63) + 1;
        String str = this.NV;
        return this.NV.substring(iIndexOf, com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str, iIndexOf, str.length(), '#'));
    }

    public String EO() {
        if (this.vCE.isEmpty()) {
            return "";
        }
        return this.NV.substring(this.NV.indexOf(58, this.IlO.length() + 3) + 1, this.NV.indexOf(64));
    }

    public URL IlO() {
        try {
            return new URL(this.NV);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String MY() {
        if (this.Cc.isEmpty()) {
            return "";
        }
        int length = this.IlO.length() + 3;
        String str = this.NV;
        return this.NV.substring(length, com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof Bc) && ((Bc) obj).NV.equals(this.NV);
    }

    public int hashCode() {
        return this.NV.hashCode();
    }

    public List<String> tV() {
        int iIndexOf = this.NV.indexOf(47, this.IlO.length() + 3);
        String str = this.NV;
        int iIlO = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iIlO) {
            int i2 = iIndexOf + 1;
            int iIlO2 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(this.NV, i2, iIlO, '/');
            arrayList.add(this.NV.substring(i2, iIlO2));
            iIndexOf = iIlO2;
        }
        return arrayList;
    }

    public String toString() {
        return this.NV;
    }

    public static int IlO(String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static Bc EO(String str) {
        IlO ilO = new IlO();
        if (ilO.IlO((Bc) null, str) == IlO.EnumC0047IlO.SUCCESS) {
            return ilO.MY();
        }
        return null;
    }

    public static void IlO(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static void MY(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(G5.T);
                sb.append(str2);
            }
        }
    }

    public static String IlO(String str, boolean z2) {
        return IlO(str, 0, str.length(), z2);
    }

    private List<String> IlO(List<String> list, boolean z2) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? IlO(str, z2) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> MY(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iIndexOf = str.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i2);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i2, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i2, iIndexOf));
                arrayList.add(null);
            }
            i2 = iIndexOf + 1;
        }
        return arrayList;
    }

    public static String IlO(String str, int i2, int i8, boolean z2) {
        for (int i9 = i2; i9 < i8; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                com.bytedance.sdk.component.MY.IlO.MY.IlO ilO = new com.bytedance.sdk.component.MY.IlO.MY.IlO();
                ilO.IlO(str, i2, i9);
                IlO(ilO, str, i9, i8, z2);
                return ilO.EO();
            }
        }
        return str.substring(i2, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void IlO(com.bytedance.sdk.component.MY.IlO.MY.IlO r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.MY(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.MY(r1)
            goto L3c
        L39:
            r5.IlO(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.MY.IlO.Bc.IlO(com.bytedance.sdk.component.MY.IlO.MY.IlO, java.lang.String, int, int, boolean):void");
    }

    public static boolean IlO(String str, int i2, int i8) {
        int i9 = i2 + 2;
        return i9 < i8 && str.charAt(i2) == '%' && com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str.charAt(i2 + 1)) != -1 && com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO(str.charAt(i9)) != -1;
    }

    public static String IlO(String str, int i2, int i8, String str2, boolean z2, boolean z7, boolean z8, boolean z9, Charset charset) {
        int iCharCount = i2;
        while (iCharCount < i8) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z9) && str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z2 && (!z7 || IlO(str, iCharCount, i8)))) && (iCodePointAt != 43 || !z8)))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                com.bytedance.sdk.component.MY.IlO.MY.IlO ilO = new com.bytedance.sdk.component.MY.IlO.MY.IlO();
                ilO.IlO(str, i2, iCharCount);
                IlO(ilO, str, iCharCount, i8, str2, z2, z7, z8, z9, charset);
                return ilO.EO();
            }
        }
        return str.substring(i2, i8);
    }

    public static void IlO(com.bytedance.sdk.component.MY.IlO.MY.IlO ilO, String str, int i2, int i8, String str2, boolean z2, boolean z7, boolean z8, boolean z9, Charset charset) {
        com.bytedance.sdk.component.MY.IlO.MY.IlO ilO2 = null;
        while (i2 < i8) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z8) {
                    ilO.IlO(z2 ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z9) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z2 && (!z7 || IlO(str, i2, i8)))))) {
                    ilO.IlO(iCodePointAt);
                } else {
                    if (ilO2 == null) {
                        ilO2 = new com.bytedance.sdk.component.MY.IlO.MY.IlO();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO)) {
                        ilO2.IlO(str, i2, Character.charCount(iCodePointAt) + i2, charset);
                    } else {
                        ilO2.IlO(iCodePointAt);
                    }
                    while (!ilO2.IlO()) {
                        byte bMY = ilO2.MY();
                        ilO.MY(37);
                        char[] cArr = tV;
                        ilO.MY((int) cArr[((bMY & 255) >> 4) & 15]);
                        ilO.MY((int) cArr[bMY & 15]);
                    }
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    public static String IlO(String str, String str2, boolean z2, boolean z7, boolean z8, boolean z9) {
        return IlO(str, 0, str.length(), str2, z2, z7, z8, z9, null);
    }
}
