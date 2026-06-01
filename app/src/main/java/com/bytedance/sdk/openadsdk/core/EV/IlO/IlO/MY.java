package com.bytedance.sdk.openadsdk.core.EV.IlO.IlO;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static com.bytedance.sdk.openadsdk.core.EV.IlO IlO(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list, int i2, double d8) throws XmlPullParserException, IOException {
        String name;
        xmlPullParser.require(2, Cc.Bc, "InLine");
        com.bytedance.sdk.openadsdk.core.EV.IlO ilO = new com.bytedance.sdk.openadsdk.core.EV.IlO();
        while (true) {
            if (xmlPullParser.next() == 3 && "InLine".equals(xmlPullParser.getName())) {
                ilO.IlO().NV(list);
                return ilO;
            }
            if (xmlPullParser.getEventType() == 2) {
                name = xmlPullParser.getName();
                name.getClass();
                switch (name) {
                    case "AdVerifications":
                        ilO.IlO(tV.IlO(xmlPullParser));
                        context = context;
                        break;
                    case "Creatives":
                        if (TextUtils.isEmpty(ilO.Bc()) || ilO.EO() == null) {
                            while (xmlPullParser.next() != 3) {
                                if (xmlPullParser.getEventType() == 2) {
                                    if ("Creative".equals(xmlPullParser.getName())) {
                                        IlO(context, xmlPullParser, ilO, i2, d8);
                                    } else {
                                        Cc.IlO(xmlPullParser);
                                    }
                                }
                            }
                        } else {
                            Cc.IlO(xmlPullParser);
                        }
                        context = context;
                        xmlPullParser = xmlPullParser;
                        i2 = i2;
                        d8 = d8;
                        break;
                    case "Description":
                        ilO.MY(Cc.MY(xmlPullParser, name));
                        break;
                    case "Error":
                        list.addAll(Cc.IlO(xmlPullParser, name));
                        break;
                    case "Extensions":
                        while (true) {
                            if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                context = context;
                                xmlPullParser = xmlPullParser;
                                i2 = i2;
                                d8 = d8;
                                break;
                            } else {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                    ilO.IlO(tV.IlO(xmlPullParser));
                                }
                            }
                        }
                        break;
                    case "AdTitle":
                        ilO.IlO(Cc.MY(xmlPullParser, name));
                        break;
                    case "Impression":
                        ilO.IlO().IlO(Cc.IlO(xmlPullParser, name));
                        break;
                    default:
                        Cc.IlO(xmlPullParser);
                        context = context;
                        xmlPullParser = xmlPullParser;
                        i2 = i2;
                        d8 = d8;
                        break;
                }
            }
        }
    }

    public static void IlO(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.EV.IlO ilO, int i2, double d8) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(ilO.Bc())) {
                    EO.IlO(xmlPullParser, ilO, i2, d8);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && ilO.EO() == null) {
                    ilO.IlO(IlO.IlO(context, xmlPullParser));
                } else {
                    Cc.IlO(xmlPullParser);
                }
            }
        }
    }
}
