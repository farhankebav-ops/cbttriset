package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class IS {
    public static String[] A00 = {"oZj5aoX1KvbFHq33YkjSnnR9n2", "YrN4", "d5f6mUL", "wzC2np4aQz", "bSG0VkmAa5PTnnRqB4khFtTiUFve1XQW", "Qyz6G41qMcU917EtFwNhHmzpy", "Reep", "5AjdKovxhleFLdRt3FcvPVZSBJ"};

    public static IR A00(int i2, long[] jArr, int[] iArr, long j) {
        int chunkSamplesRemaining = 8192 / i2;
        int iA05 = 0;
        for (int i8 : iArr) {
            iA05 += AbstractC04664a.A05(i8, chunkSamplesRemaining);
        }
        long[] jArr2 = new long[iA05];
        int[] iArr2 = new int[iA05];
        int originalSampleIndex = 0;
        long[] timestamps = new long[iA05];
        int[] flags = new int[iA05];
        int i9 = 0;
        int bufferSampleCount = 0;
        int i10 = 0;
        String[] strArr = A00;
        String str = strArr[2];
        String str2 = strArr[3];
        int maxSampleCount = str.length();
        if (maxSampleCount != str2.length()) {
            String[] strArr2 = A00;
            strArr2[2] = "OG99HZu";
            strArr2[3] = "ptKGW28cJb";
            while (true) {
                int rechunkedSampleCount = iArr.length;
                String[] strArr3 = A00;
                String str3 = strArr3[2];
                String str4 = strArr3[3];
                int maxSampleCount2 = str3.length();
                if (maxSampleCount2 == str4.length()) {
                    break;
                }
                A00[5] = "uTdlUcyBkPhiZ9U2ydDZL";
                if (i10 < rechunkedSampleCount) {
                    int rechunkedSampleCount2 = iArr[i10];
                    int maxSampleCount3 = A00[5].length();
                    if (maxSampleCount3 == 5) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A00;
                    strArr4[2] = "PmQbGcH";
                    strArr4[3] = "fT2ewQCR49";
                    long j3 = jArr[i10];
                    while (rechunkedSampleCount2 > 0) {
                        int maximumSize = Math.min(chunkSamplesRemaining, rechunkedSampleCount2);
                        jArr2[bufferSampleCount] = j3;
                        iArr2[bufferSampleCount] = i2 * maximumSize;
                        originalSampleIndex = Math.max(originalSampleIndex, iArr2[bufferSampleCount]);
                        timestamps[bufferSampleCount] = ((long) i9) * j;
                        flags[bufferSampleCount] = 1;
                        j3 += (long) iArr2[bufferSampleCount];
                        i9 += maximumSize;
                        rechunkedSampleCount2 -= maximumSize;
                        bufferSampleCount++;
                    }
                    i10++;
                } else {
                    return new IR(jArr2, iArr2, originalSampleIndex, timestamps, flags, j * ((long) i9));
                }
            }
        }
        throw new RuntimeException();
    }
}
