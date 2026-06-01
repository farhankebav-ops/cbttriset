package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class ViewUtils {
    private ViewUtils() {
    }

    @Nullable
    @KeepForSdk
    public static String getXmlAttributeString(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z2, boolean z7, @NonNull String str3) {
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z2) {
            String strSubstring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 8 + String.valueOf(strSubstring).length());
                sb.append(packageName);
                sb.append(":string/");
                sb.append(strSubstring);
                resources.getValue(sb.toString(), typedValue, true);
            } catch (Resources.NotFoundException unused) {
                Log.w(str3, a.n(new StringBuilder(String.valueOf(str2).length() + 30 + attributeValue.length()), "Could not find resource for ", str2, ": ", attributeValue));
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                String string = typedValue.toString();
                Log.w(str3, a.n(new StringBuilder(String.valueOf(str2).length() + 28 + string.length()), "Resource ", str2, " was not a string: ", string));
            }
        }
        if (z7 && attributeValue == null) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 33);
            sb2.append("Required XML attribute \"");
            sb2.append(str2);
            sb2.append("\" missing");
            Log.w(str3, sb2.toString());
        }
        return attributeValue;
    }
}
