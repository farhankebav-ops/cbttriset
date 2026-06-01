package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import e6.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.i;
import q5.x;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> initialState, l builderAction) {
        i[] iVarArr;
        k.e(initialState, "initialState");
        k.e(builderAction, "builderAction");
        if (initialState.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(initialState.size());
            for (Map.Entry<String, ? extends Object> entry : initialState.entrySet()) {
                arrayList.add(new i(entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        builderAction.invoke(SavedStateWriter.m167boximpl(SavedStateWriter.m169constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle initialState, l builderAction, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            builderAction = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.3
                @Override // e6.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m81invokexApjlu4(((SavedStateWriter) obj2).m207unboximpl());
                    return x.f13520a;
                }

                /* JADX INFO: renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m81invokexApjlu4(Bundle bundle) {
                    k.e(bundle, "<this>");
                }
            };
        }
        k.e(initialState, "initialState");
        k.e(builderAction, "builderAction");
        Bundle bundle = new Bundle(initialState);
        builderAction.invoke(SavedStateWriter.m167boximpl(SavedStateWriter.m169constructorimpl(bundle)));
        return bundle;
    }

    public static Bundle savedState$default(Map initialState, l builderAction, int i2, Object obj) {
        i[] iVarArr;
        if ((i2 & 1) != 0) {
            initialState = s.f13639a;
        }
        if ((i2 & 2) != 0) {
            builderAction = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.1
                @Override // e6.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m80invokexApjlu4(((SavedStateWriter) obj2).m207unboximpl());
                    return x.f13520a;
                }

                /* JADX INFO: renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m80invokexApjlu4(Bundle bundle) {
                    k.e(bundle, "<this>");
                }
            };
        }
        k.e(initialState, "initialState");
        k.e(builderAction, "builderAction");
        if (initialState.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(initialState.size());
            for (Map.Entry entry : initialState.entrySet()) {
                arrayList.add(new i((String) entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        builderAction.invoke(SavedStateWriter.m167boximpl(SavedStateWriter.m169constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static final Bundle savedState(Bundle initialState, l builderAction) {
        k.e(initialState, "initialState");
        k.e(builderAction, "builderAction");
        Bundle bundle = new Bundle(initialState);
        builderAction.invoke(SavedStateWriter.m167boximpl(SavedStateWriter.m169constructorimpl(bundle)));
        return bundle;
    }
}
