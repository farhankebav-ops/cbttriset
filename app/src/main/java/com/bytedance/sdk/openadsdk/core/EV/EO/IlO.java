package com.bytedance.sdk.openadsdk.core.EV.EO;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static final Set<String> IlO = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.EV.EO.IlO.1
        {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> MY = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.EV.EO.IlO.2
        {
            add("application/x-javascript");
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.EV.EO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum EnumC0084IlO {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum MY {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    @NonNull
    public static Point IlO(Context context, int i2, int i8, MY my) {
        if (context == null) {
            context = cl.IlO();
        }
        Point point = new Point(i2, i8);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int iMY = BS.MY(context, i2);
        int iMY2 = BS.MY(context, i8);
        if (iMY > width || iMY2 > height) {
            Point point2 = new Point();
            if (MY.HTML_RESOURCE == my) {
                point2.x = Math.min(width, iMY);
                point2.y = Math.min(height, iMY2);
            } else {
                float f4 = iMY;
                float f8 = f4 / width;
                float f9 = iMY2;
                float f10 = f9 / height;
                if (f8 >= f10) {
                    point2.x = width;
                    point2.y = (int) (f9 / f8);
                } else {
                    point2.x = (int) (f4 / f10);
                    point2.y = height;
                }
            }
            int i9 = point2.x;
            if (i9 >= 0 && point2.y >= 0) {
                point2.x = BS.EO(context, i9);
                point2.y = BS.EO(context, point2.y);
                return point2;
            }
        }
        return point;
    }
}
