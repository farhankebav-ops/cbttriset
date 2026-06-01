package com.google.protobuf;

import com.unity3d.services.core.fid.Constants;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 implements d2 {
    private static final j1 EMPTY_FACTORY = new a();
    private final j1 messageInfoFactory;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements j1 {
        @Override // com.google.protobuf.j1
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // com.google.protobuf.j1
        public i1 messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b implements j1 {
        private j1[] factories;

        public b(j1... j1VarArr) {
            this.factories = j1VarArr;
        }

        @Override // com.google.protobuf.j1
        public boolean isSupported(Class<?> cls) {
            for (j1 j1Var : this.factories) {
                if (j1Var.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.j1
        public i1 messageInfoFor(Class<?> cls) {
            for (j1 j1Var : this.factories) {
                if (j1Var.isSupported(cls)) {
                    return j1Var.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }
    }

    public c1() {
        this(getDefaultMessageInfoFactory());
    }

    private static boolean allowExtensions(i1 i1Var) {
        return d1.$SwitchMap$com$google$protobuf$ProtoSyntax[i1Var.getSyntax().ordinal()] != 1;
    }

    private static j1 getDefaultMessageInfoFactory() {
        return new b(l0.getInstance(), getDescriptorMessageInfoFactory());
    }

    private static j1 getDescriptorMessageInfoFactory() {
        try {
            return (j1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(Constants.GET_INSTANCE, null).invoke(null, null);
        } catch (Exception unused) {
            return EMPTY_FACTORY;
        }
    }

    private static <T> c2 newSchema(Class<T> cls, i1 i1Var) {
        return GeneratedMessageLite.class.isAssignableFrom(cls) ? allowExtensions(i1Var) ? m1.newSchema(cls, i1Var, s1.lite(), z0.lite(), e2.unknownFieldSetLiteSchema(), d0.lite(), h1.lite()) : m1.newSchema(cls, i1Var, s1.lite(), z0.lite(), e2.unknownFieldSetLiteSchema(), null, h1.lite()) : allowExtensions(i1Var) ? m1.newSchema(cls, i1Var, s1.full(), z0.full(), e2.unknownFieldSetFullSchema(), d0.full(), h1.full()) : m1.newSchema(cls, i1Var, s1.full(), z0.full(), e2.unknownFieldSetFullSchema(), null, h1.full());
    }

    @Override // com.google.protobuf.d2
    public <T> c2 createSchema(Class<T> cls) {
        e2.requireGeneratedMessage(cls);
        i1 i1VarMessageInfoFor = this.messageInfoFactory.messageInfoFor(cls);
        return i1VarMessageInfoFor.isMessageSetWireFormat() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? n1.newSchema(e2.unknownFieldSetLiteSchema(), d0.lite(), i1VarMessageInfoFor.getDefaultInstance()) : n1.newSchema(e2.unknownFieldSetFullSchema(), d0.full(), i1VarMessageInfoFor.getDefaultInstance()) : newSchema(cls, i1VarMessageInfoFor);
    }

    private c1(j1 j1Var) {
        this.messageInfoFactory = (j1) Internal.checkNotNull(j1Var, "messageInfoFactory");
    }
}
