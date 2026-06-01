package h7;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11766a = new p();

    public static final n a(String str, Number number) {
        return new n("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) l(str, -1)));
    }

    public static final n b(d7.g keyDescriptor) {
        kotlin.jvm.internal.k.e(keyDescriptor, "keyDescriptor");
        return new n("Value of type '" + keyDescriptor.h() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final k c(int i2, String message) {
        kotlin.jvm.internal.k.e(message, "message");
        if (i2 >= 0) {
            message = "Unexpected JSON token at offset " + i2 + ": " + message;
        }
        kotlin.jvm.internal.k.e(message, "message");
        return new k(message);
    }

    public static final k d(String message, CharSequence input, int i2) {
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(input, "input");
        return c(i2, message + "\nJSON input: " + ((Object) l(input, i2)));
    }

    public static final d7.g e(d7.g gVar, i7.f module) {
        d7.g gVarE;
        b7.c cVarB;
        kotlin.jvm.internal.k.e(gVar, "<this>");
        kotlin.jvm.internal.k.e(module, "module");
        if (!kotlin.jvm.internal.k.a(gVar.getKind(), d7.k.f11199b)) {
            return gVar.isInline() ? e(gVar.g(0), module) : gVar;
        }
        l6.c cVarS = n7.b.s(gVar);
        d7.g descriptor = null;
        if (cVarS != null && (cVarB = module.b(cVarS, r5.r.f13638a)) != null) {
            descriptor = cVarB.getDescriptor();
        }
        return (descriptor == null || (gVarE = e(descriptor, module)) == null) ? gVar : gVarE;
    }

    public static final byte f(char c7) {
        if (c7 < '~') {
            return f.f11757b[c7];
        }
        return (byte) 0;
    }

    public static final void g(a.a kind) {
        kotlin.jvm.internal.k.e(kind, "kind");
        if (kind instanceof d7.l) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof d7.f) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof d7.d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String h(d7.g gVar, g7.c json) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        kotlin.jvm.internal.k.e(json, "json");
        for (Annotation annotation : gVar.getAnnotations()) {
            if (annotation instanceof g7.i) {
                return ((g7.i) annotation).discriminator();
            }
        }
        return json.f11598a.f11617f;
    }

    public static final int i(d7.g gVar, g7.c json, String name) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.e(name, "name");
        m(gVar, json);
        int iC = gVar.c(name);
        if (iC != -3 || !json.f11598a.g) {
            return iC;
        }
        a4.a aVar = json.f11600c;
        f7.z zVar = new f7.z(1, gVar, json);
        aVar.getClass();
        p pVar = f11766a;
        Object objI = aVar.i(gVar, pVar);
        if (objI == null) {
            objI = zVar.invoke();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) aVar.f3216b;
            Object concurrentHashMap2 = concurrentHashMap.get(gVar);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(gVar, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(pVar, objI);
        }
        Integer num = (Integer) ((Map) objI).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int j(d7.g gVar, g7.c json, String name, String suffix) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.e(name, "name");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        int i2 = i(gVar, json, name);
        if (i2 != -3) {
            return i2;
        }
        throw new b7.i(gVar.h() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static final void k(b0 b0Var, String str) {
        b0Var.l(b0Var.f11741a - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence l(CharSequence charSequence, int i2) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i2 != -1) {
                int i8 = i2 - 30;
                int i9 = i2 + 30;
                String str = i8 <= 0 ? "" : ".....";
                String str2 = i9 >= charSequence.length() ? "" : ".....";
                StringBuilder sbR = androidx.camera.core.processing.util.a.r(str);
                if (i8 < 0) {
                    i8 = 0;
                }
                int length = charSequence.length();
                if (i9 > length) {
                    i9 = length;
                }
                sbR.append(charSequence.subSequence(i8, i9).toString());
                sbR.append(str2);
                return sbR.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void m(d7.g gVar, g7.c json) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.a(gVar.getKind(), d7.m.f11201b);
    }

    public static final Object n(g7.c cVar, String discriminator, g7.x xVar, b7.b bVar) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        kotlin.jvm.internal.k.e(discriminator, "discriminator");
        return new s(cVar, xVar, discriminator, bVar.getDescriptor()).decodeSerializableValue(bVar);
    }

    public static final d0 o(d7.g desc, g7.c cVar) {
        kotlin.jvm.internal.k.e(desc, "desc");
        a.a kind = desc.getKind();
        if (kind instanceof d7.d) {
            return d0.f11751f;
        }
        if (kotlin.jvm.internal.k.a(kind, d7.m.f11202c)) {
            return d0.f11750d;
        }
        if (!kotlin.jvm.internal.k.a(kind, d7.m.f11203d)) {
            return d0.f11749c;
        }
        d7.g gVarE = e(desc.g(0), cVar.f11599b);
        a.a kind2 = gVarE.getKind();
        if ((kind2 instanceof d7.f) || kotlin.jvm.internal.k.a(kind2, d7.l.f11200b)) {
            return d0.e;
        }
        if (cVar.f11598a.f11615c) {
            return d0.f11750d;
        }
        throw b(gVarE);
    }

    public static final void p(b0 b0Var, Number number) {
        b0.m(b0Var, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final void q(g7.m element, String str) {
        kotlin.jvm.internal.k.e(element, "element");
        StringBuilder sbY = a1.a.y("Class with serial name ", str, " cannot be serialized polymorphically because it is represented as ");
        sbY.append(kotlin.jvm.internal.b0.a(element.getClass()).f());
        sbY.append(". Make sure that its JsonTransformingSerializer returns JsonObject, so class discriminator can be added to it.");
        throw new n(sbY.toString());
    }

    public static final String r(byte b8) {
        return b8 == 1 ? "quotation mark '\"'" : b8 == 2 ? "string escape sequence '\\'" : b8 == 4 ? "comma ','" : b8 == 5 ? "colon ':'" : b8 == 6 ? "start of the object '{'" : b8 == 7 ? "end of the object '}'" : b8 == 8 ? "start of the array '['" : b8 == 9 ? "end of the array ']'" : b8 == 10 ? "end of the input" : b8 == 127 ? "invalid token" : "valid token";
    }

    public static final String s(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) l(str2, -1));
    }
}
