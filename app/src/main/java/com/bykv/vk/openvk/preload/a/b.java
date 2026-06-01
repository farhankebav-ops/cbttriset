package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4697a = new b("IDENTITY") { // from class: com.bykv.vk.openvk.preload.a.b.1
        {
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return field.getName();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f4698b = new b("UPPER_CAMEL_CASE") { // from class: com.bykv.vk.openvk.preload.a.b.2
        {
            int i2 = 1;
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f4699c = new b("UPPER_CAMEL_CASE_WITH_SPACES") { // from class: com.bykv.vk.openvk.preload.a.b.3
        {
            int i2 = 2;
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(b.a(field.getName(), " "));
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f4700d = new b("LOWER_CASE_WITH_UNDERSCORES") { // from class: com.bykv.vk.openvk.preload.a.b.4
        {
            int i2 = 3;
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };
    private static b e = new b("LOWER_CASE_WITH_DASHES") { // from class: com.bykv.vk.openvk.preload.a.b.5
        {
            int i2 = 4;
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static b f4701f = new b("LOWER_CASE_WITH_DOTS") { // from class: com.bykv.vk.openvk.preload.a.b.6
        {
            int i2 = 5;
            byte b8 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    private b(String str, int i2) {
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public /* synthetic */ b(String str, int i2, byte b8) {
        this(str, i2);
    }

    public static String a(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        while (!Character.isLetter(str.charAt(i2)) && i2 < length) {
            i2++;
        }
        char cCharAt = str.charAt(i2);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i2 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
    }
}
