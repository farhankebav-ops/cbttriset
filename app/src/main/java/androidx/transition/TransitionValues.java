package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder sbX = a1.a.x("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbX.append(this.view);
        sbX.append("\n");
        String strC = a1.a.C(sbX.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strC = strC + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strC;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
