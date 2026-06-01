package q;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13342a = new a(0);

    public static Animation a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        String name;
        int depth = xmlPullParser.getDepth();
        Animation rotateAnimation = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    name = xmlPullParser.getName();
                    name.getClass();
                    switch (name) {
                        case "rotate":
                            rotateAnimation = new RotateAnimation(context, attributeSet);
                            break;
                        case "set":
                            AnimationSet animationSet2 = new AnimationSet(context, attributeSet);
                            a(context, xmlPullParser, animationSet2, attributeSet);
                            rotateAnimation = animationSet2;
                            break;
                        case "alpha":
                            rotateAnimation = new AlphaAnimation(context, attributeSet);
                            break;
                        case "scale":
                            rotateAnimation = new ScaleAnimation(context, attributeSet);
                            break;
                        case "translate":
                            rotateAnimation = new TranslateAnimation(context, attributeSet);
                            break;
                        default:
                            try {
                                rotateAnimation = (Animation) Class.forName(name).getConstructor(Context.class, AttributeSet.class).newInstance(context, attributeSet);
                                break;
                            } catch (Exception e) {
                                throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName() + " error:" + e.getMessage());
                            }
                            break;
                    }
                    if (animationSet != null) {
                        animationSet.addAnimation(rotateAnimation);
                    }
                }
            }
        }
        return rotateAnimation;
    }

    public static Animation b(Context context, int i2) throws Throwable {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser animation = context.getResources().getAnimation(i2);
                try {
                    Animation animationA = a(context, animation, null, Xml.asAttributeSet(animation));
                    animation.close();
                    return animationA;
                } catch (IOException e) {
                    e = e;
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e);
                    throw notFoundException;
                } catch (XmlPullParserException e4) {
                    e = e4;
                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException2.initCause(e);
                    throw notFoundException2;
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = animation;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            } catch (XmlPullParserException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
