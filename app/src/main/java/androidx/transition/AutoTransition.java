package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        init();
    }

    private void init() {
        setOrdering(1);
        addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }

    public AutoTransition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
