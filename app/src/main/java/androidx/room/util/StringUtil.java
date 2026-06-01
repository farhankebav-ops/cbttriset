package androidx.room.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import n6.m;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder builder, int i2) {
        k.e(builder, "builder");
        for (int i8 = 0; i8 < i2; i8++) {
            builder.append("?");
            if (i8 < i2 - 1) {
                builder.append(",");
            }
        }
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return l.c1(list, ",", null, null, null, 62);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        Integer numValueOf;
        if (str == null) {
            return null;
        }
        List listJ0 = m.J0(str, new char[]{','});
        ArrayList arrayList = new ArrayList();
        Iterator it = listJ0.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException e) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e);
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }
}
