package com.google.firebase.crashlytics.internal.metadata;

import com.ironsource.C2300e4;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        public Element(int i2, int i8) {
            this.position = i2;
            this.length = i8;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.position);
            sb.append(", length = ");
            return a1.a.q(sb, C2300e4.i.e, this.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i8) throws IOException {
            QueueFile.nonNull(bArr, "buffer");
            if ((i2 | i8) < 0 || i8 > bArr.length - i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i9 = this.remaining;
            if (i9 <= 0) {
                return -1;
            }
            if (i8 > i9) {
                i8 = i9;
            }
            QueueFile.this.ringRead(this.position, bArr, i2, i8);
            this.position = QueueFile.this.wrapPosition(this.position + i8);
            this.remaining -= i8;
            return i8;
        }

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int i2 = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ElementReader {
        void read(InputStream inputStream, int i2) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        this.buffer = new byte[16];
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i2) throws IOException {
        int i8 = i2 + 4;
        int iRemainingBytes = remainingBytes();
        if (iRemainingBytes >= i8) {
            return;
        }
        int i9 = this.fileLength;
        do {
            iRemainingBytes += i9;
            i9 <<= 1;
        } while (iRemainingBytes < i8);
        setLength(i9);
        Element element = this.last;
        int iWrapPosition = wrapPosition(element.position + 4 + element.length);
        if (iWrapPosition < this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            long j = iWrapPosition - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i10 = this.last.position;
        int i11 = this.first.position;
        if (i10 < i11) {
            int i12 = (this.fileLength + i10) - 16;
            writeHeader(i9, this.elementCount, i11, i12);
            this.last = new Element(i12, this.last.length);
        } else {
            writeHeader(i9, this.elementCount, i11, i10);
        }
        this.fileLength = i9;
    }

    private static void initialize(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileOpen = open(file2);
        try {
            randomAccessFileOpen.setLength(4096L);
            randomAccessFileOpen.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, 4096, 0, 0, 0);
            randomAccessFileOpen.write(bArr);
            randomAccessFileOpen.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileOpen.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i2) throws IOException {
        if (i2 == 0) {
            return Element.NULL;
        }
        this.raf.seek(i2);
        return new Element(i2, this.raf.readInt());
    }

    private void readHeader() throws IOException {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        int i2 = readInt(this.buffer, 0);
        this.fileLength = i2;
        if (i2 > this.raf.length()) {
            throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
        }
        this.elementCount = readInt(this.buffer, 4);
        int i8 = readInt(this.buffer, 8);
        int i9 = readInt(this.buffer, 12);
        this.first = readElement(i8);
        this.last = readElement(i9);
    }

    private static int readInt(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i2, byte[] bArr, int i8, int i9) throws IOException {
        int iWrapPosition = wrapPosition(i2);
        int i10 = iWrapPosition + i9;
        int i11 = this.fileLength;
        if (i10 <= i11) {
            this.raf.seek(iWrapPosition);
            this.raf.readFully(bArr, i8, i9);
            return;
        }
        int i12 = i11 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.readFully(bArr, i8, i12);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i8 + i12, i9 - i12);
    }

    private void ringWrite(int i2, byte[] bArr, int i8, int i9) throws IOException {
        int iWrapPosition = wrapPosition(i2);
        int i10 = iWrapPosition + i9;
        int i11 = this.fileLength;
        if (i10 <= i11) {
            this.raf.seek(iWrapPosition);
            this.raf.write(bArr, i8, i9);
            return;
        }
        int i12 = i11 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.write(bArr, i8, i12);
        this.raf.seek(16L);
        this.raf.write(bArr, i8 + i12, i9 - i12);
    }

    private void setLength(int i2) throws IOException {
        this.raf.setLength(i2);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i2) {
        int i8 = this.fileLength;
        return i2 < i8 ? i2 : (i2 + 16) - i8;
    }

    private void writeHeader(int i2, int i8, int i9, int i10) throws IOException {
        writeInts(this.buffer, i2, i8, i9, i10);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i2, int i8) {
        bArr[i2] = (byte) (i8 >> 24);
        bArr[i2 + 1] = (byte) (i8 >> 16);
        bArr[i2 + 2] = (byte) (i8 >> 8);
        bArr[i2 + 3] = (byte) i8;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int i8 : iArr) {
            writeInt(bArr, i2, i8);
            i2 += 4;
        }
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public synchronized void clear() throws IOException {
        try {
            writeHeader(4096, 0, 0, 0);
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > 4096) {
                setLength(4096);
            }
            this.fileLength = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) throws IOException {
        int iWrapPosition = this.first.position;
        for (int i2 = 0; i2 < this.elementCount; i2++) {
            Element element = readElement(iWrapPosition);
            elementReader.read(new ElementInputStream(element), element.length);
            iWrapPosition = wrapPosition(element.position + 4 + element.length);
        }
    }

    public boolean hasSpaceFor(int i2, int i8) {
        return (usedBytes() + 4) + i2 <= i8;
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized byte[] peek() throws IOException {
        if (isEmpty()) {
            return null;
        }
        Element element = this.first;
        int i2 = element.length;
        byte[] bArr = new byte[i2];
        ringRead(element.position + 4, bArr, 0, i2);
        return bArr;
    }

    public synchronized void remove() throws IOException {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.elementCount == 1) {
                clear();
            } else {
                Element element = this.first;
                int iWrapPosition = wrapPosition(element.position + 4 + element.length);
                ringRead(iWrapPosition, this.buffer, 0, 4);
                int i2 = readInt(this.buffer, 0);
                writeHeader(this.fileLength, this.elementCount - 1, iWrapPosition, this.last.position);
                this.elementCount--;
                this.first = new Element(iWrapPosition, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1
                boolean first = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i2) throws IOException {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i2);
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i2 = element.position;
        int i8 = this.first.position;
        return i2 >= i8 ? (i2 - i8) + 4 + element.length + 16 : (((i2 + 4) + element.length) + this.fileLength) - i8;
    }

    public synchronized void add(byte[] bArr, int i2, int i8) throws IOException {
        int iWrapPosition;
        try {
            nonNull(bArr, "buffer");
            if ((i2 | i8) < 0 || i8 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            expandIfNecessary(i8);
            boolean zIsEmpty = isEmpty();
            if (zIsEmpty) {
                iWrapPosition = 16;
            } else {
                Element element = this.last;
                iWrapPosition = wrapPosition(element.position + 4 + element.length);
            }
            Element element2 = new Element(iWrapPosition, i8);
            writeInt(this.buffer, 0, i8);
            ringWrite(element2.position, this.buffer, 0, 4);
            ringWrite(element2.position + 4, bArr, i2, i8);
            writeHeader(this.fileLength, this.elementCount + 1, zIsEmpty ? element2.position : this.first.position, element2.position);
            this.last = element2;
            this.elementCount++;
            if (zIsEmpty) {
                this.first = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    public synchronized void peek(ElementReader elementReader) throws IOException {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.length);
        }
    }
}
