package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout motionLayout);

    void onPostDraw(Canvas canvas);

    void onPreDraw(Canvas canvas);

    void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> map);
}
