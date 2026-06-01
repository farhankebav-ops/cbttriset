package sg.bigo.ads.core.f;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(org.w3c.dom.Node r5) {
        /*
            if (r5 == 0) goto L34
            boolean r0 = r5.hasChildNodes()
            if (r0 == 0) goto L34
            org.w3c.dom.NodeList r0 = r5.getChildNodes()
            int r1 = r0.getLength()
            r2 = 5
            int r1 = java.lang.Math.min(r1, r2)
            if (r1 <= 0) goto L34
            r2 = 0
        L18:
            if (r2 >= r1) goto L34
            org.w3c.dom.Node r3 = r0.item(r2)
            boolean r4 = r3 instanceof org.w3c.dom.CDATASection
            if (r4 == 0) goto L31
            java.lang.String r4 = r3.getNodeValue()
            if (r4 == 0) goto L31
            java.lang.String r5 = r3.getNodeValue()
        L2c:
            java.lang.String r5 = r5.trim()
            return r5
        L31:
            int r2 = r2 + 1
            goto L18
        L34:
            if (r5 == 0) goto L4f
            org.w3c.dom.Node r0 = r5.getFirstChild()
            if (r0 == 0) goto L4f
            org.w3c.dom.Node r0 = r5.getFirstChild()
            java.lang.String r0 = r0.getNodeValue()
            if (r0 == 0) goto L4f
            org.w3c.dom.Node r5 = r5.getFirstChild()
            java.lang.String r5 = r5.getNodeValue()
            goto L2c
        L4f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.f.a.a(org.w3c.dom.Node):java.lang.String");
    }

    public static String b(Node node) {
        if (node != null && node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node nodeItem = childNodes.item(i2);
                if (nodeItem != null && !q.b(nodeItem.getNodeValue())) {
                    return nodeItem.getNodeValue();
                }
            }
        }
        return null;
    }

    public static List<Node> c(Node node, String str) {
        return b(node, str, null, null);
    }

    public static Integer d(Node node, String str) {
        if (node == null) {
            return -1;
        }
        String strE = e(node, str);
        if (q.a((CharSequence) strE)) {
            return -1;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strE));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String e(Node node, String str) {
        Node namedItem;
        if (node == null || str == null || (namedItem = node.getAttributes().getNamedItem(str)) == null) {
            return null;
        }
        return namedItem.getNodeValue();
    }

    public static Node a(Node node, String str) {
        return a(node, str, null, null);
    }

    @Nullable
    public static String b(Node node, String str) {
        Node nodeA = a(node, str, null, null);
        if (nodeA == null) {
            return null;
        }
        String strB = b(nodeA);
        if (q.a((CharSequence) strB)) {
            return null;
        }
        return strB;
    }

    public static Node a(Node node, String str, String str2, List<String> list) {
        List<Node> listB;
        if (node == null || str == null || (listB = b(node, str, str2, list)) == null || listB.isEmpty()) {
            return null;
        }
        return listB.get(0);
    }

    public static List<Node> b(Node node, String str, String str2, List<String> list) {
        if (node == null || str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem.getNodeName().equals(str) && a(nodeItem, str2, list)) {
                arrayList.add(nodeItem);
            }
        }
        return arrayList;
    }

    private static boolean a(Node node, String str, List<String> list) {
        Node namedItem;
        if (str == null || list == null) {
            return true;
        }
        NamedNodeMap attributes = node.getAttributes();
        return (attributes == null || (namedItem = attributes.getNamedItem(str)) == null || !list.contains(namedItem.getNodeValue())) ? false : true;
    }
}
