package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 {
    public static String a(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public static f0 b(e eVar, List arguments) {
        k.e(arguments, "arguments");
        return new f0(eVar, arguments, 0);
    }
}
