package com.instagram.common.viewpoint.core;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.work.WorkRequest;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C03790p extends AbstractC05547k {
    public static byte[] A05;
    public static String[] A06 = {"W2LX5ghCjNUdHPD6UOG9gNVP2r8Jjr9N", "hy0Kd51hxMRklx2U40MO6uTjDebxbFFc", "3rXKYQ25IDS9XLMelMDoz8fDuc1jWejt", "VHZF6nyXCVj1GWlzSFxOxU8Mk9", "1hZxQPwvp7yuSjm13xBtOFGqAv7wvaBL", "2txr67moghbeiUbFZCBGyiXHK8tBuFWn", "gHf8B0vtrS2LcJp", "q573XCdkPfkFHQHQX29TvMro8DPY3qfe"};
    public static final Pattern A07;
    public float A00;
    public float A01;
    public Map<String, C0839Ja> A02;
    public final JV A03;
    public final boolean A04;

    public static String A07(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A05 = new byte[]{85, 39, 48, 53, 39, 83, 107, 36, 38, 53, 38, 48, 39, 83, 107, 36, 38, 53, 39, 83, 107, 36, 38, 84, 53, 33, 82, 39, 83, 107, 36, 38, 75, 35, 52, 25, 17, 28, 31, 23, 5, 21, 74, 75, 98, 127, 96, 108, 121, 55, 101, 93, 95, 70, 70, 95, 88, 81, 22, 17, 101, 66, 79, 90, 83, 12, 17, 22, 90, 95, 88, 83, 22, 84, 83, 80, 89, 68, 83, 22, 17, 112, 89, 68, 91, 87, 66, 12, 17, 22, 90, 95, 88, 83, 12, 22, 37, 29, 31, 6, 6, 31, 24, 17, 86, 18, 31, 23, 26, 25, 17, 3, 19, 86, 26, 31, 24, 19, 86, 20, 19, 16, 25, 4, 19, 86, 21, 25, 27, 6, 26, 19, 2, 19, 86, 16, 25, 4, 27, 23, 2, 76, 86, 53, 13, 15, 22, 22, 15, 8, 1, 70, 2, 15, 7, 10, 9, 1, 19, 3, 70, 10, 15, 8, 3, 70, 17, 15, 18, 14, 70, 0, 3, 17, 3, 20, 70, 5, 9, 10, 19, 11, 8, 21, 70, 18, 14, 7, 8, 70, 0, 9, 20, 11, 7, 18, 92, 70, 66, 122, 120, 97, 97, 120, 127, 118, 49, 120, 127, 103, 112, 125, 120, 117, 49, 101, 120, 124, 120, 127, 118, 43, 49, 101, 69, 87, 114, 83, 85, 89, 82, 83, 68, 36, 3, 14, 27, 18, 77, 45, 22, 19, 22, 23, 15, 22, 88, 25, 20, 17, 31, 22, 21, 29, 22, 12, 66, 88, 40, 54, 5, 22, 29, 7, 0, 46, 94, 86, 102, 119, 108, 117, 113, 37, 76, 107, 99, 106, 88, 13, 0, 98, 118, 5, 34, 47, 58, 51, 37, 11, 124, 113, 19, 7, 116, 83, 94, 75, 66, 84, 122, 7, 70, 85, 66, 7, 73, 72, 83, 7, 84, 82, 87, 87, 72, 85, 83, 66, 67, 75, 70, 36, 59, 48, 67, 100, 105, 124, 117, 99, 77, 92, 78, 5, 49, 108, 94, 5, 25, 20, 12, 7, 16, 6, 13, 94, 66, 79, 87, 92, 75, 93, 87, -72, -38};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0D(String str, JV jv, List<List<C2105o2>> list, List<Long> list2) {
        String strA07 = A07(34, 9, 116);
        C3M.A07(str.startsWith(strA07));
        String[] strArrSplit = str.substring(strA07.length()).split(A07(32, 1, 99), jv.A01);
        int length = strArrSplit.length;
        int i2 = jv.A01;
        String strA072 = A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50);
        if (length != i2) {
            AnonymousClass44.A07(strA072, A07(143, 55, 98) + str);
            return;
        }
        long jA04 = A04(strArrSplit[jv.A02]);
        String strA073 = A07(198, 25, 21);
        if (jA04 == -9223372036854775807L) {
            AnonymousClass44.A07(strA072, strA073 + str);
            return;
        }
        long jA042 = A04(strArrSplit[jv.A00]);
        if (jA042 == -9223372036854775807L) {
            AnonymousClass44.A07(strA072, strA073 + str);
            return;
        }
        C0839Ja c0839Ja = (this.A02 == null || jv.A03 == -1) ? null : this.A02.get(strArrSplit[jv.A03].trim());
        String str2 = strArrSplit[jv.A04];
        JX jxA02 = JX.A02(str2);
        String strA04 = JX.A04(str2);
        String strA074 = A07(331, 2, 4);
        String strA075 = A07(0, 1, 91);
        C2105o2 c2105o2A06 = A06(strA04.replace(strA074, strA075).replace(A07(335, 2, 52), strA075).replace(A07(333, 2, 93), A07(353, 2, 126)), c0839Ja, jxA02, this.A01, this.A00);
        int iA03 = A03(jA042, list2, list);
        for (int iA032 = A03(jA04, list2, list); iA032 < iA03; iA032++) {
            list.get(iA032).add(c2105o2A06);
        }
    }

    static {
        A09();
        A07 = Pattern.compile(A07(1, 31, 11));
    }

    public C03790p() {
        this(null);
    }

    public C03790p(List<byte[]> list) {
        super(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50));
        this.A01 = -3.4028235E38f;
        this.A00 = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String strA0q = AbstractC04664a.A0q(list.get(0));
            String formatLine = A07(43, 7, 9);
            C3M.A07(strA0q.startsWith(formatLine));
            this.A03 = (JV) C3M.A01(JV.A00(strA0q));
            A0A(new C4J(list.get(1)));
            return;
        }
        this.A04 = false;
        this.A03 = null;
    }

    public static float A00(int i2) {
        switch (i2) {
            case 0:
                return 0.05f;
            case 1:
                return 0.5f;
            case 2:
                return 0.95f;
            default:
                return -3.4028235E38f;
        }
    }

    public static int A01(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AnonymousClass44.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i2);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                A06[6] = "Sg07jKGUv12uLKgMKKFA3fI9zPLxcTEi";
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int A02(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AnonymousClass44.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i2);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "bBVjASvxGIVEucqGKWBeREj1nHP5tR7K";
                strArr[4] = "afA0CT9VteApb4cGitBpBAxXonSmRtRK";
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    public static int A03(long j, List<Long> list, List<List<C2105o2>> list2) {
        ArrayList arrayList;
        int i2 = 0;
        int insertionIndex = list.size();
        int i8 = insertionIndex - 1;
        while (true) {
            if (i8 < 0) {
                break;
            }
            long jLongValue = list.get(i8).longValue();
            int i9 = A06[7].charAt(28);
            if (i9 == 116) {
                throw new RuntimeException();
            }
            A06[7] = "L6yhcoI2CoUL0EEbj8PtMmDYbUY1DBiP";
            if (jLongValue == j) {
                return i8;
            }
            if (list.get(i8).longValue() < j) {
                i2 = i8 + 1;
                break;
            }
            i8--;
        }
        list.add(i2, Long.valueOf(j));
        if (i2 == 0) {
            arrayList = new ArrayList();
        } else {
            int insertionIndex2 = i2 - 1;
            arrayList = new ArrayList(list2.get(insertionIndex2));
        }
        list2.add(i2, arrayList);
        return i2;
    }

    public static long A04(String str) {
        Matcher matcher = A07.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) AbstractC04664a.A0f(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) AbstractC04664a.A0f(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) AbstractC04664a.A0f(matcher.group(3))) * 1000000) + (Long.parseLong((String) AbstractC04664a.A0f(matcher.group(4))) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public static Layout.Alignment A05(int i2) {
        switch (i2) {
            case -1:
                return null;
            case 0:
            default:
                AnonymousClass44.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i2);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    public static C2105o2 A06(String str, C0839Ja c0839Ja, JX jx, float f4, float f8) {
        int i2;
        SpannableString spannableString = new SpannableString(str);
        C3C c3cA0G = new C3C().A0G(spannableString);
        if (c0839Ja != null) {
            if (c0839Ja.A04 != null) {
                spannableString.setSpan(new ForegroundColorSpan(c0839Ja.A04.intValue()), 0, spannableString.length(), 33);
            }
            if (c0839Ja.A02 == 3 && c0839Ja.A03 != null) {
                spannableString.setSpan(new BackgroundColorSpan(c0839Ja.A03.intValue()), 0, spannableString.length(), 33);
            }
            if (c0839Ja.A00 != -3.4028235E38f) {
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "hamZaHHK5iJw0vPowwB4Xi3W6GQULYkl";
                strArr[4] = "AtQHcqF1nJuVU9oQ1sBsNKUnqzSBt8ub";
                if (f8 != -3.4028235E38f) {
                    c3cA0G.A08(c0839Ja.A00 / f8, 1);
                }
            }
            if (c0839Ja.A06 && c0839Ja.A07) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (c0839Ja.A06) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (c0839Ja.A07) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (c0839Ja.A09) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (c0839Ja.A08) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i8 = jx.A00;
        if (A06[6].length() == 19) {
            throw new RuntimeException();
        }
        A06[7] = "i2mc5u7bs2HiiqvdNfcyeR2hNUTbHa8c";
        if (i8 != -1) {
            i2 = jx.A00;
        } else if (c0839Ja != null) {
            i2 = c0839Ja.A01;
        } else {
            i2 = -1;
        }
        C3C cue = c3cA0G.A0F(A05(i2));
        cue.A0A(A02(i2)).A09(A01(i2));
        if (jx.A01 != null && f8 != -3.4028235E38f && f4 != -3.4028235E38f) {
            c3cA0G.A04(jx.A01.x / f4);
            c3cA0G.A07(jx.A01.y / f8, 0);
        } else {
            c3cA0G.A04(A00(c3cA0G.A01()));
            c3cA0G.A07(A00(c3cA0G.A00()), 0);
        }
        return c3cA0G.A0H();
    }

    public static Map<String, C0839Ja> A08(C4J c4j) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JW jwA00 = null;
        while (true) {
            String strA0T = c4j.A0T();
            if (strA0T == null || (c4j.A07() != 0 && c4j.A0B() == 91)) {
                break;
            }
            if (strA0T.startsWith(A07(43, 7, 9))) {
                jwA00 = JW.A00(strA0T);
            } else if (strA0T.startsWith(A07(233, 6, 115))) {
                if (jwA00 == null) {
                    String currentLine = A07(50, 46, 50) + strA0T;
                    AnonymousClass44.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), currentLine);
                } else {
                    C0839Ja c0839JaA04 = C0839Ja.A04(strA0T, jwA00);
                    if (c0839JaA04 != null) {
                        linkedHashMap.put(c0839JaA04.A05, c0839JaA04);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private void A0A(C4J c4j) {
        while (true) {
            String strA0T = c4j.A0T();
            if (strA0T != null) {
                if (A07(266, 13, 1).equalsIgnoreCase(strA0T)) {
                    A0B(c4j);
                } else if (A07(Sdk.SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 12, 20).equalsIgnoreCase(strA0T)) {
                    this.A02 = A08(c4j);
                } else if (A07(279, 11, 82).equalsIgnoreCase(strA0T)) {
                    AnonymousClass44.A06(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(290, 29, 35));
                } else if (A07(258, 8, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equalsIgnoreCase(strA0T)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B(com.instagram.common.viewpoint.core.C4J r9) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C03790p.A0B(com.facebook.ads.redexgen.X.4J):void");
    }

    private void A0C(C4J c4j, List<List<C2105o2>> list, List<Long> list2) {
        JV jvA00 = this.A04 ? this.A03 : null;
        while (true) {
            String strA0T = c4j.A0T();
            if (strA0T != null) {
                if (strA0T.startsWith(A07(43, 7, 9))) {
                    jvA00 = JV.A00(strA0T);
                } else if (strA0T.startsWith(A07(34, 9, 116))) {
                    if (jvA00 == null) {
                        AnonymousClass44.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(96, 47, 114) + strA0T);
                    } else {
                        A0D(strA0T, jvA00, list, list2);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC05547k
    public final J7 A0g(byte[] bArr, int i2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C4J c4j = new C4J(bArr, i2);
        if (!this.A04) {
            A0A(c4j);
        }
        A0C(c4j, arrayList, arrayList2);
        return new C1878k8(arrayList, arrayList2);
    }
}
