package c6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k extends a.a {
    public static void b0(File file, File target) throws IOException {
        kotlin.jvm.internal.k.e(file, "<this>");
        kotlin.jvm.internal.k.e(target, "target");
        if (!file.exists()) {
            throw new a(file, null, "The source file doesn't exist.");
        }
        if (target.exists() && !target.delete()) {
            throw new a(file, target, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!target.mkdirs()) {
                throw new b(file, target, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                n7.b.l(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static String c0(File file) throws IOException {
        Charset charset = n6.a.f13073a;
        kotlin.jvm.internal.k.e(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strL = n7.b.L(inputStreamReader);
            inputStreamReader.close();
            return strL;
        } finally {
        }
    }

    public static File d0(File file, String str) {
        int length;
        int iX0;
        File file2 = new File(str);
        String path = file2.getPath();
        kotlin.jvm.internal.k.d(path, "getPath(...)");
        char c7 = File.separatorChar;
        int iX02 = n6.m.x0(path, c7, 0, 4);
        if (iX02 != 0) {
            length = (iX02 <= 0 || path.charAt(iX02 + (-1)) != ':') ? (iX02 == -1 && n6.m.t0(path, ':')) ? path.length() : 0 : iX02 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c7 || (iX0 = n6.m.x0(path, c7, 2, 4)) < 0) {
            length = 1;
        } else {
            int iX03 = n6.m.x0(path, c7, iX0 + 1, 4);
            length = iX03 >= 0 ? iX03 + 1 : path.length();
        }
        if (length > 0) {
            return file2;
        }
        String string = file.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        if ((string.length() == 0) || n6.m.t0(string, c7)) {
            return new File(string + file2);
        }
        return new File(string + c7 + file2);
    }

    public static void e0(File file, String text, Charset charset) throws IOException {
        kotlin.jvm.internal.k.e(file, "<this>");
        kotlin.jvm.internal.k.e(text, "text");
        kotlin.jvm.internal.k.e(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            f0(fileOutputStream, text, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void f0(FileOutputStream fileOutputStream, String text, Charset charset) throws IOException {
        kotlin.jvm.internal.k.e(text, "text");
        kotlin.jvm.internal.k.e(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            kotlin.jvm.internal.k.d(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        kotlin.jvm.internal.k.b(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        kotlin.jvm.internal.k.d(byteBufferAllocate, "allocate(...)");
        int i2 = 0;
        int i8 = 0;
        while (i2 < text.length()) {
            int iMin = Math.min(8192 - i8, text.length() - i2);
            int i9 = i2 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            kotlin.jvm.internal.k.d(cArrArray, "array(...)");
            text.getChars(i2, i9, cArrArray, i8);
            charBufferAllocate.limit(iMin + i8);
            i8 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i9 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i8 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i2 = i9;
        }
    }
}
