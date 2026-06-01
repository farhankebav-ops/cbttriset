package com.pgl.ssdk;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class p0 {
    public static Pair<Integer, String> a(String str) {
        Pair<Integer, String> pairCypher4EncryptWithNoWrapBase64 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            pairCypher4EncryptWithNoWrapBase64 = PglCryptUtils.getInstance().cypher4EncryptWithNoWrapBase64(str);
        } catch (Throwable unused) {
        }
        return (pairCypher4EncryptWithNoWrapBase64 == null || ((Integer) pairCypher4EncryptWithNoWrapBase64.first).intValue() != 0 || TextUtils.isEmpty((CharSequence) pairCypher4EncryptWithNoWrapBase64.second)) ? new Pair<>(3, IlO.MY(str)) : new Pair<>(4, pairCypher4EncryptWithNoWrapBase64.second);
    }
}
