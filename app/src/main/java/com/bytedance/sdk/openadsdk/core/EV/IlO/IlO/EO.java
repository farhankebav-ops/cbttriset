package com.bytedance.sdk.openadsdk.core.EV.IlO.IlO;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.EV.EO.IlO;
import com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.Cc;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> EO(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Cc.IlO(xmlPullParser, "Tracking");
    }

    public static void IlO(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.EV.IlO ilO, int i2, double d8) throws XmlPullParserException, IOException {
        boolean z2 = false;
        while (true) {
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals("Linear")) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z2 && TextUtils.isEmpty(ilO.Bc())) {
                        Cc.IlO(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.getClass();
                    switch (name) {
                        case "VideoClicks":
                            IlO(xmlPullParser, ilO);
                            break;
                        case "Duration":
                            ilO.IlO(MY(xmlPullParser));
                            break;
                        case "MediaFiles":
                            IlO(xmlPullParser, i2, d8, ilO);
                            z2 = true;
                            break;
                        case "Icons":
                            com.bytedance.sdk.openadsdk.core.EV.MY myIlO = IlO(xmlPullParser);
                            if (myIlO != null && ilO.MY() == null) {
                                ilO.IlO(myIlO);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "TrackingEvents":
                            IlO(xmlPullParser, ilO.IlO());
                            break;
                        default:
                            Cc.IlO(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    public static double MY(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (Cc.MY(xmlPullParser, "Duration").split(":").length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(r2[1].trim()) * 60) + (Integer.parseInt(r2[0].trim()) * 3600) + Float.parseFloat(r2[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private static String IlO(XmlPullParser xmlPullParser, int i2, double d8, com.bytedance.sdk.openadsdk.core.EV.IlO ilO) throws XmlPullParserException, IOException {
        double d9 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i8 = Integer.MIN_VALUE;
        int i9 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String str2 = Cc.Bc;
                String attributeValue = xmlPullParser.getAttributeValue(str2, "type");
                int iMY = Cc.MY(xmlPullParser.getAttributeValue(str2, "width"));
                int iMY2 = Cc.MY(xmlPullParser.getAttributeValue(str2, "height"));
                int iMY3 = Cc.MY(xmlPullParser.getAttributeValue(str2, "bitrate"));
                String strMY = Cc.MY(xmlPullParser, "MediaFile");
                if (iMY > 0 && iMY2 > 0 && com.bytedance.sdk.openadsdk.core.EV.EO.tV.IlO.contains(attributeValue) && !TextUtils.isEmpty(strMY)) {
                    double dIlO = com.bytedance.sdk.openadsdk.core.EV.EO.tV.IlO(i2, d8, iMY, iMY2, iMY3, attributeValue);
                    if (dIlO > d9) {
                        str = strMY;
                        d9 = dIlO;
                        i8 = iMY;
                        i9 = iMY2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ilO.tV(str);
            ilO.IlO(i8);
            ilO.MY(i9);
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.sdk.openadsdk.core.EV.MY IlO(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.EV.MY my;
        com.bytedance.sdk.openadsdk.core.EV.MY my2;
        int i2;
        int i8;
        int i9;
        IlO.EnumC0084IlO enumC0084IlO;
        com.bytedance.sdk.openadsdk.core.EV.MY my3 = null;
        while (true) {
            int i10 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("Icons")) {
                return my3;
            }
            xmlPullParser.next();
            int i11 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Icon")) {
                String str = Cc.Bc;
                int iMY = Cc.MY(xmlPullParser.getAttributeValue(str, "width"));
                int iMY2 = Cc.MY(xmlPullParser.getAttributeValue(str, "height"));
                if (iMY > 0 && iMY <= 300 && iMY2 > 0 && iMY2 <= 300) {
                    int iIlO = com.bytedance.sdk.openadsdk.core.EV.MY.IlO.IlO(xmlPullParser.getAttributeValue(str, TypedValues.CycleType.S_WAVE_OFFSET));
                    int iIlO2 = com.bytedance.sdk.openadsdk.core.EV.MY.IlO.IlO(xmlPullParser.getAttributeValue(str, "duration"));
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cc.IlO ilO = null;
                    String strMY = null;
                    while (true) {
                        if (xmlPullParser.next() == i10 && xmlPullParser.getName().equals("Icon")) {
                            if (ilO != null && (my3 == null || TextUtils.isEmpty(my3.vCE()))) {
                                my3 = new com.bytedance.sdk.openadsdk.core.EV.MY(iMY, iMY2, iIlO, iIlO2, ilO.MY, ilO.EO, ilO.IlO, arrayList, arrayList2, strMY);
                                Cc.IlO(xmlPullParser, "Icons", i10);
                            }
                        } else {
                            ArrayList arrayList3 = arrayList;
                            ArrayList arrayList4 = arrayList2;
                            if (xmlPullParser.getEventType() == i11) {
                                String name = xmlPullParser.getName();
                                name.getClass();
                                my2 = my3;
                                i2 = iIlO2;
                                switch (name) {
                                    case "IconViewTracking":
                                        i8 = 3;
                                        i9 = 2;
                                        arrayList4.add(new EO.IlO(Cc.MY(xmlPullParser, "IconViewTracking")).IlO());
                                        break;
                                    case "IFrameResource":
                                        i8 = 3;
                                        i9 = 2;
                                        if (ilO == null) {
                                            ilO = new Cc.IlO(Cc.MY(xmlPullParser, "IFrameResource"), IlO.EnumC0084IlO.NONE, IlO.MY.IFRAME_RESOURCE);
                                            break;
                                        } else {
                                            Cc.IlO(xmlPullParser);
                                            break;
                                        }
                                        break;
                                    case "StaticResource":
                                        i8 = 3;
                                        i9 = 2;
                                        IlO.EnumC0084IlO enumC0084IlO2 = IlO.EnumC0084IlO.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(Cc.Bc, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.EV.EO.IlO.IlO;
                                        String strMY2 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.EV.EO.IlO.MY.contains(lowerCase)) ? Cc.MY(xmlPullParser, "StaticResource") : null;
                                        if (set.contains(lowerCase)) {
                                            enumC0084IlO = IlO.EnumC0084IlO.IMAGE;
                                        } else {
                                            enumC0084IlO = IlO.EnumC0084IlO.JAVASCRIPT;
                                        }
                                        ilO = new Cc.IlO(strMY2, enumC0084IlO, IlO.MY.STATIC_RESOURCE);
                                        break;
                                    case "IconClicks":
                                        while (true) {
                                            i8 = 3;
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("IconClicks")) {
                                                i9 = 2;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2) {
                                                if (xmlPullParser.getName().equals("IconClickThrough")) {
                                                    strMY = Cc.MY(xmlPullParser, "IconClickThrough");
                                                } else if (xmlPullParser.getName().equals("IconClickTracking")) {
                                                    arrayList3.add(new EO.IlO(Cc.MY(xmlPullParser, "IconClickTracking")).IlO());
                                                }
                                            }
                                        }
                                        break;
                                    case "HTMLResource":
                                        if (ilO == null || ilO.EO == IlO.MY.IFRAME_RESOURCE) {
                                            ilO = new Cc.IlO(Cc.MY(xmlPullParser, "HTMLResource"), IlO.EnumC0084IlO.NONE, IlO.MY.HTML_RESOURCE);
                                            my3 = my2;
                                            iIlO2 = i2;
                                            i10 = 3;
                                            i11 = 2;
                                            break;
                                        }
                                        i8 = 3;
                                        i9 = 2;
                                        Cc.IlO(xmlPullParser);
                                        break;
                                    default:
                                        i8 = 3;
                                        i9 = 2;
                                        Cc.IlO(xmlPullParser);
                                        break;
                                }
                                arrayList = arrayList3;
                                arrayList2 = arrayList4;
                            } else {
                                my2 = my3;
                                i2 = iIlO2;
                                i8 = i10;
                                i9 = i11;
                            }
                            i10 = i8;
                            i11 = i9;
                            my3 = my2;
                            iIlO2 = i2;
                            arrayList = arrayList3;
                            arrayList2 = arrayList4;
                        }
                    }
                } else {
                    my = my3;
                    Cc.IlO(xmlPullParser);
                    my3 = my;
                }
            } else {
                my = my3;
                my3 = my;
            }
        }
    }

    public static void IlO(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.EV.tV tVVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(Cc.Bc, NotificationCompat.CATEGORY_EVENT);
                    if (TextUtils.isEmpty(attributeValue)) {
                        Cc.IlO(xmlPullParser, "Tracking", 3);
                    } else {
                        attributeValue.getClass();
                        switch (attributeValue) {
                            case "midpoint":
                                tVVar.IlO(Cc.MY(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case "thirdQuartile":
                                tVVar.IlO(Cc.MY(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case "resume":
                                tVVar.EO(EO(xmlPullParser));
                                break;
                            case "unmute":
                                tVVar.rp(EO(xmlPullParser));
                                break;
                            case "complete":
                                tVVar.tV(EO(xmlPullParser));
                                break;
                            case "mute":
                                tVVar.EV(EO(xmlPullParser));
                                break;
                            case "skip":
                                tVVar.vCE(EO(xmlPullParser));
                                break;
                            case "close":
                                tVVar.Cc(EO(xmlPullParser));
                                break;
                            case "pause":
                                tVVar.MY(EO(xmlPullParser));
                                break;
                            case "start":
                            case "creativeView":
                                tVVar.IlO(Cc.MY(xmlPullParser, "Tracking"), 0L);
                                break;
                            case "firstQuartile":
                                tVVar.IlO(Cc.MY(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    Cc.IlO(xmlPullParser);
                }
            }
        }
    }

    private static void IlO(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.EV.IlO ilO) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.getClass();
                if (name.equals("ClickThrough")) {
                    ilO.EO(Cc.MY(xmlPullParser, "ClickThrough"));
                } else if (!name.equals("ClickTracking")) {
                    Cc.IlO(xmlPullParser);
                } else {
                    ilO.IlO().Bc(Cc.IlO(xmlPullParser, "ClickTracking"));
                }
            }
        }
    }
}
