package scripting;

import java.io.IOException;
import java.io.Writer;

class FlushingWriter extends Writer {
    
    private final Writer writer;
    
    public FlushingWriter(Writer writer) {
        this.writer = writer;
    }
    
    public Writer append(char c) throws IOException {
        try {
            return writer.append(c);
        } finally {
            writer.flush();
        }
    }
    
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        try {
            return writer.append(csq, start, end);
        } finally {
            writer.flush();
        }
    }
    
    public Writer append(CharSequence csq) throws IOException {
        try {
            return writer.append(csq);
        } finally {
            writer.flush();
        }
    }
    
    public void close() throws IOException {
        writer.close();
    }
    
    public void flush() throws IOException {
        writer.flush();
    }
    
    public void write(char[] cbuf, int off, int len) throws IOException {
        try {
            writer.write(cbuf, off, len);
        } finally {
            writer.flush();
        }
    }
    
    public void write(char[] cbuf) throws IOException {
        try {
            writer.write(cbuf);
        } finally {
            writer.flush();
        }
    }
    
    public void write(int c) throws IOException {
        try {
            writer.write(c);
        } finally {
            writer.flush();
        }
    }
    
    public void write(String str, int off, int len) throws IOException {
        try {
            writer.write(str, off, len);
        } finally {
            writer.flush();
        }
    }
    
    public void write(String str) throws IOException {
        try {
            writer.write(str);
        } finally {
            writer.flush();
        }
    }
}