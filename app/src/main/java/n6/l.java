package n6;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f13103a;

    public l(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
        this.f13103a = patternCompile;
    }

    public final e2.h a(int i2, String input) {
        kotlin.jvm.internal.k.e(input, "input");
        Matcher matcherRegion = this.f13103a.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i2, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        kotlin.jvm.internal.k.e(input, "input");
        e2.h hVar = new e2.h();
        hVar.f11231a = matcherRegion;
        hVar.f11232b = new k(hVar);
        return hVar;
    }

    public final String toString() {
        String string = this.f13103a.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }
}
