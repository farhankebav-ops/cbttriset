package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ie {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char[] f2458 = null;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2459 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2460;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static long f2461;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2462;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static final byte[] f2463;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Cipher f2464;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private SecretKey f2465;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Cipher f2466;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    static {
        m2516();
        f2463 = new byte[]{16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};
        int i2 = f2460 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f2459 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 7 / 0;
        }
    }

    public ie(byte[] bArr, String str, String str2, String str3) {
        byte[] bArrDigest;
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(m2514((char) View.combineMeasuredStates(0, 0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 28, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(str3);
            bArrDigest = secretKeyFactory.generateSecret(new PBEKeySpec(sb.toString().toCharArray(), bArr, 1024, 256)).getEncoded();
        } catch (GeneralSecurityException unused) {
            ih.m2523(m2514((char) (Process.myPid() >> 22), Process.getGidForName("") + 20, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29).intern(), m2514((char) (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.indexOf("", "", 0) + 59, Color.blue(0) + 48).intern());
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(m2515("\u0000\u0001\u0000", true, new int[]{0, 3, 0, 2}).intern());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb2.append(str3);
                for (char c7 : sb2.toString().toCharArray()) {
                    messageDigest.update((byte) c7);
                }
                bArrDigest = messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(m2515("\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{3, 19, 0, 3}).intern(), e);
            }
        }
        this.f2465 = new SecretKeySpec(bArrDigest, m2515("\u0000\u0000\u0000", false, new int[]{22, 3, 21, 1}).intern());
        m2513();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2513() {
        try {
            Cipher cipher = Cipher.getInstance(m2514((char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4730), View.MeasureSpec.makeMeasureSpec(0, 0) + 20, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 107).intern());
            this.f2466 = cipher;
            SecretKey secretKey = this.f2465;
            byte[] bArr = f2463;
            cipher.init(1, secretKey, new IvParameterSpec(bArr));
            Cipher cipher2 = Cipher.getInstance(m2514((char) (4731 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), 20 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 107).intern());
            this.f2464 = cipher2;
            cipher2.init(2, this.f2465, new IvParameterSpec(bArr));
            int i2 = f2460 + 103;
            f2459 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 13 / 0;
            }
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(m2514((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (Process.myTid() >> 22) + 21, View.MeasureSpec.makeMeasureSpec(0, 0) + 127).intern(), e);
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2514(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2462[i8 + i9]) ^ (((long) i9) * f2461)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2516() {
        f2462 = new char[]{'P', 14249, 28563, 42902, 57317, 6083, 20426, 34622, 48912, 63234, 12143, 26455, 40768, 55005, 3823, 18163, 32498, 46802, 61138, 9776, 24089, 38420, 52767, 1630, 15946, 30128, 44531, 58763, 7671, 'K', 14254, 28563, 42903, 57325, 6071, 20419, 34600, 48907, 63244, 12108, 26495, 40817, 54940, 3769, 18084, 32452, 46836, 61172, 'P', 14233, 28601, 42915, 57293, 6133, 20462, 34580, 49016, 63266, 12096, 26425, 40813, 54913, 3769, 18090, 32477, 46827, 61159, 9733, 24117, 38437, 52830, 1656, 15912, 30103, 44475, 58815, 7645, 22012, 36335, 50523, 64832, 13599, 27972, 42328, 56677, 5273, 19589, 34029, 48348, 62666, 11496, 25631, 39937, 54333, 3167, 17483, 31844, 46043, 60295, 9121, 23500, 37845, 52221, 796, 15115, 29499, 43792, 4666, 9685, 32254, 46485, 52628, 1454, 23994, 38201, 44403, 58739, 15638, 30001, 36170, 50372, 7360, 21722, 27823, 42121, 64659, 13421, 'I', 14213, 28576, 42912, 57280, 6142, 20454, 34637, 48957, 63277, 12120, 26480, 40822, 54912, 3764, 18088, 32469, 46837, 61170, 9809, 24174, 'U', 14271, 28560, 42988, 57236, 36216};
        f2461 = 875307770958985195L;
        f2458 = new char[]{'\"', 'H', 'A', ';', 'r', '[', '^', 'q', 'i', 'i', 'm', 'n', 'p', 'm', 'o', 'r', 'i', 'B', 'B', 'f', 'j', 'f', '4', '_', 'X', '\"', 'C', '7', 'M', 'j', 'n', 't', 'Q', 'J', 'j', 'k', 'j', 'l', 'j', 'e', 'H', 'G', 'f', 'l', 'n', 'o', 'q', 'P', 'M', 'n', 'i', 'o', 'V', '/', 'O', 'p', 'q', 'j', 'b', 'k', 't', 'm', 'd', 'X', 'Q', '$', 'V', 'c', 'b', 'd', 'k', 'I', 'G', 'n', 'q', 'J', 'C', 'j', 'r', 'q', 'i', 'B', '$', 'H', 'k', 'r', 'k', 'f', 'j', 'f', 'B', 'B', 'b', 'j', 'j', '@', 'G', 'p', 'I', 'E', 'h', 'o', 'Q', '1'};
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized String m2517(String str) throws a {
        if (TextUtils.isEmpty(str)) {
            int i2 = f2459 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
            f2460 = i2 % 128;
            if (i2 % 2 == 0) {
                return null;
            }
            throw null;
        }
        try {
            try {
                try {
                    String str2 = new String(this.f2464.doFinal(ic.m2510(str)), m2514((char) TextUtils.indexOf("", "", 0, 0), 5 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), View.combineMeasuredStates(0, 0) + 148).intern());
                    if (str2.indexOf(m2515("\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{25, 40, 0, 26}).intern()) == 0) {
                        return str2.substring(m2515("\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{25, 40, 0, 26}).intern().length(), str2.length());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2515("\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001", false, new int[]{65, 39, 0, 0}).intern());
                    sb.append(str);
                    throw new a(sb.toString());
                } catch (id e) {
                    m2513();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e.getMessage());
                    sb2.append(m2514((char) (36162 - TextUtils.indexOf("", "", 0)), TextUtils.getOffsetBefore("", 0) + 1, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 152).intern());
                    sb2.append(str);
                    throw new a(sb2.toString());
                } catch (UnsupportedEncodingException e4) {
                    throw new RuntimeException(m2515("\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{3, 19, 0, 3}).intern(), e4);
                }
            } catch (IllegalBlockSizeException e8) {
                m2513();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e8.getMessage());
                sb3.append(m2514((char) (36161 - ImageFormat.getBitsPerPixel(0)), -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), AndroidCharacter.getMirror('0') + 'i').intern());
                sb3.append(str);
                throw new a(sb3.toString());
            }
        } catch (BadPaddingException e9) {
            m2513();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(e9.getMessage());
            sb4.append(m2514((char) ((ViewConfiguration.getTapTimeout() >> 16) + 36162), TextUtils.getCapsMode("", 0, 0) + 1, 153 - Color.green(0)).intern());
            sb4.append(str);
            throw new a(sb4.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        r4 = r10.f2466;
        r5 = new java.lang.StringBuilder();
        r5.append(m2515("\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{25, 40, 0, 26}).intern());
        r5.append(r11);
        r11 = com.ironsource.adqualitysdk.sdk.i.ic.m2504(r4.doFinal(r5.toString().getBytes(m2514((char) (android.graphics.ImageFormat.getBitsPerPixel(0) + 1), (-16777211) - android.graphics.Color.rgb(0, 0, 0), (android.view.ViewConfiguration.getMaximumFlingVelocity() >> 16) + 148).intern())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        r0 = com.ironsource.adqualitysdk.sdk.i.ie.f2459 + 23;
        com.ironsource.adqualitysdk.sdk.i.ie.f2460 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        if ((r0 % 2) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        m2513();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
    
        throw new java.lang.RuntimeException(m2515("\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{3, 19, 0, 3}).intern(), r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        m2513();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
    
        throw new java.lang.RuntimeException(m2515("\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001", true, new int[]{3, 19, 0, 3}).intern(), r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L16;
     */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m2518(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = com.ironsource.adqualitysdk.sdk.i.ie.f2460     // Catch: java.lang.Throwable -> L1a
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ie.f2459 = r1     // Catch: java.lang.Throwable -> L1a
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1d
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L1a
            r2 = 71
            int r2 = r2 / r1
            if (r0 == 0) goto L25
            goto L23
        L18:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L1a
        L1a:
            r11 = move-exception
            goto Lba
        L1d:
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L25
        L23:
            monitor-exit(r10)
            return r11
        L25:
            r0 = 19
            r2 = 3
            r3 = 1
            javax.crypto.Cipher r4 = r10.f2466     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            r5.<init>()     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r6 = "\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
            r7 = 40
            r8 = 26
            r9 = 25
            int[] r7 = new int[]{r9, r7, r1, r8}     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r6 = m2515(r6, r3, r7)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r6 = r6.intern()     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            r5.append(r6)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            r5.append(r11)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            int r5 = android.graphics.ImageFormat.getBitsPerPixel(r1)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            int r5 = r5 + r3
            char r5 = (char) r5     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            int r6 = android.graphics.Color.rgb(r1, r1, r1)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            r7 = -16777211(0xffffffffff000005, float:-1.7014128E38)
            int r7 = r7 - r6
            int r6 = android.view.ViewConfiguration.getMaximumFlingVelocity()     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            int r6 = r6 >> 16
            int r6 = r6 + 148
            java.lang.String r5 = m2514(r5, r7, r6)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r5 = r5.intern()     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            byte[] r11 = r11.getBytes(r5)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            byte[] r11 = r4.doFinal(r11)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            java.lang.String r11 = com.ironsource.adqualitysdk.sdk.i.ic.m2504(r11)     // Catch: java.lang.Throwable -> L1a java.security.GeneralSecurityException -> L88 java.io.UnsupportedEncodingException -> L8a
            int r0 = com.ironsource.adqualitysdk.sdk.i.ie.f2459     // Catch: java.lang.Throwable -> L1a
            int r0 = r0 + 23
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ie.f2460 = r1     // Catch: java.lang.Throwable -> L1a
            int r0 = r0 % 2
            if (r0 != 0) goto L86
            monitor-exit(r10)
            return r11
        L86:
            r11 = 0
            throw r11     // Catch: java.lang.Throwable -> L18
        L88:
            r11 = move-exception
            goto L8c
        L8a:
            r11 = move-exception
            goto La3
        L8c:
            r10.m2513()     // Catch: java.lang.Throwable -> L1a
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001"
            int[] r0 = new int[]{r2, r0, r1, r2}     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = m2515(r5, r3, r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Throwable -> L1a
            r4.<init>(r0, r11)     // Catch: java.lang.Throwable -> L1a
            throw r4     // Catch: java.lang.Throwable -> L1a
        La3:
            r10.m2513()     // Catch: java.lang.Throwable -> L1a
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001"
            int[] r0 = new int[]{r2, r0, r1, r2}     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = m2515(r5, r3, r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Throwable -> L1a
            r4.<init>(r0, r11)     // Catch: java.lang.Throwable -> L1a
            throw r4     // Catch: java.lang.Throwable -> L1a
        Lba:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L1a
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ie.m2518(java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2515(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2458, i2, cArr, 0, i8);
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
}
