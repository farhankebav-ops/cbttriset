package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> map = new HashMap<>();
        sKeyMakers = map;
        try {
            map.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(null));
            sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(null));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "unable to load", e);
        }
    }

    public KeyFrames() {
    }

    public static String name(int i2, Context context) {
        return context.getResources().getResourceEntryName(i2);
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Key key = arrayList2.get(i2);
                i2++;
                Key key2 = key;
                if (key2.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key2);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i2) {
        return this.mFramesMap.get(Integer.valueOf(i2));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        int eventType;
        Key key;
        HashMap<String, ConstraintAttribute> map;
        HashMap<String, ConstraintAttribute> map2;
        Key keyTimeCycle;
        try {
            eventType = xmlPullParser.getEventType();
            key = null;
        } catch (IOException e) {
            Log.e(TAG, "Error parsing XML resource", e);
            return;
        } catch (XmlPullParserException e4) {
            Log.e(TAG, "Error parsing XML resource", e4);
            return;
        }
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3 && ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                    return;
                }
            } else {
                String name = xmlPullParser.getName();
                if (sKeyMakers.containsKey(name)) {
                    switch (name.hashCode()) {
                        case -300573030:
                            if (name.equals("KeyTimeCycle")) {
                                keyTimeCycle = new KeyTimeCycle();
                                keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(keyTimeCycle);
                                key = keyTimeCycle;
                            } else {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            break;
                        case -298435811:
                            if (name.equals("KeyAttribute")) {
                                keyTimeCycle = new KeyAttributes();
                                keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(keyTimeCycle);
                                key = keyTimeCycle;
                            } else {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            break;
                        case 540053991:
                            if (name.equals(TypedValues.CycleType.NAME)) {
                                keyTimeCycle = new KeyCycle();
                                keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(keyTimeCycle);
                                key = keyTimeCycle;
                            } else {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            break;
                        case 1153397896:
                            if (name.equals(TypedValues.PositionType.NAME)) {
                                keyTimeCycle = new KeyPosition();
                                keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(keyTimeCycle);
                                key = keyTimeCycle;
                            } else {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            break;
                        case 1308496505:
                            if (name.equals(TypedValues.TriggerType.NAME)) {
                                keyTimeCycle = new KeyTrigger();
                                keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(keyTimeCycle);
                                key = keyTimeCycle;
                            } else {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            break;
                        default:
                            throw new NullPointerException("Key " + name + " not found");
                    }
                    return;
                }
                if (name.equalsIgnoreCase("CustomAttribute")) {
                    if (key != null && (map2 = key.mCustomConstraints) != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, map2);
                    }
                } else if (name.equalsIgnoreCase("CustomMethod") && key != null && (map = key.mCustomConstraints) != null) {
                    ConstraintAttribute.parse(context, xmlPullParser, map);
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
