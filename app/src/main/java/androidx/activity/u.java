package androidx.activity;

import android.content.res.Resources;
import androidx.activity.SystemBarStyle;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.datastore.core.CorruptionException;
import androidx.savedstate.serialization.SavedStateConfig_androidKt;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import f7.c1;
import h7.c0;
import java.util.List;
import java.util.Map;
import q5.x;
import q6.w;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements e6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3334a;

    public /* synthetic */ u(int i2) {
        this.f3334a = i2;
    }

    @Override // e6.l
    public final Object invoke(Object obj) {
        switch (this.f3334a) {
            case 0:
                return Boolean.valueOf(SystemBarStyle.Companion.light$lambda$2((Resources) obj));
            case 1:
                return Boolean.valueOf(SystemBarStyle.Companion.dark$lambda$1((Resources) obj));
            case 2:
                return Boolean.valueOf(SystemBarStyle.Companion.auto$lambda$0((Resources) obj));
            case 3:
                return ProcessCameraProvider.Companion.getInstance$lambda$0((Void) obj);
            case 4:
                return SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0((List) obj);
            case 5:
                d7.a buildSerialDescriptor = (d7.a) obj;
                kotlin.jvm.internal.k.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.f11174b = r.f13638a;
                return x.f13520a;
            case 6:
                l6.c it = (l6.c) obj;
                kotlin.jvm.internal.k.e(it, "it");
                b7.c cVarR0 = r2.q.r0(it);
                if (cVarR0 != null) {
                    return cVarR0;
                }
                if (c1.g(it)) {
                    return new b7.f(it);
                }
                return null;
            case 7:
                l6.c it2 = (l6.c) obj;
                kotlin.jvm.internal.k.e(it2, "it");
                b7.c cVarR02 = r2.q.r0(it2);
                if (cVarR02 == null) {
                    cVarR02 = c1.g(it2) ? new b7.f(it2) : null;
                }
                if (cVarR02 != null) {
                    return r2.q.Y(cVarR02);
                }
                return null;
            case 8:
                return FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore$lambda$0((CorruptionException) obj);
            case 9:
                d7.a buildSerialDescriptor2 = (d7.a) obj;
                kotlin.jvm.internal.k.e(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                d7.a.a(buildSerialDescriptor2, "JsonPrimitive", new d7.o(new m(8)));
                d7.a.a(buildSerialDescriptor2, "JsonNull", new d7.o(new m(9)));
                d7.a.a(buildSerialDescriptor2, "JsonLiteral", new d7.o(new m(10)));
                d7.a.a(buildSerialDescriptor2, "JsonObject", new d7.o(new m(11)));
                d7.a.a(buildSerialDescriptor2, "JsonArray", new d7.o(new m(12)));
                return x.f13520a;
            case 10:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.k.e(entry, "<destruct>");
                String str = (String) entry.getKey();
                g7.m mVar = (g7.m) entry.getValue();
                StringBuilder sb = new StringBuilder();
                c0.a(sb, str);
                sb.append(':');
                sb.append(mVar);
                String string = sb.toString();
                kotlin.jvm.internal.k.d(string, "toString(...)");
                return string;
            case 11:
                v5.f fVar = (v5.f) obj;
                if (fVar instanceof w) {
                    return (w) fVar;
                }
                return null;
            default:
                return 1000L;
        }
    }
}
