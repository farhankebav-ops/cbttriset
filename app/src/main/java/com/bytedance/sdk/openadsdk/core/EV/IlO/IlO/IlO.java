package com.bytedance.sdk.openadsdk.core.EV.IlO.IlO;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.core.EV.EO.IlO;
import com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.Cc;
import java.io.IOException;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.sdk.openadsdk.core.EV.EO IlO(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        float f4;
        com.bytedance.sdk.openadsdk.core.EV.EO eo;
        Cc.IlO ilO;
        int i2;
        byte b8;
        if (context == null) {
            Cc.IlO(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i8 = displayMetrics.widthPixels;
        int i9 = displayMetrics.heightPixels;
        float f8 = displayMetrics.density;
        int i10 = (int) (i8 / f8);
        int i11 = (int) (i9 / f8);
        float f9 = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.EV.EO eo2 = null;
        while (true) {
            int i12 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("CompanionAds")) {
                return eo2;
            }
            xmlPullParser.next();
            int i13 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Companion")) {
                String str = Cc.Bc;
                int iMY = Cc.MY(xmlPullParser.getAttributeValue(str, "width"));
                int iMY2 = Cc.MY(xmlPullParser.getAttributeValue(str, "height"));
                if (iMY < 300 || iMY2 < 250) {
                    f4 = f9;
                    eo = eo2;
                    Cc.IlO(xmlPullParser);
                    f9 = f4;
                    eo2 = eo;
                } else {
                    Cc.IlO ilO2 = new Cc.IlO();
                    while (true) {
                        if (xmlPullParser.getEventType() != i12 || !xmlPullParser.getName().equals("Companion")) {
                            int i14 = iMY2;
                            int i15 = iMY;
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == i13) {
                                String name = xmlPullParser.getName();
                                name.getClass();
                                float f10 = f9;
                                com.bytedance.sdk.openadsdk.core.EV.EO eo3 = eo2;
                                byte b9 = -1;
                                switch (name.hashCode()) {
                                    case -375340334:
                                        if (name.equals("IFrameResource")) {
                                            b8 = 0;
                                            b9 = b8;
                                        }
                                        break;
                                    case -348198615:
                                        if (name.equals("CompanionClickThrough")) {
                                            b8 = 1;
                                            b9 = b8;
                                        }
                                        break;
                                    case 611554000:
                                        if (name.equals("TrackingEvents")) {
                                            b9 = 2;
                                        }
                                        break;
                                    case 676623548:
                                        if (name.equals("StaticResource")) {
                                            b9 = 3;
                                        }
                                        break;
                                    case 1877773523:
                                        if (name.equals("CompanionClickTracking")) {
                                            b8 = 4;
                                            b9 = b8;
                                        }
                                        break;
                                    case 1928285401:
                                        if (name.equals("HTMLResource")) {
                                            b8 = 5;
                                            b9 = b8;
                                        }
                                        break;
                                }
                                switch (b9) {
                                    case 0:
                                        Cc.IlO ilO3 = ilO2;
                                        i2 = 2;
                                        Point pointIlO = com.bytedance.sdk.openadsdk.core.EV.EO.IlO.IlO(context, i15, i14, IlO.MY.HTML_RESOURCE);
                                        int i16 = pointIlO.x;
                                        int i17 = pointIlO.y;
                                        IlO.MY my = IlO.MY.IFRAME_RESOURCE;
                                        IlO.EnumC0084IlO enumC0084IlO = IlO.EnumC0084IlO.NONE;
                                        float fIlO = com.bytedance.sdk.openadsdk.core.EV.EO.IlO(i10, i11, i16, i17, my, enumC0084IlO);
                                        String strMY = Cc.MY(xmlPullParser, "IFrameResource");
                                        if (!TextUtils.isEmpty(strMY) && fIlO > ilO3.Bc && fIlO > f10) {
                                            ilO3.Bc = fIlO;
                                            ilO3.IlO(strMY, enumC0084IlO, my);
                                            ilO2 = ilO3;
                                            i13 = i2;
                                            iMY = i15;
                                            iMY2 = i14;
                                            f9 = f10;
                                            eo2 = eo3;
                                            i12 = 3;
                                        } else {
                                            Cc.IlO(xmlPullParser, "IFrameResource", 3);
                                            ilO2 = ilO3;
                                            i12 = 3;
                                            i13 = 2;
                                            iMY = i15;
                                            iMY2 = i14;
                                            f9 = f10;
                                            eo2 = eo3;
                                        }
                                        break;
                                    case 1:
                                        i2 = 2;
                                        ilO2.tV = Cc.MY(xmlPullParser, "CompanionClickThrough");
                                        i13 = i2;
                                        iMY = i15;
                                        iMY2 = i14;
                                        f9 = f10;
                                        eo2 = eo3;
                                        i12 = 3;
                                        break;
                                    case 2:
                                        ilO = ilO2;
                                        while (true) {
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                iMY = i15;
                                                ilO2 = ilO;
                                                iMY2 = i14;
                                                f9 = f10;
                                                eo2 = eo3;
                                                i12 = 3;
                                                i13 = 2;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                ilO.MY(Cc.MY(xmlPullParser, "Tracking"));
                                            }
                                        }
                                        break;
                                    case 3:
                                        ilO = ilO2;
                                        IlO.EnumC0084IlO enumC0084IlO2 = IlO.EnumC0084IlO.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(Cc.Bc, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.EV.EO.IlO.IlO;
                                        IlO.EnumC0084IlO enumC0084IlO3 = set.contains(lowerCase) ? IlO.EnumC0084IlO.IMAGE : IlO.EnumC0084IlO.JAVASCRIPT;
                                        IlO.MY my2 = IlO.MY.STATIC_RESOURCE;
                                        Point pointIlO2 = com.bytedance.sdk.openadsdk.core.EV.EO.IlO.IlO(context, i15, i14, my2);
                                        float fIlO2 = com.bytedance.sdk.openadsdk.core.EV.EO.IlO(i10, i11, pointIlO2.x, pointIlO2.y, my2, enumC0084IlO3);
                                        String strMY2 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.EV.EO.IlO.MY.contains(lowerCase)) ? Cc.MY(xmlPullParser, "StaticResource") : null;
                                        if (fIlO2 >= ilO.Bc && fIlO2 > f10 && !TextUtils.isEmpty(strMY2)) {
                                            ilO.Bc = fIlO2;
                                            ilO.IlO(strMY2, enumC0084IlO3, my2);
                                            iMY = i15;
                                            ilO2 = ilO;
                                            iMY2 = i14;
                                            f9 = f10;
                                            eo2 = eo3;
                                            i12 = 3;
                                            i13 = 2;
                                        } else {
                                            Cc.IlO(xmlPullParser, "StaticResource", 3);
                                            iMY = i15;
                                            ilO2 = ilO;
                                            iMY2 = i14;
                                            f9 = f10;
                                            i13 = 2;
                                            i12 = 3;
                                            eo2 = eo3;
                                        }
                                        break;
                                    case 4:
                                        ilO2.IlO(Cc.MY(xmlPullParser, "CompanionClickTracking"));
                                        iMY = i15;
                                        iMY2 = i14;
                                        f9 = f10;
                                        eo2 = eo3;
                                        i12 = 3;
                                        i13 = 2;
                                        break;
                                    case 5:
                                        IlO.MY my3 = IlO.MY.HTML_RESOURCE;
                                        Point pointIlO3 = com.bytedance.sdk.openadsdk.core.EV.EO.IlO.IlO(context, i15, i14, my3);
                                        int i18 = pointIlO3.x;
                                        int i19 = pointIlO3.y;
                                        IlO.EnumC0084IlO enumC0084IlO4 = IlO.EnumC0084IlO.NONE;
                                        ilO = ilO2;
                                        float fIlO3 = com.bytedance.sdk.openadsdk.core.EV.EO.IlO(i10, i11, i18, i19, my3, enumC0084IlO4);
                                        String strMY3 = Cc.MY(xmlPullParser, "HTMLResource");
                                        if (!TextUtils.isEmpty(strMY3) && fIlO3 > ilO.Bc && fIlO3 > f10) {
                                            ilO.Bc = fIlO3;
                                            ilO.IlO(strMY3, enumC0084IlO4, my3);
                                            iMY = i15;
                                            ilO2 = ilO;
                                            iMY2 = i14;
                                            f9 = f10;
                                            eo2 = eo3;
                                            i12 = 3;
                                            i13 = 2;
                                        } else {
                                            Cc.IlO(xmlPullParser, "HTMLResource", 3);
                                            iMY = i15;
                                            ilO2 = ilO;
                                            iMY2 = i14;
                                            f9 = f10;
                                            eo2 = eo3;
                                            i13 = 2;
                                            i12 = 3;
                                        }
                                        break;
                                    default:
                                        Cc.IlO(xmlPullParser);
                                        ilO = ilO2;
                                        iMY = i15;
                                        ilO2 = ilO;
                                        iMY2 = i14;
                                        f9 = f10;
                                        eo2 = eo3;
                                        i12 = 3;
                                        i13 = 2;
                                        break;
                                }
                            } else {
                                iMY = i15;
                                iMY2 = i14;
                            }
                        } else if (!TextUtils.isEmpty(ilO2.IlO) && ilO2.Bc >= f9) {
                            com.bytedance.sdk.openadsdk.core.EV.EO eo4 = new com.bytedance.sdk.openadsdk.core.EV.EO(iMY, iMY2, ilO2.MY, ilO2.EO, ilO2.IlO, ilO2.Cc, ilO2.vCE, ilO2.tV);
                            f9 = ilO2.Bc;
                            eo2 = eo4;
                        }
                    }
                }
            } else {
                f4 = f9;
                eo = eo2;
                f9 = f4;
                eo2 = eo;
            }
        }
    }
}
