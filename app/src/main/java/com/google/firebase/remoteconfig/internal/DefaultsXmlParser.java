package com.google.firebase.remoteconfig.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    /* JADX WARN: Removed duplicated region for block: B:41:0x007e A[Catch: IOException -> 0x0013, XmlPullParserException -> 0x0016, TryCatch #2 {IOException -> 0x0013, XmlPullParserException -> 0x0016, blocks: (B:3:0x0007, B:5:0x000d, B:11:0x0019, B:16:0x002b, B:42:0x0083, B:19:0x0033, B:23:0x0043, B:24:0x0047, B:30:0x0055, B:41:0x007e, B:35:0x0064, B:37:0x006c, B:38:0x0071, B:40:0x0079), top: B:47:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> getDefaultsFromXml(android.content.Context r7, int r8) {
        /*
            java.lang.String r0 = "FirebaseRemoteConfig"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.res.Resources r7 = r7.getResources()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r7 != 0) goto L19
            java.lang.String r7 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r0, r7)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            return r1
        L13:
            r7 = move-exception
            goto L89
        L16:
            r7 = move-exception
            goto L89
        L19:
            android.content.res.XmlResourceParser r7 = r7.getXml(r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            int r8 = r7.getEventType()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L25:
            r6 = 1
            if (r8 == r6) goto L88
            r6 = 2
            if (r8 != r6) goto L30
            java.lang.String r3 = r7.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L83
        L30:
            r6 = 3
            if (r8 != r6) goto L50
            java.lang.String r8 = r7.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            java.lang.String r3 = "entry"
            boolean r8 = r8.equals(r3)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r8 == 0) goto L4e
            if (r4 == 0) goto L47
            if (r5 == 0) goto L47
            r1.put(r4, r5)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L4c
        L47:
            java.lang.String r8 = "An entry in the defaults XML has an invalid key and/or value tag."
            android.util.Log.w(r0, r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L4c:
            r4 = r2
            r5 = r4
        L4e:
            r3 = r2
            goto L83
        L50:
            r6 = 4
            if (r8 != r6) goto L83
            if (r3 == 0) goto L83
            int r8 = r3.hashCode()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r6 = 106079(0x19e5f, float:1.48648E-40)
            if (r8 == r6) goto L71
            r6 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r8 == r6) goto L64
            goto L7e
        L64:
            java.lang.String r8 = "value"
            boolean r8 = r3.equals(r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r8 == 0) goto L7e
            java.lang.String r5 = r7.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L83
        L71:
            java.lang.String r8 = "key"
            boolean r8 = r3.equals(r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r8 == 0) goto L7e
            java.lang.String r4 = r7.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L83
        L7e:
            java.lang.String r8 = "Encountered an unexpected tag while parsing the defaults XML."
            android.util.Log.w(r0, r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L83:
            int r8 = r7.next()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L25
        L88:
            return r1
        L89:
            java.lang.String r8 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r0, r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.DefaultsXmlParser.getDefaultsFromXml(android.content.Context, int):java.util.Map");
    }
}
