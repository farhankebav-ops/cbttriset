package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class HexDumpUtils {
    @Nullable
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i2, int i8, boolean z2) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i2 < 0 || i8 <= 0 || i2 + i8 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((i8 + 15) / 16) * (z2 ? 75 : 57));
        int i9 = i8;
        int i10 = 0;
        int i11 = 0;
        while (i9 > 0) {
            if (i10 == 0) {
                if (i8 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i2)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i2)));
                }
                i11 = i2;
            } else if (i10 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i2] & 255)));
            i9--;
            i10++;
            if (z2 && (i10 == 16 || i9 == 0)) {
                int i12 = 16 - i10;
                if (i12 > 0) {
                    for (int i13 = 0; i13 < i12; i13++) {
                        sb.append("   ");
                    }
                }
                if (i12 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i14 = 0; i14 < i10; i14++) {
                    char c7 = (char) bArr[i11 + i14];
                    if (c7 < ' ' || c7 > '~') {
                        c7 = '.';
                    }
                    sb.append(c7);
                }
            }
            if (i10 == 16 || i9 == 0) {
                sb.append('\n');
                i10 = 0;
            }
            i2++;
        }
        return sb.toString();
    }
}
