package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;

    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    private static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i2) {
            return editorInfo.getInitialSelectedText(i2);
        }

        public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i2, int i8) {
            return editorInfo.getInitialTextAfterCursor(i2, i8);
        }

        public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i2, int i8) {
            return editorInfo.getInitialTextBeforeCursor(i2, i8);
        }

        public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i2) {
            editorInfo.setInitialSurroundingSubText(charSequence, i2);
        }
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        return stringArray != null ? stringArray : EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i2) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialSelectedText(editorInfo, i2);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int iMin = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int iMax = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i8 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i9 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i10 = iMax - iMin;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i9 - i8 != i10 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        return (i2 & 1) != 0 ? charSequence.subSequence(i8, i9) : TextUtils.substring(charSequence, i8, i9);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i2, int i8) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextAfterCursor(editorInfo, i2, i8);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i9 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int iMin = Math.min(i2, charSequence.length() - i9);
        return (i8 & 1) != 0 ? charSequence.subSequence(i9, iMin + i9) : TextUtils.substring(charSequence, i9, iMin + i9);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i2, int i8) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextBeforeCursor(editorInfo, i2, i8);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i9 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int iMin = Math.min(i2, i9);
        return (i8 & 1) != 0 ? charSequence.subSequence(i9 - iMin, i9) : TextUtils.substring(charSequence, i9 - iMin, i9);
    }

    public static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean zContainsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean zContainsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (zContainsKey && zContainsKey2) {
            return 4;
        }
        if (zContainsKey) {
            return 3;
        }
        return zContainsKey2 ? 2 : 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i2, int i8) {
        if (i8 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i2));
        }
        if (i8 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i2));
    }

    private static boolean isPasswordInputType(int i2) {
        int i8 = i2 & 4095;
        return i8 == 129 || i8 == 225 || i8 == 18;
    }

    public static boolean isStylusHandwritingEnabled(@NonNull EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i2) {
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, i2);
            return;
        }
        int i8 = editorInfo.initialSelStart;
        int i9 = editorInfo.initialSelEnd;
        int i10 = i8 > i9 ? i9 - i2 : i8 - i2;
        int i11 = i8 > i9 ? i8 - i2 : i9 - i2;
        int length = charSequence.length();
        if (i2 < 0 || i10 < 0 || i11 > length) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i10, i11);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i10, i11);
        }
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(@NonNull EditorInfo editorInfo, boolean z2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, z2);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i2, int i8) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i2);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i8);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i2, int i8) {
        int i9 = i8 - i2;
        int i10 = i9 > 1024 ? 0 : i9;
        int i11 = 2048 - i10;
        int iMin = Math.min(charSequence.length() - i8, i11 - Math.min(i2, (int) (((double) i11) * 0.8d)));
        int iMin2 = Math.min(i2, i11 - iMin);
        int i12 = i2 - iMin2;
        if (isCutOnSurrogate(charSequence, i12, 0)) {
            i12++;
            iMin2--;
        }
        if (isCutOnSurrogate(charSequence, (i8 + iMin) - 1, 1)) {
            iMin--;
        }
        setSurroundingText(editorInfo, i10 != i9 ? TextUtils.concat(charSequence.subSequence(i12, i12 + iMin2), charSequence.subSequence(i8, iMin + i8)) : charSequence.subSequence(i12, iMin2 + i10 + iMin + i12), iMin2, i10 + iMin2);
    }
}
